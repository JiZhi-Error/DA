package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_search extends c {
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
                instancePath.moveTo(48.929794f, 46.684208f);
                instancePath.lineTo(61.272793f, 59.027206f);
                instancePath.lineTo(58.727207f, 61.572792f);
                instancePath.lineTo(46.35855f, 49.204136f);
                instancePath.cubicTo(42.728428f, 52.200203f, 38.0744f, 54.0f, 33.0f, 54.0f);
                instancePath.cubicTo(21.402f, 54.0f, 12.0f, 44.598f, 12.0f, 33.0f);
                instancePath.cubicTo(12.0f, 21.402f, 21.402f, 12.0f, 33.0f, 12.0f);
                instancePath.cubicTo(44.598f, 12.0f, 54.0f, 21.402f, 54.0f, 33.0f);
                instancePath.cubicTo(54.0f, 38.22745f, 52.089996f, 43.00879f, 48.929794f, 46.684208f);
                instancePath.close();
                instancePath.moveTo(50.399994f, 33.00004f);
                instancePath.cubicTo(50.399994f, 23.390265f, 42.609764f, 15.600037f, 32.999992f, 15.600037f);
                instancePath.cubicTo(23.39022f, 15.600037f, 15.599991f, 23.390265f, 15.599991f, 33.00004f);
                instancePath.cubicTo(15.599991f, 42.60981f, 23.39022f, 50.40004f, 32.999992f, 50.40004f);
                instancePath.cubicTo(42.609764f, 50.40004f, 50.399994f, 42.60981f, 50.399994f, 33.00004f);
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
