package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_camera_switch extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 12.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(38.197224f, 5.551115E-15f);
                instancePath.cubicTo(38.698753f, 5.4589855E-15f, 39.167103f, 0.25065172f, 39.4453f, 0.6679497f);
                instancePath.lineTo(45.0f, 9.0f);
                instancePath.lineTo(57.0f, 9.0f);
                instancePath.cubicTo(58.656853f, 9.0f, 60.0f, 10.343145f, 60.0f, 12.0f);
                instancePath.lineTo(60.0f, 45.0f);
                instancePath.cubicTo(60.0f, 46.656853f, 58.656853f, 48.0f, 57.0f, 48.0f);
                instancePath.lineTo(3.0f, 48.0f);
                instancePath.cubicTo(1.3431457f, 48.0f, 6.8642445E-15f, 46.656853f, 6.661338E-15f, 45.0f);
                instancePath.lineTo(7.1054274E-15f, 12.0f);
                instancePath.cubicTo(6.902521E-15f, 10.343145f, 1.3431457f, 9.0f, 3.0f, 9.0f);
                instancePath.lineTo(15.0f, 9.0f);
                instancePath.lineTo(20.5547f, 0.6679497f);
                instancePath.cubicTo(20.8329f, 0.25065172f, 21.301247f, -3.4646604E-15f, 21.802776f, -2.220446E-15f);
                instancePath.lineTo(38.197224f, 0.0f);
                instancePath.close();
                instancePath.moveTo(23.1f, 36.819073f);
                instancePath.cubicTo(25.051779f, 38.19314f, 27.431664f, 39.0f, 30.0f, 39.0f);
                instancePath.cubicTo(36.62742f, 39.0f, 42.0f, 33.62742f, 42.0f, 27.0f);
                instancePath.lineTo(38.4f, 27.0f);
                instancePath.cubicTo(38.4f, 31.639193f, 34.63919f, 35.4f, 30.0f, 35.4f);
                instancePath.cubicTo(28.070463f, 35.4f, 26.254343f, 34.746292f, 24.801285f, 33.6f);
                instancePath.lineTo(28.5f, 33.6f);
                instancePath.lineTo(28.5f, 30.0f);
                instancePath.lineTo(21.0f, 30.0f);
                instancePath.cubicTo(20.171574f, 30.0f, 19.5f, 30.671574f, 19.5f, 31.5f);
                instancePath.lineTo(19.5f, 33.6f);
                instancePath.lineTo(19.5f, 39.0f);
                instancePath.lineTo(23.1f, 39.0f);
                instancePath.lineTo(23.1f, 36.819073f);
                instancePath.close();
                instancePath.moveTo(36.9f, 17.18093f);
                instancePath.cubicTo(34.94822f, 15.806861f, 32.568336f, 15.0f, 30.0f, 15.0f);
                instancePath.cubicTo(23.372583f, 15.0f, 18.0f, 20.372583f, 18.0f, 27.0f);
                instancePath.lineTo(21.6f, 27.0f);
                instancePath.cubicTo(21.6f, 22.360807f, 25.360807f, 18.6f, 30.0f, 18.6f);
                instancePath.cubicTo(31.931503f, 18.6f, 33.747807f, 19.255857f, 35.198837f, 20.4f);
                instancePath.lineTo(31.5f, 20.4f);
                instancePath.lineTo(31.5f, 24.0f);
                instancePath.lineTo(36.9f, 24.0f);
                instancePath.lineTo(39.0f, 24.0f);
                instancePath.cubicTo(39.828426f, 24.0f, 40.5f, 23.328426f, 40.5f, 22.5f);
                instancePath.lineTo(40.5f, 15.0f);
                instancePath.lineTo(36.9f, 15.0f);
                instancePath.lineTo(36.9f, 17.18093f);
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
