package com.kurume_nct.studybattle.model

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
import com.kurume_nct.studybattle.R
import android.support.annotation.RawRes



/**
 * Created by hanah on 9/24/2017.
 */
class UnitPersonal : Application(){

    //var userName : String
    var myInfomation: User = User()
    var nowGroup : Group
    var itemCount : HunachiItem
    private lateinit var prefer: SharedPreferences
    var myGroupCount: Int
    var myGroupList: MutableList<Group>
    var authenticationKey = "0"

    init {
        nowGroup = Group()
        myGroupCount = 0
        itemCount = HunachiItem()
        myGroupList = mutableListOf()
    }

    override fun onCreate() {
        super.onCreate()
        prefer = getSharedPreferences(packageName + ".txt", Context.MODE_PRIVATE)
        authenticationKey = prefer.getString("key", "0")
    }

    fun writeFile(){
        prefer = getSharedPreferences(packageName + ".txt", Context.MODE_PRIVATE)
        val edit = prefer.edit()
        edit.putString("key", authenticationKey)
        edit.commit()
    }

    fun deleteFile(){
        prefer = getSharedPreferences(packageName + ".txt", Context.MODE_PRIVATE)
        authenticationKey = "0"
        prefer.edit().clear().commit()
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}