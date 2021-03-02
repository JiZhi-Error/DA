package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class actionbar_more_landscape extends c {
    private final int height = 90;
    private final int width = 90;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -245.0f, 0.0f, 1.0f, -283.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 245.0f, 0.0f, 1.0f, 283.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(2113929216);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(90.0f, 0.0f);
                instancePath.lineTo(90.0f, 90.0f);
                instancePath.lineTo(0.0f, 90.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(45.0f, 27.0f);
                instancePath2.cubicTo(47.761425f, 27.0f, 50.0f, 24.761423f, 50.0f, 22.0f);
                instancePath2.cubicTo(50.0f, 19.238577f, 47.761425f, 17.0f, 45.0f, 17.0f);
                instancePath2.cubicTo(42.238575f, 17.0f, 40.0f, 19.238577f, 40.0f, 22.0f);
                instancePath2.cubicTo(40.0f, 24.761423f, 42.238575f, 27.0f, 45.0f, 27.0f);
                instancePath2.close();
                instancePath2.moveTo(45.0f, 50.0f);
                instancePath2.cubicTo(47.761425f, 50.0f, 50.0f, 47.761425f, 50.0f, 45.0f);
                instancePath2.cubicTo(50.0f, 42.238575f, 47.761425f, 40.0f, 45.0f, 40.0f);
                instancePath2.cubicTo(42.238575f, 40.0f, 40.0f, 42.238575f, 40.0f, 45.0f);
                instancePath2.cubicTo(40.0f, 47.761425f, 42.238575f, 50.0f, 45.0f, 50.0f);
                instancePath2.close();
                instancePath2.moveTo(45.0f, 73.0f);
                instancePath2.cubicTo(47.761425f, 73.0f, 50.0f, 70.76142f, 50.0f, 68.0f);
                instancePath2.cubicTo(50.0f, 65.23858f, 47.761425f, 63.0f, 45.0f, 63.0f);
                instancePath2.cubicTo(42.238575f, 63.0f, 40.0f, 65.23858f, 40.0f, 68.0f);
                instancePath2.cubicTo(40.0f, 70.76142f, 42.238575f, 73.0f, 45.0f, 73.0f);
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
