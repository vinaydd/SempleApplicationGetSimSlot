package com.example.sharadsingh.sempleapplication.utills

/**
 * Created by ios4_dev on 11/19/15.
 */
object Constants {
    // http://ttest.truxapp.com/
    //  public static final String HOST_URL ="http://192.168.0.43:8080/truxapiv2/";
    //public static final String HOST_URL ="http://ttest.truxapp.com/truxapiv2/";
    val HOST_URL = "http://crm.truxapp.com/truxapiv2/"
    val APP_SHARED_PREFS = "App preference"
    val API_KEY = "user_api"
    val LOGIN_URL = "clientcustom/loginSuperUser"
    val USER_NAME = "user_name"
    val USER_IMAGE = "user_img"
    val MESSAGE_COUNT = "new message count"
    val SAVE_CHECK_ADAPTER = "save check adapter"
    val JSON_OBJECTS = "object"
    val JSON_ARRAY = "array"
    val GET_REQUEST = "1"
    val POST_REQUEST = "2"
    val DEVICE_MAC = "device_mac"
    val REASION_ID = "resion id"
    val VEHICLE_DETAIL = "driver/byvehicleno/"
    val START_STOP_JOURNY_URL = "driver/journey"
    val PUNCH_IN_URL = "/leasedvicecontroller/driver/punch/"


    // global topic to receive app wide push notifications
    val TOPIC_GLOBAL = "global"

    // broadcast receiver intent filters
    val REGISTRATION_COMPLETE = "registrationComplete"
    val PUSH_NOTIFICATION = "pushNotification"

    // id to handle the notification in the notification tray
    val NOTIFICATION_ID = 100
    val NOTIFICATION_ID_BIG_IMAGE = 101

    val SHARED_PREF = "ah_firebase"

}
