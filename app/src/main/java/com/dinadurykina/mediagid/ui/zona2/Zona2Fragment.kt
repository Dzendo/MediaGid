package com.dinadurykina.mediagid.ui.zona2

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dinadurykina.mediagid.databinding.FragmentZona2Binding
import com.dinadurykina.mediagid.ui.Play

class Zona2Fragment : Fragment() {

    private var _binding: FragmentZona2Binding? = null

    // This property is only valid between onCreateView and onDestroyView.
    // Это свойство действует только между onCreateView и onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val zona2ViewModel =
            ViewModelProvider(this).get(Zona2ViewModel::class.java)

        _binding = FragmentZona2Binding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val textView: TextView = binding.textZona2
        zona2ViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonTop.setOnClickListener {
            Play.play("rus_2_1")
            /*val resID = resources.getIdentifier("rus_2_1", "raw", activity?.packageName ?:"com.dinadurykina.mediagid" )
            val mediaPlayer = MediaPlayer.create(activity, resID)
            mediaPlayer.start()

             */
        }
        binding.buttonBottom.setOnClickListener {
            Play.play("rus_2_2")
            /*val resID = resources.getIdentifier("rus_2_2", "raw", activity?.packageName ?:"com.dinadurykina.mediagid" )
            val mediaPlayer = MediaPlayer.create(activity, resID)
            mediaPlayer.start()

             */
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}