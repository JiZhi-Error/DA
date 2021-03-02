package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class panel_icon_wxtalk extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 46.0f, 0.0f, 1.0f, 41.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(58.04338f, 85.02192f);
                instancePath.cubicTo(68.83248f, 74.17345f, 75.5f, 59.221767f, 75.5f, 42.712807f);
                instancePath.cubicTo(75.5f, 25.998095f, 68.66525f, 10.879722f, 57.638073f, 5.1184834E-11f);
                instancePath.lineTo(50.21325f, 7.424826f);
                instancePath.cubicTo(59.340397f, 16.404242f, 65.0f, 28.897589f, 65.0f, 42.712807f);
                instancePath.cubicTo(65.0f, 56.322273f, 59.507717f, 68.64895f, 50.618725f, 77.59726f);
                instancePath.lineTo(58.04338f, 85.02192f);
                instancePath.close();
                instancePath.moveTo(40.01204f, 66.99058f);
                instancePath.cubicTo(46.186604f, 60.7568f, 50.0f, 52.180138f, 50.0f, 42.712807f);
                instancePath.cubicTo(50.0f, 33.039722f, 46.01905f, 24.29644f, 39.606136f, 18.031939f);
                instancePath.lineTo(32.18078f, 25.457294f);
                instancePath.cubicTo(36.693905f, 29.821022f, 39.5f, 35.939213f, 39.5f, 42.712807f);
                instancePath.cubicTo(39.5f, 49.280643f, 36.86179f, 55.232292f, 32.587296f, 59.565834f);
                instancePath.lineTo(40.01204f, 66.99058f);
                instancePath.close();
                instancePath.moveTo(13.0f, 55.5f);
                instancePath.cubicTo(20.1797f, 55.5f, 26.0f, 49.679703f, 26.0f, 42.5f);
                instancePath.cubicTo(26.0f, 35.320297f, 20.1797f, 29.5f, 13.0f, 29.5f);
                instancePath.cubicTo(5.820298f, 29.5f, 0.0f, 35.320297f, 0.0f, 42.5f);
                instancePath.cubicTo(0.0f, 49.679703f, 5.820298f, 55.5f, 13.0f, 55.5f);
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
