package com.henorek.projectmorning.ui.base.views

import android.content.Context
import com.hannesdorfmann.mosby.mvp.MvpView

interface IBaseView : MvpView {
  val activityContext: Context
}
