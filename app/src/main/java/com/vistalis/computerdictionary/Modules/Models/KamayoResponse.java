package com.vistalis.computerdictionary.Modules.Models;

import java.util.HashMap;
import java.util.Map;

public class KamayoResponse {
    private String level;
    private String sentence;
    private String targetLang;
    private String translated;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getTargetLang() {
        return targetLang;
    }

    public void setTargetLang(String targetLang) {
        this.targetLang = targetLang;
    }

    public String getTranslated() {
        return translated;
    }

    public void setTranslated(String translated) {
        this.translated = translated;
    }


}
