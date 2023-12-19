package com.example.callingapi.DateApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DisModal {
    @SerializedName("product_id")
    @Expose
    private String product_id;

    @SerializedName("product_mpn")
    @Expose
    private String product_mpn;

    @SerializedName("brand_id")
    @Expose
    private String brand_id;
    @SerializedName("product_name")
    @Expose
    private String product_name;

    @SerializedName("product_image")
    @Expose
    private Integer product_image; //image

    @SerializedName("gcode")
    @Expose
    private String gcode;

    @SerializedName("msrp")
    @Expose
    private String msrp;
    @SerializedName("brand_name")
    @Expose
    private String brand_name;

    @SerializedName("brand_key")
    @Expose
    private String brand_key;

    @SerializedName("main_image")
    @Expose
    private Integer main_image;

    @SerializedName("vendor_url")
    @Expose
    private String vendor_url;

    public DisModal(String product_id, String product_mpn, String product_name, Integer product_image,
                    String gcode, String msrp, String brand_name, String brand_key, Integer main_image, String vendor_url,String brand_id) {
        this.product_id = product_id;
        this.product_mpn = product_mpn;
        this.product_name = product_name;
        this.product_image = product_image;
        this.msrp = msrp;
        this.gcode = gcode;
        this.brand_name = brand_name;
        this.brand_key = brand_key;
        this.main_image = main_image;
        this.vendor_url = vendor_url;
        this.brand_id=brand_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_mpn() {
        return product_mpn;
    }

    public String getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(String brand_id) {
        this.brand_id = brand_id;
    }

    public void setProduct_mpn(String product_mpn) {
        this.product_mpn = product_mpn;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getProduct_image() {
        return product_image;
    }

    public void setProduct_image(Integer product_image) {
        this.product_image = product_image;
    }

    public String getGcode() {
        return gcode;
    }

    public void setGcode(String gcode) {
        this.gcode = gcode;
    }

    public String getMsrp() {
        return msrp;
    }

    public void setMsrp(String msrp) {
        this.msrp = msrp;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getBrand_key() {
        return brand_key;
    }

    public void setBrand_key(String brand_key) {
        this.brand_key = brand_key;
    }

    public Integer getMain_image() {
        return main_image;
    }

    public void setMain_image(Integer main_image) {
        this.main_image = main_image;
    }

    public String getVendor_url() {
        return vendor_url;
    }

    public void setVendor_url(String vendor_url) {
        this.vendor_url = vendor_url;
    }
}
