package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class error_image_sub extends c {
    private final int height = 27;
    private final int width = 27;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 27;
            case 1:
                return 27;
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
                instancePaint3.setColor(-772816);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(27.0f, 13.666667f);
                instancePath.cubicTo(27.0f, 6.044f, 20.956f, 0.0f, 13.333333f, 0.0f);
                instancePath.cubicTo(6.044f, 0.0f, 0.0f, 6.044f, 0.0f, 13.666667f);
                instancePath.cubicTo(0.0f, 20.956f, 6.044f, 27.0f, 13.333333f, 27.0f);
                instancePath.cubicTo(20.956f, 27.0f, 27.0f, 20.956f, 27.0f, 13.666667f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(13.5f, 6.0f);
                instancePath2.cubicTo(14.334203f, 6.0f, 14.962531f, 6.674437f, 14.916311f, 7.5063977f);
                instancePath2.lineTo(14.5f, 15.0f);
                instancePath2.lineTo(12.5f, 15.0f);
                instancePath2.lineTo(12.083689f, 7.5063977f);
                instancePath2.cubicTo(12.037581f, 6.6764627f, 12.671573f, 6.0f, 13.5f, 6.0f);
                instancePath2.close();
                instancePath2.moveTo(13.5f, 20.0f);
                instancePath2.cubicTo(12.671573f, 20.0f, 12.0f, 19.328426f, 12.0f, 18.5f);
                instancePath2.cubicTo(12.0f, 17.671574f, 12.671573f, 17.0f, 13.5f, 17.0f);
                instancePath2.cubicTo(14.328427f, 17.0f, 15.0f, 17.671574f, 15.0f, 18.5f);
                instancePath2.cubicTo(15.0f, 19.328426f, 14.328427f, 20.0f, 13.5f, 20.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
