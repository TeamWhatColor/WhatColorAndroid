package org.sopt.whatcolorandroid.ui.jeongwon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.sopt.whatcolorandroid.databinding.ActivityMissionBinding

class MissionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMissionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMissionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //팝업
        val dialog = MissionDialog.CustomDialogBuilder().create()
        dialog.isCancelable = false
        dialog.show(supportFragmentManager, "dialog")
    }

}