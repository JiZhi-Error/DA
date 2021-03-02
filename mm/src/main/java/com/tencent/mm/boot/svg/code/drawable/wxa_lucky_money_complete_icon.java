package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class wxa_lucky_money_complete_icon extends c {
    private final int height = 279;
    private final int width = 279;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 279;
            case 1:
                return 279;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -401.0f, 0.0f, 1.0f, -470.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 390.0f, 0.0f, 1.0f, 470.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-2245500);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(279.0f, 141.22223f);
                instancePath.cubicTo(279.0f, 62.454666f, 216.54533f, 0.0f, 137.77777f, 0.0f);
                instancePath.cubicTo(62.454666f, 0.0f, 0.0f, 62.454666f, 0.0f, 141.22223f);
                instancePath.cubicTo(0.0f, 216.54533f, 62.454666f, 279.0f, 137.77777f, 279.0f);
                instancePath.cubicTo(216.54533f, 279.0f, 279.0f, 216.54533f, 279.0f, 141.22223f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(69.47473f, 146.5967f);
                instancePath2.lineTo(75.88924f, 137.86859f);
                instancePath2.cubicTo(76.37983f, 137.20105f, 77.31869f, 137.0576f, 77.98622f, 137.5482f);
                instancePath2.cubicTo(77.99435f, 137.55417f, 78.0024f, 137.56023f, 78.01041f, 137.56635f);
                instancePath2.lineTo(115.591606f, 166.3702f);
                instancePath2.cubicTo(116.14801f, 166.79663f, 116.92558f, 166.78082f, 117.464195f, 166.33212f);
                instancePath2.lineTo(208.74998f, 90.283676f);
                instancePath2.cubicTo(209.34323f, 89.78945f, 210.21474f, 89.826324f, 210.76411f, 90.36889f);
                instancePath2.lineTo(216.78378f, 96.313896f);
                instancePath2.cubicTo(217.37321f, 96.89602f, 217.37914f, 97.84574f, 216.79703f, 98.43517f);
                instancePath2.cubicTo(216.79202f, 98.44024f, 216.78699f, 98.44527f, 216.78192f, 98.45026f);
                instancePath2.lineTo(117.6191f, 196.04128f);
                instancePath2.cubicTo(117.028656f, 196.62236f, 116.07894f, 196.61478f, 115.49785f, 196.02432f);
                instancePath2.cubicTo(115.49463f, 196.02106f, 115.491425f, 196.01776f, 115.488235f, 196.01447f);
                instancePath2.lineTo(69.6047f, 148.52728f);
                instancePath2.cubicTo(69.09662f, 148.00145f, 69.04172f, 147.18588f, 69.47473f, 146.5967f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
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
