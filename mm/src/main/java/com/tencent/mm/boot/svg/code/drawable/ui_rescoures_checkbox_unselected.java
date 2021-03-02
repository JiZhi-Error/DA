package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class ui_rescoures_checkbox_unselected extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(68.4f, 36.444443f);
                instancePath.cubicTo(68.4f, 18.105558f, 53.89444f, 3.6f, 35.555557f, 3.6f);
                instancePath.cubicTo(17.983149f, 3.6f, 3.6f, 18.230572f, 3.6f, 36.444443f);
                instancePath.cubicTo(3.6f, 53.89444f, 18.105558f, 68.4f, 35.555557f, 68.4f);
                instancePath.cubicTo(53.76943f, 68.4f, 68.4f, 54.01685f, 68.4f, 36.444443f);
                instancePath.close();
                instancePath.moveTo(72.0f, 36.444443f);
                instancePath.cubicTo(72.0f, 55.882668f, 55.882668f, 72.0f, 35.555557f, 72.0f);
                instancePath.cubicTo(16.117332f, 72.0f, 0.0f, 55.882668f, 0.0f, 36.444443f);
                instancePath.cubicTo(0.0f, 16.117332f, 16.117332f, 0.0f, 35.555557f, 0.0f);
                instancePath.cubicTo(55.882668f, 0.0f, 72.0f, 16.117332f, 72.0f, 36.444443f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
