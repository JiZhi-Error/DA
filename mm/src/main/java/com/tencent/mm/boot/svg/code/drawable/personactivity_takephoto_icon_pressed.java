package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class personactivity_takephoto_icon_pressed extends c {
    private final int height = 120;
    private final int width = 120;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                instancePaint3.setColor(-2829100);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 15.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(8.001439f, 18.0f);
                instancePath.cubicTo(3.5823665f, 18.0f, 0.0f, 21.582798f, 0.0f, 25.997679f);
                instancePath.lineTo(0.0f, 82.00232f);
                instancePath.cubicTo(0.0f, 86.41932f, 3.5913615f, 90.0f, 8.001439f, 90.0f);
                instancePath.lineTo(111.99856f, 90.0f);
                instancePath.cubicTo(116.41763f, 90.0f, 120.0f, 86.4172f, 120.0f, 82.00232f);
                instancePath.lineTo(120.0f, 25.997679f);
                instancePath.cubicTo(120.0f, 21.580683f, 116.40864f, 18.0f, 111.99856f, 18.0f);
                instancePath.lineTo(8.001439f, 18.0f);
                instancePath.close();
                instancePath.moveTo(47.750492f, 0.0f);
                instancePath.lineTo(60.0f, 0.0f);
                instancePath.lineTo(60.0f, 18.0f);
                instancePath.lineTo(23.340025f, 18.0f);
                instancePath.cubicTo(33.061623f, 18.0f, 38.284004f, 0.0f, 47.750492f, 0.0f);
                instancePath.close();
                instancePath.moveTo(96.65997f, 18.0f);
                instancePath.cubicTo(86.93838f, 18.0f, 81.715996f, 0.0f, 72.2474f, 0.0f);
                instancePath.lineTo(60.0f, 0.0f);
                instancePath.lineTo(60.0f, 18.0f);
                instancePath.lineTo(96.65997f, 18.0f);
                instancePath.close();
                instancePath.moveTo(60.0f, 27.0f);
                instancePath.cubicTo(74.91231f, 27.0f, 87.0f, 39.087692f, 87.0f, 54.0f);
                instancePath.cubicTo(87.0f, 68.91231f, 74.91231f, 81.0f, 60.0f, 81.0f);
                instancePath.cubicTo(45.087692f, 81.0f, 33.0f, 68.91231f, 33.0f, 54.0f);
                instancePath.cubicTo(33.0f, 39.087692f, 45.087692f, 27.0f, 60.0f, 27.0f);
                instancePath.close();
                instancePath.moveTo(78.0f, 54.0f);
                instancePath.cubicTo(78.0f, 63.9414f, 69.9414f, 72.0f, 60.0f, 72.0f);
                instancePath.cubicTo(50.0586f, 72.0f, 42.0f, 63.9414f, 42.0f, 54.0f);
                instancePath.cubicTo(42.0f, 44.0586f, 50.0586f, 36.0f, 60.0f, 36.0f);
                instancePath.cubicTo(69.9414f, 36.0f, 78.0f, 44.0586f, 78.0f, 54.0f);
                instancePath.close();
                instancePath.moveTo(5.4545455f, 6.4315085f);
                instancePath.lineTo(21.818182f, 6.4315085f);
                instancePath.lineTo(21.818182f, 12.407947f);
                instancePath.lineTo(5.4545455f, 12.407947f);
                instancePath.lineTo(5.4545455f, 6.4315085f);
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
