package com.example.iply

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PatentSearchFragment : Fragment() {

    private lateinit var searchResultsAdapter: PatentAdapter
    private val patentViewModel: PatentViewModel by viewModels()
    private lateinit var searchQueryEditText: EditText
    private lateinit var searchButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_patent_search, container, false)

        // RecyclerView 설정
        val rvSearchResults = view.findViewById<RecyclerView>(R.id.rv_search_results)
        rvSearchResults.layoutManager = GridLayoutManager(requireContext(), 2)
        searchResultsAdapter = PatentAdapter(emptyList()) { patent ->
            // 아이템 클릭 시 상세 페이지로 이동
            val bundle = Bundle().apply {
                putString("title", patent.title)
                putString("summary", patent.summary)
                putString("applicationDate", patent.applicationDate)
                putString("inventor", patent.inventor)
            }
            findNavController().navigate(R.id.action_patentSearchFragment_to_patentDetailFragment, bundle)
        }
        rvSearchResults.adapter = searchResultsAdapter

        // 검색 바와 버튼 설정
        searchQueryEditText = view.findViewById(R.id.et_search_query)
        searchButton = view.findViewById(R.id.btn_search)

        // 검색 버튼 클릭 리스너
        searchButton.setOnClickListener {
            val query = searchQueryEditText.text.toString()
            if (!TextUtils.isEmpty(query)) {
                performSearch(query)
            } else {
                Toast.makeText(requireContext(), "Please enter a search query", Toast.LENGTH_SHORT).show()
            }
        }

        fetchData()

        return view
    }

    private fun performSearch(query: String) {
        patentViewModel.fetchPatents("us", "kettle").observe(viewLifecycleOwner) { patents ->
            val filteredPatents = patents.filter {
                it.title.contains(query, ignoreCase = true) ||
                        it.summary.contains(query, ignoreCase = true)
            }
            if (filteredPatents.isNotEmpty()) {
                searchResultsAdapter.updateData(filteredPatents)
            } else {
                Toast.makeText(requireContext(), "No results found for '$query'", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun fetchData() {
        patentViewModel.fetchPatents("us", "kettle").observe(viewLifecycleOwner) { patents ->
            if (patents.isNotEmpty()) {
                searchResultsAdapter.updateData(patents) // RecyclerView에 데이터 표시
            } else {
                Toast.makeText(requireContext(), "No data available", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Mock 데이터
    private fun getDummyPatents(): List<Patent> {
        return listOf(
            Patent("", "Smartphone Patent", "", "", ""),
            Patent("","AI Technology Patent", "", "", ""),
            Patent("", "Healthcare Patent", "", "", ""),
            Patent("", "Renewable Energy Patent", "", "", ""),
            Patent("", "Blockchain Patent", "", "", "")
        )
    }
}
