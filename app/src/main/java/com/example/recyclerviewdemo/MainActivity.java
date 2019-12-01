package com.example.recyclerviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button startSecondBtn;

    private RecyclerView mRlView;
    private Adapter mAdapter;

    private ArrayList<String> mDateList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initDate();

        mRlView = findViewById(R.id.rl_list_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mRlView.setLayoutManager(layoutManager);

        mAdapter = new Adapter(this);
        mRlView.setAdapter(mAdapter);
        mAdapter.setItemDate(mDateList);
        mRlView.addItemDecoration(new ItemDecorationSimple());
    }

    private void initView() {
        startSecondBtn = findViewById(R.id.button);

        startSecondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("data", mDateList);
                intent.putExtra("data", bundle);
                startActivity(intent);
            }
        });
    }

    private void initDate() {
        for (int i = 0; i < 30; i++) {
            mDateList.add("item-" + i);
        }
    }
}
