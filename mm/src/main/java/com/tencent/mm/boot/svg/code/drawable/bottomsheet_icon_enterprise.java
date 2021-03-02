package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_icon_enterprise extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 7.0f, 0.0f, 1.0f, 13.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-8617851);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(40.5001f, 1.0E-4f);
                instancePath.cubicTo(16.1941f, 1.0E-4f, 1.0E-4f, 14.5371f, 1.0E-4f, 32.4701f);
                instancePath.cubicTo(1.0E-4f, 42.0741f, 4.6671f, 50.7011f, 12.7231f, 56.6461f);
                instancePath.lineTo(8.1001f, 69.0001f);
                instancePath.lineTo(23.6971f, 62.3011f);
                instancePath.cubicTo(28.6931f, 63.9971f, 34.3371f, 64.9411f, 40.5001f, 64.9411f);
                instancePath.cubicTo(64.7401f, 64.9411f, 81.0001f, 50.4031f, 81.0001f, 32.4701f);
                instancePath.cubicTo(81.0001f, 14.5371f, 64.8061f, 1.0E-4f, 40.5001f, 1.0E-4f);
                instancePath.close();
                instancePath.moveTo(70.6401f, 39.7451f);
                instancePath.lineTo(68.6931f, 45.4211f);
                instancePath.cubicTo(66.3191f, 44.6061f, 61.0241f, 42.3231f, 56.2901f, 37.0491f);
                instancePath.cubicTo(49.8301f, 45.3031f, 42.3131f, 46.0001f, 40.0001f, 46.0001f);
                instancePath.cubicTo(37.6871f, 46.0001f, 30.1701f, 45.3031f, 23.7101f, 37.0491f);
                instancePath.cubicTo(18.9761f, 42.3231f, 13.6811f, 44.6061f, 11.3071f, 45.4211f);
                instancePath.lineTo(9.3601f, 39.7451f);
                instancePath.cubicTo(11.3931f, 39.0471f, 16.1241f, 36.9871f, 20.1311f, 32.0001f);
                instancePath.cubicTo(16.1241f, 27.0121f, 11.3931f, 24.9531f, 9.3601f, 24.2551f);
                instancePath.lineTo(11.3071f, 18.5791f);
                instancePath.cubicTo(13.6811f, 19.3941f, 18.9761f, 21.6771f, 23.7101f, 26.9511f);
                instancePath.cubicTo(30.1701f, 18.6971f, 37.6871f, 18.0001f, 40.0001f, 18.0001f);
                instancePath.cubicTo(42.3131f, 18.0001f, 49.8301f, 18.6971f, 56.2901f, 26.9511f);
                instancePath.cubicTo(61.0241f, 21.6771f, 66.3191f, 19.3941f, 68.6931f, 18.5791f);
                instancePath.lineTo(70.6401f, 24.2551f);
                instancePath.cubicTo(68.6071f, 24.9531f, 63.8751f, 27.0121f, 59.8681f, 32.0001f);
                instancePath.cubicTo(63.8751f, 36.9871f, 68.6071f, 39.0471f, 70.6401f, 39.7451f);
                instancePath.close();
                instancePath.moveTo(40.0f, 24.0f);
                instancePath.cubicTo(38.298f, 24.0f, 32.505f, 24.612f, 27.463f, 32.0f);
                instancePath.cubicTo(32.505f, 39.388f, 38.298f, 40.0f, 40.0f, 40.0f);
                instancePath.cubicTo(41.702f, 40.0f, 47.495f, 39.388f, 52.537f, 32.0f);
                instancePath.cubicTo(47.495f, 24.612f, 41.702f, 24.0f, 40.0f, 24.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
