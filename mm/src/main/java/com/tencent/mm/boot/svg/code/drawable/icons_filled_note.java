package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_note extends c {
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
                c.instancePaint(instancePaint2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 6.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(43.5f, 50.838852f);
                instancePath.cubicTo(43.02057f, 50.96225f, 42.51795f, 51.027878f, 42.0f, 51.027878f);
                instancePath.lineTo(4.5f, 51.027878f);
                instancePath.lineTo(4.5f, 55.5f);
                instancePath.lineTo(42.0f, 55.5f);
                instancePath.cubicTo(42.828426f, 55.5f, 43.5f, 54.828426f, 43.5f, 54.0f);
                instancePath.lineTo(43.5f, 50.838852f);
                instancePath.close();
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(42.0f, 0.0f);
                instancePath.cubicTo(45.31371f, -6.087184E-16f, 48.0f, 2.6862915f, 48.0f, 6.0f);
                instancePath.lineTo(48.0f, 54.0f);
                instancePath.cubicTo(48.0f, 57.31371f, 45.31371f, 60.0f, 42.0f, 60.0f);
                instancePath.lineTo(0.0f, 60.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                instancePath.moveTo(9.0f, 4.5f);
                instancePath.lineTo(9.0f, 46.5f);
                instancePath.lineTo(13.5f, 46.5f);
                instancePath.lineTo(13.5f, 4.5f);
                instancePath.lineTo(9.0f, 4.5f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}