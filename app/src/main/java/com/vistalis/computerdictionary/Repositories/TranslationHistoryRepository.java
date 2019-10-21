package com.vistalis.computerdictionary.Repositories;

import android.content.Context;
import android.util.Log;

import com.vistalis.computerdictionary.DatabaseModules.DB;
import com.vistalis.computerdictionary.DatabaseModules.Models.TranslationHistory;

public class TranslationHistoryRepository
{
    public static boolean isExists(Context context, String phraseOrWord)
    {
        // Apply String tokenizer here..
        return DB.getInstance(context).translationDao().check(phraseOrWord) >= 1;
    }

    public static void create(Context context, String phraseOrWord, String translation, String process)
    {
        if(!TranslationHistoryRepository.isExists(context, phraseOrWord)) {
            TranslationHistory translationHistory = new TranslationHistory(phraseOrWord,translation, process);
            DB.getInstance(context).translationDao().create(translationHistory);
        }
    }
}
