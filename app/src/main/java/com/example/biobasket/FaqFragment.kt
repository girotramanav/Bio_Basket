package com.example.biobasket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.biobasket.databinding.FragmentFaqBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_faq.*

class FaqFragment : Fragment() {

    private var question1clicked  = false
    private var question2clicked  = false
    private var question3clicked  = false
    private var question4clicked  = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        (activity as? MainActivity)?.onHome = false
        (activity as? MainActivity)?.onCart = false
        (activity as? MainActivity)?.onItem = false
        (activity as? MainActivity)?.onList = false
        (activity as? MainActivity)?.onFaq = true
        (activity as? MainActivity)?.onProfile = false
        (activity as? MainActivity)?.onContact = false

        val binding = DataBindingUtil.inflate<FragmentFaqBinding>(inflater,R.layout.fragment_faq,container,false)

        binding.sideNav.setOnClickListener {
            activity?.drawerLayout?.open()
        }

        binding.question1.setOnClickListener {
            allGone()
            if(question1clicked)
            {
                changeTextViewDrawableBack(it as TextView)
                question1clicked = false
                binding.answer1.visibility = View.GONE
            }
            else
            {
                changeTextViewDrawable(it as TextView)
                question1clicked = true
                binding.answer1.visibility = View.VISIBLE
            }
        }

        binding.question2.setOnClickListener {
            allGone()
            if(question2clicked)
            {
                changeTextViewDrawableBack(it as TextView)
                question2clicked = false
                binding.answer2.visibility = View.GONE
            }
            else
            {
                changeTextViewDrawable(it as TextView)
                question2clicked = true
                binding.answer2.visibility = View.VISIBLE
            }
        }

        binding.question3.setOnClickListener {
            allGone()
            if(question3clicked)
            {
                changeTextViewDrawableBack(it as TextView)
                question3clicked = false
                binding.answer3.visibility = View.GONE
            }
            else
            {
                changeTextViewDrawable(it as TextView)
                question3clicked = true
                binding.answer3.visibility = View.VISIBLE
            }
        }

        binding.question4.setOnClickListener {
            allGone()
            if(question4clicked)
            {
                changeTextViewDrawableBack(it as TextView)
                question4clicked = false
                binding.answer4.visibility = View.GONE
            }
            else
            {
                changeTextViewDrawable(it as TextView)
                question4clicked = true
                binding.answer4.visibility = View.VISIBLE
            }
        }

        return binding.root
    }

    private fun changeTextViewDrawable(textView : TextView)
    {
        textView.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_arrow_up,0)
    }

    private fun changeTextViewDrawableBack(textView: TextView)
    {
        textView.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_arrow_down,0)
    }

    private fun allGone()
    {
        answer1.visibility = View.GONE
        answer2.visibility = View.GONE
        answer3.visibility = View.GONE
        answer4.visibility = View.GONE
        question1.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_arrow_down,0)
        question2.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_arrow_down,0)
        question3.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_arrow_down,0)
        question4.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_arrow_down,0)
    }

}