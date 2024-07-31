package com.vahid.cryptocurency.data.repository

import com.vahid.cryptocurency.data.remote.CoinApi
import com.vahid.cryptocurency.data.remote.dto.CoinDetailDto
import com.vahid.cryptocurency.data.remote.dto.CoinDto
import com.vahid.cryptocurency.domain.repository.Coinrepository
import javax.inject.Inject

class CoinRepositoryImp @Inject constructor(
    private val api: CoinApi
) : Coinrepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}