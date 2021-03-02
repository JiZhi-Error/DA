package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_tipsbar_logo extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.saveLayerAlpha(null, 204, 31);
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-2565928);
                instancePaint5.setColor(-6842473);
                instancePaint5.setStrokeWidth(1.2f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.6f, 0.6f);
                instancePath.lineTo(23.4f, 0.6f);
                instancePath.lineTo(23.4f, 23.4f);
                instancePath.lineTo(0.6f, 23.4f);
                instancePath.lineTo(0.6f, 0.6f);
                instancePath.close();
                canvas.saveLayerAlpha(null, 0, 31);
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Paint instancePaint7 = c.instancePaint(instancePaint5, looper);
                canvas.drawPath(instancePath, instancePaint6);
                canvas.drawPath(instancePath, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint, looper);
                instancePaint8.setColor(-10197008);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(17.154173f, 4.5f);
                instancePath2.cubicTo(18.49145f, 4.5f, 18.97638f, 4.6392384f, 19.46527f, 4.900699f);
                instancePath2.cubicTo(19.954157f, 5.16216f, 20.337841f, 5.5458426f, 20.5993f, 6.0347314f);
                instancePath2.cubicTo(20.860762f, 6.52362f, 21.0f, 7.0085497f, 21.0f, 8.345828f);
                instancePath2.lineTo(21.0f, 15.654172f);
                instancePath2.cubicTo(21.0f, 16.99145f, 20.860762f, 17.47638f, 20.5993f, 17.96527f);
                instancePath2.cubicTo(20.337841f, 18.454157f, 19.954157f, 18.837841f, 19.46527f, 19.0993f);
                instancePath2.cubicTo(18.97638f, 19.360762f, 18.49145f, 19.5f, 17.154173f, 19.5f);
                instancePath2.lineTo(6.8458276f, 19.5f);
                instancePath2.cubicTo(5.5085497f, 19.5f, 5.02362f, 19.360762f, 4.5347314f, 19.0993f);
                instancePath2.cubicTo(4.0458426f, 18.837841f, 3.6621597f, 18.454157f, 3.4006991f, 17.96527f);
                instancePath2.cubicTo(3.1392384f, 17.47638f, 3.0f, 16.99145f, 3.0f, 15.654172f);
                instancePath2.lineTo(3.0f, 8.345828f);
                instancePath2.cubicTo(3.0f, 7.0085497f, 3.1392384f, 6.52362f, 3.4006991f, 6.0347314f);
                instancePath2.cubicTo(3.6621597f, 5.5458426f, 4.0458426f, 5.16216f, 4.5347314f, 4.900699f);
                instancePath2.cubicTo(5.02362f, 4.6392384f, 5.5085497f, 4.5f, 6.8458276f, 4.5f);
                instancePath2.lineTo(17.154173f, 4.5f);
                instancePath2.close();
                instancePath2.moveTo(10.804f, 7.92f);
                instancePath2.cubicTo(10.47263f, 7.92f, 10.204f, 8.188629f, 10.204f, 8.52f);
                instancePath2.lineTo(10.204f, 8.52f);
                instancePath2.lineTo(10.204f, 15.48f);
                instancePath2.cubicTo(10.204f, 15.811371f, 10.47263f, 16.08f, 10.804f, 16.08f);
                instancePath2.cubicTo(11.135371f, 16.08f, 11.404f, 15.811371f, 11.404f, 15.48f);
                instancePath2.lineTo(11.404f, 15.48f);
                instancePath2.lineTo(11.404f, 8.52f);
                instancePath2.cubicTo(11.404f, 8.188629f, 11.135371f, 7.92f, 10.804f, 7.92f);
                instancePath2.close();
                instancePath2.moveTo(15.604f, 9.6f);
                instancePath2.cubicTo(15.272629f, 9.6f, 15.004f, 9.868629f, 15.004f, 10.2f);
                instancePath2.lineTo(15.004f, 10.2f);
                instancePath2.lineTo(15.004f, 13.8f);
                instancePath2.cubicTo(15.004f, 14.131371f, 15.272629f, 14.4f, 15.604f, 14.4f);
                instancePath2.cubicTo(15.93537f, 14.4f, 16.204f, 14.131371f, 16.204f, 13.8f);
                instancePath2.lineTo(16.204f, 13.8f);
                instancePath2.lineTo(16.204f, 10.2f);
                instancePath2.cubicTo(16.204f, 9.868629f, 15.93537f, 9.6f, 15.604f, 9.6f);
                instancePath2.close();
                instancePath2.moveTo(8.404f, 9.6f);
                instancePath2.cubicTo(8.072629f, 9.6f, 7.804f, 9.868629f, 7.804f, 10.2f);
                instancePath2.lineTo(7.804f, 10.2f);
                instancePath2.lineTo(7.804f, 13.8f);
                instancePath2.cubicTo(7.804f, 14.131371f, 8.072629f, 14.4f, 8.404f, 14.4f);
                instancePath2.cubicTo(8.735371f, 14.4f, 9.004f, 14.131371f, 9.004f, 13.8f);
                instancePath2.lineTo(9.004f, 13.8f);
                instancePath2.lineTo(9.004f, 10.2f);
                instancePath2.cubicTo(9.004f, 9.868629f, 8.735371f, 9.6f, 8.404f, 9.6f);
                instancePath2.close();
                instancePath2.moveTo(13.204f, 10.2f);
                instancePath2.cubicTo(12.872629f, 10.2f, 12.604f, 10.468629f, 12.604f, 10.8f);
                instancePath2.lineTo(12.604f, 10.8f);
                instancePath2.lineTo(12.604f, 13.2f);
                instancePath2.cubicTo(12.604f, 13.531371f, 12.872629f, 13.8f, 13.204f, 13.8f);
                instancePath2.cubicTo(13.535371f, 13.8f, 13.804f, 13.531371f, 13.804f, 13.2f);
                instancePath2.lineTo(13.804f, 13.2f);
                instancePath2.lineTo(13.804f, 10.8f);
                instancePath2.cubicTo(13.804f, 10.468629f, 13.535371f, 10.2f, 13.204f, 10.2f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint8);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
