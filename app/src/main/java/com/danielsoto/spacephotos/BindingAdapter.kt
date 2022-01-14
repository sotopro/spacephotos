package com.danielsoto.spacephotos

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.danielsoto.spacephotos.network.Photo
import com.danielsoto.spacephotos.overview.ApiStatus
import com.danielsoto.spacephotos.overview.PhotoGridAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Photo>?) {
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_baseline_broken_image_24)
        }
    }
}

@BindingAdapter("ApiStatus")
fun bindStatus(statusImageView: ImageView, status: ApiStatus?) {
    when (status) {
        ApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        ApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_baseline_cloud_off_24)
        }
        ApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}