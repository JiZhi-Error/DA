package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class checkbox_unselected extends c {
    private final int height = 60;
    private final int width = 60;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(60.0f, 0.0f);
                instancePath.lineTo(60.0f, 60.0f);
                instancePath.lineTo(0.0f, 60.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-5592406);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 6.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(0.0f, 6.0f);
                instancePath2.cubicTo(0.0f, 2.6891508f, 2.6835413f, 0.0f, 6.0f, 0.0f);
                instancePath2.lineTo(42.0f, 0.0f);
                instancePath2.cubicTo(45.31085f, 0.0f, 48.0f, 2.6835413f, 48.0f, 6.0f);
                instancePath2.lineTo(48.0f, 42.0f);
                instancePath2.cubicTo(48.0f, 45.31085f, 45.31646f, 48.0f, 42.0f, 48.0f);
                instancePath2.lineTo(6.0f, 48.0f);
                instancePath2.cubicTo(2.6891508f, 48.0f, 0.0f, 45.31646f, 0.0f, 42.0f);
                instancePath2.lineTo(0.0f, 6.0f);
                instancePath2.lineTo(0.0f, 6.0f);
                instancePath2.close();
                instancePath2.moveTo(3.0f, 5.0f);
                instancePath2.cubicTo(3.0f, 3.9389288f, 3.936117f, 3.0f, 5.0f, 3.0f);
                instancePath2.lineTo(43.0f, 3.0f);
                instancePath2.cubicTo(44.06107f, 3.0f, 45.0f, 3.936117f, 45.0f, 5.0f);
                instancePath2.lineTo(45.0f, 43.0f);
                instancePath2.cubicTo(45.0f, 44.06107f, 44.063885f, 45.0f, 43.0f, 45.0f);
                instancePath2.lineTo(5.0f, 45.0f);
                instancePath2.cubicTo(3.9389288f, 45.0f, 3.0f, 44.063885f, 3.0f, 43.0f);
                instancePath2.lineTo(3.0f, 5.0f);
                instancePath2.lineTo(3.0f, 5.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
