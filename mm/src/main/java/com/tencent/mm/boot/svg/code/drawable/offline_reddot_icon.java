package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class offline_reddot_icon extends c {
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
                instancePaint4.setColor(-564640);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(12.0f, 3.0f);
                instancePath.cubicTo(16.970562f, 3.0f, 21.0f, 7.029437f, 21.0f, 12.0f);
                instancePath.cubicTo(21.0f, 16.970562f, 16.970562f, 21.0f, 12.0f, 21.0f);
                instancePath.cubicTo(7.029437f, 21.0f, 3.0f, 16.970562f, 3.0f, 12.0f);
                instancePath.cubicTo(3.0f, 7.029437f, 7.029437f, 3.0f, 12.0f, 3.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                instancePaint6.setColor(-1);
                instancePaint6.setStrokeWidth(3.0f);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(12.0f, 1.5f);
                instancePath2.cubicTo(17.79899f, 1.5f, 22.5f, 6.2010098f, 22.5f, 12.0f);
                instancePath2.cubicTo(22.5f, 17.79899f, 17.79899f, 22.5f, 12.0f, 22.5f);
                instancePath2.cubicTo(6.2010098f, 22.5f, 1.5f, 17.79899f, 1.5f, 12.0f);
                instancePath2.cubicTo(1.5f, 6.2010098f, 6.2010098f, 1.5f, 12.0f, 1.5f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
