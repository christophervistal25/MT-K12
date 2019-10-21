package com.vistalis.computerdictionary.Adapters;


import android.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.vistalis.computerdictionary.DatabaseModules.DB;
import com.vistalis.computerdictionary.DatabaseModules.Models.TranslationHistory;
import com.vistalis.computerdictionary.R;

import java.util.ArrayList;
import java.util.List;

public class TranslatedAdapter extends RecyclerView.Adapter<TranslatedAdapter.TranslatedHolder> {

    private List<TranslationHistory> translated;

    public TranslatedAdapter(List<TranslationHistory> translated) {
        this.translated = translated;
    }

    @Override
    public TranslatedHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.translated_recyclerview_layout, parent, false);
        return new TranslatedHolder(view);
    }

    @Override
    public void onBindViewHolder(TranslatedHolder holder, int position) {
        TranslationHistory translationHistory = translated.get(position);
        holder.txtTranslated.setText(
                String.format("[%s] \n%s - %s",
                        translationHistory.getProcess(),
                        translationHistory.getFrom_input(),
                        translationHistory.getTo_translate()
                )
        );


        holder.txtTranslated.setOnLongClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());

            builder.setTitle("Delete an item");
            builder.setCancelable(false);
            builder.setMessage("Are you sure?");

            builder.setPositiveButton("YES", (dialog, which) -> {
                DB.getInstance(v.getContext()).translationDao().delete(translated.get(position));
                translated.remove(position);
                translated = DB.getInstance(v.getContext()).translationDao().getAllTranslated();
                notifyItemRemoved(position);
            });

            builder.setNegativeButton("NO", (dialog, which) -> dialog.dismiss());

            AlertDialog alert = builder.create();
            alert.show();

            return true;
        });

    }



    @Override
    public int getItemCount() {
        return translated.size();
    }

    public void filterList(ArrayList<TranslationHistory> filteredList) {
        translated = filteredList;
        notifyDataSetChanged();
    }

    class TranslatedHolder extends RecyclerView.ViewHolder {
        TextView txtTranslated;


        public TranslatedHolder(View itemView) {
            super(itemView);

            txtTranslated = itemView.findViewById(R.id.translated);
//            btnFavorite = itemView.findViewById(R.id.btnFavorite);

        }
    }
}