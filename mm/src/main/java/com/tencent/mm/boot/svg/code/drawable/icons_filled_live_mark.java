package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_live_mark extends c {
    private final int height = 72;
    private final int width = 72;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(63.0f, 12.0f);
                instancePath.cubicTo(64.65685f, 12.0f, 66.0f, 13.343145f, 66.0f, 15.0f);
                instancePath.lineTo(66.0f, 57.0f);
                instancePath.cubicTo(66.0f, 58.656853f, 64.65685f, 60.0f, 63.0f, 60.0f);
                instancePath.lineTo(9.0f, 60.0f);
                instancePath.cubicTo(7.343146f, 60.0f, 6.0f, 58.656853f, 6.0f, 57.0f);
                instancePath.lineTo(6.0f, 15.0f);
                instancePath.cubicTo(6.0f, 13.343145f, 7.343146f, 12.0f, 9.0f, 12.0f);
                instancePath.lineTo(63.0f, 12.0f);
                instancePath.close();
                instancePath.moveTo(17.736328f, 28.089844f);
                instancePath.lineTo(14.197266f, 28.089844f);
                instancePath.lineTo(14.197266f, 45.0f);
                instancePath.lineTo(25.13086f, 45.0f);
                instancePath.lineTo(25.13086f, 42.070312f);
                instancePath.lineTo(17.736328f, 42.070312f);
                instancePath.lineTo(17.736328f, 28.089844f);
                instancePath.close();
                instancePath.moveTo(30.767578f, 28.089844f);
                instancePath.lineTo(27.228516f, 28.089844f);
                instancePath.lineTo(27.228516f, 45.0f);
                instancePath.lineTo(30.767578f, 45.0f);
                instancePath.lineTo(30.767578f, 28.089844f);
                instancePath.close();
                instancePath.moveTo(36.46289f, 28.089844f);
                instancePath.lineTo(32.501953f, 28.089844f);
                instancePath.lineTo(38.185547f, 45.0f);
                instancePath.lineTo(42.45117f, 45.0f);
                instancePath.lineTo(48.134766f, 28.089844f);
                instancePath.lineTo(44.279297f, 28.089844f);
                instancePath.lineTo(40.41211f, 41.35547f);
                instancePath.lineTo(40.33008f, 41.35547f);
                instancePath.lineTo(36.46289f, 28.089844f);
                instancePath.close();
                instancePath.moveTo(61.060547f, 28.089844f);
                instancePath.lineTo(49.85742f, 28.089844f);
                instancePath.lineTo(49.85742f, 45.0f);
                instancePath.lineTo(61.060547f, 45.0f);
                instancePath.lineTo(61.060547f, 42.070312f);
                instancePath.lineTo(53.396484f, 42.070312f);
                instancePath.lineTo(53.396484f, 37.804688f);
                instancePath.lineTo(60.626953f, 37.804688f);
                instancePath.lineTo(60.626953f, 35.085938f);
                instancePath.lineTo(53.396484f, 35.085938f);
                instancePath.lineTo(53.396484f, 31.007812f);
                instancePath.lineTo(61.060547f, 31.007812f);
                instancePath.lineTo(61.060547f, 28.089844f);
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
