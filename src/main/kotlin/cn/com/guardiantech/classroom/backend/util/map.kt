package cn.com.guardiantech.classroom.backend.util

import org.springframework.util.LinkedMultiValueMap

/**
 * creates maps kotlin style
 * Created by dummy on 3/29/17.
 */
fun <K, V> linkedMultiValueMapOf() = LinkedMultiValueMap<K, V>()

fun <K, V> linkedMultiValueMapOf(vararg pairs: Pair<K, List<V>>) = LinkedMultiValueMap<K, V>().apply { putAll(pairs) }