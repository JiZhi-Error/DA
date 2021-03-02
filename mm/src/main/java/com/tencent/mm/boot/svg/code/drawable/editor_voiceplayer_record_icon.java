package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class editor_voiceplayer_record_icon extends c {
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
                instancePaint3.setColor(-15028967);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(37.8f, 59.92905f);
                instancePath.lineTo(37.8f, 69.0f);
                instancePath.lineTo(34.2f, 69.0f);
                instancePath.lineTo(34.2f, 59.929047f);
                instancePath.cubicTo(22.615196f, 59.012062f, 13.5f, 49.320515f, 13.5f, 37.5f);
                instancePath.lineTo(13.5f, 33.0f);
                instancePath.lineTo(17.1f, 33.0f);
                instancePath.lineTo(17.1f, 37.5f);
                instancePath.cubicTo(17.1f, 47.938183f, 25.56182f, 56.4f, 36.0f, 56.4f);
                instancePath.cubicTo(46.438183f, 56.4f, 54.9f, 47.938183f, 54.9f, 37.5f);
                instancePath.lineTo(54.9f, 33.0f);
                instancePath.lineTo(58.5f, 33.0f);
                instancePath.lineTo(58.5f, 37.5f);
                instancePath.cubicTo(58.5f, 49.320515f, 49.384804f, 59.012062f, 37.8f, 59.92905f);
                instancePath.close();
                instancePath.moveTo(22.5f, 19.5f);
                instancePath.cubicTo(22.5f, 12.044156f, 28.544155f, 6.0f, 36.0f, 6.0f);
                instancePath.cubicTo(43.455845f, 6.0f, 49.5f, 12.044156f, 49.5f, 19.5f);
                instancePath.lineTo(49.5f, 37.5f);
                instancePath.cubicTo(49.5f, 44.955845f, 43.455845f, 51.0f, 36.0f, 51.0f);
                instancePath.cubicTo(28.544155f, 51.0f, 22.5f, 44.955845f, 22.5f, 37.5f);
                instancePath.lineTo(22.5f, 19.5f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
