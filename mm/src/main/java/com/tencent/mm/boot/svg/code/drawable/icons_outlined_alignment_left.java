package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_alignment_left extends c {
    private final int height = 24;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                instancePaint3.setColor(-436207616);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(3.0f, 5.0f);
                instancePath.lineTo(21.0f, 5.0f);
                instancePath.lineTo(21.0f, 6.2000003f);
                instancePath.lineTo(3.0f, 6.2000003f);
                instancePath.lineTo(3.0f, 5.0f);
                instancePath.close();
                instancePath.moveTo(3.0f, 9.2f);
                instancePath.lineTo(15.0f, 9.2f);
                instancePath.lineTo(15.0f, 10.400001f);
                instancePath.lineTo(3.0f, 10.400001f);
                instancePath.lineTo(3.0f, 9.2f);
                instancePath.close();
                instancePath.moveTo(3.0f, 13.400001f);
                instancePath.lineTo(21.0f, 13.400001f);
                instancePath.lineTo(21.0f, 14.6f);
                instancePath.lineTo(3.0f, 14.6f);
                instancePath.lineTo(3.0f, 13.400001f);
                instancePath.close();
                instancePath.moveTo(3.0f, 17.6f);
                instancePath.lineTo(15.0f, 17.6f);
                instancePath.lineTo(15.0f, 18.800001f);
                instancePath.lineTo(3.0f, 18.800001f);
                instancePath.lineTo(3.0f, 17.6f);
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
