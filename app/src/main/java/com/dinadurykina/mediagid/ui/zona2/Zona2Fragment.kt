package com.dinadurykina.mediagid.ui.zona2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dinadurykina.mediagid.R
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

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonTop.setOnClickListener {
            Play.play("sound_2_1")
        }
        binding.buttonBottom.setOnClickListener {
            Play.play("sound_2_2")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}