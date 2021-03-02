package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class spinner_16_outer_holo extends c {
    private final int height = 48;
    private final int width = 48;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                canvas.saveLayerAlpha(null, 230, 31);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -287.0f, 0.0f, 1.0f, -642.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 287.0f, 0.0f, 1.0f, 642.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(24.0f, 0.0f);
                instancePath.cubicTo(37.254833f, 0.0f, 48.0f, 10.745166f, 48.0f, 24.0f);
                instancePath.cubicTo(48.0f, 37.254833f, 37.254833f, 48.0f, 24.0f, 48.0f);
                instancePath.lineTo(24.0f, 43.8f);
                instancePath.cubicTo(34.935238f, 43.8f, 43.8f, 34.935238f, 43.8f, 24.0f);
                instancePath.cubicTo(43.8f, 13.064762f, 34.935238f, 4.2f, 24.0f, 4.2f);
                instancePath.lineTo(24.0f, 0.0f);
                instancePath.close();
                Paint instancePaint4 = c.instancePaint(looper);
                instancePaint4.setFlags(385);
                instancePaint4.setStyle(Paint.Style.FILL);
                Paint instancePaint5 = c.instancePaint(looper);
                instancePaint5.setFlags(385);
                instancePaint5.setStyle(Paint.Style.STROKE);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint5.setStrokeWidth(1.0f);
                instancePaint5.setStrokeCap(Paint.Cap.BUTT);
                instancePaint5.setStrokeJoin(Paint.Join.MITER);
                instancePaint5.setStrokeMiter(4.0f);
                instancePaint5.setPathEffect(null);
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 48.0f, 0.0f, 24.0f, 0.0f, 48.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                WeChatSVGRenderC2Java.setLinearGradient(instancePaint3, 0.94086915f, 0.0f, 0.94086915f, 0.90559083f, new int[]{6316128, 1281384544}, new float[]{0.0f, 1.0f}, instanceMatrix, 0);
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(24.0f, 0.0f);
                instancePath2.lineTo(24.0f, 4.2f);
                instancePath2.cubicTo(13.064762f, 4.2f, 4.2f, 13.064762f, 4.2f, 24.0f);
                instancePath2.cubicTo(4.2f, 34.935238f, 13.064762f, 43.8f, 24.0f, 43.8f);
                instancePath2.lineTo(24.0f, 48.0f);
                instancePath2.cubicTo(10.745166f, 48.0f, 0.0f, 37.254833f, 0.0f, 24.0f);
                instancePath2.cubicTo(0.0f, 10.745166f, 10.745166f, 0.0f, 24.0f, 0.0f);
                instancePath2.close();
                Paint instancePaint7 = c.instancePaint(looper);
                instancePaint7.setFlags(385);
                instancePaint7.setStyle(Paint.Style.FILL);
                Paint instancePaint8 = c.instancePaint(looper);
                instancePaint8.setFlags(385);
                instancePaint8.setStyle(Paint.Style.STROKE);
                instancePaint7.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint8.setStrokeWidth(1.0f);
                instancePaint8.setStrokeCap(Paint.Cap.BUTT);
                instancePaint8.setStrokeJoin(Paint.Join.MITER);
                instancePaint8.setStrokeMiter(4.0f);
                instancePaint8.setPathEffect(null);
                float[] matrixFloatArray4 = c.setMatrixFloatArray(matrixFloatArray3, 24.0f, 0.0f, 0.0f, 0.0f, 48.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray4);
                WeChatSVGRenderC2Java.setLinearGradient(instancePaint6, 1.0f, 0.08673706f, 1.0f, 0.9062866f, new int[]{-10461088, 1281384544}, new float[]{0.0f, 1.0f}, instanceMatrix, 0);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint, looper);
                instancePaint9.setColor(-10461088);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(24.3f, 0.0f);
                instancePath3.cubicTo(25.459797f, 0.0f, 26.4f, 0.9402019f, 26.4f, 2.1f);
                instancePath3.cubicTo(26.4f, 3.259798f, 25.459797f, 4.2f, 24.3f, 4.2f);
                instancePath3.cubicTo(23.140202f, 4.2f, 22.199999f, 3.259798f, 22.199999f, 2.1f);
                instancePath3.cubicTo(22.199999f, 0.9402019f, 23.140202f, 0.0f, 24.3f, 0.0f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint9);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
