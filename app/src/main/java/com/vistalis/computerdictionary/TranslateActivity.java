package com.vistalis.computerdictionary;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.vistalis.computerdictionary.API.SinugbuanonTranslate;
import com.vistalis.computerdictionary.Modules.Models.SinugbuanonRequest;
import com.vistalis.computerdictionary.Modules.Models.SinugbuanonResponse;
import com.vistalis.computerdictionary.Modules.Service;
import com.vistalis.computerdictionary.Repositories.PhraseRepository;
import com.vistalis.computerdictionary.Repositories.TranslationHistoryRepository;
import com.vistalis.computerdictionary.Repositories.WordRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TranslateActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private Spinner fromLanguage;
    private Spinner toLanguage;
    private String[] languageCode = { "ceb", "en", "ceb" };
    private String[] fromLanguages = { "English", "Sinugbuanon", "Kamayo" };
    private String[] toLanguages = { "Sinugbuanon", "English", "Kamayo" };

     @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);

        EditText inputText = findViewById(R.id.input);
        TextView output = findViewById(R.id.sinugbanonResult);
        Button btnTranslate = findViewById(R.id.btnTranslate);
        Button btnReset = findViewById(R.id.btnReset);
        TextView inputLabel = findViewById(R.id.inputLabel);
        TextView resultLabel = findViewById(R.id.resultLabel);
        TextView viewAllTranslated = findViewById(R.id.viewTranslated);

        fromLanguage = findViewById(R.id.spinner1);
        toLanguage = findViewById(R.id.spinner2);


        this.setSpinnerValues();

        fromLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                inputLabel.setText(String.format("From %s", fromLanguages[position]));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        toLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                resultLabel.setText(String.format("Result in %s", toLanguages[position]));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        viewAllTranslated.setOnClickListener(v -> {
            Intent intent = new Intent(this, TranslatedActivity.class);
            startActivity(intent);
        });

        btnReset.setOnClickListener(v -> {
            inputText.setText("");
            output.setText("");
        });

        btnTranslate.setOnClickListener(v -> {

            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Translating...");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.show();


            Retrofit retrofit        = Service.RetrofitInstance(getApplicationContext());
            SinugbuanonTranslate services    = retrofit.create(SinugbuanonTranslate.class);
            SinugbuanonRequest sinugbuanonRequest = new SinugbuanonRequest();
            sinugbuanonRequest.setWord(inputText.getText().toString());
            sinugbuanonRequest.setLanguage(languageCode[toLanguage.getSelectedItemPosition()]);

            Call<SinugbuanonResponse> sinugbuanonResponseCall = services.translate(sinugbuanonRequest);

            sinugbuanonResponseCall.enqueue(new Callback<SinugbuanonResponse>() {
                @Override
                public void onResponse(Call<SinugbuanonResponse> call, Response<SinugbuanonResponse> response) {
                    if  (response.code() == 200 && response.isSuccessful() ) {
                        String result = response.body().getTranslate();
                        output.setText(result);

                        TranslationHistoryRepository.create(
                                getApplicationContext(),
                                inputText.getText().toString(), result,
                                fromLanguage.getSelectedItem() + " - " + toLanguage.getSelectedItem()
                        );

                    }
                    progressDialog.dismiss();
                }

                @Override
                public void onFailure(Call<SinugbuanonResponse> call, Throwable t) {
                    progressDialog.dismiss();
                    Toast.makeText(TranslateActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });


           /* if  (WordRepository.availableWord(this, inputText.getText().toString(), 1) != 0) {
                Word kamayo = WordRepository.pickWord(this, inputText.getText().toString(), 1);
                kamayoResult.setText(kamayo.getTranslation());
                kamayoResult.setTextColor(Color.parseColor("black"));
            } else {
                // Insertion for kamayo word that not exists.
                kamayoResult.setTextColor(Color.parseColor("red"));
                kamayoResult.setText("Problem occur while translating your input.");
            }

            if(WordRepository.availableWord(this, inputText.getText().toString(), 2) != 0) {
                Word sinugbanon = WordRepository.pickWord(this, inputText.getText().toString(), 2);

                output.setText(sinugbanon.getTranslation());
                output.setTextColor(Color.parseColor("black"));
            } else {
                // Insertion for cebuano word that not exists.
                output.setTextColor(Color.parseColor("red"));
                output.setText("Problem occur while translating your input.");
            }
*/

        });

    }

    private void wantToAddInList(String result) {
        if (isPhrase(result)) {
            // Check if exists.
            PhraseRepository.create(getApplicationContext(),"","",2);
        } else {
            // Check if exists.
            WordRepository.create(getApplicationContext(),"","",1);
        }
    }


    public boolean isPhrase(String string)
    {
        String[] words = string.split("\\s+");
        return words.length != 1;
    }


    private void setSpinnerValues() {
        fromLanguage = findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, fromLanguages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromLanguage.setAdapter(adapter);


        toLanguage = findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, toLanguages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toLanguage.setAdapter(adapter2);
    }
}
