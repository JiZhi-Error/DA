package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class ofm_webwechat_icon extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 21.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(1.0493919f, 4.9551387f);
                instancePath.cubicTo(0.73974586f, 3.1585698f, 1.9383756f, 0.9428011f, 3.976046f, 1.1024961f);
                instancePath.cubicTo(22.345047f, 0.9727439f, 40.724033f, 1.0725534f, 59.093037f, 1.0525914f);
                instancePath.cubicTo(60.89098f, 0.72322047f, 63.00856f, 1.970838f, 62.908672f, 3.9570448f);
                instancePath.cubicTo(63.04851f, 17.002132f, 62.948627f, 30.04722f, 62.958614f, 43.092308f);
                instancePath.cubicTo(63.238297f, 44.82899f, 62.07962f, 46.994858f, 60.11187f, 46.895046f);
                instancePath.cubicTo(53.07991f, 47.05474f, 46.03796f, 46.90503f, 38.99601f, 46.954933f);
                instancePath.lineTo(38.99601f, 50.95729f);
                instancePath.cubicTo(42.32221f, 50.927345f, 45.658394f, 50.8475f, 48.984592f, 51.17687f);
                instancePath.cubicTo(48.984592f, 52.274773f, 48.914673f, 54.400715f, 47.17666f, 53.93161f);
                instancePath.cubicTo(37.068214f, 53.951572f, 26.95977f, 53.951572f, 16.851326f, 53.93161f);
                instancePath.cubicTo(15.083348f, 54.410694f, 14.993451f, 52.25481f, 15.093336f, 51.136948f);
                instancePath.cubicTo(18.389568f, 50.87744f, 21.705776f, 50.917366f, 25.011997f, 50.95729f);
                instancePath.lineTo(25.011997f, 46.954933f);
                instancePath.cubicTo(17.980036f, 46.90503f, 10.948075f, 47.05474f, 3.926103f, 46.895046f);
                instancePath.cubicTo(1.9084098f, 47.0248f, 0.73974586f, 44.80903f, 1.0493919f, 43.032425f);
                instancePath.cubicTo(1.0294148f, 30.336668f, 1.0294148f, 17.650894f, 1.0493919f, 4.9551387f);
                instancePath.lineTo(1.0493919f, 4.9551387f);
                instancePath.close();
                instancePath.moveTo(5.0f, 5.0f);
                instancePath.lineTo(5.0f, 39.0f);
                instancePath.lineTo(59.0f, 39.0f);
                instancePath.lineTo(59.0f, 5.0f);
                instancePath.lineTo(5.0f, 5.0f);
                instancePath.lineTo(5.0f, 5.0f);
                instancePath.close();
                instancePath.moveTo(31.225903f, 41.13082f);
                instancePath.cubicTo(28.789328f, 42.126995f, 30.338081f, 45.77963f, 32.794384f, 44.84987f);
                instancePath.cubicTo(35.201366f, 43.844208f, 33.65261f, 40.276962f, 31.225903f, 41.13082f);
                instancePath.lineTo(31.225903f, 41.13082f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-15658735);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 29.0f, 0.0f, 1.0f, 40.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.saveLayerAlpha(null, 17, 31);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint5, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(2.2259018f, 1.130823f);
                instancePath2.cubicTo(4.6526113f, 0.2769606f, 6.2013645f, 3.8442078f, 3.7943847f, 4.849868f);
                instancePath2.cubicTo(1.3380812f, 5.779629f, -0.21067229f, 2.1269958f, 2.2259018f, 1.130823f);
                instancePath2.lineTo(2.2259018f, 1.130823f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
