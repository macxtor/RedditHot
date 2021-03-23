package com.example.reddit_wombat.data.remote.mapper

import com.example.reddit_wombat.domain.model.Transaction
import javax.inject.Inject

class TransactionListMapper @Inject constructor(
    private val transactionMapper: Mapper<NetworkTransaction, Transaction>
) : Mapper<List<NetworkTransaction>, List<Transaction>> {

    override fun map(origin: List<NetworkTransaction>?): List<Transaction> {
        return origin?.let {
            it.map { txs -> transactionMapper.map(txs) }
        } ?: emptyList()
    }
}