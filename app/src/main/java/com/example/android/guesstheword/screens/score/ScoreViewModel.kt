package com.example.android.guesstheword.screens.score

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class ScoreViewModel (finalScore:Int):ViewModel(){
    var score = finalScore
    init{
        Log.i("ScoreViewModel","Final Score is $score")
    }
}

/**
 * This Class will responsible for instantiation ScoreViewModel Object
 * */
class ScoreViewModelFactory(private val finalScore: Int):ViewModelProvider.Factory{

    //Error of un implement abstract method will appear solve with override function create
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        //Receive  modelClass and Return ViewModel as object
        // If model class is correct return them as ViewModel with Value
        if(modelClass.isAssignableFrom(ScoreViewModel::class.java)){
            return  ScoreViewModel(finalScore) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}