package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class loc extends c {
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
                instancePaint3.setColor(1275068416);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 6.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(24.19557f, 57.7295f);
                instancePath.cubicTo(24.18903f, 57.723602f, 24.182568f, 57.717976f, 24.176184f, 57.712605f);
                instancePath.lineTo(24.19557f, 57.7295f);
                instancePath.close();
                instancePath.moveTo(24.74051f, 56.90582f);
                instancePath.cubicTo(25.4488f, 56.267334f, 26.24197f, 55.523434f, 27.098534f, 54.683678f);
                instancePath.cubicTo(29.5519f, 52.278442f, 32.006676f, 49.60057f, 34.290497f, 46.73064f);
                instancePath.cubicTo(40.408028f, 39.04313f, 44.13418f, 31.461306f, 44.38646f, 24.719046f);
                instancePath.cubicTo(44.39548f, 24.477993f, 44.4f, 24.23831f, 44.4f, 24.0f);
                instancePath.cubicTo(44.4f, 12.733391f, 35.26661f, 3.6f, 24.0f, 3.6f);
                instancePath.cubicTo(12.733391f, 3.6f, 3.6f, 12.733391f, 3.6f, 24.0f);
                instancePath.cubicTo(3.6f, 24.23831f, 3.6045203f, 24.477993f, 3.6135402f, 24.719046f);
                instancePath.cubicTo(3.8658228f, 31.461306f, 7.591971f, 39.04313f, 13.709501f, 46.73064f);
                instancePath.cubicTo(15.993323f, 49.60057f, 18.4481f, 52.278442f, 20.901466f, 54.683678f);
                instancePath.cubicTo(21.75803f, 55.523434f, 22.5512f, 56.267334f, 23.25949f, 56.90582f);
                instancePath.cubicTo(23.590477f, 57.20419f, 23.840916f, 57.424175f, 24.0f, 57.561043f);
                instancePath.cubicTo(24.159084f, 57.424175f, 24.409523f, 57.20419f, 24.74051f, 56.90582f);
                instancePath.close();
                instancePath.moveTo(21.785156f, 60.40343f);
                instancePath.cubicTo(21.785156f, 60.40343f, 0.0f, 42.054832f, 0.0f, 24.0f);
                instancePath.cubicTo(0.0f, 10.745166f, 10.745166f, 0.0f, 24.0f, 0.0f);
                instancePath.cubicTo(37.254833f, 0.0f, 48.0f, 10.745166f, 48.0f, 24.0f);
                instancePath.cubicTo(48.0f, 42.054832f, 26.214844f, 60.40343f, 26.214844f, 60.40343f);
                instancePath.cubicTo(25.000694f, 61.51806f, 23.00838f, 61.506104f, 21.785156f, 60.40343f);
                instancePath.close();
                instancePath.moveTo(24.0f, 32.4f);
                instancePath.cubicTo(28.639193f, 32.4f, 32.4f, 28.639193f, 32.4f, 24.0f);
                instancePath.cubicTo(32.4f, 19.360807f, 28.639193f, 15.6f, 24.0f, 15.6f);
                instancePath.cubicTo(19.360807f, 15.6f, 15.6f, 19.360807f, 15.6f, 24.0f);
                instancePath.cubicTo(15.6f, 28.639193f, 19.360807f, 32.4f, 24.0f, 32.4f);
                instancePath.close();
                instancePath.moveTo(24.0f, 36.0f);
                instancePath.cubicTo(17.372583f, 36.0f, 12.0f, 30.627417f, 12.0f, 24.0f);
                instancePath.cubicTo(12.0f, 17.372583f, 17.372583f, 12.0f, 24.0f, 12.0f);
                instancePath.cubicTo(30.627417f, 12.0f, 36.0f, 17.372583f, 36.0f, 24.0f);
                instancePath.cubicTo(36.0f, 30.627417f, 30.627417f, 36.0f, 24.0f, 36.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
