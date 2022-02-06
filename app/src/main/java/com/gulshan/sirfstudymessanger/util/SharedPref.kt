package com.gulshan.sirfstudymessanger.util

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.OnSharedPreferenceChangeListener
import android.util.Log


class SharedPrefService constructor(context: Context) {
    private val preferences: SharedPreferences = context.applicationContext
        .getSharedPreferences(Keys.PREFERENCE_FILE_NAME, Context.MODE_PRIVATE)
    private lateinit var editor: SharedPreferences.Editor
    private val TAG = "SharedPrefService"
    @Synchronized
    fun storeSession(session: String?) {
        editor = preferences.edit()
        editor.putString(Keys.PREFERENCE_AUTH_KEY, session)
        editor.apply()
    }

    val session: String?
        get() {
            try {
                return preferences.getString(Keys.PREFERENCE_AUTH_KEY, FAILURE_STRING)
            } catch (e: ClassCastException) {
                Log.e(TAG, "Stored: session is NOT String")
            }
            return FAILURE_STRING
        }
    val isSessionPresent: Boolean
        get() = session != FAILURE_STRING && !session!!.isEmpty()

    /**
     * Puts a String value into Shared Preference file
     * @param key The key for Shared Preferences
     * @param value Value to store
     */
    @Synchronized
    fun putStringValue(key: String?, value: String?) {
        editor = preferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    /**
     * Puts a boolean value into Shared Preference file
     * @param key The key for Shared Preferences
     * @param value Value to store
     */
    @Synchronized
    fun putBooleanValue(key: String?, value: Boolean) {
        editor = preferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    /**
     * Puts a int value into Shared Preference file
     * @param key The key for Shared Preferences
     * @param value Value to store
     */
    @Synchronized
    fun putIntValue(key: String?, value: Int) {
        editor = preferences.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    /**
     * Puts a long value into Shared Preference file
     * @param key The key for Shared Preferences
     * @param value Value to store
     */
    @Synchronized
    fun putLongValue(key: String?, value: Long) {
        editor = preferences.edit()
        editor.putLong(key, value)
        editor.apply()
    }

    /**
     * Puts a float value into Shared Preference file
     * @param key The key for Shared Preferences
     * @param value Value to store
     */
    @Synchronized
    fun putFloatValue(key: String?, value: Float) {
        editor = preferences.edit()
        editor.putFloat(key, value)
        editor.apply()
    }

    /**
     * Gets the String Value from the given Key
     * @param key Key to find the value
     */
    fun getStringValue(key: String): String? {
        try {
            return preferences.getString(key, FAILURE_STRING)
        } catch (e: ClassCastException) {
            Log.e(TAG, "Stored: $key is NOT String")
        }
        return FAILURE_STRING
    }

    /**
     * Gets the boolean Value from the given Key
     * @param key Key to find the value
     */
    fun getBooleanValue(key: String): Boolean {
        try {
            return preferences.getBoolean(key, FAILURE_BOOLEAN)
        } catch (e: ClassCastException) {
            Log.e(TAG, "Stored: $key is NOT Boolean")
        }
        return FAILURE_BOOLEAN
    }

    /**
     * Gets the int Value from the given Key
     * @param key Key to find the value
     */
    fun getIntValue(key: String): Int {
        try {
            return preferences.getInt(key, FAILURE_INT)
        } catch (e: ClassCastException) {
            Log.e(TAG, "Stored: $key is NOT Integer")
        }
        return FAILURE_INT
    }

    /**
     * Gets the long Value from the given Key
     * @param key Key to find the value
     */
    fun getLongValue(key: String): Long {
        try {
            return preferences.getLong(key, FAILURE_LONG)
        } catch (e: ClassCastException) {
            Log.e(TAG, "Stored: $key is NOT Long")
            e.printStackTrace()
        }
        return FAILURE_LONG
    }

    /**
     * Gets the float Value from the given Key
     * @param key Key to find the value
     */
    fun getFloatValue(key: String): Float {
        try {
            return preferences.getFloat(key, FAILURE_FLOAT)
        } catch (e: ClassCastException) {
            Log.e(TAG, "Stored: $key is NOT Float")
        }
        return FAILURE_FLOAT
    }

    fun clearSharedPref() {
        editor = preferences.edit()
        editor.clear()
        editor.apply()
    }

    /**
     * Registers the Given Listener to the Shared Preference
     * @param listener Preference Change Listener to register
     */
    fun registerListener(listener: OnSharedPreferenceChangeListener?) {
        preferences.registerOnSharedPreferenceChangeListener(listener)
    }

    /**
     * Un-Registers the Given Listener to the Shared Preference
     * @param listener Preference Change Listener to un-register
     */
    fun unregisterListeners(listener: OnSharedPreferenceChangeListener?) {
        preferences.unregisterOnSharedPreferenceChangeListener(listener)
    }

    companion object {
        private var mInstance: SharedPrefService? = null
        lateinit var FAILURE_STRING: String
        var FAILURE_INT: Int = 0
        var FAILURE_BOOLEAN: Boolean = false
        var FAILURE_LONG: Long = 0
        var FAILURE_FLOAT: Float = 0.0f
        fun getInstance(context: Context): SharedPrefService? {
            if (mInstance == null) mInstance = SharedPrefService(context)
            return mInstance
        }
    }

    /**
     * Will be called only when there is no object of this class in memory
     */
    init {
        FAILURE_STRING = "N/A"
        FAILURE_INT = -1
        FAILURE_BOOLEAN = false
        FAILURE_LONG = -1
        FAILURE_FLOAT = -1f
    }
}