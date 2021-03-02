package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_transfer_text extends c {
    private final int height = 72;
    private final int width = 72;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(12.0f, 9.0f);
                instancePath.lineTo(60.0f, 9.0f);
                instancePath.cubicTo(61.656853f, 9.0f, 63.0f, 10.343145f, 63.0f, 12.0f);
                instancePath.lineTo(63.0f, 60.0f);
                instancePath.cubicTo(63.0f, 61.656853f, 61.656853f, 63.0f, 60.0f, 63.0f);
                instancePath.lineTo(12.0f, 63.0f);
                instancePath.cubicTo(10.343145f, 63.0f, 9.0f, 61.656853f, 9.0f, 60.0f);
                instancePath.lineTo(9.0f, 12.0f);
                instancePath.cubicTo(9.0f, 10.343145f, 10.343145f, 9.0f, 12.0f, 9.0f);
                instancePath.close();
                instancePath.moveTo(12.6f, 12.6f);
                instancePath.lineTo(12.6f, 59.4f);
                instancePath.lineTo(59.4f, 59.4f);
                instancePath.lineTo(59.4f, 12.6f);
                instancePath.lineTo(12.6f, 12.6f);
                instancePath.close();
                instancePath.moveTo(22.71f, 26.58f);
                instancePath.lineTo(34.59f, 26.58f);
                instancePath.cubicTo(33.84f, 25.2f, 32.91f, 23.91f, 31.83f, 22.68f);
                instancePath.lineTo(34.98f, 21.54f);
                instancePath.cubicTo(36.06f, 22.95f, 37.05f, 24.63f, 37.95f, 26.58f);
                instancePath.lineTo(49.29f, 26.58f);
                instancePath.lineTo(49.29f, 29.7f);
                instancePath.lineTo(44.76f, 29.7f);
                instancePath.cubicTo(43.32f, 34.2f, 41.22f, 37.95f, 38.46f, 40.98f);
                instancePath.cubicTo(41.55f, 43.44f, 45.39f, 45.48f, 49.95f, 47.16f);
                instancePath.lineTo(48.21f, 49.83f);
                instancePath.cubicTo(43.41f, 48.03f, 39.42f, 45.81f, 36.24f, 43.17f);
                instancePath.cubicTo(32.88f, 46.14f, 28.74f, 48.33f, 23.85f, 49.71f);
                instancePath.lineTo(22.17f, 46.95f);
                instancePath.cubicTo(26.94f, 45.72f, 30.9f, 43.8f, 34.02f, 41.16f);
                instancePath.cubicTo(30.78f, 37.86f, 28.53f, 34.05f, 27.27f, 29.7f);
                instancePath.lineTo(22.71f, 29.7f);
                instancePath.lineTo(22.71f, 26.58f);
                instancePath.close();
                instancePath.moveTo(30.27f, 29.7f);
                instancePath.cubicTo(31.5f, 33.24f, 33.48f, 36.33f, 36.24f, 39.03f);
                instancePath.cubicTo(38.58f, 36.45f, 40.35f, 33.33f, 41.52f, 29.7f);
                instancePath.lineTo(30.27f, 29.7f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
