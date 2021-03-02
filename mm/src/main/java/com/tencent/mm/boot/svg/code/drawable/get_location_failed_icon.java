package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class get_location_failed_icon extends c {
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
                c.instancePaint(instancePaint2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-4187622);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 4.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(20.0f, 1.0f);
                instancePath.cubicTo(29.125349f, -1.4006271f, 38.745907f, 1.5796907f, 45.0f, 8.0f);
                instancePath.cubicTo(51.066624f, 14.551074f, 53.526768f, 24.332117f, 51.0f, 33.0f);
                instancePath.cubicTo(48.626484f, 42.064007f, 40.82603f, 49.454796f, 32.0f, 51.0f);
                instancePath.cubicTo(22.374956f, 53.495228f, 12.184362f, 50.06486f, 6.0f, 43.0f);
                instancePath.cubicTo(0.45367983f, 36.153378f, -1.5164348f, 26.532352f, 1.0f, 18.0f);
                instancePath.cubicTo(3.8838794f, 9.480534f, 11.474321f, 2.50979f, 20.0f, 1.0f);
                instancePath.lineTo(20.0f, 1.0f);
                instancePath.close();
                instancePath.moveTo(24.0f, 11.0f);
                instancePath.lineTo(24.0f, 34.0f);
                instancePath.lineTo(28.0f, 34.0f);
                instancePath.lineTo(28.0f, 11.0f);
                instancePath.lineTo(24.0f, 11.0f);
                instancePath.lineTo(24.0f, 11.0f);
                instancePath.close();
                instancePath.moveTo(24.0f, 37.0f);
                instancePath.lineTo(24.0f, 41.0f);
                instancePath.cubicTo(25.330078f, 41.000427f, 26.670155f, 41.000427f, 28.0f, 41.0f);
                instancePath.cubicTo(28.000233f, 39.670284f, 28.000233f, 38.330143f, 28.0f, 37.0f);
                instancePath.lineTo(24.0f, 37.0f);
                instancePath.lineTo(24.0f, 37.0f);
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
