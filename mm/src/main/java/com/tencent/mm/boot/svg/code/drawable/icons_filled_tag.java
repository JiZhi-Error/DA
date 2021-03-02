package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_tag extends c {
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
                instancePath.moveTo(9.621321f, 42.62132f);
                instancePath.cubicTo(8.449747f, 41.44975f, 8.449747f, 39.55025f, 9.621321f, 38.37868f);
                instancePath.lineTo(38.12132f, 9.878679f);
                instancePath.cubicTo(38.68393f, 9.316071f, 39.44699f, 9.0f, 40.24264f, 9.0f);
                instancePath.lineTo(60.0f, 9.0f);
                instancePath.cubicTo(61.656853f, 9.0f, 63.0f, 10.343145f, 63.0f, 12.0f);
                instancePath.lineTo(63.0f, 31.757359f);
                instancePath.cubicTo(63.0f, 32.55301f, 62.68393f, 33.31607f, 62.12132f, 33.87868f);
                instancePath.lineTo(33.62132f, 62.37868f);
                instancePath.cubicTo(32.44975f, 63.55025f, 30.550253f, 63.55025f, 29.37868f, 62.37868f);
                instancePath.lineTo(9.621321f, 42.62132f);
                instancePath.close();
                instancePath.moveTo(48.0f, 30.0f);
                instancePath.cubicTo(51.31371f, 30.0f, 54.0f, 27.31371f, 54.0f, 24.0f);
                instancePath.cubicTo(54.0f, 20.68629f, 51.31371f, 18.0f, 48.0f, 18.0f);
                instancePath.cubicTo(44.68629f, 18.0f, 42.0f, 20.68629f, 42.0f, 24.0f);
                instancePath.cubicTo(42.0f, 27.31371f, 44.68629f, 30.0f, 48.0f, 30.0f);
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
