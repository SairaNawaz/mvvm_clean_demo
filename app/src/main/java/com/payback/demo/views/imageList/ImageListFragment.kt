package com.payback.demo.views.imageList

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.payback.demo.R
import com.payback.demo.databinding.FragmentImageListBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ImageListFragment : Fragment() {
    private val viewModel: ImageListViewModel by viewModels()

    @Inject
    lateinit var adapter: ImagesListAdapter

    private var _binding: FragmentImageListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_image_list, container, false
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.recyclerView.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.search_query.observe(viewLifecycleOwner) {
            viewModel.getImages()
        }

        viewModel.data.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        adapter.clickListener.onItemClick = {
            activity?.let { it1 ->
                AlertDialog.Builder(it1)
                    .setTitle(getString(R.string.dialog_title))
                    .setMessage(getString(R.string.dialog_message))
                    .setCancelable(false)
                    .setPositiveButton(getString(R.string.dialog_positive)) { dialog: DialogInterface, _: Int ->
                        dialog.dismiss()
                        findNavController().navigate(
                            ImageListFragmentDirections.actionImagesListToImageDetails(
                                it.id!!
                            )
                        )
                    }
                    .setNegativeButton(getString(R.string.dialog_negative)) { dialog: DialogInterface, _: Int ->
                        dialog.dismiss()
                    }
                    .show()
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.recyclerView.adapter = null
        _binding = null
    }

}
