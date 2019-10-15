package com.vistalis.computerdictionary.DatabaseModules.Daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.vistalis.computerdictionary.DatabaseModules.Models.Word;

import java.util.List;

@Dao
    public interface WordsDao {
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void create(Word word);

        @Query("SELECT * FROM words ORDER BY english_word")
        List<Word> getAllWords();

        @Query("SELECT id FROM words")
        List<Integer> getAllIds();

        @Query("SELECT COUNT(id) FROM words")
        int noOfWords();

        @Query("DELETE from words")
        void deleteAllWords();

        @Query("SELECT * FROM words WHERE id = :id")
        Word pickWord(int id);

        @Query("SELECT * FROM words WHERE english_word LIKE  :word  AND dialect = :dialect LIMIT 1")
        Word pickWordByDialect(String word, int dialect);

        @Query("SELECT COUNT(*) FROM words WHERE english_word LIKE :word  AND dialect = :dialect LIMIT 1")
        int hasPickWord(String word, int dialect);

}
