package com.example.arty212.cameratesttwo

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnPhoto.setOnClickListener {
            if (!editName.text.isEmpty()) {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(intent, 0)
            } else
                Snackbar.make(btnPhoto, "Введи имя!", Snackbar.LENGTH_LONG).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            val photo = data!!.extras.get("data") as Bitmap

            val intent = Intent(this, ImageActivity::class.java)
            intent.putExtra(ImageActivity.IMAGE_KEY, photo)
            intent.putExtra(ImageActivity.DESCRIPTION_KEY, editName.text.toString())
            startActivity(intent)
        }
    }
}
