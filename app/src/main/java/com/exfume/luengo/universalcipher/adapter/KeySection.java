package com.exfume.luengo.universalcipher.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.exfume.luengo.universalcipher.R;
import com.exfume.luengo.universalcipher.model.Key;

import java.util.ArrayList;

import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;

public class KeySection extends StatelessSection {

    ArrayList<Key> mDataset;
    String category;
    NotifyListener listener;

    public KeySection(ArrayList<Key> keys,String category){
        super(R.layout.key_header,R.layout.key_item);
        this.mDataset = keys;
        this.category = category;
    }

    public void add (Key key){
        mDataset.add(0,key);
        OnInsert(0);
    }

    public void setNotifyListener(NotifyListener listener){
        this.listener = listener;
    }

    @Override
    public int getContentItemsTotal() {
        return mDataset.size();
    }



    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new KeyHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, final int position) {
        KeyHolder keyHolder = (KeyHolder) holder;
        final Key key = mDataset.get(position);
        keyHolder.keyName.setText(key.getName());
        keyHolder.keyType.setText(key.getExtension());

    }



    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new HeaderHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
        HeaderHolder headerHolder = (HeaderHolder) holder;
        headerHolder.keyCategory.setText(category);
        headerHolder.keyCount.setText(mDataset.size()+"");

    }



    public static class KeyHolder extends RecyclerView.ViewHolder {
        TextView keyName;
        TextView keyType;
        CardView card;

        public KeyHolder(View itemView) {
            super(itemView);
            keyName = (TextView) itemView.findViewById(R.id.key_name);
            keyType = (TextView) itemView.findViewById(R.id.key_type);
            card = (CardView) itemView.findViewById(R.id.key_cardview);
        }
    }

    public static class HeaderHolder extends RecyclerView.ViewHolder {
        TextView keyCategory;
        TextView keyCount;

        public HeaderHolder(View itemView) {
            super(itemView);
            keyCategory = (TextView) itemView.findViewById(R.id.key_category);
            keyCount = (TextView) itemView.findViewById(R.id.key_count);
        }
    }


    public interface NotifyListener{
        void onInsert(int position);
        void onDelete(int position);
    }

    private void OnInsert(int pos){
        if (listener != null)
                listener.onInsert(pos);
    }
    private void OnDelete(int pos){
        if (listener != null)
            listener.onDelete(pos);
    }
}
