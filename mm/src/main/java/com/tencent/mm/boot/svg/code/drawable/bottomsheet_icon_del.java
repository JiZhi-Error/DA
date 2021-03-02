package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_icon_del extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-8617851);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 8.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(53.00009f, 8.0f);
                instancePath.lineTo(45.00009f, 0.0f);
                instancePath.lineTo(20.00009f, 0.0f);
                instancePath.lineTo(12.000091f, 8.0f);
                instancePath.lineTo(9.0277776E-5f, 8.0f);
                instancePath.lineTo(9.0277776E-5f, 16.0f);
                instancePath.lineTo(65.00009f, 16.0f);
                instancePath.lineTo(65.00009f, 8.0f);
                instancePath.lineTo(53.00009f, 8.0f);
                instancePath.close();
                instancePath.moveTo(12.000091f, 67.0f);
                instancePath.lineTo(20.00009f, 67.0f);
                instancePath.lineTo(20.00009f, 31.0f);
                instancePath.lineTo(12.000091f, 31.0f);
                instancePath.lineTo(12.000091f, 67.0f);
                instancePath.close();
                instancePath.moveTo(28.00009f, 67.0f);
                instancePath.lineTo(36.00009f, 67.0f);
                instancePath.lineTo(36.00009f, 31.0f);
                instancePath.lineTo(28.00009f, 31.0f);
                instancePath.lineTo(28.00009f, 67.0f);
                instancePath.close();
                instancePath.moveTo(45.00009f, 67.0f);
                instancePath.lineTo(53.00009f, 67.0f);
                instancePath.lineTo(53.00009f, 31.0f);
                instancePath.lineTo(45.00009f, 31.0f);
                instancePath.lineTo(45.00009f, 67.0f);
                instancePath.close();
                instancePath.moveTo(4.00009f, 68.0f);
                instancePath.cubicTo(4.00009f, 74.53162f, 9.468924f, 80.0f, 16.00009f, 80.0f);
                instancePath.lineTo(49.00009f, 80.0f);
                instancePath.cubicTo(55.531708f, 80.0f, 61.00009f, 74.53162f, 61.00009f, 68.0f);
                instancePath.lineTo(61.00009f, 23.0f);
                instancePath.lineTo(4.00009f, 23.0f);
                instancePath.lineTo(4.00009f, 68.0f);
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
