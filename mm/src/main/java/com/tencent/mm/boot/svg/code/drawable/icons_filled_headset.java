package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_headset extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(36.0f, 9.0f);
                instancePath.cubicTo(50.91169f, 9.0f, 63.0f, 21.088312f, 63.0f, 36.0f);
                instancePath.lineTo(63.0f, 54.0f);
                instancePath.lineTo(62.997f, 54.0f);
                instancePath.lineTo(63.0f, 57.0f);
                instancePath.cubicTo(63.0f, 60.31371f, 60.31371f, 63.0f, 57.0f, 63.0f);
                instancePath.lineTo(51.0f, 63.0f);
                instancePath.cubicTo(49.343147f, 63.0f, 48.0f, 61.656853f, 48.0f, 60.0f);
                instancePath.lineTo(48.0f, 45.0f);
                instancePath.cubicTo(48.0f, 43.343147f, 49.343147f, 42.0f, 51.0f, 42.0f);
                instancePath.lineTo(57.0f, 42.0f);
                instancePath.lineTo(57.0f, 36.0f);
                instancePath.cubicTo(57.0f, 24.40202f, 47.59798f, 15.0f, 36.0f, 15.0f);
                instancePath.cubicTo(24.40202f, 15.0f, 15.0f, 24.40202f, 15.0f, 36.0f);
                instancePath.lineTo(15.0f, 42.0f);
                instancePath.lineTo(21.0f, 42.0f);
                instancePath.cubicTo(22.656855f, 42.0f, 24.0f, 43.343147f, 24.0f, 45.0f);
                instancePath.lineTo(24.0f, 60.0f);
                instancePath.cubicTo(24.0f, 61.656853f, 22.656855f, 63.0f, 21.0f, 63.0f);
                instancePath.lineTo(15.0f, 63.0f);
                instancePath.cubicTo(11.686292f, 63.0f, 9.0f, 60.31371f, 9.0f, 57.0f);
                instancePath.lineTo(9.0f, 36.0f);
                instancePath.cubicTo(9.0f, 21.088312f, 21.088312f, 9.0f, 36.0f, 9.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
