package com.vistalis.computerdictionary.Modules.Models;

import com.google.gson.annotations.SerializedName;

public class SinugbuanonResponse {
    public String getTranslate() {
        return translate;
    }

    @SerializedName("translated")
    private String translate;

}
