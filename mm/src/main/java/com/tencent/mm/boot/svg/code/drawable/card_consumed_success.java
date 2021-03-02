package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class card_consumed_success extends c {
    private final int height = 260;
    private final int width = 260;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 260;
            case 1:
                return 260;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -449.0f, 0.0f, 1.0f, -309.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 459.0f, 0.0f, 1.0f, 319.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-1);
                instancePaint4.setStrokeWidth(10.0f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(240.0f, 121.48148f);
                instancePath.cubicTo(240.0f, 53.724445f, 186.27556f, 0.0f, 118.51852f, 0.0f);
                instancePath.cubicTo(53.724445f, 0.0f, 0.0f, 53.724445f, 0.0f, 121.48148f);
                instancePath.cubicTo(0.0f, 186.27556f, 53.724445f, 240.0f, 118.51852f, 240.0f);
                instancePath.cubicTo(186.27556f, 240.0f, 240.0f, 186.27556f, 240.0f, 121.48148f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(62.89717f, 128.89716f);
                instancePath2.cubicTo(62.320534f, 128.30037f, 62.253185f, 127.272156f, 62.745144f, 126.60276f);
                instancePath2.lineTo(67.678764f, 119.88967f);
                instancePath2.cubicTo(68.17144f, 119.2193f, 69.10391f, 119.084435f, 69.767876f, 119.59332f);
                instancePath2.lineTo(100.458435f, 143.11588f);
                instancePath2.cubicTo(101.119545f, 143.62259f, 102.17168f, 143.60332f, 102.81298f, 143.06906f);
                instancePath2.lineTo(178.11874f, 80.33327f);
                instancePath2.cubicTo(178.75801f, 79.800705f, 179.75937f, 79.846115f, 180.34068f, 80.42023f);
                instancePath2.lineTo(184.92955f, 84.95216f);
                instancePath2.cubicTo(185.51743f, 85.53275f, 185.51967f, 86.470215f, 184.92761f, 87.05289f);
                instancePath2.lineTo(102.71939f, 167.95805f);
                instancePath2.cubicTo(102.13045f, 168.53767f, 101.192276f, 168.5307f, 100.60892f, 167.92696f);
                instancePath2.lineTo(62.89717f, 128.89716f);
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
