package com.payback.demo.views.imageList

import androidx.appcompat.widget.SearchView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.payback.demo.repository.ImageListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageListViewModel @Inject constructor(
    private val imageListRepository: ImageListRepository
) : ViewModel() {

    var search_query = MutableLiveData("fruit")

    fun getImages() = search_query.value?.let {
        viewModelScope.launch(Dispatchers.IO) {
            imageListRepository.refreshImageList(it.trim())
        }
    }

    val data = imageListRepository.getImages(search_query)

    init {
        getImages()
    }

    fun getQueryTextListener(): SearchView.OnQueryTextListener? {
        return object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    search_query.value = query
                };
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //TODO("Not yet implemented")
                if (newText != null && newText.isEmpty()) {
                    search_query.value = ""
                }
                return true
            }
        }
    }
}