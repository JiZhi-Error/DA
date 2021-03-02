package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_health_note extends c {
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
                instancePath.moveTo(19.5f, 12.0f);
                instancePath.lineTo(19.5f, 15.0f);
                instancePath.cubicTo(19.5f, 18.238398f, 22.065575f, 20.877571f, 25.275063f, 20.995861f);
                instancePath.lineTo(25.5f, 21.0f);
                instancePath.lineTo(46.5f, 21.0f);
                instancePath.cubicTo(49.738396f, 21.0f, 52.37757f, 18.434425f, 52.49586f, 15.224938f);
                instancePath.lineTo(52.5f, 15.0f);
                instancePath.lineTo(52.5f, 12.0f);
                instancePath.lineTo(57.0f, 12.0f);
                instancePath.cubicTo(58.656853f, 12.0f, 60.0f, 13.343145f, 60.0f, 15.0f);
                instancePath.lineTo(60.0f, 63.0f);
                instancePath.cubicTo(60.0f, 64.65685f, 58.656853f, 66.0f, 57.0f, 66.0f);
                instancePath.lineTo(15.0f, 66.0f);
                instancePath.cubicTo(13.343145f, 66.0f, 12.0f, 64.65685f, 12.0f, 63.0f);
                instancePath.lineTo(12.0f, 15.0f);
                instancePath.cubicTo(12.0f, 13.343145f, 13.343145f, 12.0f, 15.0f, 12.0f);
                instancePath.lineTo(19.5f, 12.0f);
                instancePath.close();
                instancePath.moveTo(38.25f, 33.0f);
                instancePath.lineTo(33.75f, 33.0f);
                instancePath.lineTo(33.75f, 39.75f);
                instancePath.lineTo(27.0f, 39.75f);
                instancePath.lineTo(27.0f, 44.25f);
                instancePath.lineTo(33.75f, 44.25f);
                instancePath.lineTo(33.75f, 51.0f);
                instancePath.lineTo(38.25f, 51.0f);
                instancePath.lineTo(38.25f, 44.25f);
                instancePath.lineTo(45.0f, 44.25f);
                instancePath.lineTo(45.0f, 39.75f);
                instancePath.lineTo(38.25f, 39.75f);
                instancePath.lineTo(38.25f, 33.0f);
                instancePath.close();
                instancePath.moveTo(46.5f, 9.0f);
                instancePath.cubicTo(48.156853f, 9.0f, 49.5f, 10.343145f, 49.5f, 12.0f);
                instancePath.lineTo(49.5f, 15.0f);
                instancePath.cubicTo(49.5f, 16.656855f, 48.156853f, 18.0f, 46.5f, 18.0f);
                instancePath.lineTo(25.5f, 18.0f);
                instancePath.cubicTo(23.843145f, 18.0f, 22.5f, 16.656855f, 22.5f, 15.0f);
                instancePath.lineTo(22.5f, 12.0f);
                instancePath.cubicTo(22.5f, 10.343145f, 23.843145f, 9.0f, 25.5f, 9.0f);
                instancePath.lineTo(46.5f, 9.0f);
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
