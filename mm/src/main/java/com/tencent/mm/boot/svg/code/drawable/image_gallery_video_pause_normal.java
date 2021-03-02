package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class image_gallery_video_pause_normal extends c {
    private final int height = 55;
    private final int width = 35;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 35;
            case 1:
                return 55;
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 4.0f);
                instancePath.cubicTo(0.0f, 1.7908609f, 1.7908609f, 0.0f, 4.0f, 0.0f);
                instancePath.lineTo(5.0f, 0.0f);
                instancePath.cubicTo(7.209139f, 0.0f, 9.0f, 1.7908609f, 9.0f, 4.0f);
                instancePath.lineTo(9.0f, 51.0f);
                instancePath.cubicTo(9.0f, 53.20914f, 7.209139f, 55.0f, 5.0f, 55.0f);
                instancePath.lineTo(4.0f, 55.0f);
                instancePath.cubicTo(1.7908609f, 55.0f, 0.0f, 53.20914f, 0.0f, 51.0f);
                instancePath.lineTo(0.0f, 4.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(26.0f, 4.0f);
                instancePath2.cubicTo(26.0f, 1.7908609f, 27.790861f, 0.0f, 30.0f, 0.0f);
                instancePath2.lineTo(31.0f, 0.0f);
                instancePath2.cubicTo(33.20914f, 0.0f, 35.0f, 1.7908609f, 35.0f, 4.0f);
                instancePath2.lineTo(35.0f, 51.0f);
                instancePath2.cubicTo(35.0f, 53.20914f, 33.20914f, 55.0f, 31.0f, 55.0f);
                instancePath2.lineTo(30.0f, 55.0f);
                instancePath2.cubicTo(27.790861f, 55.0f, 26.0f, 53.20914f, 26.0f, 51.0f);
                instancePath2.lineTo(26.0f, 4.0f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
