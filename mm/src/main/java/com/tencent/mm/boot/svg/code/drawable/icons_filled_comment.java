package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_comment extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-436207616);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(20.5f, 4.0f);
                instancePath.cubicTo(21.328426f, 4.0f, 22.0f, 4.6715727f, 22.0f, 5.5f);
                instancePath.lineTo(22.0f, 5.5f);
                instancePath.lineTo(22.0f, 17.5f);
                instancePath.cubicTo(22.0f, 18.328426f, 21.328426f, 19.0f, 20.5f, 19.0f);
                instancePath.lineTo(20.5f, 19.0f);
                instancePath.lineTo(11.0f, 19.0f);
                instancePath.lineTo(8.707107f, 21.292892f);
                instancePath.cubicTo(8.316583f, 21.683418f, 7.6834173f, 21.683418f, 7.2928934f, 21.292892f);
                instancePath.cubicTo(7.1053567f, 21.105356f, 7.0f, 20.851004f, 7.0f, 20.585787f);
                instancePath.lineTo(7.0f, 19.0f);
                instancePath.lineTo(3.5f, 19.0f);
                instancePath.cubicTo(2.7203038f, 19.0f, 2.0795512f, 18.405111f, 2.0068667f, 17.64446f);
                instancePath.lineTo(2.0f, 17.5f);
                instancePath.lineTo(2.0f, 5.5f);
                instancePath.cubicTo(2.0f, 4.6715727f, 2.671573f, 4.0f, 3.5f, 4.0f);
                instancePath.lineTo(3.5f, 4.0f);
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
