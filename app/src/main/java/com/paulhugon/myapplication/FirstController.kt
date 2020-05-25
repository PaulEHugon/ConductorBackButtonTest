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
import com.paulhugon.myapplication.databinding.FirstControllerBinding

class FirstController:Controller {

    constructor() : super()
    constructor(args: Bundle?) : super(args)

    companion object{

        const val TAG = "First Controller"
    }

    lateinit var bindingFirst:FirstControllerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup,
        savedViewState: Bundle?
    ): View {
        Log.d(TAG,"On Create View")
        bindingFirst = DataBindingUtil.inflate(inflater,R.layout.first_controller,container,false)

        val list = router.backstack

        Log.d(TAG,"BackStack is:")

        for(item in list){

            Log.d(TAG,item.controller.javaClass.name)

        }

        bindingFirst.buttonToSecondController.setOnClickListener {

            router.pushController(RouterTransaction.with(SecondController())
                .pushChangeHandler(HorizontalChangeHandler())
                .popChangeHandler(HorizontalChangeHandler()))
        }

        return bindingFirst.root
    }

    override fun onAttach(view: View) {
        Log.d(TAG,"On Attach View $view")
        super.onAttach(view)
    }

    override fun onDetach(view: View) {
        Log.d(TAG,"On Detach $view")
        super.onDetach(view)
    }

    override fun onDestroyView(view: View) {
        Log.d(TAG,"On Destroy View $view")
        bindingFirst.unbind()
        super.onDestroyView(view)
    }

    override fun onDestroy() {
        Log.d(TAG,"On Destroy")
        super.onDestroy()
    }


}