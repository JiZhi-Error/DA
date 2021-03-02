package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class back_icon_normal_black extends c {
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(48.054966f, 24.0f);
                instancePath.cubicTo(49.47408f, 25.437006f, 50.893192f, 26.874012f, 52.292316f, 28.320997f);
                instancePath.cubicTo(46.73579f, 33.86944f, 41.179264f, 39.4079f, 35.63273f, 44.95634f);
                instancePath.cubicTo(47.755154f, 44.96632f, 59.877575f, 44.95634f, 72.0f, 44.96632f);
                instancePath.lineTo(72.0f, 51.01372f);
                instancePath.lineTo(35.58276f, 51.01372f);
                instancePath.cubicTo(41.129295f, 56.612057f, 46.725796f, 62.15052f, 52.292316f, 67.7289f);
                instancePath.cubicTo(50.873203f, 69.15592f, 49.444096f, 70.572975f, 48.01499f, 72.0f);
                instancePath.cubicTo(40.009995f, 64.00665f, 32.004997f, 56.013306f, 24.0f, 48.01996f);
                instancePath.cubicTo(32.01499f, 40.016632f, 40.02998f, 32.003326f, 48.054966f, 24.0f);
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
