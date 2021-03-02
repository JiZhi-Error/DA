package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class ip_call_dial_entrance extends c {
    private final int height = 75;
    private final int width = 75;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 75;
            case 1:
                return 75;
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
                instancePaint3.setColor(-15028967);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(37.5f, 45.0f);
                instancePath.cubicTo(41.642136f, 45.0f, 45.0f, 41.642136f, 45.0f, 37.5f);
                instancePath.cubicTo(45.0f, 33.357864f, 41.642136f, 30.0f, 37.5f, 30.0f);
                instancePath.cubicTo(33.357864f, 30.0f, 30.0f, 33.357864f, 30.0f, 37.5f);
                instancePath.cubicTo(30.0f, 41.642136f, 33.357864f, 45.0f, 37.5f, 45.0f);
                instancePath.close();
                instancePath.moveTo(64.5f, 45.0f);
                instancePath.cubicTo(68.642136f, 45.0f, 72.0f, 41.642136f, 72.0f, 37.5f);
                instancePath.cubicTo(72.0f, 33.357864f, 68.642136f, 30.0f, 64.5f, 30.0f);
                instancePath.cubicTo(60.357864f, 30.0f, 57.0f, 33.357864f, 57.0f, 37.5f);
                instancePath.cubicTo(57.0f, 41.642136f, 60.357864f, 45.0f, 64.5f, 45.0f);
                instancePath.close();
                instancePath.moveTo(10.5f, 45.0f);
                instancePath.cubicTo(14.642136f, 45.0f, 18.0f, 41.642136f, 18.0f, 37.5f);
                instancePath.cubicTo(18.0f, 33.357864f, 14.642136f, 30.0f, 10.5f, 30.0f);
                instancePath.cubicTo(6.3578644f, 30.0f, 3.0f, 33.357864f, 3.0f, 37.5f);
                instancePath.cubicTo(3.0f, 41.642136f, 6.3578644f, 45.0f, 10.5f, 45.0f);
                instancePath.close();
                instancePath.moveTo(37.5f, 72.0f);
                instancePath.cubicTo(41.642136f, 72.0f, 45.0f, 68.642136f, 45.0f, 64.5f);
                instancePath.cubicTo(45.0f, 60.357864f, 41.642136f, 57.0f, 37.5f, 57.0f);
                instancePath.cubicTo(33.357864f, 57.0f, 30.0f, 60.357864f, 30.0f, 64.5f);
                instancePath.cubicTo(30.0f, 68.642136f, 33.357864f, 72.0f, 37.5f, 72.0f);
                instancePath.close();
                instancePath.moveTo(64.5f, 72.0f);
                instancePath.cubicTo(68.642136f, 72.0f, 72.0f, 68.642136f, 72.0f, 64.5f);
                instancePath.cubicTo(72.0f, 60.357864f, 68.642136f, 57.0f, 64.5f, 57.0f);
                instancePath.cubicTo(60.357864f, 57.0f, 57.0f, 60.357864f, 57.0f, 64.5f);
                instancePath.cubicTo(57.0f, 68.642136f, 60.357864f, 72.0f, 64.5f, 72.0f);
                instancePath.close();
                instancePath.moveTo(10.5f, 72.0f);
                instancePath.cubicTo(14.642136f, 72.0f, 18.0f, 68.642136f, 18.0f, 64.5f);
                instancePath.cubicTo(18.0f, 60.357864f, 14.642136f, 57.0f, 10.5f, 57.0f);
                instancePath.cubicTo(6.3578644f, 57.0f, 3.0f, 60.357864f, 3.0f, 64.5f);
                instancePath.cubicTo(3.0f, 68.642136f, 6.3578644f, 72.0f, 10.5f, 72.0f);
                instancePath.close();
                instancePath.moveTo(37.5f, 18.0f);
                instancePath.cubicTo(41.642136f, 18.0f, 45.0f, 14.642136f, 45.0f, 10.5f);
                instancePath.cubicTo(45.0f, 6.3578644f, 41.642136f, 3.0f, 37.5f, 3.0f);
                instancePath.cubicTo(33.357864f, 3.0f, 30.0f, 6.3578644f, 30.0f, 10.5f);
                instancePath.cubicTo(30.0f, 14.642136f, 33.357864f, 18.0f, 37.5f, 18.0f);
                instancePath.close();
                instancePath.moveTo(64.5f, 18.0f);
                instancePath.cubicTo(68.642136f, 18.0f, 72.0f, 14.642136f, 72.0f, 10.5f);
                instancePath.cubicTo(72.0f, 6.3578644f, 68.642136f, 3.0f, 64.5f, 3.0f);
                instancePath.cubicTo(60.357864f, 3.0f, 57.0f, 6.3578644f, 57.0f, 10.5f);
                instancePath.cubicTo(57.0f, 14.642136f, 60.357864f, 18.0f, 64.5f, 18.0f);
                instancePath.close();
                instancePath.moveTo(10.5f, 18.0f);
                instancePath.cubicTo(14.642136f, 18.0f, 18.0f, 14.642136f, 18.0f, 10.5f);
                instancePath.cubicTo(18.0f, 6.3578644f, 14.642136f, 3.0f, 10.5f, 3.0f);
                instancePath.cubicTo(6.3578644f, 3.0f, 3.0f, 6.3578644f, 3.0f, 10.5f);
                instancePath.cubicTo(3.0f, 14.642136f, 6.3578644f, 18.0f, 10.5f, 18.0f);
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
