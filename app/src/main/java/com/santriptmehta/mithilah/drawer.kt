package com.santriptmehta.mithilah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat

import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class drawer : AppCompatActivity() {
    lateinit var drawerlayout : DrawerLayout
    lateinit var progressBar: ProgressBar
    lateinit var mywebView : WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)

        mywebView = findViewById(R.id.webview)
        progressBar = findViewById(R.id.ProgreeBar)
        drawerlayout = findViewById(R.id.drawer_layout)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navigationView: NavigationView = findViewById(R.id.navigation_view)
        val drawerToggle = ActionBarDrawerToggle(this,drawerlayout,toolbar,R.string.open,R.string.close)
        drawerlayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId){
                R.id.blog_d ->{
                    Toast.makeText(this,"This is Blog",Toast.LENGTH_LONG).show()
                }
                R.id.lit_book_d ->{
                    Toast.makeText(this,"This is Book",Toast.LENGTH_LONG).show()
                }
                R.id.fashion_d ->{
                    Toast.makeText(this,"This is fashion",Toast.LENGTH_LONG).show()
                }
                R.id.lit_book_d ->{
                    Toast.makeText(this,"This is Books",Toast.LENGTH_LONG).show()
                }
            }
            drawerlayout.closeDrawer(GravityCompat.START)
            true

        }
    }
}