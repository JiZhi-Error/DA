package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_icon_fav extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-15683841);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(61.194798f, 19.200624f);
                instancePath.lineTo(36.597427f, 33.401924f);
                instancePath.lineTo(12.0f, 19.200594f);
                instancePath.cubicTo(12.061533f, 19.16046f, 12.123658f, 19.122423f, 12.186299f, 19.086618f);
                instancePath.lineTo(34.008553f, 6.612736f);
                instancePath.cubicTo(35.438347f, 5.7954464f, 37.757584f, 5.796063f, 39.1863f, 6.612736f);
                instancePath.lineTo(61.008553f, 19.086618f);
                instancePath.cubicTo(61.07118f, 19.122416f, 61.133286f, 19.160461f, 61.194798f, 19.200624f);
                instancePath.lineTo(61.194798f, 19.200624f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-372399);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(64.163666f, 23.027594f);
                instancePath2.cubicTo(64.18416f, 23.187063f, 64.1948f, 23.344381f, 64.1948f, 23.49818f);
                instancePath2.lineTo(64.1948f, 48.50182f);
                instancePath2.cubicTo(64.1948f, 50.120968f, 63.03464f, 52.09671f, 61.605927f, 52.913383f);
                instancePath2.lineTo(39.783672f, 65.38726f);
                instancePath2.cubicTo(39.675545f, 65.44907f, 39.56233f, 65.5062f, 39.444798f, 65.558655f);
                instancePath2.lineTo(39.444798f, 37.299038f);
                instancePath2.lineTo(64.163666f, 23.027594f);
                instancePath2.lineTo(64.163666f, 23.027594f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-15616);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(33.411125f, 65.38726f);
                instancePath3.lineTo(11.588874f, 52.913383f);
                instancePath3.cubicTo(10.159078f, 52.096092f, 9.0f, 50.107227f, 9.0f, 48.50182f);
                instancePath3.lineTo(9.0f, 23.49818f);
                instancePath3.cubicTo(9.0f, 23.344044f, 9.010513f, 23.186676f, 9.030771f, 23.027386f);
                instancePath3.lineTo(33.75f, 37.299038f);
                instancePath3.lineTo(33.75f, 65.55865f);
                instancePath3.cubicTo(33.632458f, 65.506195f, 33.51924f, 65.449066f, 33.411125f, 65.38726f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
