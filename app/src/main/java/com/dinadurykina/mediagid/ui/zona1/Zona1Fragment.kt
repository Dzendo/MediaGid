package com.dinadurykina.mediagid.ui.zona1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dinadurykina.mediagid.databinding.FragmentZona1Binding

class Zona1Fragment : Fragment() {

    private var _binding: FragmentZona1Binding? = null

    // This property is only valid between onCreateView and onDestroyView.
    // Это свойство действует только между onCreateView и onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val zona1ViewModel =
            ViewModelProvider(this).get(Zona1ViewModel::class.java)

        _binding = FragmentZona1Binding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textZona1
        zona1ViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}