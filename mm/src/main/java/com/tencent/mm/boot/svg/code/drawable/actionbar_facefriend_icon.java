package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class actionbar_facefriend_icon extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(5.1f, 59.4f);
                instancePath.lineTo(54.9f, 59.4f);
                instancePath.lineTo(54.9f, 57.94639f);
                instancePath.cubicTo(54.9f, 57.25818f, 54.19404f, 56.13006f, 53.57943f, 55.83026f);
                instancePath.lineTo(36.59837f, 47.54712f);
                instancePath.cubicTo(32.018623f, 45.31318f, 30.886719f, 39.90874f, 34.16801f, 36.019104f);
                instancePath.lineTo(35.25261f, 34.733425f);
                instancePath.cubicTo(36.906586f, 32.772804f, 38.4f, 28.693172f, 38.4f, 26.130558f);
                instancePath.lineTo(38.4f, 21.000622f);
                instancePath.cubicTo(38.4f, 16.364742f, 34.63677f, 12.6f, 30.0f, 12.6f);
                instancePath.cubicTo(25.368927f, 12.6f, 21.6f, 16.365608f, 21.6f, 20.998741f);
                instancePath.lineTo(21.6f, 26.127872f);
                instancePath.cubicTo(21.6f, 28.696991f, 23.08724f, 32.76145f, 24.747236f, 34.728935f);
                instancePath.lineTo(25.831833f, 36.01444f);
                instancePath.cubicTo(29.11991f, 39.91158f, 27.975643f, 45.31095f, 23.402159f, 47.54276f);
                instancePath.lineTo(6.4210987f, 55.82933f);
                instancePath.cubicTo(5.8110514f, 56.127026f, 5.1f, 57.26603f, 5.1f, 57.94639f);
                instancePath.lineTo(5.1f, 59.4f);
                instancePath.close();
                instancePath.moveTo(21.995739f, 37.050415f);
                instancePath.cubicTo(19.788954f, 34.434856f, 18.0f, 29.548489f, 18.0f, 26.127872f);
                instancePath.lineTo(18.0f, 20.998741f);
                instancePath.cubicTo(18.0f, 14.37202f, 23.386068f, 9.0f, 30.0f, 9.0f);
                instancePath.cubicTo(36.62742f, 9.0f, 42.0f, 14.378941f, 42.0f, 21.000622f);
                instancePath.lineTo(42.0f, 26.130558f);
                instancePath.cubicTo(42.0f, 29.547888f, 40.202797f, 34.44858f, 38.00426f, 37.054718f);
                instancePath.lineTo(36.919662f, 38.340397f);
                instancePath.cubicTo(35.151096f, 40.43685f, 35.703564f, 43.105194f, 38.176647f, 44.31153f);
                instancePath.lineTo(55.157707f, 52.594673f);
                instancePath.cubicTo(57.003605f, 53.49508f, 58.5f, 55.87551f, 58.5f, 57.94639f);
                instancePath.lineTo(58.5f, 60.004684f);
                instancePath.cubicTo(58.5f, 61.65895f, 57.147224f, 63.0f, 55.495712f, 63.0f);
                instancePath.lineTo(4.5042887f, 63.0f);
                instancePath.cubicTo(2.8450658f, 63.0f, 1.5f, 61.667267f, 1.5f, 60.004684f);
                instancePath.lineTo(1.5f, 57.94639f);
                instancePath.cubicTo(1.5f, 55.891125f, 2.9944527f, 53.495724f, 4.842293f, 52.593998f);
                instancePath.lineTo(21.823353f, 44.30743f);
                instancePath.cubicTo(24.28613f, 43.10562f, 24.858778f, 40.443787f, 23.080336f, 38.33592f);
                instancePath.lineTo(21.995739f, 37.050415f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(42.77773f, 12.601175f);
                instancePath2.cubicTo(43.87313f, 12.211928f, 45.052574f, 12.0f, 46.281265f, 12.0f);
                instancePath2.lineTo(46.718735f, 12.0f);
                instancePath2.cubicTo(52.488968f, 12.0f, 57.166668f, 16.679132f, 57.166668f, 22.426958f);
                instancePath2.lineTo(57.166668f, 26.224447f);
                instancePath2.cubicTo(57.166668f, 29.100399f, 55.586826f, 33.146996f, 53.64127f, 35.259216f);
                instancePath2.lineTo(52.45809f, 36.54375f);
                instancePath2.cubicTo(50.89642f, 38.2392f, 51.303f, 40.420994f, 53.385597f, 41.426277f);
                instancePath2.lineTo(67.68544f, 48.328896f);
                instancePath2.cubicTo(69.239876f, 49.07923f, 70.5f, 51.097424f, 70.5f, 52.831097f);
                instancePath2.lineTo(70.5f, 54.92409f);
                instancePath2.cubicTo(70.5f, 56.070583f, 69.562706f, 57.0f, 68.40664f, 57.0f);
                instancePath2.lineTo(61.5f, 57.0f);
                instancePath2.cubicTo(61.5f, 55.734264f, 60.82772f, 54.570892f, 59.73675f, 53.942154f);
                instancePath2.lineTo(47.184334f, 46.708065f);
                instancePath2.cubicTo(45.729706f, 45.869747f, 44.833332f, 44.318584f, 44.833332f, 42.63968f);
                instancePath2.lineTo(44.833332f, 19.23913f);
                instancePath2.cubicTo(44.833332f, 16.775564f, 44.074463f, 14.4892435f, 42.77773f, 12.601175f);
                instancePath2.close();
                instancePath2.moveTo(61.5f, 53.4f);
                instancePath2.lineTo(66.9f, 53.4f);
                instancePath2.lineTo(66.9f, 52.831097f);
                instancePath2.cubicTo(66.9f, 52.475437f, 66.42734f, 51.719067f, 66.120476f, 51.570946f);
                instancePath2.lineTo(51.82064f, 44.668327f);
                instancePath2.cubicTo(47.562214f, 42.612762f, 46.61134f, 37.57765f, 49.810184f, 34.10478f);
                instancePath2.lineTo(50.993362f, 32.820244f);
                instancePath2.cubicTo(52.327118f, 31.37223f, 53.566666f, 28.196087f, 53.566666f, 26.224447f);
                instancePath2.lineTo(53.566666f, 22.426958f);
                instancePath2.cubicTo(53.566666f, 18.664661f, 50.498043f, 15.6f, 46.718735f, 15.6f);
                instancePath2.lineTo(46.281265f, 15.6f);
                instancePath2.cubicTo(45.615555f, 15.6f, 44.966045f, 15.693862f, 44.34456f, 15.876227f);
                instancePath2.cubicTo(44.662544f, 16.941574f, 44.833332f, 18.070406f, 44.833332f, 19.23913f);
                instancePath2.lineTo(44.833332f, 42.63968f);
                instancePath2.cubicTo(44.833332f, 44.318584f, 45.729706f, 45.869747f, 47.184334f, 46.708065f);
                instancePath2.lineTo(59.73675f, 53.942154f);
                instancePath2.cubicTo(60.82772f, 54.570892f, 61.5f, 55.734264f, 61.5f, 56.993443f);
                instancePath2.lineTo(61.5f, 53.4f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
