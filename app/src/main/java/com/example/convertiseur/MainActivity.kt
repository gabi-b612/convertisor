package com.example.convertiseur

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.convertiseur.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.button2.setOnClickListener {conversor()}
        binding.button.setOnClickListener { hexaconver() }
    }

    private fun hexaconver() {
        val toast = Toast.makeText(this, "Entrer invalide", Toast.LENGTH_LONG)
        val hex = binding.editTextText.text.toString().toUpperCase()

        val content = hex.any{it > 'F'}

        if (content) {
            binding.textView3.text = "-_-"
            toast.show()
        } else {
            if (hex.isEmpty()) {
                binding.textView3.text = "-_-"
                toast.show()
            } else if (hex.length > 14) {
                binding.textView3.text = "-_-"
                toast.show()
            } else {
                binding.textView3.text = hex.toInt(16).toString()
            }
        }



    }

    private fun conversor() {
        val toast = Toast.makeText(this, "Le nombre entrer est beaucoup trop grand", Toast.LENGTH_LONG)
        val toast2 = Toast.makeText(this, "Entrez au moins un chiffre", Toast.LENGTH_LONG)
        val number = binding.editTextNumber.text.toString()
        if (number.length > 10) {
            binding.textView2.text = "-_-"
            toast.show()
        } else if (number.length == 0) {
            binding.textView2.text = "-_-"
            toast2.show()
        } else {
            binding.textView2.text = Integer.toHexString(number.toString().toInt()).toString().toUpperCase()
        }
    }
}