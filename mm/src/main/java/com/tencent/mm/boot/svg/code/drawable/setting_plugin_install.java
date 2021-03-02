package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class setting_plugin_install extends c {
    private final int height = 44;
    private final int width = 48;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 48;
            case 1:
                return 44;
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
                canvas.saveLayerAlpha(null, 217, 31);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-2928046);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(10.666615f, 0.0f);
                instancePath.lineTo(12.372898f, 0.0f);
                instancePath.cubicTo(20.305622f, 0.02008788f, 25.773712f, 9.732577f, 21.51299f, 16.52228f);
                instancePath.cubicTo(17.801077f, 23.834269f, 6.1564374f, 23.824224f, 2.4644783f, 16.502193f);
                instancePath.cubicTo(-1.5567636f, 9.973632f, 3.2028701f, 0.87382275f, 10.666615f, 0.0f);
                instancePath.lineTo(10.666615f, 0.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-12537567);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 21.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint5, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(6.1586027f, 2.1373188f);
                instancePath2.cubicTo(12.047705f, -1.0015799f, 20.032927f, 2.6871262f, 21.580063f, 9.154857f);
                instancePath2.cubicTo(23.476555f, 15.432654f, 18.695402f, 22.130304f, 12.34715f, 23.0f);
                instancePath2.lineTo(9.9216385f, 23.0f);
                instancePath2.cubicTo(4.6414104f, 22.400211f, 0.359335f, 17.991756f, 0.0f, 12.673622f);
                instancePath2.lineTo(0.0f, 10.884251f);
                instancePath2.cubicTo(0.61885476f, 7.2355304f, 2.7149756f, 3.7367578f, 6.1586027f, 2.1373188f);
                instancePath2.lineTo(6.1586027f, 2.1373188f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                instancePaint7.setColor(-2511616);
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 25.0f, 0.0f, 1.0f, 21.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint7, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(1.0697373f, 12.9446945f);
                instancePath3.cubicTo(0.27009234f, 6.4077463f, 6.4773364f, 0.22063516f, 13.014434f, 1.0802338f);
                instancePath3.cubicTo(18.142157f, 1.4000845f, 22.220346f, 5.75805f, 23.0f, 10.70574f);
                instancePath3.lineTo(23.0f, 13.044648f);
                instancePath3.cubicTo(22.440248f, 18.152264f, 18.332073f, 22.260345f, 13.284314f, 23.0f);
                instancePath3.lineTo(11.015322f, 23.0f);
                instancePath3.cubicTo(5.8776026f, 22.440262f, 1.3795997f, 18.192245f, 1.0697373f, 12.9446945f);
                instancePath3.lineTo(1.0697373f, 12.9446945f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint8);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
