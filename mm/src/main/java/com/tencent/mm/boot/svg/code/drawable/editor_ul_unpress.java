package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class editor_ul_unpress extends c {
    private final int height = 144;
    private final int width = 144;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                instancePaint4.setColor(-855638017);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 28.8f);
                instancePath.cubicTo(0.0f, 12.894198f, 12.894198f, 0.0f, 28.8f, 0.0f);
                instancePath.lineTo(115.2f, 0.0f);
                instancePath.cubicTo(131.1058f, 0.0f, 144.0f, 12.894198f, 144.0f, 28.8f);
                instancePath.lineTo(144.0f, 115.2f);
                instancePath.cubicTo(144.0f, 131.1058f, 131.1058f, 144.0f, 115.2f, 144.0f);
                instancePath.lineTo(28.8f, 144.0f);
                instancePath.cubicTo(12.894198f, 144.0f, 0.0f, 131.1058f, 0.0f, 115.2f);
                instancePath.lineTo(0.0f, 28.8f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 40.8f, 0.0f, 1.0f, 45.6f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                instancePaint6.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint6.setStrokeWidth(3.6f);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(17.28f, 4.4f);
                instancePath2.lineTo(64.8f, 4.4f);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint3, looper);
                instancePaint7.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint7.setStrokeWidth(3.6f);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(17.28f, 26.4f);
                instancePath3.lineTo(64.8f, 26.4f);
                canvas.drawPath(instancePath3, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint3, looper);
                instancePaint8.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint8.setStrokeWidth(3.6f);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(17.28f, 48.4f);
                instancePath4.lineTo(64.8f, 48.4f);
                canvas.drawPath(instancePath4, instancePaint8);
                canvas.restore();
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint, looper);
                instancePaint9.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(3.456f, 0.0f);
                instancePath5.cubicTo(5.3646965f, 0.0f, 6.912f, 1.5446175f, 6.912f, 3.45f);
                instancePath5.cubicTo(6.912f, 5.3553824f, 5.3646965f, 6.9f, 3.456f, 6.9f);
                instancePath5.cubicTo(1.5473038f, 6.9f, 0.0f, 5.3553824f, 0.0f, 3.45f);
                instancePath5.cubicTo(0.0f, 1.5446175f, 1.5473038f, 0.0f, 3.456f, 0.0f);
                instancePath5.close();
                canvas.drawPath(instancePath5, instancePaint9);
                canvas.restore();
                canvas.save();
                Paint instancePaint10 = c.instancePaint(instancePaint, looper);
                instancePaint10.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath6 = c.instancePath(looper);
                instancePath6.moveTo(3.456f, 22.0f);
                instancePath6.cubicTo(5.3646965f, 22.0f, 6.912f, 23.575958f, 6.912f, 25.52f);
                instancePath6.cubicTo(6.912f, 27.464043f, 5.3646965f, 29.04f, 3.456f, 29.04f);
                instancePath6.cubicTo(1.5473038f, 29.04f, 0.0f, 27.464043f, 0.0f, 25.52f);
                instancePath6.cubicTo(0.0f, 23.575958f, 1.5473038f, 22.0f, 3.456f, 22.0f);
                instancePath6.close();
                canvas.drawPath(instancePath6, instancePaint10);
                canvas.restore();
                canvas.save();
                Paint instancePaint11 = c.instancePaint(instancePaint, looper);
                instancePaint11.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath7 = c.instancePath(looper);
                instancePath7.moveTo(3.456f, 44.0f);
                instancePath7.cubicTo(5.3646965f, 44.0f, 6.912f, 45.57596f, 6.912f, 47.52f);
                instancePath7.cubicTo(6.912f, 49.464043f, 5.3646965f, 51.04f, 3.456f, 51.04f);
                instancePath7.cubicTo(1.5473038f, 51.04f, 0.0f, 49.464043f, 0.0f, 47.52f);
                instancePath7.cubicTo(0.0f, 45.57596f, 1.5473038f, 44.0f, 3.456f, 44.0f);
                instancePath7.close();
                canvas.drawPath(instancePath7, instancePaint11);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
