package com.henorek.projectmorning.ui.logic

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by janco on 19.04.2016.
 */
class Time {

 private    var sdf :SimpleDateFormat = SimpleDateFormat("HH:mm:ss")
 private    var currentDateandTime : String= sdf.format(Date())


     fun getTime():String {
        return this.currentDateandTime;
    }

}