package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class chatting_item_biz_music_pause_icon extends c {
    private final int height = 115;
    private final int width = 115;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 115;
            case 1:
                return 115;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -1018.0f, 0.0f, 1.0f, -386.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 1018.0f, 0.0f, 1.0f, 386.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(1275068416);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(57.5f, 0.0f);
                instancePath.cubicTo(89.25638f, 0.0f, 115.0f, 25.743626f, 115.0f, 57.5f);
                instancePath.cubicTo(115.0f, 89.25638f, 89.25638f, 115.0f, 57.5f, 115.0f);
                instancePath.cubicTo(25.743626f, 115.0f, 0.0f, 89.25638f, 0.0f, 57.5f);
                instancePath.cubicTo(0.0f, 25.743626f, 25.743626f, 0.0f, 57.5f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                instancePaint6.setColor(-1);
                instancePaint6.setStrokeWidth(6.0f);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(57.5f, 3.0f);
                instancePath2.cubicTo(87.59952f, 3.0f, 112.0f, 27.40048f, 112.0f, 57.5f);
                instancePath2.cubicTo(112.0f, 87.59952f, 87.59952f, 112.0f, 57.5f, 112.0f);
                instancePath2.cubicTo(27.40048f, 112.0f, 3.0f, 87.59952f, 3.0f, 57.5f);
                instancePath2.cubicTo(3.0f, 27.40048f, 27.40048f, 3.0f, 57.5f, 3.0f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                instancePaint7.setColor(-1);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(41.0f, 43.0f);
                instancePath3.cubicTo(41.0f, 41.89543f, 41.89543f, 41.0f, 43.0f, 41.0f);
                instancePath3.lineTo(72.0f, 41.0f);
                instancePath3.cubicTo(73.10457f, 41.0f, 74.0f, 41.89543f, 74.0f, 43.0f);
                instancePath3.lineTo(74.0f, 72.0f);
                instancePath3.cubicTo(74.0f, 73.10457f, 73.10457f, 74.0f, 72.0f, 74.0f);
                instancePath3.lineTo(43.0f, 74.0f);
                instancePath3.cubicTo(41.89543f, 74.0f, 41.0f, 73.10457f, 41.0f, 72.0f);
                instancePath3.lineTo(41.0f, 43.0f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint7);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
