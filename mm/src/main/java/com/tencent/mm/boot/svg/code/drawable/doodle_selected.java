package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class doodle_selected extends c {
    private final int height = 63;
    private final int width = 63;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 63;
            case 1:
                return 63;
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-14624737);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 0.70710677f, -0.70710677f, 31.39409f, 0.70710677f, 0.70710677f, -12.125177f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(25.405478f, 12.6148405f);
                instancePath.lineTo(25.645857f, 54.121506f);
                instancePath.lineTo(30.480642f, 63.385418f);
                instancePath.lineTo(35.31543f, 54.121506f);
                instancePath.lineTo(35.21498f, 12.6148405f);
                instancePath.lineTo(25.405478f, 12.6148405f);
                instancePath.close();
                instancePath.moveTo(25.389639f, 9.879872f);
                instancePath.lineTo(25.351372f, 3.272119f);
                instancePath.cubicTo(25.341805f, 1.6204139f, 26.683146f, 0.28144225f, 28.343227f, 0.28144225f);
                instancePath.lineTo(32.175957f, 0.28144225f);
                instancePath.cubicTo(33.83788f, 0.28144225f, 35.188385f, 1.6257602f, 35.19237f, 3.272119f);
                instancePath.lineTo(35.208363f, 9.879872f);
                instancePath.lineTo(25.389639f, 9.879872f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
