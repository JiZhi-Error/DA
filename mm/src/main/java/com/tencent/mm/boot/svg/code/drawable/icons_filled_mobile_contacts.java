package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_mobile_contacts extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(12.0f, 9.0f);
                instancePath.cubicTo(12.0f, 7.343146f, 13.343145f, 6.0f, 15.0f, 6.0f);
                instancePath.lineTo(57.0f, 6.0f);
                instancePath.cubicTo(58.656853f, 6.0f, 60.0f, 7.343146f, 60.0f, 9.0f);
                instancePath.lineTo(60.0f, 63.0f);
                instancePath.cubicTo(60.0f, 64.65685f, 58.656853f, 66.0f, 57.0f, 66.0f);
                instancePath.lineTo(15.0f, 66.0f);
                instancePath.cubicTo(13.343145f, 66.0f, 12.0f, 64.65685f, 12.0f, 63.0f);
                instancePath.lineTo(12.0f, 9.0f);
                instancePath.close();
                instancePath.moveTo(44.72809f, 41.41832f);
                instancePath.cubicTo(44.45048f, 41.325924f, 44.33481f, 41.37212f, 44.080334f, 41.510715f);
                instancePath.cubicTo(43.24751f, 41.972702f, 41.211716f, 43.081467f, 40.008747f, 43.70515f);
                instancePath.cubicTo(39.708004f, 43.866844f, 39.38413f, 43.95924f, 39.013985f, 43.95924f);
                instancePath.cubicTo(38.620705f, 43.95924f, 38.273693f, 43.843746f, 37.972954f, 43.65895f);
                instancePath.cubicTo(36.28417f, 42.66568f, 34.68792f, 41.510715f, 33.323013f, 40.12476f);
                instancePath.cubicTo(31.958105f, 38.7619f, 30.801405f, 37.16805f, 29.80664f, 35.4818f);
                instancePath.cubicTo(29.621569f, 35.18151f, 29.505898f, 34.811924f, 29.505898f, 34.442333f);
                instancePath.cubicTo(29.505898f, 34.095844f, 29.598434f, 33.749355f, 29.760372f, 33.449062f);
                instancePath.cubicTo(30.38499f, 32.2248f, 31.495424f, 30.192064f, 31.958105f, 29.383589f);
                instancePath.cubicTo(32.09691f, 29.129498f, 32.143177f, 28.9909f, 32.05064f, 28.736809f);
                instancePath.lineTo(30.08425f, 23.516369f);
                instancePath.cubicTo(29.829775f, 22.915787f, 29.251425f, 22.5231f, 28.557404f, 22.5f);
                instancePath.cubicTo(28.279795f, 22.5f, 27.95592f, 22.615496f, 27.886517f, 22.638596f);
                instancePath.cubicTo(25.61938f, 23.470171f, 24.0f, 25.618404f, 24.0f, 28.159327f);
                instancePath.cubicTo(24.0f, 28.875404f, 24.185072f, 29.545284f, 24.208206f, 29.70698f);
                instancePath.cubicTo(25.31864f, 34.55783f, 27.79398f, 38.877396f, 31.194683f, 42.272995f);
                instancePath.cubicTo(34.595383f, 45.66859f, 38.921448f, 48.140213f, 43.779594f, 49.248978f);
                instancePath.cubicTo(43.941532f, 49.295177f, 44.61242f, 49.45687f, 45.329575f, 49.45687f);
                instancePath.cubicTo(47.874317f, 49.45687f, 50.02578f, 47.839924f, 50.858604f, 45.57619f);
                instancePath.cubicTo(50.88174f, 45.506893f, 51.020542f, 45.183502f, 50.99741f, 44.90631f);
                instancePath.cubicTo(50.95114f, 44.213333f, 50.55786f, 43.635853f, 49.95638f, 43.38176f);
                instancePath.lineTo(44.72809f, 41.41832f);
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
