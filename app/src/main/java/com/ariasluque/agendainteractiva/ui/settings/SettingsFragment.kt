package com.ariasluque.agendainteractiva.ui.settings

import android.content.Context
import android.os.Bundle
import androidx.preference.*
import com.ariasluque.agendainteractiva.R
import com.ariasluque.agendainteractiva.controller.OnPreferenceListener

class SettingsFragment : PreferenceFragmentCompat() {

    private lateinit var mListener : OnPreferenceListener // Listener para pasar los datos al activity

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)

        // Comprueba los cambios de preferencias del lenguaje
        (findPreference("language_preference") as ListPreference?)?.setOnPreferenceChangeListener { preference, newValue ->
            val locale: String = newValue.toString()
            mListener.onChangeLocale(locale)
            true
        }

        // Comprueba los cambios de preferencias del tema
        (findPreference("theme_preference") as SwitchPreferenceCompat?)?.setOnPreferenceChangeListener { preference, newValue ->
            mListener.onChangeTheme()
            true
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            mListener = context as OnPreferenceListener

        } catch (e: ClassCastException) {
            throw ClassCastException(("$context must implement Listener"))
        }
    }
}