package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icon_filled_activity extends c {
    private final int height = 90;
    private final int width = 90;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                instancePaint3.setColor(-855310);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(90.0f, 0.0f);
                instancePath.lineTo(90.0f, 90.0f);
                instancePath.lineTo(0.0f, 90.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(Integer.MIN_VALUE);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 18.0f, 0.0f, 1.0f, 18.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 0.89879405f, -0.43837115f, 15.343878f, 0.43837115f, 0.89879405f, -7.4762163f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(22.157137f, 48.809395f);
                instancePath2.lineTo(5.970486f, 15.38923f);
                instancePath2.cubicTo(5.7134776f, 14.835043f, 5.9342365f, 14.176727f, 6.473492f, 13.889235f);
                instancePath2.cubicTo(6.525796f, 13.819521f, 6.592122f, 13.76152f, 6.6682043f, 13.718965f);
                instancePath2.cubicTo(8.274843f, 12.573145f, 10.051613f, 11.6866665f, 11.933543f, 11.091946f);
                instancePath2.cubicTo(13.843744f, 10.485227f, 15.828424f, 10.144188f, 17.831696f, 10.078435f);
                instancePath2.lineTo(18.642996f, 10.078435f);
                instancePath2.cubicTo(20.909342f, 10.082901f, 23.162401f, 10.42448f, 25.32811f, 11.091946f);
                instancePath2.cubicTo(27.85574f, 11.982647f, 30.497282f, 12.509542f, 33.17338f, 12.656806f);
                instancePath2.cubicTo(35.850674f, 12.656806f, 37.027058f, 11.635187f, 38.511738f, 10.3378935f);
                instancePath2.lineTo(38.86871f, 10.029786f);
                instancePath2.cubicTo(39.240585f, 9.679944f, 39.7292f, 9.480572f, 40.239807f, 9.470328f);
                instancePath2.cubicTo(40.524784f, 9.470834f, 40.804604f, 9.546339f, 41.05111f, 9.689247f);
                instancePath2.cubicTo(41.935425f, 10.216272f, 41.911087f, 11.3108635f, 41.821842f, 12.048699f);
                instancePath2.cubicTo(41.67822f, 12.981487f, 41.430584f, 13.895281f, 41.08356f, 14.773016f);
                instancePath2.cubicTo(40.095985f, 17.417664f, 38.564888f, 19.826162f, 36.58896f, 21.843266f);
                instancePath2.cubicTo(35.48213f, 22.963287f, 34.17858f, 23.87027f, 32.743393f, 24.518932f);
                instancePath2.lineTo(32.467552f, 24.632446f);
                instancePath2.cubicTo(31.249294f, 25.129654f, 29.94603f, 25.385744f, 28.630102f, 25.386497f);
                instancePath2.lineTo(27.778236f, 25.386497f);
                instancePath2.cubicTo(26.918259f, 25.313526f, 26.098845f, 25.281094f, 25.344336f, 25.281094f);
                instancePath2.cubicTo(18.853933f, 25.281094f, 17.361141f, 27.87568f, 16.046835f, 30.145945f);
                instancePath2.lineTo(15.981931f, 30.267565f);
                instancePath2.lineTo(24.501795f, 47.85264f);
                instancePath2.cubicTo(24.625086f, 48.13435f, 24.625086f, 48.454712f, 24.501795f, 48.73642f);
                instancePath2.cubicTo(24.3748f, 49.054676f, 24.122526f, 49.306797f, 23.804075f, 49.433716f);
                instancePath2.cubicTo(23.653135f, 49.487877f, 23.493896f, 49.514996f, 23.33352f, 49.514996f);
                instancePath2.cubicTo(22.839455f, 49.520954f, 22.384201f, 49.247967f, 22.157137f, 48.809395f);
                instancePath2.close();
                instancePath2.moveTo(14.675737f, 27.535141f);
                instancePath2.cubicTo(15.461037f, 26.33468f, 16.506346f, 25.326029f, 17.734339f, 24.583797f);
                instancePath2.cubicTo(19.68146f, 23.424341f, 22.188377f, 22.864883f, 25.409239f, 22.864883f);
                instancePath2.cubicTo(26.22054f, 22.864883f, 27.104856f, 22.864883f, 28.013514f, 22.978397f);
                instancePath2.lineTo(28.638214f, 22.978397f);
                instancePath2.cubicTo(30.92608f, 22.978397f, 33.08414f, 21.932455f, 35.039375f, 19.864893f);
                instancePath2.cubicTo(36.469852f, 18.315645f, 37.615166f, 16.525976f, 38.422497f, 14.578422f);
                instancePath2.cubicTo(38.62532f, 14.100045f, 38.795692f, 13.645992f, 38.925503f, 13.208156f);
                instancePath2.cubicTo(37.799786f, 14.082996f, 36.47163f, 14.660226f, 35.063713f, 14.886529f);
                instancePath2.cubicTo(34.452194f, 14.985987f, 33.833504f, 15.034801f, 33.213947f, 15.0324745f);
                instancePath2.cubicTo(30.249949f, 14.893803f, 27.32113f, 14.33133f, 24.51681f, 13.362209f);
                instancePath2.cubicTo(22.602219f, 12.763239f, 20.608618f, 12.454405f, 18.60243f, 12.445995f);
                instancePath2.cubicTo(16.655602f, 12.450294f, 14.721017f, 12.753841f, 12.866538f, 13.345993f);
                instancePath2.cubicTo(11.410968f, 13.800372f, 10.020244f, 14.440807f, 8.728907f, 15.251392f);
                instancePath2.lineTo(14.675737f, 27.535141f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
