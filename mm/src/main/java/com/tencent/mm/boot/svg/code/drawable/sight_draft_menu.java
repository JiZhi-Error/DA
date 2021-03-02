package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sight_draft_menu extends c {
    private final int height = 12;
    private final int width = 64;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 64;
            case 1:
                return 12;
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
                instancePaint3.setColor(-2565928);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(6.0f, 12.0f);
                instancePath.cubicTo(9.313708f, 12.0f, 12.0f, 9.313708f, 12.0f, 6.0f);
                instancePath.cubicTo(12.0f, 2.6862915f, 9.313708f, 0.0f, 6.0f, 0.0f);
                instancePath.cubicTo(2.6862915f, 0.0f, 0.0f, 2.6862915f, 0.0f, 6.0f);
                instancePath.cubicTo(0.0f, 9.313708f, 2.6862915f, 12.0f, 6.0f, 12.0f);
                instancePath.close();
                instancePath.moveTo(32.0f, 12.0f);
                instancePath.cubicTo(35.31371f, 12.0f, 38.0f, 9.313708f, 38.0f, 6.0f);
                instancePath.cubicTo(38.0f, 2.6862915f, 35.31371f, 0.0f, 32.0f, 0.0f);
                instancePath.cubicTo(28.68629f, 0.0f, 26.0f, 2.6862915f, 26.0f, 6.0f);
                instancePath.cubicTo(26.0f, 9.313708f, 28.68629f, 12.0f, 32.0f, 12.0f);
                instancePath.close();
                instancePath.moveTo(58.0f, 12.0f);
                instancePath.cubicTo(61.31371f, 12.0f, 64.0f, 9.313708f, 64.0f, 6.0f);
                instancePath.cubicTo(64.0f, 2.6862915f, 61.31371f, 0.0f, 58.0f, 0.0f);
                instancePath.cubicTo(54.68629f, 0.0f, 52.0f, 2.6862915f, 52.0f, 6.0f);
                instancePath.cubicTo(52.0f, 9.313708f, 54.68629f, 12.0f, 58.0f, 12.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(6.0f, 12.0f);
                instancePath2.cubicTo(9.313708f, 12.0f, 12.0f, 9.313708f, 12.0f, 6.0f);
                instancePath2.cubicTo(12.0f, 2.6862915f, 9.313708f, 0.0f, 6.0f, 0.0f);
                instancePath2.cubicTo(2.6862915f, 0.0f, 0.0f, 2.6862915f, 0.0f, 6.0f);
                instancePath2.cubicTo(0.0f, 9.313708f, 2.6862915f, 12.0f, 6.0f, 12.0f);
                instancePath2.close();
                instancePath2.moveTo(32.0f, 12.0f);
                instancePath2.cubicTo(35.31371f, 12.0f, 38.0f, 9.313708f, 38.0f, 6.0f);
                instancePath2.cubicTo(38.0f, 2.6862915f, 35.31371f, 0.0f, 32.0f, 0.0f);
                instancePath2.cubicTo(28.68629f, 0.0f, 26.0f, 2.6862915f, 26.0f, 6.0f);
                instancePath2.cubicTo(26.0f, 9.313708f, 28.68629f, 12.0f, 32.0f, 12.0f);
                instancePath2.close();
                instancePath2.moveTo(58.0f, 12.0f);
                instancePath2.cubicTo(61.31371f, 12.0f, 64.0f, 9.313708f, 64.0f, 6.0f);
                instancePath2.cubicTo(64.0f, 2.6862915f, 61.31371f, 0.0f, 58.0f, 0.0f);
                instancePath2.cubicTo(54.68629f, 0.0f, 52.0f, 2.6862915f, 52.0f, 6.0f);
                instancePath2.cubicTo(52.0f, 9.313708f, 54.68629f, 12.0f, 58.0f, 12.0f);
                instancePath2.close();
                Paint instancePaint6 = c.instancePaint(looper);
                instancePaint6.setFlags(385);
                instancePaint6.setStyle(Paint.Style.FILL);
                Paint instancePaint7 = c.instancePaint(looper);
                instancePaint7.setFlags(385);
                instancePaint7.setStyle(Paint.Style.STROKE);
                instancePaint6.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint7.setStrokeWidth(1.0f);
                instancePaint7.setStrokeCap(Paint.Cap.BUTT);
                instancePaint7.setStrokeJoin(Paint.Join.MITER);
                instancePaint7.setStrokeMiter(4.0f);
                instancePaint7.setPathEffect(null);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 64.0f, 0.0f, 0.0f, 0.0f, 12.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                WeChatSVGRenderC2Java.setLinearGradient(instancePaint5, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-6556649, -9903790}, new float[]{0.0f, 1.0f}, instanceMatrix, 0);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
