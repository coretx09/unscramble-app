package com.example.android.unscramble.ui.game

import android.text.Spannable
import android.text.SpannableString
import android.text.style.TtsSpan
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {

    /* PROPERTY */

    // SCORE GAME
    private val _score = MutableLiveData(0)
    val score: LiveData<Int> get() = _score

    // NOMBRE DE MOTS ACTUEL
    private val _currentWordCount = MutableLiveData(0)
    val currentWordCount: LiveData<Int>
        get() = _currentWordCount

    // MOTS BROUILLE ACTUEL
    private  val _currentScrambledWord = MutableLiveData<String>()
    val currentScrambledWord: LiveData<Spannable> = Transformations.map(_currentScrambledWord) {
        if (it == null) {
            SpannableString("")
        } else {
            val scrambledWord = it.toString()
            val spannable: Spannable = SpannableString(scrambledWord)
            spannable.setSpan(
                TtsSpan.VerbatimBuilder(scrambledWord).build(),
                0,
                scrambledWord.length,
                Spannable.SPAN_INCLUSIVE_INCLUSIVE
            )
            spannable
        }
    }

    // LIST DES MOTS
    private var wordsList =  mutableListOf<String>()

    // MOTS ACTUEL
    private lateinit var currentWord: String



    /* METHODS */

    private fun getNextWord() {
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()

        // continue de shuffle tant que tempWord = currentWord
        while(String(tempWord).equals(currentWord, false)) {
            tempWord.shuffle()
        }
        // pour vérifier si un mot a déjà été utilisé
        if (wordsList.contains(currentWord)) getNextWord()
        else {
            // OBJECT LIVEDATA: GET VALUE
            _currentScrambledWord.value = String(tempWord)
            // inc()fonction Kotlin pour incrémenter la valeur avec une sécurité nulle.
            _currentWordCount.value = (_currentWordCount.value)?.inc()
            wordsList.add(currentWord)
        }
    }

    /*
     * Returns true if the current word count is less than MAX_NO_OF_WORDS.
     * Updates the next word.
     */
    fun nextWord(): Boolean {
        return if (currentWordCount.value!! < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }

    /* Méthodes d'assistance pour valider le mot du joueur  ajoute +20 a chaque mots correct*/
    // LE SCORE ++
    private fun increaseScore() {
        // plus()fonction  effectue l'addition avec une sécurité nulle.
        _score.value = (_score.value)?.plus(SCORE_INCREASE)
    }

    // RETURN LE SCORE
    fun isUserWordCorrect(playerWord: String): Boolean {
        if (playerWord.equals(currentWord, true)) {
            increaseScore()
            return true
        }
        return false
    }

    /*
     * Re-initializes the game data to restart the game.
     */
    fun reinitializeData() {
        _score.value = 0
        _currentWordCount.value = 0
        wordsList.clear()
        getNextWord()
    }

    init {
        getNextWord()
    }
}