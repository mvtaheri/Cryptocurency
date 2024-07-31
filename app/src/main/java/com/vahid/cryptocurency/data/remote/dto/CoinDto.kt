package com.vahid.cryptocurency.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.vahid.cryptocurency.domain.model.Coin
import kotlin.jvm.internal.Ref.BooleanRef

data class CoinDto(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}
