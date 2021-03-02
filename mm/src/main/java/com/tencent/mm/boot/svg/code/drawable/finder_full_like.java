package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_full_like extends c {
    private final int height = 72;
    private final int width = 72;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                instancePath.moveTo(12.658556f, 18.193398f);
                instancePath.cubicTo(18.51642f, 12.335534f, 28.013895f, 12.335534f, 33.87176f, 18.193398f);
                instancePath.cubicTo(34.42018f, 18.741817f, 35.127285f, 19.423899f, 35.99308f, 20.239637f);
                instancePath.cubicTo(36.858875f, 19.423899f, 37.56598f, 18.741817f, 38.1144f, 18.193398f);
                instancePath.cubicTo(43.972263f, 12.335534f, 53.469738f, 12.335534f, 59.327602f, 18.193398f);
                instancePath.cubicTo(65.13098f, 23.996773f, 65.18496f, 33.37236f, 59.48955f, 39.242195f);
                instancePath.lineTo(38.11429f, 60.619694f);
                instancePath.cubicTo(36.94289f, 61.79144f, 35.043392f, 61.79154f, 33.87176f, 60.620026f);
                instancePath.cubicTo(33.871723f, 60.61999f, 33.871685f, 60.619953f, 33.87176f, 60.619804f);
                instancePath.lineTo(12.495378f, 39.243423f);
                instancePath.lineTo(12.495378f, 39.243423f);
                instancePath.cubicTo(6.801199f, 33.37236f, 6.8551817f, 23.996773f, 12.658556f, 18.193398f);
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
