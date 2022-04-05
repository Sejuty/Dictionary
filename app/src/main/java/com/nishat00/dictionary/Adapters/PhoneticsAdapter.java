package com.nishat00.dictionary.Adapters;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nishat00.dictionary.R;
import com.nishat00.dictionary.model.Phonetics;
import com.nishat00.dictionary.view_holders.PhoneticsViewHolder;

import java.io.IOException;
import java.util.List;

public class PhoneticsAdapter extends RecyclerView.Adapter<PhoneticsViewHolder> {

    private Context context;
    private List<Phonetics> phoneticsList;

    public PhoneticsAdapter(Context context, List<Phonetics> phoneticsList) {
        this.context = context;
        this.phoneticsList = phoneticsList;
    }

    @NonNull
    @Override
    public PhoneticsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PhoneticsViewHolder(LayoutInflater.from(context).inflate(R.layout.phonetics_list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneticsViewHolder holder, int position) {
        holder.textview_phonetics.setText(phoneticsList.get(position).getText());
        holder.image_button_audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer player = new MediaPlayer();
                try {
                    String url = phoneticsList.get(holder.getAdapterPosition()).getAudio();
                    player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    player.setDataSource(url);
                    Log.i("Audio",url);
                    player.prepare();
                    player.start();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(context, "Couldn't Play Audio...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return phoneticsList.size();
    }
}
