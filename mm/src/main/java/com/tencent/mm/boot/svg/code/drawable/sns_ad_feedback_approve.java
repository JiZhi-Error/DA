package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sns_ad_feedback_approve extends c {
    private final int height = 20;
    private final int width = 20;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 20;
            case 1:
                return 20;
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(12.544887f, 3.3524082f);
                instancePath.cubicTo(13.055026f, 4.103902f, 13.192008f, 4.8967404f, 13.192008f, 6.563511f);
                instancePath.cubicTo(13.192008f, 7.018297f, 13.323089f, 7.253429f, 13.538974f, 7.37792f);
                instancePath.cubicTo(13.66419f, 7.450127f, 13.799015f, 7.475022f, 13.876532f, 7.4737535f);
                instancePath.cubicTo(14.218131f, 7.479347f, 14.67906f, 7.5401573f, 15.151651f, 7.710752f);
                instancePath.cubicTo(15.738536f, 7.922604f, 16.188656f, 8.263258f, 16.417484f, 8.773159f);
                instancePath.cubicTo(17.234251f, 10.593179f, 16.823257f, 15.012711f, 14.904936f, 16.59183f);
                instancePath.cubicTo(14.329365f, 17.065813f, 13.1730995f, 17.5f, 12.279662f, 17.573168f);
                instancePath.cubicTo(11.723206f, 17.618624f, 8.874112f, 17.612574f, 3.7834377f, 17.58011f);
                instancePath.cubicTo(3.0743093f, 17.575884f, 2.5f, 17.00643f, 2.5f, 16.301304f);
                instancePath.lineTo(2.5f, 10.23421f);
                instancePath.cubicTo(2.5f, 9.526037f, 3.080726f, 8.955395f, 3.793096f, 8.955395f);
                instancePath.lineTo(5.355313f, 8.955395f);
                instancePath.cubicTo(5.7444196f, 8.955395f, 6.10831f, 8.918886f, 6.5424423f, 8.823347f);
                instancePath.cubicTo(6.848752f, 8.755902f, 7.1032434f, 8.634685f, 7.57084f, 8.36051f);
                instancePath.cubicTo(8.094898f, 8.053254f, 8.403719f, 7.7045374f, 8.635541f, 7.0915427f);
                instancePath.cubicTo(8.766617f, 6.7444096f, 8.811127f, 6.403869f, 8.858788f, 5.39625f);
                instancePath.cubicTo(8.865109f, 5.262828f, 8.86669f, 5.220846f, 8.877431f, 4.917976f);
                instancePath.cubicTo(8.926145f, 3.5443995f, 9.071791f, 3.0550017f, 9.832507f, 2.7017379f);
                instancePath.cubicTo(10.84919f, 2.229546f, 12.063682f, 2.6433883f, 12.544887f, 3.3524082f);
                instancePath.close();
                instancePath.moveTo(10.253691f, 3.6087132f);
                instancePath.cubicTo(9.955756f, 3.7470691f, 9.916131f, 3.8444688f, 9.876802f, 4.9534187f);
                instancePath.cubicTo(9.865659f, 5.267646f, 9.864084f, 5.308139f, 9.857671f, 5.443498f);
                instancePath.cubicTo(9.805137f, 6.5541425f, 9.750492f, 6.969622f, 9.5708885f, 7.4452734f);
                instancePath.cubicTo(9.2629795f, 8.259458f, 8.80961f, 8.79342f, 8.07665f, 9.223155f);
                instancePath.cubicTo(7.5058575f, 9.5578375f, 7.1768904f, 9.707605f, 6.7573695f, 9.799976f);
                instancePath.cubicTo(6.2662635f, 9.908054f, 5.8306503f, 9.955395f, 5.355313f, 9.955395f);
                instancePath.lineTo(3.793096f, 9.955395f);
                instancePath.cubicTo(3.6288197f, 9.955395f, 3.5f, 10.08254f, 3.5f, 10.23421f);
                instancePath.lineTo(3.5f, 16.301304f);
                instancePath.cubicTo(3.5f, 16.45302f, 3.6267867f, 16.579159f, 3.7898145f, 16.580132f);
                instancePath.cubicTo(9.277115f, 16.615122f, 11.72764f, 16.61493f, 12.198049f, 16.576504f);
                instancePath.cubicTo(12.894387f, 16.519484f, 13.857486f, 16.158968f, 14.26939f, 15.819765f);
                instancePath.cubicTo(15.651137f, 14.682343f, 16.253471f, 10.850104f, 15.505142f, 9.182589f);
                instancePath.cubicTo(15.407447f, 8.964891f, 15.191441f, 8.788273f, 14.812119f, 8.651346f);
                instancePath.cubicTo(14.495332f, 8.536993f, 14.153944f, 8.478431f, 13.892894f, 8.473619f);
                instancePath.cubicTo(13.617981f, 8.478119f, 13.307423f, 8.398748f, 13.039426f, 8.244206f);
                instancePath.cubicTo(12.461014f, 7.910662f, 12.192008f, 7.3200655f, 12.192008f, 6.563511f);
                instancePath.cubicTo(12.192008f, 5.0326962f, 12.076506f, 4.4428973f, 11.717512f, 3.9140582f);
                instancePath.cubicTo(11.477591f, 3.5605516f, 10.7702465f, 3.3688018f, 10.253691f, 3.6087132f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
