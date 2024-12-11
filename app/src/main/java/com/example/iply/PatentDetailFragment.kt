package com.example.iply

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.iply.databinding.FragmentPatentDetailBinding

class PatentDetailFragment : Fragment() {

    private var _binding: FragmentPatentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPatentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Bundle로 전달받은 데이터 설정
        val title = arguments?.getString("title")
        val summary = arguments?.getString("summary")
        val applicationDate = arguments?.getString("applicationDate")
        val inventor = arguments?.getString("inventor")

        // View Binding을 통해 데이터 설정
        binding.apply {
            ivPatentImage.setImageResource(R.drawable.ic_placeholder_image)
            tvPatentTitle.text = title ?: "No Title"
            tvPatentSummary.text = summary ?: "No Summary Available"
            tvApplicationDate.text = applicationDate ?: "Unknown Date"
            tvInventor.text = inventor ?: "Unknown Inventor"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
