package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_icon_reader extends c {
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
                instancePath.moveTo(77.0f, 71.0f);
                instancePath.lineTo(53.0f, 76.0f);
                instancePath.lineTo(53.0f, 26.0f);
                instancePath.lineTo(77.0f, 21.0f);
                instancePath.lineTo(77.0f, 71.0f);
                instancePath.close();
                instancePath.moveTo(20.0f, 21.0f);
                instancePath.lineTo(44.0f, 26.0f);
                instancePath.lineTo(44.0f, 76.0f);
                instancePath.lineTo(20.0f, 71.0f);
                instancePath.lineTo(20.0f, 21.0f);
                instancePath.close();
                instancePath.moveTo(85.0f, 18.0f);
                instancePath.cubicTo(85.0f, 14.723531f, 82.27647f, 12.0f, 79.0f, 12.0f);
                instancePath.cubicTo(78.840515f, 12.0f, 78.76661f, 12.008562f, 79.0f, 12.0f);
                instancePath.lineTo(79.0f, 12.0f);
                instancePath.lineTo(79.0f, 12.0f);
                instancePath.cubicTo(77.96046f, 12.0468645f, 77.32959f, 12.18205f, 77.0f, 12.0f);
                instancePath.lineTo(49.0f, 18.0f);
                instancePath.lineTo(20.0f, 12.0f);
                instancePath.cubicTo(19.670408f, 12.18205f, 19.039543f, 12.0468645f, 18.0f, 12.0f);
                instancePath.lineTo(18.0f, 12.0f);
                instancePath.lineTo(18.0f, 12.0f);
                instancePath.cubicTo(18.233389f, 12.008562f, 18.159487f, 12.0f, 18.0f, 12.0f);
                instancePath.cubicTo(14.723531f, 12.0f, 12.0f, 14.723531f, 12.0f, 18.0f);
                instancePath.cubicTo(12.0f, 18.159487f, 12.008562f, 18.233389f, 12.0f, 18.0f);
                instancePath.lineTo(12.0f, 18.0f);
                instancePath.lineTo(12.0f, 72.0f);
                instancePath.lineTo(12.0f, 72.0f);
                instancePath.cubicTo(12.008562f, 72.45797f, 12.0f, 72.53187f, 12.0f, 73.0f);
                instancePath.cubicTo(12.0f, 75.96783f, 14.723531f, 78.69136f, 18.0f, 79.0f);
                instancePath.cubicTo(18.159487f, 78.69136f, 18.233389f, 78.68279f, 18.0f, 79.0f);
                instancePath.lineTo(18.0f, 79.0f);
                instancePath.lineTo(49.0f, 85.0f);
                instancePath.lineTo(79.0f, 79.0f);
                instancePath.lineTo(79.0f, 79.0f);
                instancePath.cubicTo(78.76661f, 78.68279f, 78.840515f, 78.69136f, 79.0f, 79.0f);
                instancePath.cubicTo(82.27647f, 78.69136f, 85.0f, 75.96783f, 85.0f, 73.0f);
                instancePath.cubicTo(85.0f, 72.53187f, 84.99144f, 72.45797f, 85.0f, 72.0f);
                instancePath.lineTo(85.0f, 72.0f);
                instancePath.lineTo(85.0f, 18.0f);
                instancePath.lineTo(85.0f, 18.0f);
                instancePath.cubicTo(84.99144f, 18.233389f, 85.0f, 18.159487f, 85.0f, 18.0f);
                instancePath.lineTo(85.0f, 18.0f);
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
