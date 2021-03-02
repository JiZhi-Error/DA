package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class panel_icon_sights extends c {
    private final int height = 168;
    private final int width = 168;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 168;
            case 1:
                return 168;
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
                instancePaint3.setColor(-8617594);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 31.0f, 0.0f, 1.0f, 50.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(53.458427f, 68.67285f);
                instancePath.cubicTo(83.84122f, 68.67285f, 105.827965f, 35.957947f, 105.827965f, 35.957947f);
                instancePath.cubicTo(106.46974f, 35.062405f, 106.47585f, 33.603374f, 105.81945f, 32.703407f);
                instancePath.cubicTo(105.81945f, 32.703407f, 83.84122f, 2.4963452E-15f, 53.458427f, 0.0f);
                instancePath.cubicTo(23.075638f, -2.4963452E-15f, 1.0888885f, 32.714905f, 1.0888885f, 32.714905f);
                instancePath.cubicTo(0.4471118f, 33.610447f, 0.44100174f, 35.069477f, 1.0974094f, 35.969444f);
                instancePath.cubicTo(1.0974094f, 35.969444f, 23.075642f, 68.67285f, 53.458427f, 68.67285f);
                instancePath.close();
                instancePath.moveTo(53.458427f, 54.626133f);
                instancePath.cubicTo(64.858315f, 54.626133f, 74.09975f, 45.54212f, 74.09975f, 34.336426f);
                instancePath.cubicTo(74.09975f, 23.13073f, 64.858315f, 14.04672f, 53.458427f, 14.04672f);
                instancePath.cubicTo(42.058544f, 14.04672f, 32.817112f, 23.13073f, 32.817112f, 34.336426f);
                instancePath.cubicTo(32.817112f, 45.54212f, 42.058544f, 54.626133f, 53.458427f, 54.626133f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(41.175587f, 25.24117f);
                instancePath2.cubicTo(39.181583f, 27.849945f, 38.0f, 31.093002f, 38.0f, 34.607468f);
                instancePath2.cubicTo(38.0f, 43.22759f, 45.10843f, 50.21493f, 53.877937f, 50.21493f);
                instancePath2.cubicTo(62.64744f, 50.21493f, 69.755875f, 43.22759f, 69.755875f, 34.607468f);
                instancePath2.cubicTo(69.755875f, 25.987343f, 62.64744f, 19.0f, 53.877937f, 19.0f);
                instancePath2.cubicTo(51.33193f, 19.0f, 48.92593f, 19.588953f, 46.793247f, 20.635828f);
                instancePath2.cubicTo(49.016388f, 21.031485f, 50.702347f, 22.943605f, 50.702347f, 25.242987f);
                instancePath2.cubicTo(50.702347f, 27.829023f, 48.56982f, 29.925226f, 45.93897f, 29.925226f);
                instancePath2.cubicTo(43.308117f, 29.925226f, 41.175587f, 27.829023f, 41.175587f, 25.242987f);
                instancePath2.cubicTo(41.175587f, 25.24238f, 41.175587f, 25.241776f, 41.175587f, 25.24117f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
