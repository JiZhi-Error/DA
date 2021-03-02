package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_actionbar_option_light extends c {
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
                instancePaint3.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -507.0f, 0.0f, 1.0f, -423.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 6.123234E-17f, -1.0f, 967.0f, 1.0f, 6.123234E-17f, -103.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(535.0f, 404.0f);
                instancePath.cubicTo(537.7558f, 404.0f, 540.0f, 406.2386f, 540.0f, 409.0f);
                instancePath.cubicTo(540.0f, 411.7558f, 537.7614f, 414.0f, 535.0f, 414.0f);
                instancePath.cubicTo(532.2442f, 414.0f, 530.0f, 411.7614f, 530.0f, 409.0f);
                instancePath.cubicTo(530.0f, 406.2442f, 532.2386f, 404.0f, 535.0f, 404.0f);
                instancePath.close();
                instancePath.moveTo(535.0f, 423.0f);
                instancePath.cubicTo(539.9717f, 423.0f, 544.0f, 427.02945f, 544.0f, 432.0f);
                instancePath.cubicTo(544.0f, 436.97165f, 539.9706f, 441.0f, 535.0f, 441.0f);
                instancePath.cubicTo(530.0283f, 441.0f, 526.0f, 436.97055f, 526.0f, 432.0f);
                instancePath.cubicTo(526.0f, 427.02835f, 530.0294f, 423.0f, 535.0f, 423.0f);
                instancePath.close();
                instancePath.moveTo(535.0f, 450.0f);
                instancePath.cubicTo(537.7558f, 450.0f, 540.0f, 452.2386f, 540.0f, 455.0f);
                instancePath.cubicTo(540.0f, 457.7558f, 537.7614f, 460.0f, 535.0f, 460.0f);
                instancePath.cubicTo(532.2442f, 460.0f, 530.0f, 457.7614f, 530.0f, 455.0f);
                instancePath.cubicTo(530.0f, 452.2442f, 532.2386f, 450.0f, 535.0f, 450.0f);
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
