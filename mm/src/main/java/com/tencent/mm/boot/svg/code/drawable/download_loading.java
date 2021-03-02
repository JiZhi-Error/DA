package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class download_loading extends c {
    private final int height = 24;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -300.0f, 0.0f, 1.0f, -145.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 80.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 40.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray4 = c.setMatrixFloatArray(matrixFloatArray3, -1.0f, -1.2246469E-16f, 336.0f, 1.2246469E-16f, -1.0f, 61.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray4);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray5 = c.setMatrixFloatArray(matrixFloatArray4, 1.0f, 0.0f, 12.0f, 0.0f, -1.0f, 36.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray5);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(419430400);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(12.0f, 0.0f);
                instancePath.cubicTo(18.627417f, 0.0f, 24.0f, 5.372583f, 24.0f, 12.0f);
                instancePath.cubicTo(24.0f, 18.627417f, 18.627417f, 24.0f, 12.0f, 24.0f);
                instancePath.cubicTo(5.372583f, 24.0f, 0.0f, 18.627417f, 0.0f, 12.0f);
                instancePath.cubicTo(0.0f, 5.372583f, 5.372583f, 0.0f, 12.0f, 0.0f);
                instancePath.close();
                instancePath.moveTo(12.0f, 2.0f);
                instancePath.cubicTo(6.4771523f, 2.0f, 2.0f, 6.4771523f, 2.0f, 12.0f);
                instancePath.cubicTo(2.0f, 17.522848f, 6.4771523f, 22.0f, 12.0f, 22.0f);
                instancePath.cubicTo(17.522848f, 22.0f, 22.0f, 17.522848f, 22.0f, 12.0f);
                instancePath.cubicTo(22.0f, 6.4771523f, 17.522848f, 2.0f, 12.0f, 2.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-16268960);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(23.0f, 11.0f);
                instancePath2.cubicTo(23.552284f, 11.0f, 24.0f, 11.447716f, 24.0f, 12.0f);
                instancePath2.lineTo(24.0f, 12.0f);
                instancePath2.lineTo(24.0f, 12.0f);
                instancePath2.cubicTo(24.0f, 18.601927f, 18.668665f, 23.958654f, 12.076414f, 23.999762f);
                instancePath2.lineTo(12.017f, 23.999f);
                instancePath2.lineTo(12.0f, 24.0f);
                instancePath2.cubicTo(11.4871645f, 24.0f, 11.064493f, 23.61396f, 11.006728f, 23.116621f);
                instancePath2.lineTo(11.0f, 23.0f);
                instancePath2.cubicTo(11.0f, 22.447716f, 11.447716f, 22.0f, 12.0f, 22.0f);
                instancePath2.lineTo(12.0f, 22.0f);
                instancePath2.cubicTo(17.522848f, 22.0f, 22.0f, 17.522848f, 22.0f, 12.0f);
                instancePath2.lineTo(22.0f, 11.999f);
                instancePath2.lineTo(22.006727f, 11.883379f);
                instancePath2.cubicTo(22.06005f, 11.424297f, 22.424297f, 11.060049f, 22.883379f, 11.006728f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.restore();
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
