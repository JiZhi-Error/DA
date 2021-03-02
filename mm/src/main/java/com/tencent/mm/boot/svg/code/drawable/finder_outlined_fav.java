package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_outlined_fav extends c {
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
                c.instanceMatrix(looper);
                c.instanceMatrixArray(looper);
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
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-2565928);
                canvas.saveLayerAlpha(null, 0, 31);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(72.0f, 0.0f);
                instancePath.lineTo(72.0f, 72.0f);
                instancePath.lineTo(0.0f, 72.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.restore();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-2565928);
                canvas.saveLayerAlpha(null, 0, 31);
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint6, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(0.0f, 0.0f);
                instancePath2.lineTo(72.0f, 0.0f);
                instancePath2.lineTo(72.0f, 72.0f);
                instancePath2.lineTo(0.0f, 72.0f);
                instancePath2.lineTo(0.0f, 0.0f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint7);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint3, looper);
                instancePaint8.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint8.setStrokeWidth(3.6f);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(13.8f, 23.73f);
                instancePath3.cubicTo(13.8f, 22.387947f, 14.887947f, 21.3f, 16.23f, 21.3f);
                instancePath3.lineTo(55.77f, 21.3f);
                instancePath3.cubicTo(57.112053f, 21.3f, 58.2f, 22.387947f, 58.2f, 23.73f);
                instancePath3.lineTo(58.2f, 58.77f);
                instancePath3.cubicTo(58.2f, 60.112053f, 57.112053f, 61.2f, 55.77f, 61.2f);
                instancePath3.lineTo(16.23f, 61.2f);
                instancePath3.cubicTo(14.887947f, 61.2f, 13.8f, 60.112053f, 13.8f, 58.77f);
                instancePath3.lineTo(13.8f, 23.73f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint8);
                canvas.restore();
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint, looper);
                instancePaint9.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(16.5f, 11.958f);
                instancePath4.cubicTo(16.5f, 11.152769f, 17.15277f, 10.5f, 17.958f, 10.5f);
                instancePath4.lineTo(54.042f, 10.5f);
                instancePath4.cubicTo(54.847233f, 10.5f, 55.5f, 11.152769f, 55.5f, 11.958f);
                instancePath4.lineTo(55.5f, 12.642f);
                instancePath4.cubicTo(55.5f, 13.447231f, 54.847233f, 14.1f, 54.042f, 14.1f);
                instancePath4.lineTo(17.958f, 14.1f);
                instancePath4.cubicTo(17.15277f, 14.1f, 16.5f, 13.447231f, 16.5f, 12.642f);
                instancePath4.lineTo(16.5f, 11.958f);
                instancePath4.close();
                canvas.drawPath(instancePath4, instancePaint9);
                canvas.restore();
                canvas.save();
                Paint instancePaint10 = c.instancePaint(instancePaint3, looper);
                instancePaint10.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint10.setStrokeWidth(3.375f);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(35.999905f, 29.044691f);
                instancePath5.lineTo(32.45585f, 36.55366f);
                instancePath5.lineTo(24.349121f, 37.785435f);
                instancePath5.lineTo(30.220894f, 43.77037f);
                instancePath5.lineTo(28.853815f, 52.10504f);
                instancePath5.lineTo(35.999905f, 48.176556f);
                instancePath5.lineTo(43.145996f, 52.10504f);
                instancePath5.lineTo(41.77892f, 43.77037f);
                instancePath5.lineTo(47.650692f, 37.785435f);
                instancePath5.lineTo(39.54396f, 36.55366f);
                instancePath5.lineTo(35.999905f, 29.044691f);
                instancePath5.close();
                canvas.drawPath(instancePath5, instancePaint10);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
