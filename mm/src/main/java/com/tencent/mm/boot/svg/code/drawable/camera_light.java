package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class camera_light extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 12.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(37.073338f, 3.6f);
                instancePath.lineTo(22.926662f, 3.6f);
                instancePath.lineTo(16.926662f, 12.6f);
                instancePath.lineTo(3.6f, 12.6f);
                instancePath.lineTo(3.6f, 44.4f);
                instancePath.lineTo(56.4f, 44.4f);
                instancePath.lineTo(56.4f, 12.6f);
                instancePath.lineTo(43.073338f, 12.6f);
                instancePath.lineTo(37.073338f, 3.6f);
                instancePath.close();
                instancePath.moveTo(38.197224f, 0.0f);
                instancePath.cubicTo(38.698753f, 1.3322676E-15f, 39.167103f, 0.25065172f, 39.4453f, 0.6679497f);
                instancePath.lineTo(45.0f, 9.0f);
                instancePath.lineTo(57.0f, 9.0f);
                instancePath.cubicTo(58.656853f, 9.0f, 60.0f, 10.343145f, 60.0f, 12.0f);
                instancePath.lineTo(60.0f, 45.0f);
                instancePath.cubicTo(60.0f, 46.656853f, 58.656853f, 48.0f, 57.0f, 48.0f);
                instancePath.lineTo(3.0f, 48.0f);
                instancePath.cubicTo(1.3431457f, 48.0f, 0.0f, 46.656853f, 0.0f, 45.0f);
                instancePath.lineTo(0.0f, 12.0f);
                instancePath.cubicTo(0.0f, 10.343145f, 1.3431457f, 9.0f, 3.0f, 9.0f);
                instancePath.lineTo(15.0f, 9.0f);
                instancePath.lineTo(20.5547f, 0.6679497f);
                instancePath.cubicTo(20.8329f, 0.25065172f, 21.301247f, 2.6645353E-15f, 21.802776f, 2.6645353E-15f);
                instancePath.lineTo(38.197224f, 0.0f);
                instancePath.close();
                instancePath.moveTo(30.0f, 35.4f);
                instancePath.cubicTo(34.63919f, 35.4f, 38.4f, 31.639193f, 38.4f, 27.0f);
                instancePath.cubicTo(38.4f, 22.360807f, 34.63919f, 18.6f, 30.0f, 18.6f);
                instancePath.cubicTo(25.360807f, 18.6f, 21.6f, 22.360807f, 21.6f, 27.0f);
                instancePath.cubicTo(21.6f, 31.639193f, 25.360807f, 35.4f, 30.0f, 35.4f);
                instancePath.close();
                instancePath.moveTo(30.0f, 39.0f);
                instancePath.cubicTo(23.372583f, 39.0f, 18.0f, 33.62742f, 18.0f, 27.0f);
                instancePath.cubicTo(18.0f, 20.372583f, 23.372583f, 15.0f, 30.0f, 15.0f);
                instancePath.cubicTo(36.62742f, 15.0f, 42.0f, 20.372583f, 42.0f, 27.0f);
                instancePath.cubicTo(42.0f, 33.62742f, 36.62742f, 39.0f, 30.0f, 39.0f);
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
