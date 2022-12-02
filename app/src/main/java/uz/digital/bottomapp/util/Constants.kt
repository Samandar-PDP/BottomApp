package uz.digital.bottomapp.util

import uz.digital.bottomapp.R
import uz.digital.bottomapp.model.Language

object Constants {
    fun mixLanguages(): List<Language> {
        return listOf(
            Language(
                name = "English",
                R.drawable.img,
                12000000,
                listOf("UK,USA,AUS,IN")
            ),
            Language(
                name = "Russian",
                R.drawable.img_1,
                1523,
                listOf("RU,UK,UZ,KRY,KAZ,BEL")
            ),
            Language(
                name = "Arabic",
                R.drawable.img_2,
                2300,
                listOf("SA,QAT,YE,BAA,SRY,IOR")
            ),
            Language(
                name = "Chinese",
                R.drawable.img_3,
                2000012,
                listOf("CHINA,VIET,TAI,SHR")
            ),
            Language(
                name = "Japanese",
                R.drawable.img_4,
                3324154,
                listOf("JAP")
            ),
            Language(
                name = "Korean",
                R.drawable.img_5,
                456,
                listOf("KOR")
            ),
            Language(
                name = "Uzbek",
                R.drawable.img_6,
                36000,
                listOf("Uz, KRY")
            ),
        )
    }
}