package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class menu_close_wechat extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                instancePaint3.setColor(-8617851);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(36.0f, 14.048469f);
                instancePath.lineTo(36.0f, 22.694517f);
                instancePath.cubicTo(26.54021f, 27.188381f, 20.0f, 36.830418f, 20.0f, 48.0f);
                instancePath.cubicTo(20.0f, 63.463974f, 32.536026f, 76.0f, 48.0f, 76.0f);
                instancePath.cubicTo(63.463974f, 76.0f, 76.0f, 63.463974f, 76.0f, 48.0f);
                instancePath.cubicTo(76.0f, 36.830418f, 69.45979f, 27.188381f, 60.0f, 22.694525f);
                instancePath.lineTo(60.0f, 14.048469f);
                instancePath.cubicTo(73.98231f, 18.990505f, 84.0f, 32.325375f, 84.0f, 48.0f);
                instancePath.cubicTo(84.0f, 67.88225f, 67.88225f, 84.0f, 48.0f, 84.0f);
                instancePath.cubicTo(28.117748f, 84.0f, 12.0f, 67.88225f, 12.0f, 48.0f);
                instancePath.cubicTo(12.0f, 32.325375f, 22.01769f, 18.990505f, 36.0f, 14.048469f);
                instancePath.close();
                instancePath.moveTo(44.0f, 6.0f);
                instancePath.lineTo(52.0f, 6.0f);
                instancePath.lineTo(52.0f, 48.0f);
                instancePath.lineTo(44.0f, 48.0f);
                instancePath.lineTo(44.0f, 6.0f);
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
