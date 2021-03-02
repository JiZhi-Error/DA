package com.tencent.tav.coremedia;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Transform {
    public float degrees = 0.0f;
    public final float scaleX;
    public final float scaleY;
    public final float translateX;
    public final float translateY;

    public static Transform instanceFromScale(float f2, float f3) {
        AppMethodBeat.i(199472);
        Transform transform = new Transform(f2, f3, 0.0f, 0.0f, 0.0f);
        AppMethodBeat.o(199472);
        return transform;
    }

    public static Transform instanceFromTranslate(float f2, float f3) {
        AppMethodBeat.i(199473);
        Transform transform = new Transform(1.0f, 1.0f, f2, f3, 0.0f);
        AppMethodBeat.o(199473);
        return transform;
    }

    public Transform(float f2, float f3, float f4, float f5, float f6) {
        this.scaleX = f2;
        this.scaleY = f3;
        this.translateX = f4;
        this.translateY = f5;
        this.degrees = f6;
    }

    public Matrix toMatrix() {
        AppMethodBeat.i(199474);
        Matrix matrix = new Matrix();
        matrix.postRotate(this.degrees);
        matrix.postScale(this.scaleX, this.scaleY);
        matrix.postTranslate(this.translateX, this.translateY);
        AppMethodBeat.o(199474);
        return matrix;
    }
}
