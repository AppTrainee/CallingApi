package com.example.callingapi;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdaptor extends RecyclerView.Adapter<RecyclerAdaptor.ViewHolder> {
    Context context;
    List<apiModal> listdata;
    LinearLayout postLayout;
    apiModal responsedata;


    public RecyclerAdaptor(Context context, List<apiModal> listdata) {
        this.context = context;
        this.listdata = listdata;
    }

//    public RecyclerAdaptor(Context context,apiModal responsedata) {
//        this.context = context;
//        this.responsedata=responsedata;
//    }

    @NonNull
    @Override
    public RecyclerAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.api_recycler_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdaptor.ViewHolder holder, int position) {
        apiModal data = listdata.get(position);

        holder.userId.setText(data.getUserId());
        holder.id.setText(data.getId());
        holder.title.setText(data.getTitle());
        holder.body.setText(data.getBody());
        postLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,CommentRecycler.class);
                i.putExtra("id",data.getId());
                i.putExtra("title",data.getTitle());
                context.startActivity(i);
            }
        });

//
//        /*for Post method */
//
//        holder.userId.setText(data.getUserId());
//        holder.title.setText(data.getTitle());
//        holder.body.setText(data.getBody());
//        holder.body.setText(responsedata.getUserId());
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userId, id, title,body;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userId = itemView.findViewById(R.id.userId);
            id = itemView.findViewById(R.id.idd);
            title = itemView.findViewById(R.id.titlee);
            body=itemView.findViewById(R.id.bodyy);
            postLayout=itemView.findViewById(R.id.postLayout);
        }
    }
}
