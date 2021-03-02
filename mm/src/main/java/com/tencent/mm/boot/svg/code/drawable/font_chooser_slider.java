package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class font_chooser_slider extends c {
    private final int height = 78;
    private final int width = 78;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 78;
            case 1:
                return 78;
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
                instancePaint3.setColor(-1776412);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(39.0f, 78.0f);
                instancePath.cubicTo(60.539104f, 78.0f, 78.0f, 60.539104f, 78.0f, 39.0f);
                instancePath.cubicTo(78.0f, 17.460896f, 60.539104f, 0.0f, 39.0f, 0.0f);
                instancePath.cubicTo(17.460896f, 0.0f, 0.0f, 17.460896f, 0.0f, 39.0f);
                instancePath.cubicTo(0.0f, 60.539104f, 17.460896f, 78.0f, 39.0f, 78.0f);
                instancePath.close();
                instancePath.moveTo(39.0f, 73.0f);
                instancePath.cubicTo(57.777683f, 73.0f, 73.0f, 57.777683f, 73.0f, 39.0f);
                instancePath.cubicTo(73.0f, 20.222319f, 57.777683f, 5.0f, 39.0f, 5.0f);
                instancePath.cubicTo(20.222319f, 5.0f, 5.0f, 20.222319f, 5.0f, 39.0f);
                instancePath.cubicTo(5.0f, 57.777683f, 20.222319f, 73.0f, 39.0f, 73.0f);
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
