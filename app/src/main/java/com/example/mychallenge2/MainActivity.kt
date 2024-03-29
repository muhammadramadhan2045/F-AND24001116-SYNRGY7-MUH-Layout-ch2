package com.example.mychallenge2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mychallenge2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private var tipPercent: Int = 0
    private  var splitBy:Int =0
    private lateinit var roundAmount: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        chooseTip()
        splitByPerson()
        roundingAmount()

    }

    private fun roundingAmount() {
        binding.btnRoundNo.setOnClickListener {
            binding.btnRoundNo.setBackgroundColor(getColor(R.color.md_theme_light_primaryContainer))
            binding.btnRoundUp.setBackgroundColor(getColor(R.color.md_theme_light_inverseOnSurface))
            roundAmount = "No"

        }

        binding.btnRoundUp.setOnClickListener {
            binding.btnRoundUp.setBackgroundColor(getColor(R.color.md_theme_light_primaryContainer))
            binding.btnRoundNo.setBackgroundColor(getColor(R.color.md_theme_light_inverseOnSurface))
            roundAmount = "Yes"
        }


    }

    private fun splitByPerson() {
        binding.sliderSplit.addOnChangeListener { _, value, _ ->
            binding.tvSplitBy.text = buildString {
                append(getText(R.string.split_by).toString())
                append(" ")
                append(value.toInt().toString())
            }
            splitBy = value.toInt()
        }
    }

    private fun chooseTip() {
        binding.btn10Percent.setOnClickListener {
            tipPercent = 10
            binding.btn10Percent.setBackgroundColor(getColor(R.color.md_theme_light_primaryContainer))
            binding.btn20Percent.setBackgroundColor(getColor(R.color.md_theme_light_inverseOnSurface))
            binding.btn15Percent.setBackgroundColor(getColor(R.color.md_theme_light_inverseOnSurface))
        }

        binding.btn15Percent.setOnClickListener {
            tipPercent = 15
            binding.btn15Percent.setBackgroundColor(getColor(R.color.md_theme_light_primaryContainer))
            binding.btn20Percent.setBackgroundColor(getColor(R.color.md_theme_light_inverseOnSurface))
            binding.btn10Percent.setBackgroundColor(getColor(R.color.md_theme_light_inverseOnSurface))
        }

        binding.btn20Percent.setOnClickListener {
            tipPercent = 20
            binding.btn20Percent.setBackgroundColor(getColor(R.color.md_theme_light_primaryContainer))
            binding.btn10Percent.setBackgroundColor(getColor(R.color.md_theme_light_inverseOnSurface))
            binding.btn15Percent.setBackgroundColor(getColor(R.color.md_theme_light_inverseOnSurface))
        }
    }
}