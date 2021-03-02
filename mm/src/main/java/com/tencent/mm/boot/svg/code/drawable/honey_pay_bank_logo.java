package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class honey_pay_bank_logo extends c {
    private final int height = 40;
    private final int width = 40;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 40;
            case 1:
                return 40;
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
                instancePaint4.setColor(-15616);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(20.0f, 0.0f);
                instancePath.cubicTo(31.045696f, 0.0f, 40.0f, 8.954305f, 40.0f, 20.0f);
                instancePath.cubicTo(40.0f, 31.045696f, 31.045696f, 40.0f, 20.0f, 40.0f);
                instancePath.cubicTo(8.954305f, 40.0f, 0.0f, 31.045696f, 0.0f, 20.0f);
                instancePath.cubicTo(0.0f, 8.954305f, 8.954305f, 0.0f, 20.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 4.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                instancePaint5.setColor(-1);
                instancePaint6.setStrokeWidth(1.0f);
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint5, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(25.152039f, 15.990615f);
                instancePath2.cubicTo(27.42224f, 12.216314f, 27.87678f, 8.533018f, 26.107307f, 6.763546f);
                instancePath2.cubicTo(24.653276f, 5.309515f, 21.813135f, 5.3108554f, 18.534306f, 6.836318f);
                instancePath2.cubicTo(18.13371f, 7.022693f, 17.657879f, 6.849034f, 17.471502f, 6.448439f);
                instancePath2.cubicTo(17.285128f, 6.0478444f, 17.458788f, 5.5720115f, 17.859383f, 5.3856363f);
                instancePath2.cubicTo(21.680468f, 3.6078906f, 25.212727f, 3.6062233f, 27.238678f, 5.632175f);
                instancePath2.cubicTo(29.696928f, 8.090425f, 29.118807f, 12.688654f, 26.316029f, 17.154604f);
                instancePath2.lineTo(27.95405f, 18.792625f);
                instancePath2.cubicTo(28.52682f, 19.365395f, 28.52682f, 20.294037f, 27.95405f, 20.866806f);
                instancePath2.lineTo(20.60014f, 28.220716f);
                instancePath2.cubicTo(20.02737f, 28.793486f, 19.098728f, 28.793486f, 18.525959f, 28.220716f);
                instancePath2.lineTo(16.315575f, 26.01033f);
                instancePath2.cubicTo(12.692017f, 27.609785f, 9.258259f, 27.62686f, 7.251127f, 25.619726f);
                instancePath2.cubicTo(5.847475f, 24.216076f, 5.407673f, 22.073048f, 5.889585f, 19.58126f);
                instancePath2.cubicTo(5.97348f, 19.14747f, 6.3931465f, 18.863825f, 6.826936f, 18.94772f);
                instancePath2.cubicTo(7.2607255f, 19.031614f, 7.544371f, 19.45128f, 7.4604764f, 19.88507f);
                instancePath2.cubicTo(7.071023f, 21.898788f, 7.401048f, 23.506907f, 8.382498f, 24.488356f);
                instancePath2.cubicTo(9.7531185f, 25.858976f, 12.272025f, 25.895203f, 15.092057f, 24.786814f);
                instancePath2.lineTo(3.6295767f, 13.324334f);
                instancePath2.cubicTo(3.0568078f, 12.751565f, 3.0568078f, 11.822923f, 3.6295767f, 11.250154f);
                instancePath2.lineTo(10.983487f, 3.8962433f);
                instancePath2.cubicTo(11.556256f, 3.3234744f, 12.484899f, 3.3234744f, 13.057667f, 3.8962433f);
                instancePath2.lineTo(25.152039f, 15.990615f);
                instancePath2.lineTo(25.152039f, 15.990615f);
                instancePath2.close();
                instancePath2.moveTo(24.253609f, 17.354927f);
                instancePath2.lineTo(12.020577f, 5.1218953f);
                instancePath2.lineTo(4.8552284f, 12.287244f);
                instancePath2.lineTo(16.643747f, 24.075762f);
                instancePath2.cubicTo(18.37848f, 23.169596f, 20.1662f, 21.86643f, 21.82579f, 20.20684f);
                instancePath2.cubicTo(22.747261f, 19.28537f, 23.55885f, 18.324398f, 24.253609f, 17.354927f);
                instancePath2.lineTo(24.253609f, 17.354927f);
                instancePath2.close();
                instancePath2.moveTo(25.399769f, 18.501087f);
                instancePath2.cubicTo(24.686337f, 19.472351f, 23.869255f, 20.426117f, 22.957163f, 21.338211f);
                instancePath2.cubicTo(21.333265f, 22.962107f, 19.577274f, 24.284828f, 17.82562f, 25.257637f);
                instancePath2.lineTo(19.56305f, 26.995066f);
                instancePath2.lineTo(26.728397f, 19.829716f);
                instancePath2.lineTo(25.399769f, 18.501087f);
                instancePath2.lineTo(25.399769f, 18.501087f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint7);
                canvas.restore();
                Paint instancePaint8 = c.instancePaint(instancePaint, looper);
                instancePaint8.setColor(-2565928);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(0.0f, 0.0f);
                instancePath3.lineTo(32.0f, 0.0f);
                instancePath3.lineTo(32.0f, 32.0f);
                instancePath3.lineTo(0.0f, 32.0f);
                instancePath3.lineTo(0.0f, 0.0f);
                instancePath3.close();
                canvas.saveLayerAlpha(null, 0, 31);
                canvas.drawPath(instancePath3, c.instancePaint(instancePaint8, looper));
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
