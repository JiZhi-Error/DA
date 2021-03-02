package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fts_web_video_stop_btn extends c {
    private final int height = 50;
    private final int width = 50;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 50;
            case 1:
                return 50;
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
                instancePaint3.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -289.0f, 0.0f, 1.0f, -369.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 302.0f, 0.0f, 1.0f, 370.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 1.5f);
                instancePath.cubicTo(0.0f, 0.6715728f, 0.6715728f, 0.0f, 1.5f, 0.0f);
                instancePath.lineTo(2.5f, 0.0f);
                instancePath.cubicTo(3.3284273f, 0.0f, 4.0f, 0.6715728f, 4.0f, 1.5f);
                instancePath.lineTo(4.0f, 46.5f);
                instancePath.cubicTo(4.0f, 47.328426f, 3.3284273f, 48.0f, 2.5f, 48.0f);
                instancePath.lineTo(1.5f, 48.0f);
                instancePath.cubicTo(0.6715728f, 48.0f, 0.0f, 47.328426f, 0.0f, 46.5f);
                instancePath.lineTo(0.0f, 1.5f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(20.0f, 1.5f);
                instancePath2.cubicTo(20.0f, 0.6715728f, 20.671574f, 0.0f, 21.5f, 0.0f);
                instancePath2.lineTo(22.5f, 0.0f);
                instancePath2.cubicTo(23.328426f, 0.0f, 24.0f, 0.6715728f, 24.0f, 1.5f);
                instancePath2.lineTo(24.0f, 46.5f);
                instancePath2.cubicTo(24.0f, 47.328426f, 23.328426f, 48.0f, 22.5f, 48.0f);
                instancePath2.lineTo(21.5f, 48.0f);
                instancePath2.cubicTo(20.671574f, 48.0f, 20.0f, 47.328426f, 20.0f, 46.5f);
                instancePath2.lineTo(20.0f, 1.5f);
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
