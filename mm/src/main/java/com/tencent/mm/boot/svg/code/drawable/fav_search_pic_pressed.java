package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fav_search_pic_pressed extends c {
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
                instancePath.moveTo(64.33f, 0.0f);
                instancePath.lineTo(70.46f, 0.0f);
                instancePath.cubicTo(86.43f, 0.79f, 102.07f, 7.27f, 113.68f, 18.29f);
                instancePath.cubicTo(126.44f, 30.11f, 134.1f, 47.02f, 135.0f, 64.36f);
                instancePath.lineTo(135.0f, 70.12f);
                instancePath.cubicTo(134.28f, 87.64f, 126.56f, 104.77f, 113.68f, 116.71f);
                instancePath.cubicTo(102.13f, 127.69f, 86.58f, 134.14f, 70.7f, 135.0f);
                instancePath.lineTo(64.53f, 135.0f);
                instancePath.cubicTo(48.56f, 134.21f, 32.91f, 127.73f, 21.31f, 116.7f);
                instancePath.cubicTo(8.45f, 104.79f, 0.76f, 87.69f, 0.0f, 70.21f);
                instancePath.lineTo(0.0f, 64.57f);
                instancePath.cubicTo(0.83f, 47.17f, 8.5f, 30.16f, 21.31f, 18.31f);
                instancePath.cubicTo(32.87f, 7.31f, 48.43f, 0.86f, 64.33f, 0.0f);
                instancePath.lineTo(64.33f, 0.0f);
                instancePath.close();
                instancePath.moveTo(38.3f, 45.37f);
                instancePath.cubicTo(36.95f, 46.02f, 36.95f, 47.67f, 36.99f, 48.94f);
                instancePath.cubicTo(37.0f, 61.3f, 37.02f, 73.65f, 36.98f, 86.01f);
                instancePath.cubicTo(37.11f, 87.41f, 36.63f, 89.13f, 37.77f, 90.25f);
                instancePath.cubicTo(38.88f, 91.38f, 40.6f, 90.88f, 42.0f, 91.02f);
                instancePath.cubicTo(59.04f, 90.96f, 76.07f, 91.03f, 93.11f, 90.99f);
                instancePath.cubicTo(94.74f, 91.22f, 96.21f, 89.68f, 95.98f, 88.06f);
                instancePath.cubicTo(96.01f, 74.68f, 96.01f, 61.3f, 95.98f, 47.92f);
                instancePath.cubicTo(96.22f, 46.28f, 94.7f, 44.79f, 93.07f, 45.02f);
                instancePath.cubicTo(76.38f, 44.97f, 59.68f, 45.03f, 42.99f, 44.98f);
                instancePath.cubicTo(41.44f, 45.11f, 39.75f, 44.69f, 38.3f, 45.37f);
                instancePath.lineTo(38.3f, 45.37f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(42.0f, 50.0f);
                instancePath2.lineTo(91.0f, 50.0f);
                instancePath2.cubicTo(91.01f, 58.8f, 90.99f, 67.6f, 91.01f, 76.4f);
                instancePath2.cubicTo(88.58f, 72.83f, 86.13f, 68.76f, 81.95f, 67.06f);
                instancePath2.cubicTo(78.44f, 66.25f, 75.78f, 69.53f, 73.18f, 71.35f);
                instancePath2.cubicTo(73.84f, 72.68f, 74.47f, 74.03f, 75.09f, 75.39f);
                instancePath2.cubicTo(70.89f, 70.42f, 67.58f, 64.27f, 61.69f, 61.07f);
                instancePath2.cubicTo(59.23f, 59.62f, 56.51f, 61.03f, 54.45f, 62.49f);
                instancePath2.cubicTo(49.5f, 65.99f, 45.24f, 70.47f, 41.98f, 75.59f);
                instancePath2.cubicTo(42.02f, 67.06f, 41.99f, 58.53f, 42.0f, 50.0f);
                instancePath2.lineTo(42.0f, 50.0f);
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
