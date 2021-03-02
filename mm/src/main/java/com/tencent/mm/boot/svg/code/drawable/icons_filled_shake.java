package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_shake extends c {
    private final int height = 72;
    private final int width = 72;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 0.9659258f, 0.25881904f, -5.141926f, -0.25881904f, 0.9659258f, 10.155929f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(54.0f, 51.3f);
                instancePath.lineTo(54.0f, 60.019806f);
                instancePath.cubicTo(54.0f, 61.66572f, 52.66549f, 63.0f, 51.013268f, 63.0f);
                instancePath.lineTo(23.986732f, 63.0f);
                instancePath.cubicTo(22.337206f, 63.0f, 21.0f, 61.66516f, 21.0f, 60.019806f);
                instancePath.lineTo(21.0f, 38.91245f);
                instancePath.cubicTo(21.30163f, 39.048756f, 21.609167f, 39.183006f, 21.921507f, 39.314156f);
                instancePath.cubicTo(23.26521f, 39.878365f, 24.582113f, 40.336334f, 25.83978f, 40.65032f);
                instancePath.cubicTo(28.095984f, 41.213585f, 30.05096f, 41.29538f, 31.665142f, 40.707027f);
                instancePath.cubicTo(36.23308f, 39.04207f, 38.330482f, 32.089893f, 35.980827f, 29.450768f);
                instancePath.cubicTo(35.51369f, 28.926079f, 33.744747f, 27.074095f, 30.979206f, 24.204306f);
                instancePath.cubicTo(29.871628f, 23.055052f, 28.685123f, 21.826685f, 27.498646f, 20.6002f);
                instancePath.cubicTo(26.786768f, 19.86432f, 26.23314f, 19.292643f, 25.91646f, 18.965904f);
                instancePath.cubicTo(24.742807f, 17.753525f, 22.812239f, 16.810616f, 21.0f, 16.49113f);
                instancePath.lineTo(21.0f, 11.980193f);
                instancePath.cubicTo(21.0f, 10.334278f, 22.33451f, 9.0f, 23.986732f, 9.0f);
                instancePath.lineTo(51.013268f, 9.0f);
                instancePath.cubicTo(52.662796f, 9.0f, 54.0f, 10.334839f, 54.0f, 11.980193f);
                instancePath.lineTo(54.0f, 17.7f);
                instancePath.lineTo(49.489227f, 17.7f);
                instancePath.cubicTo(45.916843f, 17.7f, 43.338657f, 20.655678f, 43.812843f, 24.19775f);
                instancePath.lineTo(46.832333f, 46.752647f);
                instancePath.cubicTo(47.173195f, 49.298794f, 49.442432f, 51.3f, 51.99622f, 51.3f);
                instancePath.lineTo(54.0f, 51.3f);
                instancePath.close();
                instancePath.moveTo(31.5f, 51.0f);
                instancePath.lineTo(31.5f, 54.6f);
                instancePath.lineTo(43.5f, 54.6f);
                instancePath.lineTo(43.5f, 51.0f);
                instancePath.lineTo(31.5f, 51.0f);
                instancePath.close();
                instancePath.moveTo(47.381012f, 23.720068f);
                instancePath.cubicTo(47.19547f, 22.334118f, 48.09751f, 21.3f, 49.489227f, 21.3f);
                instancePath.lineTo(56.252983f, 21.3f);
                instancePath.cubicTo(57.736332f, 21.3f, 58.94221f, 22.507206f, 58.94221f, 23.991302f);
                instancePath.lineTo(58.94221f, 45.008698f);
                instancePath.cubicTo(58.94221f, 46.505844f, 57.751324f, 47.7f, 56.243904f, 47.7f);
                instancePath.lineTo(51.99622f, 47.7f);
                instancePath.cubicTo(51.252003f, 47.7f, 50.502827f, 47.039314f, 50.4005f, 46.274967f);
                instancePath.lineTo(47.381012f, 23.720068f);
                instancePath.close();
                instancePath.moveTo(20.397715f, 34.010975f);
                instancePath.lineTo(18.843857f, 32.82467f);
                instancePath.cubicTo(18.686981f, 32.7049f, 18.495085f, 32.640022f, 18.297714f, 32.640022f);
                instancePath.cubicTo(17.80066f, 32.640022f, 17.397715f, 33.042965f, 17.397715f, 33.54002f);
                instancePath.lineTo(17.397715f, 56.090065f);
                instancePath.lineTo(10.394293f, 58.243305f);
                instancePath.cubicTo(9.746578f, 58.443615f, 8.94323f, 58.050762f, 8.692907f, 57.39413f);
                instancePath.lineTo(2.382967f, 40.84225f);
                instancePath.cubicTo(2.1705523f, 40.285057f, 2.4334471f, 39.769848f, 3.0214527f, 39.60758f);
                instancePath.lineTo(10.757407f, 37.078484f);
                instancePath.cubicTo(10.796127f, 32.456417f, 10.941004f, 29.350193f, 11.192037f, 27.759811f);
                instancePath.cubicTo(11.49506f, 25.840052f, 11.986672f, 24.227743f, 12.668005f, 23.031994f);
                instancePath.cubicTo(13.272918f, 21.970364f, 14.12464f, 21.166481f, 15.179122f, 20.576422f);
                instancePath.cubicTo(15.977722f, 20.129547f, 16.848448f, 19.829689f, 17.721182f, 19.654343f);
                instancePath.cubicTo(18.236618f, 19.550785f, 18.62059f, 19.512987f, 18.799316f, 19.509129f);
                instancePath.lineTo(18.970287f, 19.502258f);
                instancePath.cubicTo(20.092958f, 19.454565f, 21.868908f, 20.169153f, 22.670456f, 20.997149f);
                instancePath.cubicTo(22.986925f, 21.32367f, 23.539995f, 21.894772f, 24.25102f, 22.62977f);
                instancePath.cubicTo(25.436043f, 23.854748f, 26.621038f, 25.081554f, 27.770212f, 26.273972f);
                instancePath.cubicTo(30.42823f, 29.032187f, 32.213764f, 30.901539f, 32.63187f, 31.371153f);
                instancePath.cubicTo(33.230915f, 32.044f, 32.028763f, 36.028717f, 29.772131f, 36.85123f);
                instancePath.cubicTo(29.621887f, 36.905994f, 29.469059f, 36.95356f, 29.313614f, 36.994114f);
                instancePath.cubicTo(27.844446f, 37.377403f, 26.174154f, 37.131363f, 24.516998f, 36.460342f);
                instancePath.cubicTo(23.847412f, 36.189213f, 23.35302f, 35.923737f, 23.111376f, 35.7687f);
                instancePath.lineTo(20.397715f, 33.9902f);
                instancePath.lineTo(20.397715f, 34.010975f);
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
