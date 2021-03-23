package com.example.reddit_wombat.data.remote.mapper

import com.example.reddit_wombat.data.remote.model.NetworkMultiAddress
import com.example.reddit_wombat.domain.model.MultiAddress
import com.example.reddit_wombat.domain.model.Transaction
import com.example.reddit_wombat.domain.model.Wallet
import javax.inject.Inject

class MultiAddressMapper @Inject constructor(
    private val walletMapper: Mapper<NetworkWallet, Wallet>,
    private val transactionListMapper: Mapper<List<NetworkTransaction>, List<Transaction>>
) : Mapper<NetworkMultiAddress, MultiAddress> {

    override fun map(origin: NetworkMultiAddress?): MultiAddress {
        return origin?.let {
            MultiAddress(
                walletMapper.map(it.wallet),
                transactionListMapper.map(it.txs)
            )
        } ?: MultiAddress()
    }
}