package com.example.android.miwok;

import android.content.Context;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
 */
public class Word {
    private String mMiwokTranslation;
    private String mDefaultTranslation;


    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     */
    public Word (String defaultTranslation, String miwokTranslation) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;

    }
    public String getDefaultTranslation() {return mDefaultTranslation;}
    public String getMiwokTranslation() {return mMiwokTranslation;}


}
