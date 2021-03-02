package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class status_accountkey_off extends c {
    private final int height = 46;
    private final int width = 46;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 46;
            case 1:
                return 46;
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
                instancePaint3.setColor(-499359);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(23.0f, 0.0f);
                instancePath.cubicTo(35.70255f, 0.0f, 46.0f, 10.29745f, 46.0f, 23.0f);
                instancePath.cubicTo(46.0f, 35.70255f, 35.70255f, 46.0f, 23.0f, 46.0f);
                instancePath.cubicTo(10.29745f, 46.0f, 0.0f, 35.70255f, 0.0f, 23.0f);
                instancePath.cubicTo(0.0f, 10.29745f, 10.29745f, 0.0f, 23.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(29.85458f, 16.970005f);
                instancePath2.cubicTo(29.680027f, 15.727787f, 29.348436f, 14.533834f, 28.44f, 13.570005f);
                instancePath2.cubicTo(25.85f, 10.150005f, 20.18f, 10.140005f, 17.59f, 13.560005f);
                instancePath2.cubicTo(15.97f, 15.310005f, 16.18f, 17.790005f, 15.83f, 19.970005f);
                instancePath2.lineTo(13.0f, 19.970005f);
                instancePath2.cubicTo(13.01f, 24.310005f, 13.01f, 28.640005f, 13.01f, 32.970005f);
                instancePath2.lineTo(33.01f, 32.970005f);
                instancePath2.cubicTo(33.01f, 28.640005f, 33.01f, 24.310005f, 33.02f, 19.970005f);
                instancePath2.lineTo(31.605f, 19.970005f);
                instancePath2.lineTo(26.1f, 19.970005f);
                instancePath2.lineTo(18.83f, 19.970005f);
                instancePath2.cubicTo(18.81f, 17.350006f, 19.72f, 13.870006f, 23.0f, 13.970005f);
                instancePath2.cubicTo(25.080025f, 13.887314f, 26.22539f, 15.273373f, 26.773254f, 16.970005f);
                instancePath2.lineTo(29.85458f, 16.970005f);
                instancePath2.lineTo(29.85458f, 16.970005f);
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
