package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class wallet_security_digital_certificate extends c {
    private final int height = 64;
    private final int width = 64;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 64;
            case 1:
                return 64;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 10.0f, 0.0f, 1.0f, 5.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 0.666667f, 0.0f, 1.0f, 0.333333f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-15616);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(40.0f, 0.0f);
                instancePath.cubicTo(41.47276f, 0.0f, 42.666668f, 1.1939074f, 42.666668f, 2.6666667f);
                instancePath.lineTo(42.666668f, 50.666668f);
                instancePath.cubicTo(42.666668f, 52.139427f, 41.47276f, 53.333332f, 40.0f, 53.333332f);
                instancePath.lineTo(2.6666667f, 53.333332f);
                instancePath.cubicTo(1.1939074f, 53.333332f, 0.0f, 52.139427f, 0.0f, 50.666668f);
                instancePath.lineTo(0.0f, 2.6666667f);
                instancePath.cubicTo(0.0f, 1.1939074f, 1.1939074f, 0.0f, 2.6666667f, 0.0f);
                instancePath.lineTo(40.0f, 0.0f);
                instancePath.close();
                instancePath.moveTo(39.466667f, 3.2f);
                instancePath.lineTo(3.2f, 3.2f);
                instancePath.lineTo(3.2f, 50.133335f);
                instancePath.lineTo(39.466667f, 50.133335f);
                instancePath.lineTo(39.466667f, 3.2f);
                instancePath.close();
                instancePath.moveTo(18.666666f, 18.666666f);
                instancePath.lineTo(18.666666f, 21.866667f);
                instancePath.lineTo(8.0f, 21.866667f);
                instancePath.lineTo(8.0f, 18.666666f);
                instancePath.lineTo(18.666666f, 18.666666f);
                instancePath.close();
                instancePath.moveTo(24.0f, 10.666667f);
                instancePath.lineTo(24.0f, 13.866667f);
                instancePath.lineTo(8.0f, 13.866667f);
                instancePath.lineTo(8.0f, 10.666667f);
                instancePath.lineTo(24.0f, 10.666667f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(0.0f, 0.0f);
                instancePath2.lineTo(64.0f, 0.0f);
                instancePath2.lineTo(64.0f, 64.0f);
                instancePath2.lineTo(0.0f, 64.0f);
                instancePath2.lineTo(0.0f, 0.0f);
                instancePath2.close();
                c.done(looper);
                break;
        }
        return 0;
    }
}
