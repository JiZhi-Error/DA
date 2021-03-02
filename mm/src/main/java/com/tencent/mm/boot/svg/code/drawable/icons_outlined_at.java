package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_at extends c {
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
                instancePath.moveTo(33.808594f, 24.5625f);
                instancePath.cubicTo(28.710938f, 24.5625f, 25.40625f, 28.886719f, 25.40625f, 35.53125f);
                instancePath.cubicTo(25.40625f, 42.140625f, 28.675781f, 46.429688f, 33.773438f, 46.429688f);
                instancePath.cubicTo(38.976562f, 46.429688f, 42.316406f, 42.070312f, 42.316406f, 35.35547f);
                instancePath.cubicTo(42.316406f, 28.746094f, 39.046875f, 24.5625f, 33.808594f, 24.5625f);
                instancePath.close();
                instancePath.moveTo(34.933594f, 6.0f);
                instancePath.cubicTo(50.339474f, 6.0f, 63.058594f, 16.582031f, 63.058594f, 32.15625f);
                instancePath.cubicTo(63.058594f, 43.335938f, 58.41797f, 50.507812f, 50.683594f, 50.507812f);
                instancePath.cubicTo(46.5f, 50.507812f, 43.195312f, 47.976562f, 42.66797f, 44.039062f);
                instancePath.lineTo(42.421875f, 44.039062f);
                instancePath.cubicTo(40.839844f, 48.046875f, 37.570312f, 50.26172f, 33.210938f, 50.26172f);
                instancePath.cubicTo(25.96875f, 50.26172f, 21.046875f, 44.285156f, 21.046875f, 35.42578f);
                instancePath.cubicTo(21.046875f, 26.777344f, 26.039062f, 20.800781f, 33.210938f, 20.800781f);
                instancePath.cubicTo(37.289062f, 20.800781f, 40.839844f, 23.015625f, 42.140625f, 26.460938f);
                instancePath.lineTo(42.38672f, 26.460938f);
                instancePath.lineTo(42.38672f, 21.503906f);
                instancePath.lineTo(46.464844f, 21.503906f);
                instancePath.lineTo(46.464844f, 41.61328f);
                instancePath.cubicTo(46.464844f, 44.8125f, 48.152344f, 46.921875f, 51.351562f, 46.921875f);
                instancePath.cubicTo(56.027344f, 46.921875f, 59.226562f, 41.54297f, 59.226562f, 32.085938f);
                instancePath.cubicTo(59.226562f, 18.65625f, 48.71459f, 9.527114f, 34.933594f, 9.527114f);
                instancePath.cubicTo(21.1526f, 9.527114f, 9.8671875f, 19.576914f, 9.8671875f, 35.320312f);
                instancePath.cubicTo(9.8671875f, 49.944553f, 21.909554f, 61.089844f, 35.320312f, 61.089844f);
                instancePath.cubicTo(40.066406f, 61.089844f, 44.601562f, 60.492188f, 46.992188f, 59.54297f);
                instancePath.lineTo(46.992188f, 63.023438f);
                instancePath.cubicTo(44.14453f, 64.00781f, 39.996094f, 64.57031f, 35.285156f, 64.57031f);
                instancePath.cubicTo(18.59385f, 64.57031f, 6.0f, 51.976818f, 6.0f, 35.179688f);
                instancePath.cubicTo(6.0f, 18.382557f, 19.527716f, 6.0f, 34.933594f, 6.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
