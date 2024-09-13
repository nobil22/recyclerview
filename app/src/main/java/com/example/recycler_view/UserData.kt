package com.example.recycler_view

import android.provider.ContactsContract.CommonDataKinds.Phone
import java.io.Serializable
data class UserData(
    val name:String,
    val phone:String,
    val mail:String
):Serializable

