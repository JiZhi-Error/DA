package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_sms extends c {
    private final int height = 144;
    private final int width = 144;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                instancePaint3.setColor(-9276814);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(120.0f, 12.0f);
                instancePath.lineTo(24.0f, 12.0f);
                instancePath.cubicTo(17.4f, 12.0f, 12.06f, 17.4f, 12.06f, 24.0f);
                instancePath.lineTo(12.0f, 132.0f);
                instancePath.lineTo(36.0f, 108.0f);
                instancePath.lineTo(120.0f, 108.0f);
                instancePath.cubicTo(126.6f, 108.0f, 132.0f, 102.6f, 132.0f, 96.0f);
                instancePath.lineTo(132.0f, 24.0f);
                instancePath.cubicTo(132.0f, 17.4f, 126.6f, 12.0f, 120.0f, 12.0f);
                instancePath.lineTo(120.0f, 12.0f);
                instancePath.close();
                instancePath.moveTo(108.0f, 84.0f);
                instancePath.lineTo(36.0f, 84.0f);
                instancePath.lineTo(36.0f, 72.0f);
                instancePath.lineTo(108.0f, 72.0f);
                instancePath.lineTo(108.0f, 84.0f);
                instancePath.lineTo(108.0f, 84.0f);
                instancePath.close();
                instancePath.moveTo(108.0f, 66.0f);
                instancePath.lineTo(36.0f, 66.0f);
                instancePath.lineTo(36.0f, 54.0f);
                instancePath.lineTo(108.0f, 54.0f);
                instancePath.lineTo(108.0f, 66.0f);
                instancePath.lineTo(108.0f, 66.0f);
                instancePath.close();
                instancePath.moveTo(108.0f, 48.0f);
                instancePath.lineTo(36.0f, 48.0f);
                instancePath.lineTo(36.0f, 36.0f);
                instancePath.lineTo(108.0f, 36.0f);
                instancePath.lineTo(108.0f, 48.0f);
                instancePath.lineTo(108.0f, 48.0f);
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