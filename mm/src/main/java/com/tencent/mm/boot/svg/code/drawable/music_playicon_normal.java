package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class music_playicon_normal extends c {
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
                instancePaint3.setColor(419430400);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(36.0f, 1.5f);
                instancePath.cubicTo(55.053825f, 1.5f, 70.5f, 16.946175f, 70.5f, 36.0f);
                instancePath.cubicTo(70.5f, 55.053825f, 55.053825f, 70.5f, 36.0f, 70.5f);
                instancePath.cubicTo(16.946175f, 70.5f, 1.5f, 55.053825f, 1.5f, 36.0f);
                instancePath.cubicTo(1.5f, 16.946175f, 16.946175f, 1.5f, 36.0f, 1.5f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(36.0f, 72.0f);
                instancePath2.cubicTo(55.88225f, 72.0f, 72.0f, 55.88225f, 72.0f, 36.0f);
                instancePath2.cubicTo(72.0f, 16.117748f, 55.88225f, 0.0f, 36.0f, 0.0f);
                instancePath2.cubicTo(16.117748f, 0.0f, 0.0f, 16.117748f, 0.0f, 36.0f);
                instancePath2.cubicTo(0.0f, 55.88225f, 16.117748f, 72.0f, 36.0f, 72.0f);
                instancePath2.close();
                instancePath2.moveTo(36.0f, 67.5f);
                instancePath2.cubicTo(53.39697f, 67.5f, 67.5f, 53.39697f, 67.5f, 36.0f);
                instancePath2.cubicTo(67.5f, 18.603031f, 53.39697f, 4.5f, 36.0f, 4.5f);
                instancePath2.cubicTo(18.603031f, 4.5f, 4.5f, 18.603031f, 4.5f, 36.0f);
                instancePath2.cubicTo(4.5f, 53.39697f, 18.603031f, 67.5f, 36.0f, 67.5f);
                instancePath2.close();
                instancePath2.moveTo(27.0f, 48.223015f);
                instancePath2.cubicTo(27.0f, 49.87877f, 28.177517f, 50.57029f, 29.625708f, 49.769974f);
                instancePath2.lineTo(51.37429f, 37.75102f);
                instancePath2.cubicTo(52.82443f, 36.949627f, 52.822483f, 35.64924f, 51.37429f, 34.848923f);
                instancePath2.lineTo(29.625708f, 22.829967f);
                instancePath2.cubicTo(28.17557f, 22.028574f, 27.0f, 22.719145f, 27.0f, 24.376926f);
                instancePath2.lineTo(27.0f, 48.223015f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
