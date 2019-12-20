# ViewModel and ViewModelFactory Codelabs Implement

Program Bootstrap with Viewmodel and ViewModelFactory Starter Code from Google Codelabs from this link https://codelabs.developers.google.com/codelabs/kotlin-android-training-view-model/ and the Readme of Starter Code is below my readme.

## Meaning of ViewModel and ViewModelFactory
- **ViewModel**  is class to storage and Manage UI-related data
- **ViewModelFactory** is class to instant and return ViewModel that Survive configure change 

## Managing Configuration Changes Problem
Configure change like screen rotation, screen close or anything can make program run into problem the ViewModelFactory can make the ViewModel use in many configure change.

For handling th problem of configure changes can use `savedInstanceState()` to save and store device configure like screen rotation but it's too mush lines of codes and can store  minimum data. It more than useful if use Design under Android Architecture Guideline (lifecycle).It more better to seperate UI Controller , ViewModel and ViewModel Factory and make it under *Seperation of Concern*

### Seperation of Concern
 * UI Controller must only contain logic to handle UI, no decision making logic
 * ViewModel hold data to Display,Simple Calculate and Transformation, decision making
 * ViewModelFactory contains business logic to perform simple calculation and decide of ViewModel

In Configure Change like screen rotation,etc fragment will be destroy but ViewModel is still alive

## ViewModelProvider
If we use viewModel instance using `ViewModel` class, object will create everytime when fragment is re-created. For the better result we can Instance ViewModel using `ViewModelProvider`
- `ViewModelProvider()` return existing ViewModel (if exists) or create a new one if not exist will Create ViewModel instance in association with given scope
- `ViewModelProviders.of()` is for Initial ViewModel use that To Create ViewModelProvider


ViewModel and ViewModelFactory - Starter Code
==================================

Use as starter code for the ViewModel codelab.

Introduction
------------

This starter app is a two player game, GuessTheWord. It is a word guessing app you can play with one or more friends. To play, hold the device in landscape, facing away from you with your thumbs on the **Skip** and **Got It** buttons. Your friends can then give you clues to help you guess the word. If you get the word right, press **Got It**. If you're stuck, press **Skip**.
You will modify the app to use Architecture components and best practices.

Pre-requisites
--------------

You need to know:
- How to open, build, and run Android apps with Android Studio.
- How to use the Navigation Architecture Component
- Passing the data between navigation destinations.
- Read the logs using the Logcat.


Getting Started
---------------

1. Download and run the app.

License
-------

Copyright 2019 Google, Inc.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the NOTICE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.
