package io.pavelshackih.yandextranslator.presentation.main

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import io.pavelshackih.yandextranslator.R
import io.pavelshackih.yandextranslator.ext.app.AppActivity

class MainActivity : AppActivity(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
