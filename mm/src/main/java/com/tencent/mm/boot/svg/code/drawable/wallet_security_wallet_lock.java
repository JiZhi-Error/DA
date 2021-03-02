package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class wallet_security_wallet_lock extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 5.0f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 0.333333f, 0.0f, 1.0f, 0.666667f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-15432210);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(10.666667f, 0.53333336f);
                instancePath.cubicTo(14.790393f, 0.53333336f, 18.133333f, 3.8762739f, 18.133333f, 8.0f);
                instancePath.cubicTo(18.133333f, 8.441828f, 17.775162f, 8.8f, 17.333334f, 8.8f);
                instancePath.cubicTo(16.891506f, 8.8f, 16.533333f, 8.441828f, 16.533333f, 8.0f);
                instancePath.cubicTo(16.533333f, 4.7599297f, 13.906737f, 2.1333334f, 10.666667f, 2.1333334f);
                instancePath.cubicTo(7.500234f, 2.1333334f, 4.919708f, 4.6418953f, 4.8040466f, 7.7800603f);
                instancePath.lineTo(4.8f, 8.0f);
                instancePath.lineTo(4.8f, 10.666667f);
                instancePath.lineTo(20.133333f, 10.666667f);
                instancePath.cubicTo(20.796076f, 10.666667f, 21.333334f, 11.203925f, 21.333334f, 11.866667f);
                instancePath.lineTo(21.333334f, 25.466667f);
                instancePath.cubicTo(21.333334f, 26.129408f, 20.796076f, 26.666666f, 20.133333f, 26.666666f);
                instancePath.lineTo(1.2f, 26.666666f);
                instancePath.cubicTo(0.5372583f, 26.666666f, 0.0f, 26.129408f, 0.0f, 25.466667f);
                instancePath.lineTo(0.0f, 11.866667f);
                instancePath.cubicTo(0.0f, 11.203925f, 0.5372583f, 10.666667f, 1.2f, 10.666667f);
                instancePath.lineTo(3.2f, 10.666667f);
                instancePath.lineTo(3.2f, 8.0f);
                instancePath.cubicTo(3.2f, 3.8762739f, 6.5429406f, 0.53333336f, 10.666667f, 0.53333336f);
                instancePath.close();
                instancePath.moveTo(19.733334f, 12.266666f);
                instancePath.lineTo(1.6f, 12.266666f);
                instancePath.lineTo(1.6f, 25.066668f);
                instancePath.lineTo(19.733334f, 25.066668f);
                instancePath.lineTo(19.733334f, 12.266666f);
                instancePath.close();
                instancePath.moveTo(15.455034f, 14.747661f);
                instancePath.lineTo(16.544966f, 15.919006f);
                instancePath.lineTo(9.380325f, 22.585672f);
                instancePath.cubicTo(9.073209f, 22.871443f, 8.597509f, 22.871443f, 8.290394f, 22.585672f);
                instancePath.lineTo(4.7883677f, 19.327053f);
                instancePath.lineTo(5.878299f, 18.155708f);
                instancePath.lineTo(8.83536f, 20.90724f);
                instancePath.lineTo(15.455034f, 14.747661f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(0.0f, 0.0f);
                instancePath2.lineTo(32.0f, 0.0f);
                instancePath2.lineTo(32.0f, 32.0f);
                instancePath2.lineTo(0.0f, 32.0f);
                instancePath2.lineTo(0.0f, 0.0f);
                instancePath2.close();
                c.done(looper);
                break;
        }
        return 0;
    }
}
