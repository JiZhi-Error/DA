package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_moment extends c {
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
                instancePath.moveTo(28.5f, 65.05487f);
                instancePath.lineTo(28.5f, 45.470562f);
                instancePath.lineTo(46.96314f, 63.933704f);
                instancePath.cubicTo(43.567234f, 65.26753f, 39.869156f, 66.0f, 36.0f, 66.0f);
                instancePath.cubicTo(33.41025f, 66.0f, 30.89715f, 65.67185f, 28.5f, 65.05487f);
                instancePath.close();
                instancePath.moveTo(24.0f, 63.50374f);
                instancePath.cubicTo(18.196375f, 60.968025f, 13.350096f, 56.649204f, 10.153644f, 51.239754f);
                instancePath.lineTo(24.0f, 37.3934f);
                instancePath.lineTo(24.0f, 63.50374f);
                instancePath.close();
                instancePath.moveTo(8.066298f, 46.96314f);
                instancePath.cubicTo(6.7324653f, 43.567234f, 6.0f, 39.869156f, 6.0f, 36.0f);
                instancePath.cubicTo(6.0f, 33.41025f, 6.3281474f, 30.89715f, 6.9451313f, 28.5f);
                instancePath.lineTo(26.529438f, 28.5f);
                instancePath.lineTo(8.066298f, 46.96314f);
                instancePath.close();
                instancePath.moveTo(8.496263f, 24.0f);
                instancePath.cubicTo(11.031974f, 18.196375f, 15.350795f, 13.350096f, 20.760244f, 10.153644f);
                instancePath.lineTo(34.6066f, 24.0f);
                instancePath.lineTo(8.496263f, 24.0f);
                instancePath.close();
                instancePath.moveTo(25.03686f, 8.066298f);
                instancePath.cubicTo(28.432766f, 6.7324653f, 32.130844f, 6.0f, 36.0f, 6.0f);
                instancePath.cubicTo(38.58975f, 6.0f, 41.10285f, 6.3281474f, 43.5f, 6.9451313f);
                instancePath.lineTo(43.5f, 26.529438f);
                instancePath.lineTo(25.03686f, 8.066298f);
                instancePath.close();
                instancePath.moveTo(48.0f, 8.496263f);
                instancePath.cubicTo(53.803627f, 11.031974f, 58.649906f, 15.350795f, 61.846355f, 20.760244f);
                instancePath.lineTo(48.0f, 34.6066f);
                instancePath.lineTo(48.0f, 8.496263f);
                instancePath.close();
                instancePath.moveTo(63.933704f, 25.03686f);
                instancePath.cubicTo(65.26753f, 28.432766f, 66.0f, 32.130844f, 66.0f, 36.0f);
                instancePath.cubicTo(66.0f, 38.58975f, 65.67185f, 41.10285f, 65.05487f, 43.5f);
                instancePath.lineTo(45.470562f, 43.5f);
                instancePath.lineTo(63.933704f, 25.03686f);
                instancePath.close();
                instancePath.moveTo(63.50374f, 48.0f);
                instancePath.cubicTo(60.968025f, 53.803627f, 56.649204f, 58.649906f, 51.239754f, 61.846355f);
                instancePath.lineTo(37.3934f, 48.0f);
                instancePath.lineTo(63.50374f, 48.0f);
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
