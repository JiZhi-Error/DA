package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class chatting_item_biz_music_pause_loading_icon extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -513.0f, 0.0f, 1.0f, -1170.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 513.0f, 0.0f, 1.0f, 1170.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-5066062);
                instancePaint4.setStrokeWidth(6.0f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(57.5f, 3.0f);
                instancePath.cubicTo(87.59952f, 3.0f, 112.0f, 27.40048f, 112.0f, 57.5f);
                instancePath.cubicTo(112.0f, 87.59952f, 87.59952f, 112.0f, 57.5f, 112.0f);
                instancePath.cubicTo(27.40048f, 112.0f, 3.0f, 87.59952f, 3.0f, 57.5f);
                instancePath.cubicTo(3.0f, 27.40048f, 27.40048f, 3.0f, 57.5f, 3.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-5066062);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(41.0f, 43.0f);
                instancePath2.cubicTo(41.0f, 41.89543f, 41.89543f, 41.0f, 43.0f, 41.0f);
                instancePath2.lineTo(72.0f, 41.0f);
                instancePath2.cubicTo(73.10457f, 41.0f, 74.0f, 41.89543f, 74.0f, 43.0f);
                instancePath2.lineTo(74.0f, 72.0f);
                instancePath2.cubicTo(74.0f, 73.10457f, 73.10457f, 74.0f, 72.0f, 74.0f);
                instancePath2.lineTo(43.0f, 74.0f);
                instancePath2.cubicTo(41.89543f, 74.0f, 41.0f, 73.10457f, 41.0f, 72.0f);
                instancePath2.lineTo(41.0f, 43.0f);
                instancePath2.close();
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
