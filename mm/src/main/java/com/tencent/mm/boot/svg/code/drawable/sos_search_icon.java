package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sos_search_icon extends c {
    private final int height = 42;
    private final int width = 42;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 42;
            case 1:
                return 42;
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
                instancePaint4.setColor(-4210753);
                instancePaint5.setColor(-4210753);
                instancePaint5.setStrokeWidth(1.5f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Paint instancePaint7 = c.instancePaint(instancePaint5, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(16.837944f, 33.589672f);
                instancePath.cubicTo(7.7312255f, 33.589672f, 0.26877472f, 26.054348f, 0.26877472f, 16.858696f);
                instancePath.cubicTo(0.26877472f, 7.6630435f, 7.7312255f, 0.12771739f, 16.837944f, 0.12771739f);
                instancePath.cubicTo(25.944664f, 0.12771739f, 33.407116f, 7.6630435f, 33.407116f, 16.858696f);
                instancePath.cubicTo(33.407116f, 26.182066f, 25.944664f, 33.589672f, 16.837944f, 33.589672f);
                instancePath.close();
                instancePath.moveTo(16.837944f, 1.4048913f);
                instancePath.cubicTo(8.363636f, 1.4048913f, 1.5335969f, 8.30163f, 1.5335969f, 16.858696f);
                instancePath.cubicTo(1.5335969f, 25.41576f, 8.363636f, 32.3125f, 16.837944f, 32.3125f);
                instancePath.cubicTo(25.312254f, 32.3125f, 32.142292f, 25.41576f, 32.142292f, 16.858696f);
                instancePath.cubicTo(32.142292f, 8.429348f, 25.18577f, 1.4048913f, 16.837944f, 1.4048913f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint6);
                canvas.drawPath(instancePath, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint4, looper);
                Paint instancePaint9 = c.instancePaint(instancePaint5, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(39.35178f, 40.23098f);
                instancePath2.cubicTo(39.225296f, 40.23098f, 38.972332f, 40.23098f, 38.845848f, 40.10326f);
                instancePath2.lineTo(27.841898f, 28.991848f);
                instancePath2.cubicTo(27.588932f, 28.736412f, 27.588932f, 28.35326f, 27.841898f, 28.097826f);
                instancePath2.cubicTo(28.094862f, 27.842392f, 28.474308f, 27.842392f, 28.727272f, 28.097826f);
                instancePath2.lineTo(39.731224f, 39.20924f);
                instancePath2.cubicTo(39.984188f, 39.464672f, 39.984188f, 39.847828f, 39.731224f, 40.10326f);
                instancePath2.cubicTo(39.604744f, 40.23098f, 39.47826f, 40.23098f, 39.35178f, 40.23098f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
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
