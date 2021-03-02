package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_finder_icon extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 34.411766f, 0.0f, 1.0f, 10.5f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.restore();
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(72.0f, 0.0f);
                instancePath.lineTo(72.0f, 72.0f);
                instancePath.lineTo(0.0f, 72.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(56.302994f, 10.714713f);
                instancePath2.cubicTo(59.58173f, 9.3774185f, 62.38492f, 10.660283f, 63.84572f, 14.347345f);
                instancePath2.cubicTo(67.77679f, 24.267017f, 58.574986f, 61.8f, 51.35562f, 61.8f);
                instancePath2.cubicTo(49.019794f, 61.8f, 46.67889f, 59.840286f, 43.951683f, 56.317757f);
                instancePath2.cubicTo(42.722534f, 54.730156f, 41.439453f, 52.837715f, 40.12026f, 50.70183f);
                instancePath2.cubicTo(39.06494f, 48.99319f, 38.0276f, 47.19672f, 37.031036f, 45.378624f);
                instancePath2.lineTo(36.000767f, 43.464806f);
                instancePath2.lineTo(36.000767f, 43.464806f);
                instancePath2.lineTo(35.951084f, 43.55578f);
                instancePath2.cubicTo(34.661964f, 45.98931f, 33.28683f, 48.42364f, 31.879742f, 50.70183f);
                instancePath2.cubicTo(30.560547f, 52.837715f, 29.277468f, 54.730156f, 28.048317f, 56.317757f);
                instancePath2.cubicTo(25.321108f, 59.840286f, 22.980204f, 61.8f, 20.64438f, 61.8f);
                instancePath2.cubicTo(13.425013f, 61.8f, 4.223214f, 24.267017f, 8.154228f, 14.347482f);
                instancePath2.cubicTo(9.615081f, 10.660283f, 12.418269f, 9.3774185f, 15.697006f, 10.714713f);
                instancePath2.cubicTo(18.074213f, 11.684302f, 20.69782f, 14.002635f, 23.629663f, 17.475548f);
                instancePath2.cubicTo(25.374382f, 19.542255f, 27.199516f, 21.989664f, 29.07808f, 24.740967f);
                instancePath2.cubicTo(31.15805f, 27.787247f, 33.195827f, 31.044739f, 35.108894f, 34.301495f);
                instancePath2.lineTo(36.001095f, 35.834164f);
                instancePath2.lineTo(36.891106f, 34.301495f);
                instancePath2.cubicTo(38.421562f, 31.696089f, 40.031826f, 29.090214f, 41.67966f, 26.592384f);
                instancePath2.lineTo(42.92192f, 24.740967f);
                instancePath2.cubicTo(44.800484f, 21.989664f, 46.625618f, 19.542255f, 48.37034f, 17.475548f);
                instancePath2.cubicTo(51.30218f, 14.002635f, 53.92579f, 11.684302f, 56.302994f, 10.714713f);
                instancePath2.close();
                instancePath2.moveTo(14.337419f, 14.048108f);
                instancePath2.cubicTo(12.952862f, 13.483391f, 12.239483f, 13.809865f, 11.501062f, 15.673641f);
                instancePath2.cubicTo(10.210722f, 18.929691f, 10.752568f, 27.134665f, 12.665434f, 36.342224f);
                instancePath2.lineTo(13.112896f, 38.403248f);
                instancePath2.lineTo(13.60437f, 40.487656f);
                instancePath2.cubicTo(16.018845f, 50.335995f, 19.492588f, 58.2f, 20.64438f, 58.2f);
                instancePath2.cubicTo(21.432722f, 58.2f, 23.15355f, 56.75939f, 25.201746f, 54.113888f);
                instancePath2.cubicTo(26.34459f, 52.637764f, 27.55931f, 50.84615f, 28.816853f, 48.81009f);
                instancePath2.cubicTo(29.837606f, 47.157406f, 30.84509f, 45.41248f, 31.814318f, 43.64416f);
                instancePath2.lineTo(32.98602f, 41.46094f);
                instancePath2.lineTo(32.98602f, 41.46094f);
                instancePath2.lineTo(33.969f, 39.552f);
                instancePath2.lineTo(32.941296f, 37.737453f);
                instancePath2.lineTo(32.004818f, 36.124874f);
                instancePath2.cubicTo(30.130169f, 32.93352f, 28.134232f, 29.742908f, 26.10501f, 26.770954f);
                instancePath2.cubicTo(24.290594f, 24.113604f, 22.536194f, 21.761044f, 20.878828f, 19.797812f);
                instancePath2.cubicTo(18.294254f, 16.736258f, 16.036299f, 14.741029f, 14.337419f, 14.048108f);
                instancePath2.close();
                instancePath2.moveTo(60.498882f, 15.673505f);
                instancePath2.cubicTo(59.760517f, 13.809865f, 59.04714f, 13.483391f, 57.662582f, 14.048108f);
                instancePath2.cubicTo(55.963703f, 14.741029f, 53.705746f, 16.736258f, 51.121174f, 19.797812f);
                instancePath2.cubicTo(49.463806f, 21.761044f, 47.709408f, 24.113604f, 45.894993f, 26.770954f);
                instancePath2.cubicTo(44.271614f, 29.148518f, 42.669537f, 31.666023f, 41.133823f, 34.211895f);
                instancePath2.lineTo(39.51475f, 36.947468f);
                instancePath2.lineTo(38.028f, 39.552f);
                instancePath2.lineTo(38.537968f, 40.546883f);
                instancePath2.lineTo(39.230133f, 41.87059f);
                instancePath2.cubicTo(40.484726f, 44.23895f, 41.822144f, 46.60651f, 43.183147f, 48.81009f);
                instancePath2.cubicTo(44.44069f, 50.84615f, 45.65541f, 52.637764f, 46.798252f, 54.113888f);
                instancePath2.cubicTo(48.84645f, 56.75939f, 50.56728f, 58.2f, 51.35562f, 58.2f);
                instancePath2.cubicTo(52.507412f, 58.2f, 55.981155f, 50.335995f, 58.39563f, 40.487656f);
                instancePath2.lineTo(58.887104f, 38.403248f);
                instancePath2.cubicTo(61.157104f, 28.37737f, 61.884853f, 19.170872f, 60.498882f, 15.673505f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
