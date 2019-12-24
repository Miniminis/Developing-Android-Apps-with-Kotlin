package com.example.android.dessertpusher

import android.app.Application
import timber.log.Timber

/**
 * Created by Mayokun Adeniyi on 2019-10-25.
 */

/*
* Application class 를 상속받아, 해당 앱의 전체 범위에서 동작할 내용들을 정의할 수 있다.
* Timber 같은 경우는 어플리케이션 어디에서나 로그를 작성할 것이므로 어플리케이션 클래스에 정의하였다.
* */

class PusherApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        /* timber library : log 를 보다 쉽게 작성할 수 있도록 도와줌 */
    }
}