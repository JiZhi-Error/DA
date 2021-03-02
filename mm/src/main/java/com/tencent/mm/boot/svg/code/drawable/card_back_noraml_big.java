package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class card_back_noraml_big extends c {
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
                instancePaint3.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 15.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.saveLayerAlpha(null, 128, 31);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.98f, 33.0f);
                instancePath.cubicTo(11.64f, 22.32f, 22.32f, 11.64f, 33.0f, 0.98f);
                instancePath.cubicTo(34.9f, 2.86f, 36.8f, 4.76f, 38.68f, 6.66f);
                instancePath.cubicTo(31.25f, 14.11f, 23.8f, 21.54f, 16.37f, 28.99f);
                instancePath.cubicTo(32.58f, 29.01f, 48.79f, 28.99f, 65.0f, 29.0f);
                instancePath.cubicTo(65.0f, 31.69f, 65.0f, 34.37f, 64.99f, 37.06f);
                instancePath.cubicTo(48.81f, 37.08f, 32.62f, 37.05f, 16.43f, 37.07f);
                instancePath.cubicTo(23.84f, 44.5f, 31.27f, 51.91f, 38.68f, 59.34f);
                instancePath.cubicTo(36.8f, 61.24f, 34.9f, 63.14f, 33.0f, 65.02f);
                instancePath.cubicTo(22.32f, 54.36f, 11.64f, 43.68f, 0.98f, 33.0f);
                instancePath.lineTo(0.98f, 33.0f);
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
