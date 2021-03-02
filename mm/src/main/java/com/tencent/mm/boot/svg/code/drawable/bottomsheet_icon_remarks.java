package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_icon_remarks extends c {
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
                instancePaint3.setColor(-8683387);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(69.0f, 12.0f);
                instancePath.lineTo(60.0f, 21.0f);
                instancePath.lineTo(69.0f, 29.0f);
                instancePath.lineTo(77.0f, 21.0f);
                instancePath.lineTo(69.0f, 12.0f);
                instancePath.close();
                instancePath.moveTo(20.0f, 60.0f);
                instancePath.lineTo(20.0f, 60.0f);
                instancePath.lineTo(20.0f, 60.0f);
                instancePath.lineTo(20.0f, 69.0f);
                instancePath.lineTo(29.0f, 69.0f);
                instancePath.lineTo(63.0f, 34.0f);
                instancePath.lineTo(55.0f, 26.0f);
                instancePath.lineTo(20.0f, 60.0f);
                instancePath.close();
                instancePath.moveTo(12.0f, 85.0f);
                instancePath.lineTo(85.0f, 85.0f);
                instancePath.lineTo(85.0f, 77.0f);
                instancePath.lineTo(12.0f, 77.0f);
                instancePath.lineTo(12.0f, 85.0f);
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
