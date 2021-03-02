package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TrafficStyle {
    private int mCongestedColor = -46250;
    private int mCongestedStrokeColor = this.mCongestedColor;
    private int mSeriousCongestedColor = -7300827;
    private int mSeriousCongestedStrokeColor = this.mSeriousCongestedColor;
    private int mSlowColor = -16128;
    private int mSlowStrokeColor = this.mSlowColor;
    private int mSmoothColor = -16722688;
    private int mSmoothStrokeColor = this.mSmoothColor;
    private int mStrokeWidth = 0;
    private int mWidth = 3;

    public TrafficStyle() {
        AppMethodBeat.i(193617);
        AppMethodBeat.o(193617);
    }

    public TrafficStyle setWidth(int i2) {
        this.mWidth = i2;
        return this;
    }

    public TrafficStyle setStrokeWidth(int i2) {
        this.mStrokeWidth = i2;
        return this;
    }

    public TrafficStyle setSmoothColor(int i2) {
        this.mSmoothColor = i2;
        return this;
    }

    public TrafficStyle setSlowColor(int i2) {
        this.mSlowColor = i2;
        return this;
    }

    public TrafficStyle setCongestedColor(int i2) {
        this.mCongestedColor = i2;
        return this;
    }

    public TrafficStyle setSeriousCongestedColor(int i2) {
        this.mSeriousCongestedColor = i2;
        return this;
    }

    public TrafficStyle setSmoothStrokeColor(int i2) {
        this.mSmoothStrokeColor = i2;
        return this;
    }

    public TrafficStyle setSlowStrokeColor(int i2) {
        this.mSlowStrokeColor = i2;
        return this;
    }

    public TrafficStyle setCongestedStrokeColor(int i2) {
        this.mCongestedStrokeColor = i2;
        return this;
    }

    public TrafficStyle setSeriousCongestedStrokeColor(int i2) {
        this.mSeriousCongestedStrokeColor = i2;
        return this;
    }

    public String toString() {
        AppMethodBeat.i(193618);
        String str = "TrafficStyle{mWidth=" + this.mWidth + ", mStrokeWidth=" + this.mStrokeWidth + ", mSmoothColor=" + this.mSmoothColor + ", mSlowColor=" + this.mSlowColor + ", mCongestedColor=" + this.mCongestedColor + ", mSeriousCongestedColor=" + this.mSeriousCongestedColor + ", mSmoothStrokeColor=" + this.mSmoothStrokeColor + ", mSlowStrokeColor=" + this.mSlowStrokeColor + ", mCongestedStrokeColor=" + this.mCongestedStrokeColor + ", mSeriousCongestedStrokeColor=" + this.mSeriousCongestedStrokeColor + '}';
        AppMethodBeat.o(193618);
        return str;
    }
}
