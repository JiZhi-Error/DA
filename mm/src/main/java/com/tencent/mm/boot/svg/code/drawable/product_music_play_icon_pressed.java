package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class product_music_play_icon_pressed extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-9276814);
                canvas.saveLayerAlpha(null, 128, 31);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(33.9f, 0.0f);
                instancePath.lineTo(38.04f, 0.0f);
                instancePath.cubicTo(46.52f, 0.64f, 54.84f, 4.06f, 60.93f, 10.05f);
                instancePath.cubicTo(67.46f, 16.26f, 71.4f, 24.96f, 72.0f, 33.92f);
                instancePath.lineTo(72.0f, 38.04f);
                instancePath.cubicTo(71.41f, 47.03f, 67.47f, 55.74f, 60.93f, 61.95f);
                instancePath.cubicTo(54.9f, 67.87f, 46.7f, 71.29f, 38.32f, 72.0f);
                instancePath.lineTo(33.95f, 72.0f);
                instancePath.cubicTo(25.01f, 71.39f, 16.3f, 67.52f, 10.12f, 61.0f);
                instancePath.cubicTo(4.16f, 54.92f, 0.64f, 46.69f, 0.0f, 38.23f);
                instancePath.lineTo(0.0f, 33.93f);
                instancePath.cubicTo(0.66f, 23.3f, 6.2f, 13.1f, 14.85f, 6.87f);
                instancePath.cubicTo(20.36f, 2.78f, 27.09f, 0.58f, 33.9f, 0.0f);
                instancePath.lineTo(33.9f, 0.0f);
                instancePath.close();
                instancePath.moveTo(29.45f, 3.65f);
                instancePath.cubicTo(21.99f, 5.18f, 15.07f, 9.34f, 10.31f, 15.3f);
                instancePath.cubicTo(1.3f, 26.14f, 0.57f, 42.84f, 8.63f, 54.42f);
                instancePath.cubicTo(17.32f, 67.89f, 36.42f, 73.03f, 50.65f, 65.55f);
                instancePath.cubicTo(65.31f, 58.67f, 72.85f, 40.15f, 67.11f, 24.99f);
                instancePath.cubicTo(62.07f, 9.86f, 45.05f, 0.15f, 29.45f, 3.65f);
                instancePath.lineTo(29.45f, 3.65f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(26.01f, 19.02f);
                instancePath2.cubicTo(35.34f, 24.67f, 44.66f, 30.33f, 53.98f, 36.0f);
                instancePath2.cubicTo(44.68f, 41.69f, 35.33f, 47.31f, 26.03f, 53.0f);
                instancePath2.cubicTo(25.97f, 41.67f, 26.01f, 30.34f, 26.01f, 19.02f);
                instancePath2.lineTo(26.01f, 19.02f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
