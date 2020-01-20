package com.db.rodofragmentexample.activities

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.db.rodofragmentexample.R
import com.db.rodofragmentexample.fragments.ChatFragment
import com.db.rodofragmentexample.fragments.FavoritesFragment
import com.db.rodofragmentexample.fragments.HomeFragment
import com.db.rodofragmentexample.fragments.MyLeaseFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {


    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navigationView = nav_view
        navigationView.setNavigationItemSelectedListener(this)

        settings_btn.setOnClickListener {
            drawer.openDrawer(GravityCompat.END)
        }

        drawer = findViewById<DrawerLayout>(R.id.drawer_layout)

        changeFragment(HomeFragment())

        home_btn.setOnClickListener(this)
        favorites_btn.setOnClickListener(this)
        mylease_btn.setOnClickListener(this)
        chat_btn.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.home_btn -> changeFragment(HomeFragment())
            R.id.favorites_btn -> changeFragment(FavoritesFragment())
            R.id.mylease_btn -> changeFragment(MyLeaseFragment())
            R.id.chat_btn -> changeFragment(ChatFragment())
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> changeFragment(HomeFragment())
            R.id.nav_favorites -> changeFragment(FavoritesFragment())
            R.id.nav_screen -> changeActivity()
        }
        drawer.closeDrawer(GravityCompat.END)
        return true
    }

    fun changeActivity(){
        startActivity(Intent(this, MyAccountActivity::class.java))
    }

    fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.main_container, fragment).addToBackStack(null).commit()
    }

}
