package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class crop_video_selected extends c {
    private final int height = 63;
    private final int width = 63;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 63;
            case 1:
                return 63;
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
                instancePaint3.setColor(-14624737);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 12.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(51.0f, 0.0f);
                instancePath.lineTo(51.0f, 3.0f);
                instancePath.lineTo(0.0f, 3.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(0.0f, 0.0f);
                instancePath2.lineTo(9.0f, 0.0f);
                instancePath2.lineTo(9.0f, 41.0f);
                instancePath2.lineTo(0.0f, 41.0f);
                instancePath2.lineTo(0.0f, 0.0f);
                instancePath2.close();
                instancePath2.moveTo(3.0f, 18.0f);
                instancePath2.lineTo(3.0f, 24.074074f);
                instancePath2.lineTo(6.0f, 24.074074f);
                instancePath2.lineTo(6.0f, 18.0f);
                instancePath2.lineTo(3.0f, 18.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(42.0f, 0.0f);
                instancePath3.lineTo(51.0f, 0.0f);
                instancePath3.lineTo(51.0f, 41.0f);
                instancePath3.lineTo(42.0f, 41.0f);
                instancePath3.lineTo(42.0f, 0.0f);
                instancePath3.close();
                instancePath3.moveTo(45.0f, 18.0f);
                instancePath3.lineTo(45.0f, 24.074074f);
                instancePath3.lineTo(48.0f, 24.074074f);
                instancePath3.lineTo(48.0f, 18.0f);
                instancePath3.lineTo(45.0f, 18.0f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint3, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(0.0f, 38.0f);
                instancePath4.lineTo(51.0f, 38.0f);
                instancePath4.lineTo(51.0f, 41.0f);
                instancePath4.lineTo(0.0f, 41.0f);
                instancePath4.lineTo(0.0f, 38.0f);
                instancePath4.close();
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
