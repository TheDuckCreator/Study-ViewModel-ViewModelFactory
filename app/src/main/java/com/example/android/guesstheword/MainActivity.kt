/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.guesstheword

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * ViewModel is class to storage and Manage UI-related data
 * ViewModelFactory is class to instant and return ViewModel that Survive configure change like
 * screen rotation, screen close or anything can make program run into problem
 * the ViewModelFactory can make the ViewModel use in many configure change.
 * Creates an Activity that hosts all of the fragments in the app
 */
class MainActivity : AppCompatActivity() {

    /**
     *Can use savedInstanceState() to save and store device configure like screen rotation
     * but it's too mush lines of codes and can store  minimum data
     * It more than useful if use Design under Android Architecture Guideline (lifecycle)
     * It more better to seperate UI Controller , ViewModel and ViewModel Factory
     * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

}
/**
 * *****Separation of Concern*****
 * UI Controller must only contain logic to handle UI, no decision making logic
 * ViewModel hold data to Display,Simple Calculate and Transformation, decision making
 * ViewModelFactory contains business logic to perform simple calculation and decide of ViewModel
 * */