package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.WebView;

public class emoji_download_cancel_pressed extends c {
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
                instancePaint3.setColor(-12040120);
                canvas.saveLayerAlpha(null, TbsListener.ErrorCode.TPATCH_FAIL, 31);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(27.26f, 0.0f);
                instancePath.lineTo(32.6f, 0.0f);
                instancePath.cubicTo(46.68f, 1.16f, 58.73f, 13.18f, 60.0f, 27.24f);
                instancePath.lineTo(60.0f, 32.6f);
                instancePath.cubicTo(58.84f, 46.68f, 46.82f, 58.72f, 32.76f, 60.0f);
                instancePath.lineTo(27.37f, 60.0f);
                instancePath.cubicTo(13.3f, 58.82f, 1.27f, 46.81f, 0.0f, 32.76f);
                instancePath.lineTo(0.0f, 27.38f);
                instancePath.cubicTo(1.17f, 13.3f, 13.2f, 1.26f, 27.26f, 0.0f);
                instancePath.lineTo(27.26f, 0.0f);
                instancePath.close();
                instancePath.moveTo(26.24f, 2.26f);
                instancePath.cubicTo(12.44f, 3.91f, 1.18f, 17.11f, 2.04f, 31.04f);
                instancePath.cubicTo(2.23f, 45.91f, 16.12f, 58.89f, 30.99f, 57.97f);
                instancePath.cubicTo(45.9f, 57.8f, 58.9f, 43.88f, 57.96f, 28.98f);
                instancePath.cubicTo(57.82f, 13.07f, 41.98f, -0.35f, 26.24f, 2.26f);
                instancePath.lineTo(26.24f, 2.26f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint5, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(25.24f, 1.26f);
                instancePath2.cubicTo(40.98f, -1.35f, 56.82f, 12.07f, 56.96f, 27.98f);
                instancePath2.cubicTo(57.9f, 42.88f, 44.9f, 56.8f, 29.99f, 56.97f);
                instancePath2.cubicTo(15.12f, 57.89f, 1.23f, 44.91f, 1.04f, 30.04f);
                instancePath2.cubicTo(0.18f, 16.11f, 11.44f, 2.91f, 25.24f, 1.26f);
                instancePath2.lineTo(25.24f, 1.26f);
                instancePath2.close();
                instancePath2.moveTo(15.83f, 19.89f);
                instancePath2.cubicTo(18.61f, 23.11f, 21.82f, 25.92f, 24.75f, 29.0f);
                instancePath2.cubicTo(21.81f, 32.09f, 18.58f, 34.91f, 15.8f, 38.15f);
                instancePath2.cubicTo(14.21f, 40.6f, 17.43f, 43.8f, 19.87f, 42.19f);
                instancePath2.cubicTo(23.1f, 39.4f, 25.92f, 36.19f, 29.0f, 33.25f);
                instancePath2.cubicTo(32.11f, 36.2f, 34.94f, 39.45f, 38.2f, 42.24f);
                instancePath2.cubicTo(40.67f, 43.73f, 43.8f, 40.53f, 42.17f, 38.11f);
                instancePath2.cubicTo(39.39f, 34.89f, 36.18f, 32.08f, 33.25f, 29.0f);
                instancePath2.cubicTo(36.19f, 25.91f, 39.41f, 23.09f, 42.19f, 19.87f);
                instancePath2.cubicTo(43.79f, 17.42f, 40.6f, 14.22f, 38.14f, 15.8f);
                instancePath2.cubicTo(34.91f, 18.58f, 32.09f, 21.81f, 29.0f, 24.75f);
                instancePath2.cubicTo(25.92f, 21.82f, 23.11f, 18.61f, 19.89f, 15.83f);
                instancePath2.cubicTo(17.44f, 14.17f, 14.15f, 17.44f, 15.83f, 19.89f);
                instancePath2.lineTo(15.83f, 19.89f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                instancePaint7.setColor(-11711155);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 16.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint7, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(0.83f, 4.89f);
                instancePath3.cubicTo(-0.85f, 2.44f, 2.44f, -0.83f, 4.89f, 0.83f);
                instancePath3.cubicTo(8.11f, 3.61f, 10.92f, 6.82f, 14.0f, 9.75f);
                instancePath3.cubicTo(17.09f, 6.81f, 19.91f, 3.58f, 23.14f, 0.8f);
                instancePath3.cubicTo(25.6f, -0.78f, 28.79f, 2.42f, 27.19f, 4.87f);
                instancePath3.cubicTo(24.41f, 8.09f, 21.19f, 10.91f, 18.25f, 14.0f);
                instancePath3.cubicTo(21.18f, 17.08f, 24.39f, 19.89f, 27.17f, 23.11f);
                instancePath3.cubicTo(28.8f, 25.53f, 25.67f, 28.73f, 23.2f, 27.24f);
                instancePath3.cubicTo(19.94f, 24.45f, 17.11f, 21.2f, 14.0f, 18.25f);
                instancePath3.cubicTo(10.92f, 21.19f, 8.1f, 24.4f, 4.87f, 27.19f);
                instancePath3.cubicTo(2.43f, 28.8f, -0.79f, 25.6f, 0.8f, 23.15f);
                instancePath3.cubicTo(3.58f, 19.91f, 6.81f, 17.09f, 9.75f, 14.0f);
                instancePath3.cubicTo(6.82f, 10.92f, 3.61f, 8.11f, 0.83f, 4.89f);
                instancePath3.lineTo(0.83f, 4.89f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint8);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
