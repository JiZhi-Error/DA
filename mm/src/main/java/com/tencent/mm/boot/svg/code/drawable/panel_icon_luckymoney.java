package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class panel_icon_luckymoney extends c {
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
                instancePaint3.setColor(-13421773);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(96.0f, 96.249916f);
                instancePath.cubicTo(92.54822f, 96.249916f, 89.75f, 93.4517f, 89.75f, 89.999916f);
                instancePath.cubicTo(89.75f, 86.54813f, 92.54822f, 83.749916f, 96.0f, 83.749916f);
                instancePath.cubicTo(99.45178f, 83.749916f, 102.25f, 86.54813f, 102.25f, 89.999916f);
                instancePath.cubicTo(102.25f, 93.4517f, 99.45178f, 96.249916f, 96.0f, 96.249916f);
                instancePath.moveTo(126.0f, 63.005955f);
                instancePath.cubicTo(126.0f, 61.345814f, 124.66269f, 60.0f, 123.00407f, 60.0f);
                instancePath.lineTo(68.99594f, 60.0f);
                instancePath.cubicTo(67.341324f, 60.0f, 66.0f, 61.347015f, 66.0f, 63.005955f);
                instancePath.lineTo(66.0f, 65.80777f);
                instancePath.cubicTo(66.0f, 76.38241f, 75.167145f, 85.296455f, 87.69257f, 88.081665f);
                instancePath.cubicTo(87.52628f, 88.75229f, 87.42857f, 89.44967f, 87.42857f, 90.17208f);
                instancePath.cubicTo(87.42857f, 90.45863f, 87.444f, 90.74173f, 87.47143f, 91.02137f);
                instancePath.cubicTo(79.20257f, 89.72672f, 71.797714f, 86.58592f, 66.0f, 82.178955f);
                instancePath.lineTo(66.0f, 132.00877f);
                instancePath.cubicTo(66.0f, 133.66078f, 67.33731f, 135.0f, 68.99594f, 135.0f);
                instancePath.lineTo(123.00407f, 135.0f);
                instancePath.cubicTo(124.658676f, 135.0f, 126.0f, 133.65459f, 126.0f, 132.00877f);
                instancePath.lineTo(126.0f, 82.178955f);
                instancePath.cubicTo(120.202286f, 86.58592f, 112.79743f, 89.72672f, 104.52857f, 91.02137f);
                instancePath.cubicTo(104.556f, 90.74173f, 104.57143f, 90.45863f, 104.57143f, 90.17208f);
                instancePath.cubicTo(104.57143f, 89.44967f, 104.47372f, 88.75229f, 104.30743f, 88.081665f);
                instancePath.cubicTo(116.832855f, 85.296455f, 126.0f, 76.38241f, 126.0f, 65.80777f);
                instancePath.lineTo(126.0f, 63.005955f);
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
