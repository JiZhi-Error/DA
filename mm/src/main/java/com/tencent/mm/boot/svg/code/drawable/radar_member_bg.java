package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class radar_member_bg extends c {
    private final int height = 210;
    private final int width = 210;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 210;
            case 1:
                return 210;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 5.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-263173);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(24.7f, 33.63f);
                instancePath.cubicTo(40.27f, 15.91f, 62.45f, 4.14f, 85.88f, 1.28f);
                instancePath.cubicTo(108.44f, -1.63f, 131.96f, 3.59f, 151.09f, 15.93f);
                instancePath.cubicTo(172.67f, 29.61f, 188.49f, 52.03f, 194.03f, 76.98f);
                instancePath.cubicTo(200.74f, 105.79f, 193.44f, 137.4f, 174.77f, 160.34f);
                instancePath.cubicTo(173.15f, 160.22f, 171.53f, 160.1f, 169.92f, 159.98f);
                instancePath.cubicTo(183.87f, 143.67f, 192.18f, 122.51f, 192.44f, 100.99f);
                instancePath.cubicTo(193.16f, 79.56f, 185.98f, 58.09f, 172.86f, 41.17f);
                instancePath.cubicTo(159.56f, 23.77f, 139.95f, 11.4f, 118.6f, 6.64f);
                instancePath.cubicTo(99.24f, 2.59f, 78.5f, 4.25f, 60.39f, 12.4f);
                instancePath.cubicTo(38.52f, 21.96f, 20.59f, 40.16f, 11.33f, 62.16f);
                instancePath.cubicTo(-0.62f, 90.04f, 2.12f, 123.71f, 18.58f, 149.22f);
                instancePath.cubicTo(17.56f, 149.45f, 15.51f, 149.9f, 14.49f, 150.13f);
                instancePath.cubicTo(3.87f, 132.83f, -1.21f, 112.21f, 0.26f, 91.96f);
                instancePath.cubicTo(1.63f, 70.52f, 10.41f, 49.66f, 24.7f, 33.63f);
                instancePath.lineTo(24.7f, 33.63f);
                instancePath.lineTo(24.7f, 33.63f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(99.0f, 198.0f);
                instancePath2.cubicTo(153.6762f, 198.0f, 198.0f, 153.6762f, 198.0f, 99.0f);
                instancePath2.cubicTo(198.0f, 44.32381f, 153.6762f, 0.0f, 99.0f, 0.0f);
                instancePath2.cubicTo(44.32381f, 0.0f, 0.0f, 44.32381f, 0.0f, 99.0f);
                instancePath2.cubicTo(0.0f, 153.6762f, 44.32381f, 198.0f, 99.0f, 198.0f);
                instancePath2.lineTo(99.0f, 198.0f);
                instancePath2.close();
                instancePath2.moveTo(99.0f, 193.0f);
                instancePath2.cubicTo(150.91476f, 193.0f, 193.0f, 150.91476f, 193.0f, 99.0f);
                instancePath2.cubicTo(193.0f, 47.08523f, 150.91476f, 5.0f, 99.0f, 5.0f);
                instancePath2.cubicTo(47.08523f, 5.0f, 5.0f, 47.08523f, 5.0f, 99.0f);
                instancePath2.cubicTo(5.0f, 150.91476f, 47.08523f, 193.0f, 99.0f, 193.0f);
                instancePath2.lineTo(99.0f, 193.0f);
                instancePath2.close();
                Paint instancePaint6 = c.instancePaint(looper);
                instancePaint6.setFlags(385);
                instancePaint6.setStyle(Paint.Style.FILL);
                Paint instancePaint7 = c.instancePaint(looper);
                instancePaint7.setFlags(385);
                instancePaint7.setStyle(Paint.Style.STROKE);
                instancePaint6.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint7.setStrokeWidth(1.0f);
                instancePaint7.setStrokeCap(Paint.Cap.BUTT);
                instancePaint7.setStrokeJoin(Paint.Join.MITER);
                instancePaint7.setStrokeMiter(4.0f);
                instancePaint7.setPathEffect(null);
                float[] matrixFloatArray4 = c.setMatrixFloatArray(matrixFloatArray3, 198.0f, 0.0f, 0.0f, 0.0f, 198.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray4);
                WeChatSVGRenderC2Java.setLinearGradient(instancePaint5, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-1, -1184275}, new float[]{0.0f, 1.0f}, instanceMatrix, 0);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
