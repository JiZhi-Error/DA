package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bank_remit_history extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-16139513);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(26.0f, 23.171574f);
                instancePath.lineTo(33.899494f, 31.071068f);
                instancePath.cubicTo(34.680542f, 31.852116f, 34.680542f, 33.118446f, 33.899494f, 33.899494f);
                instancePath.cubicTo(33.118446f, 34.680542f, 31.852116f, 34.680542f, 31.071068f, 33.899494f);
                instancePath.lineTo(22.585787f, 25.414213f);
                instancePath.cubicTo(22.390524f, 25.218952f, 22.244078f, 24.993359f, 22.146446f, 24.752602f);
                instancePath.cubicTo(22.055964f, 24.539213f, 22.0f, 24.276142f, 22.0f, 24.0f);
                instancePath.lineTo(22.0f, 16.0f);
                instancePath.cubicTo(22.0f, 14.895431f, 22.89543f, 14.0f, 24.0f, 14.0f);
                instancePath.cubicTo(25.10457f, 14.0f, 26.0f, 14.895431f, 26.0f, 16.0f);
                instancePath.lineTo(26.0f, 23.171574f);
                instancePath.close();
                instancePath.moveTo(24.727272f, 48.0f);
                instancePath.cubicTo(10.745166f, 48.0f, 0.0f, 37.254833f, 0.0f, 24.727272f);
                instancePath.cubicTo(0.0f, 10.745166f, 10.745166f, 0.0f, 24.727272f, 0.0f);
                instancePath.cubicTo(37.254833f, 0.0f, 48.0f, 10.745166f, 48.0f, 24.727272f);
                instancePath.cubicTo(48.0f, 37.254833f, 37.254833f, 48.0f, 24.727272f, 48.0f);
                instancePath.close();
                instancePath.moveTo(24.0f, 44.0f);
                instancePath.cubicTo(35.045696f, 44.0f, 44.0f, 35.045696f, 44.0f, 24.0f);
                instancePath.cubicTo(44.0f, 12.954305f, 35.045696f, 4.0f, 24.0f, 4.0f);
                instancePath.cubicTo(12.954305f, 4.0f, 4.0f, 12.954305f, 4.0f, 24.0f);
                instancePath.cubicTo(4.0f, 35.045696f, 12.954305f, 44.0f, 24.0f, 44.0f);
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
