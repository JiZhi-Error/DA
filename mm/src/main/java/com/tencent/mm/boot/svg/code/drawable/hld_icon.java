package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class hld_icon extends c {
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
                instancePaint3.setColor(-16268960);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 192.0f);
                instancePath.lineTo(192.0f, 192.0f);
                instancePath.lineTo(192.0f, 0.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(95.84f, 43.2f);
                instancePath2.cubicTo(124.91184f, 43.2f, 148.48f, 64.844f, 148.48f, 91.54256f);
                instancePath2.cubicTo(148.48f, 118.24112f, 124.91184f, 139.884f, 95.84f, 139.884f);
                instancePath2.cubicTo(92.92464f, 139.884f, 90.07088f, 139.65776f, 87.28544f, 139.23776f);
                instancePath2.cubicTo(86.41856f, 139.10672f, 85.53488f, 139.25232f, 84.7688f, 139.68016f);
                instancePath2.lineTo(84.7688f, 139.68016f);
                instancePath2.lineTo(67.87024f, 149.10497f);
                instancePath2.cubicTo(65.39168f, 150.48705f, 62.22768f, 148.8104f, 62.29264f, 146.14703f);
                instancePath2.lineTo(62.29264f, 146.14703f);
                instancePath2.lineTo(62.64992f, 131.34848f);
                instancePath2.cubicTo(62.68352f, 129.97871f, 62.09664f, 128.66048f, 61.03264f, 127.79808f);
                instancePath2.cubicTo(50.10032f, 118.94f, 43.2f, 105.98384f, 43.2f, 91.54256f);
                instancePath2.cubicTo(43.2f, 64.844f, 66.76816f, 43.2f, 95.84f, 43.2f);
                instancePath2.close();
                instancePath2.moveTo(110.669136f, 69.80056f);
                instancePath2.lineTo(104.16081f, 69.80056f);
                instancePath2.lineTo(104.904495f, 71.12888f);
                instancePath2.cubicTo(107.66081f, 76.04792f, 110.44514f, 83.926f, 110.44514f, 90.4388f);
                instancePath2.cubicTo(110.44514f, 97.27976f, 107.645134f, 105.68872f, 104.87202f, 110.4588f);
                instancePath2.lineTo(104.095856f, 111.80056f);
                instancePath2.lineTo(110.63106f, 111.80056f);
                instancePath2.lineTo(110.86066f, 111.44216f);
                instancePath2.cubicTo(114.91842f, 105.0828f, 117.01842f, 98.0212f, 117.116974f, 90.45112f);
                instancePath2.cubicTo(117.23682f, 81.02856f, 113.622574f, 74.35448f, 110.898735f, 70.15224f);
                instancePath2.lineTo(110.669136f, 69.80056f);
                instancePath2.close();
                instancePath2.moveTo(87.44f, 99.20045f);
                instancePath2.lineTo(79.04f, 99.20045f);
                instancePath2.lineTo(79.04f, 107.60045f);
                instancePath2.lineTo(87.44f, 107.60045f);
                instancePath2.lineTo(87.44f, 99.20045f);
                instancePath2.close();
                instancePath2.moveTo(87.44f, 74.00045f);
                instancePath2.lineTo(79.04f, 74.00045f);
                instancePath2.lineTo(79.04f, 82.40045f);
                instancePath2.lineTo(87.44f, 82.40045f);
                instancePath2.lineTo(87.44f, 74.00045f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
