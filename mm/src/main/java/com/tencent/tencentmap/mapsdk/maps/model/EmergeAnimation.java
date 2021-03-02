package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class EmergeAnimation extends BaseAnimation {
    public LatLng mStartPoint;

    public EmergeAnimation(LatLng latLng) {
        AppMethodBeat.i(173136);
        this.mStartPoint = latLng;
        AppMethodBeat.o(173136);
    }

    public LatLng getStartPoint() {
        return this.mStartPoint;
    }
}
