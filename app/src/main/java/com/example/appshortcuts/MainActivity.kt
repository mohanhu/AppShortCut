package com.example.appshortcuts

import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appshortcuts.databinding.ActivityMainBinding

@RequiresApi(Build.VERSION_CODES.N_MR1)
class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val shortcutManager = getSystemService(ShortcutManager::class.java)

        val shortcut = ShortcutInfo.Builder(this, "dynamic_shortcut_id")
            .setShortLabel("Open Feature")
            .setLongLabel("Open Specific Feature")
            .setIcon(Icon.createWithResource(this, R.drawable.ic_launcher_foreground))
            .setIntent(

                Intent(this, MainActivity::class.java, ).apply {
                    putExtra("shortcut_id", "dynamic_shortcut_id")
                    action = Intent.ACTION_VIEW
                }
            )
            .build()

        shortcutManager?.dynamicShortcuts = listOf(shortcut)

        val args = intent?.getStringExtra("shortcut_id")

        println("ActivityMainBinding >>> $args")

    }
}