package org.sopt.whatcolorandroid.ui.jeongwon

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.sopt.whatcolorandroid.api.ServiceCreator
import org.sopt.whatcolorandroid.databinding.ActivityMissionBinding
import org.sopt.whatcolorandroid.util.MyApplication
import org.sopt.whatcolorandroid.util.enqueueUtil

class MissionActivity : AppCompatActivity() {
    private val sharedPreferences = MyApplication.mySharedPreferences
    private lateinit var binding: ActivityMissionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMissionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val uuid = sharedPreferences.getValue("uuid","")
        val call = ServiceCreator.apiService.getMission(uuid)
        Log.d("hihi", "wlrds")

        call.enqueueUtil(
            onSuccess = {
                mission = it.data.content
                Log.d("hihi", mission)
            },
            onError = {
                Log.d("hihi", "error"+mission)
            }
        )
        //팝업
        binding.ivBtnMission.setOnClickListener {
            val dialog = MissionDialog.CustomDialogBuilder().create()
            dialog.isCancelable = false
            dialog.show(supportFragmentManager, "dialog")
        }

        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    companion object {
        var mission = ""
    }

}