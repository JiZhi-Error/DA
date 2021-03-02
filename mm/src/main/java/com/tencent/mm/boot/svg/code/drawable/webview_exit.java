package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class webview_exit extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -127.0f, 0.0f, 1.0f, -128.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 127.0f, 0.0f, 1.0f, 128.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-9276814);
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 5.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(78.0f, 47.0f);
                instancePath.cubicTo(78.0f, 68.53911f, 60.539104f, 86.0f, 39.0f, 86.0f);
                instancePath.cubicTo(17.460896f, 86.0f, 0.0f, 68.53911f, 0.0f, 47.0f);
                instancePath.cubicTo(0.0f, 29.647755f, 11.332416f, 14.942338f, 27.0f, 9.880997f);
                instancePath.lineTo(27.0f, 18.408052f);
                instancePath.cubicTo(15.838201f, 23.098259f, 8.0f, 34.133774f, 8.0f, 47.0f);
                instancePath.cubicTo(8.0f, 64.12083f, 21.879173f, 78.0f, 39.0f, 78.0f);
                instancePath.cubicTo(56.120827f, 78.0f, 70.0f, 64.12083f, 70.0f, 47.0f);
                instancePath.cubicTo(70.0f, 34.133774f, 62.1618f, 23.098259f, 51.0f, 18.408056f);
                instancePath.lineTo(51.0f, 9.880997f);
                instancePath.cubicTo(66.66759f, 14.942338f, 78.0f, 29.647755f, 78.0f, 47.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(35.0f, 2.0f);
                instancePath2.cubicTo(35.0f, 0.89543045f, 35.89543f, 0.0f, 37.0f, 0.0f);
                instancePath2.lineTo(42.0f, 0.0f);
                instancePath2.cubicTo(43.10457f, 0.0f, 44.0f, 0.89543045f, 44.0f, 2.0f);
                instancePath2.lineTo(44.0f, 28.0f);
                instancePath2.cubicTo(44.0f, 29.10457f, 43.10457f, 30.0f, 42.0f, 30.0f);
                instancePath2.lineTo(37.0f, 30.0f);
                instancePath2.cubicTo(35.89543f, 30.0f, 35.0f, 29.10457f, 35.0f, 28.0f);
                instancePath2.lineTo(35.0f, 2.0f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint5);
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
