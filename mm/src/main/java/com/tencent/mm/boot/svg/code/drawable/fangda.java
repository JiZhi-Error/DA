package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fangda extends c {
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
                instancePaint3.setColor(-855638017);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 17.0f, 0.0f, 1.0f, 15.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, -6.123234E-17f, 1.0f, -23.840988f, 1.0f, 6.123234E-17f, 23.840988f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(15.25f, 24.75f);
                instancePath.lineTo(15.25f, 39.0f);
                instancePath.lineTo(10.75f, 39.0f);
                instancePath.lineTo(10.75f, 32.43f);
                instancePath.lineTo(4.09099f, 39.090992f);
                instancePath.lineTo(0.90900975f, 35.909008f);
                instancePath.lineTo(7.568f, 29.25f);
                instancePath.lineTo(1.0f, 29.25f);
                instancePath.lineTo(1.0f, 24.75f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 6.123234E-17f, -1.0f, 64.0f, 1.0f, 6.123234E-17f, -0.15901184f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(39.25f, 24.75f);
                instancePath2.lineTo(39.25f, 39.0f);
                instancePath2.lineTo(34.75f, 39.0f);
                instancePath2.lineTo(34.75f, 32.43f);
                instancePath2.lineTo(28.09099f, 39.090992f);
                instancePath2.lineTo(24.90901f, 35.909008f);
                instancePath2.lineTo(31.569f, 29.249f);
                instancePath2.lineTo(25.0f, 29.25f);
                instancePath2.lineTo(25.0f, 24.75f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                float[] matrixFloatArray4 = c.setMatrixFloatArray(matrixFloatArray3, -6.123234E-17f, 1.0f, 0.15900993f, -1.0f, -6.123234E-17f, 16.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray4);
                canvas.concat(instanceMatrix);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(15.25f, 0.75f);
                instancePath3.lineTo(15.25f, 15.0f);
                instancePath3.lineTo(10.75f, 15.0f);
                instancePath3.lineTo(10.75f, 8.43f);
                instancePath3.lineTo(4.09099f, 15.09099f);
                instancePath3.lineTo(0.90900975f, 11.90901f);
                instancePath3.lineTo(7.57f, 5.249f);
                instancePath3.lineTo(1.0f, 5.25f);
                instancePath3.lineTo(1.0f, 0.75f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint3, looper);
                float[] matrixFloatArray5 = c.setMatrixFloatArray(matrixFloatArray4, 6.123234E-17f, -1.0f, 40.0f, -1.0f, -6.123234E-17f, 40.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray5);
                canvas.concat(instanceMatrix);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(39.25f, 0.75f);
                instancePath4.lineTo(39.25f, 15.0f);
                instancePath4.lineTo(34.75f, 15.0f);
                instancePath4.lineTo(34.75f, 8.43f);
                instancePath4.lineTo(28.09099f, 15.09099f);
                instancePath4.lineTo(24.90901f, 11.90901f);
                instancePath4.lineTo(31.569f, 5.25f);
                instancePath4.lineTo(25.0f, 5.25f);
                instancePath4.lineTo(25.0f, 0.75f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath4, 1);
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
