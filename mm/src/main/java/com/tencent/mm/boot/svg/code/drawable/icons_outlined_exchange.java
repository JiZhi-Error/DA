package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_exchange extends c {
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
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(9.5f, 0.0f);
                instancePath.cubicTo(11.709139f, 0.0f, 13.5f, 1.7929802f, 13.5f, 4.0002074f);
                instancePath.lineTo(13.5f, 5.7101855f);
                instancePath.cubicTo(13.5f, 6.849296f, 12.900932f, 8.482861f, 12.168087f, 9.351573f);
                instancePath.lineTo(11.806555f, 9.780132f);
                instancePath.cubicTo(11.217032f, 10.4789505f, 11.401188f, 11.368398f, 12.225549f, 11.770511f);
                instancePath.lineTo(12.298645f, 11.806463f);
                instancePath.cubicTo(12.120915f, 12.164769f, 11.986195f, 12.54712f, 11.899969f, 12.947231f);
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
                instancePath.lineTo(12.078f, 16.8f);
                instancePath.lineTo(12.078f, 18.0f);
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
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 13.0f, 0.0f, 1.0f, 10.5f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(4.0f, 4.1744386E-14f);
                instancePath2.cubicTo(5.4002943f, 4.1744386E-14f, 6.6735387f, 0.73457205f, 7.3840485f, 1.9115143f);
                instancePath2.lineTo(6.3736978f, 2.46305f);
                instancePath2.cubicTo(5.9253335f, 1.6235995f, 5.0039797f, 1.1f, 4.0f, 1.1f);
                instancePath2.cubicTo(2.4461849f, 1.1f, 1.1827937f, 2.3538935f, 1.1506282f, 3.9f);
                instancePath2.cubicTo(1.1506282f, 3.9f, 0.76708543f, 3.9f, 5.2846616E-14f, 3.9f);
                instancePath2.cubicTo(0.05f, 1.7684753f, 1.8184752f, 4.1744386E-14f, 4.0f, 4.1744386E-14f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(7.949f, 3.998f);
                instancePath3.lineTo(7.95f, 3.95f);
                instancePath3.cubicTo(7.95f, 6.1315246f, 6.1815248f, 7.9f, 4.0f, 7.9f);
                instancePath3.cubicTo(2.6667264f, 7.9f, 1.4463966f, 7.2344766f, 0.71736383f, 6.147746f);
                instancePath3.lineTo(1.700229f, 5.5486f);
                instancePath3.cubicTo(2.1615448f, 6.326009f, 3.0440996f, 6.8f, 4.0f, 6.8f);
                instancePath3.cubicTo(5.559237f, 6.8f, 6.82602f, 5.5516095f, 6.8496637f, 3.998f);
                instancePath3.cubicTo(6.8496637f, 4.0005045f, 7.216109f, 4.0005045f, 7.949f, 3.998f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint4, looper);
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, -6.123234E-17f, -1.0f, 7.730032f, -1.0f, 6.123234E-17f, 7.730032f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(7.629344f, 0.07534375f);
                instancePath4.lineTo(7.629344f, 0.97534376f);
                instancePath4.lineTo(5.980031f, 0.97534376f);
                instancePath4.lineTo(5.844676f, 1.0899884f);
                instancePath4.lineTo(5.844676f, 2.8253438f);
                instancePath4.lineTo(4.9300313f, 2.8253438f);
                instancePath4.lineTo(4.9300313f, 0.42534375f);
                instancePath4.lineTo(4.937906f, 0.3497448f);
                instancePath4.cubicTo(4.970197f, 0.19322073f, 5.113031f, 0.07534375f, 5.280031f, 0.07534375f);
                instancePath4.lineTo(7.629344f, 0.07534375f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 1);
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint4, looper);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(3.051f, 5.099f);
                instancePath5.lineTo(3.0516114f, 6.05f);
                instancePath5.lineTo(1.4016113f, 6.05f);
                instancePath5.lineTo(1.266256f, 6.1146445f);
                instancePath5.lineTo(1.266256f, 7.85f);
                instancePath5.lineTo(0.35161132f, 7.85f);
                instancePath5.lineTo(0.35161132f, 5.450021f);
                instancePath5.lineTo(0.35948578f, 5.374401f);
                instancePath5.cubicTo(0.39177725f, 5.217877f, 0.5346111f, 5.099f, 0.70161134f, 5.099f);
                instancePath5.lineTo(3.051f, 5.099f);
                instancePath5.close();
                WeChatSVGRenderC2Java.setFillType(instancePath5, 1);
                canvas.drawPath(instancePath5, instancePaint8);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                Path instancePath6 = c.instancePath(looper);
                instancePath6.moveTo(0.0f, 0.0f);
                instancePath6.lineTo(24.0f, 0.0f);
                instancePath6.lineTo(24.0f, 24.0f);
                instancePath6.lineTo(0.0f, 24.0f);
                instancePath6.lineTo(0.0f, 0.0f);
                instancePath6.close();
                c.done(looper);
                break;
        }
        return 0;
    }
}