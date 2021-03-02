package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class peoplenearby_icon extends c {
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
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 23.0f, 0.0f, 1.0f, 13.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-5592406);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(3.8078494f, 11.822346f);
                instancePath.cubicTo(8.404776f, 4.3013563f, 17.218054f, -0.42926627f, 26.051363f, 0.030794242f);
                instancePath.cubicTo(35.185123f, 0.3208324f, 43.81813f, 6.141598f, 47.61385f, 14.432689f);
                instancePath.cubicTo(51.018982f, 21.393604f, 50.488182f, 29.64469f, 47.854214f, 36.76563f);
                instancePath.cubicTo(43.167152f, 49.54731f, 34.35387f, 60.318726f, 24.989763f, 70.0f);
                instancePath.cubicTo(15.275126f, 59.908672f, 6.0412145f, 48.637188f, 1.6045299f, 35.145412f);
                instancePath.cubicTo(-0.95933306f, 27.51441f, -0.60880494f, 18.713253f, 3.8078494f, 11.822346f);
                instancePath.lineTo(3.8078494f, 11.822346f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(25.084106f, 24.087467f);
                instancePath2.lineTo(16.49832f, 15.50168f);
                instancePath2.lineTo(13.669893f, 18.330107f);
                instancePath2.lineTo(22.25568f, 26.915894f);
                instancePath2.lineTo(13.669893f, 35.50168f);
                instancePath2.lineTo(16.49832f, 38.33011f);
                instancePath2.lineTo(25.084106f, 29.74432f);
                instancePath2.lineTo(33.66989f, 38.33011f);
                instancePath2.lineTo(36.49832f, 35.50168f);
                instancePath2.lineTo(27.912533f, 26.915894f);
                instancePath2.lineTo(36.49832f, 18.330107f);
                instancePath2.lineTo(33.66989f, 15.50168f);
                instancePath2.lineTo(25.084106f, 24.087467f);
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
