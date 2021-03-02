package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class star_mark extends c {
    private final int height = 60;
    private final int width = 60;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                instancePaint3.setColor(-16384);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(26.87f, 0.42f);
                instancePath.cubicTo(28.24f, 1.13f, 33.563488f, 13.02894f, 35.87f, 18.42f);
                instancePath.cubicTo(41.73349f, 18.56894f, 48.16f, 18.15f, 53.87f, 19.42f);
                instancePath.cubicTo(50.37f, 25.09f, 45.03f, 29.01f, 40.87f, 33.42f);
                instancePath.cubicTo(42.32f, 40.56f, 44.71f, 47.31f, 45.87f, 54.42f);
                instancePath.cubicTo(43.24f, 54.42f, 31.38f, 45.55f, 27.87f, 42.42f);
                instancePath.cubicTo(23.65f, 45.43f, 12.0f, 54.43f, 8.87f, 54.42f);
                instancePath.cubicTo(10.3f, 47.31f, 12.76f, 40.59f, 14.87f, 33.42f);
                instancePath.cubicTo(9.97f, 29.01f, 4.64f, 25.09f, 0.87f, 19.42f);
                instancePath.cubicTo(6.83f, 18.15f, 13.348559f, 18.55894f, 18.87f, 18.42f);
                instancePath.cubicTo(22.098558f, 12.01894f, 23.88f, 6.36f, 26.87f, 0.42f);
                instancePath.lineTo(26.87f, 0.42f);
                instancePath.lineTo(26.87f, 0.42f);
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
