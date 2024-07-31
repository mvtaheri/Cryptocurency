package com.vahid.cryptocurency.presentation.coinDetail

import com.vahid.cryptocurency.domain.model.Coin
import com.vahid.cryptocurency.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
