package com.nishat00.dictionary.view_holders;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nishat00.dictionary.R;

public class PhoneticsViewHolder extends RecyclerView.ViewHolder {

    public TextView textview_phonetics;
    public ImageButton image_button_audio;

    public PhoneticsViewHolder(@NonNull View itemView) {
        super(itemView);
        textview_phonetics = itemView.findViewById(R.id.textview_phonetics);
        image_button_audio= itemView.findViewById(R.id.image_button_audio);

    }
}
