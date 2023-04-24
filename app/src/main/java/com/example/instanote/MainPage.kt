package com.example.instanote

import android.view.LayoutInflater
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.instanote.databinding.ActivityMainBinding
import com.example.instanote.databinding.ActivityMainPageBinding
import com.example.instanote.databinding.AddLayoutBinding
import com.example.instanote.databinding.HomeLayoutBinding
import com.example.instanote.databinding.PlayLayoutBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainPage : AppCompatActivity(){
    private lateinit var binding: ActivityMainPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigation: BottomNavigationView = binding.bottomNavigation
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    showHomeLayout()
                    true
                }
                R.id.navigation_add -> {
                    showAddLayout()
                    true
                }
                R.id.navigation_play -> {
                    showPlayLayout()
                    true
                }
                else -> false

            }
        }
    }
       fun showHomeLayout(){
            val homeLayoutBinding = HomeLayoutBinding.inflate(LayoutInflater.from(this))
           binding.container.removeAllViews()
           binding.container.addView(homeLayoutBinding.root)
}
        fun showAddLayout(){
            val addLayoutFragment = AddLayoutFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, addLayoutFragment)
                .commit()
        }

        fun showPlayLayout(){
            val PlayLayoutBinding = PlayLayoutBinding.inflate(LayoutInflater.from(this))
            binding.container.removeAllViews()
            binding.container.addView(PlayLayoutBinding.root)
        }



}