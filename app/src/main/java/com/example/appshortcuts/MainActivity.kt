package com.example.appshortcuts

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.appshortcuts.databinding.ActivityMainBinding

@RequiresApi(Build.VERSION_CODES.N_MR1)
class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val shortCutManagerRedirection = ShortCutManagerRedirection(this)
        shortCutManagerRedirection.startDynamicShortcut()

        val args = intent?.getStringExtra(HOME_SHORT_CUT)

        println("ActivityMainBinding >>> $args")

        if(args == HOME_SHORT_CUT){
            Intent(this,ShortCutActivity::class.java).apply {
                startActivity(this)
            }
        }

    }
}