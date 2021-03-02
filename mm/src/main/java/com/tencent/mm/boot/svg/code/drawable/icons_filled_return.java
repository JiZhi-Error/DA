package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_return extends c {
    private final int height = 12;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
            case 1:
                return 12;
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
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(24.0f, 0.0f);
                instancePath.lineTo(24.0f, 12.0f);
                instancePath.lineTo(0.0f, 12.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(12.752577f, 9.139913f);
                instancePath2.lineTo(17.54881f, 3.6585047f);
                instancePath2.cubicTo(17.91249f, 3.242868f, 17.870373f, 2.6111054f, 17.454737f, 2.2474234f);
                instancePath2.cubicTo(17.272446f, 2.0879183f, 17.038454f, 2.0f, 16.796232f, 2.0f);
                instancePath2.lineTo(7.2037683f, 2.0f);
                instancePath2.cubicTo(6.6514835f, 2.0f, 6.2037683f, 2.4477153f, 6.2037683f, 3.0f);
                instancePath2.cubicTo(6.2037683f, 3.2422233f, 6.2916865f, 3.4762132f, 6.4511914f, 3.6585047f);
                instancePath2.lineTo(11.247423f, 9.139913f);
                instancePath2.cubicTo(11.611105f, 9.555549f, 12.242868f, 9.597667f, 12.6585045f, 9.233984f);
                instancePath2.cubicTo(12.6919155f, 9.20475f, 12.723342f, 9.173323f, 12.752577f, 9.139913f);
                instancePath2.close();
                canvas.saveLayerAlpha(null, 204, 31);
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
