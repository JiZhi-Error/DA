package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class RotateAnimation extends BaseAnimation {
    public float mFromDegree;
    public float mPivoteX;
    public float mPivoteY;
    public float mPivoteZ;
    public float mToDegree;

    public RotateAnimation(float f2, float f3, float f4, float f5, float f6) {
        AppMethodBeat.i(173370);
        this.mFromDegree = f2;
        this.mToDegree = f3;
        this.mPivoteX = f4;
        this.mPivoteY = f5;
        this.mPivoteZ = f6;
        AppMethodBeat.o(173370);
    }
}
