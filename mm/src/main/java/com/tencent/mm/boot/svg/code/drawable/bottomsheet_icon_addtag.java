package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_icon_addtag extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                c.instancePaint(instancePaint2, looper).setStrokeWidth(1.0f);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-8617851);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 10.0f, 0.0f, 1.0f, 10.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(20.0f, 65.0f);
                instancePath.cubicTo(15.581831f, 65.0f, 12.0f, 61.418266f, 12.0f, 57.00022f);
                instancePath.cubicTo(12.0f, 52.581734f, 15.581831f, 49.0f, 20.0f, 49.0f);
                instancePath.cubicTo(24.418169f, 49.0f, 28.0f, 52.581734f, 28.0f, 57.00022f);
                instancePath.cubicTo(28.0f, 61.418266f, 24.418169f, 65.0f, 20.0f, 65.0f);
                instancePath.moveTo(75.81466f, 29.779163f);
                instancePath.lineTo(47.19909f, 1.1844771f);
                instancePath.cubicTo(45.618633f, -0.3948257f, 43.056522f, -0.3948257f, 41.476063f, 1.1844771f);
                instancePath.lineTo(1.252038f, 41.379147f);
                instancePath.cubicTo(0.3639593f, 42.26658f, -0.024743835f, 43.463757f, 0.08502881f, 44.62272f);
                instancePath.lineTo(0.004948767f, 44.70319f);
                instancePath.lineTo(0.0f, 76.91503f);
                instancePath.lineTo(0.08502881f, 77.0f);
                instancePath.cubicTo(5.8085027f, 77.0f, 23.96283f, 76.97392f, 32.275406f, 76.961334f);
                instancePath.lineTo(32.376633f, 76.86018f);
                instancePath.cubicTo(33.526546f, 76.95999f, 34.71065f, 76.57157f, 35.59063f, 75.69268f);
                instancePath.lineTo(75.81466f, 35.49801f);
                instancePath.cubicTo(77.39511f, 33.91871f, 77.39511f, 31.358015f, 75.81466f, 29.779163f);
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
