package com.example.td6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private RepoList repos;
    private Context context;

    public MyAdapter(RepoList repos, Context context) {
        this.repos = repos;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        holder.repo_name.setText(repos.getItems(position).getName());
        holder.repo_full_name.setText(repos.getItems(position).getFull_name());
        holder.repo_id.setText(String.valueOf(repos.getItems(position).getId()));
    }

    @Override
    public int getItemCount() {
        return repos.getSize();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView repo_name,repo_full_name,repo_id;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            repo_name = itemView.findViewById(R.id.repo_name);
            repo_full_name = itemView.findViewById(R.id.repo_full_name);
            repo_id = itemView.findViewById(R.id.repo_id);

        }
    }
}
