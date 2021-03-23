package com.example.reddit_wombat.data.remote.mapper

import com.example.reddit_wombat.domain.model.Transaction
import javax.inject.Inject

class TransactionMapper @Inject constructor() : Mapper<NetworkTransaction, Transaction> {

    override fun map(origin: NetworkTransaction?): Transaction {
        return origin?.let {
            Transaction(
                it.result,
                it.time
            )
        } ?: Transaction()
    }
}