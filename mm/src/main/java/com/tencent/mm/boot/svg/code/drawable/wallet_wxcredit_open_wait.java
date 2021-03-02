package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class wallet_wxcredit_open_wait extends c {
    private final int height = 240;
    private final int width = 273;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 273;
            case 1:
                return 240;
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
                instancePaint3.setColor(-12810566);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 13.0f, 0.0f, 1.0f, 15.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(81.42f, 3.53f);
                instancePath.cubicTo(95.01f, -1.21f, 111.01f, 0.68f, 122.61f, 9.4f);
                instancePath.cubicTo(131.81f, 16.24f, 137.63f, 26.99f, 139.4f, 38.23f);
                instancePath.cubicTo(142.14f, 55.42f, 137.68f, 73.52f, 127.81f, 87.8f);
                instancePath.cubicTo(125.42f, 91.04f, 123.03f, 94.46f, 119.58f, 96.67f);
                instancePath.cubicTo(115.73f, 98.97f, 114.46f, 104.5f, 116.82f, 108.3f);
                instancePath.cubicTo(117.96f, 110.49f, 120.26f, 111.59f, 122.4f, 112.57f);
                instancePath.cubicTo(113.67f, 127.91f, 111.16f, 146.58f, 115.4f, 163.69f);
                instancePath.cubicTo(117.69f, 173.22f, 122.14f, 182.16f, 128.07f, 189.95f);
                instancePath.cubicTo(86.27f, 189.94f, 44.47f, 189.83f, 2.68f, 189.86f);
                instancePath.cubicTo(0.79f, 182.9f, 0.06f, 175.6f, 0.47f, 168.41f);
                instancePath.cubicTo(1.99f, 158.77f, 9.44f, 151.6f, 16.38f, 145.37f);
                instancePath.cubicTo(31.11f, 132.98f, 48.14f, 123.71f, 65.3f, 115.14f);
                instancePath.cubicTo(68.3f, 113.53f, 71.69f, 112.5f, 74.27f, 110.21f);
                instancePath.cubicTo(77.62f, 107.25f, 77.96f, 101.52f, 74.82f, 98.3f);
                instancePath.cubicTo(65.32f, 90.48f, 59.09f, 79.29f, 55.61f, 67.62f);
                instancePath.cubicTo(51.68f, 53.94f, 51.44f, 38.66f, 57.48f, 25.56f);
                instancePath.cubicTo(62.04f, 15.38f, 70.85f, 7.16f, 81.42f, 3.53f);
                instancePath.lineTo(81.42f, 3.53f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(179.49f, 85.57f);
                instancePath2.cubicTo(193.81f, 84.44f, 208.47f, 88.43f, 220.18f, 96.76f);
                instancePath2.cubicTo(232.95f, 105.7f, 242.15f, 119.57f, 245.32f, 134.84f);
                instancePath2.cubicTo(248.47f, 149.59f, 246.09f, 165.46f, 238.59f, 178.56f);
                instancePath2.cubicTo(231.36f, 191.39f, 219.45f, 201.5f, 205.59f, 206.49f);
                instancePath2.cubicTo(189.73f, 212.32f, 171.51f, 211.3f, 156.42f, 203.71f);
                instancePath2.cubicTo(143.23f, 197.18f, 132.54f, 185.82f, 126.8f, 172.27f);
                instancePath2.cubicTo(120.63f, 157.93f, 120.2f, 141.26f, 125.52f, 126.59f);
                instancePath2.cubicTo(133.46f, 103.93f, 155.49f, 87.09f, 179.49f, 85.57f);
                instancePath2.lineTo(179.49f, 85.57f);
                instancePath2.close();
                instancePath2.moveTo(179.21f, 110.04f);
                instancePath2.cubicTo(179.15f, 124.0f, 179.14f, 137.97f, 179.22f, 151.94f);
                instancePath2.cubicTo(179.06f, 154.46f, 181.46f, 156.49f, 183.9f, 156.24f);
                instancePath2.cubicTo(195.3f, 156.32f, 206.69f, 156.22f, 218.09f, 156.29f);
                instancePath2.cubicTo(220.06f, 156.25f, 222.47f, 156.47f, 223.81f, 154.68f);
                instancePath2.cubicTo(225.82f, 151.94f, 224.96f, 146.49f, 220.98f, 146.21f);
                instancePath2.cubicTo(210.42f, 146.01f, 199.86f, 146.2f, 189.3f, 146.13f);
                instancePath2.cubicTo(189.21f, 133.77f, 189.45f, 121.41f, 189.19f, 109.06f);
                instancePath2.cubicTo(188.35f, 103.85f, 178.85f, 104.55f, 179.21f, 110.04f);
                instancePath2.lineTo(179.21f, 110.04f);
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
