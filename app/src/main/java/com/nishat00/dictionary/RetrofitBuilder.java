package com.nishat00.dictionary;

import android.content.Context;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class RetrofitBuilder {
    Context context;

    //retrofit builder
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.dictionaryapi.dev/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public RetrofitBuilder(Context context) {
        this.context = context;
    }

    public void getCallResponse(OnFetchDataListener listener, String word) {

        //create instances of CallDictionary
        variableUrl variableUrl = retrofit.create(variableUrl.class);

        Call<List<DataModel>> call = variableUrl.callData(word);

        try {
            call.enqueue(new Callback<List<DataModel>>() {
                @Override
                public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {
                    if (!response.isSuccessful()) {
                        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    listener.OnFetchData(response.body().get(0),response.message());
                }

                @Override
                public void onFailure(Call<List<DataModel>> call, Throwable t) {
                    listener.OnError("Request Failed!!!");

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "An error occurred!!", Toast.LENGTH_SHORT).show();
        }
    }

    public interface variableUrl {
        @GET("entries/en/{word}")
        Call<List<DataModel>> callData(
                @Path("word") String word
        );
    }
}
