package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class webview_logo_qqbrowser_light extends c {
    private final int height = 39;
    private final int width = 39;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 39;
            case 1:
                return 39;
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
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(15.911817f, 28.210007f);
                instancePath.cubicTo(12.592391f, 26.960802f, 10.230769f, 23.756193f, 10.230769f, 20.0f);
                instancePath.cubicTo(10.230769f, 15.156888f, 14.156888f, 11.230769f, 19.0f, 11.230769f);
                instancePath.cubicTo(23.843113f, 11.230769f, 27.76923f, 15.156888f, 27.76923f, 20.0f);
                instancePath.cubicTo(27.76923f, 20.19488f, 27.762875f, 20.388273f, 27.750357f, 20.579987f);
                instancePath.cubicTo(30.774906f, 21.11086f, 33.20298f, 23.374031f, 33.973866f, 26.308788f);
                instancePath.cubicTo(34.5412f, 26.484497f, 35.077324f, 26.731188f, 35.57187f, 27.038485f);
                instancePath.cubicTo(36.491306f, 24.876438f, 37.0f, 22.497625f, 37.0f, 20.0f);
                instancePath.cubicTo(37.0f, 10.058874f, 28.941126f, 2.0f, 19.0f, 2.0f);
                instancePath.cubicTo(9.058874f, 2.0f, 1.0f, 10.058874f, 1.0f, 20.0f);
                instancePath.cubicTo(1.0f, 29.941126f, 9.058874f, 38.0f, 19.0f, 38.0f);
                instancePath.cubicTo(19.099163f, 38.0f, 19.198141f, 37.9992f, 19.296925f, 37.9976f);
                instancePath.cubicTo(19.3516f, 37.999195f, 19.406475f, 38.0f, 19.461538f, 38.0f);
                instancePath.lineTo(32.384617f, 38.0f);
                instancePath.lineTo(32.384617f, 37.9793f);
                instancePath.cubicTo(34.97223f, 37.74612f, 37.0f, 35.571404f, 37.0f, 32.923077f);
                instancePath.cubicTo(37.0f, 30.269276f, 34.96384f, 28.091045f, 32.368565f, 27.865429f);
                instancePath.cubicTo(32.142185f, 24.75823f, 29.549576f, 22.307692f, 26.384615f, 22.307692f);
                instancePath.cubicTo(23.496096f, 22.307692f, 21.084314f, 24.348843f, 20.512947f, 27.067463f);
                instancePath.cubicTo(20.216953f, 26.979319f, 19.868599f, 26.929428f, 19.461538f, 26.923077f);
                instancePath.cubicTo(18.110815f, 26.923077f, 16.873026f, 27.406603f, 15.911817f, 28.210007f);
                instancePath.close();
                canvas.saveLayerAlpha(null, 76, 31);
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
