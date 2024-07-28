package com.example.devopsapplicatioin.domain.remote.usecase

import com.example.devopsapplicatioin.data.remote.model.Item
import com.example.devopsapplicatioin.data.remote.model.ItemColor
import com.example.devopsapplicatioin.data.remote.model.ItemSize
import com.example.devopsapplicatioin.data.remote.model.mainItems

object sample {

    val sampleMainItems = listOf(
        mainItems(
            description = "Main item description 1",
            id = 1,
            items = listOf(
                Item(
                    description = "Item description 1",
                    imageUrl = "https://example.com/image1.jpg",
                    imageUrlTwo = "https://example.com/image2.jpg",
                    imageUrlThree = "https://example.com/image3.jpg",
                    isAvailable = true,
                    itemColors = listOf(
                        ItemColor(color = "Red"),
                        ItemColor(color = "Blue")
                    ),
                    itemSizes = listOf(
                        ItemSize(price = 29.99, size = "S"),
                        ItemSize(price = 34.99, size = "M")
                    ),
                    name = "Item 1"
                ),
                Item(
                    description = "Item description 2",
                    imageUrl = "https://example.com/image4.jpg",
                    imageUrlTwo = "https://example.com/image5.jpg",
                    imageUrlThree = "https://example.com/image6.jpg",
                    isAvailable = false,
                    itemColors = listOf(
                        ItemColor(color = "Green"),
                        ItemColor(color = "Yellow")
                    ),
                    itemSizes = listOf(
                        ItemSize(price = 39.99, size = "L"),
                        ItemSize(price = 44.99, size = "XL")
                    ),
                    name = "Item 2"
                )
            ),
            name = "Main Item 1"
        ),
        mainItems(
            description = "Main item description 2",
            id = 2,
            items = listOf(
                Item(
                    description = "Item description 3",
                    imageUrl = "https://example.com/image7.jpg",
                    imageUrlTwo = "https://example.com/image8.jpg",
                    imageUrlThree = "https://example.com/image9.jpg",
                    isAvailable = true,
                    itemColors = listOf(
                        ItemColor(color = "Black"),
                        ItemColor(color = "White")
                    ),
                    itemSizes = listOf(
                        ItemSize(price = 49.99, size = "S"),
                        ItemSize(price = 54.99, size = "M")
                    ),
                    name = "Item 3"
                ),
                Item(
                    description = "Item description 4",
                    imageUrl = "https://example.com/image10.jpg",
                    imageUrlTwo = "https://example.com/image11.jpg",
                    imageUrlThree = "https://example.com/image12.jpg",
                    isAvailable = false,
                    itemColors = listOf(
                        ItemColor(color = "Pink"),
                        ItemColor(color = "Purple")
                    ),
                    itemSizes = listOf(
                        ItemSize(price = 59.99, size = "L"),
                        ItemSize(price = 64.99, size = "XL")
                    ),
                    name = "Item 4"
                )
            ),
            name = "Main Item 2"
        )
    )

}