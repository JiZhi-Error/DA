package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_imac_lock extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 12.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(3.6f, 33.0f);
                instancePath.lineTo(42.0f, 33.0f);
                instancePath.lineTo(42.0f, 32.1f);
                instancePath.cubicTo(42.0f, 26.798067f, 46.029438f, 22.5f, 51.0f, 22.5f);
                instancePath.cubicTo(53.026093f, 22.5f, 54.89581f, 23.214134f, 56.4f, 24.419296f);
                instancePath.lineTo(56.4f, 3.6f);
                instancePath.lineTo(3.6f, 3.6f);
                instancePath.lineTo(3.6f, 33.0f);
                instancePath.close();
                instancePath.moveTo(3.6f, 36.6f);
                instancePath.lineTo(3.6f, 41.4f);
                instancePath.lineTo(36.0f, 41.4f);
                instancePath.lineTo(36.0f, 36.6f);
                instancePath.lineTo(3.6f, 36.6f);
                instancePath.close();
                instancePath.moveTo(56.4f, 33.0f);
                instancePath.lineTo(56.4f, 32.1f);
                instancePath.cubicTo(56.4f, 28.736214f, 53.92855f, 26.1f, 51.0f, 26.1f);
                instancePath.cubicTo(48.07145f, 26.1f, 45.6f, 28.736214f, 45.6f, 32.1f);
                instancePath.lineTo(45.6f, 33.0f);
                instancePath.lineTo(56.4f, 33.0f);
                instancePath.close();
                instancePath.moveTo(36.0f, 52.5f);
                instancePath.lineTo(20.090042f, 52.5f);
                instancePath.cubicTo(19.926783f, 52.5f, 19.764618f, 52.473347f, 19.609945f, 52.421093f);
                instancePath.cubicTo(18.825098f, 52.15594f, 18.4038f, 51.304752f, 18.66895f, 50.5199f);
                instancePath.lineTo(20.533775f, 45.0f);
                instancePath.lineTo(3.0f, 45.0f);
                instancePath.cubicTo(1.3431457f, 45.0f, -2.962303E-15f, 43.656853f, -2.220446E-16f, 42.0f);
                instancePath.lineTo(4.440892E-16f, 3.0f);
                instancePath.cubicTo(2.4118308E-16f, 1.3431457f, 1.3431457f, 3.043592E-16f, 3.0f, 0.0f);
                instancePath.lineTo(57.0f, 0.0f);
                instancePath.cubicTo(58.656853f, -3.043592E-16f, 60.0f, 1.3431457f, 60.0f, 3.0f);
                instancePath.lineTo(60.0f, 33.0f);
                instancePath.lineTo(63.01381f, 33.0f);
                instancePath.cubicTo(64.66303f, 33.0f, 66.0f, 34.340096f, 66.0f, 35.987827f);
                instancePath.lineTo(66.0f, 52.512173f);
                instancePath.cubicTo(66.0f, 54.162304f, 64.633f, 55.5f, 63.01381f, 55.5f);
                instancePath.lineTo(38.98619f, 55.5f);
                instancePath.cubicTo(37.336964f, 55.5f, 36.0f, 54.159904f, 36.0f, 52.512173f);
                instancePath.lineTo(36.0f, 52.5f);
                instancePath.close();
                instancePath.moveTo(36.0f, 44.99996f);
                instancePath.lineTo(24.33368f, 44.99996f);
                instancePath.lineTo(23.016104f, 48.9f);
                instancePath.lineTo(36.0f, 48.9f);
                instancePath.lineTo(36.0f, 44.99996f);
                instancePath.close();
                instancePath.moveTo(39.6f, 51.9f);
                instancePath.lineTo(62.4f, 51.9f);
                instancePath.lineTo(62.4f, 36.6f);
                instancePath.lineTo(39.6f, 36.6f);
                instancePath.lineTo(39.6f, 51.9f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
