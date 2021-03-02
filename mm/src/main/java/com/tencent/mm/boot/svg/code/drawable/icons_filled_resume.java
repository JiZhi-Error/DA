package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_resume extends c {
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
                instancePaint3.setColor(-436207616);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(65.48456f, 29.084822f);
                instancePath.cubicTo(69.77281f, 45.088806f, 60.275337f, 61.538914f, 44.271355f, 65.82717f);
                instancePath.cubicTo(28.26737f, 70.115425f, 11.817262f, 60.617947f, 7.5290074f, 44.613964f);
                instancePath.cubicTo(7.119025f, 43.08389f, 6.831688f, 41.536167f, 6.6667647f, 39.98142f);
                instancePath.lineTo(6.5660214f, 38.814205f);
                instancePath.lineTo(12.55276f, 38.415512f);
                instancePath.cubicTo(12.656483f, 39.972984f, 12.913397f, 41.52656f, 13.324562f, 43.06105f);
                instancePath.cubicTo(16.755165f, 55.86424f, 29.915253f, 63.462215f, 42.71844f, 60.031612f);
                instancePath.cubicTo(55.521626f, 56.60101f, 63.119606f, 43.44092f, 59.689003f, 30.637737f);
                instancePath.cubicTo(56.2584f, 17.83455f, 43.098312f, 10.23657f, 30.295126f, 13.667174f);
                instancePath.cubicTo(25.014788f, 15.082036f, 20.494555f, 18.191107f, 17.312689f, 22.438446f);
                instancePath.lineTo(24.83942f, 23.362589f);
                instancePath.lineTo(24.108204f, 29.317867f);
                instancePath.lineTo(9.220013f, 27.489826f);
                instancePath.cubicTo(7.575508f, 27.287907f, 6.406062f, 25.791084f, 6.607982f, 24.14658f);
                instancePath.lineTo(8.436022f, 9.258388f);
                instancePath.lineTo(14.391299f, 9.989603f);
                instancePath.lineTo(13.449316f, 17.651854f);
                instancePath.cubicTo(17.356117f, 12.950658f, 22.648066f, 9.50454f, 28.74221f, 7.871619f);
                instancePath.cubicTo(44.746193f, 3.5833647f, 61.196304f, 13.080839f, 65.48456f, 29.084822f);
                instancePath.close();
                instancePath.moveTo(39.0f, 21.0f);
                instancePath.lineTo(39.0f, 36.0f);
                instancePath.lineTo(54.0f, 36.0f);
                instancePath.lineTo(54.0f, 42.0f);
                instancePath.lineTo(33.0f, 42.0f);
                instancePath.lineTo(33.0f, 21.0f);
                instancePath.lineTo(39.0f, 21.0f);
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
