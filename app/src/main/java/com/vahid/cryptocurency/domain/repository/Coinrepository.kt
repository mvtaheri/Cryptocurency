package com.vahid.cryptocurency.domain.repository

import com.vahid.cryptocurency.data.remote.dto.CoinDetailDto
import com.vahid.cryptocurency.data.remote.dto.CoinDto

interface Coinrepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto

}