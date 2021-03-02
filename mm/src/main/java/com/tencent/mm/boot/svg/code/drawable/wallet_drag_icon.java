package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class wallet_drag_icon extends c {
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
                c.instancePaint(instancePaint2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(1.75f, 7.75f);
                instancePath.lineTo(22.25f, 7.75f);
                instancePath.cubicTo(22.664213f, 7.75f, 23.0f, 8.085787f, 23.0f, 8.5f);
                instancePath.cubicTo(23.0f, 8.914213f, 22.664213f, 9.25f, 22.25f, 9.25f);
                instancePath.lineTo(1.75f, 9.25f);
                instancePath.cubicTo(1.3357865f, 9.25f, 1.0f, 8.914213f, 1.0f, 8.5f);
                instancePath.cubicTo(1.0f, 8.085787f, 1.3357865f, 7.75f, 1.75f, 7.75f);
                instancePath.close();
                instancePath.moveTo(1.75f, 11.25f);
                instancePath.lineTo(22.25f, 11.25f);
                instancePath.cubicTo(22.664213f, 11.25f, 23.0f, 11.585787f, 23.0f, 12.0f);
                instancePath.cubicTo(23.0f, 12.414213f, 22.664213f, 12.75f, 22.25f, 12.75f);
                instancePath.lineTo(1.75f, 12.75f);
                instancePath.cubicTo(1.3357865f, 12.75f, 1.0f, 12.414213f, 1.0f, 12.0f);
                instancePath.cubicTo(1.0f, 11.585787f, 1.3357865f, 11.25f, 1.75f, 11.25f);
                instancePath.close();
                instancePath.moveTo(1.75f, 14.75f);
                instancePath.lineTo(22.25f, 14.75f);
                instancePath.cubicTo(22.664213f, 14.75f, 23.0f, 15.085787f, 23.0f, 15.5f);
                instancePath.cubicTo(23.0f, 15.914213f, 22.664213f, 16.25f, 22.25f, 16.25f);
                instancePath.lineTo(1.75f, 16.25f);
                instancePath.cubicTo(1.3357865f, 16.25f, 1.0f, 15.914213f, 1.0f, 15.5f);
                instancePath.cubicTo(1.0f, 15.085787f, 1.3357865f, 14.75f, 1.75f, 14.75f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
