package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class input_footer_mini_program_pressed extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-8420471);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(96.0f, 47.448277f);
                instancePath.cubicTo(96.0f, 74.50933f, 74.50971f, 96.0f, 48.551723f, 96.0f);
                instancePath.cubicTo(21.490286f, 96.0f, 0.0f, 74.50933f, 0.0f, 47.448277f);
                instancePath.cubicTo(0.0f, 21.488955f, 21.490286f, 5.9487298E-15f, 48.551723f, 5.9487298E-15f);
                instancePath.cubicTo(74.50971f, 5.9487298E-15f, 96.0f, 21.488955f, 96.0f, 47.448277f);
                instancePath.close();
                canvas.saveLayerAlpha(null, 51, 31);
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-8617594);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(96.0f, 48.0f);
                instancePath2.cubicTo(96.0f, 74.50967f, 74.50967f, 96.0f, 48.0f, 96.0f);
                instancePath2.cubicTo(21.490332f, 96.0f, 0.0f, 74.50967f, 0.0f, 48.0f);
                instancePath2.cubicTo(0.0f, 21.490332f, 21.490332f, 0.0f, 48.0f, 0.0f);
                instancePath2.cubicTo(74.50967f, 0.0f, 96.0f, 21.490332f, 96.0f, 48.0f);
                instancePath2.close();
                instancePath2.moveTo(2.2325583f, 48.0f);
                instancePath2.cubicTo(2.2325583f, 73.27666f, 22.72334f, 93.76744f, 48.0f, 93.76744f);
                instancePath2.cubicTo(73.27666f, 93.76744f, 93.76744f, 73.27666f, 93.76744f, 48.0f);
                instancePath2.cubicTo(93.76744f, 22.72334f, 73.27666f, 2.2325583f, 48.0f, 2.2325583f);
                instancePath2.cubicTo(22.72334f, 2.2325583f, 2.2325583f, 22.72334f, 2.2325583f, 48.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                Paint instancePaint8 = c.instancePaint(instancePaint3, looper);
                instancePaint7.setColor(-8617594);
                instancePaint8.setColor(-8617594);
                instancePaint8.setStrokeWidth(2.0f);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(60.0f, 50.0f);
                instancePath3.cubicTo(58.552845f, 50.154545f, 57.8374f, 49.327274f, 59.0f, 48.0f);
                instancePath3.cubicTo(58.672085f, 47.436363f, 59.506775f, 46.727272f, 61.0f, 47.0f);
                instancePath3.cubicTo(64.03794f, 45.663635f, 66.54201f, 42.945454f, 67.0f, 40.0f);
                instancePath3.cubicTo(66.54201f, 35.736362f, 62.845528f, 32.545456f, 59.0f, 32.0f);
                instancePath3.cubicTo(53.544716f, 32.545456f, 49.84824f, 35.736362f, 50.0f, 40.0f);
                instancePath3.lineTo(50.0f, 57.0f);
                instancePath3.cubicTo(49.84824f, 63.272728f, 44.482384f, 68.0f, 38.0f, 68.0f);
                instancePath3.cubicTo(31.365854f, 68.0f, 26.0f, 63.272728f, 26.0f, 57.0f);
                instancePath3.cubicTo(26.0f, 52.163635f, 30.17344f, 47.79091f, 36.0f, 47.0f);
                instancePath3.cubicTo(37.20867f, 46.96364f, 37.80488f, 48.618183f, 37.0f, 49.0f);
                instancePath3.cubicTo(36.759224f, 49.496105f, 36.373985f, 50.390907f, 35.0f, 50.0f);
                instancePath3.cubicTo(31.962059f, 51.454544f, 29.457994f, 54.172726f, 29.0f, 57.0f);
                instancePath3.cubicTo(29.457994f, 61.263638f, 33.154472f, 64.454544f, 37.0f, 65.0f);
                instancePath3.cubicTo(42.455284f, 64.454544f, 46.15176f, 61.263638f, 46.0f, 57.0f);
                instancePath3.lineTo(46.0f, 40.0f);
                instancePath3.cubicTo(46.15176f, 33.727272f, 51.517616f, 29.0f, 58.0f, 29.0f);
                instancePath3.cubicTo(64.63415f, 29.0f, 70.0f, 33.727272f, 70.0f, 40.0f);
                instancePath3.cubicTo(70.0f, 44.954544f, 65.82656f, 49.20909f, 60.0f, 50.0f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint7);
                canvas.drawPath(instancePath3, instancePaint8);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
