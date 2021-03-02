package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class input_footer_mini_program_normal extends c {
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
                instancePaint4.setColor(-8617594);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(96.0f, 48.0f);
                instancePath.cubicTo(96.0f, 74.50967f, 74.50967f, 96.0f, 48.0f, 96.0f);
                instancePath.cubicTo(21.490332f, 96.0f, 0.0f, 74.50967f, 0.0f, 48.0f);
                instancePath.cubicTo(0.0f, 21.490332f, 21.490332f, 0.0f, 48.0f, 0.0f);
                instancePath.cubicTo(74.50967f, 0.0f, 96.0f, 21.490332f, 96.0f, 48.0f);
                instancePath.close();
                instancePath.moveTo(2.2325583f, 48.0f);
                instancePath.cubicTo(2.2325583f, 73.27666f, 22.72334f, 93.76744f, 48.0f, 93.76744f);
                instancePath.cubicTo(73.27666f, 93.76744f, 93.76744f, 73.27666f, 93.76744f, 48.0f);
                instancePath.cubicTo(93.76744f, 22.72334f, 73.27666f, 2.2325583f, 48.0f, 2.2325583f);
                instancePath.cubicTo(22.72334f, 2.2325583f, 2.2325583f, 22.72334f, 2.2325583f, 48.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Paint instancePaint7 = c.instancePaint(instancePaint3, looper);
                instancePaint7.setColor(-8617594);
                instancePaint7.setStrokeWidth(2.0f);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(61.0f, 51.0f);
                instancePath2.cubicTo(59.552845f, 51.154545f, 58.8374f, 50.327274f, 60.0f, 49.0f);
                instancePath2.cubicTo(59.672085f, 48.436363f, 60.506775f, 47.727272f, 62.0f, 48.0f);
                instancePath2.cubicTo(65.03794f, 46.663635f, 67.54201f, 43.945454f, 68.0f, 41.0f);
                instancePath2.cubicTo(67.54201f, 36.736362f, 63.845528f, 33.545456f, 60.0f, 33.0f);
                instancePath2.cubicTo(54.544716f, 33.545456f, 50.84824f, 36.736362f, 51.0f, 41.0f);
                instancePath2.lineTo(51.0f, 58.0f);
                instancePath2.cubicTo(50.84824f, 64.27273f, 45.482384f, 69.0f, 39.0f, 69.0f);
                instancePath2.cubicTo(32.365852f, 69.0f, 27.0f, 64.27273f, 27.0f, 58.0f);
                instancePath2.cubicTo(27.0f, 53.163635f, 31.17344f, 48.79091f, 37.0f, 48.0f);
                instancePath2.cubicTo(38.20867f, 47.96364f, 38.80488f, 49.618183f, 38.0f, 50.0f);
                instancePath2.cubicTo(37.759224f, 50.496105f, 37.373985f, 51.390907f, 36.0f, 51.0f);
                instancePath2.cubicTo(32.96206f, 52.454544f, 30.457994f, 55.172726f, 30.0f, 58.0f);
                instancePath2.cubicTo(30.457994f, 62.263638f, 34.154472f, 65.454544f, 38.0f, 66.0f);
                instancePath2.cubicTo(43.455284f, 65.454544f, 47.15176f, 62.263638f, 47.0f, 58.0f);
                instancePath2.lineTo(47.0f, 41.0f);
                instancePath2.cubicTo(47.15176f, 34.727272f, 52.517616f, 30.0f, 59.0f, 30.0f);
                instancePath2.cubicTo(65.63415f, 30.0f, 71.0f, 34.727272f, 71.0f, 41.0f);
                instancePath2.cubicTo(71.0f, 45.954544f, 66.82656f, 50.20909f, 61.0f, 51.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.drawPath(instancePath2, instancePaint7);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
