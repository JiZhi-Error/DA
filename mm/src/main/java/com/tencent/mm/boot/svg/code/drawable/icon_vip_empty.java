package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icon_vip_empty extends c {
    private final int height = 32;
    private final int width = 32;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 32;
            case 1:
                return 32;
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
                instancePath.moveTo(28.666666f, 6.0f);
                instancePath.cubicTo(29.403046f, 6.0f, 30.0f, 6.596954f, 30.0f, 7.3333335f);
                instancePath.lineTo(30.0f, 24.666666f);
                instancePath.cubicTo(30.0f, 25.403046f, 29.403046f, 26.0f, 28.666666f, 26.0f);
                instancePath.lineTo(3.3333333f, 26.0f);
                instancePath.cubicTo(2.5969536f, 26.0f, 2.0f, 25.403046f, 2.0f, 24.666666f);
                instancePath.lineTo(2.0f, 7.3333335f);
                instancePath.cubicTo(2.0f, 6.596954f, 2.5969536f, 6.0f, 3.3333333f, 6.0f);
                instancePath.lineTo(28.666666f, 6.0f);
                instancePath.close();
                instancePath.moveTo(28.4f, 7.6f);
                instancePath.lineTo(3.6f, 7.6f);
                instancePath.lineTo(3.6f, 24.4f);
                instancePath.lineTo(28.4f, 24.4f);
                instancePath.lineTo(28.4f, 7.6f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(10.666667f, 20.666666f);
                instancePath2.lineTo(14.053333f, 11.146667f);
                instancePath2.lineTo(12.36f, 11.146667f);
                instancePath2.lineTo(9.746667f, 18.906666f);
                instancePath2.lineTo(9.706667f, 18.906666f);
                instancePath2.lineTo(7.0933332f, 11.146667f);
                instancePath2.lineTo(5.4f, 11.146667f);
                instancePath2.lineTo(8.786667f, 20.666666f);
                instancePath2.lineTo(10.666667f, 20.666666f);
                instancePath2.close();
                instancePath2.moveTo(16.613333f, 20.666666f);
                instancePath2.lineTo(16.613333f, 11.146667f);
                instancePath2.lineTo(15.053333f, 11.146667f);
                instancePath2.lineTo(15.053333f, 20.666666f);
                instancePath2.lineTo(16.613333f, 20.666666f);
                instancePath2.close();
                instancePath2.moveTo(20.04f, 20.666666f);
                instancePath2.lineTo(20.04f, 17.013332f);
                instancePath2.lineTo(22.4f, 17.013332f);
                instancePath2.cubicTo(24.72f, 17.013332f, 25.88f, 16.026667f, 25.88f, 14.066667f);
                instancePath2.cubicTo(25.88f, 12.12f, 24.72f, 11.146667f, 22.426666f, 11.146667f);
                instancePath2.lineTo(18.48f, 11.146667f);
                instancePath2.lineTo(18.48f, 20.666666f);
                instancePath2.lineTo(20.04f, 20.666666f);
                instancePath2.close();
                instancePath2.moveTo(22.306667f, 15.68f);
                instancePath2.lineTo(20.04f, 15.68f);
                instancePath2.lineTo(20.04f, 12.48f);
                instancePath2.lineTo(22.306667f, 12.48f);
                instancePath2.cubicTo(22.986668f, 12.48f, 23.493334f, 12.6f, 23.813334f, 12.853333f);
                instancePath2.cubicTo(24.133333f, 13.093333f, 24.306667f, 13.493333f, 24.306667f, 14.066667f);
                instancePath2.cubicTo(24.306667f, 14.64f, 24.146667f, 15.053333f, 23.826666f, 15.306666f);
                instancePath2.cubicTo(23.506666f, 15.546667f, 23.0f, 15.68f, 22.306667f, 15.68f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
