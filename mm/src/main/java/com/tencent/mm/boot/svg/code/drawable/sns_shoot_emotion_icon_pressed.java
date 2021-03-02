package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sns_shoot_emotion_icon_pressed extends c {
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
                instancePaint3.setColor(-7960954);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(37.78f, 0.0f);
                instancePath.lineTo(41.06f, 0.0f);
                instancePath.cubicTo(50.72f, 0.32f, 60.25f, 4.09f, 67.28f, 10.76f);
                instancePath.cubicTo(74.82f, 17.7f, 79.36f, 27.62f, 80.0f, 37.82f);
                instancePath.lineTo(80.0f, 41.96f);
                instancePath.cubicTo(79.4f, 53.2f, 73.96f, 64.11f, 65.11f, 71.1f);
                instancePath.cubicTo(58.68f, 76.45f, 50.49f, 79.36f, 42.2f, 80.0f);
                instancePath.lineTo(38.02f, 80.0f);
                instancePath.cubicTo(29.65f, 79.43f, 21.38f, 76.49f, 14.9f, 71.1f);
                instancePath.cubicTo(5.88f, 63.97f, 0.36f, 52.77f, 0.0f, 41.29f);
                instancePath.lineTo(0.0f, 38.03f);
                instancePath.cubicTo(0.57f, 27.75f, 5.14f, 17.73f, 12.73f, 10.75f);
                instancePath.cubicTo(19.48f, 4.33f, 28.54f, 0.68f, 37.78f, 0.0f);
                instancePath.lineTo(37.78f, 0.0f);
                instancePath.close();
                instancePath.moveTo(22.35f, 21.53f);
                instancePath.cubicTo(17.6f, 23.92f, 17.99f, 32.16f, 23.16f, 33.8f);
                instancePath.cubicTo(27.59f, 35.1f, 30.99f, 29.79f, 29.81f, 25.87f);
                instancePath.cubicTo(29.31f, 22.58f, 25.55f, 19.78f, 22.35f, 21.53f);
                instancePath.lineTo(22.35f, 21.53f);
                instancePath.close();
                instancePath.moveTo(53.4f, 21.51f);
                instancePath.cubicTo(48.31f, 23.96f, 49.12f, 33.05f, 54.92f, 33.96f);
                instancePath.cubicTo(59.09f, 34.44f, 61.82f, 29.6f, 60.82f, 25.93f);
                instancePath.cubicTo(60.35f, 22.64f, 56.62f, 19.79f, 53.4f, 21.51f);
                instancePath.lineTo(53.4f, 21.51f);
                instancePath.close();
                instancePath.moveTo(11.94f, 43.0f);
                instancePath.cubicTo(12.98f, 52.49f, 18.9f, 61.77f, 28.15f, 65.02f);
                instancePath.cubicTo(36.8f, 68.0f, 46.7f, 67.7f, 55.11f, 64.05f);
                instancePath.cubicTo(63.24f, 60.48f, 68.0f, 51.67f, 68.07f, 43.0f);
                instancePath.cubicTo(49.59f, 39.13f, 30.42f, 39.11f, 11.94f, 43.0f);
                instancePath.lineTo(11.94f, 43.0f);
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
