package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class panel_icon_live extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(96.0f, 0.0f);
                instancePath.lineTo(96.0f, 96.0f);
                instancePath.lineTo(0.0f, 96.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint4.setStrokeWidth(6.0f);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(48.0f, 11.0f);
                instancePath2.cubicTo(68.43454f, 11.0f, 85.0f, 27.565464f, 85.0f, 48.0f);
                instancePath2.cubicTo(85.0f, 68.43454f, 68.43454f, 85.0f, 48.0f, 85.0f);
                instancePath2.cubicTo(27.565464f, 85.0f, 11.0f, 68.43454f, 11.0f, 48.0f);
                instancePath2.cubicTo(11.0f, 27.565464f, 27.565464f, 11.0f, 48.0f, 11.0f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                instancePaint5.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint6.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint6.setStrokeWidth(3.3333333f);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(48.0f, 26.0f);
                instancePath3.cubicTo(60.150265f, 26.0f, 70.0f, 35.849735f, 70.0f, 48.0f);
                instancePath3.cubicTo(70.0f, 60.150265f, 60.150265f, 70.0f, 48.0f, 70.0f);
                instancePath3.cubicTo(35.849735f, 70.0f, 26.0f, 60.150265f, 26.0f, 48.0f);
                instancePath3.cubicTo(26.0f, 35.849735f, 35.849735f, 26.0f, 48.0f, 26.0f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
