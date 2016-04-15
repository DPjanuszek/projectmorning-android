package com.henorek.projectmorning.ui.base.presenters

import com.hannesdorfmann.mosby.mvp.MvpPresenter
import com.hannesdorfmann.mosby.mvp.MvpView

interface IBasePresenter<V : MvpView> : MvpPresenter<V>