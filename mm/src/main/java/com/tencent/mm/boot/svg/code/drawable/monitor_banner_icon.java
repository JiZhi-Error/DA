package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class monitor_banner_icon extends c {
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
                instancePaint3.setColor(-16896);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(21.44831f, 69.12264f);
                instancePath.lineTo(46.491844f, 26.187445f);
                instancePath.cubicTo(47.320778f, 24.766298f, 48.675976f, 24.758957f, 49.509193f, 26.187445f);
                instancePath.lineTo(74.55273f, 69.12264f);
                instancePath.cubicTo(75.38166f, 70.54379f, 74.719376f, 71.70915f, 73.063896f, 71.70915f);
                instancePath.lineTo(22.937145f, 71.70915f);
                instancePath.cubicTo(21.285309f, 71.70915f, 20.615093f, 70.55113f, 21.44831f, 69.12264f);
                instancePath.close();
                instancePath.moveTo(46.700405f, 41.400345f);
                instancePath.cubicTo(46.15008f, 41.400345f, 45.72443f, 41.842537f, 45.75011f, 42.39727f);
                instancePath.lineTo(46.46933f, 57.932423f);
                instancePath.lineTo(49.530827f, 57.932423f);
                instancePath.lineTo(50.250046f, 42.39727f);
                instancePath.cubicTo(50.275536f, 41.846684f, 49.83909f, 41.400345f, 49.29975f, 41.400345f);
                instancePath.lineTo(46.700405f, 41.400345f);
                instancePath.close();
                instancePath.moveTo(48.000076f, 65.280014f);
                instancePath.cubicTo(49.268192f, 65.280014f, 50.2962f, 64.252f, 50.2962f, 62.98389f);
                instancePath.cubicTo(50.2962f, 61.715775f, 49.268192f, 60.687767f, 48.000076f, 60.687767f);
                instancePath.cubicTo(46.731964f, 60.687767f, 45.703957f, 61.715775f, 45.703957f, 62.98389f);
                instancePath.cubicTo(45.703957f, 64.252f, 46.731964f, 65.280014f, 48.000076f, 65.280014f);
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
