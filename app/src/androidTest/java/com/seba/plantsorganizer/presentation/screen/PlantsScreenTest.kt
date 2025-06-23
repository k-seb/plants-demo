package com.seba.plantsorganizer.presentation.screen

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.seba.plantsorganizer.MainActivity
import org.junit.Rule
import org.junit.Test

class PlantsScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun bottomNavigation_displaysTabs() {
        composeTestRule
            .onNodeWithText("Plants")
            .assertIsDisplayed()
    }

    @Test
    fun defaultTab_showsEmptyListMessageWhenNoPlants() {
        composeTestRule
            .onNodeWithText("Oh no, it seems like you don\'t have any plants yet…")
            .assertIsDisplayed()
    }

    @Test
    fun bottomNavigation_canNavigateToAnotherTab() {
        composeTestRule
            .onNodeWithText("Favourites")
            .performClick()

        composeTestRule
            .onNodeWithText("You don\'t like your plants? Go and add heart on some!")
            .assertIsDisplayed()
    }
}
