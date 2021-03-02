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

public class emoji_sync_error extends c {
    private final int height = TbsListener.ErrorCode.EXCEED_INCR_UPDATE;
    private final int width = TbsListener.ErrorCode.EXCEED_INCR_UPDATE;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return TbsListener.ErrorCode.EXCEED_INCR_UPDATE;
            case 1:
                return TbsListener.ErrorCode.EXCEED_INCR_UPDATE;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 25.0f, 0.0f, 1.0f, 60.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1749411);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(78.05f, 2.08f);
                instancePath.cubicTo(92.32f, -2.34f, 108.61f, 0.42f, 120.54f, 9.45f);
                instancePath.cubicTo(131.03f, 17.08f, 138.02f, 29.15f, 139.66f, 42.01f);
                instancePath.cubicTo(150.08f, 40.99f, 160.9f, 45.34f, 167.32f, 53.67f);
                instancePath.cubicTo(174.74f, 62.81f, 176.09f, 76.3f, 170.66f, 86.74f);
                instancePath.cubicTo(165.6f, 96.97f, 154.51f, 103.83f, 143.08f, 103.73f);
                instancePath.cubicTo(107.72f, 103.72f, 72.35f, 103.76f, 36.99f, 103.71f);
                instancePath.cubicTo(21.48f, 103.54f, 6.85f, 92.76f, 2.02f, 78.03f);
                instancePath.cubicTo(-2.32f, 65.62f, 0.47f, 51.06f, 9.16f, 41.18f);
                instancePath.cubicTo(18.37f, 30.18f, 33.97f, 25.52f, 47.79f, 29.14f);
                instancePath.cubicTo(53.35f, 16.31f, 64.62f, 6.08f, 78.05f, 2.08f);
                instancePath.lineTo(78.05f, 2.08f);
                instancePath.close();
                instancePath.moveTo(88.29f, 34.29f);
                instancePath.cubicTo(86.16f, 35.27f, 85.9f, 37.85f, 86.04f, 39.91f);
                instancePath.cubicTo(86.45f, 50.3f, 86.59f, 60.7f, 87.07f, 71.08f);
                instancePath.cubicTo(87.03f, 73.46f, 90.38f, 74.74f, 92.01f, 73.03f);
                instancePath.cubicTo(93.22f, 72.07f, 92.9f, 70.4f, 93.07f, 69.06f);
                instancePath.cubicTo(93.32f, 58.68f, 93.77f, 48.31f, 93.96f, 37.93f);
                instancePath.cubicTo(94.28f, 34.98f, 90.81f, 32.98f, 88.29f, 34.29f);
                instancePath.lineTo(88.29f, 34.29f);
                instancePath.close();
                instancePath.moveTo(88.38f, 80.23f);
                instancePath.cubicTo(85.15f, 82.09f, 88.2f, 87.31f, 91.36f, 85.43f);
                instancePath.cubicTo(95.05f, 83.76f, 91.72f, 77.96f, 88.38f, 80.23f);
                instancePath.lineTo(88.38f, 80.23f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-1);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 86.0f, 0.0f, 1.0f, 33.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint5, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(2.29f, 1.29f);
                instancePath2.cubicTo(4.81f, -0.02f, 8.28f, 1.98f, 7.96f, 4.93f);
                instancePath2.cubicTo(7.77f, 15.31f, 7.32f, 25.68f, 7.07f, 36.06f);
                instancePath2.cubicTo(6.9f, 37.4f, 7.22f, 39.07f, 6.01f, 40.03f);
                instancePath2.cubicTo(4.38f, 41.74f, 1.03f, 40.46f, 1.07f, 38.08f);
                instancePath2.cubicTo(0.59f, 27.7f, 0.45f, 17.3f, 0.04f, 6.91f);
                instancePath2.cubicTo(-0.1f, 4.85f, 0.16f, 2.27f, 2.29f, 1.29f);
                instancePath2.lineTo(2.29f, 1.29f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint5, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(2.38f, 47.23f);
                instancePath3.cubicTo(5.72f, 44.96f, 9.05f, 50.76f, 5.36f, 52.43f);
                instancePath3.cubicTo(2.2f, 54.31f, -0.85f, 49.09f, 2.38f, 47.23f);
                instancePath3.lineTo(2.38f, 47.23f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint7);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
