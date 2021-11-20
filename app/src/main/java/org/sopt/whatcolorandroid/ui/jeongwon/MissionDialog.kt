package org.sopt.whatcolorandroid.ui.jeongwon

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import org.sopt.whatcolorandroid.R
import org.sopt.whatcolorandroid.api.ServiceCreator
import org.sopt.whatcolorandroid.databinding.DialogMissionBinding
import org.sopt.whatcolorandroid.ui.base.BaseDialogFragment
import org.sopt.whatcolorandroid.ui.jeongwon.MissionActivity.Companion.mission
import org.sopt.whatcolorandroid.util.MyApplication
import org.sopt.whatcolorandroid.util.enqueueUtil

class MissionDialog: BaseDialogFragment<DialogMissionBinding>() {

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = DialogMissionBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            setupDialogBackground()
        binding.tvMissionDetailDes.text = mission
    }

    private fun setupDialogBackground() {
        val deviceWidth = Resources.getSystem().displayMetrics.widthPixels
        val dialogHorizontalMargin = (Resources.getSystem().displayMetrics.density * 16) * 2
        dialog!!.window!!.apply {
            setLayout(
                (deviceWidth - dialogHorizontalMargin).toInt(),
                WindowManager.LayoutParams.WRAP_CONTENT
            )
            setBackgroundDrawableResource(R.drawable.bg_dialog_common)
        }
    }

    class CustomDialogBuilder {
        private val dialog = MissionDialog()

        fun create(): MissionDialog {
            return dialog
        }
    }
}