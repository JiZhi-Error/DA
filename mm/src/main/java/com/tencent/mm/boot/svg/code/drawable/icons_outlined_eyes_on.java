package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_eyes_on extends c {
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 15.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(33.0f, 38.4f);
                instancePath.cubicTo(45.102955f, 38.4f, 56.058674f, 31.649624f, 61.943615f, 21.0f);
                instancePath.cubicTo(56.058674f, 10.350376f, 45.102955f, 3.6f, 33.0f, 3.6f);
                instancePath.cubicTo(20.897047f, 3.6f, 9.941325f, 10.350376f, 4.0563836f, 21.0f);
                instancePath.cubicTo(9.941325f, 31.649624f, 20.897047f, 38.4f, 33.0f, 38.4f);
                instancePath.close();
                instancePath.moveTo(33.0f, 0.0f);
                instancePath.cubicTo(47.42337f, 0.0f, 59.91619f, 8.542883f, 66.0f, 21.0f);
                instancePath.cubicTo(59.91619f, 33.45712f, 47.42337f, 42.0f, 33.0f, 42.0f);
                instancePath.cubicTo(18.576628f, 42.0f, 6.0838094f, 33.45712f, -1.0963674E-11f, 21.0f);
                instancePath.cubicTo(6.0838094f, 8.542883f, 18.576628f, 0.0f, 33.0f, 0.0f);
                instancePath.close();
                instancePath.moveTo(33.0f, 29.4f);
                instancePath.cubicTo(37.63919f, 29.4f, 41.4f, 25.639193f, 41.4f, 21.0f);
                instancePath.cubicTo(41.4f, 16.360807f, 37.63919f, 12.6f, 33.0f, 12.6f);
                instancePath.cubicTo(28.360807f, 12.6f, 24.6f, 16.360807f, 24.6f, 21.0f);
                instancePath.cubicTo(24.6f, 25.639193f, 28.360807f, 29.4f, 33.0f, 29.4f);
                instancePath.close();
                instancePath.moveTo(33.0f, 33.0f);
                instancePath.cubicTo(26.372583f, 33.0f, 21.0f, 27.627417f, 21.0f, 21.0f);
                instancePath.cubicTo(21.0f, 14.372583f, 26.372583f, 9.0f, 33.0f, 9.0f);
                instancePath.cubicTo(39.62742f, 9.0f, 45.0f, 14.372583f, 45.0f, 21.0f);
                instancePath.cubicTo(45.0f, 27.627417f, 39.62742f, 33.0f, 33.0f, 33.0f);
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
