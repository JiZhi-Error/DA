package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class mall_pos_icon extends c {
    private final int height = 120;
    private final int width = 120;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                instancePath.moveTo(35.0f, 25.999985f);
                instancePath.lineTo(16.000061f, 25.999985f);
                instancePath.lineTo(16.000061f, 45.0f);
                instancePath.lineTo(10.0f, 45.0f);
                instancePath.lineTo(10.0f, 25.0f);
                instancePath.cubicTo(10.0f, 22.238577f, 12.238576f, 20.0f, 15.0f, 20.0f);
                instancePath.lineTo(35.0f, 20.0f);
                instancePath.lineTo(35.0f, 25.999985f);
                instancePath.close();
                instancePath.moveTo(35.0f, 94.000015f);
                instancePath.lineTo(35.0f, 100.0f);
                instancePath.lineTo(15.0f, 100.0f);
                instancePath.cubicTo(12.238576f, 100.0f, 10.0f, 97.76142f, 10.0f, 95.0f);
                instancePath.lineTo(10.0f, 75.0f);
                instancePath.lineTo(16.000061f, 75.0f);
                instancePath.lineTo(16.000061f, 94.000015f);
                instancePath.lineTo(35.0f, 94.000015f);
                instancePath.close();
                instancePath.moveTo(85.0f, 25.999985f);
                instancePath.lineTo(85.0f, 20.0f);
                instancePath.lineTo(105.0f, 20.0f);
                instancePath.cubicTo(107.76142f, 20.0f, 110.0f, 22.238577f, 110.0f, 25.0f);
                instancePath.lineTo(110.0f, 45.0f);
                instancePath.lineTo(103.99994f, 45.0f);
                instancePath.lineTo(103.99994f, 25.999985f);
                instancePath.lineTo(85.0f, 25.999985f);
                instancePath.close();
                instancePath.moveTo(85.0f, 94.000015f);
                instancePath.lineTo(103.99994f, 94.000015f);
                instancePath.lineTo(103.99994f, 75.0f);
                instancePath.lineTo(110.0f, 75.0f);
                instancePath.lineTo(110.0f, 95.0f);
                instancePath.cubicTo(110.0f, 97.76142f, 107.76142f, 100.0f, 105.0f, 100.0f);
                instancePath.lineTo(85.0f, 100.0f);
                instancePath.lineTo(85.0f, 94.000015f);
                instancePath.close();
                instancePath.moveTo(54.142136f, 72.79163f);
                instancePath.lineTo(83.18377f, 43.75f);
                instancePath.lineTo(87.42641f, 47.99264f);
                instancePath.lineTo(57.67767f, 77.74138f);
                instancePath.cubicTo(55.725048f, 79.694f, 52.559223f, 79.694f, 50.6066f, 77.74138f);
                instancePath.lineTo(35.0f, 62.134777f);
                instancePath.lineTo(39.24264f, 57.892136f);
                instancePath.lineTo(54.142136f, 72.79163f);
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
