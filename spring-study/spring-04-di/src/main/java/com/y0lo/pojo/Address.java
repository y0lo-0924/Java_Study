package com.y0lo.pojo;

public class Address {
    private String Address;

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "Address='" + Address + '\'' +
                '}';
    }
}
