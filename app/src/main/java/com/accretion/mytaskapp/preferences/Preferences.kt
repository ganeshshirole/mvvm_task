package com.accretion.mytaskapp.preferences

import android.content.Context

class Preferences {
    companion object {
        private val prefName = "BMHGPS"
        // Store data in Shared Preference
        fun putString(
            context: Context, key: String,
            value: String
        ) {
            val editor = context.getSharedPreferences(
                prefName,
                Context.MODE_PRIVATE
            ).edit()
            editor.putString(key, value)
            editor.apply()
        }

        fun putInt(
            context: Context, key: String,
            value: Int
        ) {
            val editor = context.getSharedPreferences(
                prefName,
                Context.MODE_PRIVATE
            ).edit()
            editor.putInt(key, value)
            editor.apply()
        }

        fun getString(context: Context?, key: String): String? {
            val preference = context?.getSharedPreferences(
                prefName,
                Context.MODE_PRIVATE
            )
            return preference?.getString(key, "0")
        }

        fun getInt(context: Context?, key: String, default: Int): Int {
            val preference = context?.getSharedPreferences(
                prefName,
                Context.MODE_PRIVATE
            )
            return preference?.getInt(key, default) ?: default
        }

        // Store boolean data in Shared Preference
        fun putBoolean(
            context: Context, key: String,
            value: Boolean
        ) {
            val editor = context.getSharedPreferences(
                prefName,
                Context.MODE_PRIVATE
            ).edit()
            editor.putBoolean(key, value)
            editor.apply()
        }


        fun getBoolean(context: Context, key: String): Boolean {
            val preference = context.getSharedPreferences(
                prefName,
                Context.MODE_PRIVATE
            )
            return preference.getBoolean(key, false)
        }

        // Delete all data from Shared Preference
        fun removeAll(context: Context) {
            val editor = context.getSharedPreferences(
                prefName,
                Context.MODE_PRIVATE
            ).edit()

            editor.clear()
            editor.apply()
        }

        // Delete specific data from Shared Preference
        fun remove(
            context: Context,
            key: String
        ) {
            val editor = context.getSharedPreferences(
                prefName, Context.MODE_PRIVATE
            ).edit()
            editor.remove(key)
            editor.apply()
        }
    }
}