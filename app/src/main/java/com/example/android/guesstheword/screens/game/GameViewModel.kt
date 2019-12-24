package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel :ViewModel(){
    // The current word
    private val  _word = MutableLiveData<String>()

    // Detect Game Finish use Backing Property write 2 variable
    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish:LiveData<Boolean>
        get() = _eventGameFinish

    val word:LiveData<String>
        get() = _word

    // The current score Backing Property
     private val _score = MutableLiveData<Int>()

    // score cannot Edit because if type , Override Get Method and return backing property
    val score:LiveData<Int>
         get() = _score

    // The list of words - the front of the list is the next word to guess
     private lateinit var wordList: MutableList<String>

    init {
        Log.i("GameViewModel","Game View Model Created!")
        //Use setValue() to set the value to LiveData but in Kotlin can use by .value = ....
        _word.value = ""
        //in Setter method use backing property instead of value changing
        //Old  score.value = 0
        _score.value = 0
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
        if (wordList.isEmpty()){
            onGameFinish()
        }
        else {
            //Select and remove a word from the list change word to the next index
            _word.value = wordList.removeAt(0)
        }
    }

     fun onSkip() {
        if (!wordList.isEmpty()) {
          //Instead of  score-- , Backing Property Instead of Direct Edit
            _score.value = (score.value)?.minus(1)
        }
        nextWord()
    }

    fun onCorrect() {
        if (!wordList.isEmpty()) {
            //Instead of score++
            _score.value = (score.value)?.plus(1)
        }
        nextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel","Game View Model has destroyed")
    }

    fun onGameFinish(){
        _eventGameFinish.value  = true
    }

     fun onGameFinshComplete(){
        _eventGameFinish.value = false
    }
}