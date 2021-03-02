package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class setting_plugin_uninstall extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-3750202);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 13.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(9.666615f, 0.0f);
                instancePath.lineTo(11.372898f, 0.0f);
                instancePath.cubicTo(19.305622f, 0.02008788f, 24.773712f, 9.732577f, 20.51299f, 16.52228f);
                instancePath.cubicTo(16.801077f, 23.834269f, 5.1564374f, 23.824224f, 1.4644784f, 16.502193f);
                instancePath.cubicTo(-2.5567636f, 9.973632f, 2.2028701f, 0.87382275f, 9.666615f, 0.0f);
                instancePath.lineTo(9.666615f, 0.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 22.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(6.1586027f, 1.137319f);
                instancePath2.cubicTo(12.047705f, -2.00158f, 20.032927f, 1.687126f, 21.580063f, 8.154857f);
                instancePath2.cubicTo(23.476555f, 14.432654f, 18.695402f, 21.130304f, 12.34715f, 22.0f);
                instancePath2.lineTo(9.9216385f, 22.0f);
                instancePath2.cubicTo(4.6414104f, 21.400211f, 0.359335f, 16.991756f, 0.0f, 11.673622f);
                instancePath2.lineTo(0.0f, 9.884251f);
                instancePath2.cubicTo(0.61885476f, 6.2355304f, 2.7149756f, 2.7367578f, 6.1586027f, 1.137319f);
                instancePath2.lineTo(6.1586027f, 1.137319f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 26.0f, 0.0f, 1.0f, 22.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(0.069737285f, 11.9446945f);
                instancePath3.cubicTo(-0.7299077f, 5.4077463f, 5.4773364f, -0.7793648f, 12.014434f, 0.080233835f);
                instancePath3.cubicTo(17.142157f, 0.4000845f, 21.220346f, 4.75805f, 22.0f, 9.70574f);
                instancePath3.lineTo(22.0f, 12.044648f);
                instancePath3.cubicTo(21.440248f, 17.152264f, 17.332073f, 21.260345f, 12.284314f, 22.0f);
                instancePath3.lineTo(10.015322f, 22.0f);
                instancePath3.cubicTo(4.8776026f, 21.440262f, 0.3795997f, 17.192245f, 0.069737285f, 11.9446945f);
                instancePath3.lineTo(0.069737285f, 11.9446945f);
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
