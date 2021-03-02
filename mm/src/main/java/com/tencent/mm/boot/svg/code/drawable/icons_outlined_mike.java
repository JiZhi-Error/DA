package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_mike extends c {
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 0.8660254f, -0.5f, 30.430782f, 0.5f, 0.8660254f, -17.569218f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(68.0f, 82.641014f);
                instancePath.cubicTo(48.868294f, 93.686714f, 24.404678f, 87.13171f, 13.358984f, 68.0f);
                instancePath.cubicTo(2.313289f, 48.868294f, 8.868295f, 24.404678f, 28.0f, 13.358984f);
                instancePath.cubicTo(47.131706f, 2.313289f, 71.59532f, 8.868295f, 82.641014f, 28.0f);
                instancePath.cubicTo(93.686714f, 47.131706f, 87.13171f, 71.59532f, 68.0f, 82.641014f);
                instancePath.close();
                instancePath.moveTo(65.6f, 78.48409f);
                instancePath.cubicTo(82.4359f, 68.763885f, 88.20431f, 47.2359f, 78.48409f, 30.4f);
                instancePath.cubicTo(68.763885f, 13.564099f, 47.2359f, 7.7956944f, 30.4f, 17.515905f);
                instancePath.cubicTo(13.564099f, 27.236118f, 7.7956944f, 48.7641f, 17.515905f, 65.6f);
                instancePath.cubicTo(27.236118f, 82.4359f, 48.7641f, 88.20431f, 65.6f, 78.48409f);
                instancePath.close();
                instancePath.moveTo(48.0f, 30.8f);
                instancePath.cubicTo(45.12812f, 30.8f, 42.8f, 33.12812f, 42.8f, 36.0f);
                instancePath.lineTo(42.8f, 50.0f);
                instancePath.cubicTo(42.8f, 52.87188f, 45.12812f, 55.2f, 48.0f, 55.2f);
                instancePath.cubicTo(50.87188f, 55.2f, 53.2f, 52.87188f, 53.2f, 50.0f);
                instancePath.lineTo(53.2f, 36.0f);
                instancePath.cubicTo(53.2f, 33.12812f, 50.87188f, 30.8f, 48.0f, 30.8f);
                instancePath.close();
                instancePath.moveTo(50.400097f, 67.841354f);
                instancePath.lineTo(50.400097f, 74.0f);
                instancePath.lineTo(45.600098f, 74.0f);
                instancePath.lineTo(45.600098f, 67.84136f);
                instancePath.cubicTo(36.793587f, 66.667694f, 30.0f, 59.124485f, 30.0f, 49.990005f);
                instancePath.lineTo(30.0f, 44.0f);
                instancePath.lineTo(34.8f, 44.0f);
                instancePath.lineTo(34.8f, 49.990005f);
                instancePath.cubicTo(34.8f, 57.287613f, 40.7096f, 63.2f, 48.0f, 63.2f);
                instancePath.cubicTo(55.2909f, 63.2f, 61.2f, 57.287125f, 61.2f, 49.990005f);
                instancePath.lineTo(61.2f, 44.0f);
                instancePath.lineTo(66.0f, 44.0f);
                instancePath.lineTo(66.0f, 49.990005f);
                instancePath.cubicTo(66.0f, 59.12258f, 59.208122f, 66.66752f, 50.400097f, 67.841354f);
                instancePath.close();
                instancePath.moveTo(48.0f, 26.0f);
                instancePath.cubicTo(53.522846f, 26.0f, 58.0f, 30.477152f, 58.0f, 36.0f);
                instancePath.lineTo(58.0f, 50.0f);
                instancePath.cubicTo(58.0f, 55.522846f, 53.522846f, 60.0f, 48.0f, 60.0f);
                instancePath.cubicTo(42.477154f, 60.0f, 38.0f, 55.522846f, 38.0f, 50.0f);
                instancePath.lineTo(38.0f, 36.0f);
                instancePath.cubicTo(38.0f, 30.477152f, 42.477154f, 26.0f, 48.0f, 26.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
