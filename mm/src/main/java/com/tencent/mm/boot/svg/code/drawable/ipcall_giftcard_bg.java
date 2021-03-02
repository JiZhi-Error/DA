package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.e;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class ipcall_giftcard_bg extends c {
    private final int height = e.CTRL_INDEX;
    private final int width = 450;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 450;
            case 1:
                return e.CTRL_INDEX;
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
                canvas.saveLayerAlpha(null, 7, 31);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(70.67984f, 150.63449f);
                instancePath.cubicTo(67.97303f, 110.35668f, 80.40884f, 71.12603f, 108.708755f, 42.23457f);
                instancePath.cubicTo(166.09906f, -16.355326f, 266.9981f, -10.238467f, 334.07306f, 55.896957f);
                instancePath.cubicTo(401.14804f, 122.03238f, 408.999f, 223.14223f, 351.6087f, 281.73212f);
                instancePath.cubicTo(320.71915f, 313.26736f, 277.22516f, 326.05713f, 233.18497f, 320.83246f);
                instancePath.cubicTo(228.70084f, 330.40506f, 222.63911f, 339.28018f, 214.97217f, 347.10776f);
                instancePath.cubicTo(173.24408f, 389.71017f, 99.76736f, 385.15027f, 50.85731f, 336.92297f);
                instancePath.cubicTo(1.947269f, 288.69565f, -3.8748572f, 215.06361f, 37.85323f, 172.46121f);
                instancePath.cubicTo(47.367443f, 162.74765f, 58.53215f, 155.48589f, 70.67984f, 150.63449f);
                instancePath.close();
                instancePath.moveTo(70.67984f, 150.63449f);
                instancePath.cubicTo(73.46225f, 192.0373f, 92.244995f, 234.54659f, 126.2444f, 268.06973f);
                instancePath.cubicTo(157.21716f, 298.60867f, 195.40207f, 316.3501f, 233.18497f, 320.83246f);
                instancePath.cubicTo(253.10619f, 278.3053f, 241.89159f, 222.01225f, 201.96808f, 182.64603f);
                instancePath.cubicTo(164.20978f, 145.41478f, 111.81031f, 134.20828f, 70.67984f, 150.63449f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
