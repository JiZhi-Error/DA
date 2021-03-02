package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class more_my_album extends c {
    private final int height = 108;
    private final int width = 108;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                instancePaint3.setColor(-15683841);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(86.0f, 81.0f);
                instancePath.lineTo(23.0f, 81.0f);
                instancePath.cubicTo(21.344f, 81.0f, 20.0f, 79.657f, 20.0f, 78.0f);
                instancePath.lineTo(20.0f, 31.0f);
                instancePath.cubicTo(20.0f, 29.343f, 21.344f, 28.0f, 23.0f, 28.0f);
                instancePath.lineTo(86.0f, 28.0f);
                instancePath.cubicTo(87.656f, 28.0f, 89.0f, 29.343f, 89.0f, 31.0f);
                instancePath.lineTo(89.0f, 78.0f);
                instancePath.cubicTo(89.0f, 79.657f, 87.656f, 81.0f, 86.0f, 81.0f);
                instancePath.lineTo(86.0f, 81.0f);
                instancePath.close();
                instancePath.moveTo(24.0f, 32.0f);
                instancePath.lineTo(24.0f, 68.031f);
                instancePath.lineTo(43.951f, 48.001f);
                instancePath.lineTo(68.0f, 68.706f);
                instancePath.lineTo(64.273f, 61.914f);
                instancePath.lineTo(71.0f, 54.0f);
                instancePath.lineTo(85.0f, 70.471f);
                instancePath.lineTo(85.0f, 32.0f);
                instancePath.lineTo(24.0f, 32.0f);
                instancePath.lineTo(24.0f, 32.0f);
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
