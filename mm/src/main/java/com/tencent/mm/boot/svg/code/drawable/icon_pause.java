package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icon_pause extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -164.0f, 0.0f, 1.0f, -81.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 164.0f, 0.0f, 1.0f, 81.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(48.0f, 0.0f);
                instancePath.lineTo(48.0f, 48.0f);
                instancePath.lineTo(0.0f, 48.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(17.0f, 8.0f);
                instancePath2.cubicTo(17.552284f, 8.0f, 18.0f, 8.447715f, 18.0f, 9.0f);
                instancePath2.lineTo(18.0f, 39.0f);
                instancePath2.cubicTo(18.0f, 39.552284f, 17.552284f, 40.0f, 17.0f, 40.0f);
                instancePath2.lineTo(7.0f, 40.0f);
                instancePath2.cubicTo(6.4477153f, 40.0f, 6.0f, 39.552284f, 6.0f, 39.0f);
                instancePath2.lineTo(6.0f, 9.0f);
                instancePath2.cubicTo(6.0f, 8.447715f, 6.4477153f, 8.0f, 7.0f, 8.0f);
                instancePath2.lineTo(17.0f, 8.0f);
                instancePath2.close();
                instancePath2.moveTo(41.0f, 8.0f);
                instancePath2.cubicTo(41.552284f, 8.0f, 42.0f, 8.447715f, 42.0f, 9.0f);
                instancePath2.lineTo(42.0f, 39.0f);
                instancePath2.cubicTo(42.0f, 39.552284f, 41.552284f, 40.0f, 41.0f, 40.0f);
                instancePath2.lineTo(31.0f, 40.0f);
                instancePath2.cubicTo(30.447716f, 40.0f, 30.0f, 39.552284f, 30.0f, 39.0f);
                instancePath2.lineTo(30.0f, 9.0f);
                instancePath2.cubicTo(30.0f, 8.447715f, 30.447716f, 8.0f, 31.0f, 8.0f);
                instancePath2.lineTo(41.0f, 8.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}