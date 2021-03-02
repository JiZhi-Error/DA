package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fav_note_alarm_list extends c {
    private final int height = 30;
    private final int width = 30;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 30;
            case 1:
                return 30;
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
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-5066062);
                instancePaint4.setStrokeWidth(2.0f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(1.7598912f, 9.578414f);
                instancePath.cubicTo(0.67707217f, 8.5686035f, 0.0f, 7.1293283f, 0.0f, 5.5319147f);
                instancePath.cubicTo(0.0f, 2.4767227f, 2.4767227f, 0.0f, 5.5319147f, 0.0f);
                instancePath.cubicTo(7.280762f, 0.0f, 8.840067f, 0.8115291f, 9.853792f, 2.078551f);
                instancePath.cubicTo(6.0863647f, 3.10554f, 3.0613158f, 5.932576f, 1.7598912f, 9.578414f);
                instancePath.close();
                instancePath.moveTo(16.145893f, 2.078945f);
                instancePath.cubicTo(17.15961f, 0.8116973f, 18.719057f, 0.0f, 20.468084f, 0.0f);
                instancePath.cubicTo(23.523277f, 0.0f, 26.0f, 2.4767227f, 26.0f, 5.5319147f);
                instancePath.cubicTo(26.0f, 7.1299777f, 25.322378f, 8.569773f, 24.238789f, 9.579644f);
                instancePath.cubicTo(22.937773f, 5.9336786f, 19.913073f, 3.1063783f, 16.145893f, 2.078945f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(13.0f, 1.6595745f);
                instancePath2.cubicTo(19.263145f, 1.6595745f, 24.340425f, 6.7368555f, 24.340425f, 13.0f);
                instancePath2.cubicTo(24.340425f, 19.263145f, 19.263145f, 24.340425f, 13.0f, 24.340425f);
                instancePath2.cubicTo(6.7368555f, 24.340425f, 1.6595745f, 19.263145f, 1.6595745f, 13.0f);
                instancePath2.cubicTo(1.6595745f, 6.7368555f, 6.7368555f, 1.6595745f, 13.0f, 1.6595745f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint4, looper);
                instancePaint7.setStrokeCap(Paint.Cap.SQUARE);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(20.265247f, 22.957447f);
                instancePath3.lineTo(23.031206f, 25.723404f);
                canvas.drawPath(instancePath3, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint4, looper);
                instancePaint8.setStrokeCap(Paint.Cap.SQUARE);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, -1.0f, 0.0f, 8.777304f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(3.2822695f, 22.404255f);
                instancePath4.lineTo(5.4950356f, 25.723404f);
                canvas.drawPath(instancePath4, instancePaint8);
                canvas.restore();
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint4, looper);
                instancePaint9.setStrokeCap(Paint.Cap.SQUARE);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(13.0f, 5.318182f);
                instancePath5.lineTo(13.0f, 13.0f);
                canvas.drawPath(instancePath5, instancePaint9);
                canvas.restore();
                canvas.save();
                Paint instancePaint10 = c.instancePaint(instancePaint4, looper);
                instancePaint10.setStrokeCap(Paint.Cap.SQUARE);
                Path instancePath6 = c.instancePath(looper);
                instancePath6.moveTo(13.0f, 13.0f);
                instancePath6.lineTo(17.978724f, 15.954546f);
                canvas.drawPath(instancePath6, instancePaint10);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
