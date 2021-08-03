package com.example.appliedvrcodechallenge

import org.junit.Rule

open class BaseRxTest {
    @Rule
    @JvmField
    val rxSchedulersRule: RxSchedulersRule = RxSchedulersRule()
}
