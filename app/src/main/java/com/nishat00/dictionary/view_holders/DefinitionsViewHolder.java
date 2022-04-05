package com.nishat00.dictionary.view_holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nishat00.dictionary.R;

public class DefinitionsViewHolder extends RecyclerView.ViewHolder {

    public TextView textview_definition, textview_example, textview_synonyms, textview_antonyms;

    public DefinitionsViewHolder(@NonNull View itemView) {
        super(itemView);
        textview_definition = itemView.findViewById(R.id.textview_definition);
        textview_example = itemView.findViewById(R.id. textview_example);
        textview_synonyms = itemView.findViewById(R.id.textview_synonyms);
        textview_antonyms = itemView.findViewById(R.id. textview_antonyms);
    }

}
