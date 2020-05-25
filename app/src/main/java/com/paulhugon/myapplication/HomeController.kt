package com.paulhugon.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import com.paulhugon.myapplication.databinding.HomeControllerBinding

class HomeController:Controller {
    constructor() : super()
    constructor(args: Bundle?) : super(args)

    companion object{

        const val TAG = "Home Controller"
    }

    private lateinit var bindingHome:HomeControllerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup,
        savedViewState: Bundle?
    ): View {
        Log.d(TAG,"On Create View")
        bindingHome = DataBindingUtil.inflate(inflater,R.layout.home_controller,container,false)

        val list = router.backstack

        Log.d(TAG,"BackStack is:")

        for(item in list){

            Log.d(TAG,item.controller.javaClass.name)

        }


        bindingHome.buttonToNewReceipt.setOnClickListener {

            router.pushController(RouterTransaction.with(FirstController())
                .pushChangeHandler(HorizontalChangeHandler())
                .popChangeHandler(HorizontalChangeHandler()))
        }

        return bindingHome.root
    }

    override fun onAttach(view: View) {
        Log.d(TAG,"On Attach $view")
        super.onAttach(view)
    }

    override fun onDetach(view: View) {
        Log.d(TAG,"On Detach $view")
        super.onDetach(view)
    }

    override fun onDestroyView(view: View) {
        Log.d(TAG,"On Destroy View $view")
        bindingHome.unbind()
        super.onDestroyView(view)
    }

    override fun onDestroy() {
        Log.d(TAG,"On Destroy")
        super.onDestroy()
    }
}