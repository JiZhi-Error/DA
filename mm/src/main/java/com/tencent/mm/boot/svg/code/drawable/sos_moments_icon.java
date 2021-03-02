package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sos_moments_icon extends c {
    private final int height = 42;
    private final int width = 42;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 42;
            case 1:
                return 42;
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
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-4210753);
                instancePaint5.setColor(-4210753);
                instancePaint5.setStrokeWidth(0.5f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Paint instancePaint7 = c.instancePaint(instancePaint5, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(20.0f, 40.0f);
                instancePath.cubicTo(8.954305f, 40.0f, 0.0f, 31.045694f, 0.0f, 20.0f);
                instancePath.cubicTo(0.0f, 8.954305f, 8.954305f, 0.0f, 20.0f, 0.0f);
                instancePath.cubicTo(31.045694f, 0.0f, 40.0f, 8.954305f, 40.0f, 20.0f);
                instancePath.cubicTo(40.0f, 31.045694f, 31.045694f, 40.0f, 20.0f, 40.0f);
                instancePath.close();
                instancePath.moveTo(20.0f, 25.384615f);
                instancePath.cubicTo(22.97384f, 25.384615f, 25.384615f, 22.97384f, 25.384615f, 20.0f);
                instancePath.cubicTo(25.384615f, 17.02616f, 22.97384f, 14.615385f, 20.0f, 14.615385f);
                instancePath.cubicTo(17.02616f, 14.615385f, 14.615385f, 17.02616f, 14.615385f, 20.0f);
                instancePath.cubicTo(14.615385f, 22.97384f, 17.02616f, 25.384615f, 20.0f, 25.384615f);
                instancePath.close();
                instancePath.moveTo(2.841629f, 13.025641f);
                instancePath.lineTo(20.217196f, 13.025641f);
                instancePath.lineTo(11.095022f, 3.7104073f);
                instancePath.cubicTo(7.4411893f, 5.695587f, 4.4904046f, 8.919444f, 2.841629f, 13.025641f);
                instancePath.close();
                instancePath.moveTo(19.806938f, 1.5384616f);
                instancePath.cubicTo(17.431908f, 1.5384616f, 15.042355f, 2.0230188f, 12.856712f, 2.841629f);
                instancePath.lineTo(25.333334f, 15.438914f);
                instancePath.lineTo(25.333334f, 2.40724f);
                instancePath.cubicTo(23.70856f, 1.8235183f, 21.855545f, 1.5384616f, 19.806938f, 1.5384616f);
                instancePath.close();
                instancePath.moveTo(1.5384616f, 20.217196f);
                instancePath.cubicTo(1.5384616f, 22.586182f, 2.0253615f, 24.979147f, 2.8461537f, 27.167421f);
                instancePath.lineTo(15.48718f, 14.666667f);
                instancePath.lineTo(2.4102564f, 14.666667f);
                instancePath.cubicTo(1.8229419f, 16.312695f, 1.5384616f, 18.162403f, 1.5384616f, 20.217196f);
                instancePath.close();
                instancePath.moveTo(13.025641f, 37.15837f);
                instancePath.lineTo(13.025641f, 19.782804f);
                instancePath.lineTo(3.7104073f, 28.904978f);
                instancePath.cubicTo(5.695056f, 32.564972f, 8.915772f, 35.512318f, 13.025641f, 37.15837f);
                instancePath.close();
                instancePath.moveTo(20.217196f, 38.46154f);
                instancePath.cubicTo(22.583342f, 38.46154f, 24.97778f, 37.974f, 27.167421f, 37.15837f);
                instancePath.lineTo(14.666667f, 24.561087f);
                instancePath.lineTo(14.666667f, 37.592762f);
                instancePath.cubicTo(16.31146f, 38.177578f, 18.159653f, 38.46154f, 20.217196f, 38.46154f);
                instancePath.close();
                instancePath.moveTo(37.15837f, 26.923077f);
                instancePath.lineTo(19.782804f, 26.923077f);
                instancePath.lineTo(28.904978f, 36.289593f);
                instancePath.cubicTo(32.56479f, 34.306225f, 35.51124f, 31.088493f, 37.15837f, 26.923077f);
                instancePath.close();
                instancePath.moveTo(38.46154f, 20.217196f);
                instancePath.cubicTo(38.46154f, 17.845076f, 37.973f, 15.454035f, 37.153847f, 13.266969f);
                instancePath.lineTo(24.512821f, 25.384615f);
                instancePath.lineTo(37.589745f, 25.384615f);
                instancePath.cubicTo(38.175034f, 24.120005f, 38.46154f, 22.268494f, 38.46154f, 20.217196f);
                instancePath.close();
                instancePath.moveTo(26.97436f, 3.2518854f);
                instancePath.lineTo(26.97436f, 20.62745f);
                instancePath.lineTo(36.289593f, 11.505279f);
                instancePath.cubicTo(34.305107f, 7.851749f, 31.083288f, 4.901771f, 26.97436f, 3.2518854f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint6);
                canvas.drawPath(instancePath, instancePaint7);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
