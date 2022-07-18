package com.sirius.test_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.sirius.test_app.databinding.ActivityMainBinding
import kotlin.properties.Delegates
import androidx.recyclerview.widget.LinearLayoutManager
import kotlin.math.roundToInt
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private var dataModel = DataModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        headerImageLoader()
        iconImageLoader()
        headerTextLoader()
        gradeLoader()
        initRatingRecyclers()
        initTagsRecycler()
        descriptionLoader()
        ratingLoader()
        initReviewsRecycler()
    }
    private fun headerImageLoader(){
        Glide.with(this)
            .load(dataModel.image)
            .optionalFitCenter()
            .centerCrop()
            .into(binding.headerImageView)
    }
    private fun iconImageLoader(){
        Glide.with(this)
            .load(dataModel.logo)
            .optionalFitCenter()
            .centerCrop()
            .into(binding.GameIcon)
    }
    private fun headerTextLoader(){
        binding.gameHeaderTextView.text = dataModel.name
    }
    private fun gradeLoader(){
        binding.numberOfReviews.text = dataModel.gradeCnt
    }
    private fun descriptionLoader(){
        binding.descriptionTextView.text = dataModel.description
    }
    private fun ratingLoader(){
        binding.ratingTextView.text = dataModel.rating.toString()
    }
    private fun initRatingRecyclers() {
        with(binding.ratingRecyclerView) {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)

            adapter = RatingRecyclerViewAdapter(dataModel.rating.roundToInt())
        }

        with(binding.secondRatingRecyclerView) {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)

            adapter = RatingRecyclerViewAdapter(dataModel.rating.roundToInt())
        }
    }

    private fun initTagsRecycler() {
        with(binding.tagsRecyclerView) {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)

            adapter = TagsRecyclerViewAdapter(dataModel.tags)
        }
    }
    private fun initReviewsRecycler() {
        with(binding.reviewsRecyclerView) {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)

            adapter = ReviewsRecyclerViewAdapter(dataModel.reviews)
        }
    }
}
