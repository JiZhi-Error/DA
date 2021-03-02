package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sharemore_voipvoice extends c {
    private final int height = 54;
    private final int width = 54;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 54;
            case 1:
                return 54;
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
                instancePaint3.setColor(-8683387);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(22.908676f, 30.950693f);
                instancePath.cubicTo(27.023159f, 35.1021f, 30.232687f, 36.895073f, 32.456608f, 36.895073f);
                instancePath.cubicTo(34.680527f, 36.895073f, 37.381214f, 34.49798f, 39.075436f, 34.45544f);
                instancePath.cubicTo(40.475136f, 34.420296f, 45.419086f, 37.832767f, 45.94186f, 38.32456f);
                instancePath.cubicTo(46.464634f, 38.816353f, 47.099957f, 39.55505f, 46.986763f, 40.05478f);
                instancePath.cubicTo(46.87357f, 40.55451f, 44.11331f, 47.862286f, 38.14088f, 46.915455f);
                instancePath.cubicTo(32.16845f, 45.968628f, 23.842045f, 39.47246f, 19.097456f, 34.797325f);
                instancePath.lineTo(22.908676f, 30.950693f);
                instancePath.close();
                instancePath.moveTo(16.985262f, 21.787113f);
                instancePath.cubicTo(17.054878f, 19.63332f, 19.520647f, 16.662056f, 19.493423f, 14.951664f);
                instancePath.cubicTo(19.463087f, 13.04565f, 16.725452f, 8.970869f, 15.613527f, 7.9975863f);
                instancePath.cubicTo(14.5016f, 7.024304f, 14.318393f, 6.923723f, 13.703174f, 7.037072f);
                instancePath.cubicTo(13.0879545f, 7.150421f, 6.1487045f, 9.55696f, 7.0871115f, 15.582992f);
                instancePath.cubicTo(8.025518f, 21.609024f, 14.463901f, 30.010153f, 19.097456f, 34.797325f);
                instancePath.lineTo(22.911219f, 30.946669f);
                instancePath.cubicTo(18.796738f, 26.79526f, 16.915646f, 23.940908f, 16.985262f, 21.787113f);
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
