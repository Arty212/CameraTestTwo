package com.example.arty212.cameratesttwo


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_image.*

class ImageActivity : AppCompatActivity() {

    companion object {
        const val DESCRIPTION_KEY = "DESCRIPTION_KEY"
        const val IMAGE_KEY = "IMAGE_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        imageImage.setImageBitmap(intent.getParcelableExtra(IMAGE_KEY))
        textDescription.text = intent.getStringExtra(DESCRIPTION_KEY)
    }
}
