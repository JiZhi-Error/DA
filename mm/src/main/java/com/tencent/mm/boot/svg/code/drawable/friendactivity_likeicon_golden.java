package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class friendactivity_likeicon_golden extends c {
    private final int height = 32;
    private final int width = 33;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 33;
            case 1:
                return 32;
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
                instancePaint3.setColor(-4547478);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(9.0f, 0.0f);
                instancePath.cubicTo(4.4698386f, 0.0f, 1.2866651E-7f, 4.280687f, 0.0f, 12.0f);
                instancePath.cubicTo(-1.2866651E-7f, 19.4983f, 7.829132f, 28.649586f, 16.5f, 31.5f);
                instancePath.cubicTo(25.447317f, 28.649586f, 33.0f, 19.289865f, 33.0f, 12.0f);
                instancePath.cubicTo(33.0f, 4.0722513f, 28.71333f, 1.0442231E-7f, 24.0f, 0.0f);
                instancePath.cubicTo(19.675785f, -9.371384E-8f, 17.939146f, 1.5439653f, 16.5f, 3.0f);
                instancePath.cubicTo(15.07374f, 1.5439653f, 12.953914f, 0.0f, 9.0f, 0.0f);
                instancePath.close();
                instancePath.moveTo(9.965287f, 4.0f);
                instancePath.cubicTo(7.320104f, 4.0f, 4.0f, 6.7830515f, 4.0f, 11.904762f);
                instancePath.cubicTo(4.0f, 17.026472f, 9.405654f, 24.647278f, 16.5f, 27.0f);
                instancePath.cubicTo(23.820532f, 24.647278f, 29.0f, 15.826896f, 29.0f, 11.904762f);
                instancePath.cubicTo(29.0f, 7.982628f, 26.492723f, 4.0f, 22.636364f, 4.0f);
                instancePath.cubicTo(19.09837f, 4.0f, 17.274794f, 7.6027136f, 16.5f, 9.0f);
                instancePath.cubicTo(15.76442f, 7.6027136f, 12.610471f, 4.0f, 9.965287f, 4.0f);
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
