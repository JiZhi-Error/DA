package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class mmsight_camera_navbar_icon_switch extends c {
    private final int height = 120;
    private final int width = 120;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                instancePaint3.setColor(-855310);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 30.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(4.0f, 56.998116f);
                instancePath.cubicTo(4.0f, 56.9978f, 73.99772f, 57.0f, 73.99772f, 57.0f);
                instancePath.cubicTo(74.00232f, 57.0f, 74.0f, 14.001884f, 74.0f, 14.001884f);
                instancePath.cubicTo(74.0f, 14.004772f, 56.5f, 14.0f, 56.5f, 14.0f);
                instancePath.lineTo(49.0f, 4.0f);
                instancePath.lineTo(29.0f, 4.0f);
                instancePath.lineTo(21.5f, 14.0f);
                instancePath.lineTo(3.999805f, 14.0f);
                instancePath.cubicTo(3.9999309f, 14.00048f, 4.0f, 56.998116f, 4.0f, 56.998116f);
                instancePath.close();
                instancePath.moveTo(3.993171f, 10.0f);
                instancePath.lineTo(19.5f, 10.0f);
                instancePath.lineTo(27.0f, 0.0f);
                instancePath.lineTo(51.0f, 0.0f);
                instancePath.lineTo(58.5f, 10.0f);
                instancePath.lineTo(74.00683f, 10.0f);
                instancePath.cubicTo(76.20044f, 10.0f, 78.0f, 11.791705f, 78.0f, 14.001884f);
                instancePath.lineTo(78.0f, 56.998116f);
                instancePath.cubicTo(78.0f, 59.214787f, 76.20812f, 61.0f, 73.99772f, 61.0f);
                instancePath.lineTo(4.002278f, 61.0f);
                instancePath.cubicTo(1.7944237f, 61.0f, 0.0f, 59.208294f, 0.0f, 56.998116f);
                instancePath.lineTo(0.0f, 14.001884f);
                instancePath.cubicTo(0.0f, 11.785213f, 1.7878035f, 10.0f, 3.993171f, 10.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(21.0f, 33.0f);
                instancePath2.cubicTo(21.0f, 42.941124f, 29.058874f, 51.0f, 39.0f, 51.0f);
                instancePath2.cubicTo(44.03602f, 51.0f, 48.588997f, 48.93187f, 51.855957f, 45.598595f);
                instancePath2.lineTo(49.027344f, 42.769985f);
                instancePath2.cubicTo(46.484406f, 45.379486f, 42.931446f, 47.0f, 39.0f, 47.0f);
                instancePath2.cubicTo(31.268013f, 47.0f, 25.0f, 40.731987f, 25.0f, 33.0f);
                instancePath2.lineTo(30.5f, 33.0f);
                instancePath2.lineTo(22.5f, 25.0f);
                instancePath2.lineTo(14.5f, 33.0f);
                instancePath2.lineTo(21.0f, 33.0f);
                instancePath2.close();
                instancePath2.moveTo(57.0f, 33.0f);
                instancePath2.cubicTo(57.0f, 23.058874f, 48.941124f, 15.0f, 39.0f, 15.0f);
                instancePath2.cubicTo(33.96398f, 15.0f, 29.411005f, 17.068129f, 26.144045f, 20.401403f);
                instancePath2.lineTo(28.972656f, 23.230017f);
                instancePath2.cubicTo(31.515596f, 20.620514f, 35.068554f, 19.0f, 39.0f, 19.0f);
                instancePath2.cubicTo(46.731987f, 19.0f, 53.0f, 25.268013f, 53.0f, 33.0f);
                instancePath2.lineTo(47.5f, 33.0f);
                instancePath2.lineTo(55.5f, 41.0f);
                instancePath2.lineTo(63.5f, 33.0f);
                instancePath2.lineTo(57.0f, 33.0f);
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
