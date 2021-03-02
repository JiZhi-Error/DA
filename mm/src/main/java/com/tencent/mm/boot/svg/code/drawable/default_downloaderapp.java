package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class default_downloaderapp extends c {
    private final int height = 192;
    private final int width = 192;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 192;
            case 1:
                return 192;
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
                instancePaint3.setColor(-13786557);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(192.0f, 0.0f);
                instancePath.lineTo(192.0f, 192.0f);
                instancePath.lineTo(0.0f, 192.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 42.666668f, 0.0f, 1.0f, 48.375f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, -1.0f, 0.0f, 106.5f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(88.101395f, 78.85144f);
                instancePath2.cubicTo(99.326584f, 70.61707f, 106.5f, 58.437584f, 106.5f, 44.908268f);
                instancePath2.cubicTo(106.5f, 20.105265f, 82.65881f, 0.0f, 53.25f, 0.0f);
                instancePath2.cubicTo(23.841188f, 0.0f, 0.0f, 20.105265f, 0.0f, 44.908268f);
                instancePath2.cubicTo(0.0f, 69.70905f, 23.841188f, 89.816536f, 53.25f, 89.816536f);
                instancePath2.cubicTo(59.326565f, 89.816536f, 65.19253f, 88.93738f, 70.63073f, 87.35222f);
                instancePath2.cubicTo(71.1265f, 87.201256f, 71.65299f, 87.11689f, 72.19703f, 87.11689f);
                instancePath2.cubicTo(73.2193f, 87.11689f, 74.14943f, 87.432144f, 75.02472f, 87.94499f);
                instancePath2.lineTo(86.67987f, 94.75627f);
                instancePath2.cubicTo(87.00674f, 94.94498f, 87.32263f, 95.08929f, 87.708725f, 95.08929f);
                instancePath2.cubicTo(88.68931f, 95.08929f, 89.48123f, 94.28561f, 89.48123f, 93.29544f);
                instancePath2.cubicTo(89.48123f, 92.8492f, 89.30793f, 92.40518f, 89.19605f, 91.98114f);
                instancePath2.cubicTo(89.12805f, 91.72805f, 87.69337f, 86.30656f, 86.79614f, 82.92311f);
                instancePath2.cubicTo(86.69523f, 82.54126f, 86.60967f, 82.17494f, 86.60967f, 81.77754f);
                instancePath2.cubicTo(86.60967f, 80.57202f, 87.19978f, 79.50193f, 88.101395f, 78.85144f);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-13786557);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(49.501553f, 52.715603f);
                instancePath3.lineTo(49.501553f, 27.0f);
                instancePath3.lineTo(57.24297f, 27.0f);
                instancePath3.lineTo(57.24297f, 52.62429f);
                instancePath3.lineTo(69.24226f, 40.625f);
                instancePath3.lineTo(74.403206f, 45.785946f);
                instancePath3.lineTo(53.348446f, 66.840706f);
                instancePath3.lineTo(53.326603f, 66.81886f);
                instancePath3.lineTo(53.30476f, 66.840706f);
                instancePath3.lineTo(32.25f, 45.785946f);
                instancePath3.lineTo(37.410946f, 40.625f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
