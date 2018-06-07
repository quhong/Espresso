package com.test.demo

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> loading(msg: String? = null, data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data, msg)
        }
        fun <T> success(data: T? = null): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }
        fun <T> error(msg: String? = null, data: T? = null): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }
    }
}
enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}