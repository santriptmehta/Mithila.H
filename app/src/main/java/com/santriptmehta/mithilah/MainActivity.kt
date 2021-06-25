package com.santriptmehta.mithilah

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.drawerlayout.widget.DrawerLayout

class MainActivity : AppCompatActivity() {
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkConnectivity()



        val  progressBar: ProgressBar = findViewById(R.id.ProgreeBar)
        val myWebView: WebView = findViewById(R.id.webview)


        myWebView.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url:String?): Boolean {
             view?.loadUrl(url)
                return true
             }
        }


        myWebView.settings.javaScriptEnabled=true
        myWebView.settings.allowContentAccess=true
        myWebView.settings.domStorageEnabled=true
        myWebView.settings.useWideViewPort=true
        myWebView.settings.setAppCacheEnabled(true)
        myWebView.webViewClient = object : WebViewClient(){
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressBar.visibility = View.GONE
                myWebView.visibility= View.VISIBLE
            }
        }
        myWebView.loadUrl("https://www.mithilaheritage.com/")


        




    }
    //Web View//

    // Connectivity Check//
    private fun checkConnectivity(){
        val manager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = manager.activeNetworkInfo

        if(null == activeNetwork){
            val dialogBuilder = AlertDialog.Builder(this)
            val intent = Intent(this, MainActivity::class.java)

            dialogBuilder.setMessage("यहाँ पृथ्वी खतरे में है,और आप Internet बंद किये हुए है | दुष्ट पापि निर्लज्ज")
                .setCancelable(false)
                .setPositiveButton("Retry", DialogInterface.OnClickListener{dialog, id ->
                    recreate()
                })
                .setNegativeButton("Cancel", DialogInterface.OnClickListener{dialog, id ->
                    finish()
                })

            val alert = dialogBuilder.create()
            alert.setTitle("No Internet Connection")
            alert.setIcon(R.mipmap.ic_launcher)
            alert.show()
        }

    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.blogs ->{
                Toast.makeText(this,"Its Blog",Toast.LENGTH_LONG).show()
                return true
            }
            R.id.lit_book ->{
                Toast.makeText(this,"Its litrature Book",Toast.LENGTH_LONG).show()
                return true
            }R.id.fashion ->{
                Toast.makeText(this,"Its Fashion",Toast.LENGTH_LONG).show()
                return true
            }R.id.connect ->{
                Toast.makeText(this,"Its Connect",Toast.LENGTH_LONG).show()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }





}
