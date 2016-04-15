package com.henorek.projectmorning.ui.base.configs

class ActivityConfigBuilder(contentId: Int) {
  protected var activityConfig = createConfig()

  init {
    activityConfig.layoutId = contentId
  }

  fun build(): ActivityConfig {
    return activityConfig
  }

  protected fun createConfig(): ActivityConfig {
    return ActivityConfig()
  }

  fun setContentId(contentId: Int): ActivityConfigBuilder {
    activityConfig.layoutId = contentId
    return this
  }
}
