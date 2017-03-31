package cn.com.guardiantech.classroom.backend.util

import cn.codetector.jet.jetsimplejson.JSONArray
import cn.codetector.jet.jetsimplejson.JSONObject

/**
 * val json = jsonObjectOf("id" to "password",
 *          "password" to "huh")
 * Created by dummy on 3/29/17.
 */
fun jsonObjectOf(vararg fields: Pair<String, Any?>) = JSONObject(mapOf(*fields))
fun jsonArrayOf(vararg values: Any?) = JSONArray(listOf(*values))

fun encodedJsonObjectOf(vararg fields: Pair<String, Any?>) = JSONObject(mapOf(*fields)).encode()
fun encodedJsonArrayOf(vararg values: Any?) = JSONArray(listOf(*values)).encode()

@Suppress("UNCHECKED_CAST")
fun <T> JSONObject.get(k: String) = getValue(k) as T

@Suppress("UNCHECKED_CAST")
fun <T> JSONObject.get(k: String, default: T) = getValue(k, default) as T

operator fun JSONObject.set(k: String, v: Any?) = put(k, v)!!

fun JSONObject.put(pair: Pair<String, Any?>) = put(pair.first, pair.second)!!
