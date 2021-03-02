package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class game_icon_share_wechat extends c {
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
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 16.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-15616);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(18.599894f, 29.96312f);
                instancePath.cubicTo(19.577887f, 24.167274f, 24.16104f, 19.597342f, 29.96312f, 18.638449f);
                instancePath.lineTo(29.96312f, 1.8441076f);
                instancePath.cubicTo(29.96312f, 0.82551914f, 29.137592f, 3.5527137E-14f, 28.119265f, 3.5527137E-14f);
                instancePath.lineTo(27.684988f, 3.5527137E-14f);
                instancePath.cubicTo(27.196127f, 3.5527137E-14f, 26.727163f, 0.1944138f, 26.381355f, 0.5402176f);
                instancePath.lineTo(0.53995353f, 26.381388f);
                instancePath.cubicTo(0.19414665f, 26.726923f, -4.1922021E-13f, 27.196152f, -4.1922021E-13f, 27.685009f);
                instancePath.lineTo(-4.1922021E-13f, 28.11928f);
                instancePath.cubicTo(-4.1922021E-13f, 29.1376f, 0.8255266f, 29.96312f, 1.8438553f, 29.96312f);
                instancePath.lineTo(18.599894f, 29.96312f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-15683841);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(33.958202f, 18.649372f);
                instancePath2.cubicTo(39.728767f, 19.632206f, 44.28042f, 24.189543f, 45.25464f, 29.96312f);
                instancePath2.lineTo(61.7704f, 29.96312f);
                instancePath2.cubicTo(62.958126f, 29.96312f, 63.92132f, 29.000185f, 63.92132f, 27.81218f);
                instancePath2.lineTo(63.92132f, 27.768618f);
                instancePath2.cubicTo(63.92132f, 27.198277f, 63.694637f, 26.651064f, 63.29129f, 26.247711f);
                instancePath2.lineTo(37.673576f, 0.63003546f);
                instancePath2.cubicTo(37.27023f, 0.22641478f, 36.72302f, 3.5527137E-14f, 36.152683f, 3.5527137E-14f);
                instancePath2.lineTo(36.109123f, 3.5527137E-14f);
                instancePath2.cubicTo(34.921127f, 3.5527137E-14f, 33.958202f, 0.9629351f, 33.958202f, 2.1509404f);
                instancePath2.lineTo(33.958202f, 18.649372f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-372399);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(29.96312f, 45.30842f);
                instancePath3.cubicTo(24.152487f, 44.34818f, 19.564535f, 39.766148f, 18.595694f, 33.958202f);
                instancePath3.lineTo(2.150921f, 33.958202f);
                instancePath3.cubicTo(0.9631953f, 33.958202f, -4.1922021E-13f, 34.921127f, -4.1922021E-13f, 36.109123f);
                instancePath3.lineTo(-4.1922021E-13f, 36.128216f);
                instancePath3.cubicTo(-4.1922021E-13f, 36.698547f, 0.22668165f, 37.245758f, 0.6300298f, 37.649105f);
                instancePath3.lineTo(26.272215f, 63.29129f);
                instancePath3.cubicTo(26.675564f, 63.694637f, 27.222773f, 63.92132f, 27.793106f, 63.92132f);
                instancePath3.lineTo(27.812199f, 63.92132f);
                instancePath3.cubicTo(29.000193f, 63.92132f, 29.96312f, 62.958126f, 29.96312f, 61.7704f);
                instancePath3.lineTo(29.96312f, 45.30842f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-16268960);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(45.25894f, 33.958202f);
                instancePath4.cubicTo(44.293594f, 39.743828f, 39.737373f, 44.312954f, 33.958202f, 45.297394f);
                instancePath4.lineTo(33.958202f, 61.7704f);
                instancePath4.cubicTo(33.958202f, 62.958126f, 34.921127f, 63.92132f, 36.109123f, 63.92132f);
                instancePath4.lineTo(36.171776f, 63.92132f);
                instancePath4.cubicTo(36.74211f, 63.92132f, 37.289318f, 63.694637f, 37.69267f, 63.29129f);
                instancePath4.lineTo(63.29129f, 37.69267f);
                instancePath4.cubicTo(63.694637f, 37.289318f, 63.92132f, 36.74211f, 63.92132f, 36.171776f);
                instancePath4.lineTo(63.92132f, 36.109123f);
                instancePath4.cubicTo(63.92132f, 34.921127f, 62.958126f, 33.958202f, 61.7704f, 33.958202f);
                instancePath4.lineTo(45.25894f, 33.958202f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint6);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
