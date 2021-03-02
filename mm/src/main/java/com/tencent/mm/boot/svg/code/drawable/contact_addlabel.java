package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class contact_addlabel extends c {
    private final int height = 60;
    private final int width = 60;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-12206054);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(28.32f, 0.0f);
                instancePath.lineTo(31.73f, 0.0f);
                instancePath.cubicTo(46.52f, 0.66f, 59.35f, 13.49f, 60.0f, 28.28f);
                instancePath.lineTo(60.0f, 31.52f);
                instancePath.cubicTo(59.48f, 46.57f, 46.27f, 59.66f, 31.21f, 60.0f);
                instancePath.lineTo(28.74f, 60.0f);
                instancePath.cubicTo(13.88f, 59.63f, 0.87f, 46.88f, 0.0f, 32.07f);
                instancePath.lineTo(0.0f, 28.48f);
                instancePath.cubicTo(0.53f, 13.59f, 13.45f, 0.64f, 28.32f, 0.0f);
                instancePath.lineTo(28.32f, 0.0f);
                instancePath.close();
                instancePath.moveTo(28.0f, 12.0f);
                instancePath.lineTo(28.0f, 28.0f);
                instancePath.lineTo(12.0f, 28.0f);
                instancePath.lineTo(12.0f, 32.0f);
                instancePath.lineTo(28.0f, 32.0f);
                instancePath.lineTo(28.0f, 48.0f);
                instancePath.lineTo(32.0f, 48.0f);
                instancePath.lineTo(32.0f, 32.0f);
                instancePath.lineTo(48.0f, 32.0f);
                instancePath.lineTo(48.0f, 28.0f);
                instancePath.lineTo(32.0f, 28.0f);
                instancePath.lineTo(32.0f, 12.0f);
                instancePath.lineTo(28.0f, 12.0f);
                instancePath.lineTo(28.0f, 12.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint5, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(16.0f, 0.0f);
                instancePath2.lineTo(20.0f, 0.0f);
                instancePath2.lineTo(20.0f, 16.0f);
                instancePath2.lineTo(36.0f, 16.0f);
                instancePath2.lineTo(36.0f, 20.0f);
                instancePath2.lineTo(20.0f, 20.0f);
                instancePath2.lineTo(20.0f, 36.0f);
                instancePath2.lineTo(16.0f, 36.0f);
                instancePath2.lineTo(16.0f, 20.0f);
                instancePath2.lineTo(0.0f, 20.0f);
                instancePath2.lineTo(0.0f, 16.0f);
                instancePath2.lineTo(16.0f, 16.0f);
                instancePath2.lineTo(16.0f, 0.0f);
                instancePath2.lineTo(16.0f, 0.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
