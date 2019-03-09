package com.example.bottomspace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // Set to true to break the layout; false for it to work.
    // The setting of this flag should only matter for the layout "activity_not_working."
    private boolean mBreakIt = true;

    private final LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
    private RecyclerViewAdapter mAdapter;
    private List<String> mItems = new ArrayList<>();
    private RecyclerView mRecycler;

    private int mLayoutToUse = R.layout.activity_not_working;
//    private int mLayoutToUse = R.layout.activity_working;

    private CoordinatorLayout mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mLayoutToUse);


        for (int i = 0; i < 3; i++) {
            mItems.add("Item #" + i);
        }

        mRecycler = findViewById(R.id.recyclerView);
        mAdapter = new RecyclerViewAdapter(mItems);
        mRecycler.setLayoutManager(mLayoutManager);
        mRecycler.setAdapter(mAdapter);

        mLayout = findViewById(R.id.layout);

        if (mBreakIt) {
            mLayout.post(new Runnable() {
                @Override
                public void run() {
                    int itemCount = mItems.size();
                    addViews();
                    mAdapter.notifyItemRangeChanged(itemCount, mItems.size());
                }
            });
        } else {
            int itemCount = mItems.size();
            addViews();
            mAdapter.notifyItemRangeChanged(itemCount, mItems.size());
        }
    }

    private void addViews() {
        for (int i = 0; i < 20; i++) {
            TextView tv = new TextView(MainActivity.this);
            tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            mItems.add("Added item #" + (i + 1));
        }
    }
}
