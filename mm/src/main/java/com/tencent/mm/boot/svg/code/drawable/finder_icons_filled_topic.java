package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_icons_filled_topic extends c {
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
                instancePaint3.setColor(-15132391);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(36.0f, 6.0f);
                instancePath.cubicTo(52.568542f, 6.0f, 66.0f, 19.431458f, 66.0f, 36.0f);
                instancePath.cubicTo(66.0f, 52.568542f, 52.568542f, 66.0f, 36.0f, 66.0f);
                instancePath.cubicTo(19.431458f, 66.0f, 6.0f, 52.568542f, 6.0f, 36.0f);
                instancePath.cubicTo(6.0f, 19.431458f, 19.431458f, 6.0f, 36.0f, 6.0f);
                instancePath.close();
                instancePath.moveTo(33.3f, 21.0f);
                instancePath.lineTo(28.8f, 21.0f);
                instancePath.lineTo(28.08f, 26.999f);
                instancePath.lineTo(21.0f, 27.0f);
                instancePath.lineTo(21.0f, 31.5f);
                instancePath.lineTo(27.54f, 31.499f);
                instancePath.lineTo(26.46f, 40.499f);
                instancePath.lineTo(21.0f, 40.5f);
                instancePath.lineTo(21.0f, 45.0f);
                instancePath.lineTo(25.92f, 44.999f);
                instancePath.lineTo(25.2f, 51.0f);
                instancePath.lineTo(29.7f, 51.0f);
                instancePath.lineTo(30.42f, 44.999f);
                instancePath.lineTo(39.42f, 44.999f);
                instancePath.lineTo(38.7f, 51.0f);
                instancePath.lineTo(43.2f, 51.0f);
                instancePath.lineTo(43.92f, 44.999f);
                instancePath.lineTo(51.0f, 45.0f);
                instancePath.lineTo(51.0f, 40.5f);
                instancePath.lineTo(44.46f, 40.499f);
                instancePath.lineTo(45.54f, 31.499f);
                instancePath.lineTo(51.0f, 31.5f);
                instancePath.lineTo(51.0f, 27.0f);
                instancePath.lineTo(46.08f, 26.999f);
                instancePath.lineTo(46.8f, 21.0f);
                instancePath.lineTo(42.3f, 21.0f);
                instancePath.lineTo(41.58f, 26.999f);
                instancePath.lineTo(32.58f, 26.999f);
                instancePath.lineTo(33.3f, 21.0f);
                instancePath.close();
                instancePath.moveTo(41.04f, 31.499f);
                instancePath.lineTo(39.96f, 40.499f);
                instancePath.lineTo(30.96f, 40.499f);
                instancePath.lineTo(32.04f, 31.499f);
                instancePath.lineTo(41.04f, 31.499f);
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
