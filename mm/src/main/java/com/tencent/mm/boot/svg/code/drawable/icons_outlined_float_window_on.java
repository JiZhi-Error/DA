package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_float_window_on extends c {
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
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint4.setStrokeWidth(3.6f);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(36.0f, 7.799999f);
                instancePath.cubicTo(51.574432f, 7.799999f, 64.2f, 20.425568f, 64.2f, 36.0f);
                instancePath.cubicTo(64.2f, 51.574432f, 51.574432f, 64.2f, 36.0f, 64.2f);
                instancePath.cubicTo(20.425568f, 64.2f, 7.799999f, 51.574432f, 7.799999f, 36.0f);
                instancePath.cubicTo(7.799999f, 20.425568f, 20.425568f, 7.799999f, 36.0f, 7.799999f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(36.0f, 19.8f);
                instancePath2.cubicTo(44.947014f, 19.8f, 52.2f, 27.052986f, 52.2f, 36.0f);
                instancePath2.cubicTo(52.2f, 44.947014f, 44.947014f, 52.2f, 36.0f, 52.2f);
                instancePath2.cubicTo(27.052986f, 52.2f, 19.8f, 44.947014f, 19.8f, 36.0f);
                instancePath2.cubicTo(19.8f, 27.052986f, 27.052986f, 19.8f, 36.0f, 19.8f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
