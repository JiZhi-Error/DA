package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class AlphaAnimation extends BaseAnimation {
    public float mFromAlpha;
    public float mToAlpha;

    public AlphaAnimation(float f2, float f3) {
        AppMethodBeat.i(173072);
        this.mFromAlpha = f2;
        this.mToAlpha = f3;
        AppMethodBeat.o(173072);
    }
}
