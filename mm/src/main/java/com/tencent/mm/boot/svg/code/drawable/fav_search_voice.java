package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fav_search_voice extends c {
    private final int height = com.tencent.mm.plugin.appbrand.jsapi.k.c.CTRL_INDEX;
    private final int width = com.tencent.mm.plugin.appbrand.jsapi.k.c.CTRL_INDEX;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return com.tencent.mm.plugin.appbrand.jsapi.k.c.CTRL_INDEX;
            case 1:
                return com.tencent.mm.plugin.appbrand.jsapi.k.c.CTRL_INDEX;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.instanceMatrix(looper);
                c.instanceMatrixArray(looper);
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
                instancePaint3.setColor(-10589839);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(64.25f, 0.0f);
                instancePath.lineTo(70.53f, 0.0f);
                instancePath.cubicTo(86.47f, 0.81f, 102.08f, 7.28f, 113.67f, 18.29f);
                instancePath.cubicTo(126.42f, 30.08f, 134.07f, 46.96f, 135.0f, 64.26f);
                instancePath.lineTo(135.0f, 70.55f);
                instancePath.cubicTo(134.14f, 87.93f, 126.45f, 104.9f, 113.65f, 116.74f);
                instancePath.cubicTo(102.12f, 127.68f, 86.62f, 134.11f, 70.79f, 135.0f);
                instancePath.lineTo(64.41f, 135.0f);
                instancePath.cubicTo(48.49f, 134.17f, 32.91f, 127.71f, 21.33f, 116.72f);
                instancePath.cubicTo(8.58f, 104.93f, 0.94f, 88.04f, 0.0f, 70.73f);
                instancePath.lineTo(0.0f, 64.48f);
                instancePath.cubicTo(0.86f, 47.1f, 8.53f, 30.12f, 21.33f, 18.28f);
                instancePath.cubicTo(32.87f, 7.32f, 48.39f, 0.88f, 64.25f, 0.0f);
                instancePath.lineTo(64.25f, 0.0f);
                instancePath.close();
                instancePath.moveTo(57.52f, 3.77f);
                instancePath.cubicTo(42.5f, 6.08f, 28.42f, 13.93f, 18.57f, 25.5f);
                instancePath.cubicTo(8.68f, 36.91f, 3.06f, 51.91f, 3.01f, 67.01f);
                instancePath.cubicTo(2.84f, 81.94f, 8.09f, 96.86f, 17.62f, 108.37f);
                instancePath.cubicTo(28.03f, 121.18f, 43.53f, 129.71f, 59.94f, 131.55f);
                instancePath.cubicTo(73.75f, 133.2f, 88.08f, 130.26f, 100.06f, 123.18f);
                instancePath.cubicTo(112.83f, 115.74f, 122.9f, 103.78f, 127.99f, 89.9f);
                instancePath.cubicTo(133.51f, 75.11f, 133.31f, 58.27f, 127.42f, 43.62f);
                instancePath.cubicTo(121.38f, 28.33f, 109.23f, 15.59f, 94.26f, 8.81f);
                instancePath.cubicTo(82.86f, 3.56f, 69.91f, 1.85f, 57.52f, 3.77f);
                instancePath.lineTo(57.52f, 3.77f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(71.48f, 36.66f);
                instancePath2.cubicTo(72.83f, 35.99f, 74.57f, 36.22f, 75.64f, 37.3f);
                instancePath2.cubicTo(83.56f, 45.03f, 88.42f, 55.92f, 88.48f, 67.02f);
                instancePath2.cubicTo(88.67f, 78.18f, 84.03f, 89.26f, 76.17f, 97.15f);
                instancePath2.cubicTo(74.45f, 99.09f, 70.93f, 98.32f, 70.08f, 95.91f);
                instancePath2.cubicTo(68.99f, 93.68f, 70.93f, 91.82f, 72.27f, 90.3f);
                instancePath2.cubicTo(79.57f, 82.18f, 82.68f, 70.48f, 80.12f, 59.83f);
                instancePath2.cubicTo(78.66f, 53.24f, 74.97f, 47.37f, 70.39f, 42.5f);
                instancePath2.cubicTo(68.62f, 40.81f, 69.29f, 37.63f, 71.48f, 36.66f);
                instancePath2.lineTo(71.48f, 36.66f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(59.3f, 46.31f);
                instancePath3.cubicTo(60.57f, 45.47f, 62.43f, 45.46f, 63.59f, 46.49f);
                instancePath3.cubicTo(68.45f, 50.72f, 71.98f, 56.57f, 73.07f, 62.95f);
                instancePath3.cubicTo(74.85f, 72.35f, 70.86f, 82.39f, 63.57f, 88.45f);
                instancePath3.cubicTo(61.49f, 90.24f, 57.87f, 88.68f, 57.65f, 85.97f);
                instancePath3.cubicTo(57.22f, 83.91f, 59.11f, 82.64f, 60.26f, 81.26f);
                instancePath3.cubicTo(65.65f, 75.95f, 67.57f, 67.36f, 64.59f, 60.34f);
                instancePath3.cubicTo(63.43f, 57.09f, 61.06f, 54.54f, 58.76f, 52.06f);
                instancePath3.cubicTo(56.99f, 50.55f, 57.36f, 47.51f, 59.3f, 46.31f);
                instancePath3.lineTo(59.3f, 46.31f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint3, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(46.43f, 61.47f);
                instancePath4.cubicTo(46.3f, 59.41f, 46.86f, 56.89f, 49.2f, 56.39f);
                instancePath4.cubicTo(52.91f, 55.56f, 55.53f, 59.18f, 57.13f, 62.0f);
                instancePath4.cubicTo(60.25f, 67.57f, 57.7f, 75.02f, 52.41f, 78.25f);
                instancePath4.cubicTo(49.41f, 79.96f, 45.5f, 77.16f, 46.46f, 73.72f);
                instancePath4.cubicTo(48.18f, 72.01f, 50.78f, 70.71f, 50.99f, 68.0f);
                instancePath4.cubicTo(51.36f, 64.94f, 48.63f, 62.98f, 46.43f, 61.47f);
                instancePath4.lineTo(46.43f, 61.47f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
