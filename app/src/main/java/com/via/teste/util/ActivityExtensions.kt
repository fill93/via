package com.via.teste.util

import android.app.Activity
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.squareup.moshi.JsonDataException
import com.via.teste.R
import kotlinx.android.synthetic.main.dg_simple_msg.view.*
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException

fun Activity.extDialogWindow(msg : String, btName : String, isCancelable : Boolean = true , action :() -> Unit  ) {

    val cont = this.window
    val view = View.inflate(this , R.layout.dg_simple_msg,null)

    view.tv_msg.text = msg
    view.bt_action.text = btName
    view.bt_action.setOnClickListener {
        view.card_root.visibility = View.GONE
        action()
    }

    view.setOnClickListener {
        if(isCancelable)
            view.visibility = View.GONE
    }

    cont.addContentView( view ,
        ViewGroup.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT) )
}


fun Activity.extHandleError(throwable: Throwable , activityId : Int = 0) {

    Log.i("LOG"," ::::: ${throwable.message} ")

    when(throwable) {
        is HttpException -> {

            when (throwable.code()) {
                401 -> extDialogWindow(getString(R.string.erro_implemente),getString(R.string.continuar)){}
                403 -> extDialogWindow(getString(R.string.erro_implemente),getString(R.string.continuar)){}
                405 -> extDialogWindow(getString(R.string.erro_implemente),getString(R.string.continuar)){}
                500, 503, 504 -> extDialogWindow(getString(R.string.erro_500),getString(R.string.continuar)){}
                else -> extDialogWindow(getString(R.string.erro_desconhecido),getString(R.string.continuar)){}
            }
        }
        is JsonDataException -> extDialogWindow(getString(R.string.erro_jsondataexception),getString(R.string.continuar)){}
        is ConnectException -> extDialogWindow(getString(R.string.erro_connectexception),getString(R.string.continuar)){}
        is SocketTimeoutException -> extDialogWindow(getString(R.string.erro_sockettimeoutexception),getString(R.string.continuar)){}
//        is SocketException -> extDialogWindow(getString(R.string.erro_),getString(R.string.continuar)){}
//        is IOException -> extDialogWindow(getString(R.string.erro_),getString(R.string.continuar)){}
        else -> extDialogWindow(getString(R.string.erro_desconhecido),getString(R.string.continuar)){}
    }
}