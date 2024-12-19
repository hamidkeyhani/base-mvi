package com.base.common.utils

enum class mviLanguage(val deviceLang: String, val neededLang: String) {
    TURKISH("tr", "tr"), ENGLISH("en", "en-us");

//    companion object {
//        fun getmviSharedUrl(lang: String, campaignId: String): String {
//            val selectedLang = when (lang) {
//                ENGLISH.deviceLang -> ENGLISH.neededLang
//                TURKISH.deviceLang -> TURKISH.neededLang
//                else -> ENGLISH.neededLang
//            }
//            return "https://test.com/$selectedLang/campaigns/$campaignId"
//        }
//    }
}