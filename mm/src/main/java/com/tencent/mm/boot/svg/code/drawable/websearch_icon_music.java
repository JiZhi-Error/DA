package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class websearch_icon_music extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-5066062);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(14.965f, 0.623f);
                instancePath.cubicTo(14.965f, 0.58000004f, 14.961f, 0.537f, 14.951f, 0.495f);
                instancePath.cubicTo(14.883f, 0.18f, 14.558001f, -0.037f, 14.237f, 0.037f);
                instancePath.lineTo(5.0270004f, 2.054f);
                instancePath.cubicTo(4.5260005f, 2.1639998f, 4.1620007f, 2.616f, 4.1620007f, 3.129f);
                instancePath.lineTo(4.1620007f, 3.407f);
                instancePath.lineTo(4.1620007f, 3.407f);
                instancePath.lineTo(4.1620007f, 11.347f);
                instancePath.cubicTo(4.1620007f, 11.776f, 3.8560007f, 12.15f, 3.4350007f, 12.235001f);
                instancePath.lineTo(2.1830006f, 12.488001f);
                instancePath.cubicTo(1.4210005f, 12.640001f, 0.85900056f, 13.452001f, 0.90200055f, 14.335001f);
                instancePath.cubicTo(0.941f, 15.135f, 1.579f, 16.0f, 2.541f, 16.0f);
                instancePath.lineTo(2.541f, 16.0f);
                instancePath.cubicTo(2.645f, 16.0f, 2.751f, 15.989f, 2.8569999f, 15.968f);
                instancePath.cubicTo(2.9239998f, 15.954f, 3.774f, 15.768001f, 3.921f, 15.699f);
                instancePath.cubicTo(4.6610003f, 15.353001f, 5.178f, 14.564f, 5.178f, 13.779f);
                instancePath.lineTo(5.178f, 3.183f);
                instancePath.lineTo(13.943001f, 1.2630001f);
                instancePath.lineTo(13.943001f, 9.174f);
                instancePath.cubicTo(13.943001f, 9.604f, 13.636001f, 9.978f, 13.214001f, 10.062f);
                instancePath.lineTo(11.945001f, 10.315001f);
                instancePath.cubicTo(11.177001f, 10.468f, 10.609001f, 11.280001f, 10.653001f, 12.162001f);
                instancePath.cubicTo(10.693001f, 12.964001f, 11.337001f, 13.830001f, 12.306001f, 13.830001f);
                instancePath.cubicTo(12.410001f, 13.830001f, 12.517001f, 13.819001f, 12.623001f, 13.798001f);
                instancePath.cubicTo(12.691001f, 13.784001f, 13.549001f, 13.5980015f, 13.696001f, 13.529001f);
                instancePath.cubicTo(14.442001f, 13.1830015f, 14.963001f, 12.393002f, 14.963001f, 11.608002f);
                instancePath.lineTo(14.963f, 1.04f);
                instancePath.lineTo(14.965f, 1.04f);
                instancePath.lineTo(14.965f, 0.623f);
                instancePath.close();
                instancePath.moveTo(2.001f, 14.278f);
                instancePath.cubicTo(1.9819999f, 13.894f, 2.225f, 13.599f, 2.401f, 13.564f);
                instancePath.lineTo(3.6529999f, 13.311f);
                instancePath.cubicTo(3.8009999f, 13.282f, 3.9439998f, 13.236f, 4.078f, 13.175f);
                instancePath.lineTo(4.078f, 13.779f);
                instancePath.cubicTo(4.078f, 14.134f, 3.805f, 14.54f, 3.499f, 14.684f);
                instancePath.cubicTo(3.3890002f, 14.719f, 2.828f, 14.851f, 2.64f, 14.889f);
                instancePath.cubicTo(2.316f, 14.954f, 2.019f, 14.647f, 2.001f, 14.278f);
                instancePath.close();
                instancePath.moveTo(11.753f, 12.107f);
                instancePath.cubicTo(11.734f, 11.724f, 11.982f, 11.428f, 12.161f, 11.392f);
                instancePath.lineTo(13.431f, 11.139f);
                instancePath.cubicTo(13.582f, 11.109f, 13.728f, 11.062f, 13.866f, 10.999f);
                instancePath.lineTo(13.866f, 11.606f);
                instancePath.cubicTo(13.866f, 11.96f, 13.59f, 12.365f, 13.28f, 12.511f);
                instancePath.cubicTo(13.17f, 12.545f, 12.601999f, 12.6779995f, 12.410999f, 12.717f);
                instancePath.cubicTo(12.075f, 12.779f, 11.771f, 12.477f, 11.753f, 12.107f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
