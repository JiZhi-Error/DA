package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_pay_fingerprint_android extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 8.0f, 0.0f, 1.0f, 5.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(45.439476f, 8.71f);
                instancePath.cubicTo(45.144226f, 8.71f, 44.853523f, 8.63498f, 44.611988f, 8.496641f);
                instancePath.cubicTo(38.89459f, 5.548606f, 33.96157f, 4.3f, 28.039476f, 4.3f);
                instancePath.cubicTo(22.123337f, 4.3f, 16.537058f, 5.7096915f, 11.472362f, 8.493788f);
                instancePath.cubicTo(10.610391f, 8.960689f, 9.532301f, 8.641662f, 9.025689f, 7.772885f);
                instancePath.cubicTo(8.556245f, 6.906219f, 8.881869f, 5.7946033f, 9.746318f, 5.326361f);
                instancePath.cubicTo(15.3861885f, 2.2638502f, 21.557676f, 0.7f, 28.039476f, 0.7f);
                instancePath.cubicTo(34.473038f, 0.7f, 40.100132f, 2.1192546f, 46.267883f, 5.293835f);
                instancePath.cubicTo(47.161366f, 5.7584457f, 47.49594f, 6.8402476f, 47.027805f, 7.704164f);
                instancePath.cubicTo(46.7136f, 8.332576f, 46.107735f, 8.71f, 45.439476f, 8.71f);
                instancePath.close();
                instancePath.moveTo(2.5094764f, 24.46f);
                instancePath.cubicTo(2.1460226f, 24.46f, 1.7887475f, 24.350069f, 1.4681569f, 24.136272f);
                instancePath.cubicTo(0.64463586f, 23.563387f, 0.4567785f, 22.447294f, 1.0345315f, 21.616789f);
                instancePath.cubicTo(4.034945f, 17.373781f, 7.853244f, 14.043248f, 12.391927f, 11.713391f);
                instancePath.cubicTo(21.910822f, 6.8023686f, 34.073143f, 6.785394f, 43.59648f, 11.68311f);
                instancePath.cubicTo(48.14561f, 14.018331f, 51.960213f, 17.322798f, 54.9521f, 21.523548f);
                instancePath.cubicTo(55.534912f, 22.324919f, 55.34339f, 23.47403f, 54.520794f, 24.046272f);
                instancePath.cubicTo(53.692184f, 24.622698f, 52.576088f, 24.434841f, 52.005356f, 23.614372f);
                instancePath.cubicTo(49.330296f, 19.869286f, 45.945705f, 16.932987f, 41.942715f, 14.887013f);
                instancePath.cubicTo(33.410637f, 10.516925f, 22.50299f, 10.5252695f, 14.016769f, 14.91674f);
                instancePath.cubicTo(10.00328f, 16.982508f, 6.6121254f, 19.940432f, 3.9399493f, 23.678843f);
                instancePath.cubicTo(3.6531036f, 24.180822f, 3.1146882f, 24.46f, 2.5094764f, 24.46f);
                instancePath.close();
                instancePath.moveTo(21.259476f, 60.67f);
                instancePath.cubicTo(20.771917f, 60.67f, 20.306238f, 60.475967f, 19.997345f, 60.132133f);
                instancePath.cubicTo(17.12841f, 57.2632f, 15.806204f, 55.557125f, 13.917833f, 52.146774f);
                instancePath.cubicTo(11.827357f, 48.420273f, 10.729476f, 43.873024f, 10.729476f, 38.98f);
                instancePath.cubicTo(10.729476f, 29.89975f, 18.48824f, 22.51f, 28.009476f, 22.51f);
                instancePath.cubicTo(37.530712f, 22.51f, 45.289474f, 29.89975f, 45.289474f, 38.98f);
                instancePath.cubicTo(45.289474f, 39.985687f, 44.495163f, 40.78f, 43.489475f, 40.78f);
                instancePath.cubicTo(42.48379f, 40.78f, 41.689476f, 39.985687f, 41.689476f, 38.98f);
                instancePath.cubicTo(41.689476f, 31.888676f, 35.55645f, 26.11f, 28.009476f, 26.11f);
                instancePath.cubicTo(20.462505f, 26.11f, 14.329476f, 31.888676f, 14.329476f, 38.98f);
                instancePath.cubicTo(14.329476f, 43.2561f, 15.279698f, 47.19382f, 17.081615f, 50.384113f);
                instancePath.cubicTo(18.79002f, 53.453903f, 19.888454f, 54.849728f, 22.586977f, 57.583374f);
                instancePath.cubicTo(23.266977f, 58.299164f, 23.266977f, 59.410835f, 22.571278f, 60.141983f);
                instancePath.cubicTo(22.192839f, 60.48602f, 21.732883f, 60.67f, 21.259476f, 60.67f);
                instancePath.close();
                instancePath.moveTo(42.769478f, 55.12f);
                instancePath.cubicTo(39.13529f, 55.12f, 35.927612f, 54.20021f, 33.301147f, 52.398327f);
                instancePath.cubicTo(28.748117f, 49.312042f, 26.029476f, 44.298767f, 26.029476f, 38.98f);
                instancePath.cubicTo(26.029476f, 37.974316f, 26.823792f, 37.18f, 27.829475f, 37.18f);
                instancePath.cubicTo(28.835161f, 37.18f, 29.629477f, 37.974316f, 29.629477f, 38.98f);
                instancePath.cubicTo(29.629477f, 43.118687f, 31.747166f, 47.011734f, 35.317497f, 49.41147f);
                instancePath.cubicTo(37.389816f, 50.812473f, 39.81883f, 51.49f, 42.769478f, 51.49f);
                instancePath.cubicTo(43.573322f, 51.49f, 44.76271f, 51.382626f, 45.83485f, 51.195015f);
                instancePath.cubicTo(46.81384f, 51.01372f, 47.74651f, 51.668808f, 47.92446f, 52.665375f);
                instancePath.cubicTo(48.105755f, 53.644363f, 47.45067f, 54.577034f, 46.45632f, 54.754566f);
                instancePath.cubicTo(45.0846f, 55.019283f, 43.759792f, 55.12f, 42.769478f, 55.12f);
                instancePath.close();
                instancePath.moveTo(36.739475f, 61.3f);
                instancePath.cubicTo(36.60454f, 61.3f, 36.44855f, 61.274002f, 36.269466f, 61.229134f);
                instancePath.cubicTo(31.463053f, 59.89906f, 28.294464f, 58.108406f, 24.978106f, 54.85289f);
                instancePath.cubicTo(20.719578f, 50.624783f, 18.379477f, 44.997395f, 18.379477f, 38.98f);
                instancePath.cubicTo(18.379477f, 33.948334f, 22.65975f, 29.86f, 27.919476f, 29.86f);
                instancePath.cubicTo(33.179203f, 29.86f, 37.459476f, 33.948334f, 37.459476f, 38.98f);
                instancePath.cubicTo(37.459476f, 42.02222f, 40.11361f, 44.5f, 43.399475f, 44.5f);
                instancePath.cubicTo(46.68534f, 44.5f, 49.339478f, 42.02222f, 49.339478f, 38.98f);
                instancePath.cubicTo(49.339478f, 27.841618f, 39.72957f, 18.79f, 27.889477f, 18.79f);
                instancePath.cubicTo(19.474157f, 18.79f, 11.785827f, 23.47312f, 8.329777f, 30.710144f);
                instancePath.cubicTo(7.180476f, 33.097153f, 6.589476f, 35.90253f, 6.589476f, 38.98f);
                instancePath.cubicTo(6.589476f, 42.444576f, 7.093113f, 45.73863f, 8.57948f, 49.702305f);
                instancePath.cubicTo(8.940527f, 50.64103f, 8.467659f, 51.688095f, 7.53717f, 52.010002f);
                instancePath.cubicTo(6.610118f, 52.36656f, 5.557837f, 51.880024f, 5.2284894f, 50.965103f);
                instancePath.cubicTo(3.7452471f, 46.9997f, 3.0194764f, 43.064075f, 3.0194764f, 38.98f);
                instancePath.cubicTo(3.0194764f, 35.343517f, 3.716197f, 32.02835f, 5.088672f, 29.130907f);
                instancePath.cubicTo(9.131352f, 20.650396f, 18.090721f, 15.16f, 27.889477f, 15.16f);
                instancePath.cubicTo(41.703533f, 15.16f, 52.939476f, 25.822392f, 52.939476f, 38.95f);
                instancePath.cubicTo(52.939476f, 43.981667f, 48.659203f, 48.07f, 43.399475f, 48.07f);
                instancePath.cubicTo(38.139748f, 48.07f, 33.859478f, 43.981667f, 33.859478f, 38.95f);
                instancePath.cubicTo(33.859478f, 35.90778f, 31.205343f, 33.43f, 27.919476f, 33.43f);
                instancePath.cubicTo(24.63361f, 33.43f, 21.979477f, 35.90778f, 21.979477f, 38.95f);
                instancePath.cubicTo(21.979477f, 44.00937f, 23.93411f, 48.72985f, 27.500483f, 52.26675f);
                instancePath.cubicTo(30.327671f, 55.064175f, 33.0189f, 56.590065f, 37.174767f, 57.7396f);
                instancePath.cubicTo(38.1354f, 57.988655f, 38.695545f, 58.98571f, 38.44263f, 59.92373f);
                instancePath.cubicTo(38.26758f, 60.72897f, 37.53493f, 61.3f, 36.739475f, 61.3f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
