package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_previous2 extends c {
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
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(27.805887f, 33.6f);
                instancePath.lineTo(32.030865f, 37.824978f);
                instancePath.lineTo(29.485281f, 40.370564f);
                instancePath.lineTo(23.545584f, 34.430866f);
                instancePath.lineTo(22.06066f, 32.945942f);
                instancePath.cubicTo(21.474874f, 32.360157f, 21.474874f, 31.410408f, 22.06066f, 30.824621f);
                instancePath.lineTo(29.485281f, 23.400002f);
                instancePath.lineTo(32.030865f, 25.945585f);
                instancePath.lineTo(27.976452f, 30.0f);
                instancePath.lineTo(42.0f, 30.0f);
                instancePath.cubicTo(46.970562f, 30.0f, 51.0f, 34.029438f, 51.0f, 39.0f);
                instancePath.cubicTo(51.0f, 43.970562f, 46.970562f, 48.0f, 42.0f, 48.0f);
                instancePath.lineTo(36.0f, 48.0f);
                instancePath.lineTo(36.0f, 44.4f);
                instancePath.lineTo(42.0f, 44.4f);
                instancePath.cubicTo(44.982338f, 44.4f, 47.4f, 41.982338f, 47.4f, 39.0f);
                instancePath.cubicTo(47.4f, 36.017662f, 44.982338f, 33.6f, 42.0f, 33.6f);
                instancePath.lineTo(27.805887f, 33.6f);
                instancePath.close();
                instancePath.moveTo(36.0f, 66.0f);
                instancePath.cubicTo(19.431458f, 66.0f, 6.0f, 52.568542f, 6.0f, 36.0f);
                instancePath.cubicTo(6.0f, 19.431458f, 19.431458f, 6.0f, 36.0f, 6.0f);
                instancePath.cubicTo(52.568542f, 6.0f, 66.0f, 19.431458f, 66.0f, 36.0f);
                instancePath.cubicTo(66.0f, 52.568542f, 52.568542f, 66.0f, 36.0f, 66.0f);
                instancePath.close();
                instancePath.moveTo(36.0f, 62.4f);
                instancePath.cubicTo(50.58032f, 62.4f, 62.4f, 50.58032f, 62.4f, 36.0f);
                instancePath.cubicTo(62.4f, 21.419683f, 50.58032f, 9.6f, 36.0f, 9.6f);
                instancePath.cubicTo(21.419683f, 9.6f, 9.6f, 21.419683f, 9.6f, 36.0f);
                instancePath.cubicTo(9.6f, 50.58032f, 21.419683f, 62.4f, 36.0f, 62.4f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 21.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
