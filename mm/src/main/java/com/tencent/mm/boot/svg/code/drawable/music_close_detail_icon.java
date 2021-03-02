package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class music_close_detail_icon extends c {
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, -0.70710677f, -0.70710677f, 131.874f, 0.70710677f, -0.70710677f, 32.16815f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(85.83542f, 16.085417f);
                instancePath.cubicTo(86.106865f, 16.356863f, 86.27476f, 16.731863f, 86.27476f, 17.146076f);
                instancePath.lineTo(86.27476f, 69.64608f);
                instancePath.cubicTo(86.27476f, 70.4745f, 85.60318f, 71.14608f, 84.77476f, 71.14608f);
                instancePath.lineTo(81.77476f, 71.14608f);
                instancePath.cubicTo(80.94633f, 71.14608f, 80.27476f, 70.4745f, 80.27476f, 69.64608f);
                instancePath.lineTo(80.27476f, 21.646076f);
                instancePath.lineTo(33.774757f, 21.646076f);
                instancePath.cubicTo(32.94633f, 21.646076f, 32.274757f, 20.974504f, 32.274757f, 20.146076f);
                instancePath.lineTo(32.274757f, 17.146076f);
                instancePath.cubicTo(32.274757f, 16.31765f, 32.94633f, 15.646077f, 33.774757f, 15.646077f);
                instancePath.lineTo(84.77476f, 15.646077f);
                instancePath.cubicTo(85.18897f, 15.646077f, 85.56397f, 15.81397f, 85.83542f, 16.085417f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
