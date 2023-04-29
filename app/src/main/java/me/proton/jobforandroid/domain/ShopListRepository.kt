package me.proton.jobforandroid.domain

interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)

    fun deleteShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getShopItem(shopItem: Int): ShopItem

    fun getShopList(): List<ShopItem>

}