package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class default_medianote extends c {
    private final int height = 192;
    private final int width = 192;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 192;
            case 1:
                return 192;
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
                instancePaint3.setColor(-12206054);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(192.0f, 0.0f);
                instancePath.lineTo(192.0f, 192.0f);
                instancePath.lineTo(0.0f, 192.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(48.727272f, 129.13744f);
                instancePath2.lineTo(48.727272f, 155.09727f);
                instancePath2.cubicTo(48.727272f, 156.19832f, 49.616333f, 157.09091f, 50.73237f, 157.09091f);
                instancePath2.lineTo(142.72218f, 157.09091f);
                instancePath2.cubicTo(143.82956f, 157.09091f, 144.72728f, 156.19485f, 144.72728f, 155.09727f);
                instancePath2.lineTo(144.72728f, 36.90273f);
                instancePath2.cubicTo(144.72728f, 35.801674f, 143.83821f, 34.909092f, 142.72218f, 34.909092f);
                instancePath2.lineTo(50.73237f, 34.909092f);
                instancePath2.cubicTo(49.624985f, 34.909092f, 48.727272f, 35.805138f, 48.727272f, 36.90273f);
                instancePath2.lineTo(48.727272f, 59.685844f);
                instancePath2.lineTo(48.727272f, 59.685844f);
                instancePath2.cubicTo(49.192173f, 59.566185f, 49.679565f, 59.502544f, 50.18182f, 59.502544f);
                instancePath2.cubicTo(53.39511f, 59.502544f, 56.0f, 62.107433f, 56.0f, 65.320724f);
                instancePath2.cubicTo(56.0f, 68.53402f, 53.39511f, 71.13891f, 50.18182f, 71.13891f);
                instancePath2.cubicTo(49.679565f, 71.13891f, 49.192173f, 71.07527f, 48.727272f, 70.95561f);
                instancePath2.lineTo(48.727272f, 117.86766f);
                instancePath2.cubicTo(49.192173f, 117.748f, 49.679565f, 117.684364f, 50.18182f, 117.684364f);
                instancePath2.cubicTo(53.39511f, 117.684364f, 56.0f, 120.28925f, 56.0f, 123.50255f);
                instancePath2.cubicTo(56.0f, 126.715836f, 53.39511f, 129.32072f, 50.18182f, 129.32072f);
                instancePath2.cubicTo(49.679565f, 129.32072f, 49.192173f, 129.25708f, 48.727272f, 129.13744f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-12206054);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(114.181816f, 93.09091f);
                instancePath3.lineTo(117.09091f, 93.09091f);
                instancePath3.lineTo(117.09091f, 99.47164f);
                instancePath3.cubicTo(117.09091f, 109.60416f, 108.62502f, 117.818184f, 98.181816f, 117.818184f);
                instancePath3.cubicTo(87.73862f, 117.818184f, 79.27273f, 109.60416f, 79.27273f, 99.47164f);
                instancePath3.lineTo(79.27273f, 93.09091f);
                instancePath3.lineTo(82.181816f, 93.09091f);
                instancePath3.lineTo(82.181816f, 98.911415f);
                instancePath3.cubicTo(82.181816f, 107.74669f, 89.34526f, 114.90909f, 98.181816f, 114.90909f);
                instancePath3.cubicTo(107.01837f, 114.90909f, 114.181816f, 107.74669f, 114.181816f, 98.911415f);
                instancePath3.lineTo(114.181816f, 93.09091f);
                instancePath3.lineTo(114.181816f, 93.09091f);
                instancePath3.close();
                instancePath3.moveTo(96.72727f, 117.818184f);
                instancePath3.lineTo(99.63636f, 117.818184f);
                instancePath3.lineTo(99.63636f, 122.181816f);
                instancePath3.lineTo(96.72727f, 122.181816f);
                instancePath3.lineTo(96.72727f, 117.818184f);
                instancePath3.close();
                instancePath3.moveTo(87.545456f, 122.181816f);
                instancePath3.cubicTo(86.99317f, 122.181816f, 86.545456f, 122.63637f, 86.545456f, 123.18296f);
                instancePath3.lineTo(86.545456f, 124.08977f);
                instancePath3.cubicTo(86.545456f, 124.642685f, 86.98958f, 125.09091f, 87.545456f, 125.09091f);
                instancePath3.lineTo(108.818184f, 125.09091f);
                instancePath3.cubicTo(109.37047f, 125.09091f, 109.818184f, 124.63637f, 109.818184f, 124.08977f);
                instancePath3.lineTo(109.818184f, 123.18296f);
                instancePath3.cubicTo(109.818184f, 122.63004f, 109.37406f, 122.181816f, 108.818184f, 122.181816f);
                instancePath3.lineTo(87.545456f, 122.181816f);
                instancePath3.close();
                instancePath3.moveTo(98.181816f, 66.90909f);
                instancePath3.cubicTo(91.75523f, 66.90909f, 86.545456f, 72.1185f, 86.545456f, 78.54552f);
                instancePath3.lineTo(86.545456f, 98.909035f);
                instancePath3.cubicTo(86.545456f, 105.33565f, 91.75382f, 110.545456f, 98.181816f, 110.545456f);
                instancePath3.cubicTo(104.608406f, 110.545456f, 109.818184f, 105.336044f, 109.818184f, 98.909035f);
                instancePath3.lineTo(109.818184f, 78.54552f);
                instancePath3.cubicTo(109.818184f, 72.1189f, 104.60982f, 66.90909f, 98.181816f, 66.90909f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
