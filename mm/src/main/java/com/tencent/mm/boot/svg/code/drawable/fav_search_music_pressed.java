package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fav_search_music_pressed extends c {
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
                instancePath.moveTo(64.62f, 0.0f);
                instancePath.lineTo(69.82f, 0.0f);
                instancePath.cubicTo(86.02f, 0.59f, 101.92f, 7.14f, 113.69f, 18.3f);
                instancePath.cubicTo(126.52f, 30.19f, 134.21f, 47.23f, 135.0f, 64.67f);
                instancePath.lineTo(135.0f, 69.7f);
                instancePath.cubicTo(134.43f, 86.65f, 127.28f, 103.29f, 115.22f, 115.23f);
                instancePath.cubicTo(103.44f, 127.13f, 87.1f, 134.22f, 70.39f, 135.0f);
                instancePath.lineTo(65.13f, 135.0f);
                instancePath.cubicTo(48.95f, 134.4f, 33.06f, 127.85f, 21.3f, 116.69f);
                instancePath.cubicTo(8.38f, 104.71f, 0.66f, 87.49f, 0.0f, 69.9f);
                instancePath.lineTo(0.0f, 65.25f);
                instancePath.cubicTo(0.61f, 47.36f, 8.58f, 29.83f, 21.86f, 17.8f);
                instancePath.cubicTo(33.42f, 7.05f, 48.87f, 0.76f, 64.62f, 0.0f);
                instancePath.lineTo(64.62f, 0.0f);
                instancePath.close();
                instancePath.moveTo(52.09248f, 46.367477f);
                instancePath.cubicTo(50.38364f, 46.545963f, 48.854675f, 48.04325f, 49.01457f, 49.81818f);
                instancePath.cubicTo(48.98459f, 60.358685f, 49.01457f, 70.90911f, 49.004574f, 81.45953f);
                instancePath.cubicTo(45.456978f, 81.57852f, 41.08994f, 83.49227f, 41.0f, 87.54784f);
                instancePath.cubicTo(41.039974f, 91.2266f, 44.827404f, 93.12052f, 47.975273f, 93.755135f);
                instancePath.cubicTo(52.24238f, 95.083855f, 56.28964f, 90.76056f, 55.98984f, 86.685165f);
                instancePath.cubicTo(56.01982f, 76.54129f, 55.98984f, 66.397415f, 55.999832f, 56.25354f);
                instancePath.cubicTo(64.66396f, 54.310043f, 73.31809f, 52.336796f, 81.97223f, 50.393295f);
                instancePath.cubicTo(81.99222f, 59.109295f, 81.98222f, 67.825294f, 81.98222f, 76.54129f);
                instancePath.cubicTo(78.14482f, 76.33305f, 73.078255f, 78.15757f, 72.978325f, 82.63951f);
                instancePath.cubicTo(73.467995f, 89.87805f, 86.669044f, 91.0382f, 87.85824f, 83.59143f);
                instancePath.cubicTo(88.158035f, 70.34391f, 87.86823f, 57.076553f, 87.998146f, 43.819115f);
                instancePath.cubicTo(87.9082f, 42.420986f, 88.208f, 40.82454f, 87.27863f, 39.624725f);
                instancePath.cubicTo(86.25932f, 38.662895f, 84.8103f, 39.039696f, 83.59113f, 39.267757f);
                instancePath.cubicTo(73.09824f, 41.647552f, 62.595364f, 44.01743f, 52.09248f, 46.367477f);
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
