package com.example.react_native_module

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class ReactNativeActivity : Activity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.react_activity)

        val webView = findViewById<WebView>(R.id.webview)

        // Enable JavaScript
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true

        // Load JavaScript bundle from assets
        webView.webViewClient = WebViewClient()
        webView.loadUrl("file:///android_asset/react.html") // If stored locally
    }
}