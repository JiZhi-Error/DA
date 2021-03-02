package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.pay.q;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fav_list_img_failed extends c {
    private final int height = 210;
    private final int width = q.CTRL_INDEX;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return q.CTRL_INDEX;
            case 1:
                return 210;
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
                canvas.saveLayerAlpha(null, 25, 31);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(228.0f, 94.73752f);
                instancePath.lineTo(228.0f, 12.0f);
                instancePath.lineTo(12.0f, 12.0f);
                instancePath.lineTo(12.0f, 119.51874f);
                instancePath.lineTo(80.73831f, 55.335876f);
                instancePath.lineTo(162.56027f, 130.40851f);
                instancePath.lineTo(150.84477f, 106.321465f);
                instancePath.lineTo(184.2155f, 80.51195f);
                instancePath.lineTo(206.87204f, 100.85361f);
                instancePath.cubicTo(187.48631f, 110.75349f, 174.0f, 131.23582f, 174.0f, 155.24074f);
                instancePath.cubicTo(174.0f, 166.45111f, 177.2164f, 176.99875f, 182.76556f, 186.00002f);
                instancePath.lineTo(5.9924946f, 186.0f);
                instancePath.cubicTo(2.6953125f, 186.0f, 0.0f, 183.3119f, 0.0f, 179.99596f);
                instancePath.lineTo(0.0f, 6.004041f);
                instancePath.cubicTo(0.0f, 2.6830428f, 2.6829312f, 1.364242E-12f, 5.9924946f, 1.364242E-12f);
                instancePath.lineTo(234.0075f, 1.364242E-12f);
                instancePath.cubicTo(237.30469f, 1.364242E-12f, 240.0f, 2.6881008f, 240.0f, 6.004041f);
                instancePath.lineTo(240.0f, 94.85917f);
                instancePath.cubicTo(237.78893f, 94.62174f, 235.54f, 94.5f, 233.25926f, 94.5f);
                instancePath.cubicTo(231.48848f, 94.5f, 229.73422f, 94.58025f, 228.0f, 94.73752f);
                instancePath.lineTo(228.0f, 94.73752f);
                instancePath.close();
                instancePath.moveTo(283.0f, 155.11111f);
                instancePath.cubicTo(283.0f, 127.16133f, 260.83865f, 105.0f, 232.88889f, 105.0f);
                instancePath.cubicTo(206.16133f, 105.0f, 184.0f, 127.16133f, 184.0f, 155.11111f);
                instancePath.cubicTo(184.0f, 181.83867f, 206.16133f, 204.0f, 232.88889f, 204.0f);
                instancePath.cubicTo(260.83865f, 204.0f, 283.0f, 181.83867f, 283.0f, 155.11111f);
                instancePath.close();
                instancePath.moveTo(233.5f, 178.58653f);
                instancePath.cubicTo(235.98528f, 178.58653f, 238.0f, 176.55244f, 238.0f, 174.04327f);
                instancePath.cubicTo(238.0f, 171.53409f, 235.98528f, 169.5f, 233.5f, 169.5f);
                instancePath.cubicTo(231.01472f, 169.5f, 229.0f, 171.53409f, 229.0f, 174.04327f);
                instancePath.cubicTo(229.0f, 176.55244f, 231.01472f, 178.58653f, 233.5f, 178.58653f);
                instancePath.close();
                instancePath.moveTo(230.34857f, 129.0f);
                instancePath.cubicTo(229.52448f, 129.0f, 228.88528f, 129.6712f, 228.92096f, 130.50104f);
                instancePath.lineTo(230.32753f, 163.21475f);
                instancePath.cubicTo(230.36992f, 164.20071f, 231.20103f, 165.0f, 232.19511f, 165.0f);
                instancePath.lineTo(234.80493f, 165.0f);
                instancePath.cubicTo(235.79398f, 165.0f, 236.63025f, 164.19762f, 236.67252f, 163.21475f);
                instancePath.lineTo(238.07909f, 130.50104f);
                instancePath.cubicTo(238.11473f, 129.67204f, 237.47571f, 129.0f, 236.65147f, 129.0f);
                instancePath.lineTo(230.34857f, 129.0f);
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
