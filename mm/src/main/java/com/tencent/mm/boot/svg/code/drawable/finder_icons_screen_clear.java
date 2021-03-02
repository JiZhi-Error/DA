package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_icons_screen_clear extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 2.83871f, 0.0f, 1.0f, 3.777778f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(21.580645f, 12.0f);
                instancePath.cubicTo(25.215034f, 12.0f, 28.161291f, 14.959895f, 28.161291f, 18.61111f);
                instancePath.cubicTo(28.161291f, 22.262327f, 25.215034f, 25.222221f, 21.580645f, 25.222221f);
                instancePath.cubicTo(17.946255f, 25.222221f, 15.0f, 22.262327f, 15.0f, 18.61111f);
                instancePath.cubicTo(15.0f, 14.959895f, 17.946255f, 12.0f, 21.580645f, 12.0f);
                instancePath.close();
                instancePath.moveTo(18.059921f, 14.998893f);
                instancePath.cubicTo(17.127178f, 15.916567f, 16.548388f, 17.195934f, 16.548388f, 18.61111f);
                instancePath.cubicTo(16.548388f, 21.403217f, 18.801405f, 23.666666f, 21.580645f, 23.666666f);
                instancePath.cubicTo(22.393244f, 23.666666f, 23.160856f, 23.473171f, 23.840324f, 23.129541f);
                instancePath.close();
                instancePath.moveTo(21.580645f, 13.555555f);
                instancePath.cubicTo(20.767288f, 13.555555f, 19.998999f, 13.749413f, 19.319061f, 14.093644f);
                instancePath.lineTo(25.10137f, 22.22333f);
                instancePath.cubicTo(26.034111f, 21.305655f, 26.612904f, 20.026289f, 26.612904f, 18.61111f);
                instancePath.cubicTo(26.612904f, 15.819005f, 24.359884f, 13.555555f, 21.580645f, 13.555555f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 0.16129f, 0.0f, 1.0f, 0.222222f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(23.333334f, 0.0f);
                instancePath2.cubicTo(24.069714f, 0.0f, 24.666666f, 0.5969537f, 24.666666f, 1.3333334f);
                instancePath2.lineTo(24.666666f, 13.333333f);
                instancePath2.lineTo(23.066668f, 13.333333f);
                instancePath2.lineTo(23.066668f, 1.6f);
                instancePath2.lineTo(1.6f, 1.6f);
                instancePath2.lineTo(1.6f, 19.733334f);
                instancePath2.lineTo(15.955078f, 19.733334f);
                instancePath2.lineTo(15.955078f, 21.333334f);
                instancePath2.lineTo(1.3333334f, 21.333334f);
                instancePath2.cubicTo(0.5969537f, 21.333334f, 0.0f, 20.73638f, 0.0f, 20.0f);
                instancePath2.lineTo(0.0f, 1.3333334f);
                instancePath2.cubicTo(0.0f, 0.5969537f, 0.5969537f, 0.0f, 1.3333334f, 0.0f);
                instancePath2.lineTo(23.333334f, 0.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                instancePaint6.setColor(-1);
                instancePaint6.setStrokeWidth(1.4f);
                instancePaint6.setStrokeCap(Paint.Cap.SQUARE);
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 5.0f, 0.0f, 1.0f, 5.5f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint6, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(13.5f, 0.5f);
                instancePath3.lineTo(0.5f, 0.5f);
                canvas.drawPath(instancePath3, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint6, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(13.638889f, 4.5f);
                instancePath4.lineTo(0.5f, 4.5f);
                canvas.drawPath(instancePath4, instancePaint8);
                canvas.restore();
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint6, looper);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(7.5f, 8.5f);
                instancePath5.lineTo(0.5f, 8.5f);
                canvas.drawPath(instancePath5, instancePaint9);
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
