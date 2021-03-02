package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class game_icon_mask_normal extends c {
    private final int height = 216;
    private final int width = 216;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 216;
            case 1:
                return 216;
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
                instancePaint3.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 40.0f);
                instancePath.cubicTo(0.0f, 17.90861f, 17.90861f, 0.0f, 40.0f, 0.0f);
                instancePath.lineTo(176.0f, 0.0f);
                instancePath.cubicTo(198.09138f, 0.0f, 216.0f, 17.90861f, 216.0f, 40.0f);
                instancePath.lineTo(216.0f, 176.0f);
                instancePath.cubicTo(216.0f, 198.09138f, 198.09138f, 216.0f, 176.0f, 216.0f);
                instancePath.lineTo(40.0f, 216.0f);
                instancePath.cubicTo(17.90861f, 216.0f, 0.0f, 198.09138f, 0.0f, 176.0f);
                instancePath.lineTo(0.0f, 40.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
