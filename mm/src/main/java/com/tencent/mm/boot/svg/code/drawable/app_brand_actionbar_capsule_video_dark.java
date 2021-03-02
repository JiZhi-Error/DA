package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_actionbar_capsule_video_dark extends c {
    private final int height = 96;
    private final int width = 130;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 130;
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -238.0f, 0.0f, 1.0f, -408.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 238.0f, 0.0f, 1.0f, 408.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(85.0f, 62.0f);
                instancePath.lineTo(85.0f, 35.0f);
                instancePath.cubicTo(85.0f, 33.81324f, 84.190865f, 33.0f, 83.0f, 33.0f);
                instancePath.lineTo(49.0f, 33.0f);
                instancePath.cubicTo(47.811264f, 33.0f, 47.0f, 33.81639f, 47.0f, 35.0f);
                instancePath.lineTo(47.0f, 62.0f);
                instancePath.cubicTo(47.0f, 63.18676f, 47.809135f, 64.0f, 49.0f, 64.0f);
                instancePath.lineTo(83.0f, 64.0f);
                instancePath.cubicTo(84.188736f, 64.0f, 85.0f, 63.18361f, 85.0f, 62.0f);
                instancePath.close();
                instancePath.moveTo(89.0f, 43.0f);
                instancePath.cubicTo(93.40946f, 38.83027f, 99.615555f, 32.798397f, 100.0f, 32.0f);
                instancePath.cubicTo(101.65531f, 31.724306f, 103.0f, 32.390232f, 103.0f, 34.0f);
                instancePath.lineTo(103.0f, 63.0f);
                instancePath.cubicTo(103.0f, 64.42094f, 101.78401f, 65.34744f, 100.0f, 65.0f);
                instancePath.cubicTo(99.861565f, 64.30614f, 93.517f, 58.096f, 89.0f, 53.0f);
                instancePath.lineTo(89.0f, 43.0f);
                instancePath.lineTo(89.0f, 43.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
