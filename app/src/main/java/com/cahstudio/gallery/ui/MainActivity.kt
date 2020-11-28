package com.cahstudio.gallery.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.cahstudio.gallery.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var mFragmentManager: FragmentManager
    private lateinit var actionBar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureToolbar()
        initialize()
    }

    private fun configureToolbar(){
        if (toolbar_toolbar != null) setSupportActionBar(toolbar_toolbar)
        if (supportActionBar != null) {
            actionBar = supportActionBar!!
            actionBar.setDisplayShowTitleEnabled(false)
            toolbar_tvTitle.textSize = 18f
            toolbar_tvTitle.text = "List"
        }
    }

    fun initialize(){
        mFragmentManager = supportFragmentManager

        main_bottomnav.setOnNavigationItemSelectedListener(this)

        moveFragment(ListFragment(),
            mFragmentManager,R.id.fragment_container)
    }

    fun moveFragment(fragment: Fragment, fragmentM: FragmentManager, view: Int){
        val fragmentTransaction = fragmentM.beginTransaction()
        fragmentTransaction.replace(view, fragment)
        fragmentTransaction.commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var isMove = false
        when(item.itemId){
            R.id.navigation_list -> {
                isMove = true
                toolbar_tvTitle.text = "List"
                moveFragment(ListFragment(), mFragmentManager, R.id.fragment_container)
            }
            R.id.navigation_gallery -> {
                isMove = true
                toolbar_tvTitle.text = "Gallery"
                moveFragment(GalleryFragment(), mFragmentManager, R.id.fragment_container)
            }
            R.id.navigation_profile -> {
                isMove = true
                toolbar_tvTitle.text = "Profile"
                moveFragment(ProfileFragment(), mFragmentManager, R.id.fragment_container)
            }
        }

        return isMove
    }
}