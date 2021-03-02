package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class actionbar_search_icon extends c {
    private final int height = 96;
    private final int width = 79;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 79;
            case 1:
                return 96;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -9.0f, 0.0f, 1.0f, 8.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 0.70710677f, 0.70710677f, -16.991314f, -0.70710677f, 0.70710677f, 40.313557f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(43.16711f, 52.7369f);
                instancePath.cubicTo(54.452175f, 51.26688f, 63.16711f, 41.61657f, 63.16711f, 29.93078f);
                instancePath.cubicTo(63.16711f, 17.228231f, 52.86966f, 6.9307804f, 40.16711f, 6.9307804f);
                instancePath.cubicTo(27.46456f, 6.9307804f, 17.167109f, 17.228231f, 17.167109f, 29.93078f);
                instancePath.cubicTo(17.167109f, 41.61657f, 25.882044f, 51.26688f, 37.16711f, 52.7369f);
                instancePath.lineTo(37.16711f, 73.40037f);
                instancePath.cubicTo(37.16711f, 73.954346f, 37.618084f, 74.403435f, 38.157887f, 74.403435f);
                instancePath.lineTo(42.17633f, 74.403435f);
                instancePath.cubicTo(42.723522f, 74.403435f, 43.16711f, 73.964516f, 43.16711f, 73.40037f);
                instancePath.lineTo(43.16711f, 52.7369f);
                instancePath.lineTo(43.16711f, 52.7369f);
                instancePath.close();
                instancePath.moveTo(40.16711f, 46.930782f);
                instancePath.cubicTo(49.55595f, 46.930782f, 57.16711f, 39.319622f, 57.16711f, 29.93078f);
                instancePath.cubicTo(57.16711f, 20.54194f, 49.55595f, 12.93078f, 40.16711f, 12.93078f);
                instancePath.cubicTo(30.778269f, 12.93078f, 23.167109f, 20.54194f, 23.167109f, 29.93078f);
                instancePath.cubicTo(23.167109f, 39.319622f, 30.778269f, 46.930782f, 40.16711f, 46.930782f);
                instancePath.lineTo(40.16711f, 46.930782f);
                instancePath.lineTo(40.16711f, 46.930782f);
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
