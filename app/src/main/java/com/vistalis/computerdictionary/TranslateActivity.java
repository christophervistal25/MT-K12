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

import com.vistalis.computerdictionary.API.KamayoTranslate;
import com.vistalis.computerdictionary.API.SinugbuanonTranslate;
import com.vistalis.computerdictionary.Modules.KamayoService;
import com.vistalis.computerdictionary.Modules.Models.KamayoResponse;
import com.vistalis.computerdictionary.Modules.Models.SinugbuanonRequest;
import com.vistalis.computerdictionary.Modules.Models.SinugbuanonResponse;
import com.vistalis.computerdictionary.Modules.Service;
import com.vistalis.computerdictionary.Repositories.TranslationHistoryRepository;

import java.util.HashMap;

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

            if (inputText.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please add some word/phrase that you want to be translated.", Toast.LENGTH_SHORT).show();
                return;
            }

            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Translating...");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.show();


            if (this.isUserWantKamayo()) {
                Retrofit retrofit        = KamayoService.RetrofitInstance(getApplicationContext());
                KamayoTranslate services    = retrofit.create(KamayoTranslate.class);

                HashMap<String, String> data = new HashMap<>();

                data.put("sentence", inputText.getText().toString().replaceAll("[^a-zA-Z0-9\\s]",""));
                data.put("target_lang", toLanguages[toLanguage.getSelectedItemPosition()].toLowerCase());

                Call<KamayoResponse> kamayoResponseCall = services.translate(data);

                kamayoResponseCall.enqueue(new Callback<KamayoResponse>() {
                    @Override
                    public void onResponse(Call<KamayoResponse> call, Response<KamayoResponse> response) {
                        if  (response.code() == 200 && response.isSuccessful() ) {
                            String result = response.body().getTranslated();
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
                    public void onFailure(Call<KamayoResponse> call, Throwable t) {
                        progressDialog.dismiss();
                        Toast.makeText(TranslateActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            } else {
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

            }

        });

     }

     private boolean isUserWantKamayo()
     {
         return fromLanguages[fromLanguage.getSelectedItemPosition()].toLowerCase().equals("kamayo")
                 || toLanguages[toLanguage.getSelectedItemPosition()].toLowerCase().equals("kamayo");
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
