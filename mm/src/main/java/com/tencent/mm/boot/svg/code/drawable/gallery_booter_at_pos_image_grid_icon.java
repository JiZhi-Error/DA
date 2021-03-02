package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class gallery_booter_at_pos_image_grid_icon extends c {
    private final int height = 80;
    private final int width = 120;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 120;
            case 1:
                return 80;
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
                instancePaint3.setColor(-1);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 32.0f, 0.0f, 1.0f, 12.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(28.0f, 38.0f);
                instancePath.cubicTo(33.522846f, 38.0f, 38.0f, 33.522846f, 38.0f, 28.0f);
                instancePath.cubicTo(38.0f, 22.477152f, 33.522846f, 18.0f, 28.0f, 18.0f);
                instancePath.cubicTo(22.477152f, 18.0f, 18.0f, 22.477152f, 18.0f, 28.0f);
                instancePath.cubicTo(18.0f, 33.522846f, 22.477152f, 38.0f, 28.0f, 38.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(26.0f, 0.0f);
                instancePath2.lineTo(30.0f, 0.0f);
                instancePath2.lineTo(30.0f, 9.0f);
                instancePath2.lineTo(26.0f, 9.0f);
                instancePath2.lineTo(26.0f, 0.0f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(26.0f, 47.0f);
                instancePath3.lineTo(30.0f, 47.0f);
                instancePath3.lineTo(30.0f, 56.0f);
                instancePath3.lineTo(26.0f, 56.0f);
                instancePath3.lineTo(26.0f, 47.0f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint3, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(47.0f, 25.0f);
                instancePath4.lineTo(56.0f, 25.0f);
                instancePath4.lineTo(56.0f, 29.0f);
                instancePath4.lineTo(47.0f, 29.0f);
                instancePath4.lineTo(47.0f, 25.0f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint3, looper);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(-1.9984014E-16f, 25.0f);
                instancePath5.lineTo(9.0f, 25.0f);
                instancePath5.lineTo(9.0f, 29.0f);
                instancePath5.lineTo(-1.9984014E-16f, 29.0f);
                instancePath5.lineTo(-1.9984014E-16f, 25.0f);
                instancePath5.close();
                WeChatSVGRenderC2Java.setFillType(instancePath5, 2);
                canvas.drawPath(instancePath5, instancePaint8);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
