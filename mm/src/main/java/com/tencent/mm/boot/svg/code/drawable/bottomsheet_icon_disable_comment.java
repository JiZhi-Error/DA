package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_icon_disable_comment extends c {
    private final int height = 32;
    private final int width = 32;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 32;
            case 1:
                return 32;
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
                instancePath.moveTo(5.7862f, 8.047872f);
                instancePath.lineTo(6.917913f, 9.179439f);
                instancePath.cubicTo(5.25769f, 10.865079f, 4.266667f, 13.014215f, 4.266667f, 15.333333f);
                instancePath.cubicTo(4.266667f, 18.101233f, 5.675907f, 20.701462f, 8.134127f, 22.548485f);
                instancePath.lineTo(8.868346f, 23.100151f);
                instancePath.lineTo(8.554925f, 25.796453f);
                instancePath.lineTo(11.556604f, 24.357117f);
                instancePath.lineTo(12.142986f, 24.526922f);
                instancePath.cubicTo(13.371388f, 24.882647f, 14.669612f, 25.066668f, 16.0f, 25.066668f);
                instancePath.cubicTo(18.041685f, 25.066668f, 19.953278f, 24.634855f, 21.616663f, 23.878956f);
                instancePath.lineTo(22.814817f, 25.076536f);
                instancePath.cubicTo(20.820555f, 26.086504f, 18.489986f, 26.666666f, 16.0f, 26.666666f);
                instancePath.cubicTo(14.494689f, 26.666666f, 13.047641f, 26.454632f, 11.697939f, 26.063782f);
                instancePath.lineTo(7.7206683f, 27.970924f);
                instancePath.cubicTo(7.607137f, 28.025364f, 7.48051f, 28.04654f, 7.355444f, 28.032001f);
                instancePath.cubicTo(6.9897165f, 27.989489f, 6.7276993f, 27.658546f, 6.770212f, 27.292818f);
                instancePath.lineTo(7.1730084f, 23.827644f);
                instancePath.cubicTo(4.409331f, 21.75111f, 2.6666667f, 18.715206f, 2.6666667f, 15.333333f);
                instancePath.cubicTo(2.6666667f, 12.559188f, 3.8392878f, 10.01784f, 5.7862f, 8.047872f);
                instancePath.close();
                instancePath.moveTo(16.0f, 4.0f);
                instancePath.cubicTo(23.363796f, 4.0f, 29.333334f, 9.074106f, 29.333334f, 15.333333f);
                instancePath.cubicTo(29.333334f, 18.420435f, 27.881218f, 21.21925f, 25.525908f, 23.263199f);
                instancePath.lineTo(28.566639f, 26.303896f);
                instancePath.lineTo(27.435268f, 27.435266f);
                instancePath.lineTo(24.242413f, 24.242346f);
                instancePath.cubicTo(24.242075f, 24.24257f, 24.24174f, 24.242796f, 24.241402f, 24.243023f);
                instancePath.lineTo(23.412666f, 23.413f);
                instancePath.lineTo(5.1313715f, 5.131371f);
                instancePath.lineTo(6.2627425f, 4.0f);
                instancePath.lineTo(8.326298f, 6.0639787f);
                instancePath.cubicTo(10.496256f, 4.7636843f, 13.143206f, 4.0f, 16.0f, 4.0f);
                instancePath.close();
                instancePath.moveTo(16.0f, 5.6f);
                instancePath.cubicTo(13.584878f, 5.6f, 11.35179f, 6.2042203f, 9.496242f, 7.234354f);
                instancePath.lineTo(24.391493f, 22.128908f);
                instancePath.cubicTo(26.46386f, 20.36515f, 27.733334f, 17.958113f, 27.733334f, 15.333333f);
                instancePath.cubicTo(27.733334f, 10.020646f, 22.532574f, 5.6f, 16.0f, 5.6f);
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
