package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class friendactivity_comment_writeicon_golden_normal extends c {
    private final int height = 48;
    private final int width = 54;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 54;
            case 1:
                return 48;
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
                instancePaint3.setColor(-7503);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(21.993774f, 38.0f);
                instancePath.lineTo(51.00044f, 38.0f);
                instancePath.cubicTo(52.66516f, 38.0f, 54.0f, 36.6579f, 54.0f, 35.00234f);
                instancePath.lineTo(54.0f, 2.99766f);
                instancePath.cubicTo(54.0f, 1.3524401f, 52.65705f, 0.0f, 51.00044f, 0.0f);
                instancePath.lineTo(2.9995608f, 0.0f);
                instancePath.cubicTo(1.3348389f, 0.0f, 0.0f, 1.342098f, 0.0f, 2.99766f);
                instancePath.lineTo(0.0f, 35.00234f);
                instancePath.cubicTo(0.0f, 36.64756f, 1.3429492f, 38.0f, 2.9995608f, 38.0f);
                instancePath.lineTo(9.0f, 38.0f);
                instancePath.lineTo(9.0f, 47.950085f);
                instancePath.lineTo(21.993774f, 38.0f);
                instancePath.close();
                instancePath.moveTo(19.0f, 32.0f);
                instancePath.lineTo(48.0f, 32.0f);
                instancePath.lineTo(48.0f, 6.0f);
                instancePath.lineTo(6.0f, 6.0f);
                instancePath.lineTo(6.0f, 32.0f);
                instancePath.lineTo(15.0f, 32.0f);
                instancePath.lineTo(15.0f, 36.0f);
                instancePath.lineTo(19.0f, 32.0f);
                instancePath.lineTo(19.0f, 32.0f);
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
