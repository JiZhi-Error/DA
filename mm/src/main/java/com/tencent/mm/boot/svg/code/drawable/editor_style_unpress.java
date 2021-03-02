package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class editor_style_unpress extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 6.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint4.setStrokeWidth(3.6f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(21.0f, 11.55f);
                instancePath.lineTo(63.0f, 11.55f);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint5.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint5.setStrokeWidth(3.6f);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(21.0f, 31.8f);
                instancePath2.lineTo(63.0f, 31.8f);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                instancePaint6.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint6.setStrokeWidth(3.6f);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(21.0f, 52.05f);
                instancePath3.lineTo(63.0f, 52.05f);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                instancePaint7.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(5.0906253f, 18.0f);
                instancePath4.lineTo(5.0906253f, 7.06875f);
                instancePath4.lineTo(5.034375f, 7.06875f);
                instancePath4.lineTo(1.584375f, 9.45f);
                instancePath4.lineTo(1.584375f, 6.8999996f);
                instancePath4.lineTo(5.08125f, 4.4718747f);
                instancePath4.lineTo(7.89375f, 4.4718747f);
                instancePath4.lineTo(7.89375f, 18.0f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint, looper);
                instancePaint8.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(6.375f, 27.75f);
                instancePath5.cubicTo(8.238961f, 27.75f, 9.75f, 29.26104f, 9.75f, 31.125f);
                instancePath5.cubicTo(9.75f, 32.98896f, 8.238961f, 34.5f, 6.375f, 34.5f);
                instancePath5.cubicTo(4.511039f, 34.5f, 3.0f, 32.98896f, 3.0f, 31.125f);
                instancePath5.cubicTo(3.0f, 29.26104f, 4.511039f, 27.75f, 6.375f, 27.75f);
                instancePath5.close();
                canvas.drawPath(instancePath5, instancePaint8);
                canvas.restore();
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint, looper);
                instancePaint9.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath6 = c.instancePath(looper);
                instancePath6.moveTo(3.0f, 48.0f);
                instancePath6.lineTo(9.75f, 48.0f);
                instancePath6.lineTo(9.75f, 54.75f);
                instancePath6.lineTo(3.0f, 54.75f);
                instancePath6.lineTo(3.0f, 48.0f);
                instancePath6.close();
                canvas.drawPath(instancePath6, instancePaint9);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
