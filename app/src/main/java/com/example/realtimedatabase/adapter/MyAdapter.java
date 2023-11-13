package com.example.realtimedatabase.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.realtimedatabase.R;
import com.example.realtimedatabase.model.DataClass;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<DataClass> list;

    public MyAdapter(List<DataClass> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,false);
        return  new ViewHolder(view);
    }

    /**
     *
     * List >> DataClass
     * title, Desc
     *
     * i = 0
     * title >> Hello
     * desc >> Welcome to the new jfbsdxkfg
     *
     * i = 1
     * title >> asajdf
     * desc >> ghskugfygsdhfdsfg
     *
     */
    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.desc.setText(list.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView title, desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.text_view_title);
            desc = itemView.findViewById(R.id.text_view_desc);
        }
    }
}
