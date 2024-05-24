package com.example.listpesertasakinah.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.listpesertasakinah.R

data class Peserta(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    @StringRes val number: Int,
    val age: Int,
    @StringRes val place_of_birth: Int,

)
val parapeserta = listOf(
    Peserta(R.drawable.a_alphabet_icon, R.string.peserta_1, R.string.no_peserta_1,18,  R.string.tempatlahir_peserta_1),
    Peserta(R.drawable.a_alphabet_icon, R.string.peserta_2, R.string.no_peserta_2,21,  R.string.tempatlahir_peserta_2),
    Peserta(R.drawable.a_alphabet_icon, R.string.peserta_3, R.string.no_peserta_3,19,  R.string.tempatlahir_peserta_3),
    Peserta(R.drawable.a_alphabet_icon, R.string.peserta_4, R.string.no_peserta_4,25,  R.string.tempatlahir_peserta_4),
    Peserta(R.drawable.a_alphabet_icon, R.string.peserta_5, R.string.no_peserta_5,27,  R.string.tempatlahir_peserta_5 ),
    Peserta(R.drawable.a_alphabet_icon, R.string.peserta_6, R.string.no_peserta_6,21,  R.string.tempatlahir_peserta_6 ),
    Peserta(R.drawable.a_alphabet_icon, R.string.peserta_7, R.string.no_peserta_7,19,  R.string.tempatlahir_peserta_7 ),
    Peserta(R.drawable.a_alphabet_icon, R.string.peserta_8, R.string.no_peserta_8,25,  R.string.tempatlahir_peserta_8 ),

)
