package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_icon_jd_member extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                instancePaint3.setColor(-8617851);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(65.0f, 53.0f);
                instancePath.cubicTo(65.0f, 55.20933f, 62.761665f, 57.0f, 60.0f, 57.0f);
                instancePath.lineTo(55.0f, 57.0f);
                instancePath.lineTo(55.0f, 41.0f);
                instancePath.lineTo(60.0f, 41.0f);
                instancePath.cubicTo(62.761665f, 41.0f, 65.0f, 42.79111f, 65.0f, 45.0f);
                instancePath.lineTo(65.0f, 53.0f);
                instancePath.close();
                instancePath.moveTo(60.0f, 33.0f);
                instancePath.lineTo(48.0f, 33.0f);
                instancePath.lineTo(48.0f, 65.0f);
                instancePath.lineTo(60.0f, 65.0f);
                instancePath.cubicTo(66.627556f, 65.0f, 72.0f, 59.627556f, 72.0f, 53.0f);
                instancePath.lineTo(72.0f, 45.0f);
                instancePath.cubicTo(72.0f, 38.37289f, 66.627556f, 33.0f, 60.0f, 33.0f);
                instancePath.lineTo(60.0f, 33.0f);
                instancePath.close();
                instancePath.moveTo(48.5f, 78.0f);
                instancePath.cubicTo(32.759857f, 78.0f, 20.0f, 65.24014f, 20.0f, 49.5f);
                instancePath.cubicTo(20.0f, 42.182285f, 22.76043f, 35.511475f, 27.293285f, 30.464714f);
                instancePath.lineTo(29.464714f, 28.293737f);
                instancePath.cubicTo(34.511475f, 23.76043f, 41.182285f, 21.0f, 48.5f, 21.0f);
                instancePath.cubicTo(55.817715f, 21.0f, 62.488525f, 23.76043f, 67.535286f, 28.293737f);
                instancePath.lineTo(69.70671f, 30.464714f);
                instancePath.cubicTo(74.23957f, 35.511475f, 77.0f, 42.182285f, 77.0f, 49.5f);
                instancePath.cubicTo(77.0f, 65.24014f, 64.24014f, 78.0f, 48.5f, 78.0f);
                instancePath.lineTo(48.5f, 78.0f);
                instancePath.close();
                instancePath.moveTo(89.0f, 28.320707f);
                instancePath.lineTo(84.54362f, 23.862083f);
                instancePath.lineTo(78.94612f, 29.462835f);
                instancePath.cubicTo(78.10526f, 28.189201f, 77.189674f, 26.969608f, 76.20072f, 25.813969f);
                instancePath.lineTo(81.34762f, 20.664484f);
                instancePath.lineTo(76.891235f, 16.205858f);
                instancePath.lineTo(71.71237f, 21.387772f);
                instancePath.cubicTo(70.703606f, 20.554144f, 69.645325f, 19.779964f, 68.54969f, 19.056675f);
                instancePath.lineTo(74.14538f, 13.458625f);
                instancePath.lineTo(69.688995f, 9.0f);
                instancePath.lineTo(62.753685f, 15.939241f);
                instancePath.cubicTo(58.37472f, 14.0760765f, 53.558674f, 13.040685f, 48.5f, 13.040685f);
                instancePath.cubicTo(43.441326f, 13.040685f, 38.62528f, 14.0760765f, 34.246315f, 15.939241f);
                instancePath.lineTo(27.311008f, 9.0f);
                instancePath.lineTo(22.854622f, 13.458625f);
                instancePath.lineTo(28.450312f, 19.056675f);
                instancePath.cubicTo(27.354671f, 19.779964f, 26.296392f, 20.554144f, 25.287628f, 21.387772f);
                instancePath.lineTo(20.108767f, 16.205858f);
                instancePath.lineTo(15.652381f, 20.664484f);
                instancePath.lineTo(20.799282f, 25.813969f);
                instancePath.cubicTo(19.810324f, 26.969608f, 18.89474f, 28.189201f, 18.053879f, 29.462835f);
                instancePath.lineTo(12.456387f, 23.862083f);
                instancePath.lineTo(8.0f, 28.320707f);
                instancePath.lineTo(14.937108f, 35.2613f);
                instancePath.cubicTo(13.073078f, 39.64066f, 12.038656f, 44.45868f, 12.038656f, 49.520344f);
                instancePath.cubicTo(12.038656f, 69.66747f, 28.362986f, 86.0f, 48.5f, 86.0f);
                instancePath.cubicTo(68.63702f, 86.0f, 84.96134f, 69.66747f, 84.96134f, 49.520344f);
                instancePath.cubicTo(84.96134f, 44.45868f, 83.92692f, 39.64066f, 82.06289f, 35.2613f);
                instancePath.lineTo(89.0f, 28.320707f);
                instancePath.close();
                instancePath.moveTo(36.0f, 53.0f);
                instancePath.cubicTo(36.0f, 55.20933f, 34.20933f, 57.0f, 32.0f, 57.0f);
                instancePath.lineTo(28.0f, 57.0f);
                instancePath.lineTo(28.0f, 65.0f);
                instancePath.lineTo(32.0f, 65.0f);
                instancePath.cubicTo(38.627556f, 65.0f, 44.0f, 59.627556f, 44.0f, 53.0f);
                instancePath.lineTo(44.0f, 33.0f);
                instancePath.lineTo(36.0f, 33.0f);
                instancePath.lineTo(36.0f, 53.0f);
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
