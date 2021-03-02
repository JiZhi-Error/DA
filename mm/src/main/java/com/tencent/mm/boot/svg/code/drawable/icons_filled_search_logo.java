package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_search_logo extends c {
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 9.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(25.226866f, 14.426866f);
                instancePath.lineTo(29.41791f, 5.7223883f);
                instancePath.cubicTo(29.901493f, 4.674627f, 29.901493f, 3.6268656f, 29.498508f, 2.6597016f);
                instancePath.cubicTo(29.095522f, 1.6925373f, 28.289553f, 0.96716416f, 27.161194f, 0.5641791f);
                instancePath.lineTo(26.274628f, 0.24179104f);
                instancePath.cubicTo(25.871641f, 0.08059701f, 25.468657f, 0.0f, 25.065672f, 0.0f);
                instancePath.cubicTo(23.292538f, 0.0f, 21.841791f, 1.2089552f, 21.438807f, 2.9820895f);
                instancePath.lineTo(19.585075f, 12.411941f);
                instancePath.cubicTo(19.101492f, 14.668656f, 19.826866f, 16.76418f, 21.116419f, 17.24776f);
                instancePath.cubicTo(21.277613f, 17.328358f, 21.438807f, 17.328358f, 21.680597f, 17.328358f);
                instancePath.cubicTo(22.889553f, 17.408955f, 24.340298f, 16.2f, 25.226866f, 14.426866f);
                instancePath.close();
                instancePath.moveTo(15.313433f, 20.552238f);
                instancePath.cubicTo(15.474627f, 19.182089f, 13.782089f, 17.731344f, 11.525373f, 17.24776f);
                instancePath.lineTo(4.59403f, 15.555223f);
                instancePath.cubicTo(4.2716417f, 15.474627f, 3.9492538f, 15.474627f, 3.6268656f, 15.474627f);
                instancePath.cubicTo(1.7731344f, 15.474627f, 0.24179104f, 16.844776f, 0.08059701f, 18.698507f);
                instancePath.lineTo(0.0f, 19.665672f);
                instancePath.cubicTo(0.0f, 20.79403f, 0.40298507f, 21.841791f, 1.1283582f, 22.567163f);
                instancePath.cubicTo(1.7731344f, 23.21194f, 2.6597016f, 23.534328f, 3.6268656f, 23.534328f);
                instancePath.cubicTo(3.7074628f, 23.534328f, 3.7880597f, 23.534328f, 3.8686566f, 23.534328f);
                instancePath.lineTo(10.961194f, 23.21194f);
                instancePath.cubicTo(13.298508f, 22.97015f, 15.152239f, 21.841791f, 15.313433f, 20.552238f);
                instancePath.close();
                instancePath.moveTo(16.925373f, 27.564178f);
                instancePath.cubicTo(15.555223f, 27.161194f, 13.701492f, 28.450747f, 12.814925f, 30.546268f);
                instancePath.lineTo(6.044776f, 45.376118f);
                instancePath.cubicTo(5.561194f, 46.42388f, 5.561194f, 47.47164f, 6.044776f, 48.438805f);
                instancePath.cubicTo(6.528358f, 49.40597f, 7.334328f, 50.131344f, 8.462687f, 50.45373f);
                instancePath.lineTo(9.349254f, 50.77612f);
                instancePath.lineTo(9.429851f, 50.77612f);
                instancePath.cubicTo(9.591044f, 50.77612f, 9.752239f, 50.77612f, 9.913433f, 50.77612f);
                instancePath.cubicTo(11.847761f, 50.77612f, 14.023881f, 49.889553f, 14.5074625f, 48.03582f);
                instancePath.lineTo(18.456717f, 32.238808f);
                instancePath.cubicTo(18.859701f, 30.062687f, 18.295523f, 27.967165f, 16.925373f, 27.564178f);
                instancePath.close();
                instancePath.moveTo(28.773134f, 29.337313f);
                instancePath.cubicTo(27.725372f, 28.208956f, 26.355225f, 27.483582f, 25.226866f, 27.483582f);
                instancePath.cubicTo(24.743284f, 27.483582f, 24.340298f, 27.644775f, 24.01791f, 27.886568f);
                instancePath.cubicTo(22.97015f, 28.773134f, 23.131344f, 30.949253f, 24.501492f, 32.883583f);
                instancePath.lineTo(37.316418f, 51.58209f);
                instancePath.cubicTo(38.04179f, 52.71045f, 39.250748f, 53.274628f, 40.4597f, 53.274628f);
                instancePath.cubicTo(41.346268f, 53.274628f, 42.232838f, 52.95224f, 42.95821f, 52.38806f);
                instancePath.lineTo(43.683582f, 51.82388f);
                instancePath.cubicTo(44.57015f, 51.098507f, 45.05373f, 50.131344f, 45.134327f, 49.002987f);
                instancePath.cubicTo(45.214924f, 47.874626f, 44.81194f, 46.826866f, 44.086567f, 46.020897f);
                instancePath.lineTo(28.773134f, 29.337313f);
                instancePath.close();
                instancePath.moveTo(53.919403f, 19.907463f);
                instancePath.cubicTo(53.75821f, 17.570148f, 51.82388f, 15.877612f, 49.48657f, 16.2f);
                instancePath.lineTo(30.465672f, 19.020895f);
                instancePath.cubicTo(28.208956f, 19.343283f, 26.435822f, 20.713432f, 26.516418f, 22.164179f);
                instancePath.cubicTo(26.597015f, 23.614925f, 28.450747f, 24.743284f, 30.78806f, 24.743284f);
                instancePath.lineTo(49.567165f, 24.985075f);
                instancePath.lineTo(49.647762f, 24.985075f);
                instancePath.cubicTo(50.856716f, 24.985075f, 52.06567f, 24.420895f, 52.95224f, 23.534328f);
                instancePath.cubicTo(53.677612f, 22.728357f, 54.0f, 21.761194f, 54.0f, 20.79403f);
                instancePath.lineTo(53.919403f, 19.907463f);
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
