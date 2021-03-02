package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class coin_icon extends c {
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
                instancePath.moveTo(18.626717f, 6.5727806f);
                instancePath.cubicTo(17.614721f, 5.560786f, 16.293728f, 4.994788f, 14.843735f, 4.844789f);
                instancePath.cubicTo(14.660735f, 5.292787f, 14.376737f, 5.7987843f, 13.947739f, 6.390782f);
                instancePath.cubicTo(12.732745f, 8.068773f, 10.871754f, 8.86377f, 10.871754f, 8.86377f);
                instancePath.cubicTo(10.871754f, 8.86377f, 12.822744f, 6.78678f, 13.053743f, 4.7997894f);
                instancePath.cubicTo(13.168742f, 3.8107939f, 12.965744f, 2.5787997f, 12.525745f, 2.133802f);
                instancePath.cubicTo(12.263747f, 1.8668032f, 11.814749f, 2.0228024f, 11.777749f, 2.3948007f);
                instancePath.cubicTo(11.718749f, 3.0047977f, 11.491751f, 3.8397937f, 10.897754f, 4.63179f);
                instancePath.cubicTo(10.421756f, 5.266787f, 9.41176f, 5.9987836f, 9.050762f, 6.2497826f);
                instancePath.cubicTo(8.180766f, 6.76078f, 7.34177f, 7.400777f, 6.570774f, 8.171773f);
                instancePath.cubicTo(2.800792f, 11.941755f, 2.0847955f, 17.33973f, 4.9727817f, 20.227716f);
                instancePath.cubicTo(7.859768f, 23.114702f, 13.257742f, 22.399706f, 17.027725f, 18.628723f);
                instancePath.cubicTo(20.798706f, 14.857741f, 21.514704f, 9.460767f, 18.626717f, 6.5727806f);
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
