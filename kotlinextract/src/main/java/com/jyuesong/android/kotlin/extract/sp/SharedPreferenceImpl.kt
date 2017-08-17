package com.jyuesong.android.kotlin.extract.sp

import android.content.Context
import android.content.SharedPreferences
import android.text.TextUtils
import org.apache.commons.codec.binary.Base64
import java.io.*

/**
 * Created by jiang on 2017/8/17.
 */

object SharedPreferenceImpl {

    private lateinit var SP_NAME: String
    private var MODE: Int = Context.MODE_PRIVATE
    private var sp: SharedPreferences? = null

    fun init(context: Context, sp_name: String, mode: Int = Context.MODE_PRIVATE) {
        SP_NAME = sp_name
        MODE = mode
        sp = context.getSharedPreferences(SP_NAME, mode)
    }


    fun saveBoolean(context: Context, key: String, value: Boolean) = getSP(context).edit().putBoolean(key, value).commit()


    fun saveString(context: Context, key: String, value: String) = getSP(context).edit().putString(key, value).commit()


    fun saveLong(context: Context, key: String, value: Long) = getSP(context).edit().putLong(key, value).commit()


    fun saveInt(context: Context, key: String, value: Int) = getSP(context).edit().putInt(key, value).commit()


    fun saveFloat(context: Context, key: String, value: Float) = getSP(context).edit().putFloat(key, value).commit()


    fun getBoolean(context: Context, key: String, default: Boolean = false): Boolean = getSP(context).getBoolean(key, default)


    fun getString(context: Context, key: String, default: String = ""): String = getSP(context).getString(key, default)


    fun getLong(context: Context, key: String, default: Long): Long = getSP(context).getLong(key, default)


    fun getInt(context: Context, key: String, default: Int): Int = getSP(context).getInt(key, default)


    fun getFloat(context: Context, key: String, default: Float): Float = getSP(context).getFloat(key, default)


    fun saveObj(context: Context, key: String, obj: Any) {
        try {
            val baos = ByteArrayOutputStream()
            val oos = ObjectOutputStream(baos)
            oos.writeObject(obj)
            val objBase64 = String(Base64.encodeBase64(baos.toByteArray()))
            getSP(context).edit().putString(key, objBase64).commit()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    fun <T> getObj(context: Context, key: String): T? {

        try {
            val objBase64: String = getSP(context).getString(key, "")
            if (TextUtils.isEmpty(objBase64)) {
                return null
            }
            val base64Bytes = Base64.decodeBase64(objBase64.toByteArray())
            val bais = ByteArrayInputStream(base64Bytes)
            val ois = ObjectInputStream(bais)
            val obj = ois.readObject()
            ois.close()
            return obj as T
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
    }


    fun removeIt(context: Context, key: String) {
        getSP(context).edit().remove(key).commit()
    }

    fun clear(context: Context) {
        getSP(context).edit().clear().commit()
    }


    fun getSP(context: Context): SharedPreferences {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, MODE)
        }
        return sp!!

    }


}