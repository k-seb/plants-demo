package com.seba.plantsorganizer.presentation.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.seba.plantsorganizer.R
import com.seba.plantsorganizer.core.constants.C

sealed class Screen(
    val route: String,
    @StringRes val stringId: Int,
    @DrawableRes val drawableId: Int
) {
    data object Home : Screen(C.HOME_ROUTE, R.string.tab_home, R.drawable.ic_flower)
    data object FavouritesList :
        Screen(C.FAV_ROUTE, R.string.tab_favourites, R.drawable.ic_favourite)
}
