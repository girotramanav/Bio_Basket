package com.example.biobasket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.biobasket.databinding.FragmentCartBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_cart.*

class CartFragment : Fragment(), ItemClicked {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        (activity as? MainActivity)?.onHome = false
        (activity as? MainActivity)?.onCart = true
        (activity as? MainActivity)?.onItem = false
        (activity as? MainActivity)?.onList = false

        val category0 = ArrayList<ListItem>()
        category0.add(ListItem(R.drawable.pencil_combo,199,"Stationary Combo"))
        category0.add(ListItem(R.drawable.zz_plant,249,"ZZ Plant"))
        category0.add(ListItem(R.drawable.cos_gift,599,"Cosmetic Gifts"))

        val binding = DataBindingUtil.inflate<FragmentCartBinding>(inflater,R.layout.fragment_cart,container,false)

        binding.cartRecyclerView.adapter = ItemListRecycleAdapter(category0,this)

        var totalPrice = 0

        for(item in category0)
        {
            totalPrice += item.getPrice()
        }

        binding.cartText5.text = "Rs. $totalPrice"
        binding.cartText7.text = "Rs. $totalPrice"

        binding.checkOutButton.setOnClickListener {
            Toast.makeText(context, "Order Processed. Happy Shopping", Toast.LENGTH_SHORT).show()
            activity?.host_fragment?.findNavController()!!.navigate(R.id.action_cartFragment_to_homeFragment)
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onItemClicked(item: Int) {
    }
}
