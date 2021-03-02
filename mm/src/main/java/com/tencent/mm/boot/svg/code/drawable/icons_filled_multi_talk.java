package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_multi_talk extends c {
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
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(72.0f, 0.0f);
                instancePath.lineTo(72.0f, 72.0f);
                instancePath.lineTo(0.0f, 72.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(15.675893f, 11.268668f);
                instancePath2.cubicTo(16.465866f, 11.124417f, 17.099897f, 11.837961f, 17.645164f, 12.655303f);
                instancePath2.lineTo(19.31019f, 15.183616f);
                instancePath2.cubicTo(20.944593f, 17.68732f, 23.232452f, 21.304405f, 23.247145f, 22.062124f);
                instancePath2.cubicTo(23.291979f, 24.374443f, 19.923523f, 29.272577f, 19.769342f, 31.23948f);
                instancePath2.cubicTo(19.61807f, 33.16927f, 22.149683f, 38.32563f, 27.546892f, 43.821144f);
                instancePath2.lineTo(27.86145f, 44.13855f);
                instancePath2.cubicTo(33.474854f, 49.751953f, 38.79362f, 52.38484f, 40.76052f, 52.23066f);
                instancePath2.cubicTo(42.727425f, 52.076477f, 47.625557f, 48.70802f, 49.937878f, 48.752857f);
                instancePath2.cubicTo(50.72085f, 48.768036f, 54.556995f, 51.210457f, 57.062897f, 52.850964f);
                instancePath2.lineTo(59.190414f, 54.25362f);
                instancePath2.cubicTo(60.069496f, 54.821457f, 60.884598f, 55.48476f, 60.73133f, 56.32411f);
                instancePath2.lineTo(60.7103f, 56.41782f);
                instancePath2.cubicTo(60.388878f, 57.690575f, 57.15026f, 66.37172f, 49.238228f, 65.128555f);
                instancePath2.cubicTo(41.090015f, 63.84828f, 29.730268f, 55.064373f, 23.257206f, 48.742794f);
                instancePath2.lineTo(22.933697f, 48.409485f);
                instancePath2.lineTo(22.275108f, 47.71854f);
                instancePath2.cubicTo(16.061749f, 41.122807f, 8.086618f, 30.495668f, 6.8714447f, 22.761772f);
                instancePath2.cubicTo(5.5911727f, 14.61356f, 14.836547f, 11.421935f, 15.675893f, 11.268668f);
                instancePath2.close();
                instancePath2.moveTo(62.092823f, 9.868788f);
                instancePath2.lineTo(62.1f, 10.006461f);
                instancePath2.lineTo(62.1f, 24.783524f);
                instancePath2.cubicTo(62.1f, 25.505203f, 61.461605f, 25.976877f, 60.721874f, 25.736883f);
                instancePath2.lineTo(60.381054f, 25.399904f);
                instancePath2.cubicTo(59.51407f, 24.559996f, 57.233875f, 22.403002f, 55.327614f, 20.645962f);
                instancePath2.lineTo(54.75f, 20.115414f);
                instancePath2.lineTo(54.75f, 14.61777f);
                instancePath2.lineTo(60.721874f, 9.0531025f);
                instancePath2.lineTo(60.721874f, 9.0531025f);
                instancePath2.cubicTo(61.31496f, 8.882406f, 61.93436f, 9.126265f, 62.07189f, 9.740925f);
                instancePath2.lineTo(62.092823f, 9.868788f);
                instancePath2.close();
                instancePath2.moveTo(51.75113f, 10.05f);
                instancePath2.cubicTo(52.247562f, 10.05f, 52.65f, 10.435634f, 52.65f, 10.914672f);
                instancePath2.lineTo(52.65f, 23.885328f);
                instancePath2.cubicTo(52.65f, 24.362873f, 52.246502f, 24.75f, 51.75113f, 24.75f);
                instancePath2.lineTo(34.648872f, 24.75f);
                instancePath2.cubicTo(34.15244f, 24.75f, 33.75f, 24.364367f, 33.75f, 23.885328f);
                instancePath2.lineTo(33.75f, 10.914672f);
                instancePath2.cubicTo(33.75f, 10.437126f, 34.153496f, 10.05f, 34.648872f, 10.05f);
                instancePath2.lineTo(51.75113f, 10.05f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
