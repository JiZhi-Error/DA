package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_refresh extends c {
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
                instancePath.moveTo(55.091885f, 19.908117f);
                instancePath.cubicTo(59.97792f, 24.794155f, 63.0f, 31.544155f, 63.0f, 39.0f);
                instancePath.cubicTo(63.0f, 53.91169f, 50.91169f, 66.0f, 36.0f, 66.0f);
                instancePath.cubicTo(21.088312f, 66.0f, 9.0f, 53.91169f, 9.0f, 39.0f);
                instancePath.cubicTo(9.0f, 24.088312f, 21.088312f, 12.0f, 36.0f, 12.0f);
                instancePath.lineTo(36.0f, 15.6f);
                instancePath.cubicTo(23.076536f, 15.6f, 12.6f, 26.076536f, 12.6f, 39.0f);
                instancePath.cubicTo(12.6f, 51.923462f, 23.076536f, 62.4f, 36.0f, 62.4f);
                instancePath.cubicTo(48.923462f, 62.4f, 59.4f, 51.923462f, 59.4f, 39.0f);
                instancePath.cubicTo(59.4f, 32.706245f, 56.908665f, 26.816067f, 52.5463f, 22.453701f);
                instancePath.lineTo(55.091885f, 19.908117f);
                instancePath.close();
                instancePath.moveTo(34.730843f, 15.633832f);
                instancePath.cubicTo(22.397545f, 16.293022f, 12.6f, 26.502342f, 12.6f, 39.0f);
                instancePath.cubicTo(12.6f, 51.923462f, 23.076536f, 62.4f, 36.0f, 62.4f);
                instancePath.cubicTo(48.923462f, 62.4f, 59.4f, 51.923462f, 59.4f, 39.0f);
                instancePath.cubicTo(59.4f, 32.706245f, 56.908665f, 26.816067f, 52.5463f, 22.453701f);
                instancePath.lineTo(55.091885f, 19.908117f);
                instancePath.cubicTo(59.97792f, 24.794155f, 63.0f, 31.544155f, 63.0f, 39.0f);
                instancePath.cubicTo(63.0f, 53.91169f, 50.91169f, 66.0f, 36.0f, 66.0f);
                instancePath.cubicTo(21.088312f, 66.0f, 9.0f, 53.91169f, 9.0f, 39.0f);
                instancePath.cubicTo(9.0f, 24.928625f, 19.764284f, 13.371382f, 33.507618f, 12.113505f);
                instancePath.lineTo(29.939697f, 8.545585f);
                instancePath.lineTo(32.485283f, 6.0f);
                instancePath.lineTo(39.909904f, 13.424622f);
                instancePath.cubicTo(40.49569f, 14.010407f, 40.49569f, 14.9601555f, 39.909904f, 15.545941f);
                instancePath.lineTo(38.424976f, 17.030867f);
                instancePath.lineTo(32.485283f, 22.970562f);
                instancePath.lineTo(29.939697f, 20.424978f);
                instancePath.lineTo(34.730843f, 15.633832f);
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
