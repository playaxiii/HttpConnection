package com.axiii.httpconnection.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.axiii.httpconnection.MainActivity;
import com.axiii.httpconnection.R;
import com.axiii.httpconnection.model.MyDataModel;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<MyDataModel> dataList;

    public MyAdapter() {
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MyAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
        MyDataModel data = dataList.get(position);
        holder.titleTextView.setText(data.getTitle());

        // set click listener in toast message
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Index " + holder.getAdapterPosition() + " Clicked: " + data.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public void submitList(List<MyDataModel> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.itemNameTextView);
        }
    }
}
