package com.vistalis.computerdictionary.DatabaseModules.Daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.vistalis.computerdictionary.DatabaseModules.Models.Phrase;

import java.util.List;

@Dao
public interface PhraseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void create(Phrase phrase);

    @Query("SELECT * FROM phrases ORDER BY english_word")
    List<Phrase> getAllWords();

    @Query("SELECT id FROM phrases")
    List<Integer> getAllIds();

    @Query("SELECT COUNT(id) FROM phrases")
    int noOfWords();

    @Query("DELETE from phrases")
    void deleteAllWords();

    @Query("SELECT * FROM phrases WHERE id = :id")
    Phrase pickWord(int id);

    @Query("SELECT * FROM phrases WHERE english_word LIKE  :word  AND dialect = :dialect LIMIT 1")
    Phrase pickWordByDialect(String word, int dialect);

    @Query("SELECT COUNT(*) FROM phrases WHERE english_word LIKE :word  AND dialect = :dialect LIMIT 1")
    int hasPickWord(String word, int dialect);
}
