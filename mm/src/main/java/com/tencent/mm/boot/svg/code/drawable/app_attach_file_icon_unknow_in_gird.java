package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_attach_file_icon_unknow_in_gird extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(61.0f, 33.0f);
                instancePath.lineTo(61.0f, 64.0f);
                instancePath.lineTo(19.0f, 64.0f);
                instancePath.lineTo(19.0f, 17.0f);
                instancePath.lineTo(47.0f, 17.0f);
                instancePath.lineTo(47.0f, 33.0f);
                instancePath.lineTo(49.0f, 33.0f);
                instancePath.lineTo(61.0f, 33.0f);
                instancePath.close();
                instancePath.moveTo(60.989494f, 29.0f);
                instancePath.lineTo(51.0f, 18.140165f);
                instancePath.lineTo(51.0f, 29.0f);
                instancePath.lineTo(60.989494f, 29.0f);
                instancePath.close();
                instancePath.moveTo(63.0f, 68.0f);
                instancePath.lineTo(15.0f, 68.0f);
                instancePath.lineTo(15.0f, 66.0f);
                instancePath.lineTo(15.0f, 15.0f);
                instancePath.lineTo(15.0f, 13.0f);
                instancePath.lineTo(51.0f, 13.0f);
                instancePath.lineTo(51.0f, 13.028122f);
                instancePath.lineTo(65.04203f, 28.0f);
                instancePath.lineTo(65.0f, 28.010773f);
                instancePath.lineTo(65.0f, 68.0f);
                instancePath.lineTo(63.0f, 68.0f);
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
