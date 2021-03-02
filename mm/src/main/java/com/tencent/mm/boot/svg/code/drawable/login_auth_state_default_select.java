package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class login_auth_state_default_select extends c {
    private final int height = 48;
    private final int width = 48;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                instancePaint3.setColor(-15028967);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -69.0f, 0.0f, 1.0f, -98.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 69.0f, 0.0f, 1.0f, 98.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 6.0063868f);
                instancePath.cubicTo(0.0f, 2.6891508f, 2.6835413f, 0.0f, 6.0063868f, 0.0f);
                instancePath.lineTo(41.993614f, 0.0f);
                instancePath.cubicTo(45.31085f, 0.0f, 48.0f, 2.6835413f, 48.0f, 6.0063868f);
                instancePath.lineTo(48.0f, 41.993614f);
                instancePath.cubicTo(48.0f, 45.31085f, 45.31646f, 48.0f, 41.993614f, 48.0f);
                instancePath.lineTo(6.0063868f, 48.0f);
                instancePath.cubicTo(2.6891508f, 48.0f, 0.0f, 45.31646f, 0.0f, 41.993614f);
                instancePath.lineTo(0.0f, 6.0063868f);
                instancePath.lineTo(0.0f, 6.0063868f);
                instancePath.close();
                instancePath.moveTo(6.0f, 26.576923f);
                instancePath.lineTo(10.2f, 22.538462f);
                instancePath.lineTo(19.0f, 30.923077f);
                instancePath.lineTo(37.8f, 13.0f);
                instancePath.lineTo(42.0f, 17.038462f);
                instancePath.lineTo(19.0f, 39.0f);
                instancePath.lineTo(6.0f, 26.576923f);
                instancePath.lineTo(6.0f, 26.576923f);
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
