package com.test.demo

import android.Manifest
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasShortClassName
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.GrantPermissionRule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.notNullValue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class PhoneNumTest {

    @Rule
    @JvmField
    var mActivityRule = IntentsTestRule(PhoneActivity::class.java)

    @Rule
    @JvmField
    var permissionRule = GrantPermissionRule.grant(Manifest.permission.CALL_PHONE)

//    var VALID_PHONE_NUMBER: String
//    var INTENT_DATA_PHONE_NUMBER: Uri

    @Before
    fun setUp() {

//        VALID_PHONE_NUMBER = "10085"
//        INTENT_DATA_PHONE_NUMBER = Uri.parse("tel:$VALID_PHONE_NUMBER")
    }

    fun callPhoneTest() {
//        onView(withId(R.id.etPhone)).perform(typeText(VALID_PHONE_NUMBER),
//                closeSoftKeyboard())
//        onView(withId(R.id.btnCall)).perform(click())
//
//        intended(allOf(
//                hasAction(`is`(equalTo(Intent.ACTION_CALL))),
//                hasData(equalTo(INTENT_DATA_PHONE_NUMBER))
//        ))
    }


    @Test
    fun testJump() {
        val applicationContext = (mActivityRule.activity.application as TestApplication).applicationContext

        assertThat(applicationContext, `is`(notNullValue()))
        //        mActivityRule.launchActivity(null);
        onView(withId(R.id.jumpTwo)).perform(click())
        intended(hasComponent(hasShortClassName(".TwoActivity")))
        //        mActivityRule.launchActivity(null);
    }


}
