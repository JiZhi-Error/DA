package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class force_notify_show_ui_icon extends c {
    private final int height = 192;
    private final int width = 192;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 192;
            case 1:
                return 192;
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
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(192.0f, 0.0f);
                instancePath.lineTo(192.0f, 192.0f);
                instancePath.lineTo(0.0f, 192.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-352965);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(82.96147f, 8.827505f);
                instancePath2.lineTo(90.82743f, 8.827505f);
                instancePath2.cubicTo(93.257484f, 8.827505f, 95.22743f, 10.797452f, 95.22743f, 13.227505f);
                instancePath2.cubicTo(95.227036f, 13.300007f, 95.227036f, 13.300007f, 95.225044f, 13.372481f);
                instancePath2.lineTo(94.156906f, 45.77248f);
                instancePath2.cubicTo(94.0787f, 48.14481f, 92.13292f, 50.027504f, 89.7593f, 50.027504f);
                instancePath2.lineTo(84.0296f, 50.027504f);
                instancePath2.cubicTo(81.65598f, 50.027504f, 79.710205f, 48.14481f, 79.631996f, 45.77248f);
                instancePath2.lineTo(78.56386f, 13.372481f);
                instancePath2.cubicTo(78.483795f, 10.943748f, 80.387764f, 8.909963f, 82.8165f, 8.829894f);
                instancePath2.cubicTo(82.88897f, 8.827904f, 82.88897f, 8.827904f, 82.96147f, 8.827505f);
                instancePath2.close();
                instancePath2.moveTo(142.83047f, 33.626076f);
                instancePath2.cubicTo(144.54878f, 35.344383f, 144.54878f, 38.13031f, 142.83047f, 39.848618f);
                instancePath2.cubicTo(142.77893f, 39.8996f, 142.77893f, 39.8996f, 142.72627f, 39.94944f);
                instancePath2.lineTo(119.06073f, 62.104416f);
                instancePath2.cubicTo(117.327934f, 63.726604f, 114.62079f, 63.681995f, 112.94239f, 62.003593f);
                instancePath2.lineTo(108.890884f, 57.952087f);
                instancePath2.cubicTo(107.21249f, 56.273685f, 107.16787f, 53.56654f, 108.79006f, 51.83375f);
                instancePath2.lineTo(130.94504f, 28.168207f);
                instancePath2.cubicTo(132.60579f, 26.394217f, 135.39021f, 26.302422f, 137.1642f, 27.96318f);
                instancePath2.cubicTo(137.21686f, 28.01302f, 137.21686f, 28.01302f, 137.2684f, 28.064005f);
                instancePath2.lineTo(142.83047f, 33.626076f);
                instancePath2.close();
                instancePath2.moveTo(162.06694f, 80.06706f);
                instancePath2.lineTo(162.06694f, 87.93302f);
                instancePath2.cubicTo(162.06694f, 90.363075f, 160.09698f, 92.333015f, 157.66695f, 92.333015f);
                instancePath2.cubicTo(157.59444f, 92.33262f, 157.59444f, 92.33262f, 157.52196f, 92.33063f);
                instancePath2.lineTo(125.12196f, 91.2625f);
                instancePath2.cubicTo(122.74963f, 91.18429f, 120.866936f, 89.2385f, 120.866936f, 86.86488f);
                instancePath2.lineTo(120.866936f, 81.13519f);
                instancePath2.cubicTo(120.866936f, 78.76157f, 122.74963f, 76.81579f, 125.12196f, 76.73758f);
                instancePath2.lineTo(157.52196f, 75.66945f);
                instancePath2.cubicTo(159.9507f, 75.58938f, 161.98448f, 77.49335f, 162.06454f, 79.92208f);
                instancePath2.cubicTo(162.06654f, 79.99456f, 162.06654f, 79.99456f, 162.06694f, 80.06706f);
                instancePath2.close();
                instancePath2.moveTo(56.0f, 48.0f);
                instancePath2.lineTo(56.0f, 160.0f);
                instancePath2.lineTo(120.0f, 160.0f);
                instancePath2.lineTo(120.0f, 112.0f);
                instancePath2.lineTo(136.0f, 112.0f);
                instancePath2.lineTo(136.0f, 168.0f);
                instancePath2.cubicTo(136.0f, 172.41827f, 132.41827f, 176.0f, 128.0f, 176.0f);
                instancePath2.lineTo(48.0f, 176.0f);
                instancePath2.cubicTo(43.581722f, 176.0f, 40.0f, 172.41827f, 40.0f, 168.0f);
                instancePath2.lineTo(40.0f, 40.0f);
                instancePath2.cubicTo(40.0f, 35.581722f, 43.581722f, 32.0f, 48.0f, 32.0f);
                instancePath2.lineTo(64.0f, 32.0f);
                instancePath2.lineTo(64.0f, 48.0f);
                instancePath2.lineTo(56.0f, 48.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
