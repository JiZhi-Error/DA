package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_mobile_contacts extends c {
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
                instancePath.moveTo(5.2f, 3.2f);
                instancePath.lineTo(5.2f, 20.8f);
                instancePath.lineTo(18.8f, 20.8f);
                instancePath.lineTo(18.8f, 3.2f);
                instancePath.lineTo(5.2f, 3.2f);
                instancePath.close();
                instancePath.moveTo(4.0f, 3.0f);
                instancePath.cubicTo(4.0f, 2.4477153f, 4.4477153f, 2.0f, 5.0f, 2.0f);
                instancePath.lineTo(19.0f, 2.0f);
                instancePath.cubicTo(19.552284f, 2.0f, 20.0f, 2.4477153f, 20.0f, 3.0f);
                instancePath.lineTo(20.0f, 21.0f);
                instancePath.cubicTo(20.0f, 21.552284f, 19.552284f, 22.0f, 19.0f, 22.0f);
                instancePath.lineTo(5.0f, 22.0f);
                instancePath.cubicTo(4.4477153f, 22.0f, 4.0f, 21.552284f, 4.0f, 21.0f);
                instancePath.lineTo(4.0f, 3.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(14.909363f, 13.806107f);
                instancePath2.cubicTo(14.816827f, 13.775308f, 14.77827f, 13.790707f, 14.693445f, 13.8369055f);
                instancePath2.cubicTo(14.415836f, 13.990901f, 13.737239f, 14.36049f, 13.336249f, 14.568383f);
                instancePath2.cubicTo(13.236002f, 14.622281f, 13.128043f, 14.653081f, 13.004662f, 14.653081f);
                instancePath2.cubicTo(12.873569f, 14.653081f, 12.757898f, 14.614582f, 12.657651f, 14.552983f);
                instancePath2.cubicTo(12.094723f, 14.221894f, 11.56264f, 13.8369055f, 11.107671f, 13.37492f);
                instancePath2.cubicTo(10.652701f, 12.920633f, 10.267135f, 12.38935f, 9.935547f, 11.827268f);
                instancePath2.cubicTo(9.873857f, 11.72717f, 9.8352995f, 11.603974f, 9.8352995f, 11.480778f);
                instancePath2.cubicTo(9.8352995f, 11.365281f, 9.866145f, 11.249784f, 9.920124f, 11.149688f);
                instancePath2.cubicTo(10.12833f, 10.7416f, 10.498475f, 10.064021f, 10.652701f, 9.79453f);
                instancePath2.cubicTo(10.69897f, 9.709832f, 10.714393f, 9.663633f, 10.683547f, 9.578937f);
                instancePath2.lineTo(10.028083f, 7.8387895f);
                instancePath2.cubicTo(9.943258f, 7.6385956f, 9.750475f, 7.5077f, 9.5191345f, 7.5f);
                instancePath2.cubicTo(9.426599f, 7.5f, 9.31864f, 7.538499f, 9.295506f, 7.5461984f);
                instancePath2.cubicTo(8.539794f, 7.82339f, 8.0f, 8.539468f, 8.0f, 9.386442f);
                instancePath2.cubicTo(8.0f, 9.625134f, 8.06169f, 9.848428f, 8.069402f, 9.902327f);
                instancePath2.cubicTo(8.439547f, 11.519277f, 9.26466f, 12.959132f, 10.398228f, 14.090998f);
                instancePath2.cubicTo(11.531795f, 15.222863f, 12.973816f, 16.046738f, 14.593198f, 16.416327f);
                instancePath2.cubicTo(14.647177f, 16.431726f, 14.870806f, 16.485624f, 15.109858f, 16.485624f);
                instancePath2.cubicTo(15.958105f, 16.485624f, 16.67526f, 15.946641f, 16.95287f, 15.192064f);
                instancePath2.cubicTo(16.960579f, 15.168964f, 17.006847f, 15.061168f, 16.999136f, 14.968771f);
                instancePath2.cubicTo(16.983713f, 14.737778f, 16.852621f, 14.545284f, 16.652126f, 14.460587f);
                instancePath2.lineTo(14.909363f, 13.806107f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
