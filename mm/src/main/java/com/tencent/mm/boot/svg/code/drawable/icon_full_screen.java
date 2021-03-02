package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icon_full_screen extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -327.0f, 0.0f, 1.0f, -162.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 162.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 311.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
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
                instancePath2.moveTo(31.0f, 26.0f);
                instancePath2.cubicTo(31.552284f, 26.0f, 32.0f, 26.447716f, 32.0f, 27.0f);
                instancePath2.lineTo(32.0f, 27.0f);
                instancePath2.lineTo(32.0f, 31.0f);
                instancePath2.cubicTo(32.0f, 31.552284f, 31.552284f, 32.0f, 31.0f, 32.0f);
                instancePath2.lineTo(31.0f, 32.0f);
                instancePath2.lineTo(27.0f, 32.0f);
                instancePath2.cubicTo(26.447716f, 32.0f, 26.0f, 31.552284f, 26.0f, 31.0f);
                instancePath2.cubicTo(26.0f, 30.447716f, 26.447716f, 30.0f, 27.0f, 30.0f);
                instancePath2.lineTo(27.0f, 30.0f);
                instancePath2.lineTo(30.0f, 30.0f);
                instancePath2.lineTo(30.0f, 27.0f);
                instancePath2.cubicTo(30.0f, 26.447716f, 30.447716f, 26.0f, 31.0f, 26.0f);
                instancePath2.close();
                instancePath2.moveTo(17.0f, 26.0f);
                instancePath2.cubicTo(17.552284f, 26.0f, 18.0f, 26.447716f, 18.0f, 27.0f);
                instancePath2.lineTo(18.0f, 30.0f);
                instancePath2.lineTo(21.0f, 30.0f);
                instancePath2.cubicTo(21.552284f, 30.0f, 22.0f, 30.447716f, 22.0f, 31.0f);
                instancePath2.cubicTo(22.0f, 31.552284f, 21.552284f, 32.0f, 21.0f, 32.0f);
                instancePath2.lineTo(17.0f, 32.0f);
                instancePath2.cubicTo(16.447716f, 32.0f, 16.0f, 31.552284f, 16.0f, 31.0f);
                instancePath2.lineTo(16.0f, 27.0f);
                instancePath2.cubicTo(16.0f, 26.447716f, 16.447716f, 26.0f, 17.0f, 26.0f);
                instancePath2.close();
                instancePath2.moveTo(21.0f, 16.0f);
                instancePath2.cubicTo(21.552284f, 16.0f, 22.0f, 16.447716f, 22.0f, 17.0f);
                instancePath2.cubicTo(22.0f, 17.552284f, 21.552284f, 18.0f, 21.0f, 18.0f);
                instancePath2.lineTo(21.0f, 18.0f);
                instancePath2.lineTo(18.0f, 18.0f);
                instancePath2.lineTo(18.0f, 21.0f);
                instancePath2.cubicTo(18.0f, 21.552284f, 17.552284f, 22.0f, 17.0f, 22.0f);
                instancePath2.cubicTo(16.447716f, 22.0f, 16.0f, 21.552284f, 16.0f, 21.0f);
                instancePath2.lineTo(16.0f, 21.0f);
                instancePath2.lineTo(16.0f, 17.0f);
                instancePath2.cubicTo(16.0f, 16.447716f, 16.447716f, 16.0f, 17.0f, 16.0f);
                instancePath2.lineTo(17.0f, 16.0f);
                instancePath2.close();
                instancePath2.moveTo(31.0f, 16.0f);
                instancePath2.cubicTo(31.552284f, 16.0f, 32.0f, 16.447716f, 32.0f, 17.0f);
                instancePath2.lineTo(32.0f, 21.0f);
                instancePath2.cubicTo(32.0f, 21.552284f, 31.552284f, 22.0f, 31.0f, 22.0f);
                instancePath2.cubicTo(30.447716f, 22.0f, 30.0f, 21.552284f, 30.0f, 21.0f);
                instancePath2.lineTo(30.0f, 18.0f);
                instancePath2.lineTo(27.0f, 18.0f);
                instancePath2.cubicTo(26.447716f, 18.0f, 26.0f, 17.552284f, 26.0f, 17.0f);
                instancePath2.cubicTo(26.0f, 16.447716f, 26.447716f, 16.0f, 27.0f, 16.0f);
                instancePath2.lineTo(31.0f, 16.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
