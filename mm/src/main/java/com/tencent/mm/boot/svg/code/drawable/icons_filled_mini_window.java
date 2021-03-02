package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_mini_window extends c {
    private final int height = 24;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(19.5f, 3.0f);
                instancePath.cubicTo(20.052284f, 3.0f, 20.5f, 3.4477153f, 20.5f, 4.0f);
                instancePath.lineTo(20.5f, 4.0f);
                instancePath.lineTo(20.5f, 11.999f);
                instancePath.lineTo(18.5f, 11.999f);
                instancePath.lineTo(18.5f, 5.0f);
                instancePath.lineTo(4.0f, 5.0f);
                instancePath.lineTo(4.0f, 17.0f);
                instancePath.lineTo(12.0f, 16.999f);
                instancePath.lineTo(12.0f, 19.0f);
                instancePath.lineTo(3.0f, 19.0f);
                instancePath.cubicTo(2.4871643f, 19.0f, 2.064493f, 18.61396f, 2.0067277f, 18.116621f);
                instancePath.lineTo(2.0f, 18.0f);
                instancePath.lineTo(2.0f, 4.0f);
                instancePath.cubicTo(2.0f, 3.4477153f, 2.4477153f, 3.0f, 3.0f, 3.0f);
                instancePath.lineTo(3.0f, 3.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(21.0f, 13.38f);
                instancePath2.lineTo(14.38f, 13.38f);
                instancePath2.cubicTo(13.827715f, 13.38f, 13.38f, 13.827715f, 13.38f, 14.38f);
                instancePath2.lineTo(13.38f, 19.998175f);
                instancePath2.cubicTo(13.380212f, 20.550377f, 13.827798f, 20.998058f, 14.38f, 20.998386f);
                instancePath2.lineTo(21.0f, 20.999788f);
                instancePath2.cubicTo(21.552284f, 21.000116f, 22.000095f, 20.552496f, 22.000212f, 20.000212f);
                instancePath2.cubicTo(22.000212f, 20.000141f, 22.000212f, 20.00007f, 22.0f, 20.0f);
                instancePath2.lineTo(22.0f, 14.38f);
                instancePath2.cubicTo(22.0f, 13.827715f, 21.552284f, 13.38f, 21.0f, 13.38f);
                instancePath2.close();
                instancePath2.moveTo(15.19f, 15.0f);
                instancePath2.lineTo(20.19f, 15.0f);
                instancePath2.cubicTo(20.294933f, 15.0f, 20.38f, 15.085066f, 20.38f, 15.19f);
                instancePath2.lineTo(20.38f, 19.19f);
                instancePath2.cubicTo(20.38f, 19.294933f, 20.294933f, 19.38f, 20.19f, 19.38f);
                instancePath2.lineTo(15.19f, 19.38f);
                instancePath2.cubicTo(15.085066f, 19.38f, 15.0f, 19.294933f, 15.0f, 19.19f);
                instancePath2.lineTo(15.0f, 15.19f);
                instancePath2.cubicTo(15.0f, 15.085066f, 15.085066f, 15.0f, 15.19f, 15.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 4.5f, 0.0f, 1.0f, 5.5f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint5, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(6.5f, 7.0036216f);
                instancePath3.lineTo(1.0f, 7.0036216f);
                instancePath3.lineTo(1.0f, 7.0036216f);
                instancePath3.lineTo(1.0f, 5.5036216f);
                instancePath3.lineTo(5.502f, 5.503f);
                instancePath3.lineTo(5.5023327f, 1.0f);
                instancePath3.lineTo(7.0f, 1.0f);
                instancePath3.lineTo(7.0f, 6.5036216f);
                instancePath3.cubicTo(7.0f, 6.779764f, 6.7761426f, 7.0036216f, 6.5f, 7.0036216f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint5, looper);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 0.70710677f, -0.70710677f, 3.792893f, 0.70710677f, 0.70710677f, -1.5710678f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(0.29289323f, 3.0428932f);
                instancePath4.lineTo(7.2928934f, 3.0428932f);
                instancePath4.lineTo(7.2928934f, 4.5428934f);
                instancePath4.lineTo(0.29289323f, 4.5428934f);
                instancePath4.lineTo(0.29289323f, 3.0428932f);
                instancePath4.close();
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
