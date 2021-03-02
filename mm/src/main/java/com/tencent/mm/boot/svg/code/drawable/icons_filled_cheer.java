package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_cheer extends c {
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
                instancePaint3.setColor(-1);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(15.759411f, 15.77939f);
                instancePath.cubicTo(15.958816f, 15.980215f, 15.958816f, 16.305803f, 15.759411f, 16.506628f);
                instancePath.cubicTo(15.708733f, 16.557648f, 15.6479645f, 16.597363f, 15.58105f, 16.623184f);
                instancePath.lineTo(4.419937f, 20.930206f);
                instancePath.cubicTo(4.0342774f, 21.079031f, 3.5977695f, 20.98546f, 3.3057141f, 20.691383f);
                instancePath.cubicTo(3.0138068f, 20.397387f, 2.9213877f, 19.957752f, 3.0699708f, 19.569862f);
                instancePath.lineTo(7.3676205f, 8.350456f);
                instancePath.cubicTo(7.4691176f, 8.085489f, 7.7646933f, 7.95355f, 8.027808f, 8.055761f);
                instancePath.cubicTo(8.094308f, 8.081594f, 8.1547f, 8.121161f, 8.2051f, 8.171916f);
                instancePath.lineTo(15.759411f, 15.77939f);
                instancePath.close();
                instancePath.moveTo(14.917582f, 3.0f);
                instancePath.lineTo(14.901143f, 5.944943f);
                instancePath.lineTo(16.450092f, 8.43354f);
                instancePath.lineTo(13.554729f, 8.414407f);
                instancePath.lineTo(11.105595f, 9.991583f);
                instancePath.lineTo(11.123353f, 7.0442185f);
                instancePath.lineTo(9.573084f, 4.5580425f);
                instancePath.lineTo(12.471618f, 4.5742154f);
                instancePath.lineTo(14.917582f, 3.0f);
                instancePath.close();
                instancePath.moveTo(17.977903f, 10.530056f);
                instancePath.cubicTo(17.974367f, 10.814033f, 17.742966f, 11.041418f, 17.460974f, 11.037936f);
                instancePath.cubicTo(17.100685f, 11.033487f, 16.723783f, 11.104835f, 16.032785f, 11.304616f);
                instancePath.cubicTo(15.861371f, 11.354176f, 15.678727f, 11.4225025f, 15.488144f, 11.507151f);
                instancePath.cubicTo(15.184431f, 11.642047f, 14.876952f, 11.810562f, 14.583666f, 11.99416f);
                instancePath.lineTo(14.395665f, 12.115106f);
                instancePath.lineTo(14.209309f, 12.243869f);
                instancePath.cubicTo(13.981533f, 12.41132f, 13.662087f, 12.361116f, 13.495808f, 12.131737f);
                instancePath.cubicTo(13.329527f, 11.902357f, 13.379379f, 11.580663f, 13.607155f, 11.413213f);
                instancePath.lineTo(13.741699f, 11.318266f);
                instancePath.lineTo(14.044507f, 11.120716f);
                instancePath.cubicTo(14.375652f, 10.91342f, 14.723903f, 10.722559f, 15.076022f, 10.566164f);
                instancePath.cubicTo(15.306712f, 10.463701f, 15.532122f, 10.379376f, 15.750968f, 10.316103f);
                instancePath.cubicTo(16.529284f, 10.091076f, 16.995611f, 10.003667f, 17.473495f, 10.009567f);
                instancePath.cubicTo(17.755487f, 10.013049f, 17.981283f, 10.24608f, 17.977903f, 10.530056f);
                instancePath.close();
                instancePath.moveTo(17.907688f, 13.741876f);
                instancePath.cubicTo(17.942245f, 13.99186f, 17.79211f, 14.225331f, 17.562181f, 14.302153f);
                instancePath.lineTo(17.472422f, 14.323343f);
                instancePath.lineTo(16.206427f, 14.5581875f);
                instancePath.lineTo(16.1144f, 14.56297f);
                instancePath.cubicTo(15.872551f, 14.553558f, 15.664932f, 14.371204f, 15.630375f, 14.121219f);
                instancePath.cubicTo(15.595818f, 13.871233f, 15.745954f, 13.637762f, 15.975883f, 13.560941f);
                instancePath.lineTo(16.065641f, 13.53975f);
                instancePath.lineTo(17.331636f, 13.304906f);
                instancePath.lineTo(17.423662f, 13.300123f);
                instancePath.cubicTo(17.665512f, 13.309536f, 17.87313f, 13.49189f, 17.907688f, 13.741876f);
                instancePath.close();
                instancePath.moveTo(21.0f, 9.412576f);
                instancePath.lineTo(20.431164f, 10.317467f);
                instancePath.lineTo(20.437008f, 11.389788f);
                instancePath.lineTo(19.538635f, 10.816261f);
                instancePath.lineTo(18.473618f, 10.822831f);
                instancePath.lineTo(19.043524f, 9.916767f);
                instancePath.lineTo(19.03661f, 8.845619f);
                instancePath.lineTo(19.935856f, 9.418657f);
                instancePath.lineTo(21.0f, 9.412576f);
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
