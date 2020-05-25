package com.paulhugon.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bluelinelabs.conductor.Controller
import com.paulhugon.myapplication.databinding.SecondControllerBinding

class SecondController:Controller {

    constructor() : super()
    constructor(args: Bundle?) : super(args)

    companion object{

        const val TAG = "Second Controller"
    }

    lateinit var bindingSecond:SecondControllerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup,
        savedViewState: Bundle?
    ): View {
        Log.d(TAG,"On Create View")
        bindingSecond = DataBindingUtil.inflate(inflater,R.layout.second_controller,container,false)

        val list = router.backstack

        Log.d(TAG,"BackStack is:")

        for(item in list){

            Log.d(TAG,item.controller.javaClass.name)

        }

        return bindingSecond.root
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
        bindingSecond.unbind()
        super.onDestroyView(view)
    }

    override fun onDestroy() {
        Log.d(TAG,"On Destroy")
        super.onDestroy()
    }
}