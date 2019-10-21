package com.vistalis.computerdictionary.DatabaseModules;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.vistalis.computerdictionary.DatabaseModules.Daos.PhraseDao;
import com.vistalis.computerdictionary.DatabaseModules.Daos.TranslationDao;
import com.vistalis.computerdictionary.DatabaseModules.Daos.WordFavoriteDao;
import com.vistalis.computerdictionary.DatabaseModules.Daos.WordsDao;
import com.vistalis.computerdictionary.DatabaseModules.Models.Phrase;
import com.vistalis.computerdictionary.DatabaseModules.Models.TranslationHistory;
import com.vistalis.computerdictionary.DatabaseModules.Models.Word;
import com.vistalis.computerdictionary.DatabaseModules.Models.WordFavorite;

@Database(entities = {Word.class, WordFavorite.class, Phrase.class, TranslationHistory.class},version = 1)
public abstract class DB extends RoomDatabase {

    private static DB appDatabase;
    private Context context;
    public abstract WordsDao wordsDao();
    public abstract WordFavoriteDao wordFavoriteDao();
    public abstract PhraseDao phraseDao();
    public abstract TranslationDao translationDao();

    public synchronized  static DB getInstance(Context context){
        if(appDatabase == null){
            appDatabase = Room.databaseBuilder(context.getApplicationContext(), DB.class, "computer_dictionary")
                    .allowMainThreadQueries()
                    .build();
        }
        return appDatabase;
    }

    public void destroyInstance() {
        appDatabase = null;
    }
}

