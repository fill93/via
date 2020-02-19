package com.via.teste.vp

interface BaseView<out T: BasePresenter> {

    val presenter: T

    fun handleError( throwable: Throwable )

}