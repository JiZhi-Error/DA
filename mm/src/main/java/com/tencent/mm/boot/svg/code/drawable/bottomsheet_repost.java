package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_repost extends c {
    private final int height = 144;
    private final int width = 144;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                instancePaint3.setColor(-9276814);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(18.0f, 118.0f);
                instancePath.lineTo(18.0f, 48.0f);
                instancePath.lineTo(37.602036f, 48.0f);
                instancePath.cubicTo(40.250168f, 42.636612f, 43.392544f, 37.607285f, 46.872543f, 34.0f);
                instancePath.lineTo(10.101695f, 34.0f);
                instancePath.cubicTo(6.7315254f, 34.00932f, 4.0f, 36.740845f, 4.0f, 40.0f);
                instancePath.lineTo(4.0f, 125.89831f);
                instancePath.cubicTo(4.0f, 129.26848f, 6.7315254f, 132.0f, 10.101695f, 132.0f);
                instancePath.lineTo(119.932205f, 132.0f);
                instancePath.cubicTo(123.30034f, 132.0f, 126.0339f, 129.26848f, 126.0f, 125.89831f);
                instancePath.lineTo(126.0f, 81.6f);
                instancePath.lineTo(112.0f, 93.62034f);
                instancePath.lineTo(112.0f, 118.0f);
                instancePath.lineTo(18.0f, 118.0f);
                instancePath.close();
                instancePath.moveTo(95.0f, 34.411526f);
                instancePath.cubicTo(92.118645f, 34.389153f, 88.57559f, 34.372883f, 85.355934f, 34.372883f);
                instancePath.cubicTo(57.560677f, 34.372883f, 38.688137f, 61.49085f, 38.688137f, 97.42373f);
                instancePath.cubicTo(48.178307f, 75.376274f, 57.458984f, 64.881355f, 95.0f, 64.881355f);
                instancePath.lineTo(95.0f, 87.254234f);
                instancePath.lineTo(140.27118f, 49.627117f);
                instancePath.lineTo(95.0f, 12.0f);
                instancePath.lineTo(95.0f, 34.411526f);
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
