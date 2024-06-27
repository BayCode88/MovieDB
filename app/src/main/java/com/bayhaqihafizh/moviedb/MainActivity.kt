package com.pebrioandikacf.themoviedb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bayhaqihafizh.moviedb.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val TVFragment = TVFragment()
        val MovieFragment = MovieFragment()
        val ProfileFragment = ProfileFragment()

        makeCurrentFragment (TVFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_tv -> makeCurrentFragment(TVFragment)
                R.id.menu_movie -> makeCurrentFragment(MovieFragment)
                R.id.menu_profil -> makeCurrentFragment(ProfileFragment)
            }

            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fram_nav, fragment)
            commit()
        }

    }
}