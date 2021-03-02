package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class round_cancel_btn_pressed extends c {
    private final int height = 120;
    private final int width = 120;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 10.0f, 0.0f, 1.0f, 10.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(Integer.MIN_VALUE);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(50.0f, 94.0f);
                instancePath.cubicTo(74.30053f, 94.0f, 94.0f, 74.30053f, 94.0f, 50.0f);
                instancePath.cubicTo(94.0f, 25.69947f, 74.30053f, 6.0f, 50.0f, 6.0f);
                instancePath.cubicTo(25.69947f, 6.0f, 6.0f, 25.69947f, 6.0f, 50.0f);
                instancePath.cubicTo(6.0f, 74.30053f, 25.69947f, 94.0f, 50.0f, 94.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(50.0f, 100.0f);
                instancePath2.cubicTo(22.385763f, 100.0f, 0.0f, 77.614235f, 0.0f, 50.0f);
                instancePath2.cubicTo(0.0f, 22.385763f, 22.385763f, 0.0f, 50.0f, 0.0f);
                instancePath2.cubicTo(77.614235f, 0.0f, 100.0f, 22.385763f, 100.0f, 50.0f);
                instancePath2.cubicTo(100.0f, 77.614235f, 77.614235f, 100.0f, 50.0f, 100.0f);
                instancePath2.close();
                instancePath2.moveTo(50.0f, 94.0f);
                instancePath2.cubicTo(74.30053f, 94.0f, 94.0f, 74.30053f, 94.0f, 50.0f);
                instancePath2.cubicTo(94.0f, 25.69947f, 74.30053f, 6.0f, 50.0f, 6.0f);
                instancePath2.cubicTo(25.69947f, 6.0f, 6.0f, 25.69947f, 6.0f, 50.0f);
                instancePath2.cubicTo(6.0f, 74.30053f, 25.69947f, 94.0f, 50.0f, 94.0f);
                instancePath2.close();
                instancePath2.moveTo(54.24264f, 49.999996f);
                instancePath2.lineTo(69.79899f, 65.55635f);
                instancePath2.lineTo(65.55635f, 69.79899f);
                instancePath2.lineTo(50.0f, 54.242638f);
                instancePath2.lineTo(34.44365f, 69.79899f);
                instancePath2.lineTo(30.20101f, 65.55635f);
                instancePath2.lineTo(45.75736f, 49.999996f);
                instancePath2.lineTo(30.201012f, 34.44365f);
                instancePath2.lineTo(34.443653f, 30.20101f);
                instancePath2.lineTo(50.0f, 45.757355f);
                instancePath2.lineTo(65.55635f, 30.20101f);
                instancePath2.lineTo(69.79899f, 34.44365f);
                instancePath2.lineTo(54.24264f, 49.999996f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
