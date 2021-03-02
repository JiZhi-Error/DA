package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fts_more_button_icon extends c {
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
                instancePaint3.setColor(-11048043);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 4.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(12.309931f, 11.561403f);
                instancePath.lineTo(16.424265f, 15.675735f);
                instancePath.lineTo(15.575736f, 16.524263f);
                instancePath.lineTo(11.452851f, 12.401379f);
                instancePath.cubicTo(10.24281f, 13.400067f, 8.691467f, 14.0f, 7.0f, 14.0f);
                instancePath.cubicTo(3.134f, 14.0f, 0.0f, 10.866f, 0.0f, 7.0f);
                instancePath.cubicTo(0.0f, 3.134f, 3.134f, 0.0f, 7.0f, 0.0f);
                instancePath.cubicTo(10.866f, 0.0f, 14.0f, 3.134f, 14.0f, 7.0f);
                instancePath.cubicTo(14.0f, 8.742484f, 13.363332f, 10.336264f, 12.309931f, 11.561403f);
                instancePath.close();
                instancePath.moveTo(12.799997f, 7.0000124f);
                instancePath.cubicTo(12.799997f, 3.796755f, 10.203255f, 1.2000122f, 6.999997f, 1.2000122f);
                instancePath.cubicTo(3.7967398f, 1.2000122f, 1.199997f, 3.796755f, 1.199997f, 7.0000124f);
                instancePath.cubicTo(1.199997f, 10.20327f, 3.7967398f, 12.800013f, 6.999997f, 12.800013f);
                instancePath.cubicTo(10.203255f, 12.800013f, 12.799997f, 10.20327f, 12.799997f, 7.0000124f);
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
