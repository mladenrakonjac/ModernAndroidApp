package me.fleka.modernandroidapp

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import me.fleka.modernandroidapp.databinding.ActivityMainBinding
import me.fleka.modernandroidapp.uimodels.Repository

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    var repository = Repository("Medium Android Repository Article",
            "Fleka", 1000, true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.repository = repository
        binding.executePendingBindings()

    }
}
