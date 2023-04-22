package com.example.instanote
import android.net.Uri
import android.widget.VideoView
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.drawable.activity_splash)

        val videoView: VideoView = findViewById(R.id.videoView)
        val videoUri = "android.resource://" + packageName + "/" + R.raw.logo
        videoView.setVideoURI(Uri.parse(videoUri))
        videoView.setOnPreparedListener { mp -> mp.isLooping = true }
        videoView.start()

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 2000) // 2000 milliseconds = 2 seconds
    }
}