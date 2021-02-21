package com.example.biobasket

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    private var isLogin = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        signup.setOnClickListener{
            if(isLogin)
            {
                heading.text = "SIGN UP"
                signup.text = "LOGIN"
                qText.text = "Already have an Account "
                isLogin = false
                name.visibility = View.VISIBLE
                gapView.visibility = View.GONE
            }
            else
            {
                heading.text = "LOGIN"
                signup.text = "SIGN UP"
                qText.text = "Don't have an Account"
                isLogin = true
                name.visibility = View.GONE
                gapView.visibility = View.VISIBLE
            }
        }

        auth = Firebase.auth
        signin.setOnClickListener {
            if(isLogin)
            {
                signIn(email.text.toString(),password.text.toString())
            }
            else{
                createAccount(name.text.toString(),email.text.toString(),password.text.toString())
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if(currentUser != null)
        {
            homePage()
        }
    }

    private fun homePage() {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

    private fun createAccount(name : String , email : String , password : String)
    {
        if(!validateForm())
        {
            Toast.makeText(this, "All fields are Required!!", Toast.LENGTH_SHORT).show()
            return
        }

        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if(it.isSuccessful)
                {
                    val user = hashMapOf("name" to name, "email" to email)
                    val db = FirebaseFirestore.getInstance()
                    db.collection("users").document(auth.currentUser!!.uid).set(user)
                    homePage()
                }
                else
                {
                    Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun signIn(email : String , password : String)
    {
        if(!validateForm())
        {
            Toast.makeText(this, "Valid Email id and password is required!!", Toast.LENGTH_SHORT).show()
            return
        }

        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if(it.isSuccessful)
                { homePage() }
                else
                { Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show() }
            }
    }

    private fun validateForm(): Boolean {
        if(isLogin)
        {
            if (email.text.isEmpty() || password.text.isEmpty())
                return false
            return true
        }
        else {
            if (email.text.isEmpty() || password.text.isEmpty() || name.text.isEmpty())
                return false
            return true
        }
    }
}
