package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class coupon extends c {
    private final int height = 32;
    private final int width = 32;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 32;
            case 1:
                return 32;
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
                instancePath.moveTo(28.666666f, 6.0f);
                instancePath.cubicTo(29.403046f, 6.0f, 30.0f, 6.596954f, 30.0f, 7.3333335f);
                instancePath.lineTo(30.001003f, 13.5f);
                instancePath.cubicTo(28.594185f, 13.5f, 27.454546f, 14.619288f, 27.454546f, 16.0f);
                instancePath.cubicTo(27.454546f, 17.325483f, 28.504837f, 18.410038f, 29.832636f, 18.494682f);
                instancePath.lineTo(30.0f, 18.5f);
                instancePath.lineTo(30.0f, 24.666666f);
                instancePath.cubicTo(30.0f, 25.403046f, 29.403046f, 26.0f, 28.666666f, 26.0f);
                instancePath.lineTo(3.3333333f, 26.0f);
                instancePath.cubicTo(2.5969536f, 26.0f, 2.0f, 25.403046f, 2.0f, 24.666666f);
                instancePath.lineTo(2.0f, 18.5f);
                instancePath.cubicTo(3.4058158f, 18.5f, 4.5454545f, 17.380713f, 4.5454545f, 16.0f);
                instancePath.cubicTo(4.5454545f, 14.619288f, 3.4058158f, 13.5f, 2.0f, 13.5f);
                instancePath.lineTo(2.0f, 7.3333335f);
                instancePath.cubicTo(2.0f, 6.596954f, 2.5969536f, 6.0f, 3.3333333f, 6.0f);
                instancePath.lineTo(28.666666f, 6.0f);
                instancePath.close();
                instancePath.moveTo(28.399f, 7.6f);
                instancePath.lineTo(3.599f, 7.6f);
                instancePath.lineTo(3.599f, 12.217f);
                instancePath.lineTo(3.7448542f, 12.280006f);
                instancePath.cubicTo(5.1014175f, 12.903452f, 6.062619f, 14.231622f, 6.140364f, 15.794811f);
                instancePath.lineTo(6.1454544f, 16.0f);
                instancePath.cubicTo(6.1454544f, 17.651552f, 5.1603985f, 19.069443f, 3.7448542f, 19.719994f);
                instancePath.lineTo(3.599f, 19.782f);
                instancePath.lineTo(3.599f, 24.4f);
                instancePath.lineTo(28.399f, 24.4f);
                instancePath.lineTo(28.399f, 19.782f);
                instancePath.lineTo(28.386677f, 19.77784f);
                instancePath.cubicTo(26.956083f, 19.17976f, 25.938618f, 17.811419f, 25.859509f, 16.202349f);
                instancePath.lineTo(25.854546f, 16.0f);
                instancePath.cubicTo(25.854546f, 14.348448f, 26.839602f, 12.930558f, 28.255262f, 12.280006f);
                instancePath.lineTo(28.401f, 12.217f);
                instancePath.lineTo(28.399f, 7.6f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(20.614584f, 12.333333f);
                instancePath2.cubicTo(20.911123f, 12.333333f, 21.151516f, 12.573726f, 21.151516f, 12.870265f);
                instancePath2.lineTo(21.151516f, 13.396401f);
                instancePath2.cubicTo(21.151516f, 13.692941f, 20.911123f, 13.933333f, 20.614584f, 13.933333f);
                instancePath2.lineTo(10.233901f, 13.933333f);
                instancePath2.cubicTo(9.937363f, 13.933333f, 9.69697f, 13.692941f, 9.69697f, 13.396401f);
                instancePath2.lineTo(9.69697f, 12.870265f);
                instancePath2.cubicTo(9.69697f, 12.573726f, 9.937363f, 12.333333f, 10.233901f, 12.333333f);
                instancePath2.lineTo(20.614584f, 12.333333f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(16.796402f, 17.333334f);
                instancePath3.cubicTo(17.092941f, 17.333334f, 17.333334f, 17.573727f, 17.333334f, 17.870266f);
                instancePath3.lineTo(17.333334f, 18.396402f);
                instancePath3.cubicTo(17.333334f, 18.692942f, 17.092941f, 18.933332f, 16.796402f, 18.933332f);
                instancePath3.lineTo(10.233901f, 18.933332f);
                instancePath3.cubicTo(9.937363f, 18.933332f, 9.69697f, 18.692942f, 9.69697f, 18.396402f);
                instancePath3.lineTo(9.69697f, 17.870266f);
                instancePath3.cubicTo(9.69697f, 17.573727f, 9.937363f, 17.333334f, 10.233901f, 17.333334f);
                instancePath3.lineTo(16.796402f, 17.333334f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
