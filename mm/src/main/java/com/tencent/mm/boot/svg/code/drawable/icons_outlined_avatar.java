package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_avatar extends c {
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
                instancePath.moveTo(12.6f, 12.6f);
                instancePath.lineTo(12.6f, 59.4f);
                instancePath.lineTo(59.4f, 59.4f);
                instancePath.lineTo(59.4f, 12.6f);
                instancePath.lineTo(12.6f, 12.6f);
                instancePath.close();
                instancePath.moveTo(12.0f, 9.0f);
                instancePath.lineTo(60.0f, 9.0f);
                instancePath.cubicTo(61.656853f, 9.0f, 63.0f, 10.343145f, 63.0f, 12.0f);
                instancePath.lineTo(63.0f, 60.0f);
                instancePath.cubicTo(63.0f, 61.656853f, 61.656853f, 63.0f, 60.0f, 63.0f);
                instancePath.lineTo(12.0f, 63.0f);
                instancePath.cubicTo(10.343145f, 63.0f, 9.0f, 61.656853f, 9.0f, 60.0f);
                instancePath.lineTo(9.0f, 12.0f);
                instancePath.cubicTo(9.0f, 10.343145f, 10.343145f, 9.0f, 12.0f, 9.0f);
                instancePath.close();
                instancePath.moveTo(50.28695f, 50.4f);
                instancePath.cubicTo(50.238693f, 50.314686f, 50.19275f, 50.238598f, 50.190292f, 50.23709f);
                instancePath.lineTo(39.923733f, 44.741676f);
                instancePath.cubicTo(36.319508f, 42.88591f, 35.44312f, 38.468994f, 37.965595f, 35.312737f);
                instancePath.lineTo(38.650604f, 34.455616f);
                instancePath.cubicTo(39.34484f, 33.58695f, 39.978947f, 31.234459f, 39.978947f, 29.420372f);
                instancePath.lineTo(39.978947f, 26.000416f);
                instancePath.cubicTo(39.978947f, 23.530258f, 38.151016f, 21.6f, 36.0f, 21.6f);
                instancePath.cubicTo(33.852142f, 21.6f, 32.021053f, 23.531115f, 32.021053f, 25.99916f);
                instancePath.lineTo(32.021053f, 29.418581f);
                instancePath.cubicTo(32.021053f, 31.17479f, 32.689404f, 33.54674f, 33.41562f, 34.455296f);
                instancePath.lineTo(34.100628f, 35.312298f);
                instancePath.cubicTo(36.628113f, 38.47439f, 35.74206f, 42.887615f, 32.184887f, 44.719566f);
                instancePath.lineTo(21.759434f, 50.263042f);
                instancePath.cubicTo(21.781796f, 50.251522f, 21.750141f, 50.319286f, 21.7093f, 50.4f);
                instancePath.lineTo(50.28695f, 50.4f);
                instancePath.close();
                instancePath.moveTo(18.0f, 50.630928f);
                instancePath.cubicTo(18.0f, 49.26075f, 18.943865f, 47.663815f, 20.110922f, 47.062664f);
                instancePath.lineTo(30.494669f, 41.54102f);
                instancePath.cubicTo(32.050106f, 40.739815f, 32.411777f, 38.96526f, 31.288553f, 37.560013f);
                instancePath.lineTo(30.603544f, 36.70301f);
                instancePath.cubicTo(29.209784f, 34.959305f, 28.421053f, 31.698994f, 28.421053f, 29.418581f);
                instancePath.lineTo(28.421053f, 25.99916f);
                instancePath.cubicTo(28.421053f, 21.581347f, 31.82278f, 18.0f, 36.0f, 18.0f);
                instancePath.cubicTo(40.185738f, 18.0f, 43.57895f, 21.58596f, 43.57895f, 26.000416f);
                instancePath.lineTo(43.57895f, 29.420372f);
                instancePath.cubicTo(43.57895f, 31.698591f, 42.85138f, 34.96572f, 41.46283f, 36.703148f);
                instancePath.lineTo(40.77782f, 37.560265f);
                instancePath.cubicTo(39.66083f, 38.9579f, 40.009758f, 40.736794f, 41.571705f, 41.54102f);
                instancePath.lineTo(51.889076f, 47.063114f);
                instancePath.cubicTo(53.05491f, 47.663383f, 54.0f, 49.25034f, 54.0f, 50.630928f);
                instancePath.lineTo(54.0f, 52.105263f);
                instancePath.cubicTo(54.0f, 53.1517f, 53.1517f, 54.0f, 52.105263f, 54.0f);
                instancePath.lineTo(19.894737f, 54.0f);
                instancePath.cubicTo(18.848303f, 54.0f, 18.0f, 53.1517f, 18.0f, 52.105263f);
                instancePath.lineTo(18.0f, 50.630928f);
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
