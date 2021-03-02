package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class tipsbanner_multitalk_icon extends c {
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
                instancePaint3.setColor(-15028967);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 20.0f, 0.0f, 1.0f, 21.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(20.74746f, 32.321507f);
                instancePath.cubicTo(26.264082f, 37.838127f, 31.491142f, 40.425617f, 33.424133f, 40.274094f);
                instancePath.cubicTo(35.35712f, 40.12257f, 40.170807f, 36.81219f, 42.443256f, 36.856255f);
                instancePath.cubicTo(43.535416f, 36.87743f, 50.672344f, 41.704136f, 51.53627f, 42.26218f);
                instancePath.cubicTo(52.400192f, 42.820225f, 53.201244f, 43.47209f, 53.050617f, 44.296967f);
                instancePath.cubicTo(52.899994f, 45.12184f, 49.763397f, 54.207813f, 41.755672f, 52.949615f);
                instancePath.cubicTo(33.747948f, 51.691418f, 22.584057f, 43.058952f, 16.222599f, 36.846367f);
                instancePath.lineTo(20.74746f, 32.321507f);
                instancePath.lineTo(20.74746f, 32.321507f);
                instancePath.close();
                instancePath.moveTo(20.74746f, 32.321507f);
                instancePath.cubicTo(15.230838f, 26.804884f, 12.643348f, 21.577822f, 12.794871f, 19.644833f);
                instancePath.cubicTo(12.946394f, 17.711843f, 16.256773f, 12.89816f, 16.212711f, 10.625708f);
                instancePath.cubicTo(16.191534f, 9.533548f, 11.364832f, 2.3966224f, 10.806786f, 1.5326972f);
                instancePath.cubicTo(10.248739f, 0.6687721f, 9.596872f, -0.13227762f, 8.771998f, 0.01834671f);
                instancePath.cubicTo(7.947124f, 0.16897105f, -1.1388476f, 3.3055677f, 0.11935101f, 11.313293f);
                instancePath.cubicTo(1.3775496f, 19.32102f, 10.010014f, 30.48491f, 16.222599f, 36.846367f);
                instancePath.lineTo(20.74746f, 32.321507f);
                instancePath.close();
                instancePath.moveTo(28.0f, 3.8234966f);
                instancePath.cubicTo(28.0f, 3.368692f, 28.384283f, 3.0f, 28.856068f, 3.0f);
                instancePath.lineTo(45.143932f, 3.0f);
                instancePath.cubicTo(45.616726f, 3.0f, 46.0f, 3.36727f, 46.0f, 3.8234966f);
                instancePath.lineTo(46.0f, 16.176504f);
                instancePath.cubicTo(46.0f, 16.631308f, 45.61572f, 17.0f, 45.143932f, 17.0f);
                instancePath.lineTo(28.856068f, 17.0f);
                instancePath.cubicTo(28.383274f, 17.0f, 28.0f, 16.63273f, 28.0f, 16.176504f);
                instancePath.lineTo(28.0f, 3.8234966f);
                instancePath.close();
                instancePath.moveTo(54.6875f, 17.939888f);
                instancePath.cubicTo(55.392006f, 18.168455f, 56.0f, 17.719242f, 56.0f, 17.031927f);
                instancePath.lineTo(56.0f, 2.9585342f);
                instancePath.cubicTo(56.0f, 2.189203f, 55.327656f, 1.8663305f, 54.6875f, 2.0505733f);
                instancePath.cubicTo(54.307777f, 2.3871007f, 51.20473f, 5.3116455f, 49.0f, 7.3502574f);
                instancePath.lineTo(49.0f, 12.586108f);
                instancePath.cubicTo(51.2585f, 14.652606f, 54.430782f, 17.66358f, 54.6875f, 17.939888f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
