package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class scan_from_gallery extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-419430401);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(21.008198f, 4.0f);
                instancePath.cubicTo(21.544695f, 4.0f, 22.0f, 4.481137f, 22.0f, 5.0746493f);
                instancePath.lineTo(22.0f, 18.92535f);
                instancePath.cubicTo(22.0f, 19.521152f, 21.555954f, 20.0f, 21.008198f, 20.0f);
                instancePath.lineTo(2.9918032f, 20.0f);
                instancePath.cubicTo(2.4553056f, 20.0f, 2.0f, 19.518864f, 2.0f, 18.92535f);
                instancePath.lineTo(2.0f, 5.0746493f);
                instancePath.cubicTo(2.0f, 4.4788485f, 2.4440453f, 4.0f, 2.9918032f, 4.0f);
                instancePath.lineTo(21.008198f, 4.0f);
                instancePath.close();
                instancePath.moveTo(20.5f, 5.5f);
                instancePath.lineTo(3.5f, 5.5f);
                instancePath.lineTo(3.5f, 13.849f);
                instancePath.lineTo(8.199245f, 10.049258f);
                instancePath.cubicTo(8.661799f, 9.675185f, 9.404626f, 9.693327f, 9.850495f, 10.085084f);
                instancePath.lineTo(14.326923f, 14.018227f);
                instancePath.lineTo(16.609102f, 12.0774975f);
                instancePath.cubicTo(17.071318f, 11.684438f, 17.806723f, 11.692423f, 18.255432f, 12.095083f);
                instancePath.lineTo(20.5f, 14.136f);
                instancePath.lineTo(20.5f, 5.5f);
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
