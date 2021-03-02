package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_location extends c {
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
                instancePath.moveTo(33.785156f, 66.40343f);
                instancePath.cubicTo(33.785156f, 66.40343f, 12.0f, 48.054832f, 12.0f, 30.0f);
                instancePath.cubicTo(12.0f, 16.745167f, 22.745167f, 6.0f, 36.0f, 6.0f);
                instancePath.cubicTo(49.254833f, 6.0f, 60.0f, 16.745167f, 60.0f, 30.0f);
                instancePath.cubicTo(60.0f, 48.054832f, 38.225567f, 66.39341f, 38.225567f, 66.39341f);
                instancePath.cubicTo(37.000694f, 67.51806f, 35.00838f, 67.5061f, 33.785156f, 66.40343f);
                instancePath.close();
                instancePath.moveTo(36.0f, 40.5f);
                instancePath.cubicTo(41.79899f, 40.5f, 46.5f, 35.79899f, 46.5f, 30.0f);
                instancePath.cubicTo(46.5f, 24.20101f, 41.79899f, 19.5f, 36.0f, 19.5f);
                instancePath.cubicTo(30.20101f, 19.5f, 25.5f, 24.20101f, 25.5f, 30.0f);
                instancePath.cubicTo(25.5f, 35.79899f, 30.20101f, 40.5f, 36.0f, 40.5f);
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
