package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class qr_reward_save_code_corner extends c {
    private final int height = 36;
    private final int width = 36;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 36;
            case 1:
                return 36;
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
                instancePaint3.setColor(-3833595);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(30.0f, 18.0f);
                instancePath.cubicTo(30.0f, 18.0f, 26.249992f, 20.250055f, 23.249962f, 23.249962f);
                instancePath.cubicTo(20.250055f, 26.249992f, 18.0f, 30.0f, 18.0f, 30.0f);
                instancePath.cubicTo(18.0f, 30.0f, 15.698808f, 26.198854f, 12.750039f, 23.249962f);
                instancePath.cubicTo(9.801146f, 20.301191f, 6.0f, 18.0f, 6.0f, 18.0f);
                instancePath.cubicTo(6.0f, 18.0f, 9.750008f, 15.749946f, 12.750039f, 12.750039f);
                instancePath.cubicTo(15.749946f, 9.750008f, 18.0f, 6.0f, 18.0f, 6.0f);
                instancePath.cubicTo(18.0f, 6.0f, 20.223738f, 9.723691f, 23.249962f, 12.750039f);
                instancePath.cubicTo(26.27631f, 15.776262f, 30.0f, 18.0f, 30.0f, 18.0f);
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
