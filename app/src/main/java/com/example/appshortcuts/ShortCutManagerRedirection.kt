package com.example.appshortcuts

import android.content.Context
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.N_MR1)
class ShortCutManagerRedirection(
    private val context: Context
) {

    private val shortcutManager = context.getSystemService(ShortcutManager::class.java)

    fun startDynamicShortcut() {
        val shortcut = ShortcutInfo.Builder(context, HOME_SHORT_CUT)
            .setShortLabel("Open Feature")
            .setLongLabel("Open Specific Feature")
            .setIcon(Icon.createWithResource(context, R.drawable.ic_launcher_foreground))
            .setIntent(

                Intent(context, MainActivity::class.java).apply {
                    putExtra(HOME_SHORT_CUT, HOME_SHORT_CUT)
                    action = Intent.ACTION_VIEW
                }
            )
            .build()

        shortcutManager?.dynamicShortcuts = listOf(shortcut)
    }
}

const val HOME_SHORT_CUT = "HOME_SHORT_CUT"