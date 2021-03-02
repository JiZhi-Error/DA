package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fav_search_video_pressed extends c {
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
                instancePaint3.setColor(-9207928);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(64.31f, 0.0f);
                instancePath.lineTo(70.36f, 0.0f);
                instancePath.cubicTo(86.13f, 0.75f, 101.58f, 7.05f, 113.16f, 17.81f);
                instancePath.cubicTo(126.28f, 29.71f, 134.19f, 46.96f, 135.0f, 64.63f);
                instancePath.lineTo(135.0f, 70.06f);
                instancePath.cubicTo(134.29f, 87.85f, 126.34f, 105.24f, 113.14f, 117.21f);
                instancePath.cubicTo(101.65f, 127.9f, 86.33f, 134.15f, 70.7f, 135.0f);
                instancePath.lineTo(64.61f, 135.0f);
                instancePath.cubicTo(48.84f, 134.24f, 33.37f, 127.94f, 21.8f, 117.16f);
                instancePath.cubicTo(8.65f, 105.22f, 0.75f, 87.89f, 0.0f, 70.17f);
                instancePath.lineTo(0.0f, 64.67f);
                instancePath.cubicTo(0.8f, 47.0f, 8.69f, 29.74f, 21.81f, 17.84f);
                instancePath.cubicTo(33.31f, 7.13f, 48.65f, 0.86f, 64.31f, 0.0f);
                instancePath.lineTo(64.31f, 0.0f);
                instancePath.close();
                instancePath.moveTo(39.37f, 50.47f);
                instancePath.cubicTo(37.77f, 51.38f, 38.02f, 53.4f, 37.98f, 54.96f);
                instancePath.cubicTo(38.05f, 64.0f, 37.92f, 73.04f, 38.04f, 82.08f);
                instancePath.cubicTo(37.95f, 83.58f, 39.36f, 85.08f, 40.89f, 84.96f);
                instancePath.cubicTo(53.29f, 85.03f, 65.69f, 85.03f, 78.09f, 84.96f);
                instancePath.cubicTo(79.61f, 85.08f, 81.04f, 83.62f, 80.96f, 82.12f);
                instancePath.cubicTo(81.06f, 72.7f, 80.98f, 63.29f, 81.0f, 53.87f);
                instancePath.cubicTo(81.29f, 52.11f, 80.14f, 49.93f, 78.14f, 50.05f);
                instancePath.cubicTo(66.77f, 49.91f, 55.39f, 50.07f, 44.02f, 49.98f);
                instancePath.cubicTo(42.49f, 50.13f, 40.76f, 49.67f, 39.37f, 50.47f);
                instancePath.lineTo(39.37f, 50.47f);
                instancePath.close();
                instancePath.moveTo(84.01f, 64.47f);
                instancePath.cubicTo(84.0f, 66.98f, 83.99f, 69.48f, 84.0f, 71.99f);
                instancePath.cubicTo(89.66f, 76.01f, 95.34f, 80.0f, 101.01f, 84.01f);
                instancePath.cubicTo(100.99f, 73.01f, 101.01f, 62.01f, 101.0f, 51.01f);
                instancePath.cubicTo(95.32f, 55.47f, 89.7f, 60.01f, 84.01f, 64.47f);
                instancePath.lineTo(84.01f, 64.47f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
