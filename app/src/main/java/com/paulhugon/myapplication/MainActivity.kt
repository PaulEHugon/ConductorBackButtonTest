package com.paulhugon.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.paulhugon.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bindingActivity:ActivityMainBinding
    private lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingActivity = DataBindingUtil.setContentView(this, R.layout.activity_main)

        router  = Conductor.attachRouter(this,bindingActivity.controllerContainer,savedInstanceState)

        if (!router.hasRootController()){

            router.setRoot(RouterTransaction.with(HomeController()))

        }
    }

    override fun onBackPressed() {
        Log.d("OnBackPressed",router.handleBack().toString())
        if(!router.handleBack()){
            super.onBackPressed()
        }
    }

    override fun onDestroy() {
        bindingActivity.unbind()
        super.onDestroy()
    }
}
