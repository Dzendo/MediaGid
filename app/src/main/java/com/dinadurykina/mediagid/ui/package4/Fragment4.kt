package com.dinadurykina.mediagid.ui.package4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dinadurykina.mediagid.databinding.Fragment4Binding

import com.dinadurykina.mediagid.ui.Play

class Fragment4 : Fragment() {

    private var _binding: Fragment4Binding? = null

    // This property is only valid between onCreateView and onDestroyView.
    // Это свойство действует только между onCreateView и onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel4 =
            ViewModelProvider(this).get(ViewModel4::class.java)

        _binding = Fragment4Binding.inflate(inflater, container, false)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button01.setOnClickListener {
            Play.play("s_04_01")
        }
        binding.buttonSZvon.setOnClickListener {
            Play.play("zvon")
        }
        binding.button02.setOnClickListener {
            Play.play("s_04_02")
        }
        binding.button03.setOnClickListener {
            Play.play("s_04_03")
        }
        binding.button04.setOnClickListener {
            Play.play("s_04_04")
        }

        binding.buttonZvon.setOnClickListener {
            Play.play("zvon")
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        Play.stop()
    }
}