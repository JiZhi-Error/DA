package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_actionbar_capsule_home_dark extends c {
    private final int height = 96;
    private final int width = 132;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 132;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -368.0f, 0.0f, 1.0f, -950.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 239.0f, 0.0f, 1.0f, 950.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 170.0f, 0.0f, 1.0f, 22.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(26.0f, 52.0f);
                instancePath.cubicTo(11.640596f, 52.0f, 0.0f, 40.3594f, 0.0f, 26.0f);
                instancePath.cubicTo(0.0f, 11.640596f, 11.640596f, 0.0f, 26.0f, 0.0f);
                instancePath.cubicTo(40.3594f, 0.0f, 52.0f, 11.640596f, 52.0f, 26.0f);
                instancePath.cubicTo(52.0f, 40.3594f, 40.3594f, 52.0f, 26.0f, 52.0f);
                instancePath.close();
                instancePath.moveTo(26.0f, 45.882355f);
                instancePath.cubicTo(36.98072f, 45.882355f, 45.882355f, 36.98072f, 45.882355f, 26.0f);
                instancePath.cubicTo(45.882355f, 15.0192795f, 36.98072f, 6.117647f, 26.0f, 6.117647f);
                instancePath.cubicTo(15.0192795f, 6.117647f, 6.117647f, 15.0192795f, 6.117647f, 26.0f);
                instancePath.cubicTo(6.117647f, 36.98072f, 15.0192795f, 45.882355f, 26.0f, 45.882355f);
                instancePath.close();
                instancePath.moveTo(35.0f, 26.0f);
                instancePath.cubicTo(35.0f, 30.9698f, 30.9698f, 35.0f, 26.0f, 35.0f);
                instancePath.cubicTo(21.0302f, 35.0f, 17.0f, 30.9698f, 17.0f, 26.0f);
                instancePath.cubicTo(17.0f, 21.0284f, 21.0302f, 17.0f, 26.0f, 17.0f);
                instancePath.cubicTo(30.9698f, 17.0f, 35.0f, 21.0284f, 35.0f, 26.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
