package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class actionbar_ear_icon extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-3355444);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 18.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(17.0f, 1.0f);
                instancePath.cubicTo(25.747702f, -1.789361f, 36.27221f, 2.2401934f, 40.0f, 11.0f);
                instancePath.cubicTo(43.11214f, 17.789885f, 39.038136f, 28.302631f, 31.0f, 29.0f);
                instancePath.cubicTo(28.723322f, 29.359892f, 25.318335f, 28.960926f, 26.0f, 26.0f);
                instancePath.cubicTo(26.36679f, 22.926569f, 30.930073f, 24.54238f, 33.0f, 22.0f);
                instancePath.cubicTo(37.530357f, 18.109056f, 34.345047f, 9.980129f, 29.0f, 7.0f);
                instancePath.cubicTo(21.533905f, 3.467013f, 11.987959f, 8.1149645f, 8.0f, 15.0f);
                instancePath.cubicTo(3.6402485f, 21.719696f, 6.1665297f, 30.29746f, 11.0f, 36.0f);
                instancePath.cubicTo(14.054916f, 40.999718f, 13.385901f, 47.79211f, 18.0f, 52.0f);
                instancePath.cubicTo(20.54536f, 55.25277f, 27.045792f, 54.48476f, 28.0f, 50.0f);
                instancePath.cubicTo(28.453718f, 46.675007f, 28.533602f, 42.386124f, 26.0f, 40.0f);
                instancePath.cubicTo(22.472525f, 38.426388f, 18.65814f, 37.548664f, 16.0f, 35.0f);
                instancePath.cubicTo(11.269018f, 30.82609f, 9.970929f, 23.096128f, 14.0f, 18.0f);
                instancePath.cubicTo(16.571213f, 14.687925f, 21.374142f, 13.491028f, 26.0f, 14.0f);
                instancePath.cubicTo(27.87457f, 14.278985f, 28.32391f, 17.021875f, 27.0f, 19.0f);
                instancePath.cubicTo(24.469584f, 19.445591f, 20.944773f, 18.677584f, 19.0f, 21.0f);
                instancePath.cubicTo(15.792358f, 23.544966f, 16.221725f, 28.362476f, 19.0f, 31.0f);
                instancePath.cubicTo(22.023186f, 34.2173f, 26.776188f, 34.935436f, 31.0f, 37.0f);
                instancePath.cubicTo(33.007015f, 38.905148f, 33.436382f, 42.16669f, 34.0f, 45.0f);
                instancePath.cubicTo(33.705986f, 49.57748f, 32.667515f, 55.08321f, 28.0f, 58.0f);
                instancePath.cubicTo(22.31276f, 60.658756f, 13.415857f, 58.763668f, 10.0f, 52.0f);
                instancePath.cubicTo(8.563002f, 48.77955f, 8.772693f, 44.530563f, 7.0f, 41.0f);
                instancePath.cubicTo(1.8728505f, 34.187378f, -1.3024747f, 25.270493f, 1.0f, 17.0f);
                instancePath.cubicTo(2.3022184f, 8.753309f, 9.411752f, 2.8984869f, 17.0f, 1.0f);
                instancePath.lineTo(17.0f, 1.0f);
                instancePath.lineTo(17.0f, 1.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(54.0f, 11.0f);
                instancePath2.cubicTo(56.18585f, 8.348285f, 59.851326f, 12.841387f, 57.0f, 15.0f);
                instancePath2.cubicTo(45.50505f, 21.439913f, 45.209774f, 39.720478f, 56.0f, 47.0f);
                instancePath2.cubicTo(59.403324f, 48.47805f, 56.491302f, 53.51788f, 54.0f, 52.0f);
                instancePath2.cubicTo(46.991604f, 46.947216f, 42.95958f, 39.034584f, 43.0f, 31.0f);
                instancePath2.cubicTo(42.95958f, 23.169558f, 47.001785f, 15.246986f, 54.0f, 11.0f);
                instancePath2.lineTo(54.0f, 11.0f);
                instancePath2.lineTo(54.0f, 11.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(61.0f, 20.0f);
                instancePath3.cubicTo(63.283504f, 19.210505f, 65.9285f, 21.668697f, 65.0f, 24.0f);
                instancePath3.cubicTo(63.303543f, 25.421204f, 61.27972f, 26.845953f, 61.0f, 29.0f);
                instancePath3.cubicTo(60.237755f, 32.956318f, 63.063087f, 35.93625f, 64.0f, 39.0f);
                instancePath3.cubicTo(64.61602f, 41.153637f, 62.191444f, 42.698788f, 60.0f, 42.0f);
                instancePath3.cubicTo(54.336617f, 36.217186f, 54.436806f, 25.110167f, 61.0f, 20.0f);
                instancePath3.lineTo(61.0f, 20.0f);
                instancePath3.lineTo(61.0f, 20.0f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
