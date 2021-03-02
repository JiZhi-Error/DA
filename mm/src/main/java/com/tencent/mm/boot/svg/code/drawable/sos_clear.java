package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sos_clear extends c {
    private final int height = 144;
    private final int width = 111;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 111;
            case 1:
                return 144;
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-3223858);
                instancePaint5.setColor(-3223858);
                instancePaint5.setStrokeWidth(0.6086956f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 36.0f, 0.0f, 1.0f, 55.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Paint instancePaint7 = c.instancePaint(instancePaint5, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(32.162163f, 34.0f);
                instancePath.lineTo(34.0f, 32.162163f);
                instancePath.lineTo(1.8378378f, 0.0f);
                instancePath.lineTo(0.0f, 1.8378378f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint6);
                canvas.drawPath(instancePath, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint4, looper);
                Paint instancePaint9 = c.instancePaint(instancePaint5, looper);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, -1.0f, 0.0f, 34.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(32.162163f, 34.0f);
                instancePath2.lineTo(34.0f, 32.162163f);
                instancePath2.lineTo(1.8378378f, 0.0f);
                instancePath2.lineTo(0.0f, 1.8378378f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint8);
                canvas.drawPath(instancePath2, instancePaint9);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
