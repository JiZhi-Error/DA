package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_menu_copy_path extends c {
    private final int height = 32;
    private final int width = 32;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 32;
            case 1:
                return 32;
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -77.0f, 0.0f, 1.0f, -93.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 77.0f, 0.0f, 1.0f, 93.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(13.866667f, 4.0f);
                instancePath.lineTo(5.866667f, 26.666666f);
                instancePath.lineTo(4.0f, 26.666666f);
                instancePath.lineTo(12.0f, 4.0f);
                instancePath.lineTo(13.866667f, 4.0f);
                instancePath.close();
                instancePath.moveTo(12.8f, 24.0f);
                instancePath.cubicTo(13.53638f, 24.0f, 14.133333f, 24.596954f, 14.133333f, 25.333334f);
                instancePath.cubicTo(14.133333f, 26.069714f, 13.53638f, 26.666666f, 12.8f, 26.666666f);
                instancePath.cubicTo(12.063621f, 26.666666f, 11.466667f, 26.069714f, 11.466667f, 25.333334f);
                instancePath.cubicTo(11.466667f, 24.596954f, 12.063621f, 24.0f, 12.8f, 24.0f);
                instancePath.close();
                instancePath.moveTo(19.733334f, 24.0f);
                instancePath.cubicTo(20.469713f, 24.0f, 21.066668f, 24.596954f, 21.066668f, 25.333334f);
                instancePath.cubicTo(21.066668f, 26.069714f, 20.469713f, 26.666666f, 19.733334f, 26.666666f);
                instancePath.cubicTo(18.996954f, 26.666666f, 18.4f, 26.069714f, 18.4f, 25.333334f);
                instancePath.cubicTo(18.4f, 24.596954f, 18.996954f, 24.0f, 19.733334f, 24.0f);
                instancePath.close();
                instancePath.moveTo(26.666666f, 24.0f);
                instancePath.cubicTo(27.403046f, 24.0f, 28.0f, 24.596954f, 28.0f, 25.333334f);
                instancePath.cubicTo(28.0f, 26.069714f, 27.403046f, 26.666666f, 26.666666f, 26.666666f);
                instancePath.cubicTo(25.930286f, 26.666666f, 25.333334f, 26.069714f, 25.333334f, 25.333334f);
                instancePath.cubicTo(25.333334f, 24.596954f, 25.930286f, 24.0f, 26.666666f, 24.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
