package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class multitask_bar_more_btn extends c {
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
                instancePaint3.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(72.0f, 144.0f);
                instancePath.cubicTo(32.235497f, 144.0f, 0.0f, 111.7645f, 0.0f, 72.0f);
                instancePath.cubicTo(0.0f, 32.235497f, 32.235497f, 0.0f, 72.0f, 0.0f);
                instancePath.cubicTo(111.7645f, 0.0f, 144.0f, 32.235497f, 144.0f, 72.0f);
                instancePath.cubicTo(144.0f, 111.7645f, 111.7645f, 144.0f, 72.0f, 144.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-5066062);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(42.5f, 80.0f);
                instancePath2.cubicTo(38.357864f, 80.0f, 35.0f, 76.642136f, 35.0f, 72.5f);
                instancePath2.cubicTo(35.0f, 68.357864f, 38.357864f, 65.0f, 42.5f, 65.0f);
                instancePath2.cubicTo(46.642136f, 65.0f, 50.0f, 68.357864f, 50.0f, 72.5f);
                instancePath2.cubicTo(50.0f, 76.642136f, 46.642136f, 80.0f, 42.5f, 80.0f);
                instancePath2.close();
                instancePath2.moveTo(72.5f, 80.0f);
                instancePath2.cubicTo(68.357864f, 80.0f, 65.0f, 76.642136f, 65.0f, 72.5f);
                instancePath2.cubicTo(65.0f, 68.357864f, 68.357864f, 65.0f, 72.5f, 65.0f);
                instancePath2.cubicTo(76.642136f, 65.0f, 80.0f, 68.357864f, 80.0f, 72.5f);
                instancePath2.cubicTo(80.0f, 76.642136f, 76.642136f, 80.0f, 72.5f, 80.0f);
                instancePath2.close();
                instancePath2.moveTo(102.5f, 80.0f);
                instancePath2.cubicTo(98.357864f, 80.0f, 95.0f, 76.642136f, 95.0f, 72.5f);
                instancePath2.cubicTo(95.0f, 68.357864f, 98.357864f, 65.0f, 102.5f, 65.0f);
                instancePath2.cubicTo(106.642136f, 65.0f, 110.0f, 68.357864f, 110.0f, 72.5f);
                instancePath2.cubicTo(110.0f, 76.642136f, 106.642136f, 80.0f, 102.5f, 80.0f);
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
