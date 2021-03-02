package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class music_player_icon extends c {
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
                instancePaint3.setColor(-9473160);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 20.0f, 0.0f, 1.0f, 16.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(53.0f, 46.7158f);
                instancePath.cubicTo(53.0f, 48.5108f, 51.705f, 50.4728f, 49.974f, 51.3188f);
                instancePath.cubicTo(49.355f, 51.5178f, 46.938f, 52.0728f, 46.36f, 52.1898f);
                instancePath.cubicTo(45.499f, 52.3608f, 44.713f, 52.1748f, 44.02f, 51.6328f);
                instancePath.cubicTo(43.17f, 50.9718f, 42.587f, 49.8498f, 42.534f, 48.7778f);
                instancePath.cubicTo(42.435f, 46.7368f, 43.718f, 45.0968f, 44.979f, 44.8438f);
                instancePath.lineTo(50.365f, 43.7648f);
                instancePath.cubicTo(51.329f, 43.5708f, 52.227f, 43.1428f, 53.0f, 42.5478f);
                instancePath.lineTo(53.0f, 46.7158f);
                instancePath.close();
                instancePath.moveTo(13.471f, 55.4638f);
                instancePath.cubicTo(13.471f, 57.2588f, 12.174f, 59.2228f, 10.446f, 60.0668f);
                instancePath.cubicTo(9.822f, 60.2678f, 7.39f, 60.8258f, 6.832f, 60.9378f);
                instancePath.cubicTo(5.972f, 61.1088f, 5.185f, 60.9208f, 4.489f, 60.3808f);
                instancePath.cubicTo(3.641f, 59.7188f, 3.058f, 58.5988f, 3.006f, 57.5248f);
                instancePath.cubicTo(2.906f, 55.4858f, 4.187f, 53.8458f, 5.449f, 53.5928f);
                instancePath.lineTo(10.835f, 52.5128f);
                instancePath.cubicTo(11.8f, 52.3198f, 12.697f, 51.8908f, 13.471f, 51.2958f);
                instancePath.lineTo(13.471f, 55.4638f);
                instancePath.close();
                instancePath.moveTo(13.161f, 9.3678f);
                instancePath.lineTo(13.161f, 13.2228f);
                instancePath.lineTo(13.178f, 13.2188f);
                instancePath.lineTo(13.178f, 45.9798f);
                instancePath.cubicTo(13.178f, 47.6388f, 11.86f, 49.2478f, 10.245f, 49.5708f);
                instancePath.lineTo(4.859f, 50.6508f);
                instancePath.cubicTo(2.161f, 51.1918f, -0.164f, 54.1378f, 0.009f, 57.6718f);
                instancePath.cubicTo(0.182f, 61.2058f, 3.328f, 64.6998f, 7.421f, 63.8788f);
                instancePath.cubicTo(7.847f, 63.7938f, 11.11f, 63.0668f, 11.626f, 62.8268f);
                instancePath.cubicTo(14.405f, 61.5358f, 16.471f, 58.5378f, 16.471f, 55.4638f);
                instancePath.lineTo(16.471f, 52.1628f);
                instancePath.lineTo(16.471f, 12.4988f);
                instancePath.lineTo(52.708f, 4.5748f);
                instancePath.lineTo(52.708f, 37.2318f);
                instancePath.cubicTo(52.708f, 38.8898f, 51.389f, 40.4988f, 49.775f, 40.8228f);
                instancePath.lineTo(44.388f, 41.9028f);
                instancePath.cubicTo(41.691f, 42.4438f, 39.365f, 45.3898f, 39.539f, 48.9238f);
                instancePath.cubicTo(39.712f, 52.4568f, 42.857f, 55.9518f, 46.951f, 55.1308f);
                instancePath.cubicTo(47.377f, 55.0448f, 50.639f, 54.3188f, 51.156f, 54.0788f);
                instancePath.cubicTo(53.934f, 52.7868f, 56.0f, 49.7898f, 56.0f, 46.7158f);
                instancePath.lineTo(56.0f, 43.4148f);
                instancePath.lineTo(56.0f, 3.3078f);
                instancePath.lineTo(56.0f, -2.0E-4f);
                instancePath.lineTo(13.161f, 9.3678f);
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
