package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class checkbox_unselected_white extends c {
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
                c.instancePaint(instancePaint2, looper).setStrokeWidth(1.0f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(60.0f, 0.0f);
                instancePath.lineTo(60.0f, 60.0f);
                instancePath.lineTo(0.0f, 60.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(6.0f, 12.0f);
                instancePath2.cubicTo(6.0f, 8.689151f, 8.683541f, 6.0f, 12.0f, 6.0f);
                instancePath2.lineTo(48.0f, 6.0f);
                instancePath2.cubicTo(51.31085f, 6.0f, 54.0f, 8.683541f, 54.0f, 12.0f);
                instancePath2.lineTo(54.0f, 48.0f);
                instancePath2.cubicTo(54.0f, 51.31085f, 51.31646f, 54.0f, 48.0f, 54.0f);
                instancePath2.lineTo(12.0f, 54.0f);
                instancePath2.cubicTo(8.689151f, 54.0f, 6.0f, 51.31646f, 6.0f, 48.0f);
                instancePath2.lineTo(6.0f, 12.0f);
                instancePath2.lineTo(6.0f, 12.0f);
                instancePath2.close();
                instancePath2.moveTo(9.0f, 11.0f);
                instancePath2.cubicTo(9.0f, 9.938929f, 9.936117f, 9.0f, 11.0f, 9.0f);
                instancePath2.lineTo(49.0f, 9.0f);
                instancePath2.cubicTo(50.06107f, 9.0f, 51.0f, 9.936117f, 51.0f, 11.0f);
                instancePath2.lineTo(51.0f, 49.0f);
                instancePath2.cubicTo(51.0f, 50.06107f, 50.063885f, 51.0f, 49.0f, 51.0f);
                instancePath2.lineTo(11.0f, 51.0f);
                instancePath2.cubicTo(9.938929f, 51.0f, 9.0f, 50.063885f, 9.0f, 49.0f);
                instancePath2.lineTo(9.0f, 11.0f);
                instancePath2.lineTo(9.0f, 11.0f);
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
