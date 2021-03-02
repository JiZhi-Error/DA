package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_launcher_actionbar_search extends c {
    private final int height = 58;
    private final int width = 58;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 58;
            case 1:
                return 58;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -249.0f, 0.0f, 1.0f, -79.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 0.70710677f, 0.70710677f, 4.6425705f, -0.70710677f, 0.70710677f, 229.20816f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(277.0f, 118.906f);
                instancePath.lineTo(277.0f, 141.0f);
                instancePath.lineTo(283.0f, 141.0f);
                instancePath.lineTo(283.0f, 118.61951f);
                instancePath.cubicTo(292.68488f, 116.751785f, 300.0f, 108.23016f, 300.0f, 98.0f);
                instancePath.cubicTo(300.0f, 86.40202f, 290.598f, 77.0f, 279.0f, 77.0f);
                instancePath.cubicTo(267.402f, 77.0f, 258.0f, 86.40202f, 258.0f, 98.0f);
                instancePath.cubicTo(258.0f, 108.92341f, 266.34015f, 117.89888f, 277.0f, 118.906f);
                instancePath.close();
                instancePath.moveTo(279.0f, 113.0f);
                instancePath.cubicTo(287.28427f, 113.0f, 294.0f, 106.28427f, 294.0f, 98.0f);
                instancePath.cubicTo(294.0f, 89.71573f, 287.28427f, 83.0f, 279.0f, 83.0f);
                instancePath.cubicTo(270.71573f, 83.0f, 264.0f, 89.71573f, 264.0f, 98.0f);
                instancePath.cubicTo(264.0f, 106.28427f, 270.71573f, 113.0f, 279.0f, 113.0f);
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
