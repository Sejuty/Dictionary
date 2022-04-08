package com.nishat00.dictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.nishat00.dictionary.Adapters.MeaningsAdapter;
import com.nishat00.dictionary.Adapters.PhoneticsAdapter;

public class MainActivity extends AppCompatActivity {

    SearchView search_view;
    TextView textview_word;
    RecyclerView recyler_meanings,recyler_phonetics;
    ProgressDialog progressDialog;
    PhoneticsAdapter phoneticsAdapter;
    MeaningsAdapter meaningsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        search_view = findViewById(R.id.search_view);
        textview_word = findViewById(R.id.textview_word);
        recyler_phonetics = findViewById(R.id.recyler_phonetics);
        recyler_meanings = findViewById(R.id.recyler_meanings);

        progressDialog.setTitle("Loading... ");
        progressDialog.show();

        RetrofitBuilder retrofitBuilder = new RetrofitBuilder(MainActivity.this);
        retrofitBuilder.getCallResponse(listener, "heaven");

        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressDialog.setTitle("Fetching Response for "+query);
                progressDialog.show();

                RetrofitBuilder retrofitBuilder = new RetrofitBuilder(MainActivity.this);
                retrofitBuilder.getCallResponse(listener, query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private final OnFetchDataListener listener = new OnFetchDataListener() {
        @Override
        public void OnFetchData(DataModel dataModel, String message) {
            progressDialog.dismiss();
            if(dataModel ==null)
            {
                Toast.makeText(MainActivity.this, "No data found!!!", Toast.LENGTH_SHORT).show();
                return;
            }
            showData(dataModel);
        }

        @Override
        public void OnError(String message) {
            progressDialog.dismiss();
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private void showData(DataModel dataModel) {
      textview_word.setText("Word: "+ dataModel.getWord());

      recyler_phonetics.setHasFixedSize(true);
      recyler_phonetics.setLayoutManager(new GridLayoutManager(this,1));

      phoneticsAdapter = new PhoneticsAdapter(this, dataModel.getPhonetics());
      recyler_phonetics.setAdapter(phoneticsAdapter);

      recyler_meanings.setHasFixedSize(true);
      recyler_meanings.setLayoutManager(new GridLayoutManager(this,1));
      meaningsAdapter = new MeaningsAdapter(this, dataModel.getMeanings());
      recyler_meanings.setAdapter(meaningsAdapter);

    }
}