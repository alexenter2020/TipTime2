package com.example.tiptime

import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test
import com.example.tiptime.ui.theme.TipTimeTheme
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import java.text.NumberFormat


class TipUITests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            TipTimeTheme() {
                TipTimeLayout()
            }
        }
        composeTestRule.onNodeWithText(
            text = "Bill Amount",
            ignoreCase = true
        ).performTextInput("10")
        composeTestRule.onNodeWithText(
            text = "Tip Percentage",
            ignoreCase = true
        ).performTextInput("20")
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        composeTestRule.onNodeWithText(
            text = "Tip Amount: $expectedTip",
            ignoreCase = true
        ).assertExists(
            "No node with this text was found."
        )
    }
}