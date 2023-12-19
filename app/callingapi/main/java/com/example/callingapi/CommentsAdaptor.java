package com.example.callingapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CommentsAdaptor extends RecyclerView.Adapter<CommentsAdaptor.ViewHolder> {
    Context context;
    List<CommentModal> comts;

    public CommentsAdaptor(Context context, List<CommentModal> commentlist) {
        this.context=context;
        this.comts=commentlist;
    }


    @NonNull
    @Override
    public CommentsAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.comments_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsAdaptor.ViewHolder holder, int position) {
        CommentModal comt = comts.get(position);
        holder.commentId.setText(comt.getId().toString());
        holder.name.setText(comt.getName());
        holder.email.setText(comt.getEmail());
        holder.body.setText(comt.getBody());
//        postLayout

    }

    @Override
    public int getItemCount() {
        return comts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView commentId, name, email, body;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            commentId = itemView.findViewById(R.id.CommentId);
            name = itemView.findViewById(R.id.Name);
            email = itemView.findViewById(R.id.email);
            body = itemView.findViewById(R.id.body);

        }
    }
}
