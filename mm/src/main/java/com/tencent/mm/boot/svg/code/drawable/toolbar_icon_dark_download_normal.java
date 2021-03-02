package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class toolbar_icon_dark_download_normal extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                instancePaint3.setColor(-14046139);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(96.0f, 0.0f);
                instancePath.lineTo(96.0f, 96.0f);
                instancePath.lineTo(0.0f, 96.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.saveLayerAlpha(null, 0, 31);
                canvas.drawPath(instancePath, c.instancePaint(instancePaint3, looper));
                canvas.restore();
                canvas.saveLayerAlpha(null, 204, 31);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.saveLayerAlpha(null, 204, 31);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 53.63604f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(37.79998f, 15.784549f);
                instancePath2.lineTo(37.79998f, 43.5f);
                instancePath2.lineTo(34.19998f, 43.5f);
                instancePath2.lineTo(34.19998f, 15.784586f);
                instancePath2.lineTo(27.938982f, 22.045584f);
                instancePath2.lineTo(25.393398f, 19.5f);
                instancePath2.lineTo(33.87868f, 11.014719f);
                instancePath2.cubicTo(35.05025f, 9.843145f, 36.94975f, 9.843145f, 38.12132f, 11.014719f);
                instancePath2.lineTo(38.545586f, 11.438983f);
                instancePath2.lineTo(46.6066f, 19.5f);
                instancePath2.lineTo(44.061016f, 22.045584f);
                instancePath2.lineTo(37.79998f, 15.784549f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(56.4f, 24.6f);
                instancePath3.lineTo(48.0f, 24.6f);
                instancePath3.lineTo(48.0f, 21.0f);
                instancePath3.lineTo(57.00313f, 21.0f);
                instancePath3.cubicTo(58.65261f, 21.0f, 60.0f, 22.337517f, 60.0f, 23.987425f);
                instancePath3.lineTo(60.0f, 63.012573f);
                instancePath3.cubicTo(60.0f, 64.65324f, 58.662483f, 66.0f, 57.012573f, 66.0f);
                instancePath3.lineTo(14.987426f, 66.0f);
                instancePath3.cubicTo(13.346761f, 66.0f, 12.0f, 64.66248f, 12.0f, 63.012573f);
                instancePath3.lineTo(12.0f, 23.987425f);
                instancePath3.cubicTo(12.0f, 22.34676f, 13.341744f, 21.0f, 14.99687f, 21.0f);
                instancePath3.lineTo(24.0f, 21.0f);
                instancePath3.lineTo(24.0f, 24.6f);
                instancePath3.lineTo(15.6f, 24.6f);
                instancePath3.lineTo(15.6f, 62.4f);
                instancePath3.lineTo(56.4f, 62.4f);
                instancePath3.lineTo(56.4f, 24.6f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
