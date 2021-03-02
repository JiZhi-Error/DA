package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icon_line_comment extends c {
    private final int height = 48;
    private final int width = 48;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(41.0f, 8.0f);
                instancePath.cubicTo(42.656853f, 8.0f, 44.0f, 9.343145f, 44.0f, 11.0f);
                instancePath.lineTo(44.0f, 35.0f);
                instancePath.cubicTo(44.0f, 36.656853f, 42.656853f, 38.0f, 41.0f, 38.0f);
                instancePath.lineTo(22.0f, 38.0f);
                instancePath.lineTo(17.414213f, 42.585785f);
                instancePath.cubicTo(16.633165f, 43.366837f, 15.366835f, 43.366837f, 14.585787f, 42.585785f);
                instancePath.cubicTo(14.210713f, 42.210712f, 14.0f, 41.702007f, 14.0f, 41.171574f);
                instancePath.lineTo(14.0f, 38.0f);
                instancePath.lineTo(7.0f, 38.0f);
                instancePath.cubicTo(5.343146f, 38.0f, 4.0f, 36.656853f, 4.0f, 35.0f);
                instancePath.lineTo(4.0f, 11.0f);
                instancePath.cubicTo(4.0f, 9.343145f, 5.343146f, 8.0f, 7.0f, 8.0f);
                instancePath.lineTo(41.0f, 8.0f);
                instancePath.close();
                instancePath.moveTo(41.0f, 10.4f);
                instancePath.lineTo(7.0f, 10.4f);
                instancePath.cubicTo(6.668629f, 10.4f, 6.4f, 10.66863f, 6.4f, 11.0f);
                instancePath.lineTo(6.4f, 35.0f);
                instancePath.cubicTo(6.4f, 35.33137f, 6.668629f, 35.6f, 7.0f, 35.6f);
                instancePath.lineTo(16.4f, 35.6f);
                instancePath.lineTo(16.4f, 40.205887f);
                instancePath.lineTo(21.005888f, 35.6f);
                instancePath.lineTo(41.0f, 35.6f);
                instancePath.cubicTo(41.33137f, 35.6f, 41.6f, 35.33137f, 41.6f, 35.0f);
                instancePath.lineTo(41.6f, 11.0f);
                instancePath.cubicTo(41.6f, 10.66863f, 41.33137f, 10.4f, 41.0f, 10.4f);
                instancePath.close();
                instancePath.moveTo(33.97339f, 26.133495f);
                instancePath.lineTo(33.97339f, 28.533497f);
                instancePath.lineTo(13.973389f, 28.533497f);
                instancePath.lineTo(13.973389f, 26.133495f);
                instancePath.lineTo(33.97339f, 26.133495f);
                instancePath.close();
                instancePath.moveTo(33.97339f, 17.133495f);
                instancePath.lineTo(33.97339f, 19.533497f);
                instancePath.lineTo(13.973389f, 19.533497f);
                instancePath.lineTo(13.973389f, 17.133495f);
                instancePath.lineTo(33.97339f, 17.133495f);
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
