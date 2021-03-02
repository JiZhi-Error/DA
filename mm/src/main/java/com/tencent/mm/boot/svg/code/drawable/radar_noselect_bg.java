package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class radar_noselect_bg extends c {
    private final int height = 210;
    private final int width = 210;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 210;
            case 1:
                return 210;
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
                instancePaint3.setColor(-15724528);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 6.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.saveLayerAlpha(null, 153, 31);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(86.26f, 1.24f);
                instancePath.cubicTo(108.45f, -1.53f, 131.55f, 3.55f, 150.45f, 15.53f);
                instancePath.cubicTo(169.74f, 27.58f, 184.6f, 46.55f, 191.61f, 68.2f);
                instancePath.cubicTo(198.68f, 89.68f, 198.0f, 113.61f, 189.69f, 134.65f);
                instancePath.cubicTo(181.53f, 155.58f, 165.93f, 173.48f, 146.33f, 184.43f);
                instancePath.cubicTo(126.15f, 195.89f, 101.83f, 199.69f, 79.1f, 195.13f);
                instancePath.cubicTo(56.88f, 190.83f, 36.38f, 178.43f, 22.13f, 160.87f);
                instancePath.cubicTo(8.8f, 144.64f, 0.92f, 124.01f, 0.11f, 103.02f);
                instancePath.cubicTo(-1.0f, 79.99f, 6.41f, 56.69f, 20.62f, 38.53f);
                instancePath.cubicTo(36.39f, 18.04f, 60.56f, 4.25f, 86.26f, 1.24f);
                instancePath.lineTo(86.26f, 1.24f);
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
