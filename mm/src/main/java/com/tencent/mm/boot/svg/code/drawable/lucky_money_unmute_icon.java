package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class lucky_money_unmute_icon extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -319.0f, 0.0f, 1.0f, -177.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 319.0f, 0.0f, 1.0f, 177.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(Integer.MIN_VALUE);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 36.0f);
                instancePath.cubicTo(0.0f, 16.117748f, 16.117748f, 0.0f, 36.0f, 0.0f);
                instancePath.lineTo(36.0f, 0.0f);
                instancePath.cubicTo(55.88225f, 0.0f, 72.0f, 16.117748f, 72.0f, 36.0f);
                instancePath.lineTo(72.0f, 36.0f);
                instancePath.cubicTo(72.0f, 55.88225f, 55.88225f, 72.0f, 36.0f, 72.0f);
                instancePath.lineTo(36.0f, 72.0f);
                instancePath.cubicTo(16.117748f, 72.0f, 0.0f, 55.88225f, 0.0f, 36.0f);
                instancePath.lineTo(0.0f, 36.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 15.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray4 = c.setMatrixFloatArray(matrixFloatArray3, 1.0f, 0.0f, 3.5f, 0.0f, 1.0f, 7.666667f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray4);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(16.275f, 0.55833334f);
                instancePath2.cubicTo(16.975f, -0.14166667f, 18.025f, -0.14166667f, 18.725f, 0.55833334f);
                instancePath2.cubicTo(19.075f, 0.90833336f, 19.25f, 1.2583333f, 19.25f, 1.7833333f);
                instancePath2.lineTo(19.25f, 1.7833333f);
                instancePath2.lineTo(19.25f, 24.883333f);
                instancePath2.cubicTo(19.25f, 25.933332f, 18.55f, 26.633333f, 17.5f, 26.633333f);
                instancePath2.cubicTo(16.975f, 26.633333f, 16.625f, 26.458334f, 16.275f, 26.108334f);
                instancePath2.lineTo(16.275f, 26.108334f);
                instancePath2.lineTo(9.625f, 19.458334f);
                instancePath2.lineTo(1.75f, 19.458334f);
                instancePath2.cubicTo(0.7f, 19.458334f, 0.0f, 18.758333f, 0.0f, 17.708334f);
                instancePath2.lineTo(0.0f, 17.708334f);
                instancePath2.lineTo(0.0f, 8.958333f);
                instancePath2.cubicTo(0.0f, 7.9083333f, 0.7f, 7.2083335f, 1.75f, 7.2083335f);
                instancePath2.lineTo(1.75f, 7.2083335f);
                instancePath2.lineTo(9.625f, 7.2083335f);
                instancePath2.close();
                instancePath2.moveTo(28.35f, 3.0083334f);
                instancePath2.lineTo(28.525f, 3.1833334f);
                instancePath2.cubicTo(31.15f, 5.8083334f, 32.725f, 9.483334f, 32.725f, 13.333333f);
                instancePath2.cubicTo(32.725f, 17.183332f, 31.325f, 20.683332f, 28.525f, 23.483334f);
                instancePath2.lineTo(28.35f, 23.658333f);
                instancePath2.lineTo(26.425f, 21.733334f);
                instancePath2.lineTo(26.6f, 21.558332f);
                instancePath2.cubicTo(28.875f, 19.283333f, 29.925f, 16.483334f, 29.925f, 13.333333f);
                instancePath2.cubicTo(29.925f, 10.183333f, 28.7f, 7.383333f, 26.6f, 5.108333f);
                instancePath2.lineTo(26.425f, 4.9333334f);
                instancePath2.lineTo(28.35f, 3.0083334f);
                instancePath2.close();
                instancePath2.moveTo(24.85f, 6.508333f);
                instancePath2.lineTo(25.025f, 6.6833334f);
                instancePath2.cubicTo(26.775f, 8.433333f, 27.825f, 10.883333f, 27.825f, 13.333333f);
                instancePath2.cubicTo(27.825f, 15.783333f, 26.775f, 18.233334f, 25.025f, 19.983334f);
                instancePath2.lineTo(24.85f, 20.158333f);
                instancePath2.lineTo(22.925f, 18.233334f);
                instancePath2.lineTo(23.1f, 18.058332f);
                instancePath2.cubicTo(24.325f, 16.833334f, 25.025f, 15.083333f, 25.025f, 13.333333f);
                instancePath2.cubicTo(25.025f, 11.583333f, 24.325f, 9.833333f, 23.1f, 8.608334f);
                instancePath2.lineTo(22.925f, 8.433333f);
                instancePath2.lineTo(24.85f, 6.508333f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
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
