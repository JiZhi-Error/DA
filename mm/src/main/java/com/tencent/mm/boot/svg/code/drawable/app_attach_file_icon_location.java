package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_attach_file_icon_location extends c {
    private final int height = 90;
    private final int width = 90;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                c.instancePaint(instancePaint2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-855310);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(90.0f, 0.0f);
                instancePath.lineTo(90.0f, 90.0f);
                instancePath.lineTo(0.0f, 90.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 30.0f, 0.0f, 1.0f, 24.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.saveLayerAlpha(null, 153, 31);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(29.25f, 16.59649f);
                instancePath2.cubicTo(29.25f, 9.496691f, 23.53672f, 3.75f, 16.5f, 3.75f);
                instancePath2.cubicTo(9.46328f, 3.75f, 3.75f, 9.496691f, 3.75f, 16.59649f);
                instancePath2.cubicTo(3.75f, 23.03143f, 7.8978143f, 30.246017f, 16.5f, 38.14612f);
                instancePath2.cubicTo(25.102188f, 30.246014f, 29.25f, 23.031427f, 29.25f, 16.59649f);
                instancePath2.close();
                instancePath2.moveTo(17.825495f, 41.99967f);
                instancePath2.cubicTo(17.068739f, 42.66942f, 15.931266f, 42.66942f, 15.174507f, 41.999672f);
                instancePath2.cubicTo(5.058169f, 33.046417f, 0.0f, 24.578691f, 0.0f, 16.59649f);
                instancePath2.cubicTo(4.3587476E-16f, 7.4305024f, 7.3873014f, 0.0f, 16.5f, 0.0f);
                instancePath2.cubicTo(25.612698f, 0.0f, 33.0f, 7.4305024f, 33.0f, 16.59649f);
                instancePath2.cubicTo(33.0f, 24.57869f, 27.941832f, 33.046417f, 17.825495f, 41.99967f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(16.5f, 19.614035f);
                instancePath3.cubicTo(18.156855f, 19.614035f, 19.5f, 18.263035f, 19.5f, 16.59649f);
                instancePath3.cubicTo(19.5f, 14.929948f, 18.156855f, 13.578947f, 16.5f, 13.578947f);
                instancePath3.cubicTo(14.843145f, 13.578947f, 13.5f, 14.929948f, 13.5f, 16.59649f);
                instancePath3.cubicTo(13.5f, 18.263035f, 14.843145f, 19.614035f, 16.5f, 19.614035f);
                instancePath3.close();
                instancePath3.moveTo(16.5f, 23.364035f);
                instancePath3.cubicTo(12.767167f, 23.364035f, 9.75f, 20.329224f, 9.75f, 16.59649f);
                instancePath3.cubicTo(9.75f, 12.863759f, 12.767167f, 9.828947f, 16.5f, 9.828947f);
                instancePath3.cubicTo(20.232832f, 9.828947f, 23.25f, 12.863759f, 23.25f, 16.59649f);
                instancePath3.cubicTo(23.25f, 20.329224f, 20.232832f, 23.364035f, 16.5f, 23.364035f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
