package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_outlined_share extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-1);
                instancePaint5.setColor(855638016);
                instancePaint5.setStrokeWidth(1.5f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.75f, 0.75f);
                instancePath.lineTo(71.25f, 0.75f);
                instancePath.lineTo(71.25f, 71.25f);
                instancePath.lineTo(0.75f, 71.25f);
                instancePath.lineTo(0.75f, 0.75f);
                instancePath.close();
                canvas.saveLayerAlpha(null, 0, 31);
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Paint instancePaint7 = c.instancePaint(instancePaint5, looper);
                canvas.drawPath(instancePath, instancePaint6);
                canvas.drawPath(instancePath, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint, looper);
                instancePaint8.setColor(-436207616);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(24.0f, 27.0f);
                instancePath2.lineTo(24.0f, 30.6f);
                instancePath2.lineTo(15.6f, 30.6f);
                instancePath2.lineTo(15.6f, 56.4f);
                instancePath2.lineTo(56.4f, 56.4f);
                instancePath2.lineTo(56.4f, 30.6f);
                instancePath2.lineTo(48.0f, 30.6f);
                instancePath2.lineTo(48.0f, 27.0f);
                instancePath2.lineTo(57.00313f, 27.0f);
                instancePath2.cubicTo(58.65261f, 27.0f, 60.0f, 28.337517f, 60.0f, 29.987425f);
                instancePath2.lineTo(60.0f, 57.012573f);
                instancePath2.cubicTo(60.0f, 58.65324f, 58.662483f, 60.0f, 57.012573f, 60.0f);
                instancePath2.lineTo(14.987426f, 60.0f);
                instancePath2.cubicTo(13.346761f, 60.0f, 12.0f, 58.662483f, 12.0f, 57.012573f);
                instancePath2.lineTo(12.0f, 29.987425f);
                instancePath2.cubicTo(12.0f, 28.34676f, 13.341744f, 27.0f, 14.99687f, 27.0f);
                instancePath2.lineTo(24.0f, 27.0f);
                instancePath2.close();
                instancePath2.moveTo(38.12132f, 11.014719f);
                instancePath2.lineTo(46.6066f, 19.5f);
                instancePath2.lineTo(44.061016f, 22.045584f);
                instancePath2.lineTo(37.79998f, 15.784549f);
                instancePath2.lineTo(37.79998f, 43.5f);
                instancePath2.lineTo(34.19998f, 43.5f);
                instancePath2.lineTo(34.19998f, 15.784586f);
                instancePath2.lineTo(27.938982f, 22.045584f);
                instancePath2.lineTo(25.393398f, 19.5f);
                instancePath2.lineTo(33.87868f, 11.014719f);
                instancePath2.cubicTo(35.05025f, 9.843145f, 36.94975f, 9.843145f, 38.12132f, 11.014719f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint8);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
