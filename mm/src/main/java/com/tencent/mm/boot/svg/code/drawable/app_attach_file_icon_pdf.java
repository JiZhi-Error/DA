package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_attach_file_icon_pdf extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1686720);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(46.0f, 0.0f);
                instancePath.lineTo(68.0f, 22.0f);
                instancePath.lineTo(68.0f, 87.0f);
                instancePath.cubicTo(68.0f, 88.65685f, 66.65685f, 90.0f, 65.0f, 90.0f);
                instancePath.lineTo(3.0f, 90.0f);
                instancePath.cubicTo(1.3431457f, 90.0f, 2.0290612E-16f, 88.65685f, 0.0f, 87.0f);
                instancePath.lineTo(0.0f, 3.0f);
                instancePath.cubicTo(-2.0290612E-16f, 1.3431457f, 1.3431457f, 3.043592E-16f, 3.0f, 0.0f);
                instancePath.lineTo(46.0f, 0.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-4704973);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(68.0f, 22.0f);
                instancePath2.lineTo(49.0f, 22.0f);
                instancePath2.cubicTo(47.343147f, 22.0f, 46.0f, 20.656855f, 46.0f, 19.0f);
                instancePath2.lineTo(46.0f, 0.0f);
                instancePath2.lineTo(68.0f, 22.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-1);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(13.462891f, 48.089844f);
                instancePath3.lineTo(20.03711f, 48.089844f);
                instancePath3.cubicTo(23.40039f, 48.089844f, 25.732422f, 50.375f, 25.732422f, 53.75f);
                instancePath3.cubicTo(25.732422f, 57.125f, 23.330078f, 59.410156f, 19.908203f, 59.410156f);
                instancePath3.lineTo(16.486328f, 59.410156f);
                instancePath3.lineTo(16.486328f, 65.0f);
                instancePath3.lineTo(13.462891f, 65.0f);
                instancePath3.lineTo(13.462891f, 48.089844f);
                instancePath3.close();
                instancePath3.moveTo(16.486328f, 50.5625f);
                instancePath3.lineTo(16.486328f, 56.972656f);
                instancePath3.lineTo(19.228516f, 56.972656f);
                instancePath3.cubicTo(21.396484f, 56.972656f, 22.66211f, 55.80078f, 22.66211f, 53.75f);
                instancePath3.cubicTo(22.66211f, 51.722656f, 21.408203f, 50.5625f, 19.240234f, 50.5625f);
                instancePath3.lineTo(16.486328f, 50.5625f);
                instancePath3.close();
                instancePath3.moveTo(27.935547f, 48.089844f);
                instancePath3.lineTo(34.11133f, 48.089844f);
                instancePath3.cubicTo(39.16211f, 48.089844f, 42.15039f, 51.148438f, 42.15039f, 56.503906f);
                instancePath3.cubicTo(42.15039f, 61.859375f, 39.17383f, 65.0f, 34.11133f, 65.0f);
                instancePath3.lineTo(27.935547f, 65.0f);
                instancePath3.lineTo(27.935547f, 48.089844f);
                instancePath3.close();
                instancePath3.moveTo(30.958984f, 50.64453f);
                instancePath3.lineTo(30.958984f, 62.445312f);
                instancePath3.lineTo(33.79492f, 62.445312f);
                instancePath3.cubicTo(37.19336f, 62.445312f, 39.06836f, 60.371094f, 39.06836f, 56.515625f);
                instancePath3.cubicTo(39.06836f, 52.73047f, 37.16992f, 50.64453f, 33.79492f, 50.64453f);
                instancePath3.lineTo(30.958984f, 50.64453f);
                instancePath3.close();
                instancePath3.moveTo(47.564453f, 65.0f);
                instancePath3.lineTo(44.541016f, 65.0f);
                instancePath3.lineTo(44.541016f, 48.089844f);
                instancePath3.lineTo(55.322266f, 48.089844f);
                instancePath3.lineTo(55.322266f, 50.64453f);
                instancePath3.lineTo(47.564453f, 50.64453f);
                instancePath3.lineTo(47.564453f, 55.63672f);
                instancePath3.lineTo(54.654297f, 55.63672f);
                instancePath3.lineTo(54.654297f, 58.097656f);
                instancePath3.lineTo(47.564453f, 58.097656f);
                instancePath3.lineTo(47.564453f, 65.0f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
