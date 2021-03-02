package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_camera extends c {
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
                instancePath.moveTo(43.073338f, 15.6f);
                instancePath.lineTo(28.926662f, 15.6f);
                instancePath.lineTo(22.926662f, 24.6f);
                instancePath.lineTo(9.6f, 24.6f);
                instancePath.lineTo(9.6f, 56.4f);
                instancePath.lineTo(62.4f, 56.4f);
                instancePath.lineTo(62.4f, 24.6f);
                instancePath.lineTo(49.073338f, 24.6f);
                instancePath.lineTo(43.073338f, 15.6f);
                instancePath.close();
                instancePath.moveTo(44.197224f, 12.0f);
                instancePath.cubicTo(44.698753f, 12.0f, 45.167103f, 12.250651f, 45.4453f, 12.66795f);
                instancePath.lineTo(51.0f, 21.0f);
                instancePath.lineTo(63.0f, 21.0f);
                instancePath.cubicTo(64.65685f, 21.0f, 66.0f, 22.343145f, 66.0f, 24.0f);
                instancePath.lineTo(66.0f, 57.0f);
                instancePath.cubicTo(66.0f, 58.656853f, 64.65685f, 60.0f, 63.0f, 60.0f);
                instancePath.lineTo(9.0f, 60.0f);
                instancePath.cubicTo(7.343146f, 60.0f, 6.0f, 58.656853f, 6.0f, 57.0f);
                instancePath.lineTo(6.0f, 24.0f);
                instancePath.cubicTo(6.0f, 22.343145f, 7.343146f, 21.0f, 9.0f, 21.0f);
                instancePath.lineTo(21.0f, 21.0f);
                instancePath.lineTo(26.5547f, 12.66795f);
                instancePath.cubicTo(26.8329f, 12.250651f, 27.301247f, 12.0f, 27.802776f, 12.0f);
                instancePath.lineTo(44.197224f, 12.0f);
                instancePath.close();
                instancePath.moveTo(36.0f, 47.4f);
                instancePath.cubicTo(40.63919f, 47.4f, 44.4f, 43.63919f, 44.4f, 39.0f);
                instancePath.cubicTo(44.4f, 34.36081f, 40.63919f, 30.6f, 36.0f, 30.6f);
                instancePath.cubicTo(31.360807f, 30.6f, 27.6f, 34.36081f, 27.6f, 39.0f);
                instancePath.cubicTo(27.6f, 43.63919f, 31.360807f, 47.4f, 36.0f, 47.4f);
                instancePath.close();
                instancePath.moveTo(36.0f, 51.0f);
                instancePath.cubicTo(29.372583f, 51.0f, 24.0f, 45.62742f, 24.0f, 39.0f);
                instancePath.cubicTo(24.0f, 32.37258f, 29.372583f, 27.0f, 36.0f, 27.0f);
                instancePath.cubicTo(42.62742f, 27.0f, 48.0f, 32.37258f, 48.0f, 39.0f);
                instancePath.cubicTo(48.0f, 45.62742f, 42.62742f, 51.0f, 36.0f, 51.0f);
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
