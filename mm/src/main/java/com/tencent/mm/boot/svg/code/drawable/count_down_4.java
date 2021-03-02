package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class count_down_4 extends c {
    private final int height = 80;
    private final int width = 80;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 80;
            case 1:
                return 80;
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
                instancePath.moveTo(45.344f, 14.0f);
                instancePath.lineTo(52.544f, 14.0f);
                instancePath.lineTo(52.544f, 47.984f);
                instancePath.lineTo(60.32f, 47.984f);
                instancePath.lineTo(60.32f, 54.248f);
                instancePath.lineTo(52.544f, 54.248f);
                instancePath.lineTo(52.544f, 65.408f);
                instancePath.lineTo(45.056f, 65.408f);
                instancePath.lineTo(45.056f, 54.248f);
                instancePath.lineTo(20.0f, 54.248f);
                instancePath.lineTo(20.0f, 46.832f);
                instancePath.lineTo(45.344f, 14.0f);
                instancePath.close();
                instancePath.moveTo(44.84f, 23.936f);
                instancePath.lineTo(26.408f, 47.984f);
                instancePath.lineTo(45.056f, 47.984f);
                instancePath.lineTo(45.056f, 23.936f);
                instancePath.lineTo(44.84f, 23.936f);
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
