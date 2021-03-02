package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class video_no_sd_icon extends c {
    private final int height = 255;
    private final int width = 255;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 255;
            case 1:
                return 255;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 74.0f, 0.0f, 1.0f, 65.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(98.000374f, 0.0f);
                instancePath.lineTo(21.999622f, 0.0f);
                instancePath.lineTo(24.0f, 0.0f);
                instancePath.lineTo(12.0f, 12.0f);
                instancePath.lineTo(12.0f, 10.000714f);
                instancePath.lineTo(12.0f, 126.0f);
                instancePath.lineTo(108.0f, 126.0f);
                instancePath.lineTo(108.0f, 10.000714f);
                instancePath.lineTo(108.0f, 12.0f);
                instancePath.lineTo(96.0f, 0.0f);
                instancePath.lineTo(98.000374f, 0.0f);
                instancePath.close();
                instancePath.moveTo(108.0f, 114.0f);
                instancePath.lineTo(96.0f, 126.0f);
                instancePath.lineTo(108.0f, 126.0f);
                instancePath.lineTo(108.0f, 114.0f);
                instancePath.close();
                instancePath.moveTo(0.0f, 48.0f);
                instancePath.lineTo(12.0f, 48.0f);
                instancePath.lineTo(12.0f, 126.0f);
                instancePath.lineTo(0.0f, 126.0f);
                instancePath.lineTo(0.0f, 48.0f);
                instancePath.close();
                instancePath.moveTo(0.0f, 114.0f);
                instancePath.lineTo(12.0f, 126.0f);
                instancePath.lineTo(0.0f, 126.0f);
                instancePath.lineTo(0.0f, 114.0f);
                instancePath.close();
                instancePath.moveTo(0.0f, 60.0f);
                instancePath.lineTo(12.0f, 48.0f);
                instancePath.lineTo(0.0f, 48.0f);
                instancePath.lineTo(0.0f, 60.0f);
                instancePath.close();
                instancePath.moveTo(36.0f, 12.0f);
                instancePath.lineTo(48.0f, 12.0f);
                instancePath.lineTo(48.0f, 42.0f);
                instancePath.lineTo(36.0f, 42.0f);
                instancePath.lineTo(36.0f, 12.0f);
                instancePath.close();
                instancePath.moveTo(54.0f, 12.0f);
                instancePath.lineTo(66.0f, 12.0f);
                instancePath.lineTo(66.0f, 42.0f);
                instancePath.lineTo(54.0f, 42.0f);
                instancePath.lineTo(54.0f, 12.0f);
                instancePath.close();
                instancePath.moveTo(72.0f, 12.0f);
                instancePath.lineTo(84.0f, 12.0f);
                instancePath.lineTo(84.0f, 42.0f);
                instancePath.lineTo(72.0f, 42.0f);
                instancePath.lineTo(72.0f, 12.0f);
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
