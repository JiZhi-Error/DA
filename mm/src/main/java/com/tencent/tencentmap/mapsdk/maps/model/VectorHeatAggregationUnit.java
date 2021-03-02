package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.map.sdk.utilities.heatmap.WeightedLatLng;

public class VectorHeatAggregationUnit {
    private LatLng mCenter;
    private double mIntensity;
    private WeightedLatLng[] mNodes;

    private VectorHeatAggregationUnit() {
    }

    private VectorHeatAggregationUnit(LatLng latLng, double d2, WeightedLatLng[] weightedLatLngArr) {
        this.mCenter = latLng;
        this.mIntensity = d2;
        this.mNodes = weightedLatLngArr;
    }

    public LatLng getCenter() {
        return this.mCenter;
    }

    public double getIntensity() {
        return this.mIntensity;
    }

    public WeightedLatLng[] getNodes() {
        return this.mNodes;
    }
}
