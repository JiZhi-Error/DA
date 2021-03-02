package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class qqmail_attach_icon_pressed extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                instancePaint3.setColor(-10653805);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 0.70710677f, -0.70710677f, 48.0f, 0.70710677f, 0.70710677f, -19.882248f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(62.0f, 28.517904f);
                instancePath.lineTo(62.0f, 66.0f);
                instancePath.lineTo(67.0f, 66.0f);
                instancePath.lineTo(67.0f, 28.517904f);
                instancePath.cubicTo(66.99998f, 28.51194f, 67.0f, 28.505972f, 67.0f, 28.5f);
                instancePath.cubicTo(67.0f, 27.119287f, 65.880714f, 26.0f, 64.5f, 26.0f);
                instancePath.cubicTo(63.11929f, 26.0f, 62.0f, 27.119287f, 62.0f, 28.5f);
                instancePath.cubicTo(62.0f, 28.505972f, 62.00002f, 28.51194f, 62.00006f, 28.517904f);
                instancePath.close();
                instancePath.moveTo(40.0f, 39.482143f);
                instancePath.lineTo(40.0f, 66.0f);
                instancePath.lineTo(45.0f, 66.0f);
                instancePath.lineTo(45.0f, 39.482143f);
                instancePath.cubicTo(44.990337f, 38.10965f, 43.874756f, 37.0f, 42.5f, 37.0f);
                instancePath.cubicTo(41.125244f, 37.0f, 40.009663f, 38.10965f, 40.00006f, 39.482143f);
                instancePath.lineTo(40.0f, 39.482143f);
                instancePath.close();
                instancePath.moveTo(55.99748f, 24.0f);
                instancePath.cubicTo(55.857f, 16.7968f, 49.867767f, 11.0f, 42.5f, 11.0f);
                instancePath.cubicTo(35.132233f, 11.0f, 29.143f, 16.7968f, 29.002523f, 24.0f);
                instancePath.lineTo(34.01446f, 24.0f);
                instancePath.cubicTo(34.27327f, 19.538311f, 37.973427f, 16.0f, 42.5f, 16.0f);
                instancePath.cubicTo(47.026573f, 16.0f, 50.72673f, 19.538311f, 50.98554f, 24.0f);
                instancePath.lineTo(55.99748f, 24.0f);
                instancePath.lineTo(55.99748f, 24.0f);
                instancePath.close();
                instancePath.moveTo(67.0f, 66.0f);
                instancePath.cubicTo(67.0f, 76.49341f, 58.493412f, 85.0f, 48.0f, 85.0f);
                instancePath.cubicTo(37.506588f, 85.0f, 29.0f, 76.49341f, 29.0f, 66.0f);
                instancePath.lineTo(34.0f, 66.0f);
                instancePath.cubicTo(34.0f, 73.73199f, 40.268013f, 80.0f, 48.0f, 80.0f);
                instancePath.cubicTo(55.731987f, 80.0f, 62.0f, 73.73199f, 62.0f, 66.0f);
                instancePath.lineTo(67.0f, 66.0f);
                instancePath.lineTo(67.0f, 66.0f);
                instancePath.close();
                instancePath.moveTo(56.0f, 66.0f);
                instancePath.cubicTo(56.0f, 70.41828f, 52.418278f, 74.0f, 48.0f, 74.0f);
                instancePath.cubicTo(43.581722f, 74.0f, 40.0f, 70.41828f, 40.0f, 66.0f);
                instancePath.lineTo(45.0f, 66.0f);
                instancePath.cubicTo(45.0f, 67.65685f, 46.343147f, 69.0f, 48.0f, 69.0f);
                instancePath.cubicTo(49.656853f, 69.0f, 51.0f, 67.65685f, 51.0f, 66.0f);
                instancePath.lineTo(56.0f, 66.0f);
                instancePath.lineTo(56.0f, 66.0f);
                instancePath.close();
                instancePath.moveTo(29.0f, 24.0f);
                instancePath.lineTo(34.0f, 24.0f);
                instancePath.lineTo(34.0f, 66.0f);
                instancePath.lineTo(29.0f, 66.0f);
                instancePath.lineTo(29.0f, 24.0f);
                instancePath.close();
                instancePath.moveTo(51.0f, 24.0f);
                instancePath.lineTo(56.0f, 24.0f);
                instancePath.lineTo(56.0f, 66.0f);
                instancePath.lineTo(51.0f, 66.0f);
                instancePath.lineTo(51.0f, 24.0f);
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
