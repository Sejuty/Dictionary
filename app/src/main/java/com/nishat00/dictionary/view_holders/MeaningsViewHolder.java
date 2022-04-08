package com.nishat00.dictionary.view_holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nishat00.dictionary.R;

public class MeaningsViewHolder extends RecyclerView.ViewHolder {

    public TextView textview_partOfSpeech;
    public RecyclerView recyler_definitions;
    public TextView extra_synonyms;
    public TextView extra_antonyms;

    public MeaningsViewHolder(@NonNull View itemView) {
        super(itemView);
        textview_partOfSpeech = itemView.findViewById(R.id.textview_partOfSpeech);
        recyler_definitions = itemView.findViewById(R.id.recyler_definitions);
        extra_synonyms = (TextView) itemView.findViewById(R.id.extra_synonyms);
        extra_antonyms = (TextView) itemView.findViewById(R.id.extra_antonyms);
        //recyler_extra_synonyms = itemView.findViewById(R.id.recyler_extra_synonyms);

    }
}
