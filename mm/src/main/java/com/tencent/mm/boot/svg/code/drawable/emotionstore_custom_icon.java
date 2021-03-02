package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class emotionstore_custom_icon extends c {
    private final int height = 72;
    private final int width = 72;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                instancePath.moveTo(35.5f, 14.333468f);
                instancePath.cubicTo(34.08226f, 12.584894f, 29.636719f, 8.0f, 22.0f, 8.0f);
                instancePath.cubicTo(12.603008f, 8.0f, 4.999999f, 15.031532f, 5.0f, 24.0f);
                instancePath.cubicTo(5.000001f, 34.14707f, 12.338594f, 50.355007f, 36.0f, 63.0f);
                instancePath.cubicTo(58.78113f, 50.364376f, 66.0f, 34.127697f, 66.0f, 24.0f);
                instancePath.cubicTo(66.0f, 15.026322f, 58.39699f, 8.0f, 49.0f, 8.0f);
                instancePath.cubicTo(41.36328f, 8.0f, 36.91774f, 12.584894f, 35.5f, 14.333468f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(35.5f, 14.333468f);
                instancePath2.cubicTo(34.08226f, 12.584894f, 29.636719f, 8.0f, 22.0f, 8.0f);
                instancePath2.cubicTo(12.603008f, 8.0f, 4.999999f, 15.031532f, 5.0f, 24.0f);
                instancePath2.cubicTo(5.000001f, 34.14707f, 12.338594f, 50.355007f, 36.0f, 63.0f);
                instancePath2.cubicTo(58.78113f, 50.364376f, 66.0f, 34.127697f, 66.0f, 24.0f);
                instancePath2.cubicTo(66.0f, 15.026322f, 58.39699f, 8.0f, 49.0f, 8.0f);
                instancePath2.cubicTo(41.36328f, 8.0f, 36.91774f, 12.584894f, 35.5f, 14.333468f);
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 66.0f, 0.0f, 4.999999f, 0.0f, 63.0f, 8.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                WeChatSVGRenderC2Java.setLinearGradient(instancePaint5, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-33702, -44260}, new float[]{0.0f, 1.0f}, instanceMatrix, 0);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
