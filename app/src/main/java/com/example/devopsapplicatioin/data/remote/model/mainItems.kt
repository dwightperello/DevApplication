package com.example.devopsapplicatioin.data.remote.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class mainItems(
    val description: String?,
    val id: Int,
    val items: List<Item>,
    val name: String
): Parcelable

@Parcelize
data class Item(
    val description: String?= null,
    val imageUrl: String,
    val imageUrlThree: String?= null,
    val imageUrlTwo: String?= null,
    val isAvailable: Boolean,
    val itemColors: List<ItemColor>,
    val itemSizes: List<ItemSize>,
    val name: String
): Parcelable

@Parcelize
data class ItemColor(
    val color: String
): Parcelable

@Parcelize
data class ItemSize(
    val price: Double,
    val size: String
): Parcelable