package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class c2c_transfer_icon extends c {
    private final int height = 102;
    private final int width = 102;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 102;
            case 1:
                return 102;
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
                instancePaint3.setColor(-1);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(51.0f, 102.0f);
                instancePath.cubicTo(79.16652f, 102.0f, 102.0f, 79.16652f, 102.0f, 51.0f);
                instancePath.cubicTo(102.0f, 22.833477f, 79.16652f, 0.0f, 51.0f, 0.0f);
                instancePath.cubicTo(22.833477f, 0.0f, 0.0f, 22.833477f, 0.0f, 51.0f);
                instancePath.cubicTo(0.0f, 79.16652f, 22.833477f, 102.0f, 51.0f, 102.0f);
                instancePath.close();
                instancePath.moveTo(51.0f, 98.0f);
                instancePath.cubicTo(76.95738f, 98.0f, 98.0f, 76.95738f, 98.0f, 51.0f);
                instancePath.cubicTo(98.0f, 25.042616f, 76.95738f, 4.0f, 51.0f, 4.0f);
                instancePath.cubicTo(25.042616f, 4.0f, 4.0f, 25.042616f, 4.0f, 51.0f);
                instancePath.cubicTo(4.0f, 76.95738f, 25.042616f, 98.0f, 51.0f, 98.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 14.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(39.52522f, 40.28733f);
                instancePath2.lineTo(9.866667f, 40.28733f);
                instancePath2.lineTo(9.866667f, 44.853653f);
                instancePath2.cubicTo(9.866667f, 45.975304f, 10.76179f, 46.86199f, 11.865981f, 46.86199f);
                instancePath2.lineTo(37.883682f, 46.86199f);
                instancePath2.lineTo(36.885212f, 57.796623f);
                instancePath2.cubicTo(36.735928f, 59.43152f, 37.682396f, 59.961784f, 39.00135f, 58.95761f);
                instancePath2.lineTo(58.255604f, 44.29855f);
                instancePath2.cubicTo(61.15963f, 42.087593f, 60.55669f, 40.28733f, 56.896053f, 40.28733f);
                instancePath2.lineTo(39.52522f, 40.28733f);
                instancePath2.close();
                instancePath2.moveTo(32.008507f, 33.71267f);
                instancePath2.lineTo(61.99695f, 33.71267f);
                instancePath2.lineTo(61.99695f, 29.146349f);
                instancePath2.cubicTo(61.99695f, 28.024696f, 61.104416f, 27.138008f, 60.003418f, 27.138008f);
                instancePath2.lineTo(33.649654f, 27.138008f);
                instancePath2.lineTo(34.64812f, 16.203377f);
                instancePath2.cubicTo(34.797405f, 14.5684805f, 33.850937f, 14.038217f, 32.531982f, 15.04239f);
                instancePath2.lineTo(13.277731f, 29.701452f);
                instancePath2.cubicTo(10.373704f, 31.912409f, 10.9766445f, 33.71267f, 14.637279f, 33.71267f);
                instancePath2.lineTo(32.008507f, 33.71267f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
