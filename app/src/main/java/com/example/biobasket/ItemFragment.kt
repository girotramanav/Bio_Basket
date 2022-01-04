package com.example.biobasket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.setFragmentResultListener
import com.example.biobasket.databinding.FragmentItemBinding

class ItemFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        (activity as? MainActivity)?.onHome = false
        (activity as? MainActivity)?.onCart = false
        (activity as? MainActivity)?.onItem = true
        (activity as? MainActivity)?.onList = false
        (activity as? MainActivity)?.onFaq = false
        (activity as? MainActivity)?.onProfile = false
        (activity as? MainActivity)?.onContact = false


        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentItemBinding>(inflater,R.layout.fragment_item,container,false)

        setFragmentResultListener("itemRequestKey") { requestKey: String, bundle: Bundle ->
            binding.itemImage.setImageResource(
                bundle.getInt("image")
            )
        }

        setFragmentResultListener("itemRequestKey1") { requestKey, bundle ->
        binding.itemPrice.text = "Rs. ${bundle.getInt("price").toString()}"

        }

        return binding.root

    }
}