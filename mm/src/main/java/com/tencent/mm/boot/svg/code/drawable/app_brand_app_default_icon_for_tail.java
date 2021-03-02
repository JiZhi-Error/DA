package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_app_default_icon_for_tail extends c {
    private final int height = 40;
    private final int width = 40;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 40;
            case 1:
                return 40;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -637.0f, 0.0f, 1.0f, -1392.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 637.0f, 0.0f, 1.0f, 1392.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-921103);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(40.0f, 0.0f);
                instancePath.lineTo(40.0f, 40.0f);
                instancePath.lineTo(0.0f, 40.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-3552823);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(16.955261f, 20.434963f);
                instancePath2.cubicTo(18.24053f, 22.476675f, 16.106638f, 23.401121f, 15.21541f, 23.914665f);
                instancePath2.cubicTo(11.381262f, 26.095942f, 9.705882f, 26.912895f, 9.705882f, 27.974316f);
                instancePath2.lineTo(9.705882f, 29.424192f);
                instancePath2.cubicTo(9.705882f, 29.890316f, 10.054523f, 30.294117f, 10.575808f, 30.294117f);
                instancePath2.lineTo(29.424192f, 30.294117f);
                instancePath2.cubicTo(29.945477f, 30.294117f, 30.294117f, 29.890316f, 30.294117f, 29.424192f);
                instancePath2.lineTo(30.294117f, 27.974316f);
                instancePath2.cubicTo(30.294117f, 26.912895f, 28.618738f, 26.095942f, 24.78459f, 23.914665f);
                instancePath2.cubicTo(23.893362f, 23.401121f, 21.75947f, 22.476675f, 23.044739f, 20.434963f);
                instancePath2.cubicTo(24.186148f, 18.739943f, 25.076778f, 18.04949f, 25.074566f, 15.21541f);
                instancePath2.cubicTo(25.076778f, 12.524936f, 23.08713f, 9.705882f, 20.144987f, 9.705882f);
                instancePath2.cubicTo(16.91287f, 9.705882f, 14.923222f, 12.524936f, 14.925435f, 15.21541f);
                instancePath2.cubicTo(14.923222f, 18.04949f, 15.813852f, 18.739943f, 16.955261f, 20.434963f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
