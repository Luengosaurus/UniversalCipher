package com.exfume.luengo.universalcipher.key;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.exfume.luengo.universalcipher.R;
import com.exfume.luengo.universalcipher.adapter.KeySection;
import com.exfume.luengo.universalcipher.model.Key;
import com.exfume.luengo.universalcipher.utils.FileManager;

import org.bouncycastle.util.encoders.Hex;

import java.security.SecureRandom;
import java.util.ArrayList;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;


public class AES extends Fragment{

    SectionedRecyclerViewAdapter sectionAdapter;
    KeySection keySection;
    FileManager fileManager;
    final int blockSize = 16;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.key_layout, container, false);
        fileManager = new FileManager(getContext());
        ArrayList<Key> keys = fileManager.getKeys("aeskeyiv");
        keySection = new KeySection(keys,getString(R.string.keys));
        keySection.setNotifyListener(new KeySection.NotifyListener() {
            @Override
            public void onInsert(int position) {
                sectionAdapter.notifyItemInserted(position);
            }

            @Override
            public void onDelete(int position) {
                sectionAdapter.notifyItemRemoved(position);
            }
        });
        sectionAdapter = new SectionedRecyclerViewAdapter();
        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.key_recycler);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        sectionAdapter.addSection(keySection);
        mRecyclerView.setAdapter(sectionAdapter);
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.mFAB);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }


    public void doGenerateKey(String filename) {
        byte[] key = generateKeyAndIV();
        if (key != null) {
            Key file = fileManager.saveFile(filename+".aeskeyiv",Hex.encode(key));
            keySection.add(file);
        }
    }

    public byte[] generateKeyAndIV() {
        SecureRandom sr;
        try {
            sr = new SecureRandom();
            sr.setSeed(getString(R.string.random).getBytes());
        } catch (Exception e) {
            return null;
        }
        return sr.generateSeed(24 + blockSize + 10);
    }
}
