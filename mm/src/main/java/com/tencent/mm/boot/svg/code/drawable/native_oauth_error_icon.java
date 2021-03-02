package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class native_oauth_error_icon extends c {
    private final int height = 279;
    private final int width = 279;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 279;
            case 1:
                return 279;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -17.0f, 0.0f, 1.0f, -250.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 17.0f, 0.0f, 1.0f, 250.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-15683841);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(279.0f, 141.22223f);
                instancePath.cubicTo(279.0f, 62.454666f, 216.54533f, 0.0f, 137.77777f, 0.0f);
                instancePath.cubicTo(62.454666f, 0.0f, 0.0f, 62.454666f, 0.0f, 141.22223f);
                instancePath.cubicTo(0.0f, 216.54533f, 62.454666f, 279.0f, 137.77777f, 279.0f);
                instancePath.cubicTo(216.54533f, 279.0f, 279.0f, 216.54533f, 279.0f, 141.22223f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 279.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(134.99942f, 70.5f);
                instancePath2.lineTo(144.00058f, 70.5f);
                instancePath2.cubicTo(145.65565f, 70.5f, 147.03334f, 71.843925f, 147.07448f, 73.50175f);
                instancePath2.lineTo(149.42552f, 168.25435f);
                instancePath2.cubicTo(149.46655f, 169.90797f, 148.15945f, 171.2561f, 146.5058f, 171.2561f);
                instancePath2.lineTo(132.4942f, 171.2561f);
                instancePath2.cubicTo(130.8433f, 171.2561f, 129.53334f, 169.91217f, 129.57448f, 168.25435f);
                instancePath2.lineTo(131.92552f, 73.50175f);
                instancePath2.cubicTo(131.96655f, 71.84813f, 133.34288f, 70.5f, 134.99942f, 70.5f);
                instancePath2.close();
                instancePath2.moveTo(139.5f, 208.5f);
                instancePath2.cubicTo(132.87259f, 208.5f, 127.5f, 203.12741f, 127.5f, 196.5f);
                instancePath2.cubicTo(127.5f, 189.87259f, 132.87259f, 184.5f, 139.5f, 184.5f);
                instancePath2.cubicTo(146.12741f, 184.5f, 151.5f, 189.87259f, 151.5f, 196.5f);
                instancePath2.cubicTo(151.5f, 203.12741f, 146.12741f, 208.5f, 139.5f, 208.5f);
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
