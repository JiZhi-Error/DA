package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class card_home_member_card_icon extends c {
    private final int height = 48;
    private final int width = 66;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 66;
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-15683841);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.1875f, 2.88f);
                instancePath.cubicTo(0.1875f, 1.2894199f, 1.4769199f, 0.0f, 3.0675f, 0.0f);
                instancePath.lineTo(62.9325f, 0.0f);
                instancePath.cubicTo(64.52308f, 0.0f, 65.8125f, 1.2894199f, 65.8125f, 2.88f);
                instancePath.lineTo(65.8125f, 45.12f);
                instancePath.cubicTo(65.8125f, 46.71058f, 64.52308f, 48.0f, 62.9325f, 48.0f);
                instancePath.lineTo(3.0675f, 48.0f);
                instancePath.cubicTo(1.4769199f, 48.0f, 0.1875f, 46.71058f, 0.1875f, 45.12f);
                instancePath.lineTo(0.1875f, 2.88f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(14.4375f, 9.081081f);
                instancePath2.cubicTo(17.854763f, 9.081081f, 20.625f, 11.69477f, 20.625f, 14.918919f);
                instancePath2.cubicTo(20.625f, 18.143068f, 17.854763f, 20.756756f, 14.4375f, 20.756756f);
                instancePath2.cubicTo(11.020238f, 20.756756f, 8.25f, 18.143068f, 8.25f, 14.918919f);
                instancePath2.cubicTo(8.25f, 11.69477f, 11.020238f, 9.081081f, 14.4375f, 9.081081f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-1);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(8.25f, 29.837837f);
                instancePath3.lineTo(55.0f, 29.837837f);
                instancePath3.lineTo(55.0f, 36.705883f);
                instancePath3.lineTo(8.25f, 36.705883f);
                instancePath3.lineTo(8.25f, 29.837837f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
