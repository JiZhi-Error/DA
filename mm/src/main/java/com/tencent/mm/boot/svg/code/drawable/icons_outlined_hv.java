package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_hv extends c {
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
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 1.2246469E-16f, -1.4695762E-15f, 1.2246469E-16f, -1.0f, 24.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 4.2f, 0.0f, 1.0f, -0.52f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, -1.8369701E-16f, -1.0f, 18.6f, -1.0f, 1.8369701E-16f, 10.84f, 0.0f, 0.0f, 1.0f);
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
                Paint instancePaint8 = c.instancePaint(instancePaint4, looper);
                instancePaint8.setStrokeWidth(1.575f);
                float[] matrixFloatArray6 = c.setMatrixFloatArray(matrixFloatArray5, -1.0f, 1.2246469E-16f, 11.3625f, -1.2246469E-16f, -1.0f, 22.491932f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray6);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint8, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(0.7875f, 1.9125f);
                instancePath3.cubicTo(0.7875f, 1.2911797f, 1.2911797f, 0.7875f, 1.9125f, 0.7875f);
                instancePath3.lineTo(8.887501f, 0.7875f);
                instancePath3.cubicTo(9.5088215f, 0.7875f, 10.012501f, 1.2911797f, 10.012501f, 1.9125f);
                instancePath3.lineTo(10.012501f, 14.6475f);
                instancePath3.cubicTo(10.012501f, 15.268821f, 9.5088215f, 15.7725f, 8.887501f, 15.7725f);
                instancePath3.lineTo(1.9125f, 15.7725f);
                instancePath3.cubicTo(1.2911797f, 15.7725f, 0.7875f, 15.268821f, 0.7875f, 14.6475f);
                instancePath3.lineTo(0.7875f, 1.9125f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint9);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
