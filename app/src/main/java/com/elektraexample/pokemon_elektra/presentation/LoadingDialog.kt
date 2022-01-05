package com.elektraexample.pokemon_elektra.presentation

import android.content.Context
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AlertDialog
import com.elektraexample.pokemon_elektra.R

internal class LoadingDialog(context: Context) :
    AlertDialog(context, R.style.Theme_LoadingDialog) {

    init {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCancelable(false)
        setContentView(R.layout.dialog_loader)
    }

    class Builder(private val context: Context) {

        fun create(): AlertDialog {
            return LoadingDialog(context)
        }
    }
}