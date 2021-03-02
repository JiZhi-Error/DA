package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class wallet_security_pay_guard extends c {
    private final int height = 32;
    private final int width = 32;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 32;
            case 1:
                return 32;
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-15432210);
                instancePaint4.setStrokeWidth(1.7333333f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(15.999968f, 4.866667f);
                instancePath.cubicTo(20.150236f, 4.866667f, 23.993862f, 6.177216f, 27.13068f, 8.403519f);
                instancePath.cubicTo(27.133333f, 12.910462f, 26.011505f, 16.810717f, 24.051256f, 20.172611f);
                instancePath.cubicTo(22.102459f, 23.51487f, 19.32558f, 26.325237f, 15.999294f, 28.327726f);
                instancePath.cubicTo(12.673649f, 26.32453f, 9.897253f, 23.514467f, 7.948724f, 20.172653f);
                instancePath.cubicTo(5.9884806f, 16.810747f, 4.866667f, 12.910479f, 4.866667f, 8.75285f);
                instancePath.cubicTo(8.006618f, 6.1770535f, 11.850019f, 4.866667f, 15.999968f, 4.866667f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-15432210);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(16.007088f, 19.410448f);
                instancePath2.lineTo(5.032304f, 8.867483f);
                instancePath2.lineTo(5.032304f, 7.8929935f);
                instancePath2.lineTo(16.007088f, 15.516818f);
                instancePath2.lineTo(26.98192f, 7.8929935f);
                instancePath2.lineTo(26.98192f, 8.867483f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(0.0f, 0.0f);
                instancePath3.lineTo(32.0f, 0.0f);
                instancePath3.lineTo(32.0f, 32.0f);
                instancePath3.lineTo(0.0f, 32.0f);
                instancePath3.lineTo(0.0f, 0.0f);
                instancePath3.close();
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(0.0f, 0.0f);
                instancePath4.lineTo(32.0f, 0.0f);
                instancePath4.lineTo(32.0f, 32.0f);
                instancePath4.lineTo(0.0f, 32.0f);
                instancePath4.lineTo(0.0f, 0.0f);
                instancePath4.close();
                c.done(looper);
                break;
        }
        return 0;
    }
}
