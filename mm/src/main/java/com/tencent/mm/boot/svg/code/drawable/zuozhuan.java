package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class zuozhuan extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 18.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, -1.0f, 0.0f, 44.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(35.96871f, 3.6252928f);
                instancePath.cubicTo(43.908043f, 9.608009f, 45.49418f, 20.894049f, 39.51146f, 28.833387f);
                instancePath.cubicTo(33.595215f, 36.68451f, 22.49285f, 38.322857f, 14.569242f, 32.572792f);
                instancePath.lineTo(14.3033695f, 32.37617f);
                instancePath.lineTo(17.91426f, 27.584358f);
                instancePath.cubicTo(23.207146f, 31.572834f, 30.731163f, 30.515392f, 34.719646f, 25.222498f);
                instancePath.cubicTo(38.70813f, 19.929602f, 37.650707f, 12.405581f, 32.35782f, 8.417106f);
                instancePath.cubicTo(27.06493f, 4.4286265f, 19.540894f, 5.486061f, 15.520621f, 10.820387f);
                instancePath.cubicTo(14.559699f, 12.050423f, 13.854734f, 13.4099655f, 13.406418f, 14.915149f);
                instancePath.lineTo(20.786894f, 15.609411f);
                instancePath.lineTo(9.16957f, 26.340914f);
                instancePath.lineTo(0.29198435f, 13.682716f);
                instancePath.lineTo(7.3525424f, 14.3464985f);
                instancePath.cubicTo(7.9301133f, 11.843923f, 8.976221f, 9.561095f, 10.486247f, 7.52814f);
                instancePath.lineTo(10.760601f, 7.1680617f);
                instancePath.cubicTo(16.74332f, -0.77127427f, 28.029375f, -2.357426f, 35.96871f, 3.6252928f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
