package com.example.chopechat.models

import androidx.room.rxjava3.EmptyResultSetException

sealed class Status<out T>{
    object Loading: Status<Nothing>()
    data class Success<out T>(val data: Any) : Status<T>()
    data class Error(val throwable: Throwable) : Status<Nothing>() {
        fun getMessage(): String {
            return when (throwable) {
                is EmptyResultSetException -> "No records have been found"
                else -> throwable.message ?: "An unexpected error has occurred. Please try again later."
            }
        }
    }
}
