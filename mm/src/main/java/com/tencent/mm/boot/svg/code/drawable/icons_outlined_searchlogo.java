package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_searchlogo extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(34.91217f, 25.634386f);
                instancePath.lineTo(62.88139f, 22.10429f);
                instancePath.cubicTo(63.703297f, 22.000555f, 64.453674f, 22.582748f, 64.55741f, 23.404654f);
                instancePath.cubicTo(64.56267f, 23.446283f, 64.56617f, 23.488115f, 64.56792f, 23.530039f);
                instancePath.lineTo(64.73427f, 27.522442f);
                instancePath.cubicTo(64.76875f, 28.350151f, 64.125725f, 29.049099f, 63.298016f, 29.083588f);
                instancePath.cubicTo(63.272408f, 29.084654f, 63.246777f, 29.085066f, 63.221146f, 29.084818f);
                instancePath.lineTo(35.08558f, 28.814285f);
                instancePath.cubicTo(34.262814f, 28.806374f, 33.6f, 28.137154f, 33.6f, 27.314354f);
                instancePath.lineTo(33.6f, 27.12258f);
                instancePath.cubicTo(33.6f, 26.366777f, 34.162315f, 25.729029f, 34.91217f, 25.634386f);
                instancePath.close();
                instancePath.moveTo(25.766682f, 20.061838f);
                instancePath.lineTo(29.342863f, 3.4581344f);
                instancePath.cubicTo(29.517294f, 2.6482792f, 30.315214f, 2.1331654f, 31.12507f, 2.3075957f);
                instancePath.cubicTo(31.18501f, 2.3205063f, 31.244104f, 2.3370798f, 31.302017f, 2.3572233f);
                instancePath.lineTo(35.062096f, 3.6650774f);
                instancePath.cubicTo(35.844543f, 3.9372327f, 36.258217f, 4.7921567f, 35.98606f, 5.5746036f);
                instancePath.cubicTo(35.972595f, 5.613317f, 35.95755f, 5.651462f, 35.94096f, 5.6889434f);
                instancePath.lineTo(29.085533f, 21.177128f);
                instancePath.cubicTo(28.75878f, 21.915348f, 27.906366f, 22.262547f, 27.156805f, 21.962723f);
                instancePath.lineTo(26.675968f, 21.770388f);
                instancePath.cubicTo(25.996847f, 21.49874f, 25.612673f, 20.776876f, 25.766682f, 20.061838f);
                instancePath.close();
                instancePath.moveTo(17.266468f, 28.823395f);
                instancePath.lineTo(3.1649268f, 29.070791f);
                instancePath.cubicTo(2.336627f, 29.085321f, 1.6533774f, 28.425632f, 1.6388458f, 27.597334f);
                instancePath.cubicTo(1.637931f, 27.545189f, 1.6397363f, 27.493032f, 1.6442542f, 27.441076f);
                instancePath.lineTo(1.9528012f, 23.892786f);
                instancePath.cubicTo(2.0245676f, 23.067472f, 2.7517939f, 22.456602f, 3.5771065f, 22.52837f);
                instancePath.cubicTo(3.6390703f, 22.533756f, 3.7006388f, 22.542994f, 3.7614558f, 22.556026f);
                instancePath.lineTo(17.588251f, 25.518911f);
                instancePath.cubicTo(18.335178f, 25.678967f, 18.842522f, 26.374777f, 18.766514f, 27.13487f);
                instancePath.lineTo(18.732712f, 27.472881f);
                instancePath.cubicTo(18.657032f, 28.229677f, 18.026922f, 28.810055f, 17.266468f, 28.823395f);
                instancePath.close();
                instancePath.moveTo(23.348227f, 37.991795f);
                instancePath.lineTo(17.201086f, 62.31309f);
                instancePath.cubicTo(16.998087f, 63.11626f, 16.182426f, 63.6028f, 15.379255f, 63.399796f);
                instancePath.cubicTo(15.33699f, 63.389114f, 15.295212f, 63.376595f, 15.254037f, 63.362274f);
                instancePath.lineTo(11.406978f, 62.024166f);
                instancePath.cubicTo(10.624531f, 61.75201f, 10.210857f, 60.897087f, 10.483013f, 60.11464f);
                instancePath.cubicTo(10.49315f, 60.0855f, 10.504183f, 60.056675f, 10.516097f, 60.028214f);
                instancePath.lineTo(20.178617f, 36.945522f);
                instancePath.cubicTo(20.475008f, 36.23748f, 21.258097f, 35.867428f, 21.993301f, 36.08799f);
                instancePath.lineTo(22.32498f, 36.187492f);
                instancePath.cubicTo(23.093952f, 36.418186f, 23.544954f, 37.213444f, 23.348227f, 37.991795f);
                instancePath.close();
                instancePath.moveTo(33.317963f, 35.512115f);
                instancePath.lineTo(54.749126f, 59.141342f);
                instancePath.cubicTo(55.305676f, 59.754974f, 55.2594f, 60.703594f, 54.645767f, 61.260143f);
                instancePath.cubicTo(54.630245f, 61.274223f, 54.614426f, 61.28798f, 54.598324f, 61.3014f);
                instancePath.lineTo(51.640293f, 63.766422f);
                instancePath.cubicTo(51.00388f, 64.29677f, 50.05803f, 64.210785f, 49.527683f, 63.574368f);
                instancePath.cubicTo(49.504158f, 63.546135f, 49.481674f, 63.517048f, 49.460285f, 63.487164f);
                instancePath.lineTo(30.853853f, 37.49288f);
                instancePath.cubicTo(30.37924f, 36.82982f, 30.52125f, 35.90906f, 31.173584f, 35.41981f);
                instancePath.lineTo(31.306885f, 35.319836f);
                instancePath.cubicTo(31.92638f, 34.855213f, 32.79773f, 34.938522f, 33.317963f, 35.512115f);
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
