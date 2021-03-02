package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_display_mobile extends c {
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
                instancePath.moveTo(66.0f, 30.0f);
                instancePath.lineTo(69.0f, 30.0f);
                instancePath.cubicTo(70.65685f, 30.0f, 72.0f, 31.343145f, 72.0f, 33.0f);
                instancePath.lineTo(72.0f, 63.0f);
                instancePath.cubicTo(72.0f, 64.65685f, 70.65685f, 66.0f, 69.0f, 66.0f);
                instancePath.lineTo(51.0f, 66.0f);
                instancePath.cubicTo(49.343147f, 66.0f, 48.0f, 64.65685f, 48.0f, 63.0f);
                instancePath.lineTo(48.0f, 57.0f);
                instancePath.lineTo(9.0f, 57.0f);
                instancePath.cubicTo(7.343146f, 57.0f, 6.0f, 55.656853f, 6.0f, 54.0f);
                instancePath.lineTo(6.0f, 15.0f);
                instancePath.cubicTo(6.0f, 13.343145f, 7.343146f, 12.0f, 9.0f, 12.0f);
                instancePath.lineTo(63.0f, 12.0f);
                instancePath.cubicTo(64.65685f, 12.0f, 66.0f, 13.343145f, 66.0f, 15.0f);
                instancePath.lineTo(66.0f, 30.0f);
                instancePath.close();
                instancePath.moveTo(62.4f, 30.0f);
                instancePath.lineTo(62.4f, 15.6f);
                instancePath.lineTo(9.6f, 15.6f);
                instancePath.lineTo(9.6f, 53.4f);
                instancePath.lineTo(48.0f, 53.4f);
                instancePath.lineTo(48.0f, 33.0f);
                instancePath.cubicTo(48.0f, 31.343145f, 49.343147f, 30.0f, 51.0f, 30.0f);
                instancePath.lineTo(62.4f, 30.0f);
                instancePath.close();
                instancePath.moveTo(24.0f, 62.699997f);
                instancePath.cubicTo(24.0f, 61.705887f, 24.797583f, 60.899998f, 25.79045f, 60.899998f);
                instancePath.lineTo(43.209553f, 60.899998f);
                instancePath.cubicTo(44.198387f, 60.899998f, 45.0f, 61.698956f, 45.0f, 62.699997f);
                instancePath.lineTo(45.0f, 64.5f);
                instancePath.lineTo(24.0f, 64.5f);
                instancePath.lineTo(24.0f, 62.699997f);
                instancePath.close();
                instancePath.moveTo(51.6f, 33.6f);
                instancePath.lineTo(51.6f, 62.4f);
                instancePath.lineTo(68.4f, 62.4f);
                instancePath.lineTo(68.4f, 33.6f);
                instancePath.lineTo(51.6f, 33.6f);
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
