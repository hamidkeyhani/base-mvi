package com.fourplay.common.utils

enum class TaraftarPlusLanguage(val deviceLang: String, val neededLang: String) {
    TURKISH("tr", "tr"), ENGLISH("en", "en-us");

//    companion object {
//        fun getTaraftarPlusSharedUrl(lang: String, campaignId: String): String {
//            val selectedLang = when (lang) {
//                ENGLISH.deviceLang -> ENGLISH.neededLang
//                TURKISH.deviceLang -> TURKISH.neededLang
//                else -> ENGLISH.neededLang
//            }
//            return "https://nevita-git-dev-solidfe.vercel.app/$selectedLang/campaigns/$campaignId"
//        }
//    }
}