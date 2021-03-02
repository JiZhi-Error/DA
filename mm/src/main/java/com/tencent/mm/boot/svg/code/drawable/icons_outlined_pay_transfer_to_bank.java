package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_pay_transfer_to_bank extends c {
    private final int height = 72;
    private final int width = 72;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 12.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(58.5f, 34.5f);
                instancePath.cubicTo(59.328426f, 34.5f, 60.0f, 35.171574f, 60.0f, 36.0f);
                instancePath.cubicTo(60.0f, 36.43211f, 59.813652f, 36.84323f, 59.488693f, 37.128044f);
                instancePath.lineTo(44.69047f, 50.098175f);
                instancePath.cubicTo(44.19207f, 50.535007f, 43.433914f, 50.485096f, 42.99708f, 49.986694f);
                instancePath.cubicTo(42.63626f, 49.57502f, 42.59978f, 48.971336f, 42.9084f, 48.51921f);
                instancePath.lineTo(50.31f, 38.1f);
                instancePath.lineTo(23.996721f, 38.1f);
                instancePath.lineTo(23.996721f, 34.5f);
                instancePath.lineTo(58.5f, 34.5f);
                instancePath.close();
                instancePath.moveTo(57.02459f, 0.0f);
                instancePath.cubicTo(58.667866f, 0.0f, 60.0f, 1.3338926f, 60.0f, 3.002615f);
                instancePath.lineTo(60.0f, 18.0f);
                instancePath.lineTo(56.399f, 18.0f);
                instancePath.lineTo(56.4f, 3.6f);
                instancePath.lineTo(3.6f, 3.6f);
                instancePath.lineTo(3.6f, 44.4f);
                instancePath.lineTo(36.0f, 44.4f);
                instancePath.lineTo(36.0f, 48.0f);
                instancePath.lineTo(2.9754093f, 48.0f);
                instancePath.cubicTo(1.3321362f, 48.0f, 0.0f, 46.666107f, 0.0f, 44.997383f);
                instancePath.lineTo(0.0f, 3.002615f);
                instancePath.cubicTo(0.0f, 1.3443165f, 1.3659167f, 0.0f, 2.9754093f, 0.0f);
                instancePath.lineTo(57.02459f, 0.0f);
                instancePath.close();
                instancePath.moveTo(40.99964f, 13.013306f);
                instancePath.cubicTo(41.360462f, 13.42498f, 41.39694f, 14.028662f, 41.088318f, 14.48079f);
                instancePath.lineTo(33.69f, 24.9f);
                instancePath.lineTo(60.0f, 24.9f);
                instancePath.lineTo(60.0f, 28.5f);
                instancePath.lineTo(25.496721f, 28.5f);
                instancePath.cubicTo(24.668295f, 28.5f, 23.996721f, 27.828426f, 23.996721f, 27.0f);
                instancePath.cubicTo(23.996721f, 26.56789f, 24.18307f, 26.15677f, 24.50803f, 25.871954f);
                instancePath.lineTo(39.30625f, 12.901824f);
                instancePath.cubicTo(39.804653f, 12.464992f, 40.56281f, 12.514904f, 40.99964f, 13.013306f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
