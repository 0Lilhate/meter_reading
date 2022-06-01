package com.example.my_movie_app


import android.accounts.Account
import android.os.Bundle

import android.view.View
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.my_movie_app.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import com.mikepenz.materialdrawer.widget.AccountHeaderView


class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mHeader: AccountHeaderView

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarToggle: ActionBarDrawerToggle
    private lateinit var navView: NavigationView
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)



        // Call findViewById on the DrawerLayout
        drawerLayout = findViewById(R.id.drawer_layout)
        //toolbar = findViewById(R.id.toolbar)

        // Pass the ActionBarToggle action into the drawerListener
        actionBarToggle = ActionBarDrawerToggle(this, drawerLayout, 0, 0)
        drawerLayout.addDrawerListener(actionBarToggle)
        navView = findViewById(R.id.nav_view)
        // Display the hamburger icon to launch the drawer
        setActionBar(toolbar)
        toolbar.title = "Показания счетчиков"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Показания счетчиков"


        // Call syncState() on the action bar so it'll automatically change to the back button when the drawer layout is open
        actionBarToggle.syncState()

        MyNavigation()
        // Call findViewById on the NavigationView


        // Call setNavigationItemSelectedListener on the NavigationView to detect when items are clicked

        toolbar.setNavigationOnClickListener(View.OnClickListener {
            Toast.makeText(this, "!!", Toast.LENGTH_SHORT).show()
        })
    }

    override fun onStart() {
        super.onStart()
    }

    fun MyNavigation(){
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    supportActionBar?.title = "Показания счетчиков"
                    Toast.makeText(this, "My Profile", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_gallery -> {
                    supportActionBar?.title = "Добавление показаний"
                    Toast.makeText(this, "People", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

}