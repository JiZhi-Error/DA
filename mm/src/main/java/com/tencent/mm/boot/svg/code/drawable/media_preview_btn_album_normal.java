package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class media_preview_btn_album_normal extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(Integer.MIN_VALUE);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 9.6f);
                instancePath.cubicTo(0.0f, 4.298066f, 4.298066f, 0.0f, 9.6f, 0.0f);
                instancePath.lineTo(86.4f, 0.0f);
                instancePath.cubicTo(91.701935f, 0.0f, 96.0f, 4.298066f, 96.0f, 9.6f);
                instancePath.lineTo(96.0f, 86.4f);
                instancePath.cubicTo(96.0f, 91.701935f, 91.701935f, 96.0f, 86.4f, 96.0f);
                instancePath.lineTo(9.6f, 96.0f);
                instancePath.cubicTo(4.298066f, 96.0f, 0.0f, 91.701935f, 0.0f, 86.4f);
                instancePath.lineTo(0.0f, 9.6f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 20.571428f, 0.0f, 1.0f, 25.714287f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-1);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 33.428574f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(43.885715f, 0.0f);
                instancePath2.lineTo(52.114285f, 0.0f);
                instancePath2.cubicTo(53.629124f, -2.4742114E-15f, 54.857143f, 1.2472068f, 54.857143f, 2.7857144f);
                instancePath2.lineTo(54.857143f, 30.642857f);
                instancePath2.cubicTo(54.857143f, 32.181366f, 53.629124f, 33.42857f, 52.114285f, 33.42857f);
                instancePath2.lineTo(13.714286f, 33.42857f);
                instancePath2.cubicTo(12.199448f, 33.42857f, 10.971429f, 32.181366f, 10.971429f, 30.642857f);
                instancePath2.lineTo(10.971429f, 22.285715f);
                instancePath2.lineTo(14.262857f, 22.285715f);
                instancePath2.lineTo(14.262857f, 30.085714f);
                instancePath2.lineTo(51.565716f, 30.085714f);
                instancePath2.lineTo(51.565716f, 3.3428571f);
                instancePath2.lineTo(43.885715f, 3.3428571f);
                instancePath2.lineTo(43.885715f, 0.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                instancePaint6.setColor(-1);
                instancePaint6.setStrokeWidth(2.88f);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(1.44f, 14.982857f);
                instancePath3.cubicTo(1.44f, 13.657373f, 2.5145166f, 12.582857f, 3.8400002f, 12.582857f);
                instancePath3.lineTo(40.04571f, 12.582857f);
                instancePath3.cubicTo(41.371197f, 12.582857f, 42.445713f, 13.657373f, 42.445713f, 14.982857f);
                instancePath3.lineTo(42.445713f, 40.731426f);
                instancePath3.cubicTo(42.445713f, 42.05691f, 41.371197f, 43.131428f, 40.04571f, 43.131428f);
                instancePath3.lineTo(3.8400002f, 43.131428f);
                instancePath3.cubicTo(2.5145166f, 43.131428f, 1.44f, 42.05691f, 1.44f, 40.731426f);
                instancePath3.lineTo(1.44f, 14.982857f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
