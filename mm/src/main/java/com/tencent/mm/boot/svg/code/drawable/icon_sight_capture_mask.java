package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icon_sight_capture_mask extends c {
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
                Matrix instanceMatrix = c.instanceMatrix(looper);
                float[] instanceMatrixArray = c.instanceMatrixArray(looper);
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
                instancePaint3.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 33.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(49.36591f, 13.591381f);
                instancePath.cubicTo(61.974216f, 5.669526f, 76.43786f, -0.0890914f, 91.50997f, 0.0010434911f);
                instancePath.cubicTo(106.56214f, -0.07907641f, 121.00583f, 5.6595116f, 133.60416f, 13.571351f);
                instancePath.cubicTo(153.29466f, 26.32043f, 169.7134f, 43.736492f, 183.0f, 63.00533f);
                instancePath.cubicTo(172.90538f, 77.80748f, 160.7958f, 91.267624f, 147.01047f, 102.70474f);
                instancePath.cubicTo(134.60165f, 112.81988f, 120.39736f, 121.36266f, 104.59708f, 124.65759f);
                instancePath.cubicTo(91.1808f, 127.50185f, 76.96653f, 125.729195f, 64.42805f, 120.26101f);
                instancePath.cubicTo(49.924507f, 114.28207f, 37.306225f, 104.55751f, 25.984684f, 93.801414f);
                instancePath.cubicTo(16.33893f, 84.4374f, 7.551019f, 74.142f, 0.0f, 63.00533f);
                instancePath.cubicTo(13.276628f, 43.74651f, 29.68538f, 26.34046f, 49.36591f, 13.591381f);
                instancePath.lineTo(49.36591f, 13.591381f);
                instancePath.close();
                instancePath.moveTo(57.922127f, 11.815232f);
                instancePath.cubicTo(35.62434f, 23.804834f, 17.612675f, 42.54858f, 3.0f, 63.000843f);
                instancePath.cubicTo(14.612391f, 79.44658f, 28.55723f, 94.373634f, 44.894318f, 106.1734f);
                instancePath.cubicTo(58.61987f, 115.88498f, 74.817406f, 123.32853f, 91.931984f, 122.98882f);
                instancePath.cubicTo(109.365524f, 122.76901f, 125.62287f, 114.696014f, 139.39825f, 104.52483f);
                instancePath.cubicTo(154.7286f, 92.954865f, 167.9458f, 78.697235f, 179.0f, 63.000843f);
                instancePath.cubicTo(173.14896f, 54.608124f, 166.5902f, 46.724957f, 159.5131f, 39.341362f);
                instancePath.cubicTo(144.49176f, 23.974688f, 126.72929f, 9.996809f, 105.53792f, 4.731375f);
                instancePath.cubicTo(89.469955f, 0.65491056f, 72.34541f, 4.0819387f, 57.922127f, 11.815232f);
                instancePath.lineTo(57.922127f, 11.815232f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(80.9461f, 13.323944f);
                instancePath2.cubicTo(92.338326f, 10.649595f, 104.673225f, 12.046642f, 115.12279f, 17.335466f);
                instancePath2.cubicTo(127.67831f, 23.572289f, 137.33563f, 35.23764f, 141.08624f, 48.689217f);
                instancePath2.cubicTo(144.47583f, 60.56412f, 143.34262f, 73.666435f, 137.84708f, 84.75301f);
                instancePath2.cubicTo(132.1309f, 96.48821f, 121.661285f, 105.838455f, 109.276245f, 110.149345f);
                instancePath2.cubicTo(96.80096f, 114.57999f, 82.56067f, 113.82159f, 70.65699f, 108.04379f);
                instancePath2.cubicTo(59.074226f, 102.53544f, 49.787952f, 92.426796f, 45.285217f, 80.462074f);
                instancePath2.cubicTo(40.240944f, 67.339806f, 41.033188f, 52.111984f, 47.4714f, 39.598423f);
                instancePath2.cubicTo(54.05001f, 26.526047f, 66.61556f, 16.607006f, 80.9461f, 13.323944f);
                instancePath2.lineTo(80.9461f, 13.323944f);
                instancePath2.close();
                instancePath2.moveTo(84.99124f, 15.594493f);
                instancePath2.cubicTo(74.17387f, 17.275282f, 64.04633f, 22.894487f, 56.858078f, 31.109468f);
                instancePath2.cubicTo(48.590088f, 40.398563f, 44.27114f, 53.0194f, 45.100937f, 65.40154f);
                instancePath2.cubicTo(45.83076f, 79.146225f, 52.999016f, 92.36379f, 64.106316f, 100.568825f);
                instancePath2.cubicTo(74.063896f, 108.08762f, 87.110725f, 111.35969f, 99.477715f, 109.47999f);
                instancePath2.cubicTo(111.90469f, 107.709694f, 123.43189f, 100.70806f, 130.7901f, 90.60344f);
                instancePath2.cubicTo(138.1983f, 80.628105f, 141.34753f, 67.69895f, 139.468f, 55.456047f);
                instancePath2.cubicTo(137.52847f, 41.77104f, 129.1605f, 29.180042f, 117.29339f, 21.989449f);
                instancePath2.cubicTo(107.7657f, 16.091768f, 96.06855f, 13.804303f, 84.99124f, 15.594493f);
                instancePath2.lineTo(84.99124f, 15.594493f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(66.0f, 38.39189f);
                instancePath3.cubicTo(71.673454f, 32.4223f, 79.1317f, 28.155405f, 87.26797f, 27.0f);
                instancePath3.cubicTo(88.19527f, 32.39189f, 89.102615f, 37.79392f, 90.0f, 43.18581f);
                instancePath3.cubicTo(86.05151f, 44.949326f, 82.5617f, 47.635136f, 79.79975f, 51.0f);
                instancePath3.cubicTo(75.203156f, 46.79392f, 70.596596f, 42.597973f, 66.0f, 38.39189f);
                instancePath3.lineTo(66.0f, 38.39189f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint3, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(57.91275f, 51.0f);
                instancePath4.cubicTo(63.61177f, 53.416126f, 69.31079f, 55.832253f, 75.0f, 58.26877f);
                instancePath4.cubicTo(74.6763f, 59.512512f, 74.35261f, 60.756256f, 74.02891f, 62.0f);
                instancePath4.cubicTo(68.01601f, 61.592216f, 62.003098f, 61.18443f, 56.0f, 60.78684f);
                instancePath4.cubicTo(56.31389f, 57.46339f, 56.94166f, 54.18072f, 57.91275f, 51.0f);
                instancePath4.lineTo(57.91275f, 51.0f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
