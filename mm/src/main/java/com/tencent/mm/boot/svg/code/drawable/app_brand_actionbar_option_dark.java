package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_actionbar_option_dark extends c {
    private final int height = 18;
    private final int width = 56;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 56;
            case 1:
                return 18;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -586.0f, 0.0f, 1.0f, -423.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 6.123234E-17f, -1.0f, 1046.0f, 1.0f, 6.123234E-17f, -182.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(614.0f, 404.0f);
                instancePath.cubicTo(616.7558f, 404.0f, 619.0f, 406.2386f, 619.0f, 409.0f);
                instancePath.cubicTo(619.0f, 411.7558f, 616.7614f, 414.0f, 614.0f, 414.0f);
                instancePath.cubicTo(611.2442f, 414.0f, 609.0f, 411.7614f, 609.0f, 409.0f);
                instancePath.cubicTo(609.0f, 406.2442f, 611.2386f, 404.0f, 614.0f, 404.0f);
                instancePath.close();
                instancePath.moveTo(614.0f, 423.0f);
                instancePath.cubicTo(618.9717f, 423.0f, 623.0f, 427.02945f, 623.0f, 432.0f);
                instancePath.cubicTo(623.0f, 436.97165f, 618.9706f, 441.0f, 614.0f, 441.0f);
                instancePath.cubicTo(609.0283f, 441.0f, 605.0f, 436.97055f, 605.0f, 432.0f);
                instancePath.cubicTo(605.0f, 427.02835f, 609.0294f, 423.0f, 614.0f, 423.0f);
                instancePath.close();
                instancePath.moveTo(614.0f, 450.0f);
                instancePath.cubicTo(616.7558f, 450.0f, 619.0f, 452.2386f, 619.0f, 455.0f);
                instancePath.cubicTo(619.0f, 457.7558f, 616.7614f, 460.0f, 614.0f, 460.0f);
                instancePath.cubicTo(611.2442f, 460.0f, 609.0f, 457.7614f, 609.0f, 455.0f);
                instancePath.cubicTo(609.0f, 452.2442f, 611.2386f, 450.0f, 614.0f, 450.0f);
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
