package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_board extends c {
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
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(24.0f, 0.0f);
                instancePath.lineTo(24.0f, 24.0f);
                instancePath.lineTo(0.0f, 24.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-436207616);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(21.0f, 3.0f);
                instancePath2.cubicTo(21.552284f, 3.0f, 22.0f, 3.4477153f, 22.0f, 4.0f);
                instancePath2.lineTo(22.0f, 15.0f);
                instancePath2.cubicTo(22.0f, 15.552284f, 21.552284f, 16.0f, 21.0f, 16.0f);
                instancePath2.lineTo(16.098f, 16.0f);
                instancePath2.lineTo(16.964f, 17.5f);
                instancePath2.lineTo(17.0f, 17.5f);
                instancePath2.lineTo(17.0f, 17.563f);
                instancePath2.lineTo(19.00205f, 21.03109f);
                instancePath2.lineTo(17.27f, 22.03109f);
                instancePath2.lineTo(15.808f, 19.5f);
                instancePath2.lineTo(8.193f, 19.5f);
                instancePath2.lineTo(6.732051f, 22.03109f);
                instancePath2.lineTo(5.0f, 21.03109f);
                instancePath2.lineTo(7.0f, 17.565f);
                instancePath2.lineTo(7.0f, 17.5f);
                instancePath2.lineTo(7.037f, 17.5f);
                instancePath2.lineTo(7.903f, 16.0f);
                instancePath2.lineTo(3.0f, 16.0f);
                instancePath2.cubicTo(2.4477153f, 16.0f, 2.0f, 15.552284f, 2.0f, 15.0f);
                instancePath2.lineTo(2.0f, 4.0f);
                instancePath2.cubicTo(2.0f, 3.4477153f, 2.4477153f, 3.0f, 3.0f, 3.0f);
                instancePath2.lineTo(21.0f, 3.0f);
                instancePath2.close();
                instancePath2.moveTo(13.787f, 16.0f);
                instancePath2.lineTo(10.214f, 16.0f);
                instancePath2.lineTo(9.348f, 17.5f);
                instancePath2.lineTo(14.653f, 17.5f);
                instancePath2.lineTo(13.787f, 16.0f);
                instancePath2.close();
                instancePath2.moveTo(20.0f, 5.0f);
                instancePath2.lineTo(4.0f, 5.0f);
                instancePath2.lineTo(4.0f, 14.0f);
                instancePath2.lineTo(20.0f, 14.0f);
                instancePath2.lineTo(20.0f, 5.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
