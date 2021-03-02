package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_transfer extends c {
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(27.400084f, 25.5f);
                instancePath.lineTo(61.5f, 25.5f);
                instancePath.lineTo(61.5f, 31.5f);
                instancePath.lineTo(10.98074f, 31.5f);
                instancePath.cubicTo(10.152312f, 31.5f, 9.48074f, 30.828426f, 9.48074f, 30.0f);
                instancePath.cubicTo(9.48074f, 29.529905f, 9.701123f, 29.086998f, 10.076107f, 28.80349f);
                instancePath.lineTo(28.434875f, 14.923178f);
                instancePath.cubicTo(28.963528f, 14.523485f, 29.716099f, 14.628028f, 30.115791f, 15.15668f);
                instancePath.cubicTo(30.349678f, 15.466031f, 30.419645f, 15.869344f, 30.30362f, 16.239397f);
                instancePath.lineTo(27.400084f, 25.5f);
                instancePath.close();
                instancePath.moveTo(44.596638f, 46.5f);
                instancePath.lineTo(10.5f, 46.5f);
                instancePath.lineTo(10.5f, 40.5f);
                instancePath.lineTo(56.996723f, 40.5f);
                instancePath.lineTo(61.015984f, 40.5f);
                instancePath.cubicTo(61.84441f, 40.5f, 62.515984f, 41.171574f, 62.515984f, 42.0f);
                instancePath.cubicTo(62.515984f, 42.470097f, 62.295597f, 42.913002f, 61.920616f, 43.19651f);
                instancePath.lineTo(43.561848f, 57.076824f);
                instancePath.cubicTo(43.033195f, 57.476513f, 42.280624f, 57.37197f, 41.88093f, 56.84332f);
                instancePath.cubicTo(41.647045f, 56.53397f, 41.577076f, 56.130657f, 41.693104f, 55.7606f);
                instancePath.lineTo(44.596638f, 46.5f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
