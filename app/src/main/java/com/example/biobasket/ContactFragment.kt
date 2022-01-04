package com.example.biobasket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.biobasket.databinding.FragmentContactBinding
import kotlinx.android.synthetic.main.activity_main.*


class ContactFragment : Fragment(){

    override fun onCreateView (
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        (activity as? MainActivity)?.onHome = false
        (activity as? MainActivity)?.onCart = false
        (activity as? MainActivity)?.onItem = false
        (activity as? MainActivity)?.onList = false
        (activity as? MainActivity)?.onFaq = false
        (activity as? MainActivity)?.onProfile = false
        (activity as? MainActivity)?.onContact = true

        val binding = DataBindingUtil.inflate<FragmentContactBinding>(
            inflater,
            R.layout.fragment_contact,
            container,
            false
        )

        binding.sideNav.setOnClickListener {
            (activity as MainActivity).drawerLayout.open()
        }

        return binding.root
    }

}



