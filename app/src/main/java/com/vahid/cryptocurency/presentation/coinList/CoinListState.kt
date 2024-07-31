package com.vahid.cryptocurency.presentation.coinList

import com.vahid.cryptocurency.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
