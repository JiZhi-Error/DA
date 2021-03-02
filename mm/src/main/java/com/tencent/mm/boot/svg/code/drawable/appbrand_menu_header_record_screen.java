package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class appbrand_menu_header_record_screen extends c {
    private final int height = 9;
    private final int width = 13;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 13;
            case 1:
                return 9;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -286.0f, 0.0f, 1.0f, -424.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 279.0f, 0.0f, 1.0f, 417.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 4.7f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray4 = c.setMatrixFloatArray(matrixFloatArray3, 1.0f, 0.0f, 1.166667f, 0.0f, 1.0f, 2.916667f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray4);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.5833333f, 0.29166666f);
                instancePath.lineTo(8.166667f, 0.29166666f);
                instancePath.cubicTo(8.488832f, 0.29166666f, 8.75f, 0.5528339f, 8.75f, 0.875f);
                instancePath.lineTo(8.75f, 7.2916665f);
                instancePath.cubicTo(8.75f, 7.613833f, 8.488832f, 7.875f, 8.166667f, 7.875f);
                instancePath.lineTo(0.5833333f, 7.875f);
                instancePath.cubicTo(0.26116723f, 7.875f, -2.9361293E-16f, 7.613833f, 0.0f, 7.2916665f);
                instancePath.lineTo(0.0f, 0.875f);
                instancePath.cubicTo(-3.9453968E-17f, 0.5528339f, 0.26116723f, 0.29166666f, 0.5833333f, 0.29166666f);
                instancePath.close();
                instancePath.moveTo(9.333333f, 2.9166667f);
                instancePath.lineTo(11.302261f, 1.3415244f);
                instancePath.cubicTo(11.553831f, 1.1402688f, 11.9209175f, 1.1810563f, 12.122173f, 1.4326258f);
                instancePath.cubicTo(12.20492f, 1.5360583f, 12.25f, 1.6645728f, 12.25f, 1.7970312f);
                instancePath.lineTo(12.25f, 6.3696356f);
                instancePath.cubicTo(12.25f, 6.6918015f, 11.988832f, 6.952969f, 11.666667f, 6.952969f);
                instancePath.cubicTo(11.534208f, 6.952969f, 11.405694f, 6.9078884f, 11.302261f, 6.8251424f);
                instancePath.lineTo(9.333333f, 5.25f);
                instancePath.lineTo(9.333333f, 2.9166667f);
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
