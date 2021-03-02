package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_mvlist extends c {
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(3.0f, 6.5f);
                instancePath.cubicTo(3.0f, 6.2238574f, 3.2238576f, 6.0f, 3.5f, 6.0f);
                instancePath.lineTo(20.5f, 6.0f);
                instancePath.cubicTo(20.776142f, 6.0f, 21.0f, 6.2238574f, 21.0f, 6.5f);
                instancePath.lineTo(21.0f, 6.7f);
                instancePath.cubicTo(21.0f, 6.9761424f, 20.776142f, 7.2f, 20.5f, 7.2f);
                instancePath.lineTo(3.5f, 7.2f);
                instancePath.cubicTo(3.2238576f, 7.2f, 3.0f, 6.9761424f, 3.0f, 6.7f);
                instancePath.lineTo(3.0f, 6.5f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(3.0f, 12.45f);
                instancePath2.cubicTo(3.0f, 12.173858f, 3.2238576f, 11.95f, 3.5f, 11.95f);
                instancePath2.lineTo(20.5f, 11.95f);
                instancePath2.cubicTo(20.776142f, 11.95f, 21.0f, 12.173858f, 21.0f, 12.45f);
                instancePath2.lineTo(21.0f, 12.65f);
                instancePath2.cubicTo(21.0f, 12.926142f, 20.776142f, 13.15f, 20.5f, 13.15f);
                instancePath2.lineTo(3.5f, 13.15f);
                instancePath2.cubicTo(3.2238576f, 13.15f, 3.0f, 12.926142f, 3.0f, 12.65f);
                instancePath2.lineTo(3.0f, 12.45f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(3.5f, 17.9f);
                instancePath3.lineTo(14.0f, 17.9f);
                instancePath3.cubicTo(14.276142f, 17.9f, 14.5f, 18.123857f, 14.5f, 18.4f);
                instancePath3.lineTo(14.5f, 18.6f);
                instancePath3.cubicTo(14.5f, 18.876143f, 14.276142f, 19.1f, 14.0f, 19.1f);
                instancePath3.lineTo(3.5f, 19.1f);
                instancePath3.cubicTo(3.2238576f, 19.1f, 3.0f, 18.876143f, 3.0f, 18.6f);
                instancePath3.lineTo(3.0f, 18.4f);
                instancePath3.cubicTo(3.0f, 18.123857f, 3.2238576f, 17.9f, 3.5f, 17.9f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(21.125044f, 18.800495f);
                instancePath4.lineTo(17.128647f, 21.131727f);
                instancePath4.cubicTo(17.008533f, 21.201794f, 16.854364f, 21.161222f, 16.784298f, 21.04111f);
                instancePath4.cubicTo(16.761835f, 21.002604f, 16.75f, 20.958822f, 16.75f, 20.914244f);
                instancePath4.lineTo(16.75f, 16.251781f);
                instancePath4.cubicTo(16.75f, 16.112726f, 16.862726f, 16.0f, 17.001781f, 16.0f);
                instancePath4.cubicTo(17.04636f, 16.0f, 17.09014f, 16.011835f, 17.128647f, 16.034298f);
                instancePath4.lineTo(21.125044f, 18.36553f);
                instancePath4.cubicTo(21.245155f, 18.435595f, 21.285727f, 18.589766f, 21.215662f, 18.709877f);
                instancePath4.cubicTo(21.193777f, 18.747395f, 21.16256f, 18.778612f, 21.125044f, 18.800495f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint6);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
