package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icon_filled_live_top_member extends c {
    private final int height = 16;
    private final int width = 16;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 16;
            case 1:
                return 16;
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
                instancePaint3.setColor(-1);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(13.533333f, 13.2f);
                instancePath.lineTo(13.533333f, 12.876976f);
                instancePath.cubicTo(13.533333f, 12.72404f, 13.376452f, 12.473347f, 13.239873f, 12.406725f);
                instancePath.lineTo(9.466304f, 10.566027f);
                instancePath.cubicTo(8.448583f, 10.069595f, 8.197048f, 8.868608f, 8.926225f, 8.004246f);
                instancePath.lineTo(9.167246f, 7.718539f);
                instancePath.cubicTo(9.534797f, 7.282846f, 9.866667f, 6.3762608f, 9.866667f, 5.8067904f);
                instancePath.lineTo(9.866667f, 4.666805f);
                instancePath.cubicTo(9.866667f, 3.6366096f, 9.030394f, 2.8f, 8.0f, 2.8f);
                instancePath.cubicTo(6.9708724f, 2.8f, 6.133333f, 3.6368017f, 6.133333f, 4.666387f);
                instancePath.lineTo(6.133333f, 5.806194f);
                instancePath.cubicTo(6.133333f, 6.377109f, 6.463831f, 7.2803226f, 6.832719f, 7.717541f);
                instancePath.lineTo(7.0737405f, 8.003208f);
                instancePath.cubicTo(7.8044243f, 8.86924f, 7.550143f, 10.0691f, 6.533813f, 10.565058f);
                instancePath.lineTo(2.7602441f, 12.406518f);
                instancePath.cubicTo(2.6246781f, 12.472672f, 2.4666667f, 12.725784f, 2.4666667f, 12.876976f);
                instancePath.lineTo(2.4666667f, 13.2f);
                instancePath.lineTo(13.533333f, 13.2f);
                instancePath.close();
                instancePath.moveTo(1.6666666f, 13.333333f);
                instancePath.lineTo(1.6666666f, 12.876976f);
                instancePath.cubicTo(1.6666666f, 12.42025f, 1.9987673f, 11.8879385f, 2.4093983f, 11.687555f);
                instancePath.lineTo(6.182967f, 9.846095f);
                instancePath.cubicTo(6.7302513f, 9.579026f, 6.8575063f, 8.987509f, 6.462297f, 8.519093f);
                instancePath.lineTo(6.2212753f, 8.233425f);
                instancePath.cubicTo(5.7308784f, 7.65219f, 5.3333335f, 6.566331f, 5.3333335f, 5.806194f);
                instancePath.lineTo(5.3333335f, 4.666387f);
                instancePath.cubicTo(5.3333335f, 3.193782f, 6.5302377f, 2.0f, 8.0f, 2.0f);
                instancePath.cubicTo(9.472759f, 2.0f, 10.666667f, 3.1953201f, 10.666667f, 4.666805f);
                instancePath.lineTo(10.666667f, 5.8067904f);
                instancePath.cubicTo(10.666667f, 6.5661974f, 10.267288f, 7.65524f, 9.778725f, 8.234382f);
                instancePath.lineTo(9.5377035f, 8.520088f);
                instancePath.cubicTo(9.144689f, 8.985967f, 9.267459f, 9.578932f, 9.817033f, 9.847007f);
                instancePath.lineTo(13.590602f, 11.687705f);
                instancePath.cubicTo(14.000801f, 11.887795f, 14.333333f, 12.41678f, 14.333333f, 12.876976f);
                instancePath.lineTo(14.333333f, 13.333333f);
                instancePath.cubicTo(14.333333f, 13.701523f, 14.034857f, 14.0f, 13.666667f, 14.0f);
                instancePath.lineTo(2.3333333f, 14.0f);
                instancePath.cubicTo(1.9651434f, 14.0f, 1.6666666f, 13.701523f, 1.6666666f, 13.333333f);
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
