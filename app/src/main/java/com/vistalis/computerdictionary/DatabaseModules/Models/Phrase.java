package com.vistalis.computerdictionary.DatabaseModules.Models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "phrases")
public class Phrase {
    // Dialect 1 = KAMAYO , 2 = SINUGBANON
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String english_word;
    public String translation;
    public int dialect;

    public Phrase(String english_word, String translation, int dialect) {
        this.english_word = english_word;
        this.translation = translation;
        this.dialect = dialect;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnglish_word() {
        return english_word;
    }

    public String getTranslation() {
        return translation;
    }

    public int getDialect() {
        return dialect;
    }

    public void setDialect(int dialect) {
        this.dialect = dialect;
    }
}
