package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class c2c_rejected_icon extends c {
    private final int height = 102;
    private final int width = 102;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 102;
            case 1:
                return 102;
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(51.0f, 102.0f);
                instancePath.cubicTo(79.16652f, 102.0f, 102.0f, 79.16652f, 102.0f, 51.0f);
                instancePath.cubicTo(102.0f, 22.833477f, 79.16652f, 0.0f, 51.0f, 0.0f);
                instancePath.cubicTo(22.833477f, 0.0f, 0.0f, 22.833477f, 0.0f, 51.0f);
                instancePath.cubicTo(0.0f, 79.16652f, 22.833477f, 102.0f, 51.0f, 102.0f);
                instancePath.close();
                instancePath.moveTo(51.0f, 98.0f);
                instancePath.cubicTo(76.95738f, 98.0f, 98.0f, 76.95738f, 98.0f, 51.0f);
                instancePath.cubicTo(98.0f, 25.042616f, 76.95738f, 4.0f, 51.0f, 4.0f);
                instancePath.cubicTo(25.042616f, 4.0f, 4.0f, 25.042616f, 4.0f, 51.0f);
                instancePath.cubicTo(4.0f, 76.95738f, 25.042616f, 98.0f, 51.0f, 98.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 14.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 24.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(15.415947f, 1.2113346f);
                instancePath2.cubicTo(16.290796f, 0.54233295f, 17.0f, 0.8949788f, 17.0f, 1.9970046f);
                instancePath2.lineTo(17.0f, 24.002995f);
                instancePath2.cubicTo(17.0f, 25.105911f, 16.291174f, 25.457956f, 15.415947f, 24.788666f);
                instancePath2.lineTo(1.5840529f, 14.211334f);
                instancePath2.cubicTo(0.7092046f, 13.542333f, 0.70882535f, 12.457957f, 1.5840529f, 11.788666f);
                instancePath2.lineTo(15.415947f, 1.2113346f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(14.0f, 9.0f);
                instancePath3.lineTo(55.0f, 9.0f);
                instancePath3.lineTo(55.0f, 17.0f);
                instancePath3.lineTo(14.0f, 17.0f);
                instancePath3.lineTo(14.0f, 9.0f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
