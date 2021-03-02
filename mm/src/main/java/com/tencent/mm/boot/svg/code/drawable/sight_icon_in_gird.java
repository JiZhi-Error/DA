package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sight_icon_in_gird extends c {
    private final int height = 80;
    private final int width = 80;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 80;
            case 1:
                return 80;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix instanceMatrix = c.instanceMatrix(looper);
                float[] instanceMatrixArray = c.instanceMatrixArray(looper);
                Paint instancePaint = c.instancePaint(looper);
                instancePaint.setFlags(385);
                instancePaint.setStyle(Paint.Style.FILL);
                Paint instancePaint2 = c.instancePaint(looper);
                instancePaint2.setFlags(385);
                instancePaint2.setStyle(Paint.Style.STROKE);
                instancePaint.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint2.setStrokeWidth(1.0f);
                instancePaint2.setStrokeCap(Paint.Cap.BUTT);
                instancePaint2.setStrokeJoin(Paint.Join.MITER);
                instancePaint2.setStrokeMiter(4.0f);
                instancePaint2.setPathEffect(null);
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-1);
                instancePaint4.setStrokeWidth(4.0f);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 16.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(36.925568f, 47.054665f);
                instancePath.cubicTo(56.11064f, 47.054665f, 71.45919f, 26.668798f, 71.45919f, 26.668798f);
                instancePath.cubicTo(72.148895f, 25.817219f, 72.17743f, 24.403841f, 71.5037f, 23.523014f);
                instancePath.cubicTo(71.5037f, 23.523014f, 55.69043f, 0.96764195f, 36.505352f, 0.96764195f);
                instancePath.cubicTo(17.320274f, 0.96764195f, 1.4598377f, 23.541723f, 1.4598377f, 23.541723f);
                instancePath.cubicTo(0.8014887f, 24.417181f, 0.84271175f, 25.819351f, 1.5628284f, 26.651388f);
                instancePath.cubicTo(1.5628284f, 26.651388f, 17.740492f, 47.054665f, 36.925568f, 47.054665f);
                instancePath.lineTo(36.925568f, 47.054665f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(22.42774f, 20.499218f);
                instancePath2.cubicTo(22.148413f, 21.58994f, 22.0f, 22.732264f, 22.0f, 23.908884f);
                instancePath2.cubicTo(22.0f, 31.55521f, 28.267693f, 37.75321f, 36.0f, 37.75321f);
                instancePath2.cubicTo(43.732307f, 37.75321f, 50.0f, 31.55521f, 50.0f, 23.908884f);
                instancePath2.cubicTo(50.0f, 16.262556f, 43.732307f, 10.064558f, 36.0f, 10.064558f);
                instancePath2.cubicTo(34.347454f, 10.064558f, 32.76181f, 10.347658f, 31.289946f, 10.867492f);
                instancePath2.lineTo(34.60256f, 20.195063f);
                instancePath2.lineTo(31.98528f, 23.138868f);
                instancePath2.lineTo(22.42774f, 20.499218f);
                instancePath2.lineTo(22.42774f, 20.499218f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
