package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_open extends c {
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
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(72.0f, 0.0f);
                instancePath.lineTo(72.0f, 72.0f);
                instancePath.lineTo(0.0f, 72.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-436207616);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(60.0f, 9.0f);
                instancePath2.cubicTo(61.656853f, 9.0f, 63.0f, 10.343145f, 63.0f, 12.0f);
                instancePath2.lineTo(63.0f, 60.0f);
                instancePath2.cubicTo(63.0f, 61.656853f, 61.656853f, 63.0f, 60.0f, 63.0f);
                instancePath2.lineTo(12.0f, 63.0f);
                instancePath2.cubicTo(10.343145f, 63.0f, 9.0f, 61.656853f, 9.0f, 60.0f);
                instancePath2.lineTo(9.0f, 12.0f);
                instancePath2.cubicTo(9.0f, 10.343145f, 10.343145f, 9.0f, 12.0f, 9.0f);
                instancePath2.lineTo(60.0f, 9.0f);
                instancePath2.close();
                instancePath2.moveTo(59.4f, 12.6f);
                instancePath2.lineTo(12.6f, 12.6f);
                instancePath2.lineTo(12.6f, 59.4f);
                instancePath2.lineTo(59.4f, 59.4f);
                instancePath2.lineTo(59.4f, 12.6f);
                instancePath2.close();
                instancePath2.moveTo(36.0f, 27.0f);
                instancePath2.cubicTo(40.970562f, 27.0f, 45.0f, 31.029438f, 45.0f, 36.0f);
                instancePath2.cubicTo(45.0f, 40.970562f, 40.970562f, 45.0f, 36.0f, 45.0f);
                instancePath2.cubicTo(31.029438f, 45.0f, 27.0f, 40.970562f, 27.0f, 36.0f);
                instancePath2.cubicTo(27.0f, 31.029438f, 31.029438f, 27.0f, 36.0f, 27.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
