package com.vistalis.computerdictionary;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vistalis.computerdictionary.DatabaseModules.Models.Word;
import com.vistalis.computerdictionary.Repositories.WordRepository;

public class TranslateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);

        EditText inputText = findViewById(R.id.input);
        TextView kamayoResult = findViewById(R.id.kamayoResult);
        TextView sinugbanonResult = findViewById(R.id.sinugbanonResult);

        Button btnTranslate = findViewById(R.id.btnTranslate);
        Button btnReset = findViewById(R.id.btnReset);

        btnReset.setOnClickListener(v -> {
            inputText.setText("");
            kamayoResult.setText("");
            sinugbanonResult.setText("");
        });

        btnTranslate.setOnClickListener(v -> {

            if  (WordRepository.availableWord(this, inputText.getText().toString(), 1) != 0) {
                Word kamayo = WordRepository.pickWord(this, inputText.getText().toString(), 1);
                kamayoResult.setText(kamayo.getTranslation());
                kamayoResult.setTextColor(Color.parseColor("black"));
            } else {
                kamayoResult.setTextColor(Color.parseColor("red"));
                kamayoResult.setText("Problem occur while translating your input.");
            }

            if(WordRepository.availableWord(this, inputText.getText().toString(), 2) != 0) {
                Word sinugbanon = WordRepository.pickWord(this, inputText.getText().toString(), 2);

                sinugbanonResult.setText(sinugbanon.getTranslation());
                sinugbanonResult.setTextColor(Color.parseColor("black"));
            } else {
                sinugbanonResult.setTextColor(Color.parseColor("red"));
                sinugbanonResult.setText("Problem occur while translating your input.");
            }


        });

    }
}
