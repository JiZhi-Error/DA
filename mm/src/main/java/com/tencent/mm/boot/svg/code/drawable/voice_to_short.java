package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class voice_to_short extends c {
    private final int height = 80;
    private final int width = 80;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 80;
            case 1:
                return 80;
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
                instancePath.moveTo(40.0f, 73.333336f);
                instancePath.cubicTo(21.590508f, 73.333336f, 6.6666665f, 58.409492f, 6.6666665f, 40.0f);
                instancePath.cubicTo(6.6666665f, 21.590508f, 21.590508f, 6.6666665f, 40.0f, 6.6666665f);
                instancePath.cubicTo(58.409492f, 6.6666665f, 73.333336f, 21.590508f, 73.333336f, 40.0f);
                instancePath.cubicTo(73.333336f, 58.409492f, 58.409492f, 73.333336f, 40.0f, 73.333336f);
                instancePath.close();
                instancePath.moveTo(37.45573f, 20.452475f);
                instancePath.lineTo(37.820312f, 45.77474f);
                instancePath.lineTo(42.172527f, 45.77474f);
                instancePath.lineTo(42.53711f, 20.452475f);
                instancePath.lineTo(37.45573f, 20.452475f);
                instancePath.close();
                instancePath.moveTo(39.985027f, 57.008465f);
                instancePath.cubicTo(41.69401f, 57.008465f, 42.99284f, 55.73242f, 42.99284f, 54.06901f);
                instancePath.cubicTo(42.99284f, 52.405598f, 41.69401f, 51.12956f, 39.985027f, 51.12956f);
                instancePath.cubicTo(38.321617f, 51.12956f, 37.0f, 52.405598f, 37.0f, 54.06901f);
                instancePath.cubicTo(37.0f, 55.73242f, 38.321617f, 57.008465f, 39.985027f, 57.008465f);
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
