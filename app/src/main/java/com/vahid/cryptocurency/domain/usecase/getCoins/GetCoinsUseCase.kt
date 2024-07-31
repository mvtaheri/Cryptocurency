package com.vahid.cryptocurency.domain.usecase.getCoins

import com.vahid.cryptocurency.common.Resource
import com.vahid.cryptocurency.data.remote.dto.toCoin
import com.vahid.cryptocurency.domain.model.Coin
import com.vahid.cryptocurency.domain.repository.Coinrepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: Coinrepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}