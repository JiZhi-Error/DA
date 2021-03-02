package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class default_app_brand_notify_msg extends c {
    private final int height = 144;
    private final int width = 144;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 3.0f, 0.0f, 0.0f, 0.0f, 3.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                c.instancePaint(instancePaint2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-9074725);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(6.1533246f, 1.1116495E-15f);
                instancePath.lineTo(41.846676f, 2.652589E-15f);
                instancePath.cubicTo(43.98632f, -1.5412306E-15f, 44.762207f, 0.22278146f, 45.54443f, 0.64111847f);
                instancePath.cubicTo(46.326653f, 1.0594555f, 46.940544f, 1.6733481f, 47.358883f, 2.4555702f);
                instancePath.cubicTo(47.777218f, 3.2377925f, 48.0f, 4.0136795f, 48.0f, 6.1533246f);
                instancePath.lineTo(48.0f, 41.846676f);
                instancePath.cubicTo(48.0f, 43.98632f, 47.777218f, 44.762207f, 47.358883f, 45.54443f);
                instancePath.cubicTo(46.940544f, 46.326653f, 46.326653f, 46.940544f, 45.54443f, 47.358883f);
                instancePath.cubicTo(44.762207f, 47.777218f, 43.98632f, 48.0f, 41.846676f, 48.0f);
                instancePath.lineTo(6.1533246f, 48.0f);
                instancePath.cubicTo(4.0136795f, 48.0f, 3.2377925f, 47.777218f, 2.4555702f, 47.358883f);
                instancePath.cubicTo(1.6733481f, 46.940544f, 1.0594555f, 46.326653f, 0.64111847f, 45.54443f);
                instancePath.cubicTo(0.22278146f, 44.762207f, -6.9404863E-16f, 43.98632f, 1.1945168E-15f, 41.846676f);
                instancePath.lineTo(1.6573445E-16f, 6.1533246f);
                instancePath.cubicTo(-9.629649E-17f, 4.0136795f, 0.22278146f, 3.2377925f, 0.64111847f, 2.4555702f);
                instancePath.cubicTo(1.0594555f, 1.6733481f, 1.6733481f, 1.0594555f, 2.4555702f, 0.64111847f);
                instancePath.cubicTo(3.2377925f, 0.22278146f, 4.0136795f, -6.4590037E-16f, 6.1533246f, 1.1116495E-15f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(29.928276f, 11.544827f);
                instancePath2.cubicTo(28.395653f, 11.544827f, 26.968695f, 11.947169f, 25.757242f, 12.631471f);
                instancePath2.cubicTo(23.535007f, 13.887473f, 22.049656f, 16.107447f, 22.049656f, 18.639591f);
                instancePath2.lineTo(22.049656f, 29.167305f);
                instancePath2.cubicTo(22.049656f, 31.06321f, 20.18196f, 32.600254f, 17.87862f, 32.600254f);
                instancePath2.cubicTo(15.57482f, 32.600254f, 13.707586f, 31.06321f, 13.707586f, 29.167305f);
                instancePath2.cubicTo(13.707586f, 27.817926f, 14.655802f, 26.653929f, 16.03178f, 26.092754f);
                instancePath2.cubicTo(16.130957f, 26.052475f, 16.231525f, 26.014027f, 16.334875f, 25.980154f);
                instancePath2.cubicTo(17.20106f, 25.63686f, 17.943968f, 24.99238f, 18.219719f, 24.243998f);
                instancePath2.cubicTo(18.62709f, 23.139044f, 17.868889f, 22.24373f, 16.526743f, 22.24373f);
                instancePath2.cubicTo(16.192133f, 22.24373f, 15.852888f, 22.299574f, 15.525694f, 22.400274f);
                instancePath2.cubicTo(15.524303f, 22.400732f, 15.522913f, 22.40119f, 15.521059f, 22.401648f);
                instancePath2.cubicTo(13.580602f, 22.951834f, 11.96085f, 24.158401f, 10.988535f, 25.734356f);
                instancePath2.cubicTo(10.360562f, 26.752796f, 10.0f, 27.922289f, 10.0f, 29.167305f);
                instancePath2.cubicTo(10.0f, 33.079494f, 13.534257f, 36.26207f, 17.87862f, 36.26207f);
                instancePath2.cubicTo(19.411243f, 36.26207f, 20.838202f, 35.859726f, 22.049656f, 35.175426f);
                instancePath2.cubicTo(24.27189f, 33.919422f, 25.757242f, 31.69945f, 25.757242f, 29.167305f);
                instancePath2.lineTo(25.757242f, 18.639591f);
                instancePath2.cubicTo(25.757242f, 16.743687f, 27.624474f, 15.206641f, 29.928276f, 15.206641f);
                instancePath2.cubicTo(32.231613f, 15.206641f, 34.09931f, 16.743687f, 34.09931f, 18.639591f);
                instancePath2.cubicTo(34.09931f, 20.046642f, 33.07092f, 21.255957f, 31.598543f, 21.786005f);
                instancePath2.cubicTo(30.648937f, 22.100462f, 29.870808f, 22.779272f, 29.574202f, 23.583498f);
                instancePath2.cubicTo(29.169147f, 24.682957f, 29.923641f, 25.574608f, 31.259764f, 25.574608f);
                instancePath2.cubicTo(31.562395f, 25.574608f, 31.86827f, 25.523342f, 32.166267f, 25.440037f);
                instancePath2.cubicTo(32.21493f, 25.426764f, 32.26313f, 25.412115f, 32.311325f, 25.397926f);
                instancePath2.cubicTo(34.2402f, 24.844534f, 35.85022f, 23.641628f, 36.817898f, 22.072542f);
                instancePath2.cubicTo(37.446335f, 21.054558f, 37.806896f, 19.884607f, 37.806896f, 18.639591f);
                instancePath2.cubicTo(37.806896f, 14.727402f, 34.27264f, 11.544827f, 29.928276f, 11.544827f);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
