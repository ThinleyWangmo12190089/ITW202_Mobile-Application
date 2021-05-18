package com.example.todo_18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<Sport> mSportsData;
    private SportsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        //initializing the recyclerview
        mRecyclerView = findViewById(R.id.recycler);

        //recycleview dont have layout manager thats why we set the layoutmanager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));

        //initializing the arraylist to store the data
        mSportsData = new ArrayList<>();

        //initializing the adapter and set the adapter to recyclerview
        mAdapter = new SportsAdapter(this, mSportsData);
        mRecyclerView.setAdapter(mAdapter);

        initializeData();
    }
    private void initializeData() {
        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.sports_image);
        String[] sportsList = getResources().getStringArray(R.array.sports_title);
        String[] sportsInfo = getResources().getStringArray(R.array.sports_info);

        mSportsData.clear();


        for(int i=0; i<sportsList.length; i++) {
            mSportsData.add(new Sport(sportsList[i],sportsInfo[i],sportsImageResources.getResourceId(i, 0)));
        }
        //notifying the adapter of the change
        mAdapter.notifyDataSetChanged();
        sportsImageResources.recycle();
    }
}