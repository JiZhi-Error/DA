package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class tipsbar_icon_warning extends c {
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
                instancePaint3.setColor(0);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(96.0f, 0.0f);
                instancePath.lineTo(96.0f, 96.0f);
                instancePath.lineTo(0.0f, 96.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 21.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-499359);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(27.0f, 0.0f);
                instancePath2.cubicTo(41.91169f, 0.0f, 54.0f, 12.088311f, 54.0f, 27.0f);
                instancePath2.cubicTo(54.0f, 41.91169f, 41.91169f, 54.0f, 27.0f, 54.0f);
                instancePath2.cubicTo(12.088311f, 54.0f, 0.0f, 41.91169f, 0.0f, 27.0f);
                instancePath2.cubicTo(0.0f, 12.088311f, 12.088311f, 0.0f, 27.0f, 0.0f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-1);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 13.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint5, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(3.0f, 24.0f);
                instancePath3.cubicTo(4.6568546f, 24.0f, 6.0f, 25.343145f, 6.0f, 27.0f);
                instancePath3.cubicTo(6.0f, 28.656855f, 4.6568546f, 30.0f, 3.0f, 30.0f);
                instancePath3.cubicTo(1.3431456f, 30.0f, 0.0f, 28.656855f, 0.0f, 27.0f);
                instancePath3.cubicTo(0.0f, 25.343145f, 1.3431456f, 24.0f, 3.0f, 24.0f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint5, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(0.49475262f, 0.0f);
                instancePath4.lineTo(5.4947524f, 0.0f);
                instancePath4.lineTo(4.7095985f, 20.212122f);
                instancePath4.lineTo(1.3290199f, 20.212122f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath4, 1);
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
