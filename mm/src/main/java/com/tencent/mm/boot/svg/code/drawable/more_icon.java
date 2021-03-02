package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class more_icon extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-436207616);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 10.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(3.75f, 2.0f);
                instancePath.cubicTo(3.75f, 2.96635f, 2.96635f, 3.75f, 2.0f, 3.75f);
                instancePath.cubicTo(1.03365f, 3.75f, 0.25f, 2.96635f, 0.25f, 2.0f);
                instancePath.cubicTo(0.25f, 1.0333f, 1.03365f, 0.25f, 2.0f, 0.25f);
                instancePath.cubicTo(2.96635f, 0.25f, 3.75f, 1.0333f, 3.75f, 2.0f);
                instancePath.close();
                instancePath.moveTo(9.0f, 0.25f);
                instancePath.cubicTo(9.96635f, 0.25f, 10.75f, 1.0333f, 10.75f, 2.0f);
                instancePath.cubicTo(10.75f, 2.96635f, 9.96635f, 3.75f, 9.0f, 3.75f);
                instancePath.cubicTo(8.03365f, 3.75f, 7.25f, 2.96635f, 7.25f, 2.0f);
                instancePath.cubicTo(7.25f, 1.0333f, 8.03365f, 0.25f, 9.0f, 0.25f);
                instancePath.close();
                instancePath.moveTo(16.0f, 0.25f);
                instancePath.cubicTo(16.96635f, 0.25f, 17.75f, 1.0333f, 17.75f, 2.0f);
                instancePath.cubicTo(17.75f, 2.96635f, 16.96635f, 3.75f, 16.0f, 3.75f);
                instancePath.cubicTo(15.03365f, 3.75f, 14.25f, 2.96635f, 14.25f, 2.0f);
                instancePath.cubicTo(14.25f, 1.0333f, 15.03365f, 0.25f, 16.0f, 0.25f);
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
