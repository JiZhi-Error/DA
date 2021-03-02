package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fts_video_list_next_btn extends c {
    private final int height = 33;
    private final int width = 38;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 38;
            case 1:
                return 33;
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
                instancePaint3.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -480.0f, 0.0f, 1.0f, -190.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(504.54526f, 207.37386f);
                instancePath.lineTo(481.53622f, 221.99107f);
                instancePath.lineTo(481.53622f, 221.99107f);
                instancePath.cubicTo(481.07007f, 222.28723f, 480.4521f, 222.1494f, 480.1559f, 221.68323f);
                instancePath.cubicTo(480.05408f, 221.52292f, 480.0f, 221.33693f, 480.0f, 221.147f);
                instancePath.lineTo(480.0f, 191.00273f);
                instancePath.lineTo(480.0f, 191.00273f);
                instancePath.cubicTo(480.0f, 190.45044f, 480.44772f, 190.00273f, 481.0f, 190.00273f);
                instancePath.cubicTo(481.19934f, 190.00273f, 481.39413f, 190.0623f, 481.5594f, 190.17381f);
                instancePath.lineTo(504.5684f, 205.70087f);
                instancePath.cubicTo(505.02618f, 206.00981f, 505.14688f, 206.63136f, 504.83795f, 207.08916f);
                instancePath.cubicTo(504.761f, 207.20319f, 504.66135f, 207.3001f, 504.54526f, 207.37386f);
                instancePath.lineTo(504.54526f, 207.37386f);
                instancePath.close();
                instancePath.moveTo(511.0f, 190.00006f);
                instancePath.lineTo(517.0f, 190.00006f);
                instancePath.lineTo(517.0f, 190.00006f);
                instancePath.cubicTo(517.5523f, 190.00006f, 518.0f, 190.44777f, 518.0f, 191.00006f);
                instancePath.lineTo(518.0f, 221.0f);
                instancePath.lineTo(518.0f, 221.0f);
                instancePath.cubicTo(518.0f, 221.55229f, 517.5523f, 222.0f, 517.0f, 222.0f);
                instancePath.lineTo(511.0f, 222.0f);
                instancePath.lineTo(511.0f, 222.0f);
                instancePath.cubicTo(510.44772f, 222.0f, 510.0f, 221.55229f, 510.0f, 221.0f);
                instancePath.lineTo(510.0f, 191.00006f);
                instancePath.lineTo(510.0f, 191.00006f);
                instancePath.cubicTo(510.0f, 190.44777f, 510.44772f, 190.00006f, 511.0f, 190.00006f);
                instancePath.lineTo(511.0f, 190.00006f);
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
