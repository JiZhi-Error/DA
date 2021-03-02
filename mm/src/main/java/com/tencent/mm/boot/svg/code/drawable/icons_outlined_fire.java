package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_fire extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(34.200806f, 7.552002f);
                instancePath.cubicTo(39.507114f, 7.552002f, 43.685303f, 12.014282f, 45.091553f, 16.47107f);
                instancePath.cubicTo(45.704063f, 18.412281f, 45.554214f, 20.441753f, 45.29449f, 22.318598f);
                instancePath.lineTo(44.94036f, 24.709461f);
                instancePath.cubicTo(44.68647f, 26.591227f, 44.65495f, 28.152386f, 45.740845f, 29.0625f);
                instancePath.cubicTo(47.662045f, 30.6727f, 49.98391f, 28.855038f, 51.687595f, 26.661251f);
                instancePath.lineTo(52.179134f, 25.994884f);
                instancePath.lineTo(52.627476f, 25.324259f);
                instancePath.cubicTo(52.76904f, 25.102043f, 52.902386f, 24.882168f, 53.026497f, 24.667688f);
                instancePath.cubicTo(55.80043f, 29.66374f, 57.44912f, 35.48198f, 57.44912f, 41.55088f);
                instancePath.cubicTo(57.44912f, 51.05503f, 51.26763f, 59.11542f, 42.70577f, 61.93093f);
                instancePath.cubicTo(41.475677f, 62.335438f, 39.768898f, 61.622997f, 39.8921f, 60.235847f);
                instancePath.cubicTo(39.925346f, 59.861546f, 39.94226f, 59.412838f, 39.94226f, 58.860718f);
                instancePath.cubicTo(39.94226f, 56.26245f, 38.6314f, 53.642212f, 36.00968f, 51.0f);
                instancePath.cubicTo(33.340508f, 53.642212f, 32.00592f, 56.26245f, 32.00592f, 58.860718f);
                instancePath.cubicTo(32.00592f, 59.32946f, 32.045155f, 59.79223f, 32.121117f, 60.238987f);
                instancePath.cubicTo(32.285305f, 61.204666f, 30.712719f, 62.38176f, 29.574339f, 62.024532f);
                instancePath.cubicTo(20.869337f, 59.292866f, 14.550882f, 51.15975f, 14.550882f, 41.55088f);
                instancePath.cubicTo(14.550882f, 33.741486f, 18.525185f, 27.913927f, 21.507238f, 24.716642f);
                instancePath.lineTo(22.229206f, 23.972494f);
                instancePath.lineTo(22.892584f, 23.340193f);
                instancePath.cubicTo(22.997307f, 23.244255f, 23.09887f, 23.15307f, 23.196913f, 23.066687f);
                instancePath.cubicTo(22.610746f, 25.77886f, 22.603514f, 31.248344f, 23.683264f, 32.03204f);
                instancePath.cubicTo(23.696754f, 32.041832f, 23.732718f, 32.001656f, 23.737024f, 31.972952f);
                instancePath.cubicTo(24.44823f, 27.232836f, 26.41998f, 23.772999f, 28.5083f, 20.927837f);
                instancePath.lineTo(29.294651f, 19.888416f);
                instancePath.lineTo(30.078524f, 18.89882f);
                instancePath.lineTo(31.585213f, 17.037907f);
                instancePath.lineTo(32.28122f, 16.15099f);
                instancePath.cubicTo(34.403484f, 13.376024f, 35.681896f, 10.881225f, 34.200806f, 7.552002f);
                instancePath.close();
                instancePath.moveTo(52.152f, 31.518f);
                instancePath.lineTo(52.05874f, 31.603495f);
                instancePath.cubicTo(49.432938f, 33.80492f, 46.444542f, 34.34949f, 43.42839f, 31.821587f);
                instancePath.cubicTo(41.39786f, 30.119755f, 40.93103f, 28.727163f, 41.21042f, 25.676441f);
                instancePath.lineTo(41.330063f, 24.59542f);
                instancePath.lineTo(41.498257f, 23.375385f);
                instancePath.lineTo(41.685535f, 22.122925f);
                instancePath.lineTo(41.817722f, 21.115044f);
                instancePath.lineTo(41.895847f, 20.277094f);
                instancePath.lineTo(41.922207f, 19.552797f);
                instancePath.cubicTo(41.92262f, 19.324055f, 41.914787f, 19.104876f, 41.89909f, 18.885881f);
                instancePath.cubicTo(41.86378f, 18.39323f, 41.78432f, 17.95341f, 41.658398f, 17.554333f);
                instancePath.cubicTo(41.03511f, 15.578964f, 39.79715f, 13.839796f, 38.283604f, 12.674557f);
                instancePath.lineTo(38.169f, 12.588f);
                instancePath.lineTo(38.093853f, 12.905689f);
                instancePath.cubicTo(37.873104f, 13.709835f, 37.550766f, 14.509405f, 37.13262f, 15.308198f);
                instancePath.lineTo(36.801144f, 15.907207f);
                instancePath.cubicTo(36.306377f, 16.755724f, 35.735603f, 17.57299f, 34.96167f, 18.57046f);
                instancePath.lineTo(32.001225f, 22.273218f);
                instancePath.cubicTo(29.540743f, 25.46779f, 28.103058f, 28.228533f, 27.445461f, 31.64005f);
                instancePath.lineTo(27.297174f, 32.507114f);
                instancePath.cubicTo(26.961054f, 34.747326f, 24.71665f, 37.230385f, 21.56863f, 34.945515f);
                instancePath.cubicTo(20.989494f, 34.52517f, 20.526567f, 33.904247f, 20.166746f, 33.143307f);
                instancePath.lineTo(20.103f, 32.994f);
                instancePath.lineTo(19.79558f, 33.67437f);
                instancePath.cubicTo(18.86436f, 35.834835f, 18.27713f, 38.1994f, 18.168997f, 40.70904f);
                instancePath.lineTo(18.150883f, 41.55088f);
                instancePath.cubicTo(18.150883f, 48.37215f, 22.001228f, 54.372322f, 27.71795f, 57.372517f);
                instancePath.lineTo(28.464f, 57.741f);
                instancePath.lineTo(28.488556f, 57.49233f);
                instancePath.cubicTo(28.845596f, 54.547157f, 30.352749f, 51.730568f, 32.87663f, 49.056164f);
                instancePath.lineTo(33.47705f, 48.441525f);
                instancePath.lineTo(36.0325f, 45.911892f);
                instancePath.lineTo(38.565155f, 48.464344f);
                instancePath.cubicTo(41.39886f, 51.320198f, 43.08418f, 54.337883f, 43.46123f, 57.49781f);
                instancePath.lineTo(43.485f, 57.759f);
                instancePath.lineTo(43.629936f, 57.694798f);
                instancePath.cubicTo(49.50195f, 54.91629f, 53.57066f, 49.037636f, 53.835384f, 42.255604f);
                instancePath.lineTo(53.849117f, 41.55088f);
                instancePath.cubicTo(53.849117f, 38.58419f, 53.406483f, 35.631187f, 52.561577f, 32.790985f);
                instancePath.lineTo(52.152f, 31.518f);
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
