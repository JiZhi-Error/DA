package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_icon_exit extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                instancePaint3.setColor(-8617851);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(72.0f, 44.0f);
                instancePath.lineTo(47.0f, 44.0f);
                instancePath.lineTo(47.0f, 52.0f);
                instancePath.lineTo(72.0f, 52.0f);
                instancePath.lineTo(72.0f, 60.0f);
                instancePath.lineTo(87.39076f, 48.0f);
                instancePath.lineTo(72.0f, 36.0f);
                instancePath.lineTo(72.0f, 44.0f);
                instancePath.close();
                instancePath.moveTo(80.0f, 26.0f);
                instancePath.lineTo(80.0f, 23.990396f);
                instancePath.cubicTo(80.0f, 17.382257f, 74.62726f, 12.0f, 67.99965f, 12.0f);
                instancePath.lineTo(28.00035f, 12.0f);
                instancePath.cubicTo(21.373957f, 12.0f, 16.0f, 17.368282f, 16.0f, 23.990396f);
                instancePath.lineTo(16.0f, 72.009605f);
                instancePath.cubicTo(16.0f, 78.617744f, 21.37274f, 84.0f, 28.00035f, 84.0f);
                instancePath.lineTo(67.99965f, 84.0f);
                instancePath.cubicTo(74.626045f, 84.0f, 80.0f, 78.631714f, 80.0f, 72.009605f);
                instancePath.lineTo(80.0f, 70.0f);
                instancePath.lineTo(72.0f, 70.0f);
                instancePath.lineTo(72.0f, 71.995094f);
                instancePath.cubicTo(72.0f, 74.20694f, 70.20595f, 76.0f, 67.990105f, 76.0f);
                instancePath.lineTo(28.009893f, 76.0f);
                instancePath.cubicTo(25.79529f, 76.0f, 24.0f, 74.2002f, 24.0f, 71.995094f);
                instancePath.lineTo(24.0f, 24.004908f);
                instancePath.cubicTo(24.0f, 21.793058f, 25.794052f, 20.0f, 28.009893f, 20.0f);
                instancePath.lineTo(67.990105f, 20.0f);
                instancePath.cubicTo(70.20471f, 20.0f, 72.0f, 21.799795f, 72.0f, 24.004908f);
                instancePath.lineTo(72.0f, 26.0f);
                instancePath.lineTo(80.0f, 26.0f);
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
