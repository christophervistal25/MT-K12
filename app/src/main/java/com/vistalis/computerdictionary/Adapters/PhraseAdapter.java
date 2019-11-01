package com.vistalis.computerdictionary.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vistalis.computerdictionary.DatabaseModules.Models.Phrase;
import com.vistalis.computerdictionary.R;

import java.util.ArrayList;
import java.util.List;

public class PhraseAdapter extends RecyclerView.Adapter<PhraseAdapter.PhraseHolder> {

    private List<Phrase> list_word;

    public PhraseAdapter(List<Phrase> list_word) {
        this.list_word = list_word;
    }

    @Override
    public PhraseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.phrase_layout, parent, false);
        return new PhraseHolder(view);
    }

    @Override
    public void onBindViewHolder(PhraseHolder holder, int position) {
        Phrase word = list_word.get(position);
        Context context = holder.word.getContext();

        String dialect = (word.getDialect() == 1) ? "KAMAYO" : "SINUGBUANON";

        holder.word.setText(String.format("%s - %s", word.getEnglish_word(), dialect));




        holder.word.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(word.getEnglish_word());
            builder.setMessage(word.getTranslation()).create().show();
        });

    }

    @Override
    public int getItemCount() {
        return list_word.size();
    }

    public void filterList(ArrayList<Phrase> filteredList) {
        list_word = filteredList;
        notifyDataSetChanged();
    }

    class PhraseHolder extends RecyclerView.ViewHolder {
        TextView word;

        public PhraseHolder(View itemView) {
            super(itemView);
            word = itemView.findViewById(R.id.word);
        }
    }
}