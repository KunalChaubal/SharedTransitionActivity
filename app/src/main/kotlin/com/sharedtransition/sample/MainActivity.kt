package com.sharedtransition.sample

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Pair
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cardView.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)

            val pairImage = Pair<View, String>(imageView, resources.getString(R.string.transition_image))
            val pairTitle = Pair<View, String>(tv_title, resources.getString(R.string.transition_title))
            val pairDesc = Pair<View, String>(tv_desc, resources.getString(R.string.transition_body))
            val pairBack = Pair<View, String>(cardView, resources.getString(R.string.transition_container))

            val activityOptions = ActivityOptions.makeSceneTransitionAnimation(this, pairImage, pairTitle, pairDesc, pairBack)
            startActivity(intent, activityOptions.toBundle())
        }
    }
}