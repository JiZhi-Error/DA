package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class emoticonstore_capture_icon extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint4.setStrokeWidth(3.6f);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 0.94551855f, 0.32556817f, -10.369054f, -0.32556817f, 0.94551855f, 13.085754f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(36.109615f, 51.832035f);
                instancePath.cubicTo(36.478947f, 50.021828f, 36.61918f, 49.59024f, 37.10293f, 48.37378f);
                instancePath.cubicTo(37.617302f, 47.08031f, 38.36604f, 45.48333f, 39.349148f, 43.58284f);
                instancePath.lineTo(35.89752f, 43.68798f);
                instancePath.cubicTo(34.03586f, 43.65715f, 32.764465f, 43.080475f, 31.923151f, 42.54983f);
                instancePath.moveTo(15.645319f, 47.33276f);
                instancePath.cubicTo(14.195042f, 44.7577f, 14.170011f, 43.34008f, 17.084476f, 40.53985f);
                instancePath.cubicTo(19.027452f, 38.673027f, 21.28408f, 36.735832f, 23.854359f, 34.728264f);
                instancePath.cubicTo(24.246042f, 34.41258f, 24.686108f, 34.170578f, 25.152336f, 34.00258f);
                instancePath.cubicTo(26.48819f, 33.52123f, 27.450783f, 34.054688f, 27.943132f, 35.135555f);
                instancePath.cubicTo(27.49523f, 33.24668f, 31.003172f, 32.77779f, 33.043427f, 32.451065f);
                instancePath.cubicTo(34.511005f, 32.21605f, 35.256187f, 32.098164f, 39.643166f, 32.16007f);
                instancePath.cubicTo(44.030144f, 32.221977f, 52.396873f, 32.85147f, 53.08276f, 42.162327f);
                instancePath.cubicTo(53.334805f, 45.583813f, 52.80872f, 50.06321f, 51.504498f, 55.600517f);
                instancePath.cubicTo(49.4391f, 63.581837f, 42.106003f, 69.94804f, 31.248415f, 66.42019f);
                instancePath.cubicTo(27.61513f, 65.23966f, 22.837711f, 59.587795f, 16.916162f, 49.46458f);
                instancePath.cubicTo(16.743603f, 49.21144f, 15.805292f, 47.616802f, 15.645319f, 47.33276f);
                instancePath.close();
                instancePath.moveTo(28.117203f, 34.050526f);
                instancePath.cubicTo(27.943542f, 34.585f, 27.907475f, 35.209015f, 28.048918f, 35.81476f);
                instancePath.lineTo(28.442316f, 37.49951f);
                instancePath.cubicTo(28.952667f, 39.685127f, 30.270315f, 41.509167f, 32.035316f, 42.622417f);
                instancePath.moveTo(31.690058f, 43.151917f);
                instancePath.lineTo(22.775629f, 49.957634f);
                instancePath.cubicTo(19.907536f, 51.69366f, 18.071772f, 50.685135f, 16.16978f, 48.138805f);
                instancePath.moveTo(26.226873f, 33.055264f);
                instancePath.lineTo(19.194607f, 18.60711f);
                instancePath.cubicTo(18.382626f, 16.222755f, 19.55927f, 13.596453f, 21.822718f, 12.741097f);
                instancePath.cubicTo(24.107006f, 11.8828945f, 26.174154f, 13.016047f, 27.450985f, 15.504925f);
                instancePath.lineTo(32.419773f, 24.335133f);
                instancePath.cubicTo(33.146152f, 25.473629f, 34.188427f, 26.598293f, 35.928833f, 26.32376f);
                instancePath.cubicTo(37.66924f, 26.049223f, 38.702583f, 25.042978f, 38.702583f, 23.456533f);
                instancePath.lineTo(38.4871f, 12.351198f);
                instancePath.cubicTo(38.4871f, 10.094774f, 39.539852f, 8.173945f, 41.852806f, 7.715035f);
                instancePath.cubicTo(41.938004f, 7.698131f, 42.02367f, 7.6839695f, 42.10969f, 7.67257f);
                instancePath.cubicTo(44.642258f, 7.3369603f, 46.99055f, 9.119869f, 47.489254f, 11.756927f);
                instancePath.lineTo(49.095047f, 34.196342f);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 0.70710677f, -0.70710677f, 24.052986f, 0.70710677f, 0.70710677f, -35.269047f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(54.600002f, 14.228428f);
                instancePath2.lineTo(50.775883f, 16.24984f);
                instancePath2.cubicTo(50.405285f, 16.445734f, 49.946056f, 16.304111f, 49.75016f, 15.9335165f);
                instancePath2.cubicTo(49.63286f, 15.711599f, 49.63286f, 15.446037f, 49.75016f, 15.224119f);
                instancePath2.lineTo(51.771572f, 11.400001f);
                instancePath2.lineTo(49.75016f, 7.5758815f);
                instancePath2.cubicTo(49.554268f, 7.2052865f, 49.69589f, 6.746056f, 50.066483f, 6.5501614f);
                instancePath2.cubicTo(50.288403f, 6.4328566f, 50.553963f, 6.4328566f, 50.775883f, 6.5501614f);
                instancePath2.lineTo(54.600002f, 8.571573f);
                instancePath2.lineTo(58.424118f, 6.5501614f);
                instancePath2.cubicTo(58.794716f, 6.3542666f, 59.253944f, 6.495889f, 59.44984f, 6.8664837f);
                instancePath2.cubicTo(59.567142f, 7.088402f, 59.567142f, 7.353964f, 59.44984f, 7.5758815f);
                instancePath2.lineTo(57.42843f, 11.400001f);
                instancePath2.lineTo(59.44984f, 15.224119f);
                instancePath2.cubicTo(59.645733f, 15.594714f, 59.504112f, 16.053946f, 59.13352f, 16.24984f);
                instancePath2.cubicTo(58.9116f, 16.367144f, 58.646038f, 16.367144f, 58.424118f, 16.24984f);
                instancePath2.lineTo(54.600002f, 14.228428f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
