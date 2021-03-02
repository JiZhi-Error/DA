package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_icon_reading extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.restore();
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-8683387);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 18.0f, 0.0f, 1.0f, 8.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(16.3293f, 71.9602f);
                instancePath.cubicTo(13.4363f, 68.3632f, 11.7613f, 63.5762f, 11.7333f, 58.8262f);
                instancePath.cubicTo(11.7123f, 55.3172f, 9.3753f, 52.2362f, 6.6693f, 48.6682f);
                instancePath.cubicTo(6.0453f, 47.8462f, 5.4243f, 47.0262f, 4.8313f, 46.2012f);
                instancePath.cubicTo(1.7113f, 41.8592f, 0.0413f, 36.3052f, 3.0E-4f, 30.1402f);
                instancePath.cubicTo(-0.0897f, 16.2672f, 9.4763f, 3.9412f, 22.7473f, 0.8312f);
                instancePath.cubicTo(31.8983f, -1.3138f, 41.2843f, 0.7372f, 48.4973f, 6.4552f);
                instancePath.cubicTo(55.7073f, 12.1712f, 59.8433f, 20.7212f, 59.8433f, 29.9132f);
                instancePath.cubicTo(59.8433f, 35.8332f, 58.1123f, 41.5582f, 54.8373f, 46.4712f);
                instancePath.lineTo(47.3483f, 41.4782f);
                instancePath.cubicTo(49.6353f, 38.0492f, 50.8433f, 34.0502f, 50.8433f, 29.9132f);
                instancePath.cubicTo(50.8433f, 23.4862f, 47.9503f, 17.5062f, 42.9063f, 13.5082f);
                instancePath.cubicTo(37.8603f, 9.5082f, 31.2613f, 8.0822f, 24.8013f, 9.5942f);
                instancePath.cubicTo(15.5823f, 11.7542f, 8.9373f, 20.3702f, 9.0003f, 30.0812f);
                instancePath.cubicTo(9.0293f, 34.3712f, 10.1153f, 38.1302f, 12.1403f, 40.9502f);
                instancePath.cubicTo(12.6883f, 41.7122f, 13.2633f, 42.4692f, 13.8393f, 43.2292f);
                instancePath.cubicTo(17.0523f, 47.4652f, 20.6943f, 52.2662f, 20.7333f, 58.7732f);
                instancePath.cubicTo(20.7353f, 59.2312f, 20.9243f, 69.9922f, 31.7853f, 69.9922f);
                instancePath.cubicTo(38.5203f, 69.9922f, 40.5293f, 65.0932f, 41.1263f, 62.1732f);
                instancePath.cubicTo(42.2533f, 56.6692f, 38.7963f, 52.3462f, 31.1283f, 49.6692f);
                instancePath.cubicTo(21.6763f, 46.0542f, 16.3273f, 38.8702f, 16.3273f, 29.9132f);
                instancePath.cubicTo(16.3273f, 21.8642f, 22.0113f, 16.2422f, 30.1513f, 16.2422f);
                instancePath.cubicTo(37.4623f, 16.2422f, 43.4103f, 22.3752f, 43.4103f, 29.9132f);
                instancePath.cubicTo(43.4103f, 34.2002f, 41.3043f, 36.9812f, 40.5103f, 38.0272f);
                instancePath.lineTo(32.939453f, 33.42163f);
                instancePath.cubicTo(34.1613f, 32.040527f, 34.4103f, 31.1762f, 34.4103f, 29.9132f);
                instancePath.cubicTo(34.4103f, 27.6672f, 33.214844f, 25.261963f, 30.0f, 25.261963f);
                instancePath.cubicTo(26.785156f, 25.261963f, 25.3273f, 27.509521f, 25.3273f, 29.9132f);
                instancePath.cubicTo(25.3273f, 36.4132f, 30.1173f, 39.6352f, 34.1613f, 41.1962f);
                instancePath.cubicTo(51.8603f, 47.4082f, 50.7173f, 60.2012f, 49.9443f, 63.9782f);
                instancePath.cubicTo(48.0473f, 73.2392f, 41.0893f, 78.9922f, 31.7853f, 78.9922f);
                instancePath.cubicTo(23.6863f, 78.9922f, 18.9103f, 75.1682f, 16.3293f, 71.9602f);
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
