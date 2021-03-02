package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class find_more_friend_search extends c {
    private final int height = 108;
    private final int width = 108;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                instancePaint3.setColor(-499359);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 17.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(36.832836f, 23.632835f);
                instancePath.lineTo(41.955223f, 12.99403f);
                instancePath.cubicTo(42.54627f, 11.713433f, 42.54627f, 10.432836f, 42.05373f, 9.250747f);
                instancePath.cubicTo(41.561195f, 8.068657f, 40.57612f, 7.1820893f, 39.197014f, 6.6895523f);
                instancePath.lineTo(38.113434f, 6.295522f);
                instancePath.cubicTo(37.620895f, 6.0985074f, 37.128357f, 6.0f, 36.635822f, 6.0f);
                instancePath.cubicTo(34.46866f, 6.0f, 32.695522f, 7.477612f, 32.202984f, 9.644776f);
                instancePath.lineTo(29.937313f, 21.170149f);
                instancePath.cubicTo(29.34627f, 23.928358f, 30.232836f, 26.489552f, 31.808956f, 27.080597f);
                instancePath.cubicTo(32.00597f, 27.179104f, 32.202984f, 27.179104f, 32.49851f, 27.179104f);
                instancePath.cubicTo(33.97612f, 27.277613f, 35.749252f, 25.8f, 36.832836f, 23.632835f);
                instancePath.close();
                instancePath.moveTo(24.716417f, 31.119404f);
                instancePath.cubicTo(24.913433f, 29.444777f, 22.844776f, 27.671642f, 20.086567f, 27.080597f);
                instancePath.lineTo(11.614925f, 25.01194f);
                instancePath.cubicTo(11.220896f, 24.913433f, 10.826866f, 24.913433f, 10.432836f, 24.913433f);
                instancePath.cubicTo(8.167164f, 24.913433f, 6.295522f, 26.58806f, 6.0985074f, 28.853731f);
                instancePath.lineTo(6.0f, 30.03582f);
                instancePath.cubicTo(6.0f, 31.414925f, 6.4925375f, 32.695522f, 7.3791046f, 33.58209f);
                instancePath.cubicTo(8.167164f, 34.370148f, 9.250747f, 34.76418f, 10.432836f, 34.76418f);
                instancePath.cubicTo(10.531343f, 34.76418f, 10.62985f, 34.76418f, 10.728358f, 34.76418f);
                instancePath.lineTo(19.397015f, 34.370148f);
                instancePath.cubicTo(22.25373f, 34.074627f, 24.519403f, 32.695522f, 24.716417f, 31.119404f);
                instancePath.close();
                instancePath.moveTo(26.686567f, 39.689552f);
                instancePath.cubicTo(25.01194f, 39.197014f, 22.74627f, 40.773136f, 21.662687f, 43.334328f);
                instancePath.lineTo(13.38806f, 61.4597f);
                instancePath.cubicTo(12.797015f, 62.7403f, 12.797015f, 64.0209f, 13.38806f, 65.20299f);
                instancePath.cubicTo(13.979104f, 66.38507f, 14.964179f, 67.271645f, 16.343283f, 67.66567f);
                instancePath.lineTo(17.426867f, 68.0597f);
                instancePath.lineTo(17.525373f, 68.0597f);
                instancePath.cubicTo(17.722387f, 68.0597f, 17.919403f, 68.0597f, 18.116419f, 68.0597f);
                instancePath.cubicTo(20.480597f, 68.0597f, 23.140299f, 66.97612f, 23.731344f, 64.71045f);
                instancePath.lineTo(28.558208f, 45.402985f);
                instancePath.cubicTo(29.050747f, 42.743282f, 28.361195f, 40.18209f, 26.686567f, 39.689552f);
                instancePath.close();
                instancePath.moveTo(41.167164f, 41.856716f);
                instancePath.cubicTo(39.886566f, 40.47761f, 38.21194f, 39.591045f, 36.832836f, 39.591045f);
                instancePath.cubicTo(36.24179f, 39.591045f, 35.749252f, 39.78806f, 35.355225f, 40.083584f);
                instancePath.cubicTo(34.074627f, 41.167164f, 34.27164f, 43.826866f, 35.94627f, 46.191044f);
                instancePath.lineTo(51.608955f, 69.04478f);
                instancePath.cubicTo(52.49552f, 70.42388f, 53.973133f, 71.113434f, 55.450745f, 71.113434f);
                instancePath.cubicTo(56.53433f, 71.113434f, 57.617912f, 70.719406f, 58.50448f, 70.029854f);
                instancePath.lineTo(59.391045f, 69.3403f);
                instancePath.cubicTo(60.47463f, 68.45373f, 61.06567f, 67.271645f, 61.16418f, 65.89254f);
                instancePath.cubicTo(61.262688f, 64.513435f, 60.77015f, 63.232838f, 59.883583f, 62.24776f);
                instancePath.lineTo(41.167164f, 41.856716f);
                instancePath.close();
                instancePath.moveTo(71.90149f, 30.331343f);
                instancePath.cubicTo(71.704475f, 27.474627f, 69.3403f, 25.40597f, 66.48358f, 25.8f);
                instancePath.lineTo(43.23582f, 29.24776f);
                instancePath.cubicTo(40.47761f, 29.64179f, 38.310448f, 31.316418f, 38.408955f, 33.089554f);
                instancePath.cubicTo(38.50746f, 34.862686f, 40.773136f, 36.24179f, 43.629852f, 36.24179f);
                instancePath.lineTo(66.58209f, 36.53731f);
                instancePath.lineTo(66.680595f, 36.53731f);
                instancePath.cubicTo(68.15821f, 36.53731f, 69.63582f, 35.847763f, 70.719406f, 34.76418f);
                instancePath.cubicTo(71.60597f, 33.779106f, 72.0f, 32.597015f, 72.0f, 31.414925f);
                instancePath.lineTo(71.90149f, 30.331343f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
