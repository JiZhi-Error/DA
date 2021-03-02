package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class search_timeline_btn extends c {
    private final int height = 79;
    private final int width = 78;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 78;
            case 1:
                return 79;
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
                instancePaint3.setColor(-11184811);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -98.0f, 0.0f, 1.0f, -237.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 98.0f, 0.0f, 1.0f, 237.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(39.0f, 78.49056f);
                instancePath.cubicTo(60.539104f, 78.49056f, 78.0f, 60.919853f, 78.0f, 39.24528f);
                instancePath.cubicTo(78.0f, 17.570711f, 60.539104f, 0.0f, 39.0f, 0.0f);
                instancePath.cubicTo(17.460896f, 0.0f, 0.0f, 17.570711f, 0.0f, 39.24528f);
                instancePath.cubicTo(0.0f, 60.919853f, 17.460896f, 78.49056f, 39.0f, 78.49056f);
                instancePath.close();
                instancePath.moveTo(39.0f, 49.81132f);
                instancePath.cubicTo(44.79899f, 49.81132f, 49.5f, 45.080746f, 49.5f, 39.24528f);
                instancePath.cubicTo(49.5f, 33.40982f, 44.79899f, 28.679245f, 39.0f, 28.679245f);
                instancePath.cubicTo(33.20101f, 28.679245f, 28.5f, 33.40982f, 28.5f, 39.24528f);
                instancePath.cubicTo(28.5f, 45.080746f, 33.20101f, 49.81132f, 39.0f, 49.81132f);
                instancePath.close();
                instancePath.moveTo(5.5411763f, 25.559748f);
                instancePath.lineTo(39.42353f, 25.559748f);
                instancePath.lineTo(21.635294f, 7.280799f);
                instancePath.cubicTo(14.510319f, 11.176246f, 8.756289f, 17.502306f, 5.5411763f, 25.559748f);
                instancePath.close();
                instancePath.moveTo(38.623528f, 3.018868f);
                instancePath.cubicTo(42.618313f, 3.018868f, 46.231693f, 3.5782247f, 49.4f, 4.7236404f);
                instancePath.lineTo(49.4f, 30.295227f);
                instancePath.lineTo(25.07059f, 5.5760264f);
                instancePath.cubicTo(29.332592f, 3.9696975f, 33.99222f, 3.018868f, 38.623528f, 3.018868f);
                instancePath.close();
                instancePath.moveTo(3.0f, 39.671474f);
                instancePath.cubicTo(3.0f, 44.320057f, 3.949455f, 49.015682f, 5.55f, 53.309654f);
                instancePath.lineTo(30.2f, 28.779875f);
                instancePath.lineTo(4.7f, 28.779875f);
                instancePath.cubicTo(3.5547369f, 32.009815f, 3.0f, 35.63943f, 3.0f, 39.671474f);
                instancePath.close();
                instancePath.moveTo(25.4f, 72.91454f);
                instancePath.lineTo(25.4f, 38.81909f);
                instancePath.lineTo(7.2352943f, 56.7192f);
                instancePath.cubicTo(11.105359f, 63.90108f, 17.385756f, 69.68455f, 25.4f, 72.91454f);
                instancePath.close();
                instancePath.moveTo(39.42353f, 75.471695f);
                instancePath.cubicTo(44.037518f, 75.471695f, 48.70667f, 74.51502f, 52.97647f, 72.91454f);
                instancePath.lineTo(28.6f, 48.19534f);
                instancePath.lineTo(28.6f, 73.76692f);
                instancePath.cubicTo(31.807348f, 74.91449f, 35.411324f, 75.471695f, 39.42353f, 75.471695f);
                instancePath.close();
                instancePath.moveTo(72.458824f, 52.83019f);
                instancePath.lineTo(38.57647f, 52.83019f);
                instancePath.lineTo(56.364704f, 71.20977f);
                instancePath.cubicTo(63.50134f, 67.31788f, 69.24691f, 61.003838f, 72.458824f, 52.83019f);
                instancePath.close();
                instancePath.moveTo(75.0f, 39.671474f);
                instancePath.cubicTo(75.0f, 35.01675f, 74.04735f, 30.324898f, 72.45f, 26.033297f);
                instancePath.lineTo(47.8f, 49.81132f);
                instancePath.lineTo(73.3f, 49.81132f);
                instancePath.cubicTo(74.441315f, 47.329823f, 75.0f, 43.696667f, 75.0f, 39.671474f);
                instancePath.close();
                instancePath.moveTo(52.6f, 6.381058f);
                instancePath.lineTo(52.6f, 40.47651f);
                instancePath.lineTo(70.76471f, 22.576397f);
                instancePath.cubicTo(66.89496f, 15.407206f, 60.61241f, 9.61857f, 52.6f, 6.381058f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
