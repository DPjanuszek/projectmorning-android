package com.henorek.projectmorning.ui.mainscreen

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.Toolbar
import com.henorek.projectmorning.R
import com.henorek.projectmorning.ui.base.configs.ActivityConfig
import com.henorek.projectmorning.ui.base.configs.ActivityConfigBuilder
import com.henorek.projectmorning.ui.base.views.BaseActivity

class MainActivity : BaseActivity<IMainView, MainPresenter>(), IMainView {

  override fun addFragments() {
  }

  override fun prepareView(savedInstanceState: Bundle?) {
    val toolbar = findViewById(R.id.toolbar) as Toolbar?
    setSupportActionBar(toolbar)

    val fab = findViewById(R.id.fab) as FloatingActionButton
    fab.setOnClickListener( { view -> throw RuntimeException() })
  }

  override val config: ActivityConfig
    get() = ActivityConfigBuilder(R.layout.activity_main).build();

  override fun createPresenter(): MainPresenter {
    return MainPresenter();
  }
}
