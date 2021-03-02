package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class tipsbar_icon_location_lightgreen extends c {
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
                instancePaint3.setColor(-2626143);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(46.62213f, 76.7455f);
                instancePath.cubicTo(46.62213f, 76.7455f, 27.0f, 57.136356f, 27.0f, 41.21418f);
                instancePath.cubicTo(27.0f, 29.446882f, 36.40202f, 20.0f, 48.304348f, 20.0f);
                instancePath.cubicTo(59.59798f, 20.0f, 69.0f, 29.446882f, 69.0f, 41.21418f);
                instancePath.cubicTo(69.0f, 57.136356f, 49.37787f, 76.7455f, 49.37787f, 76.7455f);
                instancePath.cubicTo(48.628487f, 77.53978f, 47.383106f, 77.54187f, 46.62213f, 76.7455f);
                instancePath.close();
                instancePath.moveTo(48.0f, 48.0905f);
                instancePath.cubicTo(51.865993f, 48.0905f, 55.0f, 44.94636f, 55.0f, 41.067875f);
                instancePath.cubicTo(55.0f, 37.189384f, 51.865993f, 34.04525f, 48.0f, 34.04525f);
                instancePath.cubicTo(44.134007f, 34.04525f, 41.0f, 37.189384f, 41.0f, 41.067875f);
                instancePath.cubicTo(41.0f, 44.94636f, 44.134007f, 48.0905f, 48.0f, 48.0905f);
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
