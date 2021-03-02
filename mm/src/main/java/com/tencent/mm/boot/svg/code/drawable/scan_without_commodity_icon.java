package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class scan_without_commodity_icon extends c {
    private final int height = 260;
    private final int width = 260;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 260;
            case 1:
                return 260;
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
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(260.0f, 0.0f);
                instancePath.lineTo(260.0f, 260.0f);
                instancePath.lineTo(0.0f, 260.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                instancePath.moveTo(98.02f, 72.03f);
                instancePath.cubicTo(85.5f, 76.81f, 75.4f, 87.31f, 70.88f, 99.9f);
                instancePath.cubicTo(66.49f, 111.86f, 67.2f, 125.65f, 73.08f, 136.99f);
                instancePath.cubicTo(79.02f, 148.74f, 90.29f, 157.6f, 103.09f, 160.64f);
                instancePath.cubicTo(115.81f, 163.78f, 129.85f, 161.26f, 140.54f, 153.65f);
                instancePath.cubicTo(142.41f, 152.25f, 144.09f, 150.58f, 146.13f, 149.41f);
                instancePath.cubicTo(147.9f, 150.37f, 149.1f, 152.06f, 150.51f, 153.45f);
                instancePath.cubicTo(162.66f, 165.65f, 174.87f, 177.79f, 187.01f, 190.01f);
                instancePath.cubicTo(188.23f, 191.37f, 190.48f, 192.71f, 191.99f, 190.93f);
                instancePath.cubicTo(193.72f, 189.38f, 192.36f, 187.22f, 191.01f, 186.0f);
                instancePath.cubicTo(177.32f, 172.33f, 163.64f, 158.63f, 149.95f, 144.95f);
                instancePath.cubicTo(156.94f, 135.91f, 160.7f, 124.4f, 159.85f, 112.96f);
                instancePath.cubicTo(158.95f, 96.64f, 148.92f, 81.17f, 134.28f, 73.86f);
                instancePath.cubicTo(123.17f, 68.16f, 109.65f, 67.51f, 98.02f, 72.03f);
                instancePath.lineTo(98.02f, 72.03f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(108.33f, 75.44f);
                instancePath2.cubicTo(117.0f, 74.15f, 126.1f, 75.84f, 133.67f, 80.27f);
                instancePath2.cubicTo(143.51f, 85.92f, 150.64f, 95.93f, 153.01f, 107.01f);
                instancePath2.cubicTo(155.37f, 117.63f, 153.42f, 129.23f, 147.35f, 138.32f);
                instancePath2.cubicTo(142.12f, 146.27f, 133.9f, 152.19f, 124.69f, 154.6f);
                instancePath2.cubicTo(114.09f, 157.45f, 102.33f, 155.86f, 92.97f, 150.09f);
                instancePath2.cubicTo(84.61f, 145.0f, 78.28f, 136.71f, 75.61f, 127.29f);
                instancePath2.cubicTo(72.13f, 115.35f, 74.47f, 101.89f, 81.78f, 91.83f);
                instancePath2.cubicTo(87.96f, 83.11f, 97.72f, 76.97f, 108.33f, 75.44f);
                instancePath2.lineTo(108.33f, 75.44f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-3552823);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 68.0f, 0.0f, 1.0f, 69.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint6, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(30.02f, 3.03f);
                instancePath3.cubicTo(41.65f, -1.49f, 55.17f, -0.84f, 66.28f, 4.86f);
                instancePath3.cubicTo(80.92f, 12.17f, 90.95f, 27.64f, 91.85f, 43.96f);
                instancePath3.cubicTo(92.7f, 55.4f, 88.94f, 66.91f, 81.95f, 75.95f);
                instancePath3.cubicTo(95.64f, 89.63f, 109.32f, 103.33f, 123.01f, 117.0f);
                instancePath3.cubicTo(124.36f, 118.22f, 125.72f, 120.38f, 123.99f, 121.93f);
                instancePath3.cubicTo(122.48f, 123.71f, 120.23f, 122.37f, 119.01f, 121.01f);
                instancePath3.cubicTo(106.87f, 108.79f, 94.66f, 96.65f, 82.51f, 84.45f);
                instancePath3.cubicTo(81.1f, 83.06f, 79.9f, 81.37f, 78.13f, 80.41f);
                instancePath3.cubicTo(76.09f, 81.58f, 74.41f, 83.25f, 72.54f, 84.65f);
                instancePath3.cubicTo(61.85f, 92.26f, 47.81f, 94.78f, 35.09f, 91.64f);
                instancePath3.cubicTo(22.29f, 88.6f, 11.02f, 79.74f, 5.08f, 67.99f);
                instancePath3.cubicTo(-0.8f, 56.65f, -1.51f, 42.86f, 2.88f, 30.9f);
                instancePath3.cubicTo(7.4f, 18.31f, 17.5f, 7.81f, 30.02f, 3.03f);
                instancePath3.lineTo(30.02f, 3.03f);
                instancePath3.close();
                instancePath3.moveTo(40.33f, 6.44f);
                instancePath3.cubicTo(29.72f, 7.97f, 19.96f, 14.11f, 13.78f, 22.83f);
                instancePath3.cubicTo(6.47f, 32.89f, 4.13f, 46.35f, 7.61f, 58.29f);
                instancePath3.cubicTo(10.28f, 67.71f, 16.61f, 76.0f, 24.97f, 81.09f);
                instancePath3.cubicTo(34.33f, 86.86f, 46.09f, 88.45f, 56.69f, 85.6f);
                instancePath3.cubicTo(65.9f, 83.19f, 74.12f, 77.27f, 79.35f, 69.32f);
                instancePath3.cubicTo(85.42f, 60.23f, 87.37f, 48.63f, 85.01f, 38.01f);
                instancePath3.cubicTo(82.64f, 26.93f, 75.51f, 16.92f, 65.67f, 11.27f);
                instancePath3.cubicTo(58.1f, 6.84f, 49.0f, 5.15f, 40.33f, 6.44f);
                instancePath3.lineTo(40.33f, 6.44f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint7);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
