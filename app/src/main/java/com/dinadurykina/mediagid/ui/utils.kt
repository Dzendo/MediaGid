package com.dinadurykina.mediagid.ui

import android.app.Activity
import android.media.MediaPlayer

object Play {
    lateinit var  mediaPlayer : MediaPlayer
    lateinit var activity: Activity
    lateinit var name: String

    fun init(activity: Activity) {
        this.activity = activity
        this.name = ""

    }
    fun play(name:String) {
        if (this.name != name) {
            if (this.name!="") {   //  if (mediaPlayer.isPlaying)
               mediaPlayer.stop()
               mediaPlayer.reset()
            }

            val resID = activity.resources.getIdentifier(
                name,
                "raw",
                activity.packageName
            )
            mediaPlayer = MediaPlayer.create(activity, resID)
            mediaPlayer.start()
            this.name = name
        }  else {
            if (mediaPlayer.isPlaying) mediaPlayer.pause()
                else mediaPlayer.start()
        }
    }
}

