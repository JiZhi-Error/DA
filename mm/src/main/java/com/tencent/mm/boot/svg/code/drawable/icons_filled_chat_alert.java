package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_chat_alert extends c {
    private final int height = 72;
    private final int width = 72;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(16.110552f, 0.31031445f);
                instancePath.lineTo(19.060286f, 0.31031445f);
                instancePath.cubicTo(19.971556f, 0.31031445f, 20.710287f, 1.0490446f, 20.710287f, 1.9603145f);
                instancePath.cubicTo(20.710136f, 1.9875025f, 20.710136f, 1.9875025f, 20.70939f, 2.0146806f);
                instancePath.lineTo(20.308842f, 14.1646805f);
                instancePath.cubicTo(20.279512f, 15.054304f, 19.549843f, 15.760315f, 18.659737f, 15.760315f);
                instancePath.lineTo(16.5111f, 15.760315f);
                instancePath.cubicTo(15.620995f, 15.760315f, 14.891326f, 15.054304f, 14.861998f, 14.1646805f);
                instancePath.lineTo(14.461448f, 2.0146806f);
                instancePath.cubicTo(14.431422f, 1.1039054f, 15.145411f, 0.3412359f, 16.056187f, 0.31121036f);
                instancePath.cubicTo(16.083364f, 0.3104638f, 16.083364f, 0.3104638f, 16.110552f, 0.31031445f);
                instancePath.close();
                instancePath.moveTo(38.561428f, 9.609778f);
                instancePath.cubicTo(39.20579f, 10.254144f, 39.20579f, 11.298866f, 38.561428f, 11.943232f);
                instancePath.cubicTo(38.542095f, 11.962351f, 38.542095f, 11.962351f, 38.52235f, 11.98104f);
                instancePath.lineTo(29.647772f, 20.289156f);
                instancePath.cubicTo(28.997976f, 20.897476f, 27.982798f, 20.880747f, 27.353395f, 20.251347f);
                instancePath.lineTo(25.834082f, 18.732033f);
                instancePath.cubicTo(25.204681f, 18.102633f, 25.187952f, 17.087454f, 25.796272f, 16.437656f);
                instancePath.lineTo(34.10439f, 7.5630774f);
                instancePath.cubicTo(34.727173f, 6.897831f, 35.771328f, 6.8634086f, 36.436573f, 7.486192f);
                instancePath.cubicTo(36.456318f, 7.5048823f, 36.456318f, 7.5048823f, 36.47565f, 7.5240016f);
                instancePath.lineTo(38.561428f, 9.609778f);
                instancePath.close();
                instancePath.moveTo(45.7751f, 27.025148f);
                instancePath.lineTo(45.7751f, 29.974882f);
                instancePath.cubicTo(45.7751f, 30.886152f, 45.036373f, 31.624882f, 44.125103f, 31.624882f);
                instancePath.cubicTo(44.097916f, 31.624733f, 44.097916f, 31.624733f, 44.070736f, 31.623987f);
                instancePath.lineTo(31.920736f, 31.223436f);
                instancePath.cubicTo(31.031113f, 31.194109f, 30.325102f, 30.46444f, 30.325102f, 29.574333f);
                instancePath.lineTo(30.325102f, 27.425697f);
                instancePath.cubicTo(30.325102f, 26.535591f, 31.031113f, 25.805922f, 31.920736f, 25.776592f);
                instancePath.lineTo(44.070736f, 25.376043f);
                instancePath.cubicTo(44.98151f, 25.346018f, 45.744183f, 26.060007f, 45.774208f, 26.970781f);
                instancePath.cubicTo(45.774952f, 26.99796f, 45.774952f, 26.99796f, 45.7751f, 27.025148f);
                instancePath.close();
                instancePath.moveTo(6.0f, 15.0f);
                instancePath.lineTo(6.0f, 57.0f);
                instancePath.lineTo(30.0f, 57.0f);
                instancePath.lineTo(30.0f, 39.0f);
                instancePath.lineTo(36.0f, 39.0f);
                instancePath.lineTo(36.0f, 60.0f);
                instancePath.cubicTo(36.0f, 61.656853f, 34.656853f, 63.0f, 33.0f, 63.0f);
                instancePath.lineTo(3.0f, 63.0f);
                instancePath.cubicTo(1.3431457f, 63.0f, -1.7763568E-15f, 61.656853f, -7.1054274E-15f, 60.0f);
                instancePath.lineTo(-7.1054274E-15f, 12.0f);
                instancePath.cubicTo(-1.2434498E-14f, 10.343145f, 1.3431457f, 9.0f, 3.0f, 9.0f);
                instancePath.lineTo(9.0f, 9.0f);
                instancePath.lineTo(9.0f, 15.0f);
                instancePath.lineTo(6.0f, 15.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
