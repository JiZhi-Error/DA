package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class media_player_btn_cur_status_on extends c {
    private final int height = 32;
    private final int width = 32;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 32;
            case 1:
                return 32;
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
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(32.0f, 0.0f);
                instancePath.lineTo(32.0f, 32.0f);
                instancePath.lineTo(0.0f, 32.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 10.0f, 0.0f, 1.0f, 9.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(0.0f, 1.0f);
                instancePath2.cubicTo(0.0f, 0.44771522f, 0.44771522f, 0.0f, 1.0f, 0.0f);
                instancePath2.lineTo(3.0f, 0.0f);
                instancePath2.cubicTo(3.5522847f, 0.0f, 4.0f, 0.44771522f, 4.0f, 1.0f);
                instancePath2.lineTo(4.0f, 13.0f);
                instancePath2.cubicTo(4.0f, 13.552285f, 3.5522847f, 14.0f, 3.0f, 14.0f);
                instancePath2.lineTo(1.0f, 14.0f);
                instancePath2.cubicTo(0.44771522f, 14.0f, 0.0f, 13.552285f, 0.0f, 13.0f);
                instancePath2.lineTo(0.0f, 1.0f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(8.0f, 1.0f);
                instancePath3.cubicTo(8.0f, 0.44771522f, 8.447715f, 0.0f, 9.0f, 0.0f);
                instancePath3.lineTo(11.0f, 0.0f);
                instancePath3.cubicTo(11.552285f, 0.0f, 12.0f, 0.44771522f, 12.0f, 1.0f);
                instancePath3.lineTo(12.0f, 13.0f);
                instancePath3.cubicTo(12.0f, 13.552285f, 11.552285f, 14.0f, 11.0f, 14.0f);
                instancePath3.lineTo(9.0f, 14.0f);
                instancePath3.cubicTo(8.447715f, 14.0f, 8.0f, 13.552285f, 8.0f, 13.0f);
                instancePath3.lineTo(8.0f, 1.0f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
