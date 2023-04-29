package me.proton.jobforandroid.data

import me.proton.jobforandroid.domain.ShopItem
import me.proton.jobforandroid.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository{


    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0

    init {
        for (i in 0 until 10) {
            val item = ShopItem("Name $i", i, true)
        }
    }



    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find {
            it.id == shopItemId } ?: throw IllegalArgumentException("No shop item with id $shopItemId")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }

}