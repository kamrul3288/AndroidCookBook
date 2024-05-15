package com.iamkamrul.material

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import coil.load
import com.google.android.material.tabs.TabLayoutMediator
import com.iamkamrul.material.databinding.FragmentViewpagerCarouselBinding
import com.iamkamrul.material.databinding.ItemCarouselSliderBinding
import com.iamkamrul.ui.base.BaseFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.abs

class ViewPagerCarouselFragment : BaseFragment<FragmentViewpagerCarouselBinding>() {
    override fun viewBindingLayout(): FragmentViewpagerCarouselBinding =
        FragmentViewpagerCarouselBinding.inflate(layoutInflater)

    private lateinit var adapter: ViewPagerCarouselAdapter

    override fun initializeView(savedInstanceState: Bundle?) {
        val images = listOf(
            "https://media.defense.gov/2021/Sep/17/2002856354/-1/-1/0/210911-Z-DY403-9158.JPG",
            "https://images05.military.com/sites/default/files/media/equipment/military-aircraft/f-22-raptor/2014/02/f-22-raptor_006.jpg",
            "https://www.lockheedmartin.com/content/dam/lockheed-martin/aero/photo/f22/514th%20FTS%20F-22%20at%20Hill%20AFB,%20Utah_March%2022,%202021_(U.S.%20Air%20Force%20photo%20by%20Alex%20R.%20Lloyd)(2).jpg"
        )
        adapter = ViewPagerCarouselAdapter(images)
        binding.imageSlider.setPageTransformer(ZoomOutPageTransformer())
        binding.imageSlider.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.imageSlider) { _, _ -> }.attach()
        startImageAutoSliding()
    }

    private fun startImageAutoSliding(){
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            while (isActive){
                delay(5000)
                val nextIndex = (binding.imageSlider.currentItem + 1) % adapter.itemCount
                withContext(Dispatchers.Main){
                    binding.imageSlider.currentItem = nextIndex
                }
            }
        }
    }
}


private class ViewPagerCarouselAdapter(
    private val images: List<String>
) : RecyclerView.Adapter<ViewPagerCarouselAdapter.ImageViewHolder>(){

    inner class ImageViewHolder(val biding: ItemCarouselSliderBinding) : RecyclerView.ViewHolder(biding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(ItemCarouselSliderBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int  = images.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.biding.sliderImage.load(images[position]){
            crossfade(true)
        }
    }
}

private const val MIN_SCALE = 0.85f
private const val MIN_ALPHA = 0.5f

private class ZoomOutPageTransformer : ViewPager2.PageTransformer {
    override fun transformPage(view: View, position: Float) {
        view.apply {
            val pageWidth = width
            val pageHeight = height
            when {
                position < -1 -> { // [-Infinity,-1)
                    // This page is way off-screen to the left.
                    alpha = 0f
                }
                position <= 1 -> { // [-1,1]
                    // Modify the default slide transition to shrink the page as well.
                    val scaleFactor = MIN_SCALE.coerceAtLeast(1 - abs(position))
                    val vertMargin = pageHeight * (1 - scaleFactor) / 2
                    val horzMargin = pageWidth * (1 - scaleFactor) / 2
                    translationX = if (position < 0) {
                        horzMargin - vertMargin / 2
                    } else {
                        horzMargin + vertMargin / 2
                    }

                    // Scale the page down (between MIN_SCALE and 1).
                    scaleX = scaleFactor
                    scaleY = scaleFactor

                    // Fade the page relative to its size.
                    alpha = (MIN_ALPHA +
                            (((scaleFactor - MIN_SCALE) / (1 - MIN_SCALE)) * (1 - MIN_ALPHA)))
                }
                else -> { // (1,+Infinity]
                    // This page is way off-screen to the right.
                    alpha = 0f
                }
            }
        }
    }
}