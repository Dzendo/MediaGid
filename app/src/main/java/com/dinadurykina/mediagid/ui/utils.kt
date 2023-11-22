package com.dinadurykina.mediagid.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.media.MediaPlayer

@SuppressLint("StaticFieldLeak")
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

        /*
           val afd = assets.openFd("1_1_rus.mp3")
           val player = MediaPlayer()
           player.setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
           player.prepare()
           player.start()
           */
        /*
        val resID = resources.getIdentifier("rus_1_1", "raw", packageName)
        val mediaPlayer = MediaPlayer.create(this, resID)
        mediaPlayer.start()
        */

}

