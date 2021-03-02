package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fix_tools_entry extends c {
    private final int height = 68;
    private final int width = 68;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 68;
            case 1:
                return 68;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.1333333f, 0.0f, 0.0f, 0.0f, 1.1333333f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                c.instancePaint(instancePaint2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(24.0f, 6.0f);
                instancePath.lineTo(24.0f, 13.582962f);
                instancePath.cubicTo(24.0f, 16.068243f, 26.014719f, 18.082962f, 28.5f, 18.082962f);
                instancePath.cubicTo(30.985281f, 18.082962f, 33.0f, 16.068243f, 33.0f, 13.582962f);
                instancePath.lineTo(33.0f, 6.0f);
                instancePath.cubicTo(36.54742f, 7.710701f, 39.0f, 11.381189f, 39.0f, 15.633177f);
                instancePath.cubicTo(39.0f, 19.693186f, 36.763893f, 23.223017f, 33.473682f, 25.022778f);
                instancePath.lineTo(33.473682f, 49.026318f);
                instancePath.cubicTo(33.473682f, 51.773205f, 31.24689f, 54.0f, 28.5f, 54.0f);
                instancePath.cubicTo(25.75311f, 54.0f, 23.526316f, 51.773205f, 23.526316f, 49.026318f);
                instancePath.lineTo(23.526316f, 25.022778f);
                instancePath.cubicTo(20.236107f, 23.223017f, 18.0f, 19.693186f, 18.0f, 15.633177f);
                instancePath.cubicTo(18.0f, 11.381189f, 20.45258f, 7.710701f, 24.0f, 6.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
