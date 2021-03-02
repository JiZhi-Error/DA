package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_remove_from_list extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 4.5f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint4.setStrokeWidth(1.2f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.5f, 1.0f);
                instancePath.lineTo(16.0f, 1.0f);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint5.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint5.setStrokeWidth(1.2f);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(0.5f, 7.5f);
                instancePath2.lineTo(16.0f, 7.5f);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                instancePaint6.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint6.setStrokeWidth(1.2f);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(0.5f, 14.0f);
                instancePath3.lineTo(8.5f, 14.0f);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                instancePaint7.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(14.975205f, 10.5f);
                instancePath4.lineTo(15.823733f, 11.348528f);
                instancePath4.lineTo(10.2485285f, 16.923733f);
                instancePath4.lineTo(9.4f, 16.075205f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath4, 1);
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint, looper);
                instancePaint8.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(10.2485285f, 10.5f);
                instancePath5.lineTo(15.823733f, 16.075205f);
                instancePath5.lineTo(14.975205f, 16.923733f);
                instancePath5.lineTo(9.4f, 11.348528f);
                instancePath5.close();
                WeChatSVGRenderC2Java.setFillType(instancePath5, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath5, 1);
                canvas.drawPath(instancePath5, instancePaint8);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
