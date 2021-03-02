package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class actionsheet_default_appbrand_icon extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -3.0f, 0.0f, 1.0f, -3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-855310);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(36.0f, 0.0f);
                instancePath.cubicTo(55.88225f, 0.0f, 72.0f, 16.117748f, 72.0f, 36.0f);
                instancePath.cubicTo(72.0f, 55.88225f, 55.88225f, 72.0f, 36.0f, 72.0f);
                instancePath.cubicTo(16.117748f, 72.0f, 0.0f, 55.88225f, 0.0f, 36.0f);
                instancePath.cubicTo(0.0f, 16.117748f, 16.117748f, 0.0f, 36.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-3355444);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(46.47831f, 37.814087f);
                instancePath2.cubicTo(46.42071f, 37.830936f, 46.363693f, 37.848957f, 46.30571f, 37.864826f);
                instancePath2.cubicTo(45.952164f, 37.9663f, 45.5895f, 38.028397f, 45.230137f, 38.028397f);
                instancePath2.cubicTo(43.64432f, 38.028397f, 42.748917f, 36.94647f, 43.229877f, 35.611637f);
                instancePath2.cubicTo(43.58168f, 34.63549f, 44.505203f, 33.811554f, 45.632362f, 33.430145f);
                instancePath2.cubicTo(47.37934f, 32.786633f, 48.599976f, 31.318983f, 48.599976f, 29.611168f);
                instancePath2.cubicTo(48.599976f, 27.309984f, 46.38367f, 25.444473f, 43.649944f, 25.444473f);
                instancePath2.cubicTo(40.916027f, 25.444473f, 38.699917f, 27.309984f, 38.699917f, 29.611168f);
                instancePath2.lineTo(38.699917f, 42.38903f);
                instancePath2.cubicTo(38.699917f, 45.46204f, 36.93723f, 48.156776f, 34.29989f, 49.68084f);
                instancePath2.cubicTo(32.86224f, 50.51163f, 31.168789f, 51.0f, 29.350056f, 51.0f);
                instancePath2.cubicTo(24.19426f, 51.0f, 20.0f, 47.13714f, 20.0f, 42.38903f);
                instancePath2.cubicTo(20.0f, 40.877697f, 20.427824f, 39.458237f, 21.173315f, 38.222336f);
                instancePath2.cubicTo(22.327042f, 36.309612f, 24.24953f, 34.844902f, 26.552137f, 34.177097f);
                instancePath2.cubicTo(26.554075f, 34.17651f, 26.55582f, 34.175922f, 26.55776f, 34.17533f);
                instancePath2.cubicTo(26.946022f, 34.05329f, 27.348633f, 33.98551f, 27.74562f, 33.98551f);
                instancePath2.cubicTo(29.338419f, 33.98551f, 30.238089f, 35.072533f, 29.754993f, 36.413242f);
                instancePath2.cubicTo(29.42763f, 37.321804f, 28.545996f, 38.10421f, 27.518133f, 38.52049f);
                instancePath2.cubicTo(27.39537f, 38.56182f, 27.275908f, 38.60825f, 27.157993f, 38.657223f);
                instancePath2.cubicTo(25.525244f, 39.338154f, 24.400026f, 40.75115f, 24.400026f, 42.38903f);
                instancePath2.cubicTo(24.400026f, 44.690212f, 26.616135f, 46.555527f, 29.350056f, 46.555527f);
                instancePath2.cubicTo(32.083782f, 46.555527f, 34.29989f, 44.690212f, 34.29989f, 42.38903f);
                instancePath2.lineTo(34.29989f, 29.611168f);
                instancePath2.cubicTo(34.29989f, 26.537962f, 36.06238f, 23.84342f, 38.699917f, 22.319159f);
                instancePath2.cubicTo(40.137566f, 21.488367f, 41.831017f, 21.0f, 43.649944f, 21.0f);
                instancePath2.cubicTo(48.805546f, 21.0f, 53.0f, 24.86286f, 53.0f, 29.611168f);
                instancePath2.cubicTo(53.0f, 31.122305f, 52.571983f, 32.541958f, 51.826492f, 33.777863f);
                instancePath2.cubicTo(50.677807f, 35.68216f, 48.767147f, 37.14197f, 46.47831f, 37.814087f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
