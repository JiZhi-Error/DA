package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class friendactivity_comment_writeicon_pressed extends c {
    private final int height = 54;
    private final int width = 60;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 60;
            case 1:
                return 54;
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
                instancePaint3.setColor(-2171170);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(1.049754f, 4.9430923f);
                instancePath.cubicTo(0.7401684f, 3.184852f, 1.8986177f, 1.0170214f, 3.875971f, 1.1069314f);
                instancePath.cubicTo(19.59493f, 0.9670714f, 35.333862f, 1.0769614f, 51.052822f, 1.0569814f);
                instancePath.cubicTo(52.84043f, 0.7173214f, 54.937622f, 1.9261116f, 54.897675f, 3.884152f);
                instancePath.cubicTo(55.05746f, 14.303724f, 54.937622f, 24.743277f, 54.957596f, 35.16285f);
                instancePath.cubicTo(55.247208f, 36.92109f, 54.02884f, 39.088917f, 52.051487f, 38.95905f);
                instancePath.cubicTo(42.384426f, 39.088917f, 32.70738f, 38.96904f, 23.030333f, 39.009f);
                instancePath.cubicTo(18.686148f, 41.99601f, 14.361935f, 45.003f, 10.027737f, 48.0f);
                instancePath.lineTo(10.027737f, 39.009f);
                instancePath.cubicTo(7.1515865f, 38.599407f, 2.7974145f, 40.32768f, 1.1995535f, 37.04097f);
                instancePath.cubicTo(0.8400347f, 26.351665f, 1.129647f, 15.632394f, 1.049754f, 4.9430923f);
                instancePath.lineTo(1.049754f, 4.9430923f);
                instancePath.close();
                instancePath.moveTo(7.0f, 7.0f);
                instancePath.lineTo(7.0f, 32.991615f);
                instancePath.lineTo(15.0f, 32.991615f);
                instancePath.cubicTo(15.0f, 34.661076f, 15.0f, 36.33054f, 15.01f, 38.0f);
                instancePath.cubicTo(17.34f, 36.32054f, 19.68f, 34.65108f, 22.03f, 32.981617f);
                instancePath.cubicTo(31.02f, 33.001614f, 40.01f, 32.991615f, 49.0f, 32.991615f);
                instancePath.lineTo(49.0f, 7.0f);
                instancePath.lineTo(7.0f, 7.0f);
                instancePath.lineTo(7.0f, 7.0f);
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
