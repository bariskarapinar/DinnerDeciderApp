package com.myapp.dinnerdeciderapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.myapp.dinnerdeciderapp.databinding.ActivityMainBinding
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val foodList = arrayListOf("Chinese", "Hamburger", "Pizza", "McDonalds", "Barros Pizza")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.decideBtn.setOnClickListener {
            val random = Random()
            val randomFood = random.nextInt(foodList.size)
            binding.selectedFoodTxt.text = foodList[randomFood]
            println("Clicked the button!")
        }

        binding.addFoodBtn.setOnClickListener {
            val newFood = binding.addFoodTxt.text.toString()
            println("New Food: $newFood")
            if (newFood.isNotEmpty()) {
                foodList.add(newFood)
                binding.addFoodTxt.text.clear()
                println(foodList)
            }
        }
    }
}