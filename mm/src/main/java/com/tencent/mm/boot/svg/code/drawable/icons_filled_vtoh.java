package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_vtoh extends c {
    private final int height = 24;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 6.123234E-17f, 1.0f, 0.0f, -1.0f, 6.123234E-17f, 24.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 4.44f, 0.0f, 1.0f, -0.76f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-1);
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, -1.8369701E-16f, -1.0f, 18.36f, -1.0f, 1.8369701E-16f, 10.840001f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                instancePaint5.setColor(-1);
                instancePaint6.setStrokeWidth(0.675f);
                float[] matrixFloatArray4 = c.setMatrixFloatArray(matrixFloatArray3, -1.8369701E-16f, -1.0f, 4.547654f, 1.0f, -1.8369701E-16f, 0.57865393f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray4);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(1.9845f, 4.0013084f);
                instancePath.lineTo(3.969f, 1.125f);
                instancePath.lineTo(-1.3267165E-12f, 1.125f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint5);
                canvas.drawPath(instancePath, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint4, looper);
                instancePaint7.setStrokeWidth(1.575f);
                float[] matrixFloatArray5 = c.setMatrixFloatArray(matrixFloatArray4, 0.9702957f, 0.2419219f, -1.1668984f, -0.2419219f, 0.9702957f, 1.5690049f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray5);
                canvas.concat(instanceMatrix);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(8.319938f, 9.343043f);
                instancePath2.cubicTo(8.436546f, 8.87535f, 8.483838f, 8.411162f, 8.483838f, 7.9222465f);
                instancePath2.cubicTo(8.483838f, 5.017462f, 6.4821863f, 2.5801878f, 3.782953f, 1.9144945f);
                instancePath2.cubicTo(3.3067403f, 1.7970494f, 3.1387181f, 1.6981331f, 3.1277833f, 1.7389423f);
                canvas.drawPath(instancePath2, instancePaint7);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint3, looper);
                instancePaint8.setColor(-1);
                instancePaint8.setStrokeWidth(1.575f);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(1.35f, 7.6044307f);
                instancePath3.cubicTo(1.35f, 6.9831104f, 1.8536795f, 6.4794307f, 2.475f, 6.4794307f);
                instancePath3.lineTo(9.450001f, 6.4794307f);
                instancePath3.cubicTo(10.0713215f, 6.4794307f, 10.575001f, 6.9831104f, 10.575001f, 7.6044307f);
                instancePath3.lineTo(10.575001f, 20.33943f);
                instancePath3.cubicTo(10.575001f, 20.96075f, 10.0713215f, 21.46443f, 9.450001f, 21.46443f);
                instancePath3.lineTo(2.475f, 21.46443f);
                instancePath3.cubicTo(1.8536795f, 21.46443f, 1.35f, 20.96075f, 1.35f, 20.33943f);
                instancePath3.lineTo(1.35f, 7.6044307f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint8);
                canvas.restore();
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint, looper);
                instancePaint9.setColor(-1);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(5.9625f, 17.436f);
                instancePath4.cubicTo(6.514785f, 17.436f, 6.9625f, 17.883717f, 6.9625f, 18.436f);
                instancePath4.cubicTo(6.9625f, 18.988285f, 6.514785f, 19.436f, 5.9625f, 19.436f);
                instancePath4.cubicTo(5.4102154f, 19.436f, 4.9625f, 18.988285f, 4.9625f, 18.436f);
                instancePath4.cubicTo(4.9625f, 17.883717f, 5.4102154f, 17.436f, 5.9625f, 17.436f);
                instancePath4.close();
                canvas.drawPath(instancePath4, instancePaint9);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
