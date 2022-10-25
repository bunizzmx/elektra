package com.elektraexample.pokemon_elektra.presentation.base

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.MotionEvent
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.elektraexample.pokemon_elektra.presentation.ui.BaseViewModel
import com.elektraexample.pokemon_elektra.utils.Event


abstract class BaseViewModelActivity<T : BaseViewModel> : AppCompatActivity() {

    protected abstract val baseViewModel: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeEvents()
    }

    private fun observeEvents() {
        baseViewModel.showLoading.observe(this, Event.EventObserver {
            showLoadingDialog()
        })
        baseViewModel.hideLoading.observe(this, Event.EventObserver {
            hideLoadingDialog()
        })
    }

    private fun showLoadingDialog() {
      //Aqui pondre cualquier loading dependiendo del diseño
    }

    private fun hideLoadingDialog() {
      //Aqui lo oculto
    }

}