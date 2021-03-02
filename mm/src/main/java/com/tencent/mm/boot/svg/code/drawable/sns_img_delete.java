package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sns_img_delete extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 4.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(15.0f, 1.0f);
                instancePath.cubicTo(15.0f, 0.44771522f, 15.447715f, 0.0f, 16.0f, 0.0f);
                instancePath.lineTo(32.0f, 0.0f);
                instancePath.cubicTo(32.552284f, 0.0f, 33.0f, 0.44771522f, 33.0f, 1.0f);
                instancePath.lineTo(33.0f, 6.0f);
                instancePath.cubicTo(33.0f, 6.5522847f, 32.552284f, 7.0f, 32.0f, 7.0f);
                instancePath.lineTo(16.0f, 7.0f);
                instancePath.cubicTo(15.447715f, 7.0f, 15.0f, 6.5522847f, 15.0f, 6.0f);
                instancePath.lineTo(15.0f, 1.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint5.setColor(-1);
                instancePaint5.setStrokeWidth(4.5f);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(7.25f, 8.25f);
                instancePath2.lineTo(40.75f, 8.25f);
                instancePath2.lineTo(40.75f, 50.75f);
                instancePath2.lineTo(7.25f, 50.75f);
                instancePath2.lineTo(7.25f, 8.25f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-1);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 17.0f, 0.0f, 1.0f, 17.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint6, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(0.0f, 1.0f);
                instancePath3.cubicTo(0.0f, 0.44771522f, 0.44771522f, -2.6645353E-15f, 1.0f, -2.6645353E-15f);
                instancePath3.lineTo(2.0f, -2.6645353E-15f);
                instancePath3.cubicTo(2.5522847f, -2.6645353E-15f, 3.0f, 0.44771522f, 3.0f, 1.0f);
                instancePath3.lineTo(3.0f, 21.0f);
                instancePath3.cubicTo(3.0f, 21.552284f, 2.5522847f, 22.0f, 2.0f, 22.0f);
                instancePath3.lineTo(1.0f, 22.0f);
                instancePath3.cubicTo(0.44771522f, 22.0f, 0.0f, 21.552284f, 0.0f, 21.0f);
                instancePath3.lineTo(0.0f, 1.0f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint6, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(11.998957f, -1.7763568E-15f);
                instancePath4.cubicTo(11.447248f, -1.7763568E-15f, 11.0f, 0.43945834f, 11.0f, 1.0024617f);
                instancePath4.lineTo(11.0f, 20.997538f);
                instancePath4.cubicTo(11.0f, 21.551182f, 11.44266f, 22.0f, 11.998957f, 22.0f);
                instancePath4.lineTo(13.001043f, 22.0f);
                instancePath4.cubicTo(13.552752f, 22.0f, 14.0f, 21.560541f, 14.0f, 20.997538f);
                instancePath4.lineTo(14.0f, 1.0024617f);
                instancePath4.cubicTo(14.0f, 0.44881737f, 13.55734f, -1.7763568E-15f, 13.001043f, -1.7763568E-15f);
                instancePath4.lineTo(11.998957f, -1.7763568E-15f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint8);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint, looper);
                instancePaint9.setColor(-1);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(0.0f, 7.0f);
                instancePath5.cubicTo(0.0f, 6.4477153f, 0.44771522f, 6.0f, 1.0f, 6.0f);
                instancePath5.lineTo(47.0f, 6.0f);
                instancePath5.cubicTo(47.552284f, 6.0f, 48.0f, 6.4477153f, 48.0f, 7.0f);
                instancePath5.lineTo(48.0f, 8.0f);
                instancePath5.cubicTo(48.0f, 8.552285f, 47.552284f, 9.0f, 47.0f, 9.0f);
                instancePath5.lineTo(1.0f, 9.0f);
                instancePath5.cubicTo(0.44771522f, 9.0f, 0.0f, 8.552285f, 0.0f, 8.0f);
                instancePath5.lineTo(0.0f, 7.0f);
                instancePath5.close();
                canvas.drawPath(instancePath5, instancePaint9);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
