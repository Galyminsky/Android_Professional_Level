package me.proton.jobforandroid.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.proton.jobforandroid.data.ShopListRepositoryImpl
import me.proton.jobforandroid.domain.DeleteShopItemUseCase
import me.proton.jobforandroid.domain.EditShopItemUseCase
import me.proton.jobforandroid.domain.GetShopListUseCase
import me.proton.jobforandroid.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)

    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)

    private val editShopItemUseCase = EditShopItemUseCase(repository)


    val shopList = getShopListUseCase.getShopList()


    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled =!shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}