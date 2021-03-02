package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class ad_unlike_android_arrow extends c {
    private final int height = 16;
    private final int width = 28;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 28;
            case 1:
                return 16;
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
                instancePaint3.setColor(-3355444);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(13.962992f, 10.188502f);
                instancePath.cubicTo(13.08834f, 9.283867f, 12.178382f, 8.349955f, 11.50355f, 7.6751227f);
                instancePath.lineTo(3.828427f, 8.881784E-16f);
                instancePath.lineTo(1.0f, 2.828427f);
                instancePath.lineTo(13.9616785f, 15.961207f);
                instancePath.lineTo(13.994814f, 15.928072f);
                instancePath.lineTo(14.008518f, 15.941776f);
                instancePath.lineTo(15.711977f, 14.210909f);
                instancePath.lineTo(16.790106f, 13.13278f);
                instancePath.cubicTo(16.790106f, 13.13278f, 16.787266f, 13.1298f, 16.781706f, 13.123969f);
                instancePath.lineTo(26.914213f, 2.828427f);
                instancePath.lineTo(24.085787f, -5.3290705E-15f);
                instancePath.lineTo(16.410664f, 7.6751227f);
                instancePath.cubicTo(15.7343025f, 8.351483f, 14.829623f, 9.285367f, 13.962992f, 10.188502f);
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
