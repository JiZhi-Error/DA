package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.WebView;

public class multitalk_video_action_on extends c {
    private final int height = 240;
    private final int width = TXLiveConstants.RENDER_ROTATION_180;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return TXLiveConstants.RENDER_ROTATION_180;
            case 1:
                return 240;
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
                instancePaint3.setColor(-1);
                canvas.saveLayerAlpha(null, 230, 31);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(90.0f, 180.0f);
                instancePath.cubicTo(139.70563f, 180.0f, 180.0f, 139.70563f, 180.0f, 90.0f);
                instancePath.cubicTo(180.0f, 40.294373f, 139.70563f, 0.0f, 90.0f, 0.0f);
                instancePath.cubicTo(40.294373f, 0.0f, 0.0f, 40.294373f, 0.0f, 90.0f);
                instancePath.cubicTo(0.0f, 139.70563f, 40.294373f, 180.0f, 90.0f, 180.0f);
                instancePath.close();
                instancePath.moveTo(44.0f, 67.99653f);
                instancePath.cubicTo(44.0f, 66.34159f, 45.34499f, 65.0f, 46.99624f, 65.0f);
                instancePath.lineTo(104.00376f, 65.0f);
                instancePath.cubicTo(105.65854f, 65.0f, 107.0f, 66.33738f, 107.0f, 67.99653f);
                instancePath.lineTo(107.0f, 112.00347f);
                instancePath.cubicTo(107.0f, 113.65841f, 105.65501f, 115.0f, 104.00376f, 115.0f);
                instancePath.lineTo(46.99624f, 115.0f);
                instancePath.cubicTo(45.34146f, 115.0f, 44.0f, 113.66262f, 44.0f, 112.00347f);
                instancePath.lineTo(44.0f, 67.99653f);
                instancePath.close();
                instancePath.moveTo(131.5f, 116.79712f);
                instancePath.cubicTo(133.91545f, 117.568535f, 136.0f, 116.05244f, 136.0f, 113.73276f);
                instancePath.lineTo(136.0f, 66.235054f);
                instancePath.cubicTo(136.0f, 63.63856f, 133.69482f, 62.548866f, 131.5f, 63.170685f);
                instancePath.cubicTo(130.19809f, 64.306465f, 119.559074f, 74.1768f, 112.0f, 81.05712f);
                instancePath.lineTo(112.0f, 98.72812f);
                instancePath.cubicTo(119.74342f, 105.702545f, 130.61983f, 115.864586f, 131.5f, 116.79712f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
