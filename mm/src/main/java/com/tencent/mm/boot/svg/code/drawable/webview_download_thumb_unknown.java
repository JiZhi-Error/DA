package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class webview_download_thumb_unknown extends c {
    private final int height = 90;
    private final int width = 90;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-7829368);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(90.0f, 0.0f);
                instancePath.lineTo(90.0f, 90.0f);
                instancePath.lineTo(0.0f, 90.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 25.0f, 0.0f, 1.0f, 17.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint5.setColor(-1);
                instancePaint5.setStrokeWidth(4.0f);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(40.0f, 50.0f);
                instancePath2.cubicTo(40.0f, 51.162144f, 39.16621f, 52.0f, 38.0f, 52.0f);
                instancePath2.lineTo(2.0f, 52.0f);
                instancePath2.cubicTo(0.83545685f, 52.0f, 0.0f, 51.15074f, 0.0f, 50.0f);
                instancePath2.lineTo(0.0f, 2.0f);
                instancePath2.cubicTo(0.0f, 0.8378576f, 0.8337914f, 0.0f, 2.0f, 0.0f);
                instancePath2.lineTo(27.0f, 0.0f);
                instancePath2.lineTo(40.0f, 13.0f);
                instancePath2.lineTo(40.0f, 50.0f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-1);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(23.0f, 0.0f);
                instancePath3.lineTo(27.0f, 0.0f);
                instancePath3.lineTo(27.0f, 16.0f);
                instancePath3.lineTo(23.0f, 16.0f);
                instancePath3.lineTo(23.0f, 0.0f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                instancePaint7.setColor(-1);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(23.0f, 13.0f);
                instancePath4.lineTo(40.0f, 13.0f);
                instancePath4.lineTo(40.0f, 17.0f);
                instancePath4.lineTo(23.0f, 17.0f);
                instancePath4.lineTo(23.0f, 13.0f);
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
