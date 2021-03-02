package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class webview_keep_banner_icon extends c {
    private final int height = 67;
    private final int width = 84;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 84;
            case 1:
                return 67;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.restore();
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-9538696);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(66.83f, 3.1693f);
                instancePath.cubicTo(66.65f, 2.9883f, 66.452f, 2.8253f, 66.239f, 2.6813f);
                instancePath.cubicTo(65.814f, 2.3943f, 65.331f, 2.1873f, 64.811f, 2.0813f);
                instancePath.cubicTo(64.551f, 2.0283f, 64.282f, 2.0003f, 64.006f, 2.0003f);
                instancePath.lineTo(19.994f, 2.0003f);
                instancePath.cubicTo(19.443f, 2.0003f, 18.918f, 2.1123f, 18.44f, 2.3143f);
                instancePath.cubicTo(17.007f, 2.9213f, 16.0f, 4.3433f, 16.0f, 6.0003f);
                instancePath.lineTo(16.0f, 60.9993f);
                instancePath.cubicTo(16.0f, 63.2163f, 17.788f, 65.0003f, 19.994f, 65.0003f);
                instancePath.lineTo(64.006f, 65.0003f);
                instancePath.cubicTo(66.21f, 65.0003f, 68.0f, 63.2093f, 68.0f, 60.9993f);
                instancePath.lineTo(68.0f, 6.0003f);
                instancePath.cubicTo(68.0f, 4.8923f, 67.553f, 3.8923f, 66.83f, 3.1693f);
                instancePath.close();
                instancePath.moveTo(65.0f, 60.9993f);
                instancePath.cubicTo(65.0f, 61.5513f, 64.554f, 62.0003f, 64.006f, 62.0003f);
                instancePath.lineTo(19.994f, 62.0003f);
                instancePath.cubicTo(19.446f, 62.0003f, 19.0f, 61.5513f, 19.0f, 60.9993f);
                instancePath.lineTo(19.0f, 6.0003f);
                instancePath.cubicTo(19.0f, 5.5093f, 19.329f, 5.1963f, 19.611f, 5.0763f);
                instancePath.cubicTo(19.731f, 5.0253f, 19.86f, 5.0003f, 19.994f, 5.0003f);
                instancePath.lineTo(64.006f, 5.0003f);
                instancePath.cubicTo(64.076f, 5.0003f, 64.145f, 5.0073f, 64.211f, 5.0203f);
                instancePath.cubicTo(64.336f, 5.0463f, 64.453f, 5.0953f, 64.56f, 5.1673f);
                instancePath.cubicTo(64.613f, 5.2033f, 64.663f, 5.2443f, 64.708f, 5.2903f);
                instancePath.cubicTo(64.841f, 5.4233f, 65.0f, 5.6543f, 65.0f, 6.0003f);
                instancePath.lineTo(65.0f, 60.9993f);
                instancePath.close();
                instancePath.moveTo(27.0f, 12.0f);
                instancePath.cubicTo(25.3425f, 12.0f, 24.0f, 13.3425f, 24.0f, 15.0f);
                instancePath.cubicTo(24.0f, 16.6575f, 25.3425f, 18.0f, 27.0f, 18.0f);
                instancePath.cubicTo(28.6575f, 18.0f, 30.0f, 16.6575f, 30.0f, 15.0f);
                instancePath.cubicTo(30.0f, 13.3425f, 28.6575f, 12.0f, 27.0f, 12.0f);
                instancePath.close();
                instancePath.moveTo(24.0f, 42.0f);
                instancePath.lineTo(39.0f, 42.0f);
                instancePath.lineTo(39.0f, 45.0f);
                instancePath.lineTo(24.0f, 45.0f);
                instancePath.lineTo(24.0f, 42.0f);
                instancePath.close();
                instancePath.moveTo(24.0f, 33.0f);
                instancePath.lineTo(39.0f, 33.0f);
                instancePath.lineTo(39.0f, 36.0f);
                instancePath.lineTo(24.0f, 36.0f);
                instancePath.lineTo(24.0f, 33.0f);
                instancePath.close();
                instancePath.moveTo(24.0f, 24.0f);
                instancePath.lineTo(51.0f, 24.0f);
                instancePath.lineTo(51.0f, 27.0f);
                instancePath.lineTo(24.0f, 27.0f);
                instancePath.lineTo(24.0f, 24.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
