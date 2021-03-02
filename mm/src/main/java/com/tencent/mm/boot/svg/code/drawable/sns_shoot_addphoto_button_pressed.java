package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sns_shoot_addphoto_button_pressed extends c {
    private final int height = 186;
    private final int width = 186;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 186;
            case 1:
                return 186;
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
                instancePaint3.setColor(-5065805);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(186.0f, 0.0f);
                instancePath.lineTo(186.0f, 186.0f);
                instancePath.lineTo(0.0f, 186.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                instancePath.moveTo(3.0f, 3.0f);
                instancePath.lineTo(3.0f, 183.0f);
                instancePath.lineTo(183.0f, 183.0f);
                instancePath.lineTo(183.0f, 3.0f);
                instancePath.lineTo(3.0f, 3.0f);
                instancePath.lineTo(3.0f, 3.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(90.0f, 33.0f);
                instancePath2.lineTo(96.0f, 33.0f);
                instancePath2.lineTo(96.0f, 90.0f);
                instancePath2.lineTo(153.0f, 90.0f);
                instancePath2.lineTo(153.0f, 96.0f);
                instancePath2.lineTo(96.0f, 96.0f);
                instancePath2.lineTo(96.0f, 153.0f);
                instancePath2.lineTo(90.0f, 153.0f);
                instancePath2.lineTo(90.0f, 96.0f);
                instancePath2.lineTo(33.0f, 96.0f);
                instancePath2.lineTo(33.0f, 90.0f);
                instancePath2.lineTo(90.0f, 90.0f);
                instancePath2.lineTo(90.0f, 33.0f);
                instancePath2.lineTo(90.0f, 33.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
