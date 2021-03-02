package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_search extends c {
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
                instancePath.moveTo(49.864876f, 45.51525f);
                instancePath.lineTo(62.598618f, 58.248997f);
                instancePath.lineTo(58.355976f, 62.49164f);
                instancePath.lineTo(45.63759f, 49.77325f);
                instancePath.cubicTo(42.1214f, 52.426655f, 37.744442f, 54.0f, 33.0f, 54.0f);
                instancePath.cubicTo(21.402f, 54.0f, 12.0f, 44.598f, 12.0f, 33.0f);
                instancePath.cubicTo(12.0f, 21.402f, 21.402f, 12.0f, 33.0f, 12.0f);
                instancePath.cubicTo(44.598f, 12.0f, 54.0f, 21.402f, 54.0f, 33.0f);
                instancePath.cubicTo(54.0f, 37.68957f, 52.462833f, 42.020115f, 49.864876f, 45.51525f);
                instancePath.close();
                instancePath.moveTo(48.0f, 33.0f);
                instancePath.cubicTo(48.0f, 24.715714f, 41.284286f, 18.0f, 33.0f, 18.0f);
                instancePath.cubicTo(24.715714f, 18.0f, 18.0f, 24.715714f, 18.0f, 33.0f);
                instancePath.cubicTo(18.0f, 41.284286f, 24.715714f, 48.0f, 33.0f, 48.0f);
                instancePath.cubicTo(41.284286f, 48.0f, 48.0f, 41.284286f, 48.0f, 33.0f);
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
