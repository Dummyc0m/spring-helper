package cn.com.guardiantech.classroom.backend.util

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType

/**
 * Created by dummy on 3/29/17.
 */
internal class HttpEntityBuilderTest {
    @Test
    fun build() {
        val built = httpEntity<HashMap<String, String>> {
            header {
                contentType = MediaType.APPLICATION_FORM_URLENCODED
            }
            body(hashMapOf("meow" to "1",
                    "pew" to "2",
                    "lelouch" to "3"))
        }
        assertEquals(hashMapOf("meow" to "1",
                "pew" to "2",
                "lelouch" to "3"), built.body)
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_FORM_URLENCODED
        assertEquals(headers, built.headers)
    }

}