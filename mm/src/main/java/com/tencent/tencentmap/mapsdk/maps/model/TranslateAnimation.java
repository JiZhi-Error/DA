package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class TranslateAnimation extends BaseAnimation {
    public LatLng mTargetLatLng;

    public TranslateAnimation(LatLng latLng) {
        AppMethodBeat.i(173394);
        this.mTargetLatLng = latLng;
        AppMethodBeat.o(173394);
    }
}
