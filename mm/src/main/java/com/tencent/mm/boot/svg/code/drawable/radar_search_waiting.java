package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class radar_search_waiting extends c {
    private final int height = 48;
    private final int width = 48;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                instancePaint3.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 7.0f, 0.0f, 1.0f, 5.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.9f, 0.0f);
                instancePath.lineTo(34.1f, 0.0f);
                instancePath.cubicTo(33.86f, 7.5f, 29.44f, 14.06f, 24.1f, 19.0f);
                instancePath.cubicTo(29.21f, 23.71f, 33.38f, 29.87f, 34.09f, 36.94f);
                instancePath.cubicTo(23.03f, 37.05f, 11.96f, 37.01f, 0.9f, 36.97f);
                instancePath.cubicTo(1.62f, 29.89f, 5.78f, 23.72f, 10.9f, 19.01f);
                instancePath.cubicTo(5.57f, 14.06f, 1.14f, 7.5f, 0.9f, 0.0f);
                instancePath.lineTo(0.9f, 0.0f);
                instancePath.close();
                instancePath.moveTo(8.27f, 6.01f);
                instancePath.cubicTo(10.16f, 10.93f, 16.03f, 13.56f, 16.48f, 19.02f);
                instancePath.cubicTo(16.19f, 24.12f, 10.8f, 26.53f, 8.87f, 30.95f);
                instancePath.cubicTo(14.62f, 31.03f, 20.37f, 31.03f, 26.12f, 30.94f);
                instancePath.cubicTo(24.2f, 26.52f, 18.8f, 24.11f, 18.52f, 19.01f);
                instancePath.cubicTo(18.99f, 13.55f, 24.84f, 10.93f, 26.73f, 6.01f);
                instancePath.cubicTo(20.58f, 6.0f, 14.42f, 6.0f, 8.27f, 6.01f);
                instancePath.lineTo(8.27f, 6.01f);
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
