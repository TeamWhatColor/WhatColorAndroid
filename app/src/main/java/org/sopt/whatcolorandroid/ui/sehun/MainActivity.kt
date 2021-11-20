package org.sopt.whatcolorandroid.ui.sehun

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.res.ResourcesCompat
import org.sopt.whatcolorandroid.R
import org.sopt.whatcolorandroid.api.ServiceCreator
import org.sopt.whatcolorandroid.databinding.ActivityMainBinding
import org.sopt.whatcolorandroid.ui.jeongwon.MissionActivity
import org.sopt.whatcolorandroid.util.MyApplication
import org.sopt.whatcolorandroid.util.enqueueUtil
import retrofit2.Call

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val sharedPreferences = MyApplication.mySharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCheck.setOnClickListener{
            val intent = Intent(this, MissionActivity::class.java) // 확인 버튼 시 미션뷰로이동
            startActivity(intent)
        }

        
        setContentView(binding.root)
    }

    override fun onStart(){
        super.onStart()
        initNetwork()
        binding.tvMission3.visibility = View.VISIBLE
    }


    private fun initNetwork(){
        val uuid = sharedPreferences.getValue("uuid","")
        Log.d("hihi", uuid)

        val call = ServiceCreator.apiService.getMain(uuid)

        call.enqueueUtil(
            onSuccess = {
                val color = it.data.color
                binding.tvName.text= it.data.nickname
                binding.tvTeam.text = it.data.color+" TEAM"
                if (color == "blue") {
                    binding.ivColor.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.icon_blue_small, null))
                } else if (color == "pink") {
                    binding.ivColor.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.icon_pink_small, null))
                } else if (color == "yellow") {
                    binding.ivColor.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.icon_yellow_small, null))
                }
                binding.tvMission.text = it.data.content
            }
        )
    }
}