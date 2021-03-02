package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icon_filled_brand_followed extends c {
    private final int height = 20;
    private final int width = 20;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 20;
            case 1:
                return 20;
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
                instancePaint3.setColor(-436207616);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -372.0f, 0.0f, 1.0f, -124.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 366.0f, 0.0f, 1.0f, 118.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 6.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(13.917866f, 16.004614f);
                instancePath.lineTo(18.110302f, 11.812178f);
                instancePath.lineTo(18.979172f, 12.681047f);
                instancePath.lineTo(14.352551f, 17.30634f);
                instancePath.cubicTo(14.118257f, 17.540672f, 13.738358f, 17.540619f, 13.504077f, 17.30627f);
                instancePath.cubicTo(13.504059f, 17.306252f, 13.504042f, 17.306234f, 13.504077f, 17.306164f);
                instancePath.lineTo(11.227897f, 15.028761f);
                instancePath.lineTo(11.227897f, 15.028761f);
                instancePath.lineTo(12.084954f, 14.171703f);
                instancePath.lineTo(13.917866f, 16.004614f);
                instancePath.close();
                instancePath.moveTo(9.916667f, 2.5f);
                instancePath.cubicTo(11.757616f, 2.5f, 13.25f, 3.9941502f, 13.25f, 5.833506f);
                instancePath.lineTo(13.25f, 7.258488f);
                instancePath.cubicTo(13.25f, 8.2077465f, 12.750777f, 9.56905f, 12.140073f, 10.292977f);
                instancePath.lineTo(11.838796f, 10.65011f);
                instancePath.cubicTo(11.62527f, 10.903223f, 11.533543f, 11.186345f, 11.554481f, 11.453089f);
                instancePath.lineTo(10.252683f, 11.452295f);
                instancePath.cubicTo(10.235727f, 10.940444f, 10.392664f, 10.412518f, 10.739343f, 9.945456f);
                instancePath.lineTo(10.845142f, 9.811866f);
                instancePath.lineTo(11.14642f, 9.454733f);
                instancePath.cubicTo(11.525756f, 9.005069f, 11.884873f, 8.072933f, 11.942092f, 7.4269834f);
                instancePath.lineTo(11.95f, 7.258488f);
                instancePath.lineTo(11.95f, 5.833506f);
                instancePath.cubicTo(11.95f, 4.71142f, 11.038946f, 3.8f, 9.916667f, 3.8f);
                instancePath.cubicTo(8.846828f, 3.8f, 7.9667225f, 4.6307445f, 7.8889236f, 5.6814523f);
                instancePath.lineTo(7.883333f, 5.8329835f);
                instancePath.lineTo(7.883333f, 7.257742f);
                instancePath.cubicTo(7.883333f, 7.846972f, 8.209404f, 8.787188f, 8.583769f, 9.3190975f);
                instancePath.lineTo(8.686857f, 9.45347f);
                instancePath.lineTo(8.988133f, 9.810554f);
                instancePath.cubicTo(9.990453f, 10.998537f, 9.68577f, 12.647564f, 8.366272f, 13.396492f);
                instancePath.lineTo(8.2155f, 13.475933f);
                instancePath.lineTo(3.498539f, 15.777759f);
                instancePath.cubicTo(3.4432356f, 15.804746f, 3.3422303f, 15.956275f, 3.310098f, 16.049063f);
                instancePath.lineTo(3.3f, 16.09622f);
                instancePath.lineTo(3.3f, 16.2f);
                instancePath.lineTo(9.916f, 16.2f);
                instancePath.lineTo(9.916f, 17.5f);
                instancePath.lineTo(2.8345246f, 17.5f);
                instancePath.cubicTo(2.3736293f, 17.5f, 2.0f, 17.129797f, 2.0f, 16.667969f);
                instancePath.lineTo(2.0f, 16.09622f);
                instancePath.cubicTo(2.0f, 15.525312f, 2.4151258f, 14.859923f, 2.9284146f, 14.609444f);
                instancePath.lineTo(7.6453757f, 12.307619f);
                instancePath.cubicTo(8.329481f, 11.9737835f, 8.488549f, 11.2343855f, 7.994538f, 10.648866f);
                instancePath.lineTo(7.6932607f, 10.291781f);
                instancePath.cubicTo(7.0802646f, 9.565238f, 6.5833335f, 8.207913f, 6.5833335f, 7.257742f);
                instancePath.lineTo(6.5833335f, 5.8329835f);
                instancePath.cubicTo(6.5833335f, 3.9922276f, 8.079463f, 2.5f, 9.916667f, 2.5f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
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
