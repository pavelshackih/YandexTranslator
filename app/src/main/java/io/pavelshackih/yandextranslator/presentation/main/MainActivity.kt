package io.pavelshackih.yandextranslator.presentation.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import io.pavelshackih.yandextranslator.R
import io.pavelshackih.yandextranslator.databinding.ActivityMainBinding
import io.pavelshackih.yandextranslator.ext.app.AppActivity

class MainActivity : AppActivity(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.presenter = presenter
    }

    override fun showErrorSameLang() {
        Toast.makeText(this, R.string.error_same_langs, Toast.LENGTH_LONG).show()
    }

    override fun setTranslations(list: List<String>) {
        if (binding.recyclerView.adapter == null) {
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            binding.recyclerView.itemAnimator = DefaultItemAnimator()
            binding.recyclerView.adapter = SimpleAdapter()
        }
        val adapter = binding.recyclerView.adapter as SimpleAdapter
        adapter.swapList(list)
    }

    override fun setModel(model: ViewModel) {
        binding.viewModel = model
        binding.executePendingBindings()
    }
}