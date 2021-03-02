package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_capsule_multitasking_wechat extends c {
    private final int height = 150;
    private final int width = 150;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 150;
            case 1:
                return 150;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -239.0f, 0.0f, 1.0f, -739.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 239.0f, 0.0f, 1.0f, 739.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-16139513);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(75.0f, 0.0f);
                instancePath.cubicTo(116.42136f, 0.0f, 150.0f, 33.57864f, 150.0f, 75.0f);
                instancePath.cubicTo(150.0f, 116.42136f, 116.42136f, 150.0f, 75.0f, 150.0f);
                instancePath.cubicTo(33.57864f, 150.0f, 0.0f, 116.42136f, 0.0f, 75.0f);
                instancePath.cubicTo(0.0f, 33.57864f, 33.57864f, 0.0f, 75.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(40.333332f, 110.27027f);
                instancePath2.cubicTo(37.63287f, 110.70741f, 36.316177f, 109.3305f, 37.133335f, 107.076164f);
                instancePath2.lineTo(41.4f, 94.29975f);
                instancePath2.cubicTo(37.380486f, 88.30855f, 35.0f, 83.169525f, 35.0f, 76.19984f);
                instancePath2.cubicTo(35.0f, 56.08848f, 52.9088f, 40.0f, 75.53333f, 40.0f);
                instancePath2.cubicTo(97.0912f, 40.0f, 115.0f, 56.08848f, 115.0f, 76.19984f);
                instancePath2.cubicTo(115.0f, 95.78047f, 97.0912f, 110.27027f, 75.53333f, 110.27027f);
                instancePath2.cubicTo(67.61395f, 110.27027f, 60.69544f, 108.47199f, 55.266666f, 104.94676f);
                instancePath2.lineTo(40.333332f, 110.27027f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
