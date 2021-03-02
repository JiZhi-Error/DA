package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class photo_edit_mark extends c {
    private final int height = 44;
    private final int width = 54;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 54;
            case 1:
                return 44;
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
                instancePaint3.setColor(-1);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 0.5f, 0.0f, 1.0f, 0.5f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.5f, 0.5f);
                instancePath.lineTo(46.5f, 0.5f);
                instancePath.lineTo(46.5f, 36.5f);
                instancePath.lineTo(0.5f, 36.5f);
                instancePath.lineTo(0.5f, 0.5f);
                instancePath.close();
                instancePath.moveTo(42.5f, 2.5f);
                instancePath.lineTo(42.5f, 32.5f);
                instancePath.lineTo(3.5f, 32.5f);
                instancePath.lineTo(3.5f, 2.5f);
                instancePath.lineTo(42.5f, 2.5f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(51.0f, 42.5f);
                instancePath2.lineTo(52.5f, 42.5f);
                instancePath2.lineTo(52.5f, 7.5f);
                instancePath2.lineTo(49.5f, 7.5f);
                instancePath2.lineTo(49.5f, 39.5f);
                instancePath2.lineTo(5.5f, 39.5f);
                instancePath2.lineTo(5.5f, 42.5f);
                instancePath2.lineTo(51.0f, 42.5f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(36.170597f, 14.009804f);
                instancePath3.lineTo(28.390347f, 19.793558f);
                instancePath3.lineTo(15.891026f, 9.5f);
                instancePath3.lineTo(0.5576923f, 22.578432f);
                instancePath3.lineTo(0.5576923f, 32.5f);
                instancePath3.lineTo(46.557693f, 32.5f);
                instancePath3.lineTo(46.557693f, 22.578432f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
