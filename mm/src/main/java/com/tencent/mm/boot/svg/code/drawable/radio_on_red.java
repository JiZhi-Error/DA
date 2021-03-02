package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class radio_on_red extends c {
    private final int height = 60;
    private final int width = 60;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                instancePaint3.setColor(-899014);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -218.0f, 0.0f, 1.0f, -230.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 224.0f, 0.0f, 1.0f, 236.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 24.0f);
                instancePath.cubicTo(0.0f, 10.8f, 10.8f, 0.0f, 24.0f, 0.0f);
                instancePath.cubicTo(37.2f, 0.0f, 48.0f, 10.8f, 48.0f, 24.0f);
                instancePath.cubicTo(48.0f, 37.2f, 37.2f, 48.0f, 24.0f, 48.0f);
                instancePath.cubicTo(10.8f, 48.0f, 0.0f, 37.2f, 0.0f, 24.0f);
                instancePath.close();
                instancePath.moveTo(4.0f, 24.0f);
                instancePath.cubicTo(4.0f, 35.0f, 13.0f, 44.0f, 24.0f, 44.0f);
                instancePath.cubicTo(35.0f, 44.0f, 44.0f, 35.0f, 44.0f, 24.0f);
                instancePath.cubicTo(44.0f, 13.0f, 35.0f, 4.0f, 24.0f, 4.0f);
                instancePath.cubicTo(13.0f, 4.0f, 4.0f, 13.0f, 4.0f, 24.0f);
                instancePath.close();
                instancePath.moveTo(10.0f, 24.0f);
                instancePath.cubicTo(10.0f, 31.7f, 16.3f, 38.0f, 24.0f, 38.0f);
                instancePath.cubicTo(31.7f, 38.0f, 38.0f, 31.7f, 38.0f, 24.0f);
                instancePath.cubicTo(38.0f, 16.3f, 31.7f, 10.0f, 24.0f, 10.0f);
                instancePath.cubicTo(16.3f, 10.0f, 10.0f, 16.3f, 10.0f, 24.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
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
