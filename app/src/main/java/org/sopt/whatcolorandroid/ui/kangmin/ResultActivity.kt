package org.sopt.whatcolorandroid.ui.kangmin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import org.sopt.whatcolorandroid.R
import org.sopt.whatcolorandroid.databinding.ActivityResultBinding
import org.sopt.whatcolorandroid.databinding.ActivityUserBinding
import org.sopt.whatcolorandroid.ui.sehun.MainActivity

class ResultActivity: AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initEvent()
        buttonClickEvent()
    }

    private fun initEvent() {
        val intent = intent
        val userName = intent.getStringExtra("userName")
        val color = intent.getStringExtra("color")

        if (color == "blue") {
            binding.imageColor.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.icon_blue_small, null))
        } else if (color == "pink") {
            binding.imageColor.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.icon_pink_small, null))
        } else if (color == "yellow") {
            binding.imageColor.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.icon_yellow_small, null))
        }

        binding.tvName.text = userName
        binding.tvTeamName.text = color
    }
    private fun buttonClickEvent() {
        binding.btnFinish.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}