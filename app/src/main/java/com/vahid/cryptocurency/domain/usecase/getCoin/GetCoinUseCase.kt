package com.vahid.cryptocurency.domain.usecase.getCoin

import com.vahid.cryptocurency.common.Resource
import com.vahid.cryptocurency.data.remote.dto.toCoin
import com.vahid.cryptocurency.data.remote.dto.toCoinDetail
import com.vahid.cryptocurency.domain.model.Coin
import com.vahid.cryptocurency.domain.model.CoinDetail
import com.vahid.cryptocurency.domain.repository.Coinrepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: Coinrepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}