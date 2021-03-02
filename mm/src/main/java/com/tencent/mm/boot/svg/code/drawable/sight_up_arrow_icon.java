package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sight_up_arrow_icon extends c {
    private final int height = 36;
    private final int width = 22;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 22;
            case 1:
                return 36;
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
                instancePath.moveTo(10.0f, 0.0f);
                instancePath.lineTo(11.59f, 0.0f);
                instancePath.cubicTo(14.44f, 4.26f, 18.06f, 8.06f, 22.0f, 11.34f);
                instancePath.lineTo(22.0f, 11.75f);
                instancePath.cubicTo(19.0f, 11.97f, 16.0f, 12.05f, 13.0f, 12.02f);
                instancePath.cubicTo(13.05f, 20.01f, 12.89f, 28.01f, 13.09f, 36.0f);
                instancePath.lineTo(9.0f, 36.0f);
                instancePath.lineTo(9.0f, 12.03f);
                instancePath.cubicTo(6.0f, 12.04f, 3.0f, 11.98f, 0.0f, 11.77f);
                instancePath.lineTo(0.0f, 11.38f);
                instancePath.cubicTo(3.84f, 8.02f, 7.68f, 4.33f, 10.39f, 0.0f);
                instancePath.lineTo(10.0f, 0.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
