package com.vistalis.computerdictionary.DatabaseModules.Daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;


import com.vistalis.computerdictionary.DatabaseModules.Models.TranslationHistory;

import java.util.List;

@Dao
public interface TranslationDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void create(TranslationHistory history);

    @Delete()
    void delete(TranslationHistory history);


    @Query("SELECT * FROM translation_history")
    List<TranslationHistory> getAllTranslated();

    @Query("SELECT COUNT(id) FROM translation_history WHERE from_input = :from_input")
    int check(String from_input);

}
