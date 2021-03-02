package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_colorful_handoff extends c {
    private final int height = 32;
    private final int width = 32;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 32;
            case 1:
                return 32;
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
                instancePaint3.setColor(-15683841);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -12.0f, 0.0f, 1.0f, -12.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(20.03616f, 23.6f);
                instancePath.lineTo(21.609674f, 27.926605f);
                instancePath.cubicTo(21.760666f, 28.341833f, 21.546461f, 28.800842f, 21.131235f, 28.951836f);
                instancePath.cubicTo(21.043606f, 28.9837f, 20.951082f, 29.0f, 20.85784f, 29.0f);
                instancePath.lineTo(11.14216f, 29.0f);
                instancePath.cubicTo(10.700333f, 29.0f, 10.34216f, 28.641829f, 10.34216f, 28.2f);
                instancePath.cubicTo(10.34216f, 28.106758f, 10.35846f, 28.014235f, 10.390326f, 27.926605f);
                instancePath.lineTo(11.96316f, 23.6f);
                instancePath.lineTo(20.03616f, 23.6f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(28.1f, 3.0f);
                instancePath2.cubicTo(28.8732f, 3.0f, 29.5f, 3.6268013f, 29.5f, 4.4f);
                instancePath2.lineTo(29.5f, 20.6f);
                instancePath2.cubicTo(29.5f, 21.3732f, 28.8732f, 22.0f, 28.1f, 22.0f);
                instancePath2.lineTo(3.9f, 22.0f);
                instancePath2.cubicTo(3.1268013f, 22.0f, 2.5f, 21.3732f, 2.5f, 20.6f);
                instancePath2.lineTo(2.5f, 4.4f);
                instancePath2.cubicTo(2.5f, 3.6268013f, 3.1268013f, 3.0f, 3.9f, 3.0f);
                instancePath2.lineTo(28.1f, 3.0f);
                instancePath2.close();
                instancePath2.moveTo(16.411257f, 7.5488462f);
                instancePath2.cubicTo(16.169971f, 7.3217154f, 15.790246f, 7.33319f, 15.563115f, 7.5744743f);
                instancePath2.lineTo(15.563115f, 7.5744743f);
                instancePath2.lineTo(11.0f, 12.421952f);
                instancePath2.lineTo(12.25f, 13.749849f);
                instancePath2.lineTo(15.117f, 10.704729f);
                instancePath2.lineTo(15.116117f, 17.614271f);
                instancePath2.lineTo(16.883884f, 17.614271f);
                instancePath2.lineTo(16.884f, 10.703729f);
                instancePath2.lineTo(19.75f, 13.749849f);
                instancePath2.lineTo(21.0f, 12.421952f);
                instancePath2.lineTo(17.25f, 8.438261f);
                instancePath2.lineTo(16.436884f, 7.5744743f);
                instancePath2.cubicTo(16.428602f, 7.5656757f, 16.420055f, 7.557129f, 16.411257f, 7.5488462f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
