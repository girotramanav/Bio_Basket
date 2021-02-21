package com.example.biobasket

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavHost
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var onHome = true
    var onCart = false
    var onList = false
    var onItem = false
    var onFaq = false
    var onContact = false
    var onProfile = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppBarConfiguration(findNavController(R.id.host_fragment).graph)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.host_fragment) as NavHost
        val navController = navHostFragment.navController
        findViewById<NavigationView>(R.id.nav_view)
            .setupWithNavController(navController)

        val currentUser = intent.getStringExtra("currentUser")
        Log.i("UserCurrent",currentUser.toString())

        bottomNav.setOnNavigationItemSelectedListener { item->
            when(item.itemId)
            {
                R.id.home-> {
                    when{
                        onCart->{
                            host_fragment.findNavController().navigate(R.id.action_cartFragment_to_homeFragment)
                        }
                        onList->{
                            host_fragment.findNavController().navigate(R.id.action_listFragment_to_homeFragment)
                        }
                        onItem->{
                            host_fragment.findNavController().navigate(R.id.action_itemFragment_to_homeFragment)
                        }
                        onContact->{
                            host_fragment.findNavController().navigate(R.id.action_contactFragment_to_homeFragment)
                        }
                        onProfile->{
                            host_fragment.findNavController().navigate(R.id.action_profileFragment_to_homeFragment)
                        }
                        onFaq->{
                            host_fragment.findNavController().navigate(R.id.action_faqFragment_to_homeFragment)
                        }
                    }
                    true}
                R.id.cart->{
                    when{
                        onHome->{
                            host_fragment.findNavController().navigate(R.id.action_homeFragment_to_cartFragment)
                        }
                        onItem->{
                            host_fragment.findNavController().navigate(R.id.action_itemFragment_to_cartFragment)
                        }
                        onList->{
                            host_fragment.findNavController().navigate(R.id.action_listFragment_to_cartFragment)
                        }
                        onContact->{
                            host_fragment.findNavController().navigate(R.id.action_contactFragment_to_cartFragment)
                        }
                        onProfile->{
                            host_fragment.findNavController().navigate(R.id.action_profileFragment_to_cartFragment)
                        }
                        onFaq->{
                            host_fragment.findNavController().navigate(R.id.action_faqFragment_to_cartFragment)
                        }
                    }
                    true }
                else->false
            }
        }

        nav_view.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home ->
                            { when{
                                onCart->{
                                    host_fragment.findNavController().navigate(R.id.action_cartFragment_to_homeFragment)
                                }
                                onList->{
                                    host_fragment.findNavController().navigate(R.id.action_listFragment_to_homeFragment)
                                }
                                onItem->{
                                    host_fragment.findNavController().navigate(R.id.action_itemFragment_to_homeFragment)
                                }
                                onContact->{
                                    host_fragment.findNavController().navigate(R.id.action_contactFragment_to_homeFragment)
                                }
                                onProfile->{
                                    host_fragment.findNavController().navigate(R.id.action_profileFragment_to_homeFragment)
                                }
                                onFaq->{
                                    host_fragment.findNavController().navigate(R.id.action_faqFragment_to_homeFragment)
                                }
                            }
                                drawerLayout.close()
                                true}
                R.id.nav_cart ->
                            {  when{
                                onHome->{
                                    host_fragment.findNavController().navigate(R.id.action_homeFragment_to_cartFragment)
                                }
                                onItem->{
                                    host_fragment.findNavController().navigate(R.id.action_itemFragment_to_cartFragment)
                                }
                                onList->{
                                    host_fragment.findNavController().navigate(R.id.action_listFragment_to_cartFragment)
                                 }
                                onContact->{
                                    host_fragment.findNavController().navigate(R.id.action_contactFragment_to_cartFragment)
                                }
                                onProfile->{
                                    host_fragment.findNavController().navigate(R.id.action_profileFragment_to_cartFragment)
                                }
                                onFaq->{
                                    host_fragment.findNavController().navigate(R.id.action_faqFragment_to_cartFragment)
                                }
                            }
                                drawerLayout.close()
                                true}
                R.id.nav_profile ->
                            {when {
                                onHome -> {
                                    host_fragment.findNavController()
                                        .navigate(R.id.action_homeFragment_to_profileFragment)
                                }
                                onItem -> {
                                    host_fragment.findNavController()
                                        .navigate(R.id.action_itemFragment_to_profileFragment)
                                }
                                onList -> {
                                    host_fragment.findNavController()
                                        .navigate(R.id.action_listFragment_to_profileFragment)
                                }
                                onCart -> {
                                    host_fragment.findNavController()
                                        .navigate(R.id.action_cartFragment_to_profileFragment)
                                }
                                onContact -> {
                                    host_fragment.findNavController()
                                        .navigate(R.id.action_contactFragment_to_profileFragment)
                                }
                                onFaq -> {
                                    host_fragment.findNavController()
                                        .navigate(R.id.action_faqFragment_to_profileFragment)
                                }
                            }
                                drawerLayout.close()
                                true}
                R.id.nav_faq ->
                            {
                                when {
                                    onHome -> {
                                        host_fragment.findNavController()
                                            .navigate(R.id.action_homeFragment_to_faqFragment)
                                    }
                                    onItem -> {
                                        host_fragment.findNavController()
                                            .navigate(R.id.action_itemFragment_to_faqFragment)
                                    }
                                    onList -> {
                                        host_fragment.findNavController()
                                            .navigate(R.id.action_listFragment_to_faqFragment)
                                    }
                                    onCart -> {
                                        host_fragment.findNavController()
                                            .navigate(R.id.action_cartFragment_to_faqFragment)
                                    }
                                    onContact -> {
                                        host_fragment.findNavController()
                                            .navigate(R.id.action_contactFragment_to_faqFragment)
                                    }
                                    onProfile -> {
                                        host_fragment.findNavController()
                                            .navigate(R.id.action_profileFragment_to_faqFragment)
                                    }
                                }
                                drawerLayout.close()
                                true}
                R.id.nav_contact_us ->
                            {when {
                                onHome -> {
                                    host_fragment.findNavController()
                                        .navigate(R.id.action_homeFragment_to_contactFragment)
                                }
                                onItem -> {
                                    host_fragment.findNavController()
                                        .navigate(R.id.action_itemFragment_to_contactFragment)
                                }
                                onList -> {
                                    host_fragment.findNavController()
                                        .navigate(R.id.action_listFragment_to_contactFragment)
                                }
                                onCart -> {
                                    host_fragment.findNavController()
                                        .navigate(R.id.action_cartFragment_to_contactFragment)
                                }
                                onProfile -> {
                                    host_fragment.findNavController()
                                        .navigate(R.id.action_profileFragment_to_contactFragment)
                                }
                                onFaq -> {
                                    host_fragment.findNavController()
                                        .navigate(R.id.action_faqFragment_to_contactFragment)
                                }
                            }
                                drawerLayout.close()
                                true}
                else -> {drawerLayout.close()
                                true}
            }
        }
    }
}
