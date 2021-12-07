package com.example.td5_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    private final List<Contact> mContacts;

    public ContactsAdapter(List<Contact> contacts){
        mContacts = contacts;
    }
    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.item_contact, parent,false);
        return new ViewHolder(contactView,context);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact contact = mContacts.get(position);
        TextView firstNameTextView = holder.firstNameTextView;
        firstNameTextView.setText(contact.getmFirstName());
        TextView lastNameTextView = holder.lastNameTextView;
        lastNameTextView.setText(contact.getmLastName());
        ImageView mImageView = holder.mImageView;
        Glide.with(holder.context).load(contact.getmImageUrl()).into(mImageView);
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView firstNameTextView;
        public TextView lastNameTextView;
        public ImageView mImageView;
        public Context context;
        public ViewHolder(View itemView,Context ct){
            super(itemView);
            firstNameTextView = itemView.findViewById(R.id.textview_first_name);
            lastNameTextView = itemView.findViewById(R.id.textview_last_name);
            mImageView = itemView.findViewById(R.id.imageview);
            context=ct;
        }
    }
}
