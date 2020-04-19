package com.toyyibat.myprofile

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var colorCode: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title = ("My Profile")
        setSupportActionBar(toolbar)


        appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, i ->

            colorCode = -i
            if (colorCode > 255) colorCode = 255

            toolbar.background.alpha = colorCode
            toolbar.alpha = colorCode / 256f

        })
//        val viewbio = findViewById<ImageView>(R.id.logoId)
//        viewbio.setOnClickListener {
//            val intent = Intent(this, MainActivity).apply {
//                startActivity(this)
//            }
//        }

        val emailme = findViewById<ImageView>(R.id.logoId)
        emailme.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:toyyibat.abdulkareem@gmail.com") // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, "")
            intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback")
            startActivity(intent)

        }
        val github = findViewById<ImageView>(R.id.githubId)
        github.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://github.com/toyyibat1")
            startActivity(intent)
        });
        val linkedIn = findViewById<ImageView>(R.id.linkedInId)
        linkedIn.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.linkedin.com/in/toyyibat1")
            startActivity(intent)
        })
    }

    override fun onStart() {
        super.onStart()
        Log.d("onStart", "This activity is in onStart state")
    }

    override fun onResume() {
        super.onResume()
        Log.d("onResume", "This activity is in onResume state")
    }

    override fun onPause() {
        super.onPause()
        Log.d("onPause", "This activity is in onPause state")
    }

    override fun onStop() {
        super.onStop()
        Log.d("onStop", "This activity is in onStop state")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("onRestart", "This activity is in onRestart state")
    }
}

