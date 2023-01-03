package com.test.cryptoappproject.api

import com.test.cryptoappproject.pojo.CoinInfoListOfData
import com.test.cryptoappproject.pojo.CoinPriceInfo
import com.test.cryptoappproject.pojo.CoinPriceInfoCoinData
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top/totalvolfull")
    fun getTopCoinsInfo(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = "171d55cac85815bbda4b4fc9af37277f5999f7148b6d6a2b079d7c7dd05d53af",
        @Query(QUERY_PARAM_LIMIT) limit: Int = 10,
        @Query(QUERY_PARAM_TO_SYMBOL) tSym: String = CURRENCY
    ): Single<CoinInfoListOfData>

    @GET("pricemultifull")
    fun getFullPriceList(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = "171d55cac85815bbda4b4fc9af37277f5999f7148b6d6a2b079d7c7dd05d53af",
        @Query(QUERY_PARAM_FROM_SYMBOLS) fSym: String,
        @Query(QUERY_PARAM_TO_SYMBOLS) tSyms: String = CURRENCY
    ): Single<CoinPriceInfoCoinData>

    companion object {
        private const val QUERY_PARAM_API_KEY = "api_key"
        private const val QUERY_PARAM_LIMIT = "limit"
        private const val QUERY_PARAM_TO_SYMBOL = "tsym"
        private const val QUERY_PARAM_TO_SYMBOLS = "tsyms"
        private const val QUERY_PARAM_FROM_SYMBOLS = "fsyms"

        private const val CURRENCY = "Eur"
    }
}