package com.via.teste.vp

interface BasePresenter {

    fun start()

    fun stop()

    fun attachView( view : BaseView<BasePresenter> )

}