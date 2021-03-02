package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class more_setting extends c {
    private final int height = 108;
    private final int width = 108;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                instancePaint3.setColor(-15683841);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 20.0f, 0.0f, 1.0f, 20.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(68.184f, 29.114f);
                instancePath.cubicTo(67.793f, 28.723f, 67.323f, 28.528f, 66.77f, 28.528f);
                instancePath.lineTo(63.135f, 28.528f);
                instancePath.cubicTo(62.385f, 24.973f, 60.993f, 21.656f, 59.072f, 18.711f);
                instancePath.lineTo(61.64f, 16.143f);
                instancePath.cubicTo(62.031f, 15.753f, 62.226f, 15.282f, 62.226f, 14.729f);
                instancePath.cubicTo(62.226f, 14.176f, 62.031f, 13.706f, 61.64f, 13.315f);
                instancePath.lineTo(55.983f, 7.659f);
                instancePath.cubicTo(55.592f, 7.268f, 55.122f, 7.072f, 54.569f, 7.072f);
                instancePath.cubicTo(54.017f, 7.072f, 53.546f, 7.268f, 53.155f, 7.659f);
                instancePath.lineTo(50.587f, 10.227f);
                instancePath.cubicTo(47.641f, 8.306f, 44.327f, 6.901f, 40.771f, 6.153f);
                instancePath.lineTo(40.771f, 2.528f);
                instancePath.cubicTo(40.771f, 1.976f, 40.576f, 1.505f, 40.185f, 1.114f);
                instancePath.cubicTo(39.794f, 0.724f, 39.324f, 0.528f, 38.771f, 0.528f);
                instancePath.lineTo(30.771f, 0.528f);
                instancePath.cubicTo(30.218f, 0.528f, 29.748f, 0.724f, 29.357f, 1.114f);
                instancePath.cubicTo(28.966f, 1.505f, 28.771f, 1.976f, 28.771f, 2.528f);
                instancePath.lineTo(28.771f, 6.153f);
                instancePath.cubicTo(24.975f, 6.952f, 21.464f, 8.507f, 18.374f, 10.632f);
                instancePath.lineTo(15.857f, 8.115f);
                instancePath.cubicTo(15.465f, 7.724f, 14.994f, 7.528f, 14.44f, 7.528f);
                instancePath.cubicTo(13.887f, 7.528f, 13.415f, 7.724f, 13.024f, 8.115f);
                instancePath.lineTo(7.358f, 13.781f);
                instancePath.cubicTo(6.966f, 14.173f, 6.771f, 14.644f, 6.771f, 15.198f);
                instancePath.cubicTo(6.771f, 15.751f, 6.966f, 16.222f, 7.358f, 16.614f);
                instancePath.lineTo(10.085f, 19.341f);
                instancePath.cubicTo(8.367f, 22.129f, 7.095f, 25.22f, 6.398f, 28.528f);
                instancePath.lineTo(2.771f, 28.528f);
                instancePath.cubicTo(2.218f, 28.528f, 1.748f, 28.723f, 1.357f, 29.114f);
                instancePath.cubicTo(0.966f, 29.505f, 0.771f, 29.975f, 0.771f, 30.528f);
                instancePath.lineTo(0.771f, 38.529f);
                instancePath.cubicTo(0.771f, 39.081f, 0.966f, 39.551f, 1.357f, 39.943f);
                instancePath.cubicTo(1.748f, 40.333f, 2.218f, 40.528f, 2.771f, 40.528f);
                instancePath.lineTo(6.406f, 40.528f);
                instancePath.cubicTo(7.156f, 44.083f, 8.547f, 47.401f, 10.468f, 50.345f);
                instancePath.lineTo(7.901f, 52.912f);
                instancePath.cubicTo(7.51f, 53.303f, 7.315f, 53.774f, 7.315f, 54.327f);
                instancePath.cubicTo(7.315f, 54.879f, 7.51f, 55.35f, 7.901f, 55.741f);
                instancePath.lineTo(13.558f, 61.398f);
                instancePath.cubicTo(13.949f, 61.788f, 14.419f, 61.983f, 14.972f, 61.983f);
                instancePath.cubicTo(15.524f, 61.983f, 15.995f, 61.788f, 16.386f, 61.398f);
                instancePath.lineTo(18.955f, 58.829f);
                instancePath.cubicTo(21.901f, 60.75f, 25.214f, 62.154f, 28.771f, 62.902f);
                instancePath.lineTo(28.771f, 66.527f);
                instancePath.cubicTo(28.771f, 67.08f, 28.966f, 67.55f, 29.357f, 67.941f);
                instancePath.cubicTo(29.748f, 68.332f, 30.218f, 68.527f, 30.771f, 68.527f);
                instancePath.lineTo(38.771f, 68.527f);
                instancePath.cubicTo(39.324f, 68.527f, 39.794f, 68.332f, 40.185f, 67.941f);
                instancePath.cubicTo(40.576f, 67.55f, 40.771f, 67.08f, 40.771f, 66.527f);
                instancePath.lineTo(40.771f, 62.902f);
                instancePath.cubicTo(44.08f, 62.206f, 47.171f, 60.934f, 49.959f, 59.215f);
                instancePath.lineTo(52.685f, 61.941f);
                instancePath.cubicTo(53.077f, 62.332f, 53.548f, 62.527f, 54.102f, 62.527f);
                instancePath.cubicTo(54.655f, 62.527f, 55.127f, 62.332f, 55.518f, 61.941f);
                instancePath.lineTo(61.184f, 56.275f);
                instancePath.cubicTo(61.576f, 55.883f, 61.771f, 55.412f, 61.771f, 54.859f);
                instancePath.cubicTo(61.771f, 54.304f, 61.576f, 53.833f, 61.184f, 53.442f);
                instancePath.lineTo(58.666f, 50.924f);
                instancePath.cubicTo(60.79f, 47.834f, 62.345f, 44.323f, 63.144f, 40.527f);
                instancePath.lineTo(66.771f, 40.527f);
                instancePath.cubicTo(67.324f, 40.527f, 67.794f, 40.332f, 68.185f, 39.942f);
                instancePath.cubicTo(68.576f, 39.55f, 68.771f, 39.08f, 68.771f, 38.528f);
                instancePath.lineTo(68.771f, 30.527f);
                instancePath.cubicTo(68.77f, 29.976f, 68.574f, 29.505f, 68.184f, 29.114f);
                instancePath.lineTo(68.184f, 29.114f);
                instancePath.close();
                instancePath.moveTo(34.769f, 56.528f);
                instancePath.cubicTo(22.62f, 56.528f, 12.77f, 46.678f, 12.77f, 34.528f);
                instancePath.cubicTo(12.77f, 22.378f, 22.62f, 12.528f, 34.769f, 12.528f);
                instancePath.cubicTo(46.92f, 12.528f, 56.77f, 22.378f, 56.77f, 34.528f);
                instancePath.cubicTo(56.77f, 46.678f, 46.92f, 56.528f, 34.769f, 56.528f);
                instancePath.lineTo(34.769f, 56.528f);
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
