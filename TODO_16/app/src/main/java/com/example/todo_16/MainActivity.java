package com.example.todo_16;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private final LinkedList<String> mwordlist = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inserting the words
        for (int i = 0; i < 20; i++) {
            mwordlist.addLast("Word" + i);
        }

        mRecyclerView = findViewById(R.id.recycleview);
        mAdapter = new WordListAdapter(this, mwordlist);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.floatingActionButton1);
        fab.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int wordListSize = mwordlist.size();

                //adds new word to the wordlist
                mwordlist.addLast("+ Word " + wordListSize);

                //notifies the adapter that the data has been changed
                mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
                //it scrolls to the bottom
                mRecyclerView.smoothScrollToPosition(wordListSize);
            }
        });
    }
}