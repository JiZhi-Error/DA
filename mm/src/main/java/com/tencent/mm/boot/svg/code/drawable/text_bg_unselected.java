package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class text_bg_unselected extends c {
    private final int height = 60;
    private final int width = 60;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-1);
                instancePaint4.setStrokeWidth(3.0f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(1.5f, 4.5f);
                instancePath.cubicTo(1.5f, 2.8431456f, 2.8431456f, 1.5f, 4.5f, 1.5f);
                instancePath.lineTo(54.0f, 1.5f);
                instancePath.cubicTo(55.656853f, 1.5f, 57.0f, 2.8431456f, 57.0f, 4.5f);
                instancePath.lineTo(57.0f, 54.0f);
                instancePath.cubicTo(57.0f, 55.656853f, 55.656853f, 57.0f, 54.0f, 57.0f);
                instancePath.lineTo(4.5f, 57.0f);
                instancePath.cubicTo(2.8431456f, 57.0f, 1.5f, 55.656853f, 1.5f, 54.0f);
                instancePath.lineTo(1.5f, 4.5f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(31.5f, 18.0f);
                instancePath2.lineTo(31.5f, 46.5f);
                instancePath2.cubicTo(31.5f, 47.328426f, 30.828426f, 48.0f, 30.0f, 48.0f);
                instancePath2.lineTo(27.0f, 48.0f);
                instancePath2.cubicTo(26.171574f, 48.0f, 25.5f, 47.328426f, 25.5f, 46.5f);
                instancePath2.lineTo(25.5f, 18.0f);
                instancePath2.lineTo(13.5f, 18.0f);
                instancePath2.cubicTo(12.671573f, 18.0f, 12.0f, 17.328426f, 12.0f, 16.5f);
                instancePath2.lineTo(12.0f, 13.5f);
                instancePath2.cubicTo(12.0f, 12.671573f, 12.671573f, 12.0f, 13.5f, 12.0f);
                instancePath2.lineTo(45.0f, 12.0f);
                instancePath2.cubicTo(45.828426f, 12.0f, 46.5f, 12.671573f, 46.5f, 13.5f);
                instancePath2.lineTo(46.5f, 16.5f);
                instancePath2.cubicTo(46.5f, 17.328426f, 45.828426f, 18.0f, 45.0f, 18.0f);
                instancePath2.lineTo(31.5f, 18.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
