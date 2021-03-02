package com.tencent.mm.plugin.music.ui.transition;

import android.content.Context;
import android.graphics.Path;
import android.transition.ArcMotion;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GravityArcMotion extends ArcMotion {
    private static final float zI = ((float) Math.tan(Math.toRadians(35.0d)));
    private float zJ = 0.0f;
    private float zK = 0.0f;
    private float zL = 70.0f;
    private float zM = 0.0f;
    private float zN = 0.0f;
    private float zO = zI;

    static {
        AppMethodBeat.i(219892);
        AppMethodBeat.o(219892);
    }

    public GravityArcMotion() {
    }

    public GravityArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setMinimumHorizontalAngle(float f2) {
        AppMethodBeat.i(219887);
        this.zJ = f2;
        this.zM = w(f2);
        AppMethodBeat.o(219887);
    }

    public float getMinimumHorizontalAngle() {
        return this.zJ;
    }

    public void setMinimumVerticalAngle(float f2) {
        AppMethodBeat.i(219888);
        this.zK = f2;
        this.zN = w(f2);
        AppMethodBeat.o(219888);
    }

    public float getMinimumVerticalAngle() {
        return this.zK;
    }

    public void setMaximumAngle(float f2) {
        AppMethodBeat.i(219889);
        this.zL = f2;
        this.zO = w(f2);
        AppMethodBeat.o(219889);
    }

    public float getMaximumAngle() {
        return this.zL;
    }

    private static float w(float f2) {
        AppMethodBeat.i(219890);
        if (f2 < 0.0f || f2 > 90.0f) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Arc must be between 0 and 90 degrees");
            AppMethodBeat.o(219890);
            throw illegalArgumentException;
        }
        float tan = (float) Math.tan(Math.toRadians((double) (f2 / 2.0f)));
        AppMethodBeat.o(219890);
        return tan;
    }

    public Path getPath(float f2, float f3, float f4, float f5) {
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        AppMethodBeat.i(219891);
        Path path = new Path();
        path.moveTo(f2, f3);
        if (f3 == f5) {
            f7 = (f2 + f4) / 2.0f;
            f10 = f3 + ((this.zM * Math.abs(f4 - f2)) / 2.0f);
        } else if (f2 == f4) {
            f7 = f2 + ((this.zN * Math.abs(f5 - f3)) / 2.0f);
            f10 = (f3 + f5) / 2.0f;
        } else {
            float f11 = f4 - f2;
            if (f5 < f3) {
                f6 = f3 - f5;
            } else {
                f6 = f5 - f3;
            }
            float f12 = (f11 * f11) + (f6 * f6);
            float f13 = (f2 + f4) / 2.0f;
            float f14 = (f3 + f5) / 2.0f;
            float f15 = 0.25f * f12;
            if (Math.abs(f11) < Math.abs(f6)) {
                f9 = f5 + (f12 / (f6 * 2.0f));
                f8 = this.zN * f15 * this.zN;
                f7 = f4;
            } else {
                f7 = f4 + (f12 / (2.0f * f11));
                f8 = this.zM * f15 * this.zM;
                f9 = f5;
            }
            float f16 = f13 - f7;
            float f17 = f14 - f9;
            float f18 = (f17 * f17) + (f16 * f16);
            float f19 = f15 * this.zO * this.zO;
            if (f18 >= f8) {
                if (f18 > f19) {
                    f8 = f19;
                } else {
                    f8 = 0.0f;
                }
            }
            if (f8 != 0.0f) {
                float sqrt = (float) Math.sqrt((double) (f8 / f18));
                f7 = ((f7 - f13) * sqrt) + f13;
                f10 = f14 + (sqrt * (f9 - f14));
            } else {
                f10 = f9;
            }
        }
        path.cubicTo((f2 + f7) / 2.0f, (f3 + f10) / 2.0f, (f7 + f4) / 2.0f, (f10 + f5) / 2.0f, f4, f5);
        AppMethodBeat.o(219891);
        return path;
    }
}
