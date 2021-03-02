package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_icons_filled_unstar2 extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-1);
                instancePaint5.setColor(419430400);
                instancePaint5.setStrokeWidth(0.5f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.25f, 0.25f);
                instancePath.lineTo(23.75f, 0.25f);
                instancePath.lineTo(23.75f, 23.75f);
                instancePath.lineTo(0.25f, 23.75f);
                instancePath.lineTo(0.25f, 0.25f);
                instancePath.close();
                canvas.saveLayerAlpha(null, 0, 31);
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Paint instancePaint7 = c.instancePaint(instancePaint5, looper);
                canvas.drawPath(instancePath, instancePaint6);
                canvas.drawPath(instancePath, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint, looper);
                instancePaint8.setColor(-352965);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(12.442566f, 3.3628154f);
                instancePath2.cubicTo(12.639778f, 3.4601457f, 12.799406f, 3.6197731f, 12.896736f, 3.8169858f);
                instancePath2.lineTo(15.232819f, 8.550406f);
                instancePath2.lineTo(20.456459f, 9.309445f);
                instancePath2.cubicTo(21.003004f, 9.388864f, 21.381685f, 9.896306f, 21.302267f, 10.442851f);
                instancePath2.cubicTo(21.270643f, 10.660488f, 21.168156f, 10.86163f, 21.010672f, 11.01514f);
                instancePath2.lineTo(17.23081f, 14.699594f);
                instancePath2.cubicTo(17.40354f, 15.706675f, 17.541647f, 16.511904f, 17.645134f, 17.11528f);
                instancePath2.lineTo(21.750967f, 21.219595f);
                instancePath2.lineTo(20.619596f, 22.350967f);
                instancePath2.lineTo(3.649033f, 5.380404f);
                instancePath2.lineTo(4.7804036f, 4.249033f);
                instancePath2.lineTo(8.871033f, 8.339329f);
                instancePath2.lineTo(11.103264f, 3.8169858f);
                instancePath2.cubicTo(11.347686f, 3.321732f, 11.947312f, 3.1183932f, 12.442566f, 3.3628154f);
                instancePath2.close();
                instancePath2.moveTo(12.0f, 5.616f);
                instancePath2.lineTo(10.065033f, 9.533328f);
                instancePath2.lineTo(15.685033f, 15.154328f);
                instancePath2.lineTo(15.5116415f, 14.141002f);
                instancePath2.lineTo(19.023f, 10.717f);
                instancePath2.lineTo(14.170314f, 10.012819f);
                instancePath2.lineTo(12.0f, 5.616f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint8);
                canvas.restore();
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint, looper);
                instancePaint9.setColor(-352965);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(17.688086f, 20.906256f);
                instancePath3.cubicTo(17.576086f, 20.980183f, 17.447294f, 21.03264f, 17.306551f, 21.05678f);
                instancePath3.cubicTo(17.089794f, 21.093956f, 16.866827f, 21.058641f, 16.672165f, 20.956303f);
                instancePath3.lineTo(12.0f, 18.5f);
                instancePath3.lineTo(7.3278346f, 20.956303f);
                instancePath3.cubicTo(6.8389897f, 21.213305f, 6.2343626f, 21.025356f, 5.9773617f, 20.536512f);
                instancePath3.cubicTo(5.875023f, 20.341852f, 5.839708f, 20.118883f, 5.876885f, 19.902126f);
                instancePath3.lineTo(6.7691894f, 14.699594f);
                instancePath3.lineTo(2.9893277f, 11.01514f);
                instancePath3.cubicTo(2.5938442f, 10.629638f, 2.5857518f, 9.996525f, 2.9712532f, 9.601041f);
                instancePath3.cubicTo(3.1247616f, 9.443558f, 3.3259041f, 9.34107f, 3.5435412f, 9.309445f);
                instancePath3.cubicTo(4.5368266f, 9.165113f, 5.2817907f, 9.056862f, 5.778434f, 8.984694f);
                instancePath3.cubicTo(5.778434f, 8.983784f, 9.748318f, 12.957638f, 17.688086f, 20.906256f);
                instancePath3.close();
                instancePath3.moveTo(7.1861296f, 10.392611f);
                instancePath3.lineTo(4.977f, 10.718f);
                instancePath3.lineTo(8.4883585f, 14.141002f);
                instancePath3.lineTo(7.659f, 18.974f);
                instancePath3.lineTo(12.0f, 16.692358f);
                instancePath3.lineTo(15.151225f, 18.367878f);
                instancePath3.lineTo(7.1861296f, 10.392611f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
                canvas.drawPath(instancePath3, instancePaint9);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
