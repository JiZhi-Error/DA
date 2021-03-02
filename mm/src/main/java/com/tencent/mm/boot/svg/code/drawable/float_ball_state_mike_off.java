package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class float_ball_state_mike_off extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-16268960);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 5.0f, 0.0f, 1.0f, 5.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(13.541667f, 20.833334f);
                instancePath.lineTo(13.541667f, 25.0f);
                instancePath.cubicTo(13.541667f, 31.328262f, 18.671738f, 36.458332f, 25.0f, 36.458332f);
                instancePath.cubicTo(27.028416f, 36.458332f, 28.933727f, 35.931263f, 30.586452f, 35.006607f);
                instancePath.lineTo(32.863476f, 37.283802f);
                instancePath.cubicTo(31.00807f, 38.474003f, 28.865313f, 39.255337f, 26.562386f, 39.50062f);
                instancePath.lineTo(26.5625f, 45.833332f);
                instancePath.lineTo(23.4375f, 45.833332f);
                instancePath.lineTo(23.436659f, 39.50052f);
                instancePath.cubicTo(16.117636f, 38.72049f, 10.416667f, 32.526012f, 10.416667f, 25.0f);
                instancePath.lineTo(10.416667f, 20.833334f);
                instancePath.lineTo(13.541667f, 20.833334f);
                instancePath.close();
                instancePath.moveTo(8.459708f, 8.459708f);
                instancePath.lineTo(10.669417f, 6.25f);
                instancePath.lineTo(16.665709f, 12.246667f);
                instancePath.lineTo(16.666666f, 11.979167f);
                instancePath.cubicTo(16.666666f, 7.7474174f, 20.031206f, 4.3014984f, 24.231165f, 4.1705284f);
                instancePath.lineTo(24.479166f, 4.1666665f);
                instancePath.lineTo(25.520834f, 4.1666665f);
                instancePath.cubicTo(29.752583f, 4.1666665f, 33.1985f, 7.5312057f, 33.32947f, 11.731166f);
                instancePath.lineTo(33.333332f, 11.979167f);
                instancePath.lineTo(33.333332f, 25.520834f);
                instancePath.cubicTo(33.333332f, 26.528337f, 33.14262f, 27.4913f, 32.795326f, 28.375587f);
                instancePath.lineTo(35.00655f, 30.586554f);
                instancePath.cubicTo(35.93124f, 28.933807f, 36.458332f, 27.028458f, 36.458332f, 25.0f);
                instancePath.lineTo(36.45767f, 20.833334f);
                instancePath.lineTo(39.583332f, 20.833334f);
                instancePath.lineTo(39.583332f, 25.0f);
                instancePath.cubicTo(39.583332f, 27.896093f, 38.739136f, 30.595015f, 37.283398f, 32.864105f);
                instancePath.lineTo(46.024757f, 41.60534f);
                instancePath.lineTo(43.81505f, 43.81505f);
                instancePath.lineTo(8.459708f, 8.459708f);
                instancePath.close();
                instancePath.moveTo(16.66471f, 21.083666f);
                instancePath.lineTo(28.375782f, 32.79525f);
                instancePath.cubicTo(27.564268f, 33.113987f, 26.686493f, 33.300858f, 25.768835f, 33.32947f);
                instancePath.lineTo(25.520834f, 33.333332f);
                instancePath.lineTo(24.479166f, 33.333332f);
                instancePath.cubicTo(20.247417f, 33.333332f, 16.801498f, 29.968794f, 16.670528f, 25.768835f);
                instancePath.lineTo(16.666666f, 25.520834f);
                instancePath.lineTo(16.66471f, 21.083666f);
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
