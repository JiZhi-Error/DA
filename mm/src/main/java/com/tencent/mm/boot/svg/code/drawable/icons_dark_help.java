package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_dark_help extends c {
    private final int height = 64;
    private final int width = 64;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 64;
            case 1:
                return 64;
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-15616);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 5.333333f, 0.0f, 1.0f, 5.333333f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(26.666666f, 0.0f);
                instancePath.cubicTo(41.39426f, 0.0f, 53.333332f, 11.939074f, 53.333332f, 26.666666f);
                instancePath.cubicTo(53.333332f, 41.39426f, 41.39426f, 53.333332f, 26.666666f, 53.333332f);
                instancePath.cubicTo(11.939074f, 53.333332f, 0.0f, 41.39426f, 0.0f, 26.666666f);
                instancePath.cubicTo(0.0f, 11.939074f, 11.939074f, 0.0f, 26.666666f, 0.0f);
                instancePath.close();
                instancePath.moveTo(26.666666f, 36.72578f);
                instancePath.cubicTo(25.416666f, 36.72578f, 24.440104f, 37.68281f, 24.440104f, 38.952343f);
                instancePath.cubicTo(24.440104f, 40.202343f, 25.416666f, 41.178905f, 26.666666f, 41.178905f);
                instancePath.cubicTo(27.936197f, 41.178905f, 28.893229f, 40.202343f, 28.893229f, 38.952343f);
                instancePath.cubicTo(28.893229f, 37.68281f, 27.936197f, 36.72578f, 26.666666f, 36.72578f);
                instancePath.close();
                instancePath.moveTo(28.424479f, 12.8f);
                instancePath.lineTo(24.908854f, 12.8f);
                instancePath.lineTo(25.143229f, 31.628126f);
                instancePath.lineTo(28.190104f, 31.628126f);
                instancePath.lineTo(28.424479f, 12.8f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
