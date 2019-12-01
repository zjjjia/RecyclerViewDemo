package com.example.recyclerviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context mContext;

    private ArrayList<String> mItemDateList = new ArrayList<>();

    public Adapter(Context context) {
        mContext = context;
    }

    public void setItemDate(ArrayList<String> itemDateList) {
        if(mItemDateList == null){
            return;
        }
        this.mItemDateList = itemDateList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_rl_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemText.setText(mItemDateList.get(position));
    }

    @Override
    public int getItemCount() {
        return mItemDateList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemText = itemView.findViewById(R.id.text_view);
        }
    }
}
