package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fts_video_list_share extends c {
    private final int height = 20;
    private final int width = 15;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 15;
            case 1:
                return 20;
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
                canvas.save();
                c.instancePaint(instancePaint2, looper).setStrokeWidth(1.0f);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -278.0f, 0.0f, 1.0f, -114.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(286.1f, 115.882835f);
                instancePath.lineTo(286.1f, 125.12132f);
                instancePath.lineTo(284.9f, 125.12132f);
                instancePath.lineTo(284.9f, 115.88285f);
                instancePath.lineTo(282.813f, 117.96985f);
                instancePath.lineTo(281.96448f, 117.12132f);
                instancePath.lineTo(284.7929f, 114.29289f);
                instancePath.cubicTo(285.1834f, 113.90237f, 285.8166f, 113.90237f, 286.2071f, 114.29289f);
                instancePath.lineTo(286.34854f, 114.43432f);
                instancePath.lineTo(289.03552f, 117.12132f);
                instancePath.lineTo(288.187f, 117.96985f);
                instancePath.lineTo(286.1f, 115.882835f);
                instancePath.close();
                instancePath.moveTo(281.0f, 118.62132f);
                instancePath.lineTo(281.0f, 119.82132f);
                instancePath.lineTo(279.2f, 119.82132f);
                instancePath.lineTo(279.2f, 132.42133f);
                instancePath.lineTo(291.8f, 132.42133f);
                instancePath.lineTo(291.8f, 119.82132f);
                instancePath.lineTo(290.0f, 119.82132f);
                instancePath.lineTo(290.0f, 118.62132f);
                instancePath.lineTo(292.00104f, 118.62132f);
                instancePath.cubicTo(292.55087f, 118.62132f, 293.0f, 119.06716f, 293.0f, 119.61713f);
                instancePath.lineTo(293.0f, 132.62552f);
                instancePath.cubicTo(293.0f, 133.1724f, 292.55417f, 133.62132f, 292.00418f, 133.62132f);
                instancePath.lineTo(278.99582f, 133.62132f);
                instancePath.cubicTo(278.4489f, 133.62132f, 278.0f, 133.17548f, 278.0f, 132.62552f);
                instancePath.lineTo(278.0f, 119.61713f);
                instancePath.cubicTo(278.0f, 119.070244f, 278.44724f, 118.62132f, 278.99896f, 118.62132f);
                instancePath.lineTo(281.0f, 118.62132f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
