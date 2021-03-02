package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class refresh extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 6.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-372399);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(46.091885f, 13.908117f);
                instancePath.cubicTo(50.97792f, 18.794155f, 54.0f, 25.544155f, 54.0f, 33.0f);
                instancePath.cubicTo(54.0f, 47.91169f, 41.91169f, 60.0f, 27.0f, 60.0f);
                instancePath.cubicTo(12.088312f, 60.0f, 0.0f, 47.91169f, 0.0f, 33.0f);
                instancePath.cubicTo(0.0f, 18.088312f, 12.088312f, 6.0f, 27.0f, 6.0f);
                instancePath.lineTo(27.0f, 9.6f);
                instancePath.cubicTo(14.076537f, 9.6f, 3.6f, 20.076536f, 3.6f, 33.0f);
                instancePath.cubicTo(3.6f, 45.923462f, 14.076537f, 56.4f, 27.0f, 56.4f);
                instancePath.cubicTo(39.923462f, 56.4f, 50.4f, 45.923462f, 50.4f, 33.0f);
                instancePath.cubicTo(50.4f, 26.706247f, 47.908665f, 20.816067f, 43.5463f, 16.453701f);
                instancePath.lineTo(46.091885f, 13.908117f);
                instancePath.close();
                instancePath.moveTo(25.730843f, 9.633832f);
                instancePath.cubicTo(13.397545f, 10.293022f, 3.6f, 20.502342f, 3.6f, 33.0f);
                instancePath.cubicTo(3.6f, 45.923462f, 14.076537f, 56.4f, 27.0f, 56.4f);
                instancePath.cubicTo(39.923462f, 56.4f, 50.4f, 45.923462f, 50.4f, 33.0f);
                instancePath.cubicTo(50.4f, 26.706247f, 47.908665f, 20.816067f, 43.5463f, 16.453701f);
                instancePath.lineTo(46.091885f, 13.908117f);
                instancePath.cubicTo(50.97792f, 18.794155f, 54.0f, 25.544155f, 54.0f, 33.0f);
                instancePath.cubicTo(54.0f, 47.91169f, 41.91169f, 60.0f, 27.0f, 60.0f);
                instancePath.cubicTo(12.088312f, 60.0f, 0.0f, 47.91169f, 0.0f, 33.0f);
                instancePath.cubicTo(0.0f, 18.928625f, 10.764283f, 7.3713818f, 24.507618f, 6.1135054f);
                instancePath.lineTo(20.939697f, 2.5455844f);
                instancePath.lineTo(23.485281f, 3.0375702E-13f);
                instancePath.lineTo(30.909903f, 7.424621f);
                instancePath.cubicTo(31.49569f, 8.010407f, 31.49569f, 8.9601555f, 30.909903f, 9.545941f);
                instancePath.lineTo(29.424978f, 11.030866f);
                instancePath.lineTo(23.485281f, 16.970562f);
                instancePath.lineTo(20.939697f, 14.424978f);
                instancePath.lineTo(25.730843f, 9.633832f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
