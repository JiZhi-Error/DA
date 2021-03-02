package com.tencent.mm.svg;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;

public abstract class c {
    public static final int GetHeight = 1;
    public static final int GetWidth = 0;
    public static final int Render = 2;

    /* access modifiers changed from: protected */
    public abstract int doCommand(int i2, Object... objArr);

    protected static void done(Looper looper) {
        if (looper != null) {
            b.h(looper);
        }
    }

    public static int getWidth(c cVar) {
        return cVar.doCommand(0, new Object[0]);
    }

    public static int getHeight(c cVar) {
        return cVar.doCommand(1, new Object[0]);
    }

    public static void render(c cVar, Canvas canvas, Looper looper) {
        cVar.doCommand(2, canvas, looper);
    }

    protected static Paint instancePaint(Looper looper) {
        return b.a(looper, (Paint) null);
    }

    protected static Paint instancePaint(Paint paint, Looper looper) {
        return b.a(looper, paint);
    }

    protected static float[] instanceMatrixArray(Looper looper) {
        return b.instanceMatrixArray(looper);
    }

    protected static Matrix instanceMatrix(Looper looper) {
        return b.instanceMatrix(looper);
    }

    protected static Path instancePath(Looper looper) {
        return b.a(looper, (Path) null);
    }

    protected static Path instancePath(Path path, Looper looper) {
        return b.a(looper, path);
    }

    protected static float[] setMatrixFloatArray(float[] fArr, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        if (fArr != null) {
            fArr[0] = f2;
            fArr[1] = f3;
            fArr[2] = f4;
            fArr[3] = f5;
            fArr[4] = f6;
            fArr[5] = f7;
            fArr[6] = f8;
            fArr[7] = f9;
            fArr[8] = f10;
        }
        return fArr;
    }
}
