package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class c2c_received_icon extends c {
    private final int height = 102;
    private final int width = 102;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 102;
            case 1:
                return 102;
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
                instancePaint3.setColor(-1);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(51.0f, 102.0f);
                instancePath.cubicTo(79.16652f, 102.0f, 102.0f, 79.16652f, 102.0f, 51.0f);
                instancePath.cubicTo(102.0f, 22.833477f, 79.16652f, 0.0f, 51.0f, 0.0f);
                instancePath.cubicTo(22.833477f, 0.0f, 0.0f, 22.833477f, 0.0f, 51.0f);
                instancePath.cubicTo(0.0f, 79.16652f, 22.833477f, 102.0f, 51.0f, 102.0f);
                instancePath.close();
                instancePath.moveTo(51.0f, 98.0f);
                instancePath.cubicTo(76.95738f, 98.0f, 98.0f, 76.95738f, 98.0f, 51.0f);
                instancePath.cubicTo(98.0f, 25.042616f, 76.95738f, 4.0f, 51.0f, 4.0f);
                instancePath.cubicTo(25.042616f, 4.0f, 4.0f, 25.042616f, 4.0f, 51.0f);
                instancePath.cubicTo(4.0f, 76.95738f, 25.042616f, 98.0f, 51.0f, 98.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 6.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 12.65625f, 0.0f, 1.0f, 21.515625f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(1.8785756f, 23.757034f);
                instancePath2.cubicTo(1.2973921f, 23.163979f, 1.223493f, 22.150276f, 1.7250522f, 21.477392f);
                instancePath2.lineTo(3.0639734f, 19.681114f);
                instancePath2.cubicTo(3.5603683f, 19.015158f, 4.4945054f, 18.877115f, 5.1620426f, 19.381565f);
                instancePath2.lineTo(18.21077f, 29.242313f);
                instancePath2.cubicTo(18.873106f, 29.742832f, 19.922352f, 29.727772f, 20.574799f, 29.191858f);
                instancePath2.lineTo(54.486485f, 1.3371443f);
                instancePath2.cubicTo(55.12977f, 0.8087597f, 56.12762f, 0.8442794f, 56.730663f, 1.4314854f);
                instancePath2.lineTo(57.70836f, 2.3835058f);
                instancePath2.cubicTo(58.304504f, 2.9639935f, 58.30409f, 3.9039125f, 57.71406f, 4.4764366f);
                instancePath2.lineTo(20.482594f, 40.603558f);
                instancePath2.cubicTo(19.889599f, 41.178963f, 18.940239f, 41.167206f, 18.356556f, 40.5716f);
                instancePath2.lineTo(1.8785756f, 23.757034f);
                instancePath2.close();
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
