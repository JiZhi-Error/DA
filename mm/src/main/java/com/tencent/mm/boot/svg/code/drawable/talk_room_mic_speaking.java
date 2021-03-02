package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class talk_room_mic_speaking extends c {
    private final int height = 80;
    private final int width = 80;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 80;
            case 1:
                return 80;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.3333334f, 0.0f, 0.0f, 0.0f, 1.3333334f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-6626030);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(36.83f, 10.18f);
                instancePath.cubicTo(38.71f, 8.29f, 40.59f, 6.41f, 42.48f, 4.54f);
                instancePath.cubicTo(53.62f, 15.45f, 56.31f, 33.8f, 48.53f, 47.35f);
                instancePath.cubicTo(46.75f, 50.69f, 44.3f, 53.6f, 41.66f, 56.28f);
                instancePath.cubicTo(39.84f, 54.34f, 38.0f, 52.42f, 36.19f, 50.48f);
                instancePath.cubicTo(41.15f, 45.64f, 44.46f, 39.07f, 44.9f, 32.11f);
                instancePath.cubicTo(45.62f, 24.06f, 42.44f, 15.94f, 36.83f, 10.18f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-6626030);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(29.09f, 17.92f);
                instancePath2.cubicTo(30.73f, 16.27f, 32.37f, 14.63f, 34.02f, 12.99f);
                instancePath2.cubicTo(39.1f, 18.26f, 41.84f, 25.78f, 40.78f, 33.09f);
                instancePath2.cubicTo(40.19f, 38.61f, 37.33f, 43.62f, 33.49f, 47.54f);
                instancePath2.cubicTo(31.88f, 45.86f, 30.27f, 44.18f, 28.68f, 42.48f);
                instancePath2.cubicTo(35.5f, 36.1f, 35.71f, 24.52f, 29.09f, 17.92f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-6626030);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(13.42f, 19.61f);
                instancePath3.cubicTo(19.82f, 17.14f, 27.45f, 22.12f, 27.94f, 28.9f);
                instancePath3.cubicTo(28.83f, 35.53f, 22.57f, 41.8f, 15.94f, 40.95f);
                instancePath3.cubicTo(9.72f, 40.5f, 4.88f, 34.08f, 6.19f, 27.96f);
                instancePath3.cubicTo(6.92f, 24.17f, 9.75f, 20.85f, 13.42f, 19.61f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
