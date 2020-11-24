package com.ariasluque.agendainteractiva.controller

import androidx.preference.Preference

interface OnPreferenceListener {
    fun onChangeLocale(locale: String)
    fun onChangeTheme()
}