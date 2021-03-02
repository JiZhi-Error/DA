package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_reward extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(5.7090178f, 7.405125f);
                instancePath.cubicTo(7.7156563f, 7.663993f, 9.491468f, 8.293761f, 10.959029f, 9.175508f);
                instancePath.cubicTo(10.322219f, 9.696532f, 9.759318f, 10.268267f, 9.278586f, 10.878827f);
                instancePath.lineTo(9.278586f, 10.878827f);
                instancePath.lineTo(10.221414f, 11.621173f);
                instancePath.lineTo(10.379844f, 11.42558f);
                instancePath.cubicTo(10.842314f, 10.870387f, 11.38461f, 10.351974f, 12.000444f, 9.881989f);
                instancePath.cubicTo(12.686535f, 10.406253f, 13.282932f, 10.991659f, 13.778586f, 11.621173f);
                instancePath.lineTo(13.778586f, 11.621173f);
                instancePath.lineTo(14.721414f, 10.878827f);
                instancePath.lineTo(14.554976f, 10.67295f);
                instancePath.cubicTo(14.112268f, 10.13945f, 13.6056795f, 9.637541f, 13.040362f, 9.175959f);
                instancePath.cubicTo(14.504399f, 8.2962475f, 16.274391f, 7.6675253f, 18.274115f, 7.4073105f);
                instancePath.cubicTo(20.102053f, 8.828622f, 21.201488f, 10.612956f, 21.510899f, 12.667511f);
                instancePath.cubicTo(21.556664f, 12.97141f, 21.585146f, 13.281221f, 21.596138f, 13.596644f);
                instancePath.cubicTo(21.60083f, 13.729015f, 21.600994f, 13.85985f, 21.596643f, 13.989122f);
                instancePath.cubicTo(21.599787f, 19.16647f, 17.200577f, 21.679976f, 12.022907f, 21.679976f);
                instancePath.cubicTo(6.937696f, 21.679976f, 2.5409057f, 19.255436f, 2.385499f, 14.263627f);
                instancePath.lineTo(2.38125f, 13.9888f);
                instancePath.cubicTo(2.3800423f, 13.85985f, 2.3802063f, 13.729015f, 2.3848982f, 13.596644f);
                instancePath.cubicTo(2.469213f, 11.1772995f, 3.5824142f, 9.088149f, 5.632454f, 7.4643455f);
                instancePath.close();
                instancePath.moveTo(12.10875f, 1.875f);
                instancePath.cubicTo(13.317911f, 1.875f, 14.359991f, 2.590357f, 14.834863f, 3.6209426f);
                instancePath.cubicTo(15.140803f, 3.4640043f, 15.489383f, 3.375f, 15.85875f, 3.375f);
                instancePath.cubicTo(17.10139f, 3.375f, 18.10875f, 4.3823595f, 18.10875f, 5.625f);
                instancePath.cubicTo(18.10875f, 5.835256f, 18.07991f, 6.038776f, 18.02597f, 6.2318206f);
                instancePath.cubicTo(15.705674f, 6.5453663f, 13.662296f, 7.323763f, 12.000898f, 8.413464f);
                instancePath.cubicTo(10.369265f, 7.344176f, 8.370415f, 6.5744176f, 6.1043305f, 6.2480035f);
                instancePath.cubicTo(6.0456924f, 6.05164f, 6.015f, 5.8419046f, 6.015f, 5.625f);
                instancePath.cubicTo(6.015f, 4.3823595f, 7.0223594f, 3.375f, 8.265f, 3.375f);
                instancePath.cubicTo(8.664536f, 3.375f, 9.039751f, 3.4791374f, 9.36498f, 3.6617498f);
                instancePath.cubicTo(9.830027f, 2.6093674f, 10.883628f, 1.875f, 12.10875f, 1.875f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
