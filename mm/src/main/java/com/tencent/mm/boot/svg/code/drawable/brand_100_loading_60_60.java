package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class brand_100_loading_60_60 extends c {
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
                canvas.saveLayerAlpha(null, 230, 31);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(30.0f, 0.0f);
                instancePath.cubicTo(46.568542f, 0.0f, 60.0f, 13.4314575f, 60.0f, 30.0f);
                instancePath.cubicTo(60.0f, 46.568542f, 46.568542f, 60.0f, 30.0f, 60.0f);
                instancePath.lineTo(30.0f, 54.75f);
                instancePath.cubicTo(43.66905f, 54.75f, 54.75f, 43.66905f, 54.75f, 30.0f);
                instancePath.cubicTo(54.75f, 16.330952f, 43.66905f, 5.25f, 30.0f, 5.25f);
                instancePath.lineTo(30.0f, 0.0f);
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 60.0f, 0.0f, 30.0f, 0.0f, 60.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                WeChatSVGRenderC2Java.setLinearGradient(instancePaint3, 0.94086915f, 0.0f, 0.94086915f, 0.90559083f, new int[]{508256, 1275576672}, new float[]{0.0f, 1.0f}, instanceMatrix, 0);
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(30.0f, 0.0f);
                instancePath2.lineTo(30.0f, 5.25f);
                instancePath2.cubicTo(16.330952f, 5.25f, 5.25f, 16.330952f, 5.25f, 30.0f);
                instancePath2.cubicTo(5.25f, 43.66905f, 16.330952f, 54.75f, 30.0f, 54.75f);
                instancePath2.lineTo(30.0f, 60.0f);
                instancePath2.cubicTo(13.4314575f, 60.0f, 0.0f, 46.568542f, 0.0f, 30.0f);
                instancePath2.cubicTo(0.0f, 13.4314575f, 13.4314575f, 0.0f, 30.0f, 0.0f);
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
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 30.0f, 0.0f, 0.0f, 0.0f, 60.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                WeChatSVGRenderC2Java.setLinearGradient(instancePaint6, 1.0f, 0.08673706f, 1.0f, 0.9062866f, new int[]{-16268960, 1275576672}, new float[]{0.0f, 1.0f}, instanceMatrix, 0);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint, looper);
                instancePaint9.setColor(-16268960);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(30.375f, 0.0f);
                instancePath3.cubicTo(31.824747f, 0.0f, 33.0f, 1.1752524f, 33.0f, 2.625f);
                instancePath3.cubicTo(33.0f, 4.0747476f, 31.824747f, 5.25f, 30.375f, 5.25f);
                instancePath3.cubicTo(28.925253f, 5.25f, 27.75f, 4.0747476f, 27.75f, 2.625f);
                instancePath3.cubicTo(27.75f, 1.1752524f, 28.925253f, 0.0f, 30.375f, 0.0f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint9);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
