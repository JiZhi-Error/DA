package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class find_more_friend_mobile_icon extends c {
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
                instancePaint3.setColor(-11615450);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 18.0f, 0.0f, 1.0f, 18.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(2.1112194f, 10.565054f);
                instancePath.cubicTo(4.587666f, 6.591597f, 8.452122f, 3.6065128f, 12.426419f, 1.2503928f);
                instancePath.cubicTo(14.263783f, 0.21210259f, 15.3522215f, 2.6680582f, 16.330818f, 3.7762334f);
                instancePath.cubicTo(18.937078f, 7.849526f, 22.262306f, 11.45359f, 24.48911f, 15.746521f);
                instancePath.cubicTo(22.951319f, 19.690027f, 17.718826f, 20.53863f, 14.313711f, 22.535341f);
                instancePath.cubicTo(15.721691f, 27.826628f, 19.156763f, 32.249344f, 22.871433f, 36.152916f);
                instancePath.cubicTo(27.245157f, 40.69544f, 32.267952f, 44.898514f, 38.409138f, 46.75546f);
                instancePath.cubicTo(40.096718f, 43.281178f, 41.464756f, 39.487427f, 44.190845f, 36.66208f);
                instancePath.cubicTo(45.83848f, 36.172886f, 47.17656f, 37.660435f, 48.49467f, 38.419186f);
                instancePath.cubicTo(52.08951f, 41.23455f, 56.06381f, 43.56072f, 59.52884f, 46.53582f);
                instancePath.cubicTo(60.647232f, 47.71388f, 59.508865f, 49.14153f, 58.84981f, 50.199787f);
                instancePath.cubicTo(56.333424f, 53.624146f, 53.677235f, 57.22821f, 49.81278f, 59.224922f);
                instancePath.cubicTo(46.797104f, 60.81231f, 43.34206f, 59.654217f, 40.39629f, 58.48614f);
                instancePath.cubicTo(23.520502f, 51.367863f, 9.690345f, 37.480732f, 2.520632f, 20.638466f);
                instancePath.cubicTo(1.1725662f, 17.503628f, 0.10409919f, 13.679925f, 2.1112194f, 10.565054f);
                instancePath.lineTo(2.1112194f, 10.565054f);
                instancePath.lineTo(2.1112194f, 10.565054f);
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
