package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.audio.l;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class connect_ipad extends c {
    private final int height = l.CTRL_INDEX;
    private final int width = 378;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 378;
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
                c.instancePaint(instancePaint2, looper).setStrokeWidth(1.0f);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-13092808);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 81.0f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(213.0f, 273.9996f);
                instancePath.cubicTo(213.0f, 280.0646f, 208.063f, 284.9996f, 201.994f, 284.9996f);
                instancePath.lineTo(14.006f, 284.9996f);
                instancePath.cubicTo(7.937f, 284.9996f, 3.0f, 280.0646f, 3.0f, 273.9996f);
                instancePath.lineTo(3.0f, 13.9996f);
                instancePath.cubicTo(3.0f, 7.9346f, 7.937f, 2.9996f, 14.006f, 2.9996f);
                instancePath.lineTo(201.994f, 2.9996f);
                instancePath.cubicTo(208.063f, 2.9996f, 213.0f, 7.9346f, 213.0f, 13.9996f);
                instancePath.lineTo(213.0f, 273.9996f);
                instancePath.close();
                instancePath.moveTo(216.0f, 14.0006f);
                instancePath.cubicTo(216.0f, 6.2666f, 209.729f, -4.0E-4f, 201.994f, -4.0E-4f);
                instancePath.lineTo(14.006f, -4.0E-4f);
                instancePath.cubicTo(6.26f, -4.0E-4f, 0.0f, 6.2686f, 0.0f, 14.0006f);
                instancePath.lineTo(0.0f, 273.9996f);
                instancePath.cubicTo(0.0f, 281.7336f, 6.271f, 287.9996f, 14.006f, 287.9996f);
                instancePath.lineTo(201.994f, 287.9996f);
                instancePath.cubicTo(209.74f, 287.9996f, 216.0f, 281.7316f, 216.0f, 273.9996f);
                instancePath.lineTo(216.0f, 14.0006f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(14.0f, 256.0f);
                instancePath2.lineTo(201.0f, 256.0f);
                instancePath2.lineTo(201.0f, 30.0f);
                instancePath2.lineTo(14.0f, 30.0f);
                instancePath2.lineTo(14.0f, 256.0f);
                instancePath2.close();
                instancePath2.moveTo(13.0f, 257.0f);
                instancePath2.lineTo(202.0f, 257.0f);
                instancePath2.lineTo(202.0f, 29.0f);
                instancePath2.lineTo(13.0f, 29.0f);
                instancePath2.lineTo(13.0f, 257.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(108.5f, 278.4996f);
                instancePath3.cubicTo(104.641f, 278.4996f, 101.5f, 275.3586f, 101.5f, 271.4996f);
                instancePath3.cubicTo(101.5f, 267.6406f, 104.641f, 264.4996f, 108.5f, 264.4996f);
                instancePath3.cubicTo(112.359f, 264.4996f, 115.5f, 267.6406f, 115.5f, 271.4996f);
                instancePath3.cubicTo(115.5f, 275.3586f, 112.359f, 278.4996f, 108.5f, 278.4996f);
                instancePath3.moveTo(108.5f, 263.4996f);
                instancePath3.cubicTo(104.089f, 263.4996f, 100.5f, 267.0886f, 100.5f, 271.4996f);
                instancePath3.cubicTo(100.5f, 275.9106f, 104.089f, 279.4996f, 108.5f, 279.4996f);
                instancePath3.cubicTo(112.911f, 279.4996f, 116.5f, 275.9106f, 116.5f, 271.4996f);
                instancePath3.cubicTo(116.5f, 267.0886f, 112.911f, 263.4996f, 108.5f, 263.4996f);
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint3, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(108.0f, 12.5001f);
                instancePath4.cubicTo(109.379f, 12.5001f, 110.5f, 13.6221f, 110.5f, 15.0001f);
                instancePath4.cubicTo(110.5f, 16.3781f, 109.379f, 17.5001f, 108.0f, 17.5001f);
                instancePath4.cubicTo(106.621f, 17.5001f, 105.5f, 16.3781f, 105.5f, 15.0001f);
                instancePath4.cubicTo(105.5f, 13.6221f, 106.621f, 12.5001f, 108.0f, 12.5001f);
                instancePath4.moveTo(108.0f, 18.5001f);
                instancePath4.cubicTo(109.93f, 18.5001f, 111.5f, 16.9301f, 111.5f, 15.0001f);
                instancePath4.cubicTo(111.5f, 13.0701f, 109.93f, 11.5001f, 108.0f, 11.5001f);
                instancePath4.cubicTo(106.07f, 11.5001f, 104.5f, 13.0701f, 104.5f, 15.0001f);
                instancePath4.cubicTo(104.5f, 16.9301f, 106.07f, 18.5001f, 108.0f, 18.5001f);
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
