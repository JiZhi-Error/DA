package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sight_record_icon extends c {
    private final int height = 144;
    private final int width = 144;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                instancePaint3.setColor(-2565928);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(18.6f, 55.014008f);
                instancePath.cubicTo(18.53468f, 55.004772f, 18.467905f, 55.0f, 18.4f, 55.0f);
                instancePath.cubicTo(17.62141f, 55.0f, 17.0f, 55.6296f, 17.0f, 56.40625f);
                instancePath.lineTo(17.0f, 62.59375f);
                instancePath.cubicTo(17.0f, 63.381393f, 17.6268f, 64.0f, 18.4f, 64.0f);
                instancePath.cubicTo(18.467968f, 64.0f, 18.534737f, 63.9952f, 18.6f, 63.985928f);
                instancePath.lineTo(18.6f, 64.0f);
                instancePath.lineTo(21.0f, 64.0f);
                instancePath.lineTo(21.0f, 55.0f);
                instancePath.lineTo(18.6f, 55.0f);
                instancePath.lineTo(18.6f, 55.014008f);
                instancePath.close();
                instancePath.moveTo(97.0f, 63.123047f);
                instancePath.lineTo(120.11719f, 49.0f);
                instancePath.lineTo(120.11719f, 95.0f);
                instancePath.lineTo(97.0f, 81.11865f);
                instancePath.lineTo(97.0f, 63.123047f);
                instancePath.close();
                instancePath.moveTo(23.0f, 48.994312f);
                instancePath.cubicTo(23.0f, 44.579174f, 26.581768f, 41.0f, 31.006588f, 41.0f);
                instancePath.lineTo(85.993416f, 41.0f);
                instancePath.cubicTo(90.41533f, 41.0f, 94.0f, 44.57869f, 94.0f, 48.994312f);
                instancePath.lineTo(94.0f, 95.005684f);
                instancePath.cubicTo(94.0f, 99.42082f, 90.41823f, 103.0f, 85.993416f, 103.0f);
                instancePath.lineTo(31.006588f, 103.0f);
                instancePath.cubicTo(26.584671f, 103.0f, 23.0f, 99.42131f, 23.0f, 95.005684f);
                instancePath.lineTo(23.0f, 48.994312f);
                instancePath.close();
                instancePath.moveTo(122.0f, 48.0f);
                instancePath.lineTo(126.0f, 48.0f);
                instancePath.lineTo(126.0f, 96.0f);
                instancePath.lineTo(122.0f, 96.0f);
                instancePath.lineTo(122.0f, 48.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(18.6f, 55.014008f);
                instancePath2.cubicTo(18.53468f, 55.004772f, 18.467905f, 55.0f, 18.4f, 55.0f);
                instancePath2.cubicTo(17.62141f, 55.0f, 17.0f, 55.6296f, 17.0f, 56.40625f);
                instancePath2.lineTo(17.0f, 62.59375f);
                instancePath2.cubicTo(17.0f, 63.381393f, 17.6268f, 64.0f, 18.4f, 64.0f);
                instancePath2.cubicTo(18.467968f, 64.0f, 18.534737f, 63.9952f, 18.6f, 63.985928f);
                instancePath2.lineTo(18.6f, 64.0f);
                instancePath2.lineTo(21.0f, 64.0f);
                instancePath2.lineTo(21.0f, 55.0f);
                instancePath2.lineTo(18.6f, 55.0f);
                instancePath2.lineTo(18.6f, 55.014008f);
                instancePath2.close();
                instancePath2.moveTo(97.0f, 63.123047f);
                instancePath2.lineTo(120.11719f, 49.0f);
                instancePath2.lineTo(120.11719f, 95.0f);
                instancePath2.lineTo(97.0f, 81.11865f);
                instancePath2.lineTo(97.0f, 63.123047f);
                instancePath2.close();
                instancePath2.moveTo(23.0f, 48.994312f);
                instancePath2.cubicTo(23.0f, 44.579174f, 26.581768f, 41.0f, 31.006588f, 41.0f);
                instancePath2.lineTo(85.993416f, 41.0f);
                instancePath2.cubicTo(90.41533f, 41.0f, 94.0f, 44.57869f, 94.0f, 48.994312f);
                instancePath2.lineTo(94.0f, 95.005684f);
                instancePath2.cubicTo(94.0f, 99.42082f, 90.41823f, 103.0f, 85.993416f, 103.0f);
                instancePath2.lineTo(31.006588f, 103.0f);
                instancePath2.cubicTo(26.584671f, 103.0f, 23.0f, 99.42131f, 23.0f, 95.005684f);
                instancePath2.lineTo(23.0f, 48.994312f);
                instancePath2.close();
                instancePath2.moveTo(122.0f, 48.0f);
                instancePath2.lineTo(126.0f, 48.0f);
                instancePath2.lineTo(126.0f, 96.0f);
                instancePath2.lineTo(122.0f, 96.0f);
                instancePath2.lineTo(122.0f, 48.0f);
                instancePath2.close();
                Paint instancePaint6 = c.instancePaint(looper);
                instancePaint6.setFlags(385);
                instancePaint6.setStyle(Paint.Style.FILL);
                Paint instancePaint7 = c.instancePaint(looper);
                instancePaint7.setFlags(385);
                instancePaint7.setStyle(Paint.Style.STROKE);
                instancePaint6.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint7.setStrokeWidth(1.0f);
                instancePaint7.setStrokeCap(Paint.Cap.BUTT);
                instancePaint7.setStrokeJoin(Paint.Join.MITER);
                instancePaint7.setStrokeMiter(4.0f);
                instancePaint7.setPathEffect(null);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 126.0f, 0.0f, 17.0f, 0.0f, 103.0f, 41.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                WeChatSVGRenderC2Java.setLinearGradient(instancePaint5, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-9772465, -6687207}, new float[]{0.0f, 1.0f}, instanceMatrix, 0);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
