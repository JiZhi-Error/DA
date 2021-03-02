package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_nearby extends c {
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
                instancePath.moveTo(21.0f, 18.0f);
                instancePath.cubicTo(17.68629f, 18.0f, 15.0f, 15.313708f, 15.0f, 12.0f);
                instancePath.cubicTo(15.0f, 8.686292f, 17.68629f, 6.0f, 21.0f, 6.0f);
                instancePath.cubicTo(24.31371f, 6.0f, 27.0f, 8.686292f, 27.0f, 12.0f);
                instancePath.cubicTo(27.0f, 15.313708f, 24.31371f, 18.0f, 21.0f, 18.0f);
                instancePath.close();
                instancePath.moveTo(16.919687f, 24.0f);
                instancePath.lineTo(25.080313f, 24.0f);
                instancePath.cubicTo(27.565594f, 24.0f, 29.580313f, 26.014719f, 29.580313f, 28.5f);
                instancePath.cubicTo(29.580313f, 28.633596f, 29.574364f, 28.767126f, 29.562483f, 28.900194f);
                instancePath.lineTo(26.494036f, 63.266796f);
                instancePath.cubicTo(26.355885f, 64.8141f, 25.059385f, 66.0f, 23.505922f, 66.0f);
                instancePath.lineTo(18.494078f, 66.0f);
                instancePath.cubicTo(16.940615f, 66.0f, 15.644116f, 64.8141f, 15.505964f, 63.266796f);
                instancePath.lineTo(12.437517f, 28.900194f);
                instancePath.cubicTo(12.216496f, 26.424759f, 14.04406f, 24.238852f, 16.519493f, 24.01783f);
                instancePath.cubicTo(16.652561f, 24.005949f, 16.78609f, 24.0f, 16.919687f, 24.0f);
                instancePath.close();
                instancePath.moveTo(51.0f, 18.0f);
                instancePath.cubicTo(47.68629f, 18.0f, 45.0f, 15.313708f, 45.0f, 12.0f);
                instancePath.cubicTo(45.0f, 8.686292f, 47.68629f, 6.0f, 51.0f, 6.0f);
                instancePath.cubicTo(54.31371f, 6.0f, 57.0f, 8.686292f, 57.0f, 12.0f);
                instancePath.cubicTo(57.0f, 15.313708f, 54.31371f, 18.0f, 51.0f, 18.0f);
                instancePath.close();
                instancePath.moveTo(46.919685f, 24.0f);
                instancePath.lineTo(55.080315f, 24.0f);
                instancePath.cubicTo(57.565594f, 24.0f, 59.580315f, 26.014719f, 59.580315f, 28.5f);
                instancePath.cubicTo(59.580315f, 28.633596f, 59.574364f, 28.767126f, 59.56248f, 28.900194f);
                instancePath.lineTo(56.494038f, 63.266796f);
                instancePath.cubicTo(56.355885f, 64.8141f, 55.059387f, 66.0f, 53.505924f, 66.0f);
                instancePath.lineTo(48.494076f, 66.0f);
                instancePath.cubicTo(46.940613f, 66.0f, 45.644115f, 64.8141f, 45.505962f, 63.266796f);
                instancePath.lineTo(42.43752f, 28.900194f);
                instancePath.cubicTo(42.216496f, 26.424759f, 44.04406f, 24.238852f, 46.519493f, 24.01783f);
                instancePath.cubicTo(46.65256f, 24.005949f, 46.78609f, 24.0f, 46.919685f, 24.0f);
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
