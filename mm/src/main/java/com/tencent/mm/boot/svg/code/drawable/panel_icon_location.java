package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class panel_icon_location extends c {
    private final int height = 192;
    private final int width = 192;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 192;
            case 1:
                return 192;
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
                instancePaint3.setColor(-13421773);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 48.0f, 0.0f, 1.0f, 48.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(45.781845f, 85.01546f);
                instancePath.cubicTo(45.781845f, 85.01546f, 18.0f, 61.568542f, 18.0f, 39.0f);
                instancePath.cubicTo(18.0f, 22.431458f, 31.431458f, 9.0f, 48.0f, 9.0f);
                instancePath.cubicTo(64.56854f, 9.0f, 78.0f, 22.431458f, 78.0f, 39.0f);
                instancePath.cubicTo(78.0f, 61.568542f, 50.230366f, 85.00419f, 50.230366f, 85.00419f);
                instancePath.cubicTo(49.015343f, 86.10895f, 47.006897f, 86.11149f, 45.781845f, 85.01546f);
                instancePath.close();
                instancePath.moveTo(48.0f, 51.0f);
                instancePath.cubicTo(54.62742f, 51.0f, 60.0f, 45.62742f, 60.0f, 39.0f);
                instancePath.cubicTo(60.0f, 32.37258f, 54.62742f, 27.0f, 48.0f, 27.0f);
                instancePath.cubicTo(41.37258f, 27.0f, 36.0f, 32.37258f, 36.0f, 39.0f);
                instancePath.cubicTo(36.0f, 45.62742f, 41.37258f, 51.0f, 48.0f, 51.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
