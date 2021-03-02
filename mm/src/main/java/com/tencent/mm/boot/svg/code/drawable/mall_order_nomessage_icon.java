package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class mall_order_nomessage_icon extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-3026479);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 48.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(29.022663f, 6.881502f);
                instancePath.cubicTo(28.962679f, 3.3246841f, 32.48179f, 0.6071154f, 35.910923f, 1.046722f);
                instancePath.lineTo(171.01677f, 1.046722f);
                instancePath.cubicTo(174.47589f, 0.6071154f, 178.005f, 3.3646483f, 177.90503f, 6.941448f);
                instancePath.cubicTo(177.99501f, 40.29161f, 177.92502f, 73.651764f, 177.94502f, 107.01192f);
                instancePath.cubicTo(178.48488f, 110.91843f, 174.96577f, 114.48524f, 171.04677f, 113.94572f);
                instancePath.lineTo(35.900925f, 113.94572f);
                instancePath.cubicTo(32.4418f, 114.38532f, 28.92269f, 111.60781f, 29.012667f, 108.041f);
                instancePath.cubicTo(28.932686f, 97.59035f, 29.002668f, 87.14969f, 28.992672f, 76.69904f);
                instancePath.cubicTo(19.335112f, 70.45463f, 9.657558f, 64.24019f, 0.0f, 57.995773f);
                instancePath.cubicTo(9.647561f, 51.16189f, 19.265131f, 44.288036f, 28.95268f, 37.504105f);
                instancePath.cubicTo(29.062653f, 27.293242f, 28.902695f, 17.092367f, 29.022663f, 6.881502f);
                instancePath.lineTo(29.022663f, 6.881502f);
                instancePath.close();
                instancePath.moveTo(63.374653f, 45.406013f);
                instancePath.cubicTo(56.590252f, 46.86757f, 51.75968f, 54.195107f, 53.28151f, 61.058495f);
                instancePath.cubicTo(54.43024f, 67.90214f, 61.469917f, 72.93858f, 68.27395f, 71.85229f);
                instancePath.cubicTo(75.66708f, 71.09189f, 81.342026f, 63.319958f, 79.722015f, 55.992424f);
                instancePath.cubicTo(78.51437f, 48.635265f, 70.53214f, 43.480316f, 63.374653f, 45.406013f);
                instancePath.lineTo(63.374653f, 45.406013f);
                instancePath.close();
                instancePath.moveTo(100.24062f, 45.43193f);
                instancePath.cubicTo(93.876f, 46.893433f, 89.20076f, 53.509697f, 90.1142f, 60.046963f);
                instancePath.cubicTo(90.76244f, 67.24585f, 97.94228f, 72.914116f, 105.063194f, 71.877235f);
                instancePath.cubicTo(112.50823f, 71.22549f, 118.313f, 63.473595f, 116.741486f, 56.08708f);
                instancePath.cubicTo(115.5825f, 48.64131f, 107.459755f, 43.427303f, 100.24062f, 45.43193f);
                instancePath.lineTo(100.24062f, 45.43193f);
                instancePath.close();
                instancePath.moveTo(136.14615f, 45.755013f);
                instancePath.cubicTo(129.64459f, 47.81871f, 125.55901f, 55.32308f, 127.47412f, 61.938766f);
                instancePath.cubicTo(129.1437f, 68.89018f, 136.88274f, 73.471794f, 143.74768f, 71.56608f);
                instancePath.cubicTo(150.77959f, 70.01583f, 155.54282f, 62.146126f, 153.5393f, 55.155216f);
                instancePath.cubicTo(151.84026f, 47.73972f, 143.23698f, 43.09886f, 136.14615f, 45.755013f);
                instancePath.lineTo(136.14615f, 45.755013f);
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
