package com.example.reddit_wombat.data.remote.mapper

interface Mapper<O, R> {

    fun map(origin: O?): R
}