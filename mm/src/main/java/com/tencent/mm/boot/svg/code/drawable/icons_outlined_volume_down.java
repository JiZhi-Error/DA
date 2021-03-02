package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_volume_down extends c {
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
                instancePath.moveTo(36.0f, 16.23f);
                instancePath.lineTo(23.742641f, 28.48736f);
                instancePath.lineTo(9.0f, 28.48736f);
                instancePath.lineTo(9.0f, 43.48736f);
                instancePath.lineTo(23.742641f, 43.48736f);
                instancePath.lineTo(36.0f, 55.74472f);
                instancePath.lineTo(36.0f, 16.23f);
                instancePath.close();
                instancePath.moveTo(22.5f, 25.48736f);
                instancePath.lineTo(33.87868f, 14.10868f);
                instancePath.cubicTo(35.05025f, 12.937107f, 36.94975f, 12.937107f, 38.12132f, 14.10868f);
                instancePath.cubicTo(38.68393f, 14.6712885f, 39.0f, 15.434351f, 39.0f, 16.23f);
                instancePath.lineTo(39.0f, 55.74472f);
                instancePath.cubicTo(39.0f, 57.401573f, 37.656853f, 58.74472f, 36.0f, 58.74472f);
                instancePath.cubicTo(35.20435f, 58.74472f, 34.441288f, 58.42865f, 33.87868f, 57.86604f);
                instancePath.lineTo(22.5f, 46.48736f);
                instancePath.lineTo(9.0f, 46.48736f);
                instancePath.cubicTo(7.343146f, 46.48736f, 6.0f, 45.144215f, 6.0f, 43.48736f);
                instancePath.lineTo(6.0f, 28.48736f);
                instancePath.cubicTo(6.0f, 26.830505f, 7.343146f, 25.48736f, 9.0f, 25.48736f);
                instancePath.lineTo(22.5f, 25.48736f);
                instancePath.close();
                instancePath.moveTo(45.985283f, 44.47264f);
                instancePath.cubicTo(48.22353f, 42.234394f, 49.5f, 39.216476f, 49.5f, 35.98736f);
                instancePath.cubicTo(49.5f, 32.75824f, 48.22353f, 29.740326f, 45.985283f, 27.502077f);
                instancePath.lineTo(48.530865f, 24.956493f);
                instancePath.cubicTo(51.353912f, 27.77954f, 53.1f, 31.679539f, 53.1f, 35.98736f);
                instancePath.cubicTo(53.1f, 40.29518f, 51.353912f, 44.19518f, 48.530865f, 47.018227f);
                instancePath.lineTo(45.985283f, 44.47264f);
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
