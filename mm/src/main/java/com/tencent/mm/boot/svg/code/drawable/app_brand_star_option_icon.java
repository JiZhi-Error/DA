package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_star_option_icon extends c {
    private final int height = 60;
    private final int width = 64;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 64;
            case 1:
                return 60;
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -194.0f, 0.0f, 1.0f, -102.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(224.36317f, 150.10246f);
                instancePath.lineTo(204.89511f, 161.91656f);
                instancePath.lineTo(210.11502f, 139.75056f);
                instancePath.lineTo(192.86317f, 124.88609f);
                instancePath.lineTo(215.55734f, 123.000854f);
                instancePath.lineTo(224.36317f, 102.0f);
                instancePath.lineTo(233.16902f, 123.000854f);
                instancePath.lineTo(255.86317f, 124.88609f);
                instancePath.lineTo(238.61133f, 139.75056f);
                instancePath.lineTo(243.83125f, 161.91656f);
                instancePath.lineTo(224.36317f, 150.10246f);
                instancePath.close();
                instancePath.moveTo(224.24213f, 144.04645f);
                instancePath.lineTo(235.99782f, 151.18034f);
                instancePath.lineTo(232.8458f, 137.7955f);
                instancePath.lineTo(243.26324f, 128.81966f);
                instancePath.lineTo(229.5595f, 127.681274f);
                instancePath.lineTo(224.24213f, 115.0f);
                instancePath.lineTo(218.92476f, 127.681274f);
                instancePath.lineTo(205.221f, 128.81966f);
                instancePath.lineTo(215.63844f, 137.7955f);
                instancePath.lineTo(212.48642f, 151.18034f);
                instancePath.lineTo(224.24213f, 144.04645f);
                instancePath.close();
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
