package com.payback.demo.views.imageDetails

import androidx.databinding.ObservableParcelable
import androidx.lifecycle.ViewModel
import com.payback.demo.domain.ImageListItem
import com.payback.demo.repository.ImageDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ImageDetailsViewModel @Inject constructor(
    private val imageDetailsRepository: ImageDetailsRepository
) : ViewModel() {

    val imageDetails = ObservableParcelable(ImageListItem())
    fun getImageDetails(id: Int) = imageDetailsRepository.getImageDetails(id)
}