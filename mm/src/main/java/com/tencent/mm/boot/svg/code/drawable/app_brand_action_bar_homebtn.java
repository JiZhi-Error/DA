package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_action_bar_homebtn extends c {
    private final int height = 61;
    private final int width = 68;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 68;
            case 1:
                return 61;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -296.0f, 0.0f, 1.0f, -485.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 295.0f, 0.0f, 1.0f, 485.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(53.0f, 31.0f);
                instancePath.lineTo(59.0f, 31.0f);
                instancePath.lineTo(38.0f, 9.956522f);
                instancePath.lineTo(36.0f, 8.043478f);
                instancePath.lineTo(12.0f, 31.0f);
                instancePath.lineTo(17.0f, 31.0f);
                instancePath.lineTo(17.0f, 55.04348f);
                instancePath.lineTo(53.0f, 55.04348f);
                instancePath.lineTo(53.0f, 31.0f);
                instancePath.close();
                instancePath.moveTo(59.0f, 37.0f);
                instancePath.lineTo(59.0f, 59.001785f);
                instancePath.cubicTo(59.0f, 60.10537f, 58.10506f, 61.0f, 56.99861f, 61.0f);
                instancePath.lineTo(13.0013895f, 61.0f);
                instancePath.cubicTo(11.896052f, 61.0f, 11.0f, 60.105663f, 11.0f, 59.001785f);
                instancePath.lineTo(11.0f, 37.0f);
                instancePath.lineTo(3.993048f, 37.0f);
                instancePath.cubicTo(0.68317896f, 37.0f, -0.102572955f, 35.102573f, 2.2484722f, 32.75153f);
                instancePath.lineTo(33.17487f, 1.825131f);
                instancePath.cubicTo(34.735146f, 0.26485425f, 37.228786f, 0.29705298f, 38.750225f, 1.9030144f);
                instancePath.lineTo(67.870346f, 32.640915f);
                instancePath.cubicTo(70.15109f, 35.04837f, 69.322586f, 37.0f, 66.00695f, 37.0f);
                instancePath.lineTo(59.0f, 37.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(40.0f, 42.0f);
                instancePath2.lineTo(40.0f, 58.0f);
                instancePath2.lineTo(30.0f, 58.0f);
                instancePath2.lineTo(30.0f, 42.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
