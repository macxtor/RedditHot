package com.example.reddit_wombat.data.repository

import com.example.reddit_wombat.data.remote.api.RedditApi
import com.example.reddit_wombat.data.remote.mapper.Mapper
import com.example.reddit_wombat.data.remote.model.NetworkSubmissions
import com.example.reddit_wombat.data.toNetworkResult
import com.example.reddit_wombat.data.util.NetworkResultHandler
import com.example.reddit_wombat.domain.model.Submissions
import com.example.reddit_wombat.domain.repository.RedditRepository
import javax.inject.Inject

class RedditRepositoryImpl @Inject constructor(
    private val redditApi: RedditApi,
    private val multiAddressMapper: Mapper<NetworkSubmissions, Submissions>,
    private val networkResultHandler: NetworkResultHandler
) : RedditRepository {


    override fun getHotSubmissions(): = redditApi
        .getHotSubmissions()
        .map { multiAddressMapper.map(it) }
        .toNetworkResult(networkResultHandler)

}