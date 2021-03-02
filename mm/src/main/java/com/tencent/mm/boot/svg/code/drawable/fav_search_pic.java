package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fav_search_pic extends c {
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
                instancePath.moveTo(63.94f, 0.0f);
                instancePath.lineTo(70.81f, 0.0f);
                instancePath.cubicTo(86.67f, 0.91f, 102.18f, 7.35f, 113.71f, 18.32f);
                instancePath.cubicTo(126.37f, 30.04f, 133.96f, 46.78f, 135.0f, 63.96f);
                instancePath.lineTo(135.0f, 70.81f);
                instancePath.cubicTo(134.04f, 88.09f, 126.4f, 104.93f, 113.68f, 116.71f);
                instancePath.cubicTo(102.22f, 127.61f, 86.83f, 134.01f, 71.08f, 135.0f);
                instancePath.lineTo(64.17f, 135.0f);
                instancePath.cubicTo(48.32f, 134.09f, 32.82f, 127.65f, 21.3f, 116.69f);
                instancePath.cubicTo(8.63f, 104.98f, 1.05f, 88.23f, 0.0f, 71.06f);
                instancePath.lineTo(0.0f, 64.21f);
                instancePath.cubicTo(0.96f, 46.94f, 8.58f, 30.08f, 21.3f, 18.31f);
                instancePath.cubicTo(32.77f, 7.4f, 48.18f, 0.99f, 63.94f, 0.0f);
                instancePath.lineTo(63.94f, 0.0f);
                instancePath.close();
                instancePath.moveTo(57.48f, 3.78f);
                instancePath.cubicTo(40.34f, 6.39f, 24.51f, 16.32f, 14.64f, 30.56f);
                instancePath.cubicTo(5.98f, 42.81f, 1.91f, 58.16f, 3.25f, 73.09f);
                instancePath.cubicTo(4.37f, 86.66f, 9.99f, 99.8f, 19.01f, 110.01f);
                instancePath.cubicTo(29.36f, 121.91f, 44.22f, 129.77f, 59.9f, 131.54f);
                instancePath.cubicTo(73.73f, 133.21f, 88.08f, 130.26f, 100.07f, 123.17f);
                instancePath.cubicTo(112.84f, 115.73f, 122.91f, 103.76f, 128.0f, 89.88f);
                instancePath.cubicTo(133.43f, 75.31f, 133.31f, 58.76f, 127.67f, 44.26f);
                instancePath.cubicTo(121.81f, 28.94f, 109.83f, 16.09f, 94.97f, 9.14f);
                instancePath.cubicTo(83.39f, 3.63f, 70.14f, 1.8f, 57.48f, 3.78f);
                instancePath.lineTo(57.48f, 3.78f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(39.32f, 45.3f);
                instancePath2.cubicTo(40.83f, 44.79f, 42.47f, 45.06f, 44.03f, 44.98f);
                instancePath2.cubicTo(60.06f, 45.04f, 76.09f, 44.96f, 92.11f, 45.02f);
                instancePath2.cubicTo(93.76f, 44.78f, 95.27f, 46.26f, 94.99f, 47.92f);
                instancePath2.cubicTo(95.01f, 60.63f, 95.01f, 73.34f, 94.99f, 86.06f);
                instancePath2.cubicTo(95.26f, 87.75f, 93.75f, 89.25f, 92.06f, 88.98f);
                instancePath2.cubicTo(75.02f, 89.01f, 57.98f, 89.01f, 40.94f, 88.98f);
                instancePath2.cubicTo(39.28f, 89.24f, 37.73f, 87.77f, 38.02f, 86.09f);
                instancePath2.cubicTo(37.97f, 73.72f, 38.03f, 61.34f, 37.99f, 48.96f);
                instancePath2.cubicTo(37.98f, 47.67f, 37.9f, 45.94f, 39.32f, 45.3f);
                instancePath2.lineTo(39.32f, 45.3f);
                instancePath2.close();
                instancePath2.moveTo(43.0f, 50.0f);
                instancePath2.lineTo(43.0f, 73.62f);
                instancePath2.cubicTo(46.44f, 68.93f, 50.54f, 64.63f, 55.48f, 61.5f);
                instancePath2.cubicTo(57.29f, 60.32f, 59.61f, 59.41f, 61.69f, 60.53f);
                instancePath2.cubicTo(68.61f, 63.77f, 71.39f, 71.39f, 76.27f, 76.76f);
                instancePath2.cubicTo(75.33f, 74.74f, 74.33f, 72.75f, 73.33f, 70.77f);
                instancePath2.cubicTo(75.67f, 69.26f, 77.98f, 66.88f, 80.96f, 67.06f);
                instancePath2.cubicTo(85.06f, 68.1f, 87.56f, 71.89f, 90.01f, 75.03f);
                instancePath2.cubicTo(89.98f, 66.69f, 90.01f, 58.34f, 90.0f, 50.0f);
                instancePath2.lineTo(43.0f, 50.0f);
                instancePath2.lineTo(43.0f, 50.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
