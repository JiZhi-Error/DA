package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MapPoi {
    private double latitude;
    private double longitude;
    public String name;
    public LatLng position;

    public MapPoi() {
    }

    public MapPoi(double d2, double d3) {
        AppMethodBeat.i(193609);
        this.latitude = d2;
        this.longitude = d3;
        this.position = new LatLng(d2, d3);
        AppMethodBeat.o(193609);
    }

    public MapPoi(double d2, double d3, String str) {
        this(d2, d3);
        this.name = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public void setPosition(LatLng latLng) {
        AppMethodBeat.i(193610);
        this.position = latLng;
        this.latitude = latLng.getLatitude();
        this.longitude = latLng.getLongitude();
        AppMethodBeat.o(193610);
    }

    public LatLng getPosition() {
        return this.position;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }
}
