package com.example.junjie.learning.View;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.junjie.learning.BR;
import com.example.junjie.learning.Model.Data.Bean.User;
import com.example.junjie.learning.R;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private RecyclerView mMainRecyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<User> mUsers;


    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        mMainRecyclerView = findView(R.id.main_activity_recycleview);
    }

    @Override
    protected void initData() {
        super.initData();
        mUsers = new ArrayList<User>();
        mUsers.add(new User("lu", "30", "male"));
        mUsers.add(new User("wu", "20", "female"));
    }

    @Override
    protected void initList() {
//        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        linearLayoutManager = new LinearLayoutManager(this);
        mMainRecyclerView.setLayoutManager(linearLayoutManager);
        mMainRecyclerView.setHasFixedSize(true);
        mMainRecyclerView.setAdapter(new MainRecyclerViewAdapter(mUsers));
    }

    private class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder> {
        private ArrayList<User> mData = new ArrayList<>();

        private MainRecyclerViewAdapter(ArrayList<User> users) {
            mData.addAll(users);
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.main_recyclerview_item, parent, false);
            ViewHolder holder = new ViewHolder(binding.getRoot());
            holder.setBinding(binding);
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.getBinding().setVariable(BR.user, mData.get(position));
            holder.getBinding().executePendingBindings();
        }


        @Override
        public int getItemCount() {
            return mData.size();
        }


        class ViewHolder extends RecyclerView.ViewHolder {
            private ViewDataBinding binding;

            public ViewHolder(View itemView) {
                super(itemView);
            }

            public void setBinding(ViewDataBinding binding) {
                this.binding = binding;
            }

            public ViewDataBinding getBinding() {
                return this.binding;
            }

        }
    }


}
