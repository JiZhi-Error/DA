package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sos_article_icon extends c {
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
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 4.307692f, 0.0f, 1.0f, 2.076923f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-4210753);
                instancePaint4.setStrokeWidth(2.3f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 1.6488063f);
                instancePath.cubicTo(0.0f, 0.7381957f, 0.7381957f, 0.0f, 1.6488063f, 0.0f);
                instancePath.lineTo(30.658888f, 0.0f);
                instancePath.cubicTo(31.569498f, 0.0f, 32.307693f, 0.7381957f, 32.307693f, 1.6488063f);
                instancePath.lineTo(32.307693f, 36.351192f);
                instancePath.cubicTo(32.307693f, 37.261803f, 31.569498f, 38.0f, 30.658888f, 38.0f);
                instancePath.lineTo(1.6488063f, 38.0f);
                instancePath.cubicTo(0.7381957f, 38.0f, 0.0f, 37.261803f, 0.0f, 36.351192f);
                instancePath.lineTo(0.0f, 1.6488063f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                instancePaint5.setColor(-4737097);
                instancePaint6.setColor(-4737097);
                instancePaint6.setStrokeWidth(0.6f);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(4.0384617f, 14.942307f);
                instancePath2.lineTo(21.0f, 14.942307f);
                instancePath2.lineTo(21.0f, 16.602564f);
                instancePath2.lineTo(4.0384617f, 16.602564f);
                instancePath2.lineTo(4.0384617f, 14.942307f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                Paint instancePaint8 = c.instancePaint(instancePaint3, looper);
                instancePaint7.setColor(-4737097);
                instancePaint8.setColor(-4737097);
                instancePaint8.setStrokeWidth(0.6f);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(4.0384617f, 19.923077f);
                instancePath3.lineTo(12.923077f, 19.923077f);
                instancePath3.lineTo(12.923077f, 21.583332f);
                instancePath3.lineTo(4.0384617f, 21.583332f);
                instancePath3.lineTo(4.0384617f, 19.923077f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint7);
                canvas.drawPath(instancePath3, instancePaint8);
                canvas.restore();
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint, looper);
                Paint instancePaint10 = c.instancePaint(instancePaint3, looper);
                instancePaint9.setColor(-4737097);
                instancePaint10.setColor(-4737097);
                instancePaint10.setStrokeWidth(0.6f);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(4.0384617f, 24.903847f);
                instancePath4.lineTo(14.538462f, 24.903847f);
                instancePath4.lineTo(14.538462f, 26.564102f);
                instancePath4.lineTo(4.0384617f, 26.564102f);
                instancePath4.lineTo(4.0384617f, 24.903847f);
                instancePath4.close();
                canvas.drawPath(instancePath4, instancePaint9);
                canvas.drawPath(instancePath4, instancePaint10);
                canvas.restore();
                canvas.save();
                Paint instancePaint11 = c.instancePaint(instancePaint, looper);
                instancePaint11.setColor(-4737097);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(6.3695426f, 6.0f);
                instancePath5.cubicTo(7.6569633f, 6.0f, 8.7006235f, 7.072651f, 8.7006235f, 8.395833f);
                instancePath5.cubicTo(8.7006235f, 9.719015f, 7.6569633f, 10.791666f, 6.3695426f, 10.791666f);
                instancePath5.cubicTo(5.082122f, 10.791666f, 4.0384617f, 9.719015f, 4.0384617f, 8.395833f);
                instancePath5.cubicTo(4.0384617f, 7.072651f, 5.082122f, 6.0f, 6.3695426f, 6.0f);
                instancePath5.close();
                canvas.drawPath(instancePath5, instancePaint11);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
