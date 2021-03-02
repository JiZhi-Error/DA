package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_pay_transfer extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 14.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(52.015984f, 26.5f);
                instancePath.cubicTo(52.84441f, 26.5f, 53.515984f, 27.171574f, 53.515984f, 28.0f);
                instancePath.cubicTo(53.515984f, 28.470095f, 53.295597f, 28.913002f, 52.920616f, 29.19651f);
                instancePath.lineTo(34.561848f, 43.076824f);
                instancePath.cubicTo(34.033195f, 43.476513f, 33.280624f, 43.37197f, 32.88093f, 42.84332f);
                instancePath.cubicTo(32.647045f, 42.53397f, 32.577076f, 42.130657f, 32.693104f, 41.7606f);
                instancePath.lineTo(35.596638f, 32.5f);
                instancePath.lineTo(1.5f, 32.5f);
                instancePath.lineTo(1.5f, 26.5f);
                instancePath.lineTo(52.015984f, 26.5f);
                instancePath.close();
                instancePath.moveTo(21.115791f, 1.1566801f);
                instancePath.cubicTo(21.349678f, 1.4660312f, 21.419645f, 1.8693439f, 21.30362f, 2.2393975f);
                instancePath.lineTo(18.400084f, 11.5f);
                instancePath.lineTo(52.5f, 11.5f);
                instancePath.lineTo(52.5f, 17.5f);
                instancePath.lineTo(1.9807396f, 17.5f);
                instancePath.cubicTo(1.1523125f, 17.5f, 0.48073965f, 16.828426f, 0.48073965f, 16.0f);
                instancePath.cubicTo(0.48073965f, 15.529904f, 0.70112365f, 15.086998f, 1.0761067f, 14.803489f);
                instancePath.lineTo(19.434875f, 0.92317754f);
                instancePath.cubicTo(19.963528f, 0.52348554f, 20.716099f, 0.6280282f, 21.115791f, 1.1566801f);
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
