package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.k.g;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_avatar_shadow extends c {
    private final int height = g.CTRL_INDEX;
    private final int width = g.CTRL_INDEX;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return g.CTRL_INDEX;
            case 1:
                return g.CTRL_INDEX;
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
                instancePaint3.setColor(-4605512);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(67.0f, 134.0f);
                instancePath.cubicTo(104.003075f, 134.0f, 134.0f, 104.003075f, 134.0f, 67.0f);
                instancePath.cubicTo(134.0f, 29.996922f, 104.003075f, 0.0f, 67.0f, 0.0f);
                instancePath.cubicTo(29.996922f, 0.0f, 0.0f, 29.996922f, 0.0f, 67.0f);
                instancePath.cubicTo(0.0f, 104.003075f, 29.996922f, 134.0f, 67.0f, 134.0f);
                instancePath.close();
                instancePath.moveTo(67.0f, 133.0f);
                instancePath.cubicTo(103.45079f, 133.0f, 133.0f, 103.45079f, 133.0f, 67.0f);
                instancePath.cubicTo(133.0f, 30.549206f, 103.45079f, 1.0f, 67.0f, 1.0f);
                instancePath.cubicTo(30.549206f, 1.0f, 1.0f, 30.549206f, 1.0f, 67.0f);
                instancePath.cubicTo(1.0f, 103.45079f, 30.549206f, 133.0f, 67.0f, 133.0f);
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
