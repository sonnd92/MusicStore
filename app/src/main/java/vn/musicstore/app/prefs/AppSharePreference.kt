package vn.musicstore.app.prefs

import android.content.Context
import android.content.SharedPreferences

class AppSharePreference(ctx: Context) {
    private val USER_INFO_STORAGE :String = "MUSIC_STORE_USER_INFO"
    private var sharedPreference :SharedPreferences

    init {
        sharedPreference = ctx.getSharedPreferences(USER_INFO_STORAGE, Context.MODE_PRIVATE)
    }

    fun set(key:String, value:Any?) {
        if (value == null) return

        when (value) {
            is String -> this.sharedPreference.edit().putString(key, value).apply()
            is Int -> this.sharedPreference.edit().putInt(key, value).apply()
            is Float -> this.sharedPreference.edit().putFloat(key, value).apply()
            is Boolean -> this.sharedPreference.edit().putBoolean(key, value).apply()
            is Long -> this.sharedPreference.edit().putLong(key, value).apply()
        }
    }

    fun getInt(key:String) :Int = this.sharedPreference.getInt(key, -1)

    fun getString(key:String) :String = this.sharedPreference.getString(key, "")

    fun getFloat(key:String) :Float = this.sharedPreference.getFloat(key, -1f)

    fun getLong(key: String) :Long = this.sharedPreference.getLong(key, -1)

    fun getBoolean(key:String) :Boolean = this.sharedPreference.getBoolean(key, false)

    fun remove(key:String) = this.sharedPreference.edit().remove(key).commit()

    fun removeAll() = this.sharedPreference.edit().clear().commit()
}