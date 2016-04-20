package com.test.demo;

import android.content.Intent;
import android.net.Uri;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.test.suitebuilder.annotation.MediumTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasData;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;


/**
 * Created by quhong on 16/4/20.
 */
@RunWith(JUnit4.class)
@MediumTest
public class PhoneNumTest {

    @Rule
    public IntentsTestRule<PhoneActivity> mActivityRule = new IntentsTestRule<>(PhoneActivity.class);

    public String VALID_PHONE_NUMBER;
    public Uri INTENT_DATA_PHONE_NUMBER;

    @Before
    public void setUp() throws Exception {
        VALID_PHONE_NUMBER = "10085";
        INTENT_DATA_PHONE_NUMBER = Uri.parse("tel:"+VALID_PHONE_NUMBER);
    }

    @Test
    public void typeNumber_ValidInput_InitiatesCall() {
        onView(withId(R.id.etPhone)).perform(typeText(VALID_PHONE_NUMBER),
                closeSoftKeyboard());
        onView(withId(R.id.btnCall)).perform(click());

        intended(allOf(
                hasAction(is(equalTo(Intent.ACTION_CALL))),
                hasData(equalTo(INTENT_DATA_PHONE_NUMBER))
                ));
    }

}
