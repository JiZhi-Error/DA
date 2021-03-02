package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_volume_off extends c {
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
                instancePaint3.setColor(-16515072);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(27.18198f, 20.81802f);
                instancePath.lineTo(33.9f, 14.1f);
                instancePath.cubicTo(35.1f, 12.9f, 36.9f, 12.9f, 38.1f, 14.1f);
                instancePath.cubicTo(38.7f, 14.7f, 39.0f, 15.3f, 39.0f, 16.2f);
                instancePath.lineTo(39.0f, 32.63604f);
                instancePath.lineTo(47.635643f, 41.271683f);
                instancePath.cubicTo(48.456047f, 39.64947f, 48.9f, 37.824738f, 48.9f, 36.0f);
                instancePath.cubicTo(48.9f, 33.0f, 47.7f, 30.0f, 45.6f, 27.9f);
                instancePath.lineTo(45.3f, 27.6f);
                instancePath.lineTo(48.6f, 24.3f);
                instancePath.lineTo(48.9f, 24.6f);
                instancePath.cubicTo(51.9f, 27.6f, 53.7f, 31.8f, 53.7f, 36.0f);
                instancePath.cubicTo(53.7f, 39.056602f, 52.74665f, 42.113205f, 51.071224f, 44.707264f);
                instancePath.lineTo(53.827003f, 47.463043f);
                instancePath.cubicTo(56.190712f, 44.108547f, 57.3f, 40.239155f, 57.3f, 36.0f);
                instancePath.cubicTo(57.3f, 30.6f, 55.2f, 25.8f, 51.6f, 21.9f);
                instancePath.lineTo(51.3f, 21.6f);
                instancePath.lineTo(54.6f, 18.3f);
                instancePath.lineTo(54.9f, 18.6f);
                instancePath.cubicTo(59.4f, 23.1f, 62.1f, 29.4f, 62.1f, 36.0f);
                instancePath.cubicTo(62.1f, 41.460022f, 60.457474f, 46.50941f, 57.172424f, 50.808464f);
                instancePath.lineTo(66.27565f, 59.91169f);
                instancePath.lineTo(63.09367f, 63.09367f);
                instancePath.lineTo(12.18198f, 12.18198f);
                instancePath.lineTo(15.363961f, 9.0f);
                instancePath.lineTo(27.18198f, 20.81802f);
                instancePath.close();
                instancePath.moveTo(39.0f, 45.36396f);
                instancePath.lineTo(39.0f, 55.8f);
                instancePath.cubicTo(39.0f, 57.6f, 37.8f, 58.8f, 36.0f, 58.8f);
                instancePath.cubicTo(35.1f, 58.8f, 34.5f, 58.5f, 33.9f, 57.9f);
                instancePath.lineTo(22.5f, 46.5f);
                instancePath.lineTo(9.0f, 46.5f);
                instancePath.cubicTo(7.2f, 46.5f, 6.0f, 45.3f, 6.0f, 43.5f);
                instancePath.lineTo(6.0f, 28.5f);
                instancePath.cubicTo(6.0f, 26.7f, 7.2f, 25.5f, 9.0f, 25.5f);
                instancePath.lineTo(19.13604f, 25.5f);
                instancePath.lineTo(39.0f, 45.36396f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
