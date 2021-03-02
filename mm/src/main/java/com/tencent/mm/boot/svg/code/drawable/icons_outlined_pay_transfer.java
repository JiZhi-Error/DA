package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_pay_transfer extends c {
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 15.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(46.5f, 25.5f);
                instancePath.cubicTo(47.328426f, 25.5f, 48.0f, 26.171574f, 48.0f, 27.0f);
                instancePath.cubicTo(48.0f, 27.43211f, 47.813652f, 27.84323f, 47.488693f, 28.128046f);
                instancePath.lineTo(32.69047f, 41.098175f);
                instancePath.cubicTo(32.19207f, 41.535007f, 31.433912f, 41.485096f, 30.99708f, 40.986694f);
                instancePath.cubicTo(30.636261f, 40.57502f, 30.599783f, 39.971336f, 30.908403f, 39.51921f);
                instancePath.lineTo(37.406178f, 30.0f);
                instancePath.lineTo(-0.003277817f, 30.0f);
                instancePath.lineTo(-0.003277817f, 25.5f);
                instancePath.lineTo(46.5f, 25.5f);
                instancePath.close();
                instancePath.moveTo(16.999641f, 1.0133055f);
                instancePath.cubicTo(17.36046f, 1.4249806f, 17.39694f, 2.028662f, 17.08832f, 2.4807901f);
                instancePath.lineTo(10.590546f, 12.0f);
                instancePath.lineTo(48.0f, 12.0f);
                instancePath.lineTo(48.0f, 16.5f);
                instancePath.lineTo(1.4967222f, 16.5f);
                instancePath.cubicTo(0.6682951f, 16.5f, -0.003277817f, 15.828427f, -0.003277817f, 15.0f);
                instancePath.cubicTo(-0.003277817f, 14.56789f, 0.18306966f, 14.156771f, 0.5080293f, 13.871955f);
                instancePath.lineTo(15.306251f, 0.9018236f);
                instancePath.cubicTo(15.804652f, 0.4649916f, 16.562809f, 0.5149038f, 16.999641f, 1.0133055f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
