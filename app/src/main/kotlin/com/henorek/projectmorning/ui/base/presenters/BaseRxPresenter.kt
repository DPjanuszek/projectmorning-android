package com.henorek.projectmorning.ui.base.presenters

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter
import com.hannesdorfmann.mosby.mvp.MvpPresenter
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

abstract class BaseRxPresenter<VIEW : MvpLceView<MODEL>, MODEL> : MvpBasePresenter<VIEW>(), MvpPresenter<VIEW> {

  protected var subscriber: Subscriber<MODEL>? = null

  protected fun unsubscribe() {
    if (subscriber != null && !subscriber!!.isUnsubscribed) {
      subscriber!!.unsubscribe()
    }

    subscriber = null
  }

  fun subscribe(observable: Observable<MODEL>, pullToRefresh: Boolean) {

    if (isViewAttached) {
      view!!.showLoading(pullToRefresh)
    }

    unsubscribe()

    subscriber = object : Subscriber<MODEL>() {

      private val ptr = pullToRefresh

      override fun onCompleted() {
        this@BaseRxPresenter.onCompleted()
      }

      override fun onError(e: Throwable) {
        this@BaseRxPresenter.onError(e, ptr)
      }

      override fun onNext(MODEL: MODEL) {
        this@BaseRxPresenter.onNext(MODEL)
      }
    }

    observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
        subscriber)
  }

  protected fun onCompleted() {
    if (isViewAttached) {
      view!!.showContent()
    }
    unsubscribe()
  }

  protected fun onError(e: Throwable, pullToRefresh: Boolean) {
    if (isViewAttached) {
      view!!.showError(e, pullToRefresh)
    }
    unsubscribe()
  }

  protected fun onNext(data: MODEL) {
    if (isViewAttached) {
      view!!.setData(data)
    }
  }

  override fun detachView(retainInstance: Boolean) {
    super.detachView(retainInstance)
    if (!retainInstance) {
      unsubscribe()
    }
  }
}
