package io.pavelshackih.yandextranslator.presentation.main

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import io.pavelshackih.yandextranslator.domain.AppLang
import io.pavelshackih.yandextranslator.domain.main.MainInteractor
import io.pavelshackih.yandextranslator.ext.di.inject
import io.pavelshackih.yandextranslator.ext.mvp.AppPresenter
import io.pavelshackih.yandextranslator.ext.rx.RxScheduler
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit

@InjectViewState
class MainPresenter : AppPresenter<MainView>() {

    private val interactor by inject<MainInteractor>()
    private val rxScheduler by inject<RxScheduler>()

    private val viewModel = ViewModel(languages = AppLang.values().toList())
    private val subject: PublishSubject<CharSequence> = PublishSubject.create()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setModel(viewModel)

        subject.debounce(500, TimeUnit.MILLISECONDS)
                .flatMapSingle { interactor.translate(viewModel.fromLang, viewModel.toLang, it.toString()) }
                .subscribeOn(rxScheduler.getNetwork())
                .observeOn(rxScheduler.getMain())
                .subscribe({
                    viewState.setTranslations(it.variants)
                }, { t ->
                    Log.e(TAG, "Error while getting translation", t)
                })
    }

    fun onSwitchClick() {
        viewModel.switch()
    }

    fun onTextChanged(text: CharSequence) {
        subject.onNext(text)
    }

    // todo: replace with 2 way binding
    fun onFromChanged(position: Int) {
        viewModel.fromLang = viewModel.languages[position]
        viewModel.refresh()
    }

    // todo: replace with 2 way binding
    fun onToChanged(position: Int) {
        viewModel.toLang = viewModel.languages[position]
        viewModel.refresh()
    }

    override fun onDestroy() {
        super.onDestroy()
        subject.onComplete()
    }

    companion object {
        const val TAG = "MainPresenter"
    }
}