package org.sopt.whatcolorandroid.ui.kangmin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.sopt.whatcolorandroid.api.ServiceCreator
import org.sopt.whatcolorandroid.ui.sehun.MainActivity
import org.sopt.whatcolorandroid.util.MyApplication
import org.sopt.whatcolorandroid.util.enqueueUtil
import java.util.*

class SplashActivity : AppCompatActivity() {
    private val sharedPreferences = MyApplication.mySharedPreferences

    val SPLASH_VIEW_TIME: Long = 3000 //2초간 스플래시 화면을 보여줌 (ms)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        Handler().postDelayed({ //delay를 위한 handler
            val uuid = sharedPreferences.getValue("uuid", "")
            if (uuid == "") {
                sharedPreferences.setValue("uuid", UUID.randomUUID().toString())
                Log.d("tag", "UUID : $uuid")

            } else {
                Log.d("tag", "UUID : $uuid")
            }
            val call = ServiceCreator.apiService.getInfo(uuid)

            call.enqueueUtil(
                onSuccess = {
                    if (it.data.exist) {
                        startActivity(Intent(this,MainActivity::class.java))
                        finish()
                    } else if (!it.data.exist) {
                        startActivity(Intent(this, UserActivity::class.java))
                        finish()
                    }
                },
                onError = {
                    startActivity(Intent(this, UserActivity::class.java))
                    finish()
                }
            )
        }, SPLASH_VIEW_TIME)
    }
}