package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class text_selected extends c {
    private final int height = 63;
    private final int width = 63;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 63;
            case 1:
                return 63;
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
                instancePaint3.setColor(-14624737);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(35.0f, 20.0f);
                instancePath.lineTo(50.492165f, 20.0f);
                instancePath.cubicTo(51.322575f, 20.0f, 52.0f, 19.326305f, 52.0f, 18.495262f);
                instancePath.lineTo(52.0f, 13.504739f);
                instancePath.cubicTo(52.0f, 12.668316f, 51.324917f, 12.0f, 50.492165f, 12.0f);
                instancePath.lineTo(12.507836f, 12.0f);
                instancePath.cubicTo(11.677424f, 12.0f, 11.0f, 12.673695f, 11.0f, 13.504739f);
                instancePath.lineTo(11.0f, 18.495262f);
                instancePath.cubicTo(11.0f, 19.331684f, 11.675081f, 20.0f, 12.507836f, 20.0f);
                instancePath.lineTo(27.0f, 20.0f);
                instancePath.lineTo(27.0f, 52.5052f);
                instancePath.cubicTo(27.0f, 53.32327f, 27.673695f, 54.0f, 28.504738f, 54.0f);
                instancePath.lineTo(33.495262f, 54.0f);
                instancePath.cubicTo(34.331684f, 54.0f, 35.0f, 53.330753f, 35.0f, 52.5052f);
                instancePath.lineTo(35.0f, 20.0f);
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
