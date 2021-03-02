package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_icons_outlined_star extends c {
    private final int height = 24;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                instancePaint3.setColor(-436207616);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(13.941434f, 11.280649f);
                instancePath.lineTo(17.882868f, 7.4387007f);
                instancePath.lineTo(12.435941f, 6.647216f);
                instancePath.lineTo(10.0f, 1.7114618f);
                instancePath.lineTo(7.5640597f, 6.647216f);
                instancePath.lineTo(2.1171317f, 7.4387007f);
                instancePath.lineTo(6.0585656f, 11.280649f);
                instancePath.lineTo(5.1281195f, 16.705568f);
                instancePath.lineTo(10.0f, 14.144269f);
                instancePath.lineTo(14.871881f, 16.705568f);
                instancePath.lineTo(13.941434f, 11.280649f);
                instancePath.close();
                instancePath.moveTo(10.0f, 15.5f);
                instancePath.lineTo(5.3278346f, 17.956303f);
                instancePath.cubicTo(4.8389897f, 18.213305f, 4.2343626f, 18.025356f, 3.977362f, 17.536512f);
                instancePath.cubicTo(3.8750226f, 17.341852f, 3.839708f, 17.118883f, 3.876885f, 16.902126f);
                instancePath.lineTo(4.7691894f, 11.699594f);
                instancePath.lineTo(0.9893278f, 8.01514f);
                instancePath.cubicTo(0.5938442f, 7.629638f, 0.5857519f, 6.996525f, 0.9712531f, 6.6010413f);
                instancePath.cubicTo(1.1247617f, 6.4435577f, 1.3259041f, 6.34107f, 1.5435412f, 6.309446f);
                instancePath.lineTo(6.767181f, 5.5504065f);
                instancePath.lineTo(9.103264f, 0.8169857f);
                instancePath.cubicTo(9.347686f, 0.3217321f, 9.947312f, 0.11839309f, 10.442566f, 0.36281538f);
                instancePath.cubicTo(10.639778f, 0.46014562f, 10.799406f, 0.61977315f, 10.896736f, 0.8169857f);
                instancePath.lineTo(13.232819f, 5.5504065f);
                instancePath.lineTo(18.456459f, 6.309446f);
                instancePath.cubicTo(19.003004f, 6.3888636f, 19.381685f, 6.8963065f, 19.302267f, 7.442851f);
                instancePath.cubicTo(19.270643f, 7.660488f, 19.168156f, 7.8616304f, 19.010672f, 8.01514f);
                instancePath.lineTo(15.230811f, 11.699594f);
                instancePath.lineTo(16.123116f, 16.902126f);
                instancePath.cubicTo(16.216476f, 17.446463f, 15.850888f, 17.963419f, 15.306552f, 18.05678f);
                instancePath.cubicTo(15.089794f, 18.093956f, 14.866826f, 18.058641f, 14.672166f, 17.956303f);
                instancePath.lineTo(10.0f, 15.5f);
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
