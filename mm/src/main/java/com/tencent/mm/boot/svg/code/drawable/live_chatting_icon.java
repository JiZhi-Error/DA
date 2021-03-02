package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class live_chatting_icon extends c {
    private final int height = 20;
    private final int width = 20;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 20;
            case 1:
                return 20;
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
                instancePaint5.setStrokeWidth(1.6f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.8f, 0.8f);
                instancePath.lineTo(19.199999f, 0.8f);
                instancePath.lineTo(19.199999f, 19.199999f);
                instancePath.lineTo(0.8f, 19.199999f);
                instancePath.lineTo(0.8f, 0.8f);
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
                instancePath2.moveTo(12.384966f, 3.75f);
                instancePath2.cubicTo(14.1527195f, 3.75f, 14.80184f, 3.9356513f, 15.4536915f, 4.2842655f);
                instancePath2.cubicTo(16.105543f, 4.6328797f, 16.61712f, 5.144457f, 16.965734f, 5.7963085f);
                instancePath2.cubicTo(17.314348f, 6.4481606f, 17.5f, 7.09728f, 17.5f, 8.865034f);
                instancePath2.lineTo(17.5f, 11.134966f);
                instancePath2.cubicTo(17.5f, 12.9027195f, 17.314348f, 13.55184f, 16.965734f, 14.2036915f);
                instancePath2.cubicTo(16.61712f, 14.855543f, 16.105543f, 15.367121f, 15.4536915f, 15.7157345f);
                instancePath2.cubicTo(14.80184f, 16.064348f, 14.1527195f, 16.25f, 12.384966f, 16.25f);
                instancePath2.lineTo(7.6150336f, 16.25f);
                instancePath2.cubicTo(5.84728f, 16.25f, 5.1981606f, 16.064348f, 4.5463085f, 15.7157345f);
                instancePath2.cubicTo(3.8944566f, 15.367121f, 3.3828795f, 14.855543f, 3.0342655f, 14.2036915f);
                instancePath2.cubicTo(2.6856513f, 13.55184f, 2.5f, 12.9027195f, 2.5f, 11.134966f);
                instancePath2.lineTo(2.5f, 8.865034f);
                instancePath2.cubicTo(2.5f, 7.09728f, 2.6856513f, 6.4481606f, 3.0342655f, 5.7963085f);
                instancePath2.cubicTo(3.3828795f, 5.144457f, 3.8944566f, 4.6328797f, 4.5463085f, 4.2842655f);
                instancePath2.cubicTo(5.1981606f, 3.9356513f, 5.84728f, 3.75f, 7.6150336f, 3.75f);
                instancePath2.lineTo(12.384966f, 3.75f);
                instancePath2.close();
                instancePath2.moveTo(9.003333f, 6.6f);
                instancePath2.cubicTo(8.727191f, 6.6f, 8.503333f, 6.823858f, 8.503333f, 7.1f);
                instancePath2.lineTo(8.503333f, 7.1f);
                instancePath2.lineTo(8.503333f, 12.9f);
                instancePath2.cubicTo(8.503333f, 13.176143f, 8.727191f, 13.4f, 9.003333f, 13.4f);
                instancePath2.cubicTo(9.279476f, 13.4f, 9.503333f, 13.176143f, 9.503333f, 12.9f);
                instancePath2.lineTo(9.503333f, 12.9f);
                instancePath2.lineTo(9.503333f, 7.1f);
                instancePath2.cubicTo(9.503333f, 6.823858f, 9.279476f, 6.6f, 9.003333f, 6.6f);
                instancePath2.close();
                instancePath2.moveTo(13.003333f, 8.0f);
                instancePath2.cubicTo(12.727191f, 8.0f, 12.503333f, 8.223858f, 12.503333f, 8.5f);
                instancePath2.lineTo(12.503333f, 8.5f);
                instancePath2.lineTo(12.503333f, 11.5f);
                instancePath2.cubicTo(12.503333f, 11.776142f, 12.727191f, 12.0f, 13.003333f, 12.0f);
                instancePath2.cubicTo(13.279476f, 12.0f, 13.503333f, 11.776142f, 13.503333f, 11.5f);
                instancePath2.lineTo(13.503333f, 11.5f);
                instancePath2.lineTo(13.503333f, 8.5f);
                instancePath2.cubicTo(13.503333f, 8.223858f, 13.279476f, 8.0f, 13.003333f, 8.0f);
                instancePath2.close();
                instancePath2.moveTo(7.003333f, 8.0f);
                instancePath2.cubicTo(6.727191f, 8.0f, 6.503333f, 8.223858f, 6.503333f, 8.5f);
                instancePath2.lineTo(6.503333f, 8.5f);
                instancePath2.lineTo(6.503333f, 11.5f);
                instancePath2.cubicTo(6.503333f, 11.776142f, 6.727191f, 12.0f, 7.003333f, 12.0f);
                instancePath2.cubicTo(7.2794757f, 12.0f, 7.503333f, 11.776142f, 7.503333f, 11.5f);
                instancePath2.lineTo(7.503333f, 11.5f);
                instancePath2.lineTo(7.503333f, 8.5f);
                instancePath2.cubicTo(7.503333f, 8.223858f, 7.2794757f, 8.0f, 7.003333f, 8.0f);
                instancePath2.close();
                instancePath2.moveTo(11.003333f, 8.5f);
                instancePath2.cubicTo(10.727191f, 8.5f, 10.503333f, 8.723858f, 10.503333f, 9.0f);
                instancePath2.lineTo(10.503333f, 9.0f);
                instancePath2.lineTo(10.503333f, 11.0f);
                instancePath2.cubicTo(10.503333f, 11.276142f, 10.727191f, 11.5f, 11.003333f, 11.5f);
                instancePath2.cubicTo(11.279476f, 11.5f, 11.503333f, 11.276142f, 11.503333f, 11.0f);
                instancePath2.lineTo(11.503333f, 11.0f);
                instancePath2.lineTo(11.503333f, 9.0f);
                instancePath2.cubicTo(11.503333f, 8.723858f, 11.279476f, 8.5f, 11.003333f, 8.5f);
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
