package com.example.reddit_wombat.domain.repository

import com.example.reddit_wombat.domain.model.Submissions

interface RedditRepository {

    fun getHotSubmissions(): List<Submissions>
}