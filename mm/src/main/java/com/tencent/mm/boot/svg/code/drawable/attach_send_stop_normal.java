package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class attach_send_stop_normal extends c {
    private final int height = 66;
    private final int width = 66;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 66;
            case 1:
                return 66;
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
                instancePaint3.setColor(-372399);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(33.0f, 0.0f);
                instancePath.cubicTo(51.225395f, 0.0f, 66.0f, 14.774603f, 66.0f, 33.0f);
                instancePath.cubicTo(66.0f, 51.225395f, 51.225395f, 66.0f, 33.0f, 66.0f);
                instancePath.cubicTo(14.774603f, 66.0f, 0.0f, 51.225395f, 0.0f, 33.0f);
                instancePath.cubicTo(0.0f, 14.774603f, 14.774603f, 0.0f, 33.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(40.0f, 18.0f);
                instancePath2.lineTo(44.0f, 18.0f);
                instancePath2.lineTo(44.0f, 48.0f);
                instancePath2.lineTo(40.0f, 48.0f);
                instancePath2.lineTo(40.0f, 18.0f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-1);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(22.0f, 18.0f);
                instancePath3.lineTo(26.0f, 18.0f);
                instancePath3.lineTo(26.0f, 48.0f);
                instancePath3.lineTo(22.0f, 48.0f);
                instancePath3.lineTo(22.0f, 18.0f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
