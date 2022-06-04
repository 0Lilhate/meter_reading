package com.example.my_movie_app


import android.accounts.Account
import android.content.Context
import android.os.Bundle

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.my_movie_app.Fragment.AddReadingsFragment
import com.example.my_movie_app.Fragment.MainFragment
import com.example.my_movie_app.Fragment.NoteFragment
import com.example.my_movie_app.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.mikepenz.materialdrawer.widget.AccountHeaderView


class MainActivity : AppCompatActivity(){
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var ft: FragmentTransaction

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarToggle: ActionBarDrawerToggle
    private lateinit var navView: NavigationView
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        if(savedInstanceState==null){
            val bundle = bundleOf("some_int" to 0)
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<MainFragment>(R.id.nav_host_fragment_content_main, args = bundle)
            }
        }

    }

    override fun onStart() {
        super.onStart()
        initFields()
        createToolBar()
        initFunc()
    }

    private fun initFunc() {


        createHeader()
    }

    private fun createToolBar() {
        toolbar = findViewById(R.id.toolbar)
        toolbar?.setTitle("Показания счетчиков")
        setSupportActionBar(toolbar)
    }

    private fun createHeader() {
        var header: View = navView.getHeaderView(0)
        //тут происходит изменение header в navigationView
        var tx1:TextView = header.findViewById(R.id.email)
        tx1.setText("Daniil@gmail.com")

    }

    private fun initFields() {
        //toolbar = mBinding.toolbar
        drawerLayout = findViewById(R.id.drawer_layout)
        //

        // Pass the ActionBarToggle action into the drawerListener
        actionBarToggle = ActionBarDrawerToggle(this, drawerLayout, 0, 0)
        drawerLayout.addDrawerListener(actionBarToggle)
        navView = findViewById(R.id.nav_view)
        // Display the hamburger icon to launch the drawer

        MyNavigation()
        //init FloatingActionButton

}

    fun MyNavigation(){
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    toolbar?.setTitle("Показания счетчиков")
                    Toast.makeText(this, "My Profile", Toast.LENGTH_SHORT).show()
                    ft = supportFragmentManager.beginTransaction()
                    ft.replace(R.id.nav_host_fragment_content_main, MainFragment())
                    ft.addToBackStack(null)
                    ft.commit()
                    true
                }
                R.id.nav_gallery -> {
                    toolbar?.setTitle("Добавление показаний")
                    Toast.makeText(this, "People", Toast.LENGTH_SHORT).show()
                    ft = supportFragmentManager.beginTransaction()
                    ft.replace(R.id.nav_host_fragment_content_main, AddReadingsFragment())
                    ft.addToBackStack(null)
                    ft.commit()

                    true
                }
                else -> {
                    false
                }
            }
        }
    }


}