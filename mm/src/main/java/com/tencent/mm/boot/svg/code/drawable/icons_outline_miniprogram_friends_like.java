package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outline_miniprogram_friends_like extends c {
    private final int height = 24;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                instancePaint3.setColor(-436207616);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(1.2f, 16.8f);
                instancePath.lineTo(17.8f, 16.8f);
                instancePath.lineTo(17.8f, 16.315464f);
                instancePath.cubicTo(17.8f, 16.08606f, 17.564678f, 15.71002f, 17.35981f, 15.610087f);
                instancePath.lineTo(11.699456f, 12.84904f);
                instancePath.cubicTo(10.172874f, 12.104393f, 9.795573f, 10.302913f, 10.889337f, 9.006369f);
                instancePath.lineTo(11.250869f, 8.577808f);
                instancePath.cubicTo(11.802195f, 7.9242687f, 12.3f, 6.564391f, 12.3f, 5.7101855f);
                instancePath.lineTo(12.3f, 4.0002074f);
                instancePath.cubicTo(12.3f, 2.454914f, 11.045589f, 1.2f, 9.5f, 1.2f);
                instancePath.cubicTo(7.956309f, 1.2f, 6.7f, 2.4552028f, 6.7f, 3.9995804f);
                instancePath.lineTo(6.7f, 5.7092905f);
                instancePath.cubicTo(6.7f, 6.565664f, 7.195747f, 7.9204836f, 7.7490783f, 8.576312f);
                instancePath.lineTo(8.110611f, 9.004812f);
                instancePath.cubicTo(9.206636f, 10.30386f, 8.825214f, 12.10365f, 7.3007193f, 12.847587f);
                instancePath.lineTo(1.6403663f, 15.6097765f);
                instancePath.cubicTo(1.4370171f, 15.709009f, 1.2f, 16.088676f, 1.2f, 16.315464f);
                instancePath.lineTo(1.2f, 16.8f);
                instancePath.close();
                instancePath.moveTo(9.5f, 0.0f);
                instancePath.cubicTo(10.702559f, 0.0f, 11.781173f, 0.5313033f, 12.514435f, 1.3715119f);
                instancePath.lineTo(12.496095f, 1.3506423f);
                instancePath.lineTo(12.496095f, 1.3506423f);
                instancePath.cubicTo(12.94908f, 1.1262641f, 13.459958f, 1.0f, 14.0f, 1.0f);
                instancePath.cubicTo(15.860328f, 1.0f, 17.368422f, 2.4941502f, 17.368422f, 4.333506f);
                instancePath.lineTo(17.368422f, 5.758488f);
                instancePath.cubicTo(17.368422f, 6.7077465f, 16.863943f, 8.06905f, 16.24681f, 8.792977f);
                instancePath.lineTo(15.942362f, 9.15011f);
                instancePath.cubicTo(15.445922f, 9.732459f, 15.601f, 10.473664f, 16.295198f, 10.808759f);
                instancePath.lineTo(21.061813f, 13.109632f);
                instancePath.cubicTo(21.57996f, 13.359744f, 22.0f, 14.020975f, 22.0f, 14.596219f);
                instancePath.lineTo(22.0f, 15.167968f);
                instancePath.cubicTo(22.0f, 15.627486f, 21.620274f, 16.0f, 21.15669f, 16.0f);
                instancePath.lineTo(18.967646f, 16.0f);
                instancePath.lineTo(18.970575f, 16.015045f);
                instancePath.cubicTo(18.98982f, 16.11613f, 19.0f, 16.21685f, 19.0f, 16.315464f);
                instancePath.lineTo(19.0f, 17.001562f);
                instancePath.cubicTo(19.0f, 17.552984f, 18.549074f, 18.0f, 17.99857f, 18.0f);
                instancePath.lineTo(1.0014296f, 18.0f);
                instancePath.cubicTo(0.44835532f, 18.0f, 0.0f, 17.555756f, 0.0f, 17.001562f);
                instancePath.lineTo(0.0f, 16.315464f);
                instancePath.cubicTo(0.0f, 15.630374f, 0.49815091f, 14.831908f, 1.1140976f, 14.531333f);
                instancePath.lineTo(6.774451f, 11.769143f);
                instancePath.cubicTo(7.595377f, 11.36854f, 7.786259f, 10.481262f, 7.193445f, 9.778639f);
                instancePath.lineTo(6.8319125f, 9.350138f);
                instancePath.cubicTo(6.096318f, 8.478285f, 5.5f, 6.8494964f, 5.5f, 5.7092905f);
                instancePath.lineTo(5.5f, 3.9995804f);
                instancePath.cubicTo(5.5f, 1.7906731f, 7.2953563f, 0.0f, 9.5f, 0.0f);
                instancePath.close();
                instancePath.moveTo(14.0f, 2.2f);
                instancePath.cubicTo(13.699479f, 2.2f, 13.413292f, 2.2603538f, 13.153156f, 2.3693054f);
                instancePath.lineTo(13.143256f, 2.3473558f);
                instancePath.cubicTo(13.372382f, 2.851302f, 13.5f, 3.410995f, 13.5f, 4.0002074f);
                instancePath.lineTo(13.5f, 5.7101855f);
                instancePath.cubicTo(13.5f, 6.849296f, 12.900932f, 8.482861f, 12.168087f, 9.351573f);
                instancePath.lineTo(11.806555f, 9.780132f);
                instancePath.cubicTo(11.217032f, 10.4789505f, 11.401188f, 11.368398f, 12.225549f, 11.770511f);
                instancePath.lineTo(17.885902f, 14.531558f);
                instancePath.cubicTo(18.04204f, 14.607719f, 18.190676f, 14.71565f, 18.325563f, 14.845601f);
                instancePath.lineTo(18.276657f, 14.8f);
                instancePath.lineTo(18.276657f, 14.8f);
                instancePath.lineTo(20.8f, 14.8f);
                instancePath.lineTo(20.8f, 14.596219f);
                instancePath.cubicTo(20.8f, 14.484596f, 20.646305f, 14.241552f, 20.54016f, 14.190315f);
                instancePath.lineTo(15.773546f, 11.889442f);
                instancePath.cubicTo(14.372796f, 11.213292f, 14.021533f, 9.553606f, 15.029153f, 8.371619f);
                instancePath.lineTo(15.333601f, 8.014486f);
                instancePath.cubicTo(15.76679f, 7.506334f, 16.16842f, 6.420608f, 16.16842f, 5.758488f);
                instancePath.lineTo(16.16842f, 4.333506f);
                instancePath.cubicTo(16.16842f, 3.1590285f, 15.199687f, 2.2f, 14.0f, 2.2f);
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
