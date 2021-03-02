package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_pause extends c {
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
                instancePath.moveTo(19.5f, 13.5f);
                instancePath.lineTo(25.5f, 13.5f);
                instancePath.cubicTo(27.156855f, 13.5f, 28.5f, 14.843145f, 28.5f, 16.5f);
                instancePath.lineTo(28.5f, 55.5f);
                instancePath.cubicTo(28.5f, 57.156853f, 27.156855f, 58.5f, 25.5f, 58.5f);
                instancePath.lineTo(19.5f, 58.5f);
                instancePath.cubicTo(17.843145f, 58.5f, 16.5f, 57.156853f, 16.5f, 55.5f);
                instancePath.lineTo(16.5f, 16.5f);
                instancePath.cubicTo(16.5f, 14.843145f, 17.843145f, 13.5f, 19.5f, 13.5f);
                instancePath.close();
                instancePath.moveTo(46.5f, 13.5f);
                instancePath.lineTo(52.5f, 13.5f);
                instancePath.cubicTo(54.156853f, 13.5f, 55.5f, 14.843145f, 55.5f, 16.5f);
                instancePath.lineTo(55.5f, 55.5f);
                instancePath.cubicTo(55.5f, 57.156853f, 54.156853f, 58.5f, 52.5f, 58.5f);
                instancePath.lineTo(46.5f, 58.5f);
                instancePath.cubicTo(44.843147f, 58.5f, 43.5f, 57.156853f, 43.5f, 55.5f);
                instancePath.lineTo(43.5f, 16.5f);
                instancePath.cubicTo(43.5f, 14.843145f, 44.843147f, 13.5f, 46.5f, 13.5f);
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
