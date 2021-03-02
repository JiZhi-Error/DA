package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class note_voiceplayer_seekbar_thumb extends c {
    private final int height = 96;
    private final int width = 43;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 43;
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
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-1);
                instancePaint5.setColor(832018327);
                instancePaint5.setStrokeWidth(1.44f);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Paint instancePaint7 = c.instancePaint(instancePaint5, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(21.5f, 31.0f);
                instancePath.cubicTo(31.164984f, 31.0f, 39.0f, 38.835014f, 39.0f, 48.5f);
                instancePath.cubicTo(39.0f, 58.164986f, 31.164984f, 66.0f, 21.5f, 66.0f);
                instancePath.cubicTo(11.835016f, 66.0f, 4.0f, 58.164986f, 4.0f, 48.5f);
                instancePath.cubicTo(4.0f, 38.835014f, 11.835016f, 31.0f, 21.5f, 31.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint6);
                canvas.drawPath(instancePath, instancePaint7);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
