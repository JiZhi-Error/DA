package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class mall_recharge_banner_left extends c {
    private final int height = 36;
    private final int width = 46;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 46;
            case 1:
                return 36;
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
                instancePaint3.setColor(-16036);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(25.915672f, 0.0f);
                instancePath.cubicTo(25.97802f, 12.003458f, 26.092323f, 24.006916f, 25.863716f, 36.0f);
                instancePath.cubicTo(19.75988f, 32.49351f, 13.654047f, 28.48876f, 7.201107f, 25.397118f);
                instancePath.cubicTo(4.8215203f, 25.034006f, 2.4003692f, 25.241499f, 0.0f, 25.241499f);
                instancePath.lineTo(0.0f, 10.696254f);
                instancePath.cubicTo(2.4003692f, 10.696254f, 4.8215203f, 10.903747f, 7.2114983f, 10.540634f);
                instancePath.cubicTo(13.685221f, 7.5008645f, 19.217047f, 3.8922536f, 25.915672f, 0.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(34.0f, 8.687097f);
                instancePath2.cubicTo(37.385418f, 6.432258f, 40.822918f, 4.225806f, 44.239582f, 2.0f);
                instancePath2.cubicTo(44.822918f, 2.7935483f, 45.40625f, 3.5774193f, 46.0f, 4.370968f);
                instancePath2.cubicTo(42.5625f, 6.548387f, 39.177082f, 8.793549f, 35.760418f, 11.0f);
                instancePath2.cubicTo(35.1875f, 10.225806f, 34.59375f, 9.451612f, 34.0f, 8.687097f);
                instancePath2.lineTo(34.0f, 8.687097f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(46.0f, 16.0f);
                instancePath3.lineTo(46.0f, 19.0f);
                instancePath3.lineTo(34.0f, 19.0f);
                instancePath3.lineTo(34.0f, 16.0f);
                instancePath3.lineTo(46.0f, 16.0f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint3, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(34.0f, 26.688448f);
                instancePath4.cubicTo(34.535355f, 25.806301f, 35.050507f, 24.913652f, 35.535355f, 24.0f);
                instancePath4.cubicTo(39.0101f, 26.121353f, 42.50505f, 28.211203f, 46.0f, 30.290548f);
                instancePath4.cubicTo(45.626263f, 30.973162f, 44.878788f, 32.317387f, 44.515152f, 33.0f);
                instancePath4.cubicTo(41.0f, 30.89965f, 37.50505f, 28.788797f, 34.0f, 26.688448f);
                instancePath4.lineTo(34.0f, 26.688448f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
