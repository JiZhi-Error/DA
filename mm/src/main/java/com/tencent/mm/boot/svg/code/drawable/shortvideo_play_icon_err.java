package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class shortvideo_play_icon_err extends c {
    private final int height = 120;
    private final int width = 120;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 120;
            case 1:
                return 120;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix instanceMatrix = c.instanceMatrix(looper);
                float[] instanceMatrixArray = c.instanceMatrixArray(looper);
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.6666666f, 0.0f, 0.0f, 0.0f, 1.6666666f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                c.instancePaint(instancePaint2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(637534208);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(36.0f, 0.0f);
                instancePath.cubicTo(55.88225f, 0.0f, 72.0f, 16.117748f, 72.0f, 36.0f);
                instancePath.cubicTo(72.0f, 55.88225f, 55.88225f, 72.0f, 36.0f, 72.0f);
                instancePath.cubicTo(16.117748f, 72.0f, 0.0f, 55.88225f, 0.0f, 36.0f);
                instancePath.cubicTo(0.0f, 16.117748f, 16.117748f, 0.0f, 36.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(36.0f, 0.0f);
                instancePath2.cubicTo(55.88225f, 0.0f, 72.0f, 16.117748f, 72.0f, 36.0f);
                instancePath2.cubicTo(72.0f, 55.88225f, 55.88225f, 72.0f, 36.0f, 72.0f);
                instancePath2.cubicTo(16.117748f, 72.0f, 0.0f, 55.88225f, 0.0f, 36.0f);
                instancePath2.cubicTo(0.0f, 16.117748f, 16.117748f, 0.0f, 36.0f, 0.0f);
                instancePath2.close();
                instancePath2.moveTo(36.0f, 2.16f);
                instancePath2.cubicTo(17.310684f, 2.16f, 2.16f, 17.310684f, 2.16f, 36.0f);
                instancePath2.cubicTo(2.16f, 54.689316f, 17.310684f, 69.84f, 36.0f, 69.84f);
                instancePath2.cubicTo(54.689316f, 69.84f, 69.84f, 54.689316f, 69.84f, 36.0f);
                instancePath2.cubicTo(69.84f, 17.310684f, 54.689316f, 2.16f, 36.0f, 2.16f);
                instancePath2.close();
                instancePath2.moveTo(35.98428f, 47.686035f);
                instancePath2.cubicTo(37.778713f, 47.686035f, 39.142483f, 49.02588f, 39.142483f, 50.77246f);
                instancePath2.cubicTo(39.142483f, 52.519043f, 37.778713f, 53.858887f, 35.98428f, 53.858887f);
                instancePath2.cubicTo(34.237698f, 53.858887f, 32.850002f, 52.519043f, 32.850002f, 50.77246f);
                instancePath2.cubicTo(32.850002f, 49.02588f, 34.237698f, 47.686035f, 35.98428f, 47.686035f);
                instancePath2.close();
                instancePath2.moveTo(38.663967f, 15.475098f);
                instancePath2.lineTo(38.281155f, 42.063477f);
                instancePath2.lineTo(33.71133f, 42.063477f);
                instancePath2.lineTo(33.328518f, 15.475098f);
                instancePath2.lineTo(38.663967f, 15.475098f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
