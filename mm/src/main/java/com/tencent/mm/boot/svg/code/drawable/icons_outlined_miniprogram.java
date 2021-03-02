package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_miniprogram extends c {
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
                instancePath.moveTo(36.0f, 66.0f);
                instancePath.cubicTo(19.431458f, 66.0f, 6.0f, 52.568542f, 6.0f, 36.0f);
                instancePath.cubicTo(6.0f, 19.431458f, 19.431458f, 6.0f, 36.0f, 6.0f);
                instancePath.cubicTo(52.568542f, 6.0f, 66.0f, 19.431458f, 66.0f, 36.0f);
                instancePath.cubicTo(66.0f, 52.568542f, 52.568542f, 66.0f, 36.0f, 66.0f);
                instancePath.close();
                instancePath.moveTo(36.0f, 62.4f);
                instancePath.cubicTo(50.58032f, 62.4f, 62.4f, 50.58032f, 62.4f, 36.0f);
                instancePath.cubicTo(62.4f, 21.419683f, 50.58032f, 9.6f, 36.0f, 9.6f);
                instancePath.cubicTo(21.419683f, 9.6f, 9.6f, 21.419683f, 9.6f, 36.0f);
                instancePath.cubicTo(9.6f, 50.58032f, 21.419683f, 62.4f, 36.0f, 62.4f);
                instancePath.close();
                instancePath.moveTo(45.43322f, 37.56829f);
                instancePath.lineTo(45.01818f, 37.572727f);
                instancePath.cubicTo(43.807514f, 37.572727f, 43.1058f, 36.723286f, 43.56062f, 35.700005f);
                instancePath.cubicTo(43.882267f, 34.949493f, 44.61438f, 34.358173f, 45.493244f, 34.16292f);
                instancePath.cubicTo(48.049187f, 33.545967f, 49.80909f, 31.53819f, 49.80909f, 29.181818f);
                instancePath.cubicTo(49.80909f, 26.344769f, 47.118664f, 24.027273f, 43.745453f, 24.027273f);
                instancePath.cubicTo(40.372242f, 24.027273f, 37.681816f, 26.344769f, 37.681816f, 29.181818f);
                instancePath.lineTo(37.681816f, 42.81818f);
                instancePath.cubicTo(37.681816f, 47.521393f, 33.467216f, 51.3f, 28.290909f, 51.3f);
                instancePath.cubicTo(23.1146f, 51.3f, 18.9f, 47.521393f, 18.9f, 42.81818f);
                instancePath.cubicTo(18.9f, 38.697357f, 22.159544f, 35.184917f, 26.563635f, 34.51818f);
                instancePath.lineTo(26.92727f, 34.51818f);
                instancePath.cubicTo(27.858202f, 34.51818f, 28.499998f, 35.058643f, 28.499998f, 35.81818f);
                instancePath.cubicTo(28.500383f, 35.950336f, 28.497911f, 36.01463f, 28.484554f, 36.094772f);
                instancePath.cubicTo(28.46752f, 36.19698f, 28.434095f, 36.293537f, 28.384832f, 36.390903f);
                instancePath.cubicTo(28.079563f, 37.1032f, 27.287638f, 37.719143f, 26.45221f, 37.92799f);
                instancePath.cubicTo(23.910059f, 38.54161f, 22.136362f, 40.540142f, 22.136362f, 42.81818f);
                instancePath.cubicTo(22.136362f, 45.65523f, 24.82679f, 47.97273f, 28.199999f, 47.97273f);
                instancePath.cubicTo(31.573208f, 47.97273f, 34.263634f, 45.65523f, 34.263634f, 42.81818f);
                instancePath.lineTo(34.263634f, 29.181818f);
                instancePath.cubicTo(34.263634f, 24.478607f, 38.478237f, 20.7f, 43.654545f, 20.7f);
                instancePath.cubicTo(48.830853f, 20.7f, 53.045452f, 24.478607f, 53.045452f, 29.181818f);
                instancePath.cubicTo(53.045452f, 33.34714f, 49.839336f, 36.80201f, 45.43322f, 37.56829f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
