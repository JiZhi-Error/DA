package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class addfriend_icon_search extends c {
    private final int height = 138;
    private final int width = 138;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 138;
            case 1:
                return 138;
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-372399);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(73.897f, 30.479f);
                instancePath.cubicTo(74.751f, 28.69f, 74.819f, 26.755001f, 74.084f, 25.024f);
                instancePath.cubicTo(73.349f, 23.294f, 71.902f, 21.997f, 70.015f, 21.374f);
                instancePath.lineTo(68.426f, 20.848f);
                instancePath.cubicTo(67.69701f, 20.607f, 66.952f, 20.484f, 66.212006f, 20.484f);
                instancePath.cubicTo(63.095005f, 20.484f, 60.479004f, 22.682999f, 59.852005f, 25.833f);
                instancePath.lineTo(56.529007f, 42.544f);
                instancePath.cubicTo(55.72801f, 46.562f, 56.918007f, 50.312f, 59.237007f, 51.079998f);
                instancePath.cubicTo(59.53301f, 51.177998f, 59.85301f, 51.227997f, 60.184006f, 51.227997f);
                instancePath.cubicTo(62.403008f, 51.227997f, 65.01101f, 49.019997f, 66.524f, 45.857f);
                instancePath.lineTo(73.897f, 30.479f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-372399);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(47.594f, 58.56f);
                instancePath2.cubicTo(47.825f, 56.139f, 44.891003f, 53.479f, 40.913002f, 52.502003f);
                instancePath2.lineTo(28.674002f, 49.49f);
                instancePath2.cubicTo(28.108002f, 49.352f, 27.537003f, 49.281002f, 26.977001f, 49.281002f);
                instancePath2.cubicTo(23.645f, 49.281002f, 20.992f, 51.755f, 20.665f, 55.160004f);
                instancePath2.lineTo(20.5f, 56.885f);
                instancePath2.cubicTo(20.483f, 58.966f, 21.181f, 60.827f, 22.469f, 62.123997f);
                instancePath2.cubicTo(23.628f, 63.291996f, 25.164f, 63.911995f, 26.909f, 63.911995f);
                instancePath2.cubicTo(27.034f, 63.911995f, 27.163f, 63.907993f, 27.29f, 63.902996f);
                instancePath2.lineTo(39.885002f, 63.248997f);
                instancePath2.cubicTo(43.976f, 63.039f, 47.36f, 60.978f, 47.594f, 58.56f);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-372399);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(52.464f, 71.346f);
                instancePath3.cubicTo(50.162003f, 70.582f, 46.995003f, 72.976f, 45.374f, 76.679f);
                instancePath3.lineTo(33.727f, 103.298004f);
                instancePath3.cubicTo(32.935f, 105.107f, 32.925003f, 107.064f, 33.699f, 108.80801f);
                instancePath3.cubicTo(34.476f, 110.55401f, 35.939003f, 111.86101f, 37.822002f, 112.490005f);
                instancePath3.lineTo(39.410004f, 113.018005f);
                instancePath3.lineTo(39.569004f, 113.051f);
                instancePath3.cubicTo(39.827003f, 113.07201f, 40.099003f, 113.086006f, 40.385002f, 113.086006f);
                instancePath3.cubicTo(43.696003f, 113.086006f, 47.402f, 111.55301f, 48.216003f, 108.12201f);
                instancePath3.lineTo(54.923004f, 79.86101f);
                instancePath3.cubicTo(55.872f, 75.861f, 54.79f, 72.12f, 52.464f, 71.346f);
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-372399);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(75.157f, 75.74f);
                instancePath4.cubicTo(73.254f, 73.711f, 70.840996f, 72.45f, 68.858f, 72.45f);
                instancePath4.cubicTo(68.017f, 72.45f, 67.277f, 72.687996f, 66.722f, 73.135994f);
                instancePath4.cubicTo(64.809f, 74.685f, 65.159f, 78.536995f, 67.52f, 81.912994f);
                instancePath4.lineTo(90.321f, 114.520996f);
                instancePath4.cubicTo(91.653f, 116.423996f, 93.719f, 117.515f, 95.988f, 117.515f);
                instancePath4.cubicTo(97.584f, 117.515f, 99.101f, 116.97f, 100.381f, 115.939f);
                instancePath4.lineTo(101.682f, 114.887f);
                instancePath4.cubicTo(103.22f, 113.645004f, 104.139f, 111.901f, 104.274f, 109.984f);
                instancePath4.cubicTo(104.405f, 108.065f, 103.734f, 106.213f, 102.379005f, 104.772f);
                instancePath4.lineTo(75.157f, 75.74f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 1);
                canvas.drawPath(instancePath4, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                instancePaint7.setColor(-372399);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(117.396f, 55.183f);
                instancePath5.cubicTo(117.16701f, 51.164997f, 113.701004f, 48.226997f, 109.587006f, 48.821f);
                instancePath5.lineTo(75.83f, 53.738f);
                instancePath5.cubicTo(71.757f, 54.335f, 68.674f, 56.717f, 68.811005f, 59.159f);
                instancePath5.cubicTo(68.950005f, 61.612f, 72.288f, 63.583f, 76.414f, 63.645f);
                instancePath5.lineTo(109.757f, 64.078f);
                instancePath5.lineTo(109.873f, 64.081f);
                instancePath5.cubicTo(112.042f, 64.081f, 114.214005f, 63.15f, 115.685f, 61.594f);
                instancePath5.cubicTo(116.947f, 60.258003f, 117.587f, 58.575f, 117.49f, 56.855003f);
                instancePath5.lineTo(117.396f, 55.183f);
                instancePath5.close();
                instancePath5.moveTo(109.874f, 63.373f);
                instancePath5.lineTo(109.874f, 63.373f);
                instancePath5.lineTo(109.874f, 63.375f);
                instancePath5.lineTo(109.874f, 63.373f);
                instancePath5.close();
                WeChatSVGRenderC2Java.setFillType(instancePath5, 1);
                canvas.drawPath(instancePath5, instancePaint7);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
