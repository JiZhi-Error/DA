package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_qr_code extends c {
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
                instancePath.moveTo(33.0f, 57.0f);
                instancePath.lineTo(39.0f, 57.0f);
                instancePath.lineTo(39.0f, 63.0f);
                instancePath.lineTo(33.0f, 63.0f);
                instancePath.lineTo(33.0f, 57.0f);
                instancePath.close();
                instancePath.moveTo(57.0f, 33.0f);
                instancePath.lineTo(63.0f, 33.0f);
                instancePath.lineTo(63.0f, 39.0f);
                instancePath.lineTo(57.0f, 39.0f);
                instancePath.lineTo(57.0f, 33.0f);
                instancePath.close();
                instancePath.moveTo(33.0f, 45.0f);
                instancePath.lineTo(39.0f, 45.0f);
                instancePath.lineTo(39.0f, 51.0f);
                instancePath.lineTo(33.0f, 51.0f);
                instancePath.lineTo(33.0f, 45.0f);
                instancePath.close();
                instancePath.moveTo(45.0f, 33.0f);
                instancePath.lineTo(51.0f, 33.0f);
                instancePath.lineTo(51.0f, 39.0f);
                instancePath.lineTo(45.0f, 39.0f);
                instancePath.lineTo(45.0f, 33.0f);
                instancePath.close();
                instancePath.moveTo(12.0f, 9.0f);
                instancePath.lineTo(36.0f, 9.0f);
                instancePath.cubicTo(37.656853f, 9.0f, 39.0f, 10.343145f, 39.0f, 12.0f);
                instancePath.lineTo(39.0f, 36.0f);
                instancePath.cubicTo(39.0f, 37.656853f, 37.656853f, 39.0f, 36.0f, 39.0f);
                instancePath.lineTo(12.0f, 39.0f);
                instancePath.cubicTo(10.343145f, 39.0f, 9.0f, 37.656853f, 9.0f, 36.0f);
                instancePath.lineTo(9.0f, 12.0f);
                instancePath.cubicTo(9.0f, 10.343145f, 10.343145f, 9.0f, 12.0f, 9.0f);
                instancePath.close();
                instancePath.moveTo(12.6f, 12.6f);
                instancePath.lineTo(12.6f, 35.4f);
                instancePath.lineTo(35.4f, 35.4f);
                instancePath.lineTo(35.4f, 12.6f);
                instancePath.lineTo(12.6f, 12.6f);
                instancePath.close();
                instancePath.moveTo(21.0f, 21.0f);
                instancePath.lineTo(27.0f, 21.0f);
                instancePath.lineTo(27.0f, 27.0f);
                instancePath.lineTo(21.0f, 27.0f);
                instancePath.lineTo(21.0f, 21.0f);
                instancePath.close();
                instancePath.moveTo(48.0f, 9.0f);
                instancePath.lineTo(60.0f, 9.0f);
                instancePath.cubicTo(61.656853f, 9.0f, 63.0f, 10.343145f, 63.0f, 12.0f);
                instancePath.lineTo(63.0f, 24.0f);
                instancePath.cubicTo(63.0f, 25.656855f, 61.656853f, 27.0f, 60.0f, 27.0f);
                instancePath.lineTo(48.0f, 27.0f);
                instancePath.cubicTo(46.343147f, 27.0f, 45.0f, 25.656855f, 45.0f, 24.0f);
                instancePath.lineTo(45.0f, 12.0f);
                instancePath.cubicTo(45.0f, 10.343145f, 46.343147f, 9.0f, 48.0f, 9.0f);
                instancePath.close();
                instancePath.moveTo(48.6f, 23.4f);
                instancePath.lineTo(59.4f, 23.4f);
                instancePath.lineTo(59.4f, 12.6f);
                instancePath.lineTo(48.6f, 12.6f);
                instancePath.lineTo(48.6f, 23.4f);
                instancePath.close();
                instancePath.moveTo(48.0f, 45.0f);
                instancePath.lineTo(60.0f, 45.0f);
                instancePath.cubicTo(61.656853f, 45.0f, 63.0f, 46.343147f, 63.0f, 48.0f);
                instancePath.lineTo(63.0f, 60.0f);
                instancePath.cubicTo(63.0f, 61.656853f, 61.656853f, 63.0f, 60.0f, 63.0f);
                instancePath.lineTo(48.0f, 63.0f);
                instancePath.cubicTo(46.343147f, 63.0f, 45.0f, 61.656853f, 45.0f, 60.0f);
                instancePath.lineTo(45.0f, 48.0f);
                instancePath.cubicTo(45.0f, 46.343147f, 46.343147f, 45.0f, 48.0f, 45.0f);
                instancePath.close();
                instancePath.moveTo(48.6f, 59.4f);
                instancePath.lineTo(59.4f, 59.4f);
                instancePath.lineTo(59.4f, 48.6f);
                instancePath.lineTo(48.6f, 48.6f);
                instancePath.lineTo(48.6f, 59.4f);
                instancePath.close();
                instancePath.moveTo(12.0f, 45.0f);
                instancePath.lineTo(24.0f, 45.0f);
                instancePath.cubicTo(25.656855f, 45.0f, 27.0f, 46.343147f, 27.0f, 48.0f);
                instancePath.lineTo(27.0f, 60.0f);
                instancePath.cubicTo(27.0f, 61.656853f, 25.656855f, 63.0f, 24.0f, 63.0f);
                instancePath.lineTo(12.0f, 63.0f);
                instancePath.cubicTo(10.343145f, 63.0f, 9.0f, 61.656853f, 9.0f, 60.0f);
                instancePath.lineTo(9.0f, 48.0f);
                instancePath.cubicTo(9.0f, 46.343147f, 10.343145f, 45.0f, 12.0f, 45.0f);
                instancePath.close();
                instancePath.moveTo(12.6f, 59.4f);
                instancePath.lineTo(23.4f, 59.4f);
                instancePath.lineTo(23.4f, 48.6f);
                instancePath.lineTo(12.6f, 48.6f);
                instancePath.lineTo(12.6f, 59.4f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
