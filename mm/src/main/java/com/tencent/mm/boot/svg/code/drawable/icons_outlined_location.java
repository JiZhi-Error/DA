package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_location extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint4.setStrokeWidth(3.8f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 13.5f, 0.0f, 1.0f, 7.5f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(22.5f, 1.9f);
                instancePath.cubicTo(16.80991f, 1.9f, 11.657898f, 4.1889653f, 7.9288034f, 7.8915734f);
                instancePath.cubicTo(4.2046285f, 11.589297f, 1.9f, 16.697329f, 1.9f, 22.340193f);
                instancePath.cubicTo(1.9f, 38.49178f, 21.652529f, 54.777836f, 21.700645f, 54.819466f);
                instancePath.cubicTo(21.922876f, 55.018337f, 22.219185f, 55.103367f, 22.507957f, 55.10272f);
                instancePath.cubicTo(22.790081f, 55.102085f, 23.079666f, 55.019444f, 23.357542f, 54.768497f);
                instancePath.cubicTo(23.357542f, 54.768497f, 43.1f, 38.49152f, 43.1f, 22.340193f);
                instancePath.cubicTo(43.1f, 16.697329f, 40.795372f, 11.589297f, 37.071198f, 7.8915734f);
                instancePath.cubicTo(33.342102f, 4.1889653f, 28.19009f, 1.9f, 22.5f, 1.9f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(22.5f, 13.9f);
                instancePath2.cubicTo(27.24965f, 13.9f, 31.1f, 17.75035f, 31.1f, 22.5f);
                instancePath2.cubicTo(31.1f, 27.24965f, 27.24965f, 31.1f, 22.5f, 31.1f);
                instancePath2.cubicTo(17.75035f, 31.1f, 13.9f, 27.24965f, 13.9f, 22.5f);
                instancePath2.cubicTo(13.9f, 17.75035f, 17.75035f, 13.9f, 22.5f, 13.9f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
