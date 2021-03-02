package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class switch_off extends c {
    private final int height = 72;
    private final int width = 210;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 210;
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
                c.instancePaint(instancePaint2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-6710887);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 12.0f);
                instancePath.cubicTo(0.0f, 5.3725824f, 5.3725824f, 0.0f, 12.0f, 0.0f);
                instancePath.lineTo(198.0f, 0.0f);
                instancePath.cubicTo(204.62741f, 0.0f, 210.0f, 5.3725824f, 210.0f, 12.0f);
                instancePath.lineTo(210.0f, 60.0f);
                instancePath.cubicTo(210.0f, 66.62742f, 204.62741f, 72.0f, 198.0f, 72.0f);
                instancePath.lineTo(12.0f, 72.0f);
                instancePath.cubicTo(5.3725824f, 72.0f, 0.0f, 66.62742f, 0.0f, 60.0f);
                instancePath.lineTo(0.0f, 12.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(3.0f, 11.0f);
                instancePath2.cubicTo(3.0f, 6.581722f, 6.581722f, 3.0f, 11.0f, 3.0f);
                instancePath2.lineTo(97.0f, 3.0f);
                instancePath2.cubicTo(101.41828f, 3.0f, 105.0f, 6.581722f, 105.0f, 11.0f);
                instancePath2.lineTo(105.0f, 61.0f);
                instancePath2.cubicTo(105.0f, 65.41828f, 101.41828f, 69.0f, 97.0f, 69.0f);
                instancePath2.lineTo(11.0f, 69.0f);
                instancePath2.cubicTo(6.581722f, 69.0f, 3.0f, 65.41828f, 3.0f, 61.0f);
                instancePath2.lineTo(3.0f, 11.0f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
