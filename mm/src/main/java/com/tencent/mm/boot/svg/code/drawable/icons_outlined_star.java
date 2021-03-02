package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_star extends c {
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
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint4.setStrokeWidth(1.125f);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(3.5625f, 6.5625f);
                instancePath.cubicTo(3.5625f, 4.9056454f, 4.9056454f, 3.5625f, 6.5625f, 3.5625f);
                instancePath.lineTo(17.4375f, 3.5625f);
                instancePath.cubicTo(19.094355f, 3.5625f, 20.4375f, 4.9056454f, 20.4375f, 6.5625f);
                instancePath.lineTo(20.4375f, 17.4375f);
                instancePath.cubicTo(20.4375f, 19.094355f, 19.094355f, 20.4375f, 17.4375f, 20.4375f);
                instancePath.lineTo(6.5625f, 20.4375f);
                instancePath.cubicTo(4.9056454f, 20.4375f, 3.5625f, 19.094355f, 3.5625f, 17.4375f);
                instancePath.lineTo(3.5625f, 6.5625f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(12.0000105f, 15.584204f);
                instancePath2.lineTo(9.245821f, 17.032167f);
                instancePath2.cubicTo(8.957653f, 17.183666f, 8.601233f, 17.072874f, 8.449733f, 16.784706f);
                instancePath2.cubicTo(8.389405f, 16.669954f, 8.3685875f, 16.538517f, 8.390503f, 16.410742f);
                instancePath2.lineTo(8.916507f, 13.343907f);
                instancePath2.lineTo(6.6883206f, 11.171963f);
                instancePath2.cubicTo(6.455188f, 10.944715f, 6.4504175f, 10.571502f, 6.6776657f, 10.338368f);
                instancePath2.cubicTo(6.7681575f, 10.245533f, 6.886729f, 10.185119f, 7.015023f, 10.166476f);
                instancePath2.lineTo(10.0943f, 9.719031f);
                instancePath2.lineTo(11.471395f, 6.928733f);
                instancePath2.cubicTo(11.6154785f, 6.6367865f, 11.968951f, 6.51692f, 12.260898f, 6.6610045f);
                instancePath2.cubicTo(12.377152f, 6.7183795f, 12.4712515f, 6.812478f, 12.528626f, 6.928733f);
                instancePath2.lineTo(13.905721f, 9.719031f);
                instancePath2.lineTo(16.984997f, 10.166476f);
                instancePath2.cubicTo(17.30718f, 10.213292f, 17.530409f, 10.5124235f, 17.483593f, 10.834606f);
                instancePath2.cubicTo(17.46495f, 10.9629f, 17.404535f, 11.081471f, 17.3117f, 11.171963f);
                instancePath2.lineTo(15.083514f, 13.343907f);
                instancePath2.lineTo(15.609518f, 16.410742f);
                instancePath2.cubicTo(15.664553f, 16.731623f, 15.449043f, 17.036362f, 15.128163f, 17.091396f);
                instancePath2.cubicTo(15.000386f, 17.113312f, 14.86895f, 17.092495f, 14.754199f, 17.032167f);
                instancePath2.lineTo(12.0000105f, 15.584204f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
