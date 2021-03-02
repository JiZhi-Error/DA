package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class kinda_offline_shield_icon extends c {
    private final int height = 16;
    private final int width = 16;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 16;
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(1275068416);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(13.333333f, 6.2430563f);
                instancePath.cubicTo(13.333333f, 6.2430563f, 13.333333f, 6.2430563f, 13.333333f, 6.2430563f);
                instancePath.lineTo(13.333333f, 7.502526f);
                instancePath.cubicTo(13.333333f, 10.733429f, 11.134437f, 13.549725f, 8.0f, 14.333333f);
                instancePath.cubicTo(4.8655634f, 13.549725f, 2.6666667f, 10.733429f, 2.6666667f, 7.502526f);
                instancePath.lineTo(2.6666667f, 3.6666667f);
                instancePath.lineTo(8.0f, 1.6666666f);
                instancePath.lineTo(13.333333f, 3.6666667f);
                instancePath.lineTo(13.333333f, 6.2430563f);
                instancePath.close();
                instancePath.moveTo(12.533333f, 6.1714115f);
                instancePath.lineTo(12.533333f, 4.291288f);
                instancePath.lineTo(8.0f, 2.4912877f);
                instancePath.lineTo(3.4666667f, 4.291288f);
                instancePath.lineTo(3.4666667f, 7.502526f);
                instancePath.cubicTo(3.4666667f, 10.299193f, 5.325406f, 12.745391f, 8.0f, 13.505414f);
                instancePath.cubicTo(10.674594f, 12.745391f, 12.533333f, 10.299193f, 12.533333f, 7.502526f);
                instancePath.lineTo(12.533333f, 6.8846183f);
                instancePath.lineTo(6.885941f, 9.941663f);
                instancePath.lineTo(6.8461113f, 9.963326f);
                instancePath.cubicTo(6.7969275f, 9.986406f, 6.741558f, 10.0f, 6.6828694f, 10.0f);
                instancePath.cubicTo(6.5466332f, 10.0f, 6.4282002f, 9.929626f, 6.3660417f, 9.825695f);
                instancePath.lineTo(6.342355f, 9.776986f);
                instancePath.lineTo(5.350683f, 7.7348857f);
                instancePath.cubicTo(5.3399715f, 7.712655f, 5.3333335f, 7.687451f, 5.3333335f, 7.662955f);
                instancePath.cubicTo(5.3333335f, 7.568935f, 5.4146523f, 7.4927564f, 5.5148306f, 7.4927564f);
                instancePath.cubicTo(5.555867f, 7.4927564f, 5.593132f, 7.505358f, 5.623608f, 7.526598f);
                instancePath.lineTo(6.793608f, 8.308351f);
                instancePath.cubicTo(6.87885f, 8.360741f, 6.9812913f, 8.391609f, 7.0911245f, 8.391609f);
                instancePath.cubicTo(7.1564517f, 8.391609f, 7.219063f, 8.380281f, 7.277148f, 8.360316f);
                instancePath.cubicTo(7.277148f, 8.360316f, 11.068007f, 6.7807727f, 12.533333f, 6.1714115f);
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
