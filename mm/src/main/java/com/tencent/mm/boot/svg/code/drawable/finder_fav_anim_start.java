package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_fav_anim_start extends c {
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
                instancePaint3.setColor(-436207616);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(12.0f, 18.5f);
                instancePath.lineTo(7.3278346f, 20.956303f);
                instancePath.cubicTo(6.8389897f, 21.213305f, 6.2343626f, 21.025356f, 5.9773617f, 20.536512f);
                instancePath.cubicTo(5.875023f, 20.341852f, 5.839708f, 20.118883f, 5.876885f, 19.902126f);
                instancePath.lineTo(6.7691894f, 14.699594f);
                instancePath.lineTo(2.9893277f, 11.01514f);
                instancePath.cubicTo(2.5938442f, 10.629638f, 2.5857518f, 9.996525f, 2.9712532f, 9.601041f);
                instancePath.cubicTo(3.1247616f, 9.443558f, 3.3259041f, 9.34107f, 3.5435412f, 9.309445f);
                instancePath.lineTo(8.767181f, 8.550406f);
                instancePath.lineTo(11.103264f, 3.8169858f);
                instancePath.cubicTo(11.347686f, 3.321732f, 11.947312f, 3.1183932f, 12.442566f, 3.3628154f);
                instancePath.cubicTo(12.639778f, 3.4601457f, 12.799406f, 3.6197731f, 12.896736f, 3.8169858f);
                instancePath.lineTo(15.232819f, 8.550406f);
                instancePath.lineTo(20.456459f, 9.309445f);
                instancePath.cubicTo(21.003004f, 9.388864f, 21.381685f, 9.896306f, 21.302267f, 10.442851f);
                instancePath.cubicTo(21.270643f, 10.660488f, 21.168156f, 10.86163f, 21.010672f, 11.01514f);
                instancePath.lineTo(17.23081f, 14.699594f);
                instancePath.lineTo(18.123116f, 19.902126f);
                instancePath.cubicTo(18.216476f, 20.446463f, 17.85089f, 20.963419f, 17.306551f, 21.05678f);
                instancePath.cubicTo(17.089794f, 21.093956f, 16.866827f, 21.058641f, 16.672165f, 20.956303f);
                instancePath.lineTo(12.0f, 18.5f);
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
