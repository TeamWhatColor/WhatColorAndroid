package org.sopt.whatcolorandroid.ui.kangmin

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import org.sopt.whatcolorandroid.R
import org.sopt.whatcolorandroid.api.ServiceCreator
import org.sopt.whatcolorandroid.databinding.ActivityUserBinding
import org.sopt.whatcolorandroid.ui.kangmin.data.RequestUserInfo
import org.sopt.whatcolorandroid.util.MyApplication
import org.sopt.whatcolorandroid.util.enqueueUtil

class UserActivity: AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding
    private val sharedPreferences = MyApplication.mySharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textCountEvent()
        textClearEvent()
        buttonClickEvent()

    }

    private fun textCountEvent() {
        binding.editName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.tvTextCount.text = "0/6"
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var input = binding.editName.text.toString()
                binding.tvTextCount.setTextColor(ContextCompat.getColor(applicationContext!!, R.color.btn_color))
                binding.tvTextCount.text = input.length.toString() + "/6"

            }

            override fun afterTextChanged(p0: Editable?) {
                var input = binding.editName.text.toString()
                binding.tvTextCount.setTextColor(ContextCompat.getColor(applicationContext!!, R.color.btn_color))
                binding.tvTextCount.text = input.length.toString() + "/6"
            }
        })
    }

    private fun textClearEvent() {
        binding.btnDelete.setOnClickListener {
            binding.editName.text.clear()
        }
    }

    private fun buttonClickEvent() {
        binding.btnNext.setOnClickListener {
            val requestUserInfo = RequestUserInfo(
                id = sharedPreferences.getValue("uuid",""),
                nickname = binding.editName.text.toString()
            )
            val call = ServiceCreator.apiService.postUserInfo(requestUserInfo)

            call.enqueueUtil(
                onSuccess = {
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra("userName", binding.editName.text.toString())
                    intent.putExtra("color", it.data.teamColor)
                    startActivity(intent)
                }
            )
        }
    }
}