package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class multitask_indicator_icon extends c {
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
                instancePaint3.setColor(-1);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(49.5f, 30.0f);
                instancePath.cubicTo(52.81371f, 30.0f, 55.5f, 32.68629f, 55.5f, 36.0f);
                instancePath.cubicTo(55.5f, 39.31371f, 52.81371f, 42.0f, 49.5f, 42.0f);
                instancePath.cubicTo(46.18629f, 42.0f, 43.5f, 39.31371f, 43.5f, 36.0f);
                instancePath.cubicTo(43.5f, 32.68629f, 46.18629f, 30.0f, 49.5f, 30.0f);
                instancePath.close();
                instancePath.moveTo(22.5f, 30.0f);
                instancePath.cubicTo(25.81371f, 30.0f, 28.5f, 32.68629f, 28.5f, 36.0f);
                instancePath.cubicTo(28.5f, 39.31371f, 25.81371f, 42.0f, 22.5f, 42.0f);
                instancePath.cubicTo(19.18629f, 42.0f, 16.5f, 39.31371f, 16.5f, 36.0f);
                instancePath.cubicTo(16.5f, 32.68629f, 19.18629f, 30.0f, 22.5f, 30.0f);
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
