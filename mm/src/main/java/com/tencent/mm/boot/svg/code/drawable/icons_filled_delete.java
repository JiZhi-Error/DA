package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_delete extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 6.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(46.235294f, 13.500007f);
                instancePath.lineTo(43.832214f, 54.352333f);
                instancePath.cubicTo(43.645664f, 57.52371f, 41.01943f, 60.0f, 37.84257f, 60.0f);
                instancePath.lineTo(16.15743f, 60.0f);
                instancePath.cubicTo(12.980573f, 60.0f, 10.354336f, 57.52371f, 10.167784f, 54.352333f);
                instancePath.lineTo(7.764706f, 13.500007f);
                instancePath.lineTo(1.5f, 13.500007f);
                instancePath.lineTo(1.5f, 10.5f);
                instancePath.cubicTo(1.5f, 9.671573f, 2.171573f, 9.0f, 3.0f, 9.0f);
                instancePath.lineTo(51.0f, 9.0f);
                instancePath.cubicTo(51.828426f, 9.0f, 52.5f, 9.671573f, 52.5f, 10.5f);
                instancePath.lineTo(52.5f, 13.500007f);
                instancePath.lineTo(46.235294f, 13.500007f);
                instancePath.close();
                instancePath.moveTo(21.0f, 1.5001023f);
                instancePath.lineTo(33.0f, 1.5001023f);
                instancePath.cubicTo(33.828426f, 1.5001023f, 34.5f, 2.1716752f, 34.5f, 3.0001023f);
                instancePath.lineTo(34.5f, 6.0f);
                instancePath.lineTo(19.5f, 6.0f);
                instancePath.lineTo(19.5f, 3.0001023f);
                instancePath.cubicTo(19.5f, 2.1716752f, 20.171574f, 1.5001023f, 21.0f, 1.5001023f);
                instancePath.close();
                instancePath.moveTo(18.0f, 20.999945f);
                instancePath.lineTo(19.5f, 47.99998f);
                instancePath.lineTo(24.0f, 47.99998f);
                instancePath.lineTo(22.800001f, 20.999945f);
                instancePath.lineTo(18.0f, 20.999945f);
                instancePath.close();
                instancePath.moveTo(31.5f, 20.999945f);
                instancePath.lineTo(30.0f, 47.99998f);
                instancePath.lineTo(34.5f, 47.99998f);
                instancePath.lineTo(36.0f, 20.999945f);
                instancePath.lineTo(31.5f, 20.999945f);
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
