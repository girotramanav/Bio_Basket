package com.example.biobasket

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.biobasket.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    private lateinit var auth : FirebaseAuth
    private lateinit var db : FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        (activity as? MainActivity)?.onHome = false
        (activity as? MainActivity)?.onCart = false
        (activity as? MainActivity)?.onItem = false
        (activity as? MainActivity)?.onList = false
        (activity as? MainActivity)?.onFaq = false
        (activity as? MainActivity)?.onProfile = true
        (activity as? MainActivity)?.onContact = false

        auth = Firebase.auth
        db = FirebaseFirestore.getInstance()

        val binding = DataBindingUtil.inflate<FragmentProfileBinding>(inflater,R.layout.fragment_profile,container,false)

        db.collection("users")
            .document(auth.currentUser!!.uid)
            .get()
            .addOnSuccessListener {
                userName.text = it["name"].toString()
                userEmail.text = it["email"].toString()
            }
            .addOnFailureListener {
                Toast.makeText(context, "Error fetching USer Info. Try Again!", Toast.LENGTH_SHORT)
                    .show()
            }

        binding.signOutButton.setOnClickListener {
            auth.signOut()
            val intent = Intent(context,SignInActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }
}
