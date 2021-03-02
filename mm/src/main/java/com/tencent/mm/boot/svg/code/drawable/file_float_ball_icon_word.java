package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class file_float_ball_icon_word extends c {
    private final int height = 48;
    private final int width = 48;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 48;
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
                instancePaint3.setColor(-13871462);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(48.0f, 0.0f);
                instancePath.lineTo(48.0f, 48.0f);
                instancePath.lineTo(0.0f, 48.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(23.941406f, 20.765625f);
                instancePath2.lineTo(20.484375f, 33.0f);
                instancePath2.lineTo(17.636719f, 33.0f);
                instancePath2.lineTo(13.1015625f, 16.089844f);
                instancePath2.lineTo(16.242188f, 16.089844f);
                instancePath2.lineTo(19.171875f, 28.898438f);
                instancePath2.lineTo(19.265625f, 28.898438f);
                instancePath2.lineTo(22.664062f, 16.089844f);
                instancePath2.lineTo(25.335938f, 16.089844f);
                instancePath2.lineTo(28.734375f, 28.898438f);
                instancePath2.lineTo(28.828125f, 28.898438f);
                instancePath2.lineTo(31.757812f, 16.089844f);
                instancePath2.lineTo(34.898438f, 16.089844f);
                instancePath2.lineTo(30.363281f, 33.0f);
                instancePath2.lineTo(27.515625f, 33.0f);
                instancePath2.lineTo(24.058594f, 20.765625f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
