package com.example.biobasket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.biobasket.databinding.FragmentListBinding
import kotlinx.android.synthetic.main.activity_main.*

class ListFragment : Fragment(), ItemClicked {

    private lateinit var finalResult : ArrayList<ListItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        (activity as? MainActivity)?.onHome = false
        (activity as? MainActivity)?.onCart = false
        (activity as? MainActivity)?.onItem = false
        (activity as? MainActivity)?.onList = true
        (activity as? MainActivity)?.onFaq = false
        (activity as? MainActivity)?.onProfile = false
        (activity as? MainActivity)?.onContact = false

        val category0 = ArrayList<ListItem>()
        category0.add(ListItem(R.drawable.fiddle_leaf,299,"Fiddle Leaf"))
        category0.add(ListItem(R.drawable.bambo,199,"Bamboo"))
        category0.add(ListItem(R.drawable.zz_plant,249,"ZZ Plant"))
        category0.add(ListItem(R.drawable.prayer_plant,349,"Prayer Plant"))
        category0.add(ListItem(R.drawable.diy_garden,199,"Diy Garden set"))

        val category1 = ArrayList<ListItem>()
        category1.add(ListItem(R.drawable.seed_pen,60,"Seed Pen"))
        category1.add(ListItem(R.drawable.seed_pencil,25,"Seed Pencil"))
        category1.add(ListItem(R.drawable.pencil_combo,199,"Stationary Combo"))
        category1.add(ListItem(R.drawable.stationary_kit,349,"Notebook Combo"))
        category1.add(ListItem(R.drawable.recyclepaper_diary,79,"Paper Diary"))

        val category2 = ArrayList<ListItem>()
        category2.add(ListItem(R.drawable.paper_straw,99,"Paper Straw"))
        category2.add(ListItem(R.drawable.eco_ballon,149,"Eco Balloon"))
        category2.add(ListItem(R.drawable.light_jar,199,"Light Glass"))

        val category3 = ArrayList<ListItem>()
        category3.add(ListItem(R.drawable.pencil_combo,199,"Stationary Combo"))
        category3.add(ListItem(R.drawable.stationary_kit,349,"Notebook Combo"))
        category3.add(ListItem(R.drawable.wood_cup,99,"Wooden Cup"))
        category3.add(ListItem(R.drawable.giy_bio,299,"Grow it Yourself"))
        category3.add(ListItem(R.drawable.cos_gift,599,"Cosmetic Gift"))

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentListBinding>(inflater,R.layout.fragment_list,container,false)

        setFragmentResultListener("categoryRequestKey") { requestKey: String, bundle: Bundle ->
            val selectedCategory = when(bundle.getInt("categoryType")) {
                0-> category0
                1-> category1
                2-> category2
                3-> category3
                else -> category0
            }

            val itemAdapter = ItemListRecycleAdapter(selectedCategory,this)
            binding.listRecyclerView.apply {
                adapter = itemAdapter
            }
            finalResult = selectedCategory
        }

        binding.roundedImageView.setOnClickListener{
            requireActivity().host_fragment.findNavController().navigate(R.id.action_listFragment_to_profileFragment)
        }

        binding.sideNav.setOnClickListener {
            activity?.drawerLayout?.open()
        }

        return binding.root
    }

    override fun onItemClicked(item: Int) {
        setFragmentResult("itemRequestKey", bundleOf("image" to finalResult[item].getImage()))
        setFragmentResult("itemRequestKey1", bundleOf("price" to finalResult[item].getPrice()))
        setFragmentResult("itemRequestKey2", bundleOf("name" to finalResult[item].getName()))


        activity?.host_fragment?.findNavController()?.navigate(R.id.action_listFragment_to_itemFragment)
    }
}