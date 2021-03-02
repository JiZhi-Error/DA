package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class offline_entrance_f2f_lucky extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(16.997526f, 3.2f);
                instancePath.cubicTo(17.551178f, 3.2f, 18.0f, 3.6500537f, 18.0f, 4.199581f);
                instancePath.lineTo(18.0f, 10.062f);
                instancePath.lineTo(20.292656f, 11.34288f);
                instancePath.cubicTo(20.455315f, 11.433762f, 20.564934f, 11.593962f, 20.592934f, 11.774771f);
                instancePath.lineTo(20.6f, 11.866667f);
                instancePath.lineTo(20.6f, 20.2f);
                instancePath.cubicTo(20.6f, 20.53137f, 20.331371f, 20.8f, 20.0f, 20.8f);
                instancePath.lineTo(20.0f, 20.8f);
                instancePath.lineTo(18.295454f, 20.8f);
                instancePath.cubicTo(17.44173f, 20.8f, 16.69018f, 19.919174f, 16.20843f, 18.799942f);
                instancePath.lineTo(7.7894f, 18.804977f);
                instancePath.cubicTo(7.3075647f, 19.921816f, 6.556989f, 20.8f, 5.7045455f, 20.8f);
                instancePath.lineTo(4.0f, 20.8f);
                instancePath.cubicTo(3.6686292f, 20.8f, 3.4f, 20.53137f, 3.4f, 20.2f);
                instancePath.lineTo(3.4f, 11.866667f);
                instancePath.cubicTo(3.4f, 11.649287f, 3.5175765f, 11.448909f, 3.7073445f, 11.34288f);
                instancePath.lineTo(6.0f, 10.061f);
                instancePath.lineTo(6.0007863f, 8.188833f);
                instancePath.cubicTo(6.000458f, 8.188686f, 6.000129f, 8.1885395f, 5.9998007f, 8.188394f);
                instancePath.lineTo(6.0003242f, 7.200138f);
                instancePath.lineTo(6.0f, 4.199581f);
                instancePath.cubicTo(6.0f, 3.6475277f, 6.455761f, 3.2f, 7.0024734f, 3.2f);
                instancePath.lineTo(16.997526f, 3.2f);
                instancePath.close();
                instancePath.moveTo(5.781725f, 11.558466f);
                instancePath.lineTo(4.6f, 12.218731f);
                instancePath.lineTo(4.6f, 19.6f);
                instancePath.lineTo(5.7045455f, 19.6f);
                instancePath.cubicTo(6.2559605f, 19.6f, 7.157728f, 17.560911f, 7.1500096f, 16.203411f);
                instancePath.cubicTo(7.1486096f, 15.957215f, 7.297752f, 15.735149f, 7.5261817f, 15.643309f);
                instancePath.cubicTo(7.5355453f, 15.639544f, 7.7595725f, 15.562558f, 7.8661246f, 15.5217705f);
                instancePath.cubicTo(8.060586f, 15.447331f, 8.246862f, 15.363797f, 8.417936f, 15.269865f);
                instancePath.cubicTo(8.673977f, 15.129279f, 8.86824f, 14.979343f, 9.042405f, 14.763948f);
                instancePath.cubicTo(9.31162f, 14.509497f, 9.471106f, 14.0319195f, 9.520088f, 13.532683f);
                instancePath.cubicTo(9.513984f, 13.531677f, 9.507778f, 13.530678f, 9.501472f, 13.529685f);
                instancePath.cubicTo(9.241013f, 13.488678f, 8.865994f, 13.466028f, 8.394492f, 13.459088f);
                instancePath.cubicTo(8.10244f, 13.45479f, 7.824297f, 13.4562645f, 7.4040403f, 13.462167f);
                instancePath.cubicTo(7.228623f, 13.464701f, 7.228623f, 13.464701f, 7.060964f, 13.466623f);
                instancePath.cubicTo(6.121178f, 13.4553175f, 5.8212047f, 12.72472f, 5.781725f, 11.558466f);
                instancePath.close();
                instancePath.moveTo(18.218275f, 11.558466f);
                instancePath.cubicTo(18.178795f, 12.72472f, 17.878822f, 13.4553175f, 16.939035f, 13.466623f);
                instancePath.cubicTo(16.771378f, 13.464701f, 16.771378f, 13.464701f, 16.595959f, 13.462167f);
                instancePath.cubicTo(16.175703f, 13.4562645f, 15.89756f, 13.45479f, 15.605508f, 13.459088f);
                instancePath.cubicTo(15.134006f, 13.466028f, 14.758987f, 13.488678f, 14.498528f, 13.529685f);
                instancePath.cubicTo(14.492222f, 13.530678f, 14.486016f, 13.531677f, 14.479912f, 13.532683f);
                instancePath.cubicTo(14.528894f, 14.0319195f, 14.68838f, 14.509497f, 14.957595f, 14.763948f);
                instancePath.cubicTo(15.13176f, 14.979343f, 15.326023f, 15.129279f, 15.582064f, 15.269865f);
                instancePath.cubicTo(15.753138f, 15.363797f, 15.939414f, 15.447331f, 16.133875f, 15.5217705f);
                instancePath.cubicTo(16.240427f, 15.562558f, 16.464455f, 15.639544f, 16.473818f, 15.643309f);
                instancePath.cubicTo(16.702248f, 15.735149f, 16.85139f, 15.957215f, 16.84999f, 16.203411f);
                instancePath.cubicTo(16.842272f, 17.560911f, 17.74404f, 19.6f, 18.295454f, 19.6f);
                instancePath.lineTo(18.295454f, 19.6f);
                instancePath.lineTo(19.4f, 19.6f);
                instancePath.lineTo(19.4f, 12.218731f);
                instancePath.close();
                instancePath.moveTo(11.832934f, 9.433738f);
                instancePath.cubicTo(10.163565f, 9.433738f, 8.588236f, 9.132588f, 7.198762f, 8.658633f);
                instancePath.lineTo(7.1991496f, 12.26495f);
                instancePath.cubicTo(7.2447896f, 12.264341f, 7.288078f, 12.263716f, 7.3871894f, 12.262285f);
                instancePath.cubicTo(7.8181477f, 12.256232f, 8.105707f, 12.254708f, 8.41215f, 12.259218f);
                instancePath.cubicTo(10.165435f, 12.285023f, 10.736363f, 12.37491f, 10.736363f, 13.2f);
                instancePath.cubicTo(10.736363f, 14.110157f, 10.498004f, 15.039351f, 9.931616f, 15.563874f);
                instancePath.cubicTo(9.704937f, 15.861069f, 9.385616f, 16.107527f, 8.995492f, 16.321733f);
                instancePath.cubicTo(8.783638f, 16.438059f, 8.562324f, 16.538456f, 8.33426f, 16.62735f);
                instancePath.cubicTo(8.310042f, 16.944628f, 8.258484f, 17.273233f, 8.1829195f, 17.600378f);
                instancePath.lineTo(15.816849f, 17.599375f);
                instancePath.cubicTo(15.741411f, 17.272562f, 15.689933f, 16.944304f, 15.665741f, 16.62735f);
                instancePath.cubicTo(15.437676f, 16.538456f, 15.216362f, 16.438059f, 15.004508f, 16.321733f);
                instancePath.cubicTo(14.614384f, 16.107527f, 14.295063f, 15.861069f, 14.068384f, 15.563874f);
                instancePath.cubicTo(13.501996f, 15.039351f, 13.263637f, 14.110157f, 13.263637f, 13.2f);
                instancePath.cubicTo(13.263637f, 12.37491f, 13.834565f, 12.285023f, 15.58785f, 12.259218f);
                instancePath.cubicTo(15.894293f, 12.254708f, 16.181852f, 12.256232f, 16.61281f, 12.262285f);
                instancePath.cubicTo(16.711922f, 12.263716f, 16.75521f, 12.264341f, 16.80085f, 12.26495f);
                instancePath.lineTo(16.801668f, 8.539898f);
                instancePath.cubicTo(15.332701f, 9.081726f, 13.637779f, 9.433738f, 11.832934f, 9.433738f);
                instancePath.close();
                instancePath.moveTo(16.800001f, 4.3999996f);
                instancePath.lineTo(7.2f, 4.3999996f);
                instancePath.lineTo(7.198556f, 7.645903f);
                instancePath.cubicTo(8.571887f, 8.086834f, 10.151837f, 8.367416f, 11.832934f, 8.367416f);
                instancePath.cubicTo(13.652234f, 8.367416f, 15.353074f, 8.038804f, 16.801771f, 7.533972f);
                instancePath.lineTo(16.800001f, 4.3999996f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
