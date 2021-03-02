package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class tipsbar_bluetooth_icon extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(96.0f, 0.0f);
                instancePath.lineTo(96.0f, 96.0f);
                instancePath.lineTo(0.0f, 96.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-15028967);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(46.279175f, 21.000214f);
                instancePath2.lineTo(46.279175f, 44.5821f);
                instancePath2.lineTo(33.04137f, 33.706234f);
                instancePath2.lineTo(31.0f, 36.192547f);
                instancePath2.lineTo(45.37214f, 47.999035f);
                instancePath2.lineTo(31.0f, 59.806595f);
                instancePath2.lineTo(33.04137f, 62.292908f);
                instancePath2.lineTo(46.279175f, 51.41704f);
                instancePath2.lineTo(46.279175f, 75.0f);
                instancePath2.lineTo(64.73941f, 59.746555f);
                instancePath2.lineTo(50.43911f, 47.999035f);
                instancePath2.lineTo(64.73941f, 36.251514f);
                instancePath2.lineTo(46.279175f, 21.000214f);
                instancePath2.close();
                instancePath2.moveTo(49.495617f, 27.828722f);
                instancePath2.lineTo(59.68102f, 36.244007f);
                instancePath2.lineTo(49.495617f, 44.61212f);
                instancePath2.lineTo(49.495617f, 27.828722f);
                instancePath2.close();
                instancePath2.moveTo(49.495617f, 51.38595f);
                instancePath2.lineTo(59.68102f, 59.75299f);
                instancePath2.lineTo(49.495617f, 68.16935f);
                instancePath2.lineTo(49.495617f, 51.38595f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
