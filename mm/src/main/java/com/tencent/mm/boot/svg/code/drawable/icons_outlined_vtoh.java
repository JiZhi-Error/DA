package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_vtoh extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 4.8f, 0.0f, 1.0f, 0.137907f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, -6.123234E-17f, -1.0f, 18.0f, -1.0f, 6.123234E-17f, 10.200001f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                instancePaint5.setColor(-1);
                instancePaint6.setStrokeWidth(0.675f);
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, -1.8369701E-16f, -1.0f, 4.622654f, 1.0f, -1.8369701E-16f, 0.653654f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(1.9845f, 4.0763087f);
                instancePath.lineTo(3.969f, 1.2f);
                instancePath.lineTo(-4.172218E-13f, 1.2f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint5);
                canvas.drawPath(instancePath, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint4, looper);
                instancePaint7.setStrokeWidth(1.575f);
                float[] matrixFloatArray4 = c.setMatrixFloatArray(matrixFloatArray3, 0.9702957f, 0.2419219f, -1.1850425f, -0.2419219f, 0.9702957f, 1.5712327f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray4);
                canvas.concat(instanceMatrix);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(8.319938f, 9.418044f);
                instancePath2.cubicTo(8.427132f, 8.961834f, 8.483838f, 8.486162f, 8.483838f, 7.9972463f);
                instancePath2.cubicTo(8.483838f, 5.0924616f, 6.4821863f, 2.6551876f, 3.782953f, 1.9894944f);
                instancePath2.cubicTo(3.3067403f, 1.8720495f, 3.1387181f, 1.7731332f, 3.1277833f, 1.8139423f);
                canvas.drawPath(instancePath2, instancePaint7);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint4, looper);
                instancePaint8.setStrokeWidth(1.575f);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(0.7875f, 7.426524f);
                instancePath3.cubicTo(0.7875f, 6.805204f, 1.2911797f, 6.301524f, 1.9125f, 6.301524f);
                instancePath3.lineTo(8.887501f, 6.301524f);
                instancePath3.cubicTo(9.5088215f, 6.301524f, 10.012501f, 6.805204f, 10.012501f, 7.426524f);
                instancePath3.lineTo(10.012501f, 19.351524f);
                instancePath3.cubicTo(10.012501f, 19.972845f, 9.5088215f, 20.476524f, 8.887501f, 20.476524f);
                instancePath3.lineTo(1.9125f, 20.476524f);
                instancePath3.cubicTo(1.2911797f, 20.476524f, 0.7875f, 19.972845f, 0.7875f, 19.351524f);
                instancePath3.lineTo(0.7875f, 7.426524f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint8);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
