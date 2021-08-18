package com.example.wingstask

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val productCode: String,
    val productName: String,
    val price: Int,
    val currency: String,
    val discount: Int,
    val dimension: String,
    val unit: String
) : Parcelable

data class TransactionHeader(
    val documentCode: String,
    val documentNumber: String,
    val user: String,
    val total: Int,
    val date: String
)

data class TransactionDetail(
    val documentCode: String,
    val documentNumber: String,
    val productCode: String,
    val price: Int,
    val quantity: Int,
    val unit: String,
    val subTotal: Int,
    val currency: String
)