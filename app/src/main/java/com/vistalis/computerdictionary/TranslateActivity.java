package com.vistalis.computerdictionary;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TranslateActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private Spinner spinnerFirstLanguage;
    private Spinner spinnerSecondLanguage;
    private String[] languageCode = { "en", "ceb", "ceb" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);

        EditText inputText = findViewById(R.id.input);
        TextView kamayoResult = findViewById(R.id.kamayoResult);
        TextView sinugbanonResult = findViewById(R.id.sinugbanonResult);
        Button btnTranslate = findViewById(R.id.btnTranslate);
        Button btnReset = findViewById(R.id.btnReset);

        spinnerFirstLanguage = findViewById(R.id.spinner1);
        spinnerSecondLanguage = findViewById(R.id.spinner2);


        this.setSpinnerValues();


        btnReset.setOnClickListener(v -> {
            inputText.setText("");
            kamayoResult.setText("");
            sinugbanonResult.setText("");
        });

        btnTranslate.setOnClickListener(v -> {

            //Declare progressDialog before so we can use .hide() later!
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("LOADING . . .");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.show();


            Retrofit retrofit        = Service.RetrofitInstance(getApplicationContext());
            SinugbuanonTranslate services    = retrofit.create(SinugbuanonTranslate.class);
            SinugbuanonRequest sinugbuanonRequest = new SinugbuanonRequest();
            sinugbuanonRequest.setWord(inputText.getText().toString());
            sinugbuanonRequest.setLanguage(languageCode[spinnerSecondLanguage.getSelectedItemPosition()]);

            Call<SinugbuanonResponse> sinugbuanonResponseCall = services.translate(sinugbuanonRequest);

            sinugbuanonResponseCall.enqueue(new Callback<SinugbuanonResponse>() {
                @Override
                public void onResponse(Call<SinugbuanonResponse> call, Response<SinugbuanonResponse> response) {
                    if  (response.code() == 200 && response.isSuccessful() ) {
                        sinugbanonResult.setText(response.body().getTranslate());
                        kamayoResult.setText(response.body().getTranslate());
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

                sinugbanonResult.setText(sinugbanon.getTranslation());
                sinugbanonResult.setTextColor(Color.parseColor("black"));
            } else {
                // Insertion for cebuano word that not exists.
                sinugbanonResult.setTextColor(Color.parseColor("red"));
                sinugbanonResult.setText("Problem occur while translating your input.");
            }
*/

        });

    }

    private void setSpinnerValues() {
        String[] langauges = { "English", "Kamayo", "Sinugbuanon" };

        spinnerFirstLanguage = findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, langauges);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFirstLanguage.setAdapter(adapter);

        spinnerSecondLanguage = findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, langauges);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSecondLanguage.setAdapter(adapter2);
    }
}
