package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_cellphone extends c {
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
                instancePath.moveTo(15.0f, 9.0f);
                instancePath.cubicTo(15.0f, 7.343146f, 16.343145f, 6.0f, 18.0f, 6.0f);
                instancePath.lineTo(54.0f, 6.0f);
                instancePath.cubicTo(55.656853f, 6.0f, 57.0f, 7.343146f, 57.0f, 9.0f);
                instancePath.lineTo(57.0f, 63.0f);
                instancePath.cubicTo(57.0f, 64.65685f, 55.656853f, 66.0f, 54.0f, 66.0f);
                instancePath.lineTo(18.0f, 66.0f);
                instancePath.cubicTo(16.343145f, 66.0f, 15.0f, 64.65685f, 15.0f, 63.0f);
                instancePath.lineTo(15.0f, 9.0f);
                instancePath.close();
                instancePath.moveTo(36.0f, 60.0f);
                instancePath.cubicTo(37.656853f, 60.0f, 39.0f, 58.656853f, 39.0f, 57.0f);
                instancePath.cubicTo(39.0f, 55.343147f, 37.656853f, 54.0f, 36.0f, 54.0f);
                instancePath.cubicTo(34.343147f, 54.0f, 33.0f, 55.343147f, 33.0f, 57.0f);
                instancePath.cubicTo(33.0f, 58.656853f, 34.343147f, 60.0f, 36.0f, 60.0f);
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
