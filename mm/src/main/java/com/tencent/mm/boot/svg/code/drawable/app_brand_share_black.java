package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_share_black extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-13882324);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -333.0f, 0.0f, 1.0f, -317.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 333.0f, 0.0f, 1.0f, 317.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(67.0f, 69.0f);
                instancePath.lineTo(21.0f, 69.0f);
                instancePath.lineTo(21.0f, 35.0f);
                instancePath.lineTo(30.521f, 35.0f);
                instancePath.cubicTo(31.823f, 32.063f, 33.368f, 29.769f, 35.079f, 28.0f);
                instancePath.lineTo(17.0f, 28.0f);
                instancePath.cubicTo(15.343f, 28.0f, 14.0f, 29.343f, 14.0f, 31.0f);
                instancePath.lineTo(14.0f, 73.0f);
                instancePath.cubicTo(14.0f, 74.657f, 15.343f, 76.0f, 17.0f, 76.0f);
                instancePath.lineTo(71.0f, 76.0f);
                instancePath.cubicTo(72.656f, 76.0f, 74.0f, 74.657f, 74.0f, 73.0f);
                instancePath.lineTo(74.0f, 51.22f);
                instancePath.lineTo(67.0f, 57.13f);
                instancePath.lineTo(67.0f, 69.0f);
                instancePath.lineTo(67.0f, 69.0f);
                instancePath.close();
                instancePath.moveTo(59.0f, 17.0f);
                instancePath.lineTo(59.0f, 28.019f);
                instancePath.cubicTo(57.325f, 28.008f, 55.583f, 28.0f, 54.0f, 28.0f);
                instancePath.cubicTo(40.334f, 28.0f, 31.055f, 41.333f, 31.055f, 59.0f);
                instancePath.cubicTo(35.721f, 48.16f, 40.284f, 43.0f, 59.0f, 43.0f);
                instancePath.lineTo(59.0f, 54.0f);
                instancePath.lineTo(73.452f, 41.848f);
                instancePath.lineTo(74.0f, 42.357f);
                instancePath.lineTo(74.0f, 41.386f);
                instancePath.lineTo(81.0f, 35.5f);
                instancePath.lineTo(59.0f, 17.0f);
                instancePath.lineTo(59.0f, 17.0f);
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
