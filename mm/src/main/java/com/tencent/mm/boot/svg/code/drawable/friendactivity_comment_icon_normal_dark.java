package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class friendactivity_comment_icon_normal_dark extends c {
    private final int height = 60;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 60;
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
                instancePaint3.setColor(-13882324);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 12.0f);
                instancePath.cubicTo(0.0f, 5.3725824f, 5.3725824f, 0.0f, 12.0f, 0.0f);
                instancePath.lineTo(84.0f, 0.0f);
                instancePath.cubicTo(90.62742f, 0.0f, 96.0f, 5.3725824f, 96.0f, 12.0f);
                instancePath.lineTo(96.0f, 48.0f);
                instancePath.cubicTo(96.0f, 54.62742f, 90.62742f, 60.0f, 84.0f, 60.0f);
                instancePath.lineTo(12.0f, 60.0f);
                instancePath.cubicTo(5.3725824f, 60.0f, 0.0f, 54.62742f, 0.0f, 48.0f);
                instancePath.lineTo(0.0f, 12.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-10521442);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(36.0f, 24.0f);
                instancePath2.cubicTo(39.31371f, 24.0f, 42.0f, 26.68629f, 42.0f, 30.0f);
                instancePath2.cubicTo(42.0f, 33.31371f, 39.31371f, 36.0f, 36.0f, 36.0f);
                instancePath2.cubicTo(32.68629f, 36.0f, 30.0f, 33.31371f, 30.0f, 30.0f);
                instancePath2.cubicTo(30.0f, 26.68629f, 32.68629f, 24.0f, 36.0f, 24.0f);
                instancePath2.close();
                instancePath2.moveTo(60.0f, 24.0f);
                instancePath2.cubicTo(63.31371f, 24.0f, 66.0f, 26.68629f, 66.0f, 30.0f);
                instancePath2.cubicTo(66.0f, 33.31371f, 63.31371f, 36.0f, 60.0f, 36.0f);
                instancePath2.cubicTo(56.68629f, 36.0f, 54.0f, 33.31371f, 54.0f, 30.0f);
                instancePath2.cubicTo(54.0f, 26.68629f, 56.68629f, 24.0f, 60.0f, 24.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
