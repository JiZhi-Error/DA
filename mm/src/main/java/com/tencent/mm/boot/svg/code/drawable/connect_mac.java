package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.audio.l;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class connect_mac extends c {
    private final int height = l.CTRL_INDEX;
    private final int width = 378;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 378;
            case 1:
                return l.CTRL_INDEX;
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
                instancePaint3.setColor(-13092808);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(373.0f, 236.0006f);
                instancePath.cubicTo(373.0f, 242.0656f, 368.063f, 247.0006f, 361.993f, 247.0006f);
                instancePath.lineTo(16.007f, 247.0006f);
                instancePath.cubicTo(9.938f, 247.0006f, 5.0f, 242.0656f, 5.0f, 236.0006f);
                instancePath.lineTo(5.0f, 15.9996f);
                instancePath.cubicTo(5.0f, 9.9346f, 9.938f, 5.0006f, 16.007f, 5.0006f);
                instancePath.lineTo(361.993f, 5.0006f);
                instancePath.cubicTo(368.063f, 5.0006f, 373.0f, 9.9346f, 373.0f, 15.9996f);
                instancePath.lineTo(373.0f, 236.0006f);
                instancePath.lineTo(373.0f, 236.0006f);
                instancePath.close();
                instancePath.moveTo(361.993f, 1.9996f);
                instancePath.lineTo(16.007f, 1.9996f);
                instancePath.cubicTo(8.276f, 1.9996f, 2.0f, 8.2676f, 2.0f, 15.9996f);
                instancePath.lineTo(2.0f, 236.0006f);
                instancePath.cubicTo(2.0f, 243.7296f, 8.271f, 249.9996f, 16.007f, 249.9996f);
                instancePath.lineTo(361.993f, 249.9996f);
                instancePath.cubicTo(369.724f, 249.9996f, 376.0f, 243.7326f, 376.0f, 236.0006f);
                instancePath.lineTo(376.0f, 15.9996f);
                instancePath.cubicTo(376.0f, 8.2696f, 369.729f, 1.9996f, 361.993f, 1.9996f);
                instancePath.lineTo(361.993f, 1.9996f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-13092808);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(243.0f, 288.0001f);
                instancePath2.lineTo(134.0f, 288.0001f);
                instancePath2.lineTo(134.0f, 286.5041f);
                instancePath2.lineTo(155.712f, 282.5561f);
                instancePath2.lineTo(159.658f, 250.0001f);
                instancePath2.lineTo(217.342f, 250.0001f);
                instancePath2.lineTo(221.288f, 282.5561f);
                instancePath2.lineTo(243.0f, 286.5041f);
                instancePath2.lineTo(243.0f, 288.0001f);
                instancePath2.close();
                instancePath2.moveTo(220.0f, 247.0001f);
                instancePath2.lineTo(157.0f, 247.0001f);
                instancePath2.lineTo(153.0f, 280.0001f);
                instancePath2.lineTo(131.0f, 284.0001f);
                instancePath2.lineTo(131.0f, 291.0001f);
                instancePath2.lineTo(246.0f, 291.0001f);
                instancePath2.lineTo(246.0f, 284.0001f);
                instancePath2.lineTo(224.0f, 280.0001f);
                instancePath2.lineTo(220.0f, 247.0001f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-13092808);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(4.0f, 201.0f);
                instancePath3.lineTo(376.0f, 201.0f);
                instancePath3.lineTo(376.0f, 198.0f);
                instancePath3.lineTo(4.0f, 198.0f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
