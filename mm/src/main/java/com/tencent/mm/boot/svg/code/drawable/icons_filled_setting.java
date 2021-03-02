package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_setting extends c {
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
                instancePath.moveTo(42.622616f, 14.490464f);
                instancePath.cubicTo(43.982933f, 14.9088f, 45.28828f, 15.452635f, 46.52515f, 16.108456f);
                instancePath.lineTo(52.022694f, 12.809935f);
                instancePath.cubicTo(53.20312f, 12.101678f, 54.714096f, 12.287687f, 55.6875f, 13.261093f);
                instancePath.lineTo(58.738907f, 16.3125f);
                instancePath.cubicTo(59.71231f, 17.285906f, 59.898323f, 18.79688f, 59.190067f, 19.977308f);
                instancePath.lineTo(55.891544f, 25.474846f);
                instancePath.cubicTo(56.547367f, 26.711718f, 57.0912f, 28.017067f, 57.509537f, 29.377384f);
                instancePath.lineTo(63.727608f, 30.931902f);
                instancePath.cubicTo(65.06311f, 31.265778f, 66.0f, 32.465725f, 66.0f, 33.84233f);
                instancePath.lineTo(66.0f, 38.15767f);
                instancePath.cubicTo(66.0f, 39.534275f, 65.06311f, 40.734222f, 63.727608f, 41.0681f);
                instancePath.lineTo(57.509537f, 42.622616f);
                instancePath.cubicTo(57.0912f, 43.982933f, 56.547367f, 45.28828f, 55.891544f, 46.52515f);
                instancePath.lineTo(59.190067f, 52.022694f);
                instancePath.cubicTo(59.898323f, 53.20312f, 59.71231f, 54.714096f, 58.738907f, 55.6875f);
                instancePath.lineTo(55.6875f, 58.738907f);
                instancePath.cubicTo(54.714096f, 59.71231f, 53.20312f, 59.898323f, 52.022694f, 59.190067f);
                instancePath.lineTo(46.525154f, 55.891544f);
                instancePath.cubicTo(45.28828f, 56.547367f, 43.982933f, 57.0912f, 42.622616f, 57.509537f);
                instancePath.lineTo(41.0681f, 63.727608f);
                instancePath.cubicTo(40.734222f, 65.06311f, 39.534275f, 66.0f, 38.15767f, 66.0f);
                instancePath.lineTo(33.84233f, 66.0f);
                instancePath.cubicTo(32.465725f, 66.0f, 31.265778f, 65.06311f, 30.931902f, 63.727608f);
                instancePath.lineTo(29.377384f, 57.509537f);
                instancePath.cubicTo(28.017067f, 57.0912f, 26.711718f, 56.547367f, 25.474848f, 55.891544f);
                instancePath.lineTo(19.977308f, 59.190067f);
                instancePath.cubicTo(18.79688f, 59.898323f, 17.285906f, 59.71231f, 16.3125f, 58.738907f);
                instancePath.lineTo(13.261093f, 55.6875f);
                instancePath.cubicTo(12.287687f, 54.714096f, 12.101678f, 53.20312f, 12.809935f, 52.022694f);
                instancePath.lineTo(16.108458f, 46.525154f);
                instancePath.cubicTo(15.452635f, 45.28828f, 14.9088f, 43.982933f, 14.490464f, 42.622616f);
                instancePath.lineTo(8.272393f, 41.0681f);
                instancePath.cubicTo(6.936892f, 40.734222f, 6.0f, 39.534275f, 6.0f, 38.15767f);
                instancePath.lineTo(6.0f, 33.84233f);
                instancePath.cubicTo(6.0f, 32.465725f, 6.936892f, 31.265778f, 8.272393f, 30.931902f);
                instancePath.lineTo(14.490464f, 29.377384f);
                instancePath.cubicTo(14.9088f, 28.017067f, 15.452635f, 26.711718f, 16.108456f, 25.474848f);
                instancePath.lineTo(12.809935f, 19.977308f);
                instancePath.cubicTo(12.101678f, 18.79688f, 12.287687f, 17.285906f, 13.261093f, 16.3125f);
                instancePath.lineTo(16.3125f, 13.261093f);
                instancePath.cubicTo(17.285906f, 12.287687f, 18.79688f, 12.101678f, 19.977308f, 12.809935f);
                instancePath.lineTo(25.474846f, 16.108458f);
                instancePath.cubicTo(26.711718f, 15.452635f, 28.017067f, 14.9088f, 29.377384f, 14.490464f);
                instancePath.lineTo(30.931902f, 8.272393f);
                instancePath.cubicTo(31.265778f, 6.936892f, 32.465725f, 6.0f, 33.84233f, 6.0f);
                instancePath.lineTo(38.15767f, 6.0f);
                instancePath.cubicTo(39.534275f, 6.0f, 40.734222f, 6.936892f, 41.0681f, 8.272393f);
                instancePath.lineTo(42.622616f, 14.490464f);
                instancePath.close();
                instancePath.moveTo(36.0f, 48.0f);
                instancePath.cubicTo(42.62742f, 48.0f, 48.0f, 42.62742f, 48.0f, 36.0f);
                instancePath.cubicTo(48.0f, 29.372583f, 42.62742f, 24.0f, 36.0f, 24.0f);
                instancePath.cubicTo(29.372583f, 24.0f, 24.0f, 29.372583f, 24.0f, 36.0f);
                instancePath.cubicTo(24.0f, 42.62742f, 29.372583f, 48.0f, 36.0f, 48.0f);
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
