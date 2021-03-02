package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_call extends c {
    private final int height = 16;
    private final int width = 16;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 16;
            case 1:
                return 16;
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
                instancePath.moveTo(11.119819f, 10.335465f);
                instancePath.cubicTo(10.997457f, 10.294674f, 10.946472f, 10.315069f, 10.834308f, 10.376256f);
                instancePath.cubicTo(10.467222f, 10.580212f, 9.569902f, 11.069706f, 9.039668f, 11.345047f);
                instancePath.cubicTo(8.907109f, 11.416431f, 8.764354f, 11.457222f, 8.601205f, 11.457222f);
                instancePath.cubicTo(8.427859f, 11.457222f, 8.274907f, 11.406234f, 8.142348f, 11.324651f);
                instancePath.cubicTo(7.3979807f, 10.886146f, 6.6944003f, 10.376256f, 6.092788f, 9.764388f);
                instancePath.cubicTo(5.491176f, 9.162719f, 4.981335f, 8.459071f, 4.542872f, 7.7146316f);
                instancePath.cubicTo(4.4612975f, 7.5820603f, 4.410313f, 7.4188957f, 4.410313f, 7.255731f);
                instancePath.cubicTo(4.410313f, 7.102764f, 4.451101f, 6.949797f, 4.522478f, 6.817226f);
                instancePath.cubicTo(4.7977924f, 6.2767425f, 5.2872396f, 5.379337f, 5.491176f, 5.0224137f);
                instancePath.cubicTo(5.5523567f, 4.9102383f, 5.5727506f, 4.8490515f, 5.5319633f, 4.7368755f);
                instancePath.lineTo(4.6652336f, 2.432174f);
                instancePath.cubicTo(4.5530686f, 2.1670313f, 4.298148f, 1.9936689f, 3.992244f, 1.983471f);
                instancePath.cubicTo(3.869882f, 1.983471f, 3.7271266f, 2.03446f, 3.6965363f, 2.044658f);
                instancePath.cubicTo(2.6972482f, 2.4117785f, 1.983471f, 3.3601735f, 1.983471f, 4.4819307f);
                instancePath.cubicTo(1.983471f, 4.7980623f, 2.0650456f, 5.0937986f, 2.0752425f, 5.165183f);
                instancePath.cubicTo(2.5646896f, 7.30672f, 3.6557488f, 9.213708f, 5.1546807f, 10.712784f);
                instancePath.cubicTo(6.653613f, 12.211859f, 8.560417f, 13.303023f, 10.701749f, 13.792518f);
                instancePath.cubicTo(10.773127f, 13.812913f, 11.068834f, 13.884297f, 11.384935f, 13.884297f);
                instancePath.cubicTo(12.506585f, 13.884297f, 13.454889f, 13.170452f, 13.821975f, 12.171068f);
                instancePath.cubicTo(13.832171f, 12.140474f, 13.8933525f, 11.997705f, 13.883156f, 11.875332f);
                instancePath.cubicTo(13.862762f, 11.569398f, 13.689416f, 11.314453f, 13.424299f, 11.202277f);
                instancePath.lineTo(11.119819f, 10.335465f);
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
