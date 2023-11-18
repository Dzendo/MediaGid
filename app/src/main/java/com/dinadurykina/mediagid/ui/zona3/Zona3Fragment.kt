package com.dinadurykina.mediagid.ui.zona3

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dinadurykina.mediagid.databinding.FragmentZona3Binding

class Zona3Fragment : Fragment() {

    private var _binding: FragmentZona3Binding? = null

    // This property is only valid between onCreateView and onDestroyView.
    // Это свойство действует только между onCreateView и onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val zona3ViewModel =
            ViewModelProvider(this).get(Zona3ViewModel::class.java)

        _binding = FragmentZona3Binding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val textView: TextView = binding.textZona3
        zona3ViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonTop.setOnClickListener {

            val resID = resources.getIdentifier("eng_1_1", "raw", activity?.packageName ?:"com.dinadurykina.mediagid" )
            val mediaPlayer = MediaPlayer.create(activity, resID)
            mediaPlayer.start()
        }
        binding.buttonBottom.setOnClickListener {
            val resID = resources.getIdentifier("eng_1_2", "raw", activity?.packageName ?:"com.dinadurykina.mediagid" )
            val mediaPlayer = MediaPlayer.create(activity, resID)
            mediaPlayer.start()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}