package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_comment extends c {
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
                c.instancePaint(instancePaint2, looper).setStrokeWidth(1.0f);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-436207616);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 5.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(8.1f, 13.5f);
                instancePath.lineTo(6.036396f, 15.563604f);
                instancePath.cubicTo(5.684924f, 15.915076f, 5.1150756f, 15.915076f, 4.7636037f, 15.563604f);
                instancePath.cubicTo(4.594821f, 15.394821f, 4.5f, 15.165902f, 4.5f, 14.927208f);
                instancePath.lineTo(4.5f, 13.5f);
                instancePath.lineTo(1.35f, 13.5f);
                instancePath.cubicTo(0.6044156f, 13.5f, 0.0f, 12.895584f, 0.0f, 12.15f);
                instancePath.lineTo(0.0f, 1.35f);
                instancePath.cubicTo(0.0f, 0.6044156f, 0.6044156f, 0.0f, 1.35f, 0.0f);
                instancePath.lineTo(16.65f, 0.0f);
                instancePath.cubicTo(17.395584f, 0.0f, 18.0f, 0.6044156f, 18.0f, 1.35f);
                instancePath.lineTo(18.0f, 12.15f);
                instancePath.cubicTo(18.0f, 12.895584f, 17.395584f, 13.5f, 16.65f, 13.5f);
                instancePath.lineTo(8.1f, 13.5f);
                instancePath.close();
                instancePath.moveTo(5.7f, 14.202944f);
                instancePath.lineTo(7.602944f, 12.3f);
                instancePath.lineTo(16.65f, 12.3f);
                instancePath.cubicTo(16.732843f, 12.3f, 16.8f, 12.232842f, 16.8f, 12.15f);
                instancePath.lineTo(16.8f, 1.35f);
                instancePath.cubicTo(16.8f, 1.2671573f, 16.732843f, 1.2f, 16.65f, 1.2f);
                instancePath.lineTo(1.35f, 1.2f);
                instancePath.cubicTo(1.2671573f, 1.2f, 1.2f, 1.2671573f, 1.2f, 1.35f);
                instancePath.lineTo(1.2f, 12.15f);
                instancePath.cubicTo(1.2f, 12.232842f, 1.2671573f, 12.3f, 1.35f, 12.3f);
                instancePath.lineTo(5.7f, 12.3f);
                instancePath.lineTo(5.7f, 14.202944f);
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