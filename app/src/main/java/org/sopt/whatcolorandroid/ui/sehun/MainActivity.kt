package org.sopt.whatcolorandroid.ui.sehun

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.whatcolorandroid.R
import org.sopt.whatcolorandroid.databinding.ActivityMainBinding
import org.sopt.whatcolorandroid.ui.jeongwon.MissionActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val intent = Intent(this, MissionActivity::class.java) // 확인 버튼 시 미션뷰로이동

        binding.btnCheck.setOnClickListener{
            startActivity(intent)
        }
        setContentView(binding.root)
    }
}