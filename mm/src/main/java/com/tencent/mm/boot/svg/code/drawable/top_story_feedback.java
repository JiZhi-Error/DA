package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class top_story_feedback extends c {
    private final int height = 24;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                canvas.saveLayerAlpha(null, 230, 31);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 4.5f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                instancePaint5.setStrokeWidth(1.2f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.6f, 9.0f);
                instancePath.cubicTo(0.6f, 4.360808f, 4.360808f, 0.6f, 9.0f, 0.6f);
                instancePath.lineTo(13.0f, 0.6f);
                instancePath.cubicTo(17.639193f, 0.6f, 21.4f, 4.360808f, 21.4f, 9.0f);
                instancePath.lineTo(21.4f, 9.0f);
                instancePath.cubicTo(21.4f, 13.639193f, 17.639193f, 17.4f, 13.0f, 17.4f);
                instancePath.lineTo(9.0f, 17.4f);
                instancePath.cubicTo(4.360808f, 17.4f, 0.6f, 13.639193f, 0.6f, 9.0f);
                instancePath.lineTo(0.6f, 9.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 0.70710677f, -0.70710677f, 9.585787f, 0.70710677f, 0.70710677f, -5.142135f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(7.5f, 8.833333f);
                instancePath2.lineTo(7.5f, 9.166667f);
                instancePath2.lineTo(10.833333f, 9.166667f);
                instancePath2.lineTo(10.833333f, 12.5f);
                instancePath2.lineTo(11.166667f, 12.5f);
                instancePath2.lineTo(11.166667f, 9.166667f);
                instancePath2.lineTo(14.5f, 9.166667f);
                instancePath2.lineTo(14.5f, 8.833333f);
                instancePath2.lineTo(11.166667f, 8.833333f);
                instancePath2.lineTo(11.166667f, 5.5f);
                instancePath2.lineTo(10.833333f, 5.5f);
                instancePath2.lineTo(10.833333f, 8.833333f);
                instancePath2.lineTo(7.5f, 8.833333f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
