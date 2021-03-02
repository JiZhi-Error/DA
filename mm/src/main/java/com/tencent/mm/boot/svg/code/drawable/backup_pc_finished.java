package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas;
import com.tencent.mm.plugin.appbrand.jsapi.audio.l;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class backup_pc_finished extends c {
    private final int height = l.CTRL_INDEX;
    private final int width = JsApiOpenAdCanvas.CTRL_INDEX;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return JsApiOpenAdCanvas.CTRL_INDEX;
            case 1:
                return l.CTRL_INDEX;
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-13158344);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, -1.0f, 0.0f, 470.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(304.0f, 278.731f);
                instancePath.lineTo(304.0f, 284.001f);
                instancePath.lineTo(166.0f, 284.001f);
                instancePath.lineTo(166.0f, 278.731f);
                instancePath.lineTo(219.0f, 273.731f);
                instancePath.lineTo(219.0f, 240.001f);
                instancePath.lineTo(251.0f, 240.001f);
                instancePath.lineTo(251.0f, 273.731f);
                instancePath.lineTo(304.0f, 278.731f);
                instancePath.close();
                instancePath.moveTo(254.0f, 240.0f);
                instancePath.lineTo(366.985f, 240.0f);
                instancePath.lineTo(366.985f, 237.001f);
                instancePath.lineTo(254.0f, 237.001f);
                instancePath.lineTo(216.0f, 237.0f);
                instancePath.lineTo(62.006f, 237.001f);
                instancePath.cubicTo(55.938f, 237.001f, 51.0f, 232.063f, 51.0f, 225.994f);
                instancePath.lineTo(51.0f, 14.007f);
                instancePath.cubicTo(51.0f, 7.938f, 55.938f, 3.001f, 62.006f, 3.001f);
                instancePath.lineTo(407.993f, 3.001f);
                instancePath.cubicTo(414.063f, 3.001f, 419.0f, 7.938f, 419.0f, 14.007f);
                instancePath.lineTo(419.0f, 97.39f);
                instancePath.lineTo(422.0f, 97.39f);
                instancePath.lineTo(422.0f, 14.007f);
                instancePath.cubicTo(422.0f, 6.266f, 415.729f, 0.0f, 407.993f, 0.0f);
                instancePath.lineTo(62.007f, 0.0f);
                instancePath.cubicTo(54.276f, 0.0f, 48.0f, 6.271f, 48.0f, 14.007f);
                instancePath.lineTo(48.0f, 225.994f);
                instancePath.cubicTo(48.0f, 233.735f, 54.271f, 240.0f, 62.007f, 240.0f);
                instancePath.lineTo(216.0f, 240.0f);
                instancePath.lineTo(216.0f, 271.0f);
                instancePath.lineTo(163.0f, 276.0f);
                instancePath.lineTo(163.0f, 287.0f);
                instancePath.lineTo(307.0f, 287.0f);
                instancePath.lineTo(307.0f, 276.0f);
                instancePath.lineTo(254.0f, 271.0f);
                instancePath.lineTo(254.0f, 240.0f);
                instancePath.close();
                instancePath.moveTo(365.9854f, 226.0006f);
                instancePath.lineTo(62.0004f, 226.0006f);
                instancePath.lineTo(62.0004f, 14.0006f);
                instancePath.lineTo(408.0004f, 14.0006f);
                instancePath.lineTo(408.0004f, 95.3906f);
                instancePath.cubicTo(408.0004f, 95.3906f, 408.9994f, 97.02239f, 408.9994f, 95.01775f);
                instancePath.lineTo(408.9994f, 13.0006f);
                instancePath.lineTo(60.9994f, 13.0006f);
                instancePath.lineTo(60.9994f, 227.0006f);
                instancePath.lineTo(365.9854f, 227.0006f);
                instancePath.lineTo(365.9854f, 226.0006f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-6579301);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(175.0975f, 101.5f);
                instancePath2.cubicTo(173.38675f, 101.5f, 172.0f, 100.4927f, 172.0f, 99.25005f);
                instancePath2.cubicTo(172.0f, 98.0073f, 173.38675f, 97.0f, 175.0975f, 97.0f);
                instancePath2.lineTo(273.9025f, 97.0f);
                instancePath2.cubicTo(275.61325f, 97.0f, 277.0f, 98.0073f, 277.0f, 99.24995f);
                instancePath2.cubicTo(277.0f, 100.492584f, 275.61325f, 101.5f, 273.9025f, 101.5f);
                instancePath2.lineTo(175.0975f, 101.5f);
                instancePath2.close();
                instancePath2.moveTo(294.283f, 125.68484f);
                instancePath2.lineTo(175.717f, 125.68484f);
                instancePath2.cubicTo(173.66411f, 125.68484f, 172.0f, 124.677536f, 172.0f, 123.43489f);
                instancePath2.lineTo(172.0f, 123.43478f);
                instancePath2.cubicTo(172.0f, 122.19213f, 173.66411f, 121.18484f, 175.717f, 121.18484f);
                instancePath2.lineTo(294.283f, 121.18484f);
                instancePath2.cubicTo(296.3359f, 121.18484f, 298.0f, 122.19213f, 298.0f, 123.43478f);
                instancePath2.lineTo(298.0f, 123.43489f);
                instancePath2.cubicTo(298.0f, 124.677536f, 296.3359f, 125.68484f, 294.283f, 125.68484f);
                instancePath2.lineTo(294.283f, 125.68484f);
                instancePath2.close();
                instancePath2.moveTo(235.79611f, 148.77036f);
                instancePath2.lineTo(175.70389f, 148.77036f);
                instancePath2.cubicTo(173.65823f, 148.77036f, 172.0f, 147.76303f, 172.0f, 146.52036f);
                instancePath2.lineTo(172.0f, 146.52036f);
                instancePath2.cubicTo(172.0f, 145.27768f, 173.65823f, 144.27036f, 175.70389f, 144.27036f);
                instancePath2.lineTo(235.79611f, 144.27036f);
                instancePath2.cubicTo(237.84177f, 144.27036f, 239.5f, 145.27768f, 239.5f, 146.52036f);
                instancePath2.lineTo(239.5f, 146.52036f);
                instancePath2.cubicTo(239.49982f, 147.76303f, 237.84158f, 148.77036f, 235.79611f, 148.77036f);
                instancePath2.lineTo(235.79611f, 148.77036f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, -1.0f, 0.0f, 106.0f, 0.0f, 1.0f, 96.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-13092808);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(3.0f, 183.006f);
                instancePath3.lineTo(3.0f, 7.994f);
                instancePath3.cubicTo(3.0f, 5.24f, 5.243f, 3.0f, 8.0f, 3.0f);
                instancePath3.lineTo(98.0f, 3.0f);
                instancePath3.cubicTo(100.757f, 3.0f, 103.0f, 5.24f, 103.0f, 7.994f);
                instancePath3.lineTo(103.0f, 183.006f);
                instancePath3.cubicTo(103.0f, 185.76f, 100.757f, 188.0f, 98.0f, 188.0f);
                instancePath3.lineTo(8.0f, 188.0f);
                instancePath3.cubicTo(5.243f, 188.0f, 3.0f, 185.76f, 3.0f, 183.006f);
                instancePath3.lineTo(3.0f, 183.006f);
                instancePath3.close();
                instancePath3.moveTo(98.0f, 191.0f);
                instancePath3.cubicTo(102.418f, 191.0f, 106.0f, 187.418f, 106.0f, 183.006f);
                instancePath3.lineTo(106.0f, 7.994f);
                instancePath3.cubicTo(106.0f, 3.579f, 102.412f, 0.0f, 98.0f, 0.0f);
                instancePath3.lineTo(8.0f, 0.0f);
                instancePath3.cubicTo(3.582f, 0.0f, 0.0f, 3.582f, 0.0f, 7.994f);
                instancePath3.lineTo(0.0f, 183.006f);
                instancePath3.cubicTo(0.0f, 187.421f, 3.588f, 191.0f, 8.0f, 191.0f);
                instancePath3.lineTo(98.0f, 191.0f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray4 = c.setMatrixFloatArray(matrixFloatArray3, 1.0f, 0.0f, 35.0f, 0.0f, 1.0f, 77.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray4);
                canvas.concat(instanceMatrix);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray5 = c.setMatrixFloatArray(matrixFloatArray4, 1.0f, 0.0f, 7.0f, 0.0f, 1.0f, 10.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray5);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                instancePaint7.setColor(-13092808);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(1.0f, 157.0f);
                instancePath4.lineTo(91.0f, 157.0f);
                instancePath4.lineTo(91.0f, 11.0f);
                instancePath4.lineTo(1.0f, 11.0f);
                instancePath4.lineTo(1.0f, 157.0f);
                instancePath4.close();
                instancePath4.moveTo(0.0f, 158.0f);
                instancePath4.lineTo(92.0f, 158.0f);
                instancePath4.lineTo(92.0f, 10.0f);
                instancePath4.lineTo(0.0f, 10.0f);
                instancePath4.lineTo(0.0f, 158.0f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray6 = c.setMatrixFloatArray(matrixFloatArray5, -1.0f, 0.0f, 74.0f, 0.0f, 1.0f, 52.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray6);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint3, looper);
                instancePaint8.setColor(-15028967);
                instancePaint8.setStrokeWidth(3.0f);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(56.0f, 28.345678f);
                instancePath5.cubicTo(56.0f, 12.535704f, 43.464294f, 0.0f, 27.654322f, 0.0f);
                instancePath5.cubicTo(12.535704f, 0.0f, 0.0f, 12.535704f, 0.0f, 28.345678f);
                instancePath5.cubicTo(0.0f, 43.464294f, 12.535704f, 56.0f, 27.654322f, 56.0f);
                instancePath5.cubicTo(43.464294f, 56.0f, 56.0f, 43.464294f, 56.0f, 28.345678f);
                instancePath5.close();
                canvas.drawPath(instancePath5, instancePaint8);
                canvas.restore();
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint, looper);
                instancePaint9.setColor(-15028967);
                Path instancePath6 = c.instancePath(looper);
                instancePath6.moveTo(14.588646f, 30.351446f);
                instancePath6.cubicTo(14.207352f, 29.956825f, 14.165816f, 29.27285f, 14.492403f, 28.82847f);
                instancePath6.lineTo(14.924433f, 28.240616f);
                instancePath6.cubicTo(15.252574f, 27.79412f, 15.871776f, 27.702866f, 16.31292f, 28.040977f);
                instancePath6.lineTo(21.912512f, 32.332745f);
                instancePath6.cubicTo(22.788515f, 33.00415f, 24.187197f, 32.974823f, 25.030779f, 32.272053f);
                instancePath6.lineTo(41.452072f, 18.591785f);
                instancePath6.cubicTo(41.87669f, 18.238045f, 42.53333f, 18.259823f, 42.936333f, 18.657825f);
                instancePath6.lineTo(43.125828f, 18.84497f);
                instancePath6.cubicTo(43.520943f, 19.235186f, 43.5217f, 19.865993f, 43.12915f, 20.252325f);
                instancePath6.lineTo(24.928555f, 38.16443f);
                instancePath6.cubicTo(24.138515f, 38.941948f, 22.875587f, 38.92802f, 22.102167f, 38.127567f);
                instancePath6.lineTo(14.588646f, 30.351446f);
                instancePath6.close();
                WeChatSVGRenderC2Java.setFillType(instancePath6, 2);
                canvas.drawPath(instancePath6, instancePaint9);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint instancePaint10 = c.instancePaint(instancePaint, looper);
                instancePaint10.setColor(-13092808);
                Path instancePath7 = c.instancePath(looper);
                instancePath7.moveTo(39.0f, 3.0f);
                instancePath7.lineTo(53.0f, 3.0f);
                instancePath7.lineTo(53.0f, 0.0f);
                instancePath7.lineTo(39.0f, 0.0f);
                instancePath7.close();
                WeChatSVGRenderC2Java.setFillType(instancePath7, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath7, 2);
                canvas.drawPath(instancePath7, instancePaint10);
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