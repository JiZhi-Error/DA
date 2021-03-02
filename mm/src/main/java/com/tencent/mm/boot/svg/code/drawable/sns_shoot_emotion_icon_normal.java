package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sns_shoot_emotion_icon_normal extends c {
    private final int height = 80;
    private final int width = 80;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 80;
            case 1:
                return 80;
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
                instancePaint3.setColor(-11316397);
                canvas.saveLayerAlpha(null, 192, 31);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(37.22f, 0.0f);
                instancePath.lineTo(41.24f, 0.0f);
                instancePath.cubicTo(51.3f, 0.4f, 61.21f, 4.53f, 68.29f, 11.75f);
                instancePath.cubicTo(75.07f, 18.41f, 79.06f, 27.57f, 80.0f, 36.98f);
                instancePath.lineTo(80.0f, 42.08f);
                instancePath.cubicTo(79.34f, 53.27f, 73.92f, 64.13f, 65.09f, 71.1f);
                instancePath.cubicTo(58.82f, 76.35f, 50.85f, 79.17f, 42.77f, 80.0f);
                instancePath.lineTo(37.53f, 80.0f);
                instancePath.cubicTo(29.35f, 79.27f, 21.28f, 76.41f, 14.93f, 71.12f);
                instancePath.cubicTo(5.92f, 64.01f, 0.41f, 52.84f, 0.0f, 41.39f);
                instancePath.lineTo(0.0f, 37.28f);
                instancePath.cubicTo(0.83f, 27.74f, 4.89f, 18.45f, 11.75f, 11.72f);
                instancePath.cubicTo(18.45f, 4.85f, 27.73f, 0.92f, 37.22f, 0.0f);
                instancePath.lineTo(37.22f, 0.0f);
                instancePath.lineTo(37.22f, 0.0f);
                instancePath.close();
                instancePath.moveTo(22.36f, 21.51f);
                instancePath.cubicTo(17.63f, 23.88f, 17.96f, 32.09f, 23.09f, 33.78f);
                instancePath.cubicTo(27.53f, 35.16f, 30.98f, 29.87f, 29.83f, 25.92f);
                instancePath.cubicTo(29.37f, 22.59f, 25.58f, 19.78f, 22.36f, 21.51f);
                instancePath.lineTo(22.36f, 21.51f);
                instancePath.lineTo(22.36f, 21.51f);
                instancePath.close();
                instancePath.moveTo(53.42f, 21.49f);
                instancePath.cubicTo(48.62f, 23.81f, 48.94f, 32.09f, 54.09f, 33.78f);
                instancePath.cubicTo(58.54f, 35.16f, 61.99f, 29.86f, 60.82f, 25.91f);
                instancePath.cubicTo(60.36f, 22.61f, 56.63f, 19.81f, 53.42f, 21.49f);
                instancePath.lineTo(53.42f, 21.49f);
                instancePath.lineTo(53.42f, 21.49f);
                instancePath.close();
                instancePath.moveTo(11.95f, 42.99f);
                instancePath.cubicTo(12.95f, 52.73f, 19.22f, 62.19f, 28.79f, 65.26f);
                instancePath.cubicTo(37.5f, 67.98f, 47.39f, 67.67f, 55.7f, 63.77f);
                instancePath.cubicTo(63.52f, 60.07f, 68.0f, 51.44f, 68.08f, 42.99f);
                instancePath.cubicTo(49.6f, 39.13f, 30.42f, 39.11f, 11.95f, 42.99f);
                instancePath.lineTo(11.95f, 42.99f);
                instancePath.lineTo(11.95f, 42.99f);
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
