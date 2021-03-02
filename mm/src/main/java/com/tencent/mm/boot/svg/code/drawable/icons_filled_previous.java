package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_previous extends c {
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(31.757359f, 27.0f);
                instancePath.lineTo(37.24264f, 32.485283f);
                instancePath.lineTo(33.0f, 36.72792f);
                instancePath.lineTo(24.514719f, 28.242641f);
                instancePath.lineTo(22.393398f, 26.12132f);
                instancePath.cubicTo(21.221825f, 24.949747f, 21.221825f, 23.050253f, 22.393398f, 21.87868f);
                instancePath.lineTo(33.0f, 11.272078f);
                instancePath.lineTo(37.24264f, 15.514719f);
                instancePath.lineTo(31.757359f, 21.0f);
                instancePath.lineTo(45.0f, 21.0f);
                instancePath.cubicTo(54.941124f, 21.0f, 63.0f, 29.058874f, 63.0f, 39.0f);
                instancePath.cubicTo(63.0f, 48.941124f, 54.941124f, 57.0f, 45.0f, 57.0f);
                instancePath.lineTo(12.0f, 57.0f);
                instancePath.lineTo(12.0f, 51.0f);
                instancePath.lineTo(45.0f, 51.0f);
                instancePath.cubicTo(51.62742f, 51.0f, 57.0f, 45.62742f, 57.0f, 39.0f);
                instancePath.cubicTo(57.0f, 32.37258f, 51.62742f, 27.0f, 45.0f, 27.0f);
                instancePath.lineTo(31.757359f, 27.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
