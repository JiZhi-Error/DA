package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_photo_wall extends c {
    private final int height = 72;
    private final int width = 72;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 12.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(3.6f, 15.6f);
                instancePath.lineTo(3.6f, 44.4f);
                instancePath.lineTo(44.4f, 44.4f);
                instancePath.lineTo(44.4f, 15.6f);
                instancePath.lineTo(3.6f, 15.6f);
                instancePath.close();
                instancePath.moveTo(3.0f, 12.0f);
                instancePath.lineTo(45.0f, 12.0f);
                instancePath.cubicTo(46.656853f, 12.0f, 48.0f, 13.343145f, 48.0f, 15.0f);
                instancePath.lineTo(48.0f, 45.0f);
                instancePath.cubicTo(48.0f, 46.656853f, 46.656853f, 48.0f, 45.0f, 48.0f);
                instancePath.lineTo(3.0f, 48.0f);
                instancePath.cubicTo(1.3431457f, 48.0f, 3.75562E-15f, 46.656853f, 3.5527137E-15f, 45.0f);
                instancePath.lineTo(3.5527137E-15f, 15.0f);
                instancePath.cubicTo(3.3498076E-15f, 13.343145f, 1.3431457f, 12.0f, 3.0f, 12.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 36.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(48.0f, 0.0f);
                instancePath2.lineTo(57.0f, 0.0f);
                instancePath2.cubicTo(58.656853f, -2.6645353E-15f, 60.0f, 1.3431457f, 60.0f, 3.0f);
                instancePath2.lineTo(60.0f, 33.0f);
                instancePath2.cubicTo(60.0f, 34.656853f, 58.656853f, 36.0f, 57.0f, 36.0f);
                instancePath2.lineTo(15.0f, 36.0f);
                instancePath2.cubicTo(13.343145f, 36.0f, 12.0f, 34.656853f, 12.0f, 33.0f);
                instancePath2.lineTo(12.0f, 24.0f);
                instancePath2.lineTo(15.6f, 24.0f);
                instancePath2.lineTo(15.6f, 32.4f);
                instancePath2.lineTo(56.4f, 32.4f);
                instancePath2.lineTo(56.4f, 3.6f);
                instancePath2.lineTo(48.0f, 3.6f);
                instancePath2.lineTo(48.0f, 0.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}