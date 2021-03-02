package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_grouptool extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(15.652174f, 0.0f);
                instancePath.cubicTo(24.29663f, 0.0f, 31.304348f, 7.007716f, 31.304348f, 15.652174f);
                instancePath.cubicTo(31.304348f, 24.29663f, 24.29663f, 31.304348f, 15.652174f, 31.304348f);
                instancePath.cubicTo(7.007716f, 31.304348f, 0.0f, 24.29663f, 0.0f, 15.652174f);
                instancePath.cubicTo(0.0f, 7.007716f, 7.007716f, 0.0f, 15.652174f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(56.347828f, 0.0f);
                instancePath2.cubicTo(64.99229f, 0.0f, 72.0f, 7.007716f, 72.0f, 15.652174f);
                instancePath2.cubicTo(72.0f, 24.29663f, 64.99229f, 31.304348f, 56.347828f, 31.304348f);
                instancePath2.cubicTo(47.70337f, 31.304348f, 40.695656f, 24.29663f, 40.695656f, 15.652174f);
                instancePath2.cubicTo(40.695656f, 7.007716f, 47.70337f, 0.0f, 56.347828f, 0.0f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(15.652174f, 40.695656f);
                instancePath3.cubicTo(24.29663f, 40.695656f, 31.304348f, 47.70337f, 31.304348f, 56.347828f);
                instancePath3.cubicTo(31.304348f, 64.99229f, 24.29663f, 72.0f, 15.652174f, 72.0f);
                instancePath3.cubicTo(7.007716f, 72.0f, 0.0f, 64.99229f, 0.0f, 56.347828f);
                instancePath3.cubicTo(0.0f, 47.70337f, 7.007716f, 40.695656f, 15.652174f, 40.695656f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint3, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(56.347828f, 40.695656f);
                instancePath4.cubicTo(64.99229f, 40.695656f, 72.0f, 47.70337f, 72.0f, 56.347828f);
                instancePath4.cubicTo(72.0f, 64.99229f, 64.99229f, 72.0f, 56.347828f, 72.0f);
                instancePath4.cubicTo(47.70337f, 72.0f, 40.695656f, 64.99229f, 40.695656f, 56.347828f);
                instancePath4.cubicTo(40.695656f, 47.70337f, 47.70337f, 40.695656f, 56.347828f, 40.695656f);
                instancePath4.close();
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
