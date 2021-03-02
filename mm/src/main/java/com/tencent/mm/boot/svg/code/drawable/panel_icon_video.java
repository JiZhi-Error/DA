package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class panel_icon_video extends c {
    private final int height = 168;
    private final int width = 168;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 168;
            case 1:
                return 168;
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
                instancePaint3.setColor(-8617594);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 40.0f, 0.0f, 1.0f, 50.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(1.7979208f, 0.0f);
                instancePath.cubicTo(0.8049566f, 0.0f, 0.0f, 0.8110437f, 0.0f, 1.8013198f);
                instancePath.lineTo(0.0f, 66.19868f);
                instancePath.cubicTo(0.0f, 67.19352f, 0.8120969f, 68.0f, 1.8074489f, 68.0f);
                instancePath.lineTo(75.140465f, 68.0f);
                instancePath.cubicTo(76.138695f, 68.0f, 76.947914f, 67.19573f, 76.947914f, 66.19761f);
                instancePath.cubicTo(76.947914f, 66.19761f, 76.947914f, 56.10486f, 76.947914f, 49.86667f);
                instancePath.cubicTo(76.94792f, 40.74555f, 89.0f, 34.377186f, 89.0f, 29.013332f);
                instancePath.cubicTo(89.0f, 23.696405f, 89.0f, 1.8062787f, 89.0f, 1.8062787f);
                instancePath.cubicTo(89.0f, 0.8086985f, 88.20341f, 0.0f, 87.20208f, 0.0f);
                instancePath.lineTo(1.7979208f, 0.0f);
                instancePath.lineTo(1.7979208f, 0.0f);
                instancePath.close();
                instancePath.moveTo(6.0f, 6.0f);
                instancePath.lineTo(6.0f, 12.0f);
                instancePath.lineTo(16.0f, 12.0f);
                instancePath.lineTo(16.0f, 6.0f);
                instancePath.lineTo(6.0f, 6.0f);
                instancePath.lineTo(6.0f, 6.0f);
                instancePath.close();
                instancePath.moveTo(6.0f, 56.0f);
                instancePath.lineTo(6.0f, 62.0f);
                instancePath.lineTo(16.0f, 62.0f);
                instancePath.lineTo(16.0f, 56.0f);
                instancePath.lineTo(6.0f, 56.0f);
                instancePath.lineTo(6.0f, 56.0f);
                instancePath.close();
                instancePath.moveTo(22.0f, 6.0f);
                instancePath.lineTo(22.0f, 12.0f);
                instancePath.lineTo(32.0f, 12.0f);
                instancePath.lineTo(32.0f, 6.0f);
                instancePath.lineTo(22.0f, 6.0f);
                instancePath.lineTo(22.0f, 6.0f);
                instancePath.close();
                instancePath.moveTo(22.0f, 56.0f);
                instancePath.lineTo(22.0f, 62.0f);
                instancePath.lineTo(32.0f, 62.0f);
                instancePath.lineTo(32.0f, 56.0f);
                instancePath.lineTo(22.0f, 56.0f);
                instancePath.lineTo(22.0f, 56.0f);
                instancePath.close();
                instancePath.moveTo(38.0f, 6.0f);
                instancePath.lineTo(38.0f, 12.0f);
                instancePath.lineTo(48.0f, 12.0f);
                instancePath.lineTo(48.0f, 6.0f);
                instancePath.lineTo(38.0f, 6.0f);
                instancePath.lineTo(38.0f, 6.0f);
                instancePath.close();
                instancePath.moveTo(38.0f, 56.0f);
                instancePath.lineTo(38.0f, 62.0f);
                instancePath.lineTo(48.0f, 62.0f);
                instancePath.lineTo(48.0f, 56.0f);
                instancePath.lineTo(38.0f, 56.0f);
                instancePath.lineTo(38.0f, 56.0f);
                instancePath.close();
                instancePath.moveTo(54.0f, 6.0f);
                instancePath.lineTo(54.0f, 12.0f);
                instancePath.lineTo(64.0f, 12.0f);
                instancePath.lineTo(64.0f, 6.0f);
                instancePath.lineTo(54.0f, 6.0f);
                instancePath.lineTo(54.0f, 6.0f);
                instancePath.close();
                instancePath.moveTo(54.0f, 56.0f);
                instancePath.lineTo(54.0f, 62.0f);
                instancePath.lineTo(64.0f, 62.0f);
                instancePath.lineTo(64.0f, 56.0f);
                instancePath.lineTo(54.0f, 56.0f);
                instancePath.lineTo(54.0f, 56.0f);
                instancePath.close();
                instancePath.moveTo(70.0f, 6.0f);
                instancePath.lineTo(70.0f, 12.0f);
                instancePath.lineTo(80.0f, 12.0f);
                instancePath.lineTo(80.0f, 6.0f);
                instancePath.lineTo(70.0f, 6.0f);
                instancePath.lineTo(70.0f, 6.0f);
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
