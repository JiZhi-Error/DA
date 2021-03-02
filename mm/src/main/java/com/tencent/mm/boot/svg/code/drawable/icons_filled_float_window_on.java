package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_float_window_on extends c {
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
                instancePath.moveTo(36.0f, 60.0f);
                instancePath.cubicTo(49.254833f, 60.0f, 60.0f, 49.254833f, 60.0f, 36.0f);
                instancePath.cubicTo(60.0f, 22.745167f, 49.254833f, 12.0f, 36.0f, 12.0f);
                instancePath.cubicTo(22.745167f, 12.0f, 12.0f, 22.745167f, 12.0f, 36.0f);
                instancePath.cubicTo(12.0f, 49.254833f, 22.745167f, 60.0f, 36.0f, 60.0f);
                instancePath.close();
                instancePath.moveTo(36.0f, 66.0f);
                instancePath.cubicTo(19.431458f, 66.0f, 6.0f, 52.568542f, 6.0f, 36.0f);
                instancePath.cubicTo(6.0f, 19.431458f, 19.431458f, 6.0f, 36.0f, 6.0f);
                instancePath.cubicTo(52.568542f, 6.0f, 66.0f, 19.431458f, 66.0f, 36.0f);
                instancePath.cubicTo(66.0f, 52.568542f, 52.568542f, 66.0f, 36.0f, 66.0f);
                instancePath.close();
                instancePath.moveTo(36.0f, 48.0f);
                instancePath.cubicTo(42.62742f, 48.0f, 48.0f, 42.62742f, 48.0f, 36.0f);
                instancePath.cubicTo(48.0f, 29.372583f, 42.62742f, 24.0f, 36.0f, 24.0f);
                instancePath.cubicTo(29.372583f, 24.0f, 24.0f, 29.372583f, 24.0f, 36.0f);
                instancePath.cubicTo(24.0f, 42.62742f, 29.372583f, 48.0f, 36.0f, 48.0f);
                instancePath.close();
                instancePath.moveTo(36.0f, 54.0f);
                instancePath.cubicTo(26.058874f, 54.0f, 18.0f, 45.941124f, 18.0f, 36.0f);
                instancePath.cubicTo(18.0f, 26.058874f, 26.058874f, 18.0f, 36.0f, 18.0f);
                instancePath.cubicTo(45.941124f, 18.0f, 54.0f, 26.058874f, 54.0f, 36.0f);
                instancePath.cubicTo(54.0f, 45.941124f, 45.941124f, 54.0f, 36.0f, 54.0f);
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
