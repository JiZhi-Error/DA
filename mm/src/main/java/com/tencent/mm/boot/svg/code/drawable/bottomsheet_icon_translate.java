package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_icon_translate extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-8617594);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 14.0f, 0.0f, 1.0f, 8.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(30.572737f, 32.89709f);
                instancePath.lineTo(32.149662f, 36.971424f);
                instancePath.lineTo(34.77378f, 36.971424f);
                instancePath.lineTo(28.691349f, 21.256136f);
                instancePath.lineTo(28.379143f, 21.256136f);
                instancePath.lineTo(25.755024f, 21.256136f);
                instancePath.lineTo(19.67259f, 36.971424f);
                instancePath.lineTo(22.29671f, 36.971424f);
                instancePath.lineTo(23.873636f, 32.89709f);
                instancePath.lineTo(30.572737f, 32.89709f);
                instancePath.close();
                instancePath.moveTo(29.671635f, 30.5689f);
                instancePath.lineTo(24.774738f, 30.5689f);
                instancePath.lineTo(27.223186f, 24.242798f);
                instancePath.lineTo(29.671635f, 30.5689f);
                instancePath.close();
                instancePath.moveTo(12.226544f, 8.0f);
                instancePath.lineTo(63.14051f, 8.0f);
                instancePath.cubicTo(65.4457f, 8.0f, 67.31442f, 9.868725f, 67.31442f, 12.173913f);
                instancePath.lineTo(67.31442f, 75.54891f);
                instancePath.cubicTo(67.31442f, 77.8541f, 65.4457f, 79.722824f, 63.14051f, 79.722824f);
                instancePath.lineTo(12.226544f, 79.722824f);
                instancePath.cubicTo(9.921356f, 79.722824f, 8.052631f, 77.8541f, 8.052631f, 75.54891f);
                instancePath.lineTo(8.052631f, 12.173913f);
                instancePath.cubicTo(8.052631f, 9.868725f, 9.921356f, 8.0f, 12.226544f, 8.0f);
                instancePath.close();
                instancePath.moveTo(18.827503f, 47.244564f);
                instancePath.lineTo(18.827503f, 51.304348f);
                instancePath.lineTo(56.53955f, 51.304348f);
                instancePath.lineTo(56.53955f, 47.244564f);
                instancePath.lineTo(18.827503f, 47.244564f);
                instancePath.close();
                instancePath.moveTo(18.827503f, 56.717392f);
                instancePath.lineTo(18.827503f, 60.777172f);
                instancePath.lineTo(56.53955f, 60.777172f);
                instancePath.lineTo(56.53955f, 56.717392f);
                instancePath.lineTo(18.827503f, 56.717392f);
                instancePath.close();
                instancePath.moveTo(18.827503f, 64.83696f);
                instancePath.lineTo(18.827503f, 68.896736f);
                instancePath.lineTo(56.53955f, 68.896736f);
                instancePath.lineTo(56.53955f, 64.83696f);
                instancePath.lineTo(18.827503f, 64.83696f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(60.582043f, 5.410628f);
                instancePath2.lineTo(7.4720273f, 5.410628f);
                instancePath2.cubicTo(6.3194327f, 5.410628f, 5.3850703f, 6.3449903f, 5.3850703f, 7.4975843f);
                instancePath2.lineTo(5.3850703f, 73.04348f);
                instancePath2.lineTo(4.173913f, 73.04348f);
                instancePath2.cubicTo(1.8687245f, 73.04348f, 1.1704826E-15f, 71.17475f, 8.881784E-16f, 68.86957f);
                instancePath2.lineTo(0.0f, 4.173913f);
                instancePath2.cubicTo(-2.8230417E-16f, 1.8687245f, 1.8687245f, 4.8643484E-15f, 4.173913f, 4.440892E-15f);
                instancePath2.lineTo(56.40813f, 0.0f);
                instancePath2.cubicTo(58.713318f, -4.5182935E-15f, 60.582043f, 1.8687245f, 60.582043f, 4.173913f);
                instancePath2.lineTo(60.582043f, 5.410628f);
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
