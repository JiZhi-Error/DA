package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class scan_translation_hl extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-12470759);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 9.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(34.16953f, 37.009228f);
                instancePath.lineTo(35.931976f, 41.59285f);
                instancePath.lineTo(38.864815f, 41.59285f);
                instancePath.lineTo(32.066803f, 23.913153f);
                instancePath.lineTo(31.717865f, 23.913153f);
                instancePath.lineTo(28.785027f, 23.913153f);
                instancePath.lineTo(21.987013f, 41.59285f);
                instancePath.lineTo(24.919851f, 41.59285f);
                instancePath.lineTo(26.682299f, 37.009228f);
                instancePath.lineTo(34.16953f, 37.009228f);
                instancePath.close();
                instancePath.moveTo(33.162415f, 34.39001f);
                instancePath.lineTo(27.689413f, 34.39001f);
                instancePath.lineTo(30.425915f, 27.273148f);
                instancePath.lineTo(33.162415f, 34.39001f);
                instancePath.close();
                instancePath.moveTo(13.695652f, 9.0f);
                instancePath.lineTo(70.53812f, 9.0f);
                instancePath.cubicTo(73.131454f, 9.0f, 75.233765f, 11.102315f, 75.233765f, 13.695652f);
                instancePath.lineTo(75.233765f, 84.99253f);
                instancePath.cubicTo(75.233765f, 87.58586f, 73.131454f, 89.68818f, 70.53812f, 89.68818f);
                instancePath.lineTo(13.695652f, 89.68818f);
                instancePath.cubicTo(11.102315f, 89.68818f, 9.0f, 87.58586f, 9.0f, 84.99253f);
                instancePath.lineTo(9.0f, 13.695652f);
                instancePath.cubicTo(9.0f, 11.102315f, 11.102315f, 9.0f, 13.695652f, 9.0f);
                instancePath.close();
                instancePath.moveTo(21.042503f, 53.150135f);
                instancePath.lineTo(21.042503f, 57.717392f);
                instancePath.lineTo(63.191265f, 57.717392f);
                instancePath.lineTo(63.191265f, 53.150135f);
                instancePath.lineTo(21.042503f, 53.150135f);
                instancePath.close();
                instancePath.moveTo(21.042503f, 63.807064f);
                instancePath.lineTo(21.042503f, 68.37432f);
                instancePath.lineTo(63.191265f, 68.37432f);
                instancePath.lineTo(63.191265f, 63.807064f);
                instancePath.lineTo(21.042503f, 63.807064f);
                instancePath.close();
                instancePath.moveTo(21.042503f, 72.941574f);
                instancePath.lineTo(21.042503f, 77.508835f);
                instancePath.lineTo(63.191265f, 77.508835f);
                instancePath.lineTo(63.191265f, 72.941574f);
                instancePath.lineTo(21.042503f, 72.941574f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(67.70934f, 6.0869565f);
                instancePath2.lineTo(8.366434f, 6.0869565f);
                instancePath2.cubicTo(7.0697656f, 6.0869565f, 6.018608f, 7.138114f, 6.018608f, 8.434783f);
                instancePath2.lineTo(6.018608f, 82.17391f);
                instancePath2.lineTo(4.695652f, 82.17391f);
                instancePath2.cubicTo(2.1023152f, 82.17391f, -5.705862E-16f, 80.071594f, -8.881784E-16f, 77.478264f);
                instancePath2.lineTo(0.0f, 4.695652f);
                instancePath2.cubicTo(-3.175922E-16f, 2.1023152f, 2.1023152f, 2.2527451E-15f, 4.695652f, 1.7763568E-15f);
                instancePath2.lineTo(63.01369f, 0.0f);
                instancePath2.cubicTo(65.607025f, -5.0830803E-15f, 67.70934f, 2.1023152f, 67.70934f, 4.695652f);
                instancePath2.lineTo(67.70934f, 6.0869565f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
