package com.sajal.newspapers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webView = findViewById(R.id.webView)

        // Enable JavaScript (Optional)
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true

        // Ensure links open within the WebView
        webView.webViewClient = WebViewClient()

        // Load your newspaper website URL
        webView.loadUrl("https://www.w3newspapers.com/bangladesh/")
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            showExitConfirmationDialog()
        }
    }

    private fun showExitConfirmationDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("আপনি কি এই অ্যাপটি বন্ধ করতে চান?")
            .setCancelable(false)
            .setPositiveButton("হ্যা") { dialog, id ->
                super.onBackPressed()
            }
            .setNegativeButton("না") { dialog, id ->
                dialog.dismiss()
            }
        val alert = builder.create()
        alert.show()
    }
}
