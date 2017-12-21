package com.example.junjie.learning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public class MainActivity extends BaseActivity {
    private RecyclerView mMainRecyclerView;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
         mMainRecyclerView = findView(R.id.main_activity_recycleview);
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initList() {
         linearLayoutManager = new LinearLayoutManager(this);
        mMainRecyclerView.setLayoutManager(linearLayoutManager);
        mMainRecyclerView.setHasFixedSize(true);

    }

    private class MainRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }
}
