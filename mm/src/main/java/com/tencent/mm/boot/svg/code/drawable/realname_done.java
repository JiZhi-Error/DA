package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class realname_done extends c {
    private final int height = 192;
    private final int width = 192;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 192;
            case 1:
                return 192;
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
                instancePaint3.setColor(-16268960);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(96.0f, 176.0f);
                instancePath.cubicTo(51.81722f, 176.0f, 16.0f, 140.18279f, 16.0f, 96.0f);
                instancePath.cubicTo(16.0f, 51.81722f, 51.81722f, 16.0f, 96.0f, 16.0f);
                instancePath.cubicTo(140.18279f, 16.0f, 176.0f, 51.81722f, 176.0f, 96.0f);
                instancePath.cubicTo(176.0f, 140.18279f, 140.18279f, 176.0f, 96.0f, 176.0f);
                instancePath.close();
                instancePath.moveTo(86.5875f, 113.11453f);
                instancePath.lineTo(64.460304f, 90.987335f);
                instancePath.lineTo(56.0f, 99.44764f);
                instancePath.lineTo(80.95047f, 124.41615f);
                instancePath.cubicTo(80.94989f, 124.41731f, 80.95018f, 124.4176f, 80.95047f, 124.41789f);
                instancePath.cubicTo(84.07402f, 127.54274f, 89.139336f, 127.54379f, 92.26331f, 124.41937f);
                instancePath.lineTo(139.88225f, 76.82022f);
                instancePath.lineTo(131.38203f, 68.32f);
                instancePath.lineTo(86.5875f, 113.11453f);
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
