package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.WebView;

public class media_btn_play extends c {
    private final int height = TXLiveConstants.RENDER_ROTATION_180;
    private final int width = TXLiveConstants.RENDER_ROTATION_180;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return TXLiveConstants.RENDER_ROTATION_180;
            case 1:
                return TXLiveConstants.RENDER_ROTATION_180;
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
                instancePaint3.setColor(1711276032);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(90.0f, 0.0f);
                instancePath.cubicTo(139.70563f, 0.0f, 180.0f, 40.29437f, 180.0f, 90.0f);
                instancePath.cubicTo(180.0f, 139.70563f, 139.70563f, 180.0f, 90.0f, 180.0f);
                instancePath.cubicTo(40.29437f, 180.0f, 0.0f, 139.70563f, 0.0f, 90.0f);
                instancePath.cubicTo(0.0f, 40.29437f, 40.29437f, 0.0f, 90.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(69.0f, 59.64535f);
                instancePath2.cubicTo(69.0f, 56.333775f, 71.31589f, 54.997013f, 74.19147f, 56.67054f);
                instancePath2.lineTo(126.27224f, 86.98049f);
                instancePath2.cubicTo(129.1394f, 88.649124f, 129.14781f, 91.349625f, 126.27224f, 93.023155f);
                instancePath2.lineTo(74.19147f, 123.33311f);
                instancePath2.cubicTo(71.3243f, 125.00174f, 69.0f, 123.65884f, 69.0f, 120.35829f);
                instancePath2.lineTo(69.0f, 59.64535f);
                instancePath2.close();
                canvas.saveLayerAlpha(null, 204, 31);
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-855638017);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(90.0f, 174.0f);
                instancePath3.cubicTo(136.39192f, 174.0f, 174.0f, 136.39192f, 174.0f, 90.0f);
                instancePath3.cubicTo(174.0f, 43.60808f, 136.39192f, 6.0f, 90.0f, 6.0f);
                instancePath3.cubicTo(43.60808f, 6.0f, 6.0f, 43.60808f, 6.0f, 90.0f);
                instancePath3.cubicTo(6.0f, 136.39192f, 43.60808f, 174.0f, 90.0f, 174.0f);
                instancePath3.close();
                instancePath3.moveTo(90.0f, 180.0f);
                instancePath3.cubicTo(40.294373f, 180.0f, 0.0f, 139.70563f, 0.0f, 90.0f);
                instancePath3.cubicTo(0.0f, 40.294373f, 40.294373f, 0.0f, 90.0f, 0.0f);
                instancePath3.cubicTo(139.70563f, 0.0f, 180.0f, 40.294373f, 180.0f, 90.0f);
                instancePath3.cubicTo(180.0f, 139.70563f, 139.70563f, 180.0f, 90.0f, 180.0f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
