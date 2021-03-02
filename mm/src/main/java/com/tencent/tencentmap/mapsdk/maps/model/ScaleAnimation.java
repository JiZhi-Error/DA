package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class ScaleAnimation extends BaseAnimation {
    public float mFromX;
    public float mFromY;
    public float mToX;
    public float mToY;

    public ScaleAnimation(float f2, float f3, float f4, float f5) {
        AppMethodBeat.i(173373);
        this.mFromX = f2;
        this.mToX = f3;
        this.mFromY = f4;
        this.mToY = f5;
        AppMethodBeat.o(173373);
    }
}
