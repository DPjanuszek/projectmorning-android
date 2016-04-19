package com.henorek.projectmorning.ui.base.views

import android.content.Context
import android.os.Bundle
import android.view.View
import com.hannesdorfmann.mosby.mvp.MvpActivity
import com.hannesdorfmann.mosby.mvp.delegate.ActivityMvpDelegateCallback
import com.henorek.projectmorning.ui.base.configs.ActivityConfig
import com.henorek.projectmorning.ui.base.presenters.BasePresenter
import timber.log.Timber

abstract class BaseActivity<VIEW : IBaseView, PRESENTER : BasePresenter<VIEW>> : MvpActivity<VIEW, PRESENTER>(), ActivityMvpDelegateCallback<VIEW, PRESENTER>, IBaseView {

  private var activityConfig: ActivityConfig? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    activityConfig = config

    setContentView()
    initLibraries()

    prepareView(savedInstanceState)
    addFragments()
      addToCreate()
  }


    protected abstract fun addToCreate()

  protected abstract val config: ActivityConfig

  protected abstract fun prepareView(savedInstanceState: Bundle?)


  protected abstract fun addFragments()
  private fun setContentView() {
    val root = View.inflate(this, activityConfig!!.layoutId, null)
    setContentView(root)
  }

  private fun initLibraries() {
    Timber.plant(Timber.DebugTree())
  }

  override val activityContext: Context
    get() = this
}
