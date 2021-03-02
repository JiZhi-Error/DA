package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class wifi_logo extends c {
    private final int height = 242;
    private final int width = 245;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 245;
            case 1:
                return 242;
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-3552823);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 55.0f, 0.0f, 1.0f, 75.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(134.481f, 27.64f);
                instancePath.lineTo(125.895f, 36.226f);
                instancePath.cubicTo(110.961f, 21.261f, 90.312f, 12.0f, 67.499f, 12.0f);
                instancePath.cubicTo(44.686f, 12.0f, 24.037f, 21.261f, 9.103f, 36.226f);
                instancePath.lineTo(0.517f, 27.64f);
                instancePath.cubicTo(17.694f, 10.56f, 41.362f, 0.0f, 67.499f, 0.0f);
                instancePath.cubicTo(93.636f, 0.0f, 117.304f, 10.56f, 134.481f, 27.64f);
                instancePath.lineTo(134.481f, 27.64f);
                instancePath.close();
                instancePath.moveTo(115.389f, 46.732f);
                instancePath.lineTo(106.807f, 55.314f);
                instancePath.cubicTo(96.758f, 45.234f, 82.859f, 38.996f, 67.501f, 38.996f);
                instancePath.cubicTo(52.142f, 38.996f, 38.242f, 45.235f, 28.192f, 55.316f);
                instancePath.lineTo(19.608f, 46.732f);
                instancePath.cubicTo(31.899f, 34.537f, 48.817f, 27.0f, 67.499f, 27.0f);
                instancePath.cubicTo(86.181f, 27.0f, 103.098f, 34.537f, 115.389f, 46.732f);
                instancePath.lineTo(115.389f, 46.732f);
                instancePath.close();
                instancePath.moveTo(96.196f, 65.925f);
                instancePath.lineTo(87.607f, 74.514f);
                instancePath.cubicTo(82.517f, 69.262f, 75.393f, 65.993f, 67.502f, 65.993f);
                instancePath.cubicTo(59.609f, 65.993f, 52.484f, 69.263f, 47.394f, 74.517f);
                instancePath.lineTo(38.802f, 65.925f);
                instancePath.cubicTo(46.135f, 58.56f, 56.284f, 54.0f, 67.499f, 54.0f);
                instancePath.cubicTo(78.714f, 54.0f, 88.862f, 58.56f, 96.196f, 65.925f);
                instancePath.lineTo(96.196f, 65.925f);
                instancePath.close();
                instancePath.moveTo(77.2f, 84.921f);
                instancePath.lineTo(67.498f, 94.623f);
                instancePath.lineTo(57.796f, 84.922f);
                instancePath.cubicTo(60.314f, 82.497f, 63.729f, 81.0f, 67.499f, 81.0f);
                instancePath.cubicTo(71.269f, 81.0f, 74.683f, 82.497f, 77.2f, 84.921f);
                instancePath.lineTo(77.2f, 84.921f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                instancePaint6.setColor(-3552823);
                instancePaint6.setStrokeWidth(4.0f);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(123.0f, 7.0f);
                instancePath2.cubicTo(185.96046f, 7.0f, 237.0f, 58.039536f, 237.0f, 121.0f);
                instancePath2.cubicTo(237.0f, 183.96046f, 185.96046f, 235.0f, 123.0f, 235.0f);
                instancePath2.cubicTo(60.039536f, 235.0f, 9.0f, 183.96046f, 9.0f, 121.0f);
                instancePath2.cubicTo(9.0f, 58.039536f, 60.039536f, 7.0f, 123.0f, 7.0f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
