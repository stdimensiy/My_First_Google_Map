package ru.vdv.myfirstgooglemap.domain

interface CallBack<T> {
    fun onResult(value: T)
}