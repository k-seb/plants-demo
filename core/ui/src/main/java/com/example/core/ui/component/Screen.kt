package com.example.core.ui.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.seba.plantsorganizer.core.constants.C
import com.seba.plantsorganizer.core.ui.R

sealed class Screen(
    val route: String,
    @StringRes val stringId: Int,
    @DrawableRes val drawableId: Int
) {
    data object Home : Screen(C.HOME_ROUTE, R.string.tab_home, R.drawable.ic_flower)
    data object FavouritesList :
        Screen(C.FAV_ROUTE, R.string.tab_favourites, R.drawable.ic_favourite)
}
