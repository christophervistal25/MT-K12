package com.vistalis.computerdictionary.Modules.Models;

import com.google.gson.annotations.SerializedName;

public class SinugbuanonRequest {
    @SerializedName("word")
    private String word;

    @SerializedName("language")
    private String language;


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
