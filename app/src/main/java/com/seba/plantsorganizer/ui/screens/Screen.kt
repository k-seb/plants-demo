package com.seba.plantsorganizer.ui.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.seba.plantsorganizer.R
import com.seba.plantsorganizer.ui.core.C.Companion.FAV_ROUTE
import com.seba.plantsorganizer.ui.core.C.Companion.HOME_ROUTE

sealed class Screen(
    val route: String,
    @StringRes val stringId: Int,
    @DrawableRes val drawableId: Int
) {
    object Home : Screen(HOME_ROUTE, R.string.tab_home, R.drawable.ic_flower)
    object FavouritesList : Screen(FAV_ROUTE, R.string.tab_favourites, R.drawable.ic_favourite)
}
