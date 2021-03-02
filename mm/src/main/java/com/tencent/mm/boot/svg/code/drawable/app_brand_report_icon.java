package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_report_icon extends c {
    private final int height = 41;
    private final int width = 47;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 47;
            case 1:
                return 41;
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -126.0f, 0.0f, 1.0f, -1631.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 127.0f, 0.0f, 1.0f, 1631.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-10526881);
                instancePaint4.setStrokeWidth(6.0f);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.27375567f, 36.99819f);
                instancePath.cubicTo(-0.9820049f, 39.20833f, 0.05327524f, 41.0f, 2.6142578f, 41.0f);
                instancePath.lineTo(43.385742f, 41.0f);
                instancePath.cubicTo(45.934128f, 41.0f, 46.981197f, 39.20691f, 45.726246f, 36.99819f);
                instancePath.lineTo(25.273756f, 1.00181f);
                instancePath.cubicTo(24.017996f, -1.2083286f, 21.981197f, -1.2069088f, 20.726244f, 1.00181f);
                instancePath.lineTo(0.27375567f, 36.99819f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-10526881);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(22.22413f, 14.0f);
                instancePath2.cubicTo(21.548061f, 14.0f, 21.041523f, 14.548094f, 21.093502f, 15.234215f);
                instancePath2.lineTo(22.120932f, 28.7963f);
                instancePath2.cubicTo(22.14619f, 29.129715f, 22.437256f, 29.4f, 22.777334f, 29.4f);
                instancePath2.lineTo(22.722666f, 29.4f);
                instancePath2.cubicTo(23.059927f, 29.4f, 23.353582f, 29.132704f, 23.379068f, 28.7963f);
                instancePath2.lineTo(24.406498f, 15.234215f);
                instancePath2.cubicTo(24.458138f, 14.552577f, 23.953125f, 14.0f, 23.27587f, 14.0f);
                instancePath2.lineTo(22.22413f, 14.0f);
                instancePath2.close();
                instancePath2.moveTo(23.0f, 35.0f);
                instancePath2.cubicTo(24.10457f, 35.0f, 25.0f, 34.10457f, 25.0f, 33.0f);
                instancePath2.cubicTo(25.0f, 31.89543f, 24.10457f, 31.0f, 23.0f, 31.0f);
                instancePath2.cubicTo(21.89543f, 31.0f, 21.0f, 31.89543f, 21.0f, 33.0f);
                instancePath2.cubicTo(21.0f, 34.10457f, 21.89543f, 35.0f, 23.0f, 35.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
