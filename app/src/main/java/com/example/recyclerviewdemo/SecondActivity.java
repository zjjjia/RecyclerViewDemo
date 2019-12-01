package com.example.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private RecyclerView mRlView;
    private Adapter mAdapter;

    private ArrayList<String> mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");

        mDataList = bundle.getStringArrayList("data");

        initRecyclerView();
    }

    private void initRecyclerView() {
        mRlView = findViewById(R.id.rl_list_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mRlView.setLayoutManager(layoutManager);
        mAdapter = new Adapter(this);
        mRlView.setAdapter(mAdapter);
        mAdapter.setItemDate(mDataList);
        mRlView.addItemDecoration(new HeaderItemDecoration());
    }
}
