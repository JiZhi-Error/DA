package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class voip_cs_hangup extends c {
    private final int height = 210;
    private final int width = 210;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 210;
            case 1:
                return 210;
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
                instancePaint3.setColor(-2471350);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(105.0f, 0.0f);
                instancePath.cubicTo(162.9899f, 0.0f, 210.0f, 47.010098f, 210.0f, 105.0f);
                instancePath.cubicTo(210.0f, 162.9899f, 162.9899f, 210.0f, 105.0f, 210.0f);
                instancePath.cubicTo(47.010098f, 210.0f, 0.0f, 162.9899f, 0.0f, 105.0f);
                instancePath.cubicTo(0.0f, 47.010098f, 47.010098f, 0.0f, 105.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(105.0f, 96.46164f);
                instancePath2.cubicTo(93.324905f, 96.46164f, 85.05575f, 99.22135f, 83.17065f, 101.40075f);
                instancePath2.cubicTo(81.28554f, 103.58014f, 79.694786f, 112.07398f, 77.24351f, 114.4038f);
                instancePath2.cubicTo(76.0654f, 115.52354f, 63.405796f, 117.93891f, 61.901104f, 118.25871f);
                instancePath2.cubicTo(60.39641f, 118.578514f, 58.85897f, 118.73449f, 58.145496f, 117.714584f);
                instancePath2.cubicTo(57.432022f, 116.69469f, 51.136547f, 103.91579f, 60.94151f, 96.85904f);
                instancePath2.cubicTo(70.746475f, 89.8023f, 91.694466f, 87.15565f, 105.0f, 87.0f);
                instancePath2.lineTo(105.0f, 96.46164f);
                instancePath2.close();
                instancePath2.moveTo(105.0f, 96.46164f);
                instancePath2.cubicTo(116.675095f, 96.46164f, 124.94425f, 99.22135f, 126.82935f, 101.40075f);
                instancePath2.cubicTo(128.71446f, 103.58014f, 130.30522f, 112.07398f, 132.7565f, 114.4038f);
                instancePath2.cubicTo(133.9346f, 115.52354f, 146.59421f, 117.93891f, 148.09889f, 118.25871f);
                instancePath2.cubicTo(149.60359f, 118.578514f, 151.14102f, 118.73449f, 151.8545f, 117.714584f);
                instancePath2.cubicTo(152.56798f, 116.69469f, 158.86345f, 103.91579f, 149.05849f, 96.85904f);
                instancePath2.cubicTo(139.25352f, 89.8023f, 118.305534f, 87.15565f, 105.0f, 87.0f);
                instancePath2.lineTo(105.0f, 96.46164f);
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
