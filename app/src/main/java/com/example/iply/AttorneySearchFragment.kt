package com.example.iply

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AttorneySearchFragment : Fragment() {

    private lateinit var searchResultsAdapter: AttorneyAdapter
    private lateinit var searchQueryEditText: EditText
    private lateinit var searchButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_attorney_search, container, false)

        // RecyclerView 설정
        val rvSearchResults = view.findViewById<RecyclerView>(R.id.rv_search_results)
        rvSearchResults.layoutManager = GridLayoutManager(requireContext(), 2)
        searchResultsAdapter = AttorneyAdapter(getDummyattorneys())
        rvSearchResults.adapter = searchResultsAdapter

        // 검색 바와 버튼 설정
        searchQueryEditText = view.findViewById(R.id.et_search_query)
        searchButton = view.findViewById(R.id.btn_search)

        // 검색 버튼 클릭 리스너
        searchButton.setOnClickListener {
            val query = searchQueryEditText.text.toString()
            if (!TextUtils.isEmpty(query)) {
                performSearch(query)
            }
        }

        return view
    }

    private fun performSearch(query: String) {
        val filteredList = getDummyattorneys().filter { it.name.contains(query, ignoreCase = true) }
        searchResultsAdapter.updateData(filteredList)
    }

    // Mock 데이터
    private fun getDummyattorneys(): List<Attorney> {
        return listOf(
            Attorney("Smartphone Attorney", R.drawable.ic_placeholder_image),
            Attorney("AI Technology Attorney", R.drawable.ic_placeholder_image),
            Attorney("Healthcare Attorney", R.drawable.ic_placeholder_image),
            Attorney("Renewable Energy Attorney", R.drawable.ic_placeholder_image),
            Attorney("Blockchain Attorney", R.drawable.ic_placeholder_image)
        )
    }
}
