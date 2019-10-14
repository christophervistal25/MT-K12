package com.vistalis.computerdictionary.DatabaseModules.Models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "words_favorite")
public class WordFavorite {

    @PrimaryKey(autoGenerate = true)
    public int id;



    public int word_id;
    public String word;
    public String definition;
    public int dialect;


    public WordFavorite(int word_id, String word, String definition, int dialect) {
        this.setWord(word);
        this.setDefinition(definition);
        this.setWord_id(word_id);
        this.setDialect(dialect);

    }

    public int getDialect() {
        return dialect;
    }

    public void setDialect(int dialect) {
        this.dialect = dialect;
    }

    public int getWord_id() {
        return word_id;
    }

    public void setWord_id(int word_id) {
        this.word_id = word_id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
