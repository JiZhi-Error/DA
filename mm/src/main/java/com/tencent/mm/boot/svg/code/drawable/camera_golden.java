package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class camera_golden extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                instancePaint3.setColor(-4284563);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(66.36202f, 28.0f);
                instancePath.lineTo(76.99543f, 28.0f);
                instancePath.cubicTo(79.20043f, 28.0f, 81.0f, 29.79529f, 81.0f, 32.00989f);
                instancePath.lineTo(81.0f, 71.990105f);
                instancePath.cubicTo(81.0f, 74.20595f, 79.20709f, 76.0f, 76.99543f, 76.0f);
                instancePath.lineTo(19.00457f, 76.0f);
                instancePath.cubicTo(16.79957f, 76.0f, 15.0f, 74.20471f, 15.0f, 71.990105f);
                instancePath.lineTo(15.0f, 32.00989f);
                instancePath.cubicTo(15.0f, 29.794052f, 16.792908f, 28.0f, 19.00457f, 28.0f);
                instancePath.lineTo(29.637974f, 28.0f);
                instancePath.lineTo(36.0f, 22.0f);
                instancePath.lineTo(60.0f, 22.0f);
                instancePath.lineTo(66.36202f, 28.0f);
                instancePath.close();
                instancePath.moveTo(48.0f, 70.0f);
                instancePath.cubicTo(59.045696f, 70.0f, 68.0f, 61.045696f, 68.0f, 50.0f);
                instancePath.cubicTo(68.0f, 38.954304f, 59.045696f, 30.0f, 48.0f, 30.0f);
                instancePath.cubicTo(36.954304f, 30.0f, 28.0f, 38.954304f, 28.0f, 50.0f);
                instancePath.cubicTo(28.0f, 61.045696f, 36.954304f, 70.0f, 48.0f, 70.0f);
                instancePath.close();
                instancePath.moveTo(48.0f, 63.0f);
                instancePath.cubicTo(55.179703f, 63.0f, 61.0f, 57.179703f, 61.0f, 50.0f);
                instancePath.cubicTo(61.0f, 42.820297f, 55.179703f, 37.0f, 48.0f, 37.0f);
                instancePath.cubicTo(40.820297f, 37.0f, 35.0f, 42.820297f, 35.0f, 50.0f);
                instancePath.cubicTo(35.0f, 57.179703f, 40.820297f, 63.0f, 48.0f, 63.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(66.36202f, 28.0f);
                instancePath2.lineTo(76.99543f, 28.0f);
                instancePath2.cubicTo(79.20043f, 28.0f, 81.0f, 29.79529f, 81.0f, 32.00989f);
                instancePath2.lineTo(81.0f, 71.990105f);
                instancePath2.cubicTo(81.0f, 74.20595f, 79.20709f, 76.0f, 76.99543f, 76.0f);
                instancePath2.lineTo(19.00457f, 76.0f);
                instancePath2.cubicTo(16.79957f, 76.0f, 15.0f, 74.20471f, 15.0f, 71.990105f);
                instancePath2.lineTo(15.0f, 32.00989f);
                instancePath2.cubicTo(15.0f, 29.794052f, 16.792908f, 28.0f, 19.00457f, 28.0f);
                instancePath2.lineTo(29.637974f, 28.0f);
                instancePath2.lineTo(36.0f, 22.0f);
                instancePath2.lineTo(60.0f, 22.0f);
                instancePath2.lineTo(66.36202f, 28.0f);
                instancePath2.close();
                instancePath2.moveTo(48.0f, 70.0f);
                instancePath2.cubicTo(59.045696f, 70.0f, 68.0f, 61.045696f, 68.0f, 50.0f);
                instancePath2.cubicTo(68.0f, 38.954304f, 59.045696f, 30.0f, 48.0f, 30.0f);
                instancePath2.cubicTo(36.954304f, 30.0f, 28.0f, 38.954304f, 28.0f, 50.0f);
                instancePath2.cubicTo(28.0f, 61.045696f, 36.954304f, 70.0f, 48.0f, 70.0f);
                instancePath2.close();
                instancePath2.moveTo(48.0f, 63.0f);
                instancePath2.cubicTo(55.179703f, 63.0f, 61.0f, 57.179703f, 61.0f, 50.0f);
                instancePath2.cubicTo(61.0f, 42.820297f, 55.179703f, 37.0f, 48.0f, 37.0f);
                instancePath2.cubicTo(40.820297f, 37.0f, 35.0f, 42.820297f, 35.0f, 50.0f);
                instancePath2.cubicTo(35.0f, 57.179703f, 40.820297f, 63.0f, 48.0f, 63.0f);
                instancePath2.close();
                Paint instancePaint6 = c.instancePaint(looper);
                instancePaint6.setFlags(385);
                instancePaint6.setStyle(Paint.Style.FILL);
                Paint instancePaint7 = c.instancePaint(looper);
                instancePaint7.setFlags(385);
                instancePaint7.setStyle(Paint.Style.STROKE);
                instancePaint6.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint7.setStrokeWidth(1.0f);
                instancePaint7.setStrokeCap(Paint.Cap.BUTT);
                instancePaint7.setStrokeJoin(Paint.Join.MITER);
                instancePaint7.setStrokeMiter(4.0f);
                instancePaint7.setPathEffect(null);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 81.0f, 0.0f, 15.0f, 0.0f, 76.0f, 22.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                WeChatSVGRenderC2Java.setLinearGradient(instancePaint5, 0.7940693f, 0.8090447f, 0.08431214f, 0.07970222f, new int[]{-4679064, -2112619}, new float[]{0.0f, 1.0f}, instanceMatrix, 0);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
