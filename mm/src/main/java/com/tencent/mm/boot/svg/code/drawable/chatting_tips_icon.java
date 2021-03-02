package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class chatting_tips_icon extends c {
    private final int height = 22;
    private final int width = 20;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 20;
            case 1:
                return 22;
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
                instancePaint3.setColor(-12404711);
                canvas.saveLayerAlpha(null, 245, 31);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(10.0f, 0.0f);
                instancePath.cubicTo(13.33002f, 3.351164f, 16.779324f, 6.5837026f, 20.0f, 10.043607f);
                instancePath.cubicTo(19.990059f, 11.556079f, 19.264414f, 12.188747f, 17.823061f, 11.951496f);
                instancePath.cubicTo(15.129225f, 9.470251f, 12.624254f, 6.791297f, 10.00994f, 4.240854f);
                instancePath.cubicTo(7.365805f, 6.7814116f, 4.870775f, 9.470251f, 2.1769383f, 11.951496f);
                instancePath.cubicTo(0.73558646f, 12.188747f, 0.009940358f, 11.546193f, 0.0f, 10.043607f);
                instancePath.cubicTo(3.2107356f, 6.5738173f, 6.6799207f, 3.351164f, 10.0f, 0.0f);
                instancePath.lineTo(10.0f, 0.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(20.0f, 20.046492f);
                instancePath2.cubicTo(19.990059f, 21.54951f, 19.264414f, 22.18236f, 17.833002f, 21.95493f);
                instancePath2.cubicTo(15.129225f, 19.472971f, 12.624254f, 16.793247f, 10.00994f, 14.242071f);
                instancePath2.cubicTo(7.365805f, 16.793247f, 4.870775f, 19.472971f, 2.166998f, 21.95493f);
                instancePath2.cubicTo(0.73558646f, 22.18236f, 0.009940358f, 21.54951f, 0.0f, 20.046492f);
                instancePath2.cubicTo(3.2107356f, 16.575705f, 6.6799207f, 13.362015f, 10.0f, 10.0f);
                instancePath2.cubicTo(13.33002f, 13.352126f, 16.789265f, 16.585594f, 20.0f, 20.046492f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
