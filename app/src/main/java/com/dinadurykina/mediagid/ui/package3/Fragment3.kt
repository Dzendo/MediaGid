package com.dinadurykina.mediagid.ui.package3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dinadurykina.mediagid.databinding.Fragment3Binding
import com.dinadurykina.mediagid.ui.Play
import com.dinadurykina.mediagid.ui.package4.ViewModel4

class Fragment3 : Fragment() {

    private var _binding: Fragment3Binding? = null

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

        _binding = Fragment3Binding.inflate(inflater, container, false)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button01.setOnClickListener {
            Play.play("s_03_01")
        }
        binding.button02.setOnClickListener {
            Play.play("s_03_02")
        }
        binding.button03.setOnClickListener {
            Play.play("s_03_03")
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