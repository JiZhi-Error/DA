package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class album_ad_link_tag_weapp extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(1275068416);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(34.0086f, 25.9815f);
                instancePath.lineTo(33.5367f, 25.9891f);
                instancePath.cubicTo(32.11f, 25.9891f, 31.2799f, 24.9425f, 31.8162f, 23.7359f);
                instancePath.cubicTo(32.1835f, 22.8789f, 33.0121f, 22.2171f, 33.9907f, 21.9997f);
                instancePath.cubicTo(36.6089f, 21.3677f, 38.3879f, 19.3214f, 38.3879f, 16.9425f);
                instancePath.cubicTo(38.3879f, 14.0583f, 35.6342f, 11.708f, 32.1949f, 11.708f);
                instancePath.cubicTo(28.7555f, 11.708f, 26.0019f, 14.0583f, 26.0019f, 16.9425f);
                instancePath.lineTo(26.0019f, 31.3195f);
                instancePath.cubicTo(26.0019f, 36.3833f, 21.4758f, 40.462f, 15.901f, 40.462f);
                instancePath.cubicTo(10.3261f, 40.462f, 5.8f, 36.3833f, 5.8f, 31.3195f);
                instancePath.cubicTo(5.8f, 26.8793f, 9.30469f, 23.0893f, 14.0799f, 22.3687f);
                instancePath.lineTo(14.4633f, 22.3687f);
                instancePath.cubicTo(15.5434f, 22.3687f, 16.3214f, 23.0153f, 16.3214f, 23.9387f);
                instancePath.cubicTo(16.3219f, 24.0969f, 16.318f, 24.1701f, 16.3024f, 24.2638f);
                instancePath.cubicTo(16.2813f, 24.3902f, 16.2403f, 24.5111f, 16.1838f, 24.6219f);
                instancePath.cubicTo(15.8396f, 25.4251f, 14.9595f, 26.1206f, 14.0093f, 26.3581f);
                instancePath.cubicTo(11.41f, 26.9855f, 9.61214f, 29.0193f, 9.61214f, 31.3195f);
                instancePath.cubicTo(9.61214f, 34.2036f, 12.3658f, 36.554f, 15.8051f, 36.554f);
                instancePath.cubicTo(19.2445f, 36.554f, 21.9981f, 34.2036f, 21.9981f, 31.3195f);
                instancePath.lineTo(21.9981f, 16.9425f);
                instancePath.cubicTo(21.9981f, 11.8787f, 26.5242f, 7.8f, 32.099f, 7.8f);
                instancePath.cubicTo(37.6739f, 7.8f, 42.2f, 11.8787f, 42.2f, 16.9425f);
                instancePath.cubicTo(42.2f, 21.4062f, 38.7778f, 25.1521f, 34.0086f, 25.9815f);
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
