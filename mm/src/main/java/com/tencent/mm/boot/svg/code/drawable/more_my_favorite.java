package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class more_my_favorite extends c {
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
                instancePaint3.setColor(-14513167);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(37.8f, 62.89739f);
                instancePath.lineTo(58.59719f, 50.765697f);
                instancePath.cubicTo(58.920998f, 50.57681f, 59.4f, 49.743988f, 59.4f, 49.37328f);
                instancePath.lineTo(59.4f, 23.856966f);
                instancePath.cubicTo(59.4f, 23.493624f, 58.91633f, 22.650715f, 58.59719f, 22.464552f);
                instancePath.lineTo(36.774937f, 9.734903f);
                instancePath.cubicTo(36.466652f, 9.555071f, 35.53348f, 9.554993f, 35.225063f, 9.734903f);
                instancePath.lineTo(13.402809f, 22.464552f);
                instancePath.cubicTo(13.079003f, 22.653439f, 12.6f, 23.48626f, 12.6f, 23.856966f);
                instancePath.lineTo(12.6f, 49.37328f);
                instancePath.cubicTo(12.6f, 49.73662f, 13.083672f, 50.579533f, 13.402809f, 50.765697f);
                instancePath.lineTo(34.2f, 62.89739f);
                instancePath.lineTo(34.2f, 36.615124f);
                instancePath.lineTo(34.5f, 36.315125f);
                instancePath.lineTo(37.5f, 36.315125f);
                instancePath.lineTo(37.8f, 36.615124f);
                instancePath.lineTo(37.8f, 62.89739f);
                instancePath.close();
                instancePath.moveTo(33.411125f, 6.6252995f);
                instancePath.cubicTo(34.840923f, 5.791252f, 37.160156f, 5.791881f, 38.588875f, 6.6252995f);
                instancePath.lineTo(60.411125f, 19.354948f);
                instancePath.cubicTo(61.840923f, 20.188995f, 63.0f, 22.21864f, 63.0f, 23.856966f);
                instancePath.lineTo(63.0f, 49.37328f);
                instancePath.cubicTo(63.0f, 51.02563f, 61.839844f, 53.04188f, 60.411125f, 53.8753f);
                instancePath.lineTo(38.588875f, 66.60495f);
                instancePath.cubicTo(37.159077f, 67.438995f, 34.839844f, 67.43836f, 33.411125f, 66.60495f);
                instancePath.lineTo(11.588874f, 53.8753f);
                instancePath.cubicTo(10.159078f, 53.041252f, 9.0f, 51.01161f, 9.0f, 49.37328f);
                instancePath.lineTo(9.0f, 23.856966f);
                instancePath.cubicTo(9.0f, 22.204617f, 10.160156f, 20.188366f, 11.588874f, 19.354948f);
                instancePath.lineTo(33.411125f, 6.6252995f);
                instancePath.close();
                instancePath.moveTo(37.009808f, 35.466084f);
                instancePath.lineTo(35.509808f, 38.064163f);
                instancePath.lineTo(35.1f, 38.17397f);
                instancePath.lineTo(10.418276f, 23.92397f);
                instancePath.lineTo(10.308469f, 23.514162f);
                instancePath.lineTo(11.808469f, 20.916086f);
                instancePath.lineTo(12.218276f, 20.806278f);
                instancePath.lineTo(36.9f, 35.05628f);
                instancePath.lineTo(37.009808f, 35.466084f);
                instancePath.close();
                instancePath.moveTo(36.490192f, 38.064163f);
                instancePath.lineTo(34.990192f, 35.466084f);
                instancePath.lineTo(35.1f, 35.05628f);
                instancePath.lineTo(59.781723f, 20.806278f);
                instancePath.lineTo(60.191532f, 20.916086f);
                instancePath.lineTo(61.691532f, 23.514162f);
                instancePath.lineTo(61.581722f, 23.92397f);
                instancePath.lineTo(36.9f, 38.17397f);
                instancePath.lineTo(36.490192f, 38.064163f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-568490);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(63.0f, 18.918291f);
                instancePath2.lineTo(63.0f, 69.882225f);
                instancePath2.lineTo(34.2f, 69.882225f);
                instancePath2.lineTo(36.00463f, 36.316406f);
                instancePath2.lineTo(36.00463f, 34.52065f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-81363);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(9.0f, 23.12807f);
                instancePath3.lineTo(34.217228f, 37.674953f);
                instancePath3.lineTo(36.008614f, 36.302216f);
                instancePath3.lineTo(37.8f, 37.674953f);
                instancePath3.lineTo(37.8f, 69.882225f);
                instancePath3.lineTo(9.0f, 69.882225f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
