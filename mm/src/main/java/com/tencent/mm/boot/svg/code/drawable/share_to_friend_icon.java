package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class share_to_friend_icon extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-12799249);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 11.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(27.39f, 1.59f);
                instancePath.cubicTo(34.1f, -0.34f, 42.03f, 2.41f, 45.55f, 8.57f);
                instancePath.cubicTo(50.69f, 17.75f, 47.8f, 30.26f, 40.07f, 37.12f);
                instancePath.cubicTo(38.37f, 38.32f, 38.73f, 41.26f, 40.63f, 42.07f);
                instancePath.cubicTo(48.12f, 45.88f, 55.8f, 50.27f, 60.7f, 57.32f);
                instancePath.cubicTo(63.44f, 60.98f, 63.18f, 65.75f, 62.92f, 70.07f);
                instancePath.cubicTo(62.88f, 71.98f, 60.86f, 73.2f, 59.09f, 72.98f);
                instancePath.cubicTo(41.02f, 73.01f, 22.93f, 73.01f, 4.86f, 72.98f);
                instancePath.cubicTo(3.09f, 73.2f, 1.11f, 71.94f, 1.08f, 70.05f);
                instancePath.cubicTo(0.85f, 65.98f, 0.57f, 61.52f, 2.96f, 57.98f);
                instancePath.cubicTo(7.67f, 50.59f, 15.53f, 46.13f, 23.04f, 42.09f);
                instancePath.cubicTo(25.09f, 41.02f, 25.02f, 38.06f, 23.18f, 36.81f);
                instancePath.cubicTo(16.97f, 30.9f, 14.24f, 21.58f, 16.21f, 13.24f);
                instancePath.cubicTo(17.51f, 7.74f, 21.84f, 2.97f, 27.39f, 1.59f);
                instancePath.lineTo(27.39f, 1.59f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(57.39f, 12.35f);
                instancePath2.cubicTo(61.78f, 5.69f, 72.63f, 5.2f, 77.63f, 11.4f);
                instancePath2.cubicTo(82.95f, 18.02f, 81.57f, 28.16f, 76.57f, 34.55f);
                instancePath2.cubicTo(75.23f, 36.15f, 72.17f, 38.3f, 74.42f, 40.47f);
                instancePath2.cubicTo(80.64f, 43.86f, 87.25f, 47.44f, 91.24f, 53.54f);
                instancePath2.cubicTo(93.55f, 56.87f, 93.11f, 61.13f, 92.88f, 64.96f);
                instancePath2.cubicTo(92.77f, 66.27f, 91.38f, 67.11f, 90.15f, 66.98f);
                instancePath2.cubicTo(82.44f, 67.05f, 74.73f, 66.97f, 67.02f, 67.0f);
                instancePath2.cubicTo(66.74f, 57.77f, 60.71f, 49.78f, 52.66f, 45.67f);
                instancePath2.cubicTo(55.44f, 43.69f, 58.58f, 42.3f, 61.36f, 40.34f);
                instancePath2.cubicTo(62.61f, 39.12f, 61.92f, 37.31f, 60.74f, 36.34f);
                instancePath2.cubicTo(54.71f, 30.25f, 52.54f, 19.75f, 57.39f, 12.35f);
                instancePath2.lineTo(57.39f, 12.35f);
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
