import android.content.Context
import android.content.SharedPreferences

object SharedPref{
    private lateinit var prefs:SharedPreferences
    private const val PREFS_NAME = "params"

    fun init(context: Context) {
        prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun read(key: String, default: String): String? {
        return prefs.getString(key, default)
    }

    fun read(key: String, default: Long): Long {
        return prefs.getLong(key, default)
    }

    fun write(key: String, value: String) {
        val prefsEditor: SharedPreferences.Editor = prefs.edit()
        with(prefsEditor) {
            putString(key, value)
            commit()
        }
    }

    fun write(key: String, value: Long) {
        val prefsEditor: SharedPreferences.Editor = prefs.edit()
        with(prefsEditor) {
            putLong(key, value)
            commit()
        }
    }
}