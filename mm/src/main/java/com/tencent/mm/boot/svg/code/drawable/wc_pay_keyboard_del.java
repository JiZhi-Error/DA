package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class wc_pay_keyboard_del extends c {
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
                instancePaint3.setColor(-436207616);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(25.5f, 12.0f);
                instancePath.lineTo(63.0f, 12.0f);
                instancePath.cubicTo(64.65685f, 12.0f, 66.0f, 13.343145f, 66.0f, 15.0f);
                instancePath.lineTo(66.0f, 57.0f);
                instancePath.cubicTo(66.0f, 58.656853f, 64.65685f, 60.0f, 63.0f, 60.0f);
                instancePath.lineTo(25.5f, 60.0f);
                instancePath.cubicTo(24.555729f, 60.0f, 23.666563f, 59.555416f, 23.1f, 58.8f);
                instancePath.lineTo(7.35f, 37.8f);
                instancePath.cubicTo(6.55f, 36.733334f, 6.55f, 35.266666f, 7.35f, 34.2f);
                instancePath.lineTo(23.1f, 13.2f);
                instancePath.cubicTo(23.666563f, 12.444583f, 24.555729f, 12.0f, 25.5f, 12.0f);
                instancePath.close();
                instancePath.moveTo(42.0f, 33.454414f);
                instancePath.lineTo(34.272793f, 25.727207f);
                instancePath.cubicTo(33.569847f, 25.024263f, 32.430153f, 25.024263f, 31.727207f, 25.727207f);
                instancePath.cubicTo(31.024263f, 26.430151f, 31.024263f, 27.569849f, 31.727207f, 28.272793f);
                instancePath.lineTo(39.454414f, 36.0f);
                instancePath.lineTo(31.727207f, 43.727207f);
                instancePath.cubicTo(31.024263f, 44.430153f, 31.024263f, 45.569847f, 31.727207f, 46.272793f);
                instancePath.cubicTo(32.430153f, 46.975735f, 33.569847f, 46.975735f, 34.272793f, 46.272793f);
                instancePath.lineTo(42.0f, 38.545586f);
                instancePath.lineTo(49.727207f, 46.272793f);
                instancePath.cubicTo(50.430153f, 46.975735f, 51.569847f, 46.975735f, 52.272793f, 46.272793f);
                instancePath.cubicTo(52.975735f, 45.569847f, 52.975735f, 44.430153f, 52.272793f, 43.727207f);
                instancePath.lineTo(44.545586f, 36.0f);
                instancePath.lineTo(52.272793f, 28.272793f);
                instancePath.cubicTo(52.975735f, 27.569849f, 52.975735f, 26.430151f, 52.272793f, 25.727207f);
                instancePath.cubicTo(51.569847f, 25.024263f, 50.430153f, 25.024263f, 49.727207f, 25.727207f);
                instancePath.lineTo(42.0f, 33.454414f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
