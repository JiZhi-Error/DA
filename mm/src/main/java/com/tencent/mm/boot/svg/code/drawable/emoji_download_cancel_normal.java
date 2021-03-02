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

public class emoji_download_cancel_normal extends c {
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
                instancePaint3.setColor(-8947849);
                canvas.saveLayerAlpha(null, TbsListener.ErrorCode.TPATCH_FAIL, 31);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(27.26f, 0.0f);
                instancePath.lineTo(32.62f, 0.0f);
                instancePath.cubicTo(46.7f, 1.17f, 58.74f, 13.2f, 60.0f, 27.26f);
                instancePath.lineTo(60.0f, 32.63f);
                instancePath.cubicTo(58.82f, 46.7f, 46.8f, 58.74f, 32.74f, 60.0f);
                instancePath.lineTo(27.39f, 60.0f);
                instancePath.cubicTo(13.31f, 58.84f, 1.26f, 46.81f, 0.0f, 32.75f);
                instancePath.lineTo(0.0f, 27.37f);
                instancePath.cubicTo(1.18f, 13.3f, 13.2f, 1.26f, 27.26f, 0.0f);
                instancePath.lineTo(27.26f, 0.0f);
                instancePath.close();
                instancePath.moveTo(24.42f, 2.54f);
                instancePath.cubicTo(10.35f, 5.18f, -0.2f, 19.83f, 2.27f, 34.03f);
                instancePath.cubicTo(4.12f, 48.83f, 19.33f, 60.34f, 34.09f, 57.72f);
                instancePath.cubicTo(48.99f, 55.83f, 60.51f, 40.38f, 57.66f, 25.54f);
                instancePath.cubicTo(55.54f, 10.38f, 39.42f, -1.0f, 24.42f, 2.54f);
                instancePath.lineTo(24.42f, 2.54f);
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
                instancePath2.moveTo(23.42f, 1.54f);
                instancePath2.cubicTo(38.42f, -2.0f, 54.54f, 9.38f, 56.66f, 24.54f);
                instancePath2.cubicTo(59.51f, 39.38f, 47.99f, 54.83f, 33.09f, 56.72f);
                instancePath2.cubicTo(18.33f, 59.34f, 3.12f, 47.83f, 1.27f, 33.03f);
                instancePath2.cubicTo(-1.2f, 18.83f, 9.35f, 4.18f, 23.42f, 1.54f);
                instancePath2.lineTo(23.42f, 1.54f);
                instancePath2.close();
                instancePath2.moveTo(15.79f, 19.84f);
                instancePath2.cubicTo(18.57f, 23.09f, 21.82f, 25.9f, 24.75f, 29.0f);
                instancePath2.cubicTo(21.83f, 32.09f, 18.61f, 34.89f, 15.83f, 38.11f);
                instancePath2.cubicTo(14.2f, 40.53f, 17.34f, 43.76f, 19.81f, 42.23f);
                instancePath2.cubicTo(23.07f, 39.45f, 25.89f, 36.19f, 29.0f, 33.25f);
                instancePath2.cubicTo(32.08f, 36.16f, 34.88f, 39.39f, 38.1f, 42.16f);
                instancePath2.cubicTo(40.53f, 43.85f, 43.82f, 40.58f, 42.18f, 38.13f);
                instancePath2.cubicTo(39.41f, 34.89f, 36.17f, 32.1f, 33.25f, 29.0f);
                instancePath2.cubicTo(36.17f, 25.91f, 39.4f, 23.11f, 42.17f, 19.89f);
                instancePath2.cubicTo(43.83f, 17.44f, 40.55f, 14.16f, 38.11f, 15.83f);
                instancePath2.cubicTo(34.89f, 18.6f, 32.09f, 21.83f, 29.0f, 24.75f);
                instancePath2.cubicTo(25.91f, 21.82f, 23.1f, 18.59f, 19.87f, 15.81f);
                instancePath2.cubicTo(17.43f, 14.21f, 14.22f, 17.39f, 15.79f, 19.84f);
                instancePath2.lineTo(15.79f, 19.84f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                instancePaint7.setColor(-8355712);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 16.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint7, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(0.79f, 4.84f);
                instancePath3.cubicTo(-0.78f, 2.39f, 2.43f, -0.79f, 4.87f, 0.81f);
                instancePath3.cubicTo(8.1f, 3.59f, 10.91f, 6.82f, 14.0f, 9.75f);
                instancePath3.cubicTo(17.09f, 6.83f, 19.89f, 3.6f, 23.11f, 0.83f);
                instancePath3.cubicTo(25.55f, -0.84f, 28.83f, 2.44f, 27.17f, 4.89f);
                instancePath3.cubicTo(24.4f, 8.11f, 21.17f, 10.91f, 18.25f, 14.0f);
                instancePath3.cubicTo(21.17f, 17.1f, 24.41f, 19.89f, 27.18f, 23.13f);
                instancePath3.cubicTo(28.82f, 25.58f, 25.53f, 28.85f, 23.1f, 27.16f);
                instancePath3.cubicTo(19.88f, 24.39f, 17.08f, 21.16f, 14.0f, 18.25f);
                instancePath3.cubicTo(10.89f, 21.19f, 8.07f, 24.45f, 4.81f, 27.23f);
                instancePath3.cubicTo(2.34f, 28.76f, -0.8f, 25.53f, 0.83f, 23.11f);
                instancePath3.cubicTo(3.61f, 19.89f, 6.83f, 17.09f, 9.75f, 14.0f);
                instancePath3.cubicTo(6.82f, 10.9f, 3.57f, 8.09f, 0.79f, 4.84f);
                instancePath3.lineTo(0.79f, 4.84f);
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
