package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel :ViewModel(){
    // The current word
    var word = MutableLiveData<String>()

    // The current score
     var score = MutableLiveData<Int>()

    // The list of words - the front of the list is the next word to guess
     private lateinit var wordList: MutableList<String>

    init {
        Log.i("GameViewModel","Game View Model Created!")
        //Use setValue() to set the value to LiveData but in Kotlin can use by .value = ....
        word.value = ""
        score.value = 0
        resetList()
        nextWord()
    }
    private fun resetList() {
        wordList = mutableListOf(
                "queen",
                "hospital",
                "basketball",
                "cat",
                "change",
                "snail",
                "soup",
                "calendar",
                "sad",
                "desk",
                "guitar",
                "home",
                "railway",
                "zebra",
                "jelly",
                "car",
                "crow",
                "trade",
                "bag",
                "roll",
                "bubble"
        )
        wordList.shuffle()
    }
    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        if (!wordList.isEmpty()) {
            //Select and remove a word from the list change word to the next index
            word.value = wordList.removeAt(0)
        }
    }

     fun onSkip() {
        if (!wordList.isEmpty()) {
          //Instead of  score--
            score.value = (score.value)?.minus(1)
        }
        nextWord()
    }

    fun onCorrect() {
        if (!wordList.isEmpty()) {
            //Instead of score++
            score.value = (score.value)?.plus(1)
        }
        nextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel","Game View Model has destroyed")
    }
}