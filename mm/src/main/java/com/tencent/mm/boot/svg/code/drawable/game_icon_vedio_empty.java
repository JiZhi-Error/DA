package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class game_icon_vedio_empty extends c {
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
                instancePaint3.setColor(419430400);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -144.0f, 0.0f, 1.0f, -322.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 47.0f, 0.0f, 1.0f, 322.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 97.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray4 = c.setMatrixFloatArray(matrixFloatArray3, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 15.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray4);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(3.0f, 1.5f);
                instancePath.lineTo(42.0f, 1.5f);
                instancePath.cubicTo(43.656853f, 1.5f, 45.0f, 2.8431458f, 45.0f, 4.5f);
                instancePath.lineTo(45.0f, 37.5f);
                instancePath.cubicTo(45.0f, 39.156853f, 43.656853f, 40.5f, 42.0f, 40.5f);
                instancePath.lineTo(3.0f, 40.5f);
                instancePath.cubicTo(1.3431457f, 40.5f, 2.0290612E-16f, 39.156853f, 0.0f, 37.5f);
                instancePath.lineTo(0.0f, 4.5f);
                instancePath.cubicTo(-2.0290612E-16f, 2.8431458f, 1.3431457f, 1.5f, 3.0f, 1.5f);
                instancePath.close();
                instancePath.moveTo(48.0f, 15.0f);
                instancePath.lineTo(58.125916f, 6.899268f);
                instancePath.cubicTo(59.4197f, 5.8642397f, 61.30758f, 6.0740037f, 62.342606f, 7.3677893f);
                instancePath.cubicTo(62.768158f, 7.899729f, 63.0f, 8.56066f, 63.0f, 9.241875f);
                instancePath.lineTo(63.0f, 32.758125f);
                instancePath.cubicTo(63.0f, 34.414978f, 61.656853f, 35.758125f, 60.0f, 35.758125f);
                instancePath.cubicTo(59.318787f, 35.758125f, 58.657852f, 35.526283f, 58.125916f, 35.10073f);
                instancePath.lineTo(48.0f, 27.0f);
                instancePath.lineTo(48.0f, 15.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
