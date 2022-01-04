package com.example.biobasket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.biobasket.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.activity_main.*

class HomeFragment : Fragment(), CategoryClicked, ItemClicked {

    private var popularItem = ArrayList<ListItem>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        (activity as? MainActivity)?.onHome = true
        (activity as? MainActivity)?.onCart = false
        (activity as? MainActivity)?.onItem = false
        (activity as? MainActivity)?.onList = false
        (activity as? MainActivity)?.onFaq = false
        (activity as? MainActivity)?.onProfile = false
        (activity as? MainActivity)?.onContact = false

        // Inflate the layout for this fragment
        val sliderItem = ArrayList<SliderItem>()
        sliderItem.add(SliderItem(R.drawable.exibit1))
        sliderItem.add(SliderItem(R.drawable.exhibit2))
        sliderItem.add(SliderItem(R.drawable.exhibit3))
        sliderItem.add(SliderItem(R.drawable.exhibit4))

        popularItem.add(ListItem(R.drawable.pencil_combo,199,"Stationary Combo"))
        popularItem.add(ListItem(R.drawable.seed_pencil,25,"Seed Pencil"))
        popularItem.add(ListItem(R.drawable.seed_pen,60,"Seed Pen"))
        popularItem.add(ListItem(R.drawable.wood_cup,99,"Wooden Cup"))
        popularItem.add(ListItem(R.drawable.stationary_kit,349,"Notebook Combo"))

        val categories = ArrayList<CategoryItem>()
        categories.add(CategoryItem(R.drawable.ic_plants))
        categories.add(CategoryItem(R.drawable.ic_stationary))
        categories.add(CategoryItem(R.drawable.ic_decoration))
        categories.add(CategoryItem(R.drawable.ic_gift))


        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater,R.layout.fragment_home,container,false)
        binding.viewpagerSlider.apply {
            adapter = SliderAdapter(activity?.applicationContext!!,sliderItem)
            clipToPadding = false
            offscreenPageLimit = 3
            getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }

        binding.sideNav.setOnClickListener {
            activity?.drawerLayout?.open()
        }

        val itemAdapter = ItemListRecycleAdapter(popularItem,this)

        binding.popularRecycleView.apply {
            adapter = itemAdapter
        }

        val categoryAdapter = CategoryRecycleAdapter(categories,this)

        binding.roundedImageView.setOnClickListener{
            activity?.host_fragment?.findNavController()?.navigate(R.id.action_homeFragment_to_profileFragment)
        }

        binding.categoryView.apply {
             adapter = categoryAdapter
        }

        return binding.root
    }

    override fun onCategoryClicked(item: Int) {
        setFragmentResult("categoryRequestKey", bundleOf("categoryType" to item))
        activity?.host_fragment?.findNavController()?.navigate(R.id.action_homeFragment_to_listFragment)
    }

    override fun onItemClicked(item: Int) {
        setFragmentResult("itemRequestKey", bundleOf("image" to popularItem[item].getImage()))
        setFragmentResult("itemRequestKey1", bundleOf("price" to popularItem[item].getPrice()))
        setFragmentResult("itemRequestKey2", bundleOf("name" to popularItem[item].getName()))
        activity?.host_fragment?.findNavController()?.navigate(R.id.action_homeFragment_to_itemFragment)
    }
}
