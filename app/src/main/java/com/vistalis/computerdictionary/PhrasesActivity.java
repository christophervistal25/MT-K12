package com.vistalis.computerdictionary;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.vistalis.computerdictionary.Adapters.PhraseAdapter;
import com.vistalis.computerdictionary.DatabaseModules.DB;
import com.vistalis.computerdictionary.DatabaseModules.Models.Phrase;

import java.util.ArrayList;
import java.util.List;

public class PhrasesActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PhraseAdapter pharseAdapter;
    LinearLayoutManager layoutManager;
    List<Phrase> word_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);
        //this.setActivityToFullScreen();
        this.buildRecyclerView();

        findViewById(R.id.phraseLayout).requestFocus();

        EditText searchField = findViewById(R.id.searchField);

        searchField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Intent intent;
            switch (item.getItemId()) {

                case R.id.action_translate:
                    intent = new Intent(this,TranslateActivity.class);
                    startActivity(intent);
                    break;


                case R.id.action_favorites:
                    intent = new Intent(this,FavoritesActivity.class);
                    startActivity(intent);
                    break;

                case R.id.action_phrases:
                    intent = new Intent(this,PhrasesActivity.class);
                    startActivity(intent);
                    break;

            }
            return true;
        });


    }

    private void filter(String text) {
        ArrayList<Phrase> filteredList = new ArrayList<>();

        for (Phrase item : word_list) {
            if (item.getEnglish_word().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        pharseAdapter.filterList(filteredList);
    }

    private void buildRecyclerView() {

        word_list = DB.getInstance(this).phraseDao().getAllWords();

        pharseAdapter = new PhraseAdapter(word_list);

        recyclerView = findViewById(R.id.pharses_recycler_view);

        recyclerView.addItemDecoration(
                new DividerItemDecoration(this,
                        LinearLayoutManager.VERTICAL)
        );


        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(pharseAdapter);

    }


    private void setActivityToFullScreen()
    {
        Window window = getWindow();
        WindowManager.LayoutParams winParams = window.getAttributes();
        winParams.flags &= ~WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        window.setAttributes(winParams);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
}
