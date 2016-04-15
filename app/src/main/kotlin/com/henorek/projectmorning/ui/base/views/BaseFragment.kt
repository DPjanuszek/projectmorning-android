package com.henorek.projectmorning.ui.base.views

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.mosby.mvp.MvpFragment
import com.hannesdorfmann.mosby.mvp.delegate.BaseMvpDelegateCallback
import com.henorek.projectmorning.ui.base.presenters.BasePresenter

abstract class BaseFragment<VIEW : IBaseView, PRESENTER : BasePresenter<VIEW>> : MvpFragment<VIEW, PRESENTER>(), BaseMvpDelegateCallback<VIEW, PRESENTER>, IBaseView {

  private val hostActivity: IBaseView? = null

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    val view = inflateView(inflater, container)
    super.onCreateView(inflater, container, savedInstanceState)
    prepareView(savedInstanceState)
    return view
  }

  protected fun inflateView(inflater: LayoutInflater?, container: ViewGroup?): View {
    return inflater!!.inflate(resourceId, container, false)
  }

  protected abstract val resourceId: Int

  protected abstract fun prepareView(savedInstanceState: Bundle?)

  override val activityContext: Context
    get() = hostActivity!!.activityContext
}
