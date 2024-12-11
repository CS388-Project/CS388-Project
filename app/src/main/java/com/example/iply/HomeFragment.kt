package com.example.iply

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var popularPatentsAdapter: RecyclerView.Adapter<*>
    private lateinit var popularAttorneysAdapter: RecyclerView.Adapter<*>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 기본 텍스트 확인 로그 추가
        Log.d("HomeFragment", "Home Fragment View Created")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Popular Patents RecyclerView
        val rvPopularPatents = view.findViewById<RecyclerView>(R.id.rv_popular_patents)
        rvPopularPatents.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        popularPatentsAdapter = PopularPatentAdapter(getDummyPatents())
        rvPopularPatents.adapter = popularPatentsAdapter

        // Popular Attorneys RecyclerView
        val rvPopularAttorneys = view.findViewById<RecyclerView>(R.id.rv_popular_attorneys)
        rvPopularAttorneys.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        popularAttorneysAdapter = PopularAttorneyAdapter(getDummyAttorneys())
        rvPopularAttorneys.adapter = popularAttorneysAdapter

        return view
    }

    // Mock Data for Patents
    private fun getDummyPatents(): List<Patent> {
        return listOf(
            Patent("", "Patent 1", "", "", ""),
            Patent("", "Patent 2", "", "", ""),
            Patent("", "Patent 3", "", "", ""),
            Patent("", "Patent 4", "", "", ""),
            Patent("", "Patent 5", "", "", "")
        )
    }

    private fun getDummyAttorneys(): List<Attorney> {
        return listOf(
            Attorney("Attorney A", R.drawable.ic_placeholder_image),
            Attorney("Attorney B", R.drawable.ic_placeholder_image),
            Attorney("Attorney C", R.drawable.ic_placeholder_image),
            Attorney("Attorney D", R.drawable.ic_placeholder_image),
            Attorney("Attorney E", R.drawable.ic_placeholder_image)
        )
    }


}