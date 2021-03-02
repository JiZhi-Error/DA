package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class scan_detail_movie_icon extends c {
    private final int height = 120;
    private final int width = 120;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                instancePaint3.setColor(-1);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(57.74f, 0.0f);
                instancePath.lineTo(61.88f, 0.0f);
                instancePath.cubicTo(76.5f, 0.47f, 90.87f, 6.44f, 101.42f, 16.6f);
                instancePath.cubicTo(112.63f, 27.2f, 119.36f, 42.25f, 120.0f, 57.65f);
                instancePath.lineTo(120.0f, 62.03f);
                instancePath.cubicTo(119.47f, 77.56f, 112.7f, 92.75f, 101.39f, 103.42f);
                instancePath.cubicTo(90.95f, 113.49f, 76.75f, 119.41f, 62.28f, 120.0f);
                instancePath.lineTo(58.1f, 120.0f);
                instancePath.cubicTo(42.07f, 119.5f, 26.38f, 112.32f, 15.65f, 100.39f);
                instancePath.cubicTo(6.15f, 90.08f, 0.61f, 76.34f, 0.0f, 62.36f);
                instancePath.lineTo(0.0f, 57.99f);
                instancePath.cubicTo(0.53f, 42.26f, 7.48f, 26.86f, 19.05f, 16.16f);
                instancePath.cubicTo(29.45f, 6.34f, 43.46f, 0.59f, 57.74f, 0.0f);
                instancePath.lineTo(57.74f, 0.0f);
                instancePath.close();
                instancePath.moveTo(50.53f, 4.81f);
                instancePath.cubicTo(34.94f, 7.39f, 20.71f, 17.0f, 12.43f, 30.46f);
                instancePath.cubicTo(4.17f, 43.58f, 1.85f, 60.21f, 6.07f, 75.11f);
                instancePath.cubicTo(9.83f, 88.74f, 19.02f, 100.74f, 31.15f, 108.0f);
                instancePath.cubicTo(44.42f, 116.08f, 61.13f, 118.16f, 76.0f, 113.67f);
                instancePath.cubicTo(89.73f, 109.64f, 101.71f, 100.06f, 108.73f, 87.6f);
                instancePath.cubicTo(115.52f, 75.74f, 117.64f, 61.35f, 114.7f, 48.02f);
                instancePath.cubicTo(111.63f, 33.64f, 102.57f, 20.7f, 90.16f, 12.83f);
                instancePath.cubicTo(78.57f, 5.32f, 64.13f, 2.44f, 50.53f, 4.81f);
                instancePath.lineTo(50.53f, 4.81f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(42.0f, 32.01f);
                instancePath2.cubicTo(57.32f, 41.34f, 72.66f, 50.64f, 87.97f, 60.0f);
                instancePath2.cubicTo(72.67f, 69.37f, 57.32f, 78.66f, 42.01f, 88.0f);
                instancePath2.cubicTo(42.0f, 69.33f, 42.0f, 50.67f, 42.0f, 32.01f);
                instancePath2.lineTo(42.0f, 32.01f);
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
