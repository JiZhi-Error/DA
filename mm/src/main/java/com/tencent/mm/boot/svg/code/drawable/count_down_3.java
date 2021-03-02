package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class count_down_3 extends c {
    private final int height = 80;
    private final int width = 80;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 80;
            case 1:
                return 80;
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
                instancePaint3.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(40.008f, 13.0f);
                instancePath.cubicTo(45.192f, 13.0f, 49.296f, 14.224f, 52.464f, 16.744f);
                instancePath.cubicTo(55.488f, 19.264f, 57.072f, 22.72f, 57.072f, 27.112f);
                instancePath.cubicTo(57.072f, 32.728f, 54.192f, 36.544f, 48.576f, 38.416f);
                instancePath.cubicTo(51.6f, 39.352f, 53.904f, 40.792f, 55.488f, 42.664f);
                instancePath.cubicTo(57.216f, 44.608f, 58.08f, 47.128f, 58.08f, 50.152f);
                instancePath.cubicTo(58.08f, 54.904f, 56.424f, 58.792f, 53.184f, 61.816f);
                instancePath.cubicTo(49.728f, 64.84f, 45.192f, 66.424f, 39.72f, 66.424f);
                instancePath.cubicTo(34.464f, 66.424f, 30.216f, 65.056f, 27.048f, 62.392f);
                instancePath.cubicTo(23.448f, 59.368f, 21.432f, 54.976f, 21.0f, 49.216f);
                instancePath.lineTo(28.92f, 49.216f);
                instancePath.cubicTo(29.064f, 52.672f, 30.144f, 55.336f, 32.304f, 57.208f);
                instancePath.cubicTo(34.176f, 58.936f, 36.624f, 59.8f, 39.648f, 59.8f);
                instancePath.cubicTo(42.96f, 59.8f, 45.624f, 58.792f, 47.64f, 56.92f);
                instancePath.cubicTo(49.368f, 55.192f, 50.304f, 53.104f, 50.304f, 50.512f);
                instancePath.cubicTo(50.304f, 47.488f, 49.368f, 45.256f, 47.496f, 43.816f);
                instancePath.cubicTo(45.768f, 42.376f, 43.176f, 41.656f, 39.792f, 41.656f);
                instancePath.lineTo(36.048f, 41.656f);
                instancePath.lineTo(36.048f, 35.752f);
                instancePath.lineTo(39.72f, 35.752f);
                instancePath.cubicTo(42.888f, 35.752f, 45.264f, 35.032f, 46.848f, 33.664f);
                instancePath.cubicTo(48.432f, 32.296f, 49.296f, 30.28f, 49.296f, 27.688f);
                instancePath.cubicTo(49.296f, 25.096f, 48.504f, 23.152f, 47.064f, 21.784f);
                instancePath.cubicTo(45.48f, 20.344f, 43.104f, 19.696f, 40.08f, 19.696f);
                instancePath.cubicTo(36.984f, 19.696f, 34.536f, 20.488f, 32.808f, 22.072f);
                instancePath.cubicTo(31.08f, 23.656f, 30.0f, 26.032f, 29.712f, 29.2f);
                instancePath.lineTo(22.008f, 29.2f);
                instancePath.cubicTo(22.44f, 24.088f, 24.312f, 20.128f, 27.696f, 17.248f);
                instancePath.cubicTo(30.864f, 14.368f, 34.968f, 13.0f, 40.008f, 13.0f);
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
