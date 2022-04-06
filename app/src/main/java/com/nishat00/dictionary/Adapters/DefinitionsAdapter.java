package com.nishat00.dictionary.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nishat00.dictionary.R;
import com.nishat00.dictionary.model.Definitions;
import com.nishat00.dictionary.view_holders.DefinitionsViewHolder;

import java.util.List;

public class DefinitionsAdapter extends RecyclerView.Adapter<DefinitionsViewHolder> {

    private Context context;
    private List<Definitions> definitionsList;

    public DefinitionsAdapter(Context context, List<Definitions> definitionsList) {
        this.context = context;
        this.definitionsList = definitionsList;
    }

    @NonNull
    @Override
    public DefinitionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DefinitionsViewHolder(LayoutInflater.from(context).inflate(R.layout.definitions_list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DefinitionsViewHolder holder, int position) {
        holder.textview_definition.setText("Definition: "+definitionsList.get(position).getDefinition());
        holder.textview_example.setText("Example: "+definitionsList.get(position).getExample());


        StringBuilder synonyms = new StringBuilder();
        StringBuilder antonyms = new StringBuilder();


        synonyms.append(definitionsList.get(position).getSynonyms());
        antonyms.append(definitionsList.get(position).getAntonyms());

        //Log.i("Synonyms", synonyms.toString());

        holder.textview_synonyms.setText(synonyms);
        holder.textview_antonyms.setText(antonyms);

        holder.textview_synonyms.setSelected(true);
        holder.textview_antonyms.setSelected(true);

    }

    @Override
    public int getItemCount() {
        return definitionsList.size();
    }
}
