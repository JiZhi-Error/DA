package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sns_shoot_twitter_pressed extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-12799249);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 5.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(1.04f, 5.81f);
                instancePath.cubicTo(0.91f, 1.08f, 7.16f, -1.81f, 10.71f, 1.3f);
                instancePath.cubicTo(14.01f, 3.84f, 12.8f, 8.42f, 13.0f, 12.0f);
                instancePath.cubicTo(18.34f, 12.05f, 23.69f, 11.9f, 29.04f, 12.06f);
                instancePath.cubicTo(32.6f, 11.89f, 35.62f, 15.51f, 34.91f, 18.99f);
                instancePath.cubicTo(34.51f, 21.75f, 31.93f, 24.02f, 29.12f, 23.95f);
                instancePath.cubicTo(23.75f, 24.1f, 18.38f, 23.95f, 13.01f, 24.0f);
                instancePath.cubicTo(13.22f, 27.54f, 11.9f, 32.22f, 15.35f, 34.62f);
                instancePath.cubicTo(19.65f, 37.31f, 25.03f, 34.96f, 29.6f, 36.6f);
                instancePath.cubicTo(33.23f, 38.19f, 34.16f, 43.54f, 31.23f, 46.24f);
                instancePath.cubicTo(28.55f, 48.93f, 24.42f, 47.74f, 21.03f, 48.02f);
                instancePath.cubicTo(15.1f, 48.47f, 8.72f, 46.94f, 4.53f, 42.5f);
                instancePath.cubicTo(1.84f, 39.75f, 0.9f, 35.8f, 1.0f, 32.05f);
                instancePath.cubicTo(1.03f, 23.3f, 0.94f, 14.55f, 1.04f, 5.81f);
                instancePath.lineTo(1.04f, 5.81f);
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
