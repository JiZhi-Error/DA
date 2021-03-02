package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_refresh extends c {
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(52.970562f, 22.029438f);
                instancePath.cubicTo(57.31371f, 26.372583f, 60.0f, 32.37258f, 60.0f, 39.0f);
                instancePath.cubicTo(60.0f, 52.254833f, 49.254833f, 63.0f, 36.0f, 63.0f);
                instancePath.cubicTo(22.745167f, 63.0f, 12.0f, 52.254833f, 12.0f, 39.0f);
                instancePath.cubicTo(12.0f, 25.745167f, 22.745167f, 15.0f, 36.0f, 15.0f);
                instancePath.lineTo(36.0f, 21.0f);
                instancePath.cubicTo(26.058874f, 21.0f, 18.0f, 29.058874f, 18.0f, 39.0f);
                instancePath.cubicTo(18.0f, 48.941124f, 26.058874f, 57.0f, 36.0f, 57.0f);
                instancePath.cubicTo(45.941124f, 57.0f, 54.0f, 48.941124f, 54.0f, 39.0f);
                instancePath.cubicTo(54.0f, 34.155792f, 52.085682f, 29.629839f, 48.72792f, 26.272078f);
                instancePath.lineTo(52.970562f, 22.029438f);
                instancePath.close();
                instancePath.moveTo(31.63806f, 15.395418f);
                instancePath.lineTo(26.485281f, 10.2426405f);
                instancePath.lineTo(30.727922f, 6.0f);
                instancePath.lineTo(42.395184f, 17.667261f);
                instancePath.cubicTo(42.980972f, 18.253048f, 42.980972f, 19.202795f, 42.395184f, 19.788582f);
                instancePath.lineTo(30.727922f, 31.455845f);
                instancePath.lineTo(26.485281f, 27.213203f);
                instancePath.lineTo(32.322514f, 21.375973f);
                instancePath.cubicTo(24.145084f, 23.07356f, 18.0f, 30.319149f, 18.0f, 39.0f);
                instancePath.cubicTo(18.0f, 48.941124f, 26.058874f, 57.0f, 36.0f, 57.0f);
                instancePath.cubicTo(45.941124f, 57.0f, 54.0f, 48.941124f, 54.0f, 39.0f);
                instancePath.cubicTo(54.0f, 34.155792f, 52.085682f, 29.629839f, 48.72792f, 26.272078f);
                instancePath.lineTo(52.970562f, 22.029438f);
                instancePath.cubicTo(57.31371f, 26.372583f, 60.0f, 32.37258f, 60.0f, 39.0f);
                instancePath.cubicTo(60.0f, 52.254833f, 49.254833f, 63.0f, 36.0f, 63.0f);
                instancePath.cubicTo(22.745167f, 63.0f, 12.0f, 52.254833f, 12.0f, 39.0f);
                instancePath.cubicTo(12.0f, 27.234737f, 20.465796f, 17.446768f, 31.63806f, 15.395418f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
