package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_font extends c {
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
                instancePath.moveTo(34.450928f, 52.877197f);
                instancePath.lineTo(30.94629f, 42.89502f);
                instancePath.lineTo(17.072754f, 42.89502f);
                instancePath.lineTo(13.568115f, 52.877197f);
                instancePath.lineTo(9.0f, 52.877197f);
                instancePath.lineTo(21.858398f, 18.0f);
                instancePath.lineTo(26.160645f, 18.0f);
                instancePath.lineTo(39.019043f, 52.877197f);
                instancePath.lineTo(34.450928f, 52.877197f);
                instancePath.close();
                instancePath.moveTo(23.937012f, 23.293213f);
                instancePath.lineTo(18.35376f, 39.19702f);
                instancePath.lineTo(29.665283f, 39.19702f);
                instancePath.lineTo(24.082031f, 23.293213f);
                instancePath.lineTo(23.937012f, 23.293213f);
                instancePath.close();
                instancePath.moveTo(50.983154f, 49.46924f);
                instancePath.cubicTo(55.23706f, 49.46924f, 58.35498f, 46.713867f, 58.35498f, 42.96753f);
                instancePath.lineTo(58.35498f, 40.864746f);
                instancePath.lineTo(51.539062f, 41.299805f);
                instancePath.cubicTo(47.623535f, 41.541504f, 45.59326f, 42.96753f, 45.59326f, 45.4812f);
                instancePath.cubicTo(45.59326f, 47.898193f, 47.696045f, 49.46924f, 50.983154f, 49.46924f);
                instancePath.close();
                instancePath.moveTo(50.088867f, 53.118896f);
                instancePath.cubicTo(44.795654f, 53.118896f, 41.291016f, 50.073486f, 41.291016f, 45.45703f);
                instancePath.cubicTo(41.291016f, 40.985596f, 44.723145f, 38.351074f, 51.055664f, 37.964355f);
                instancePath.lineTo(58.35498f, 37.529297f);
                instancePath.lineTo(58.35498f, 35.354004f);
                instancePath.cubicTo(58.35498f, 32.115234f, 56.228027f, 30.32666f, 52.38501f, 30.32666f);
                instancePath.cubicTo(49.36377f, 30.32666f, 47.115967f, 31.873535f, 46.6084f, 34.338867f);
                instancePath.lineTo(42.57202f, 34.338867f);
                instancePath.cubicTo(42.69287f, 29.939941f, 46.970947f, 26.580322f, 52.43335f, 26.580322f);
                instancePath.cubicTo(58.59668f, 26.580322f, 62.560547f, 29.867432f, 62.560547f, 34.991455f);
                instancePath.lineTo(62.560547f, 52.877197f);
                instancePath.lineTo(58.57251f, 52.877197f);
                instancePath.lineTo(58.57251f, 48.35742f);
                instancePath.lineTo(58.47583f, 48.35742f);
                instancePath.cubicTo(57.001465f, 51.257812f, 53.738525f, 53.118896f, 50.088867f, 53.118896f);
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
