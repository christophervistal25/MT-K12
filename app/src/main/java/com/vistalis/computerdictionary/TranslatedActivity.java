package com.vistalis.computerdictionary;

import android.graphics.Color;
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
import android.widget.Toast;

import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;
import com.shashank.sony.fancydialoglib.FancyAlertDialogListener;
import com.shashank.sony.fancydialoglib.Icon;
import com.vistalis.computerdictionary.Adapters.PhraseAdapter;
import com.vistalis.computerdictionary.Adapters.TranslatedAdapter;
import com.vistalis.computerdictionary.DatabaseModules.DB;
import com.vistalis.computerdictionary.DatabaseModules.Models.TranslationHistory;
import com.vistalis.computerdictionary.DatabaseModules.Models.Word;
import com.vistalis.computerdictionary.Helpers.SharedPref;

import java.util.ArrayList;
import java.util.List;

public class TranslatedActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TranslatedAdapter translatedAdapter;
    LinearLayoutManager layoutManager;
    List<TranslationHistory> translatedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translated);
        this.setActivityToFullScreen();
        this.buildRecyclerView();
        this.displayMessageDialog();
        findViewById(R.id.translatedLayout).requestFocus();

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


    }

    private void filter(String text) {
        ArrayList<TranslationHistory> filteredList = new ArrayList<>();

        for (TranslationHistory item : translatedList) {
            if (item.getFrom_input().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        translatedAdapter.filterList(filteredList);
    }


    private void displayMessageDialog()
    {
        // Check if first time in shared pref.
        //if so display this message
        //otherwise ignore.
        boolean isDisplayed = SharedPref.getSharedPreferenceBoolean(this,"is_already_displayed", false);
        if(!isDisplayed) {
            new FancyAlertDialog.Builder(this)
                    .setTitle("Message")
                    .setBackgroundColor(Color.parseColor("#303F9F"))  //Don't pass R.color.colorvalue
                    .setMessage("If you want to delete some items just long press the translated phrase/word.")
                    .setPositiveBtnText("")
                    .setPositiveBtnBackground(Color.parseColor("#FFA9A7A8"))  //Don't pass R.color.colorvalue
                    .setPositiveBtnText("Okay")
                    .setNegativeBtnBackground(Color.parseColor("#FFFFFF"))  //Don't pass R.color.colorvalue
                    .setAnimation(Animation.POP)
                    .isCancellable(true)
                    .setIcon(R.drawable.ic_info_black_24dp, Icon.Visible)
                    .OnNegativeClicked(() -> Toast.makeText(getApplicationContext(),"Okay",Toast.LENGTH_SHORT).show())
                    .build();
        }
        SharedPref.setSharedPreferenceBoolean(this,"is_already_displayed", true);
    }

    private void buildRecyclerView() {

        translatedList = DB.getInstance(this).translationDao().getAllTranslated();

        translatedAdapter = new TranslatedAdapter(translatedList);

        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.addItemDecoration(
                new DividerItemDecoration(this,
                        LinearLayoutManager.VERTICAL)
        );


        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(translatedAdapter);

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
