package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class avatar_del_btn_pressed extends c {
    private final int height = 60;
    private final int width = 60;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                instancePaint3.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(11.0f, 15.0f);
                instancePath.lineTo(44.0f, 15.0f);
                instancePath.lineTo(44.0f, 48.0f);
                instancePath.lineTo(11.0f, 48.0f);
                instancePath.lineTo(11.0f, 15.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-2012855);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(30.0f, 28.37868f);
                instancePath2.lineTo(20.454058f, 18.832739f);
                instancePath2.lineTo(18.332739f, 20.954058f);
                instancePath2.lineTo(27.87868f, 30.5f);
                instancePath2.lineTo(18.332739f, 40.04594f);
                instancePath2.lineTo(20.454058f, 42.167263f);
                instancePath2.lineTo(30.0f, 32.62132f);
                instancePath2.lineTo(39.54594f, 42.167263f);
                instancePath2.lineTo(41.667263f, 40.04594f);
                instancePath2.lineTo(32.12132f, 30.5f);
                instancePath2.lineTo(41.667263f, 20.954058f);
                instancePath2.lineTo(39.54594f, 18.832739f);
                instancePath2.lineTo(30.0f, 28.37868f);
                instancePath2.close();
                instancePath2.moveTo(30.0f, 60.0f);
                instancePath2.cubicTo(13.4314575f, 60.0f, 0.0f, 46.568542f, 0.0f, 30.0f);
                instancePath2.cubicTo(0.0f, 13.4314575f, 13.4314575f, 0.0f, 30.0f, 0.0f);
                instancePath2.cubicTo(46.568542f, 0.0f, 60.0f, 13.4314575f, 60.0f, 30.0f);
                instancePath2.cubicTo(60.0f, 46.568542f, 46.568542f, 60.0f, 30.0f, 60.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
