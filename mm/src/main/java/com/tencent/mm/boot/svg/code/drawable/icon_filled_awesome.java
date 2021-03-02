package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icon_filled_awesome extends c {
    private final int height = 24;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 2.757333f, 0.0f, 1.0f, 5.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(1.4645188f, 1.4644661f);
                instancePath.cubicTo(3.4171402f, -0.48815536f, 6.5829654f, -0.48815536f, 8.535586f, 1.4644661f);
                instancePath.cubicTo(8.718393f, 1.6472728f, 8.954096f, 1.8746326f, 9.242693f, 2.1465456f);
                instancePath.cubicTo(9.531291f, 1.8746326f, 9.7669935f, 1.6472728f, 9.9498005f, 1.4644661f);
                instancePath.cubicTo(11.902422f, -0.48815536f, 15.068247f, -0.48815536f, 17.020868f, 1.4644661f);
                instancePath.cubicTo(18.955326f, 3.3989244f, 18.97332f, 6.5241203f, 17.07485f, 8.480731f);
                instancePath.lineTo(9.949763f, 15.6065645f);
                instancePath.cubicTo(9.559297f, 15.997147f, 8.926131f, 15.99718f, 8.535586f, 15.606676f);
                instancePath.cubicTo(8.535574f, 15.606664f, 8.535562f, 15.606651f, 8.535586f, 15.606602f);
                instancePath.lineTo(1.410126f, 8.481141f);
                instancePath.cubicTo(-0.4879337f, 6.5241203f, -0.4699394f, 3.3989244f, 1.4645188f, 1.4644661f);
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
