package com.nishat00.dictionary.view_holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nishat00.dictionary.R;

public class MeaningsViewHolder extends RecyclerView.ViewHolder {

    public TextView textview_partOfSpeech;
    public RecyclerView recyler_definitions;
    public MeaningsViewHolder(@NonNull View itemView) {
        super(itemView);
        textview_partOfSpeech = itemView.findViewById(R.id.textview_partOfSpeech);
        recyler_definitions = itemView.findViewById(R.id.recyler_definitions);

    }
}
