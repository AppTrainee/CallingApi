package com.example.callingapi.DateApi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.callingapi.R;

import java.util.List;

public class DisRecycAdaptor extends RecyclerView.Adapter<DisRecycAdaptor.DataHolder> {
    Context context;

    List<DisModal> discountList;

    public DisRecycAdaptor(Context context, List<DisModal> dataList) {
        this.context=context;
        this.discountList=dataList;
    }

    @NonNull
    @Override
    public DisRecycAdaptor.DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.discount_layout, parent, false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DisRecycAdaptor.DataHolder holder, int position) {
        DisModal disList = discountList.get(position);
        holder.productid.setText(disList.getProduct_id());
        holder.productMpn.setText(disList.getProduct_mpn());
        holder.brandId.setText(disList.getBrand_id());
        holder.productName.setText(disList.getProduct_name());
        holder.gcode.setText(disList.getGcode());
        holder.msrp.setText(disList.getMsrp());
        holder.brandName.setText(disList.getBrand_name());
        holder.brandKey.setText(disList.getBrand_key());
    }

    @Override
    public int getItemCount() {
        return discountList.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder {
        TextView productid, productMpn, brandId, productName, gcode, msrp, brandName, brandKey, main_Image;

        public DataHolder(@NonNull View itemView) {
            super(itemView);
            productid = itemView.findViewById(R.id.productid);
            productMpn = itemView.findViewById(R.id.productMpn);
            brandId = itemView.findViewById(R.id.brandId);
            productName = itemView.findViewById(R.id.productName);
            gcode = itemView.findViewById(R.id.gcode);
            msrp = itemView.findViewById(R.id.msrp);
            brandName = itemView.findViewById(R.id.brandName);
            brandKey = itemView.findViewById(R.id.brandKey);
        }
    }
}
