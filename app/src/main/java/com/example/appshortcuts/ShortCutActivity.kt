package com.example.appshortcuts

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appshortcuts.databinding.ActivityShortCutBinding

class ShortCutActivity : AppCompatActivity() {

    private val binding:ActivityShortCutBinding by lazy { ActivityShortCutBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

    }
}