package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_pay_notice extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(45.0f, 11.412743f);
                instancePath.cubicTo(46.656853f, 11.412743f, 48.0f, 12.755889f, 48.0f, 14.412743f);
                instancePath.lineTo(48.0f, 14.412743f);
                instancePath.lineTo(48.0f, 57.587257f);
                instancePath.cubicTo(48.0f, 58.149517f, 47.84199f, 58.70046f, 47.543995f, 59.177254f);
                instancePath.cubicTo(46.665863f, 60.582264f, 44.815014f, 61.009384f, 43.410004f, 60.131252f);
                instancePath.lineTo(43.410004f, 60.131252f);
                instancePath.lineTo(24.0f, 48.0f);
                instancePath.lineTo(18.0f, 48.0f);
                instancePath.cubicTo(11.372583f, 48.0f, 6.0f, 42.62742f, 6.0f, 36.0f);
                instancePath.cubicTo(6.0f, 29.372583f, 11.372583f, 24.0f, 18.0f, 24.0f);
                instancePath.lineTo(18.0f, 24.0f);
                instancePath.lineTo(24.0f, 24.0f);
                instancePath.lineTo(43.410004f, 11.868748f);
                instancePath.cubicTo(43.8868f, 11.570751f, 44.43774f, 11.412743f, 45.0f, 11.412743f);
                instancePath.close();
                instancePath.moveTo(55.328876f, 45.316196f);
                instancePath.lineTo(67.34059f, 51.316196f);
                instancePath.lineTo(64.65941f, 56.683804f);
                instancePath.lineTo(52.647686f, 50.683804f);
                instancePath.lineTo(55.328876f, 45.316196f);
                instancePath.close();
                instancePath.moveTo(66.0f, 33.0f);
                instancePath.lineTo(66.0f, 39.0f);
                instancePath.lineTo(53.98828f, 39.0f);
                instancePath.lineTo(53.98828f, 33.0f);
                instancePath.lineTo(66.0f, 33.0f);
                instancePath.close();
                instancePath.moveTo(64.65941f, 15.316195f);
                instancePath.lineTo(67.34059f, 20.683805f);
                instancePath.lineTo(55.328876f, 26.683805f);
                instancePath.lineTo(52.647686f, 21.316195f);
                instancePath.lineTo(64.65941f, 15.316195f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
