package com.nishat00.dictionary.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nishat00.dictionary.R;
import com.nishat00.dictionary.model.Meanings;
import com.nishat00.dictionary.view_holders.MeaningsViewHolder;

import java.util.List;

public class MeaningsAdapter extends RecyclerView.Adapter<MeaningsViewHolder> {

    private Context context;
    private List<Meanings> meaningsList;

    public MeaningsAdapter(Context context, List<Meanings> meaningsList) {
        this.context = context;
        this.meaningsList = meaningsList;
    }

    @NonNull
    @Override
    public MeaningsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MeaningsViewHolder(LayoutInflater.from(context).inflate(R.layout.meanings_list_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull MeaningsViewHolder holder, int position) {
        holder.textview_partOfSpeech.setText("Parts of Speech: " + meaningsList.get(position).getPartOfSpeech());

        holder.recyler_definitions.setHasFixedSize(true);
        holder.recyler_definitions.setLayoutManager(new GridLayoutManager(context, 1));

        DefinitionsAdapter definitionsAdapter = new DefinitionsAdapter(context, meaningsList.get(position).getDefinitions());
        holder.recyler_definitions.setAdapter(definitionsAdapter);

        StringBuilder synonyms = new StringBuilder();
        StringBuilder antonyms = new StringBuilder();

        synonyms.append(meaningsList.get(position).getSynonyms());
        antonyms.append(meaningsList.get(position).getAntonyms());

        Log.i("Synonyms", synonyms.toString());
        Log.i("Antonyms", antonyms.toString());

        holder.extra_synonyms.setText(synonyms);
        holder.extra_antonyms.setText(antonyms);

        holder.extra_synonyms.setSelected(true);
        holder.extra_antonyms.setSelected(true);


    }

    @Override
    public int getItemCount() {
        return meaningsList.size();
    }
}
