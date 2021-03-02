package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class ofm_add_green_icon extends c {
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
                instancePaint3.setColor(-12140518);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 19.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(28.009975f, 0.14335303f);
                instancePath.cubicTo(17.018795f, 0.20603612f, 14.567894f, 10.157754f, 15.0f, 16.0f);
                instancePath.cubicTo(14.805542f, 21.506954f, 18.45052f, 25.816072f, 21.0f, 30.0f);
                instancePath.cubicTo(22.314592f, 32.33474f, 21.796728f, 35.26414f, 20.0f, 37.0f);
                instancePath.cubicTo(14.028744f, 40.73302f, 7.226779f, 43.172523f, 2.0f, 48.0f);
                instancePath.cubicTo(-0.93956214f, 50.261074f, -0.89972633f, 57.339626f, 4.0f, 57.0f);
                instancePath.cubicTo(11.956668f, 56.980297f, 20.026274f, 56.986336f, 28.009975f, 56.99984f);
                instancePath.lineTo(28.009975f, 57.010265f);
                instancePath.cubicTo(36.02442f, 56.99665f, 44.021988f, 56.96801f, 52.009975f, 56.98779f);
                instancePath.cubicTo(56.909702f, 57.327415f, 56.94954f, 50.261074f, 54.009975f, 48.0f);
                instancePath.cubicTo(48.783195f, 43.172523f, 41.98123f, 40.73302f, 36.009975f, 37.0f);
                instancePath.cubicTo(34.21325f, 35.26414f, 33.695385f, 32.33474f, 35.009975f, 30.0f);
                instancePath.cubicTo(37.559456f, 25.816072f, 41.204433f, 21.506954f, 41.009975f, 16.0f);
                instancePath.cubicTo(41.443314f, 10.141088f, 39.08142f, 0.14727847f, 28.009975f, 0.14111328f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(59.0f, 15.0f);
                instancePath2.cubicTo(59.550797f, 12.291986f, 64.49609f, 12.311896f, 65.0f, 15.0f);
                instancePath2.cubicTo(65.09821f, 18.404175f, 64.91067f, 21.709135f, 65.0f, 25.0f);
                instancePath2.cubicTo(68.60236f, 25.073826f, 72.244705f, 24.884686f, 76.0f, 25.0f);
                instancePath2.cubicTo(77.397285f, 26.348026f, 77.338066f, 29.59326f, 76.0f, 31.0f);
                instancePath2.cubicTo(72.26445f, 31.11633f, 68.612236f, 30.92719f, 65.0f, 31.0f);
                instancePath2.cubicTo(64.91067f, 34.321743f, 65.108086f, 37.65657f, 65.0f, 41.0f);
                instancePath2.cubicTo(64.357895f, 43.699074f, 59.540924f, 43.66921f, 59.0f, 41.0f);
                instancePath2.cubicTo(58.89932f, 37.606796f, 59.106606f, 34.291878f, 59.0f, 31.0f);
                instancePath2.cubicTo(55.40504f, 30.92719f, 51.762695f, 31.11633f, 48.0f, 31.0f);
                instancePath2.cubicTo(46.659466f, 29.662943f, 46.56076f, 26.20866f, 48.0f, 25.0f);
                instancePath2.cubicTo(51.81205f, 24.874731f, 55.43465f, 25.073826f, 59.0f, 25.0f);
                instancePath2.cubicTo(59.106606f, 21.709135f, 58.90919f, 18.39422f, 59.0f, 15.0f);
                instancePath2.lineTo(59.0f, 15.0f);
                instancePath2.lineTo(59.0f, 15.0f);
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
