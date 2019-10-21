package com.vistalis.computerdictionary.DatabaseModules.Models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "translation_history")
public class TranslationHistory {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String from_input;
    public String to_translate;
    public String process;

    public TranslationHistory(String from_input, String to_translate, String process) {
        this.from_input = from_input;
        this.to_translate = to_translate;
        this.process = process;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom_input() {
        return from_input;
    }


    public String getTo_translate() {
        return to_translate;
    }


    public String getProcess() {
        return process;
    }

}
