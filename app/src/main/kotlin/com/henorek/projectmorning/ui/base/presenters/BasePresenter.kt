package com.henorek.projectmorning.ui.base.presenters

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter
import com.hannesdorfmann.mosby.mvp.MvpPresenter
import com.henorek.projectmorning.ui.base.views.IBaseView

abstract class BasePresenter<VIEW : IBaseView> : MvpBasePresenter<VIEW>(), MvpPresenter<VIEW>