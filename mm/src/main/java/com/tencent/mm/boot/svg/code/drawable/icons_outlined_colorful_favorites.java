package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_colorful_favorites extends c {
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
                instancePaint3.setColor(-14513167);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(57.05529f, 26.537308f);
                instancePath.cubicTo(57.34599f, 25.177156f, 57.580128f, 23.656338f, 57.7577f, 21.974848f);
                instancePath.lineTo(36.774937f, 9.734903f);
                instancePath.cubicTo(36.466652f, 9.555071f, 35.53348f, 9.554993f, 35.225063f, 9.734903f);
                instancePath.lineTo(14.2423f, 21.974848f);
                instancePath.lineTo(36.0f, 34.536663f);
                instancePath.cubicTo(38.0953f, 34.90591f, 40.012356f, 35.184734f, 41.751175f, 35.373142f);
                instancePath.lineTo(37.8f, 37.654354f);
                instancePath.lineTo(34.2f, 37.654354f);
                instancePath.lineTo(12.6f, 25.183588f);
                instancePath.lineTo(9.0f, 23.856966f);
                instancePath.cubicTo(9.0f, 22.204617f, 10.160156f, 20.188366f, 11.588874f, 19.354948f);
                instancePath.lineTo(33.411125f, 6.6252995f);
                instancePath.cubicTo(34.840923f, 5.791252f, 37.160156f, 5.791881f, 38.588875f, 6.6252995f);
                instancePath.lineTo(60.411125f, 19.354948f);
                instancePath.cubicTo(61.840923f, 20.188995f, 63.0f, 22.21864f, 63.0f, 23.856966f);
                instancePath.lineTo(59.4f, 25.183588f);
                instancePath.lineTo(57.05529f, 26.537308f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-568490);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(34.582882f, 62.76065f);
                instancePath2.lineTo(37.8f, 62.89739f);
                instancePath2.lineTo(58.59719f, 50.765697f);
                instancePath2.cubicTo(58.920998f, 50.57681f, 59.4f, 49.743988f, 59.4f, 49.37328f);
                instancePath2.lineTo(59.4f, 25.183588f);
                instancePath2.lineTo(37.8f, 37.654354f);
                instancePath2.lineTo(35.855362f, 39.0928f);
                instancePath2.lineTo(36.00463f, 36.316406f);
                instancePath2.lineTo(36.00463f, 34.52065f);
                instancePath2.lineTo(61.200527f, 19.958323f);
                instancePath2.cubicTo(62.244278f, 20.956034f, 63.0f, 22.53407f, 63.0f, 23.856966f);
                instancePath2.lineTo(63.0f, 49.37328f);
                instancePath2.cubicTo(63.0f, 51.02563f, 61.839844f, 53.04188f, 60.411125f, 53.8753f);
                instancePath2.lineTo(38.588875f, 66.60495f);
                instancePath2.cubicTo(37.443314f, 67.27319f, 35.726795f, 67.40563f, 34.354786f, 67.003235f);
                instancePath2.lineTo(34.582882f, 62.76065f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-81363);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(37.8f, 66.9551f);
                instancePath3.cubicTo(36.403755f, 67.4152f, 34.599426f, 67.29812f, 33.411125f, 66.60495f);
                instancePath3.lineTo(11.588874f, 53.8753f);
                instancePath3.cubicTo(10.159078f, 53.041252f, 9.0f, 51.01161f, 9.0f, 49.37328f);
                instancePath3.lineTo(9.0f, 23.856966f);
                instancePath3.cubicTo(9.0f, 23.631493f, 9.021603f, 23.399242f, 9.062542f, 23.164148f);
                instancePath3.lineTo(12.6f, 25.204777f);
                instancePath3.lineTo(12.6f, 49.37328f);
                instancePath3.cubicTo(12.6f, 49.73662f, 13.083672f, 50.579533f, 13.402809f, 50.765697f);
                instancePath3.lineTo(34.2f, 62.89739f);
                instancePath3.lineTo(34.2f, 37.665016f);
                instancePath3.lineTo(34.217228f, 37.674953f);
                instancePath3.lineTo(36.008614f, 36.302216f);
                instancePath3.lineTo(37.8f, 37.674953f);
                instancePath3.lineTo(37.8f, 66.9551f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
