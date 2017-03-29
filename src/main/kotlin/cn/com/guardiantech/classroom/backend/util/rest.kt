package cn.com.guardiantech.classroom.backend.util

import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
/**
 * val request = httpEntity<HashMap<String, String>> {
 *      header {
 *          contentType = MediaType.APPLICATION_FORM_URLENCODED
 *      }
 *      body(hashMapOf("id" to "1", "p" to "p"))
 * }
 * helps you build HttpEntity
 * Created by dummy on 3/29/17.
 */
fun <T> httpEntity(builder: HttpEntityBuilder<T>.() -> Unit): HttpEntity<T> {
    return HttpEntityBuilder<T>().apply(builder).build()
}

class HttpEntityBuilder<T> {
    private var header: HttpHeaders? = null
    private var body: T? = null

    fun header(value: HttpHeaders) {
        header = value
    }

    inline fun header(crossinline function: HttpHeaders.() -> Unit) {
        header(HttpHeaders().apply(function))
    }

    fun body(value: T) {
        body = value
    }

    inline fun body(function: () -> T) {
        body(function())
    }

    fun build(): HttpEntity<T> {
        return HttpEntity<T>(body, header)
    }
}