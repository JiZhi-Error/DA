package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class tips_background_dark extends c {
    private final int height = 101;
    private final int width = 200;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 200;
            case 1:
                return 101;
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
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-13882324);
                instancePaint5.setColor(268435455);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.5f, 8.5f);
                instancePath.cubicTo(0.5f, 4.081722f, 4.081722f, 0.5f, 8.5f, 0.5f);
                instancePath.lineTo(191.5f, 0.5f);
                instancePath.cubicTo(195.91827f, 0.5f, 199.5f, 4.081722f, 199.5f, 8.5f);
                instancePath.lineTo(199.5f, 92.5f);
                instancePath.cubicTo(199.5f, 96.91828f, 195.91827f, 100.5f, 191.5f, 100.5f);
                instancePath.lineTo(8.5f, 100.5f);
                instancePath.cubicTo(4.081722f, 100.5f, 0.5f, 96.91828f, 0.5f, 92.5f);
                instancePath.lineTo(0.5f, 8.5f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
