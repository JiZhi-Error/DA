package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fav_search_location_pressed extends c {
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
                instancePath.moveTo(64.43f, 0.0f);
                instancePath.lineTo(70.36f, 0.0f);
                instancePath.cubicTo(86.61f, 0.76f, 102.53f, 7.46f, 114.22f, 18.81f);
                instancePath.cubicTo(126.68f, 30.6f, 134.12f, 47.3f, 135.0f, 64.4f);
                instancePath.lineTo(135.0f, 70.04f);
                instancePath.cubicTo(134.31f, 87.59f, 126.58f, 104.75f, 113.69f, 116.7f);
                instancePath.cubicTo(102.12f, 127.7f, 86.53f, 134.17f, 70.61f, 135.0f);
                instancePath.lineTo(64.61f, 135.0f);
                instancePath.cubicTo(48.61f, 134.24f, 32.93f, 127.74f, 21.3f, 116.69f);
                instancePath.cubicTo(8.43f, 104.77f, 0.74f, 87.65f, 0.0f, 70.15f);
                instancePath.lineTo(0.0f, 64.68f);
                instancePath.cubicTo(0.8f, 47.25f, 8.47f, 30.21f, 21.28f, 18.33f);
                instancePath.cubicTo(32.87f, 7.3f, 48.48f, 0.83f, 64.43f, 0.0f);
                instancePath.lineTo(64.43f, 0.0f);
                instancePath.close();
                instancePath.moveTo(52.66f, 42.66f);
                instancePath.cubicTo(44.71f, 48.71f, 41.53f, 59.9f, 44.75f, 69.31f);
                instancePath.cubicTo(48.78f, 81.4f, 57.88f, 91.02f, 67.52f, 99.0f);
                instancePath.cubicTo(77.11f, 90.99f, 86.23f, 81.41f, 90.25f, 69.31f);
                instancePath.cubicTo(93.47f, 59.92f, 90.3f, 48.73f, 82.36f, 42.67f);
                instancePath.cubicTo(74.01f, 35.84f, 61.01f, 35.84f, 52.66f, 42.66f);
                instancePath.lineTo(52.66f, 42.66f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(63.25f, 50.28f);
                instancePath2.cubicTo(69.49f, 47.7f, 77.27f, 51.6f, 79.0f, 58.1f);
                instancePath2.cubicTo(81.0f, 64.22f, 77.06f, 71.37f, 70.86f, 73.02f);
                instancePath2.cubicTo(64.78f, 74.97f, 57.7f, 71.09f, 56.01f, 64.96f);
                instancePath2.cubicTo(54.11f, 59.14f, 57.5f, 52.33f, 63.25f, 50.28f);
                instancePath2.lineTo(63.25f, 50.28f);
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
