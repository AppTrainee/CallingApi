package com.example.callingapi.DateApi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.callingapi.R;

import java.util.List;

public class DisRecycAdaptor extends RecyclerView.Adapter<DisRecycAdaptor.DataHolder> {
    Context context;

    List<DisModal> discoList;
    String vendorLink,prodImglink;

    public DisRecycAdaptor(Context context, List<DisModal> dataList) {
        this.context = context;
        this.discoList = dataList;
    }

    @NonNull
    @Override
    public DisRecycAdaptor.DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.discount_layout, parent, false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DisRecycAdaptor.DataHolder holder, int position) {
        DisModal disList = discoList.get(position);

        holder.productid.setText(disList.getProduct_id());
        holder.productMpn.setText(disList.getProduct_mpn());
        holder.brandId.setText(disList.getBrand_id());
        holder.productName.setText(disList.getProduct_name());
        holder.gcode.setText(disList.getGcode());
        holder.msrp.setText(disList.getMsrp());
        holder.brandName.setText(disList.getBrand_name());
        holder.brandKey.setText(disList.getBrand_key());
        vendorLink = disList.getVendor_url();
        prodImglink=disList.getProduct_image();

        try {
            holder.mainImg.setText(disList.getMain_image());
        }catch (Exception e){
            try {
                throw new Exception(e);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public int getItemCount() {
        return discoList.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder {
        TextView productid, productMpn, brandId, productName, gcode, msrp, brandName, brandKey, mainImg, vendorUrl;
ImageView productImg;
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
            mainImg=itemView.findViewById(R.id.main_Image);
            Glide.with(context).load(prodImglink).into(productImg);
            vendorUrl = itemView.findViewById(R.id.vendor_url);
            vendorUrl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent link1 = new Intent();
                    link1.setAction(Intent.ACTION_VIEW);
                    link1.setData(Uri.parse(vendorLink));
                    context.startActivity(link1);
                }
            });
//            productImg=itemView.findViewById(R.id.product_image);

            productImg=itemView.findViewById(R.id.product_image);
            productImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent link2 = new Intent();
                    link2.setAction(Intent.ACTION_VIEW);
                    link2.setData(Uri.parse(prodImglink));
                    context.startActivity(link2);

                }
            });

        }
    }
}
