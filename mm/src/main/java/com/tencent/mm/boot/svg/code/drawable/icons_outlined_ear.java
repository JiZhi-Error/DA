package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_ear extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(42.756084f, 23.753653f);
                instancePath.cubicTo(42.756084f, 23.753653f, 32.904655f, 22.533808f, 33.2793f, 30.323002f);
                instancePath.cubicTo(33.655968f, 38.094997f, 41.06112f, 36.807858f, 46.942364f, 42.972137f);
                instancePath.cubicTo(50.873383f, 47.09234f, 50.694675f, 55.362328f, 49.30796f, 58.95535f);
                instancePath.cubicTo(46.944668f, 65.07873f, 40.665535f, 65.99771f, 38.941086f, 66.0f);
                instancePath.cubicTo(33.958065f, 66.00661f, 30.134794f, 64.82345f, 28.11141f, 60.38087f);
                instancePath.cubicTo(26.088026f, 55.938293f, 27.59972f, 49.031265f, 23.877104f, 45.04466f);
                instancePath.cubicTo(20.056442f, 40.953053f, 12.17825f, 32.561337f, 16.036615f, 19.769604f);
                instancePath.cubicTo(17.667137f, 14.363896f, 23.538895f, 6.0f, 38.941086f, 6.0f);
                instancePath.cubicTo(52.097633f, 6.0f, 60.592396f, 14.844056f, 58.082718f, 24.757557f);
                instancePath.cubicTo(55.219227f, 36.064884f, 43.393326f, 34.106762f, 43.393326f, 34.106762f);
                instancePath.lineTo(43.981403f, 30.555119f);
                instancePath.cubicTo(43.99767f, 30.557812f, 44.098087f, 30.57103f, 44.27062f, 30.587133f);
                instancePath.cubicTo(45.954597f, 30.74432f, 47.931103f, 30.576462f, 49.707092f, 29.864014f);
                instancePath.cubicTo(52.115486f, 28.897875f, 53.78163f, 27.077248f, 54.59281f, 23.874062f);
                instancePath.cubicTo(56.5027f, 16.3298f, 49.76442f, 9.6f, 38.941086f, 9.6f);
                instancePath.cubicTo(27.652885f, 9.6f, 21.417698f, 14.395851f, 19.48324f, 20.809208f);
                instancePath.cubicTo(17.412807f, 27.673365f, 19.006674f, 33.338905f, 23.24795f, 38.84005f);
                instancePath.cubicTo(24.181522f, 40.050934f, 24.950243f, 40.91912f, 26.508316f, 42.587685f);
                instancePath.cubicTo(28.916208f, 45.166332f, 29.745024f, 47.971817f, 30.291613f, 52.847862f);
                instancePath.cubicTo(30.320282f, 53.10362f, 30.343494f, 53.317245f, 30.392647f, 53.773994f);
                instancePath.cubicTo(30.705244f, 56.67587f, 30.9238f, 57.87037f, 31.38761f, 58.888718f);
                instancePath.cubicTo(32.560234f, 61.463356f, 34.5903f, 62.40577f, 38.93631f, 62.4f);
                instancePath.cubicTo(39.736103f, 62.39894f, 41.10713f, 62.111256f, 42.33132f, 61.52559f);
                instancePath.cubicTo(44.006718f, 60.72406f, 45.24353f, 59.48811f, 45.949417f, 57.659134f);
                instancePath.cubicTo(47.251934f, 54.284264f, 46.6771f, 47.90922f, 44.337685f, 45.457222f);
                instancePath.cubicTo(43.559967f, 44.64208f, 42.7071f, 43.945812f, 41.728207f, 43.304165f);
                instancePath.cubicTo(41.08307f, 42.88129f, 40.39223f, 42.486404f, 39.544956f, 42.04684f);
                instancePath.cubicTo(39.060635f, 41.795578f, 37.39228f, 40.966763f, 37.204113f, 40.871178f);
                instancePath.cubicTo(32.272728f, 38.36617f, 29.937366f, 35.735035f, 29.683456f, 30.495955f);
                instancePath.cubicTo(29.426466f, 25.152885f, 32.484676f, 21.806908f, 37.10066f, 20.598345f);
                instancePath.cubicTo(38.996887f, 20.101871f, 40.901432f, 20.00654f, 42.62291f, 20.127865f);
                instancePath.cubicTo(42.87304f, 20.145493f, 43.067455f, 20.164715f, 43.19847f, 20.180939f);
                instancePath.lineTo(42.756084f, 23.753653f);
                instancePath.close();
                instancePath.moveTo(33.2793f, 30.323002f);
                instancePath.cubicTo(33.655968f, 38.094997f, 41.06112f, 36.807858f, 46.942364f, 42.972137f);
                instancePath.cubicTo(50.873383f, 47.09234f, 50.694675f, 55.362328f, 49.30796f, 58.95535f);
                instancePath.cubicTo(46.944668f, 65.07873f, 40.665535f, 65.99771f, 38.941086f, 66.0f);
                instancePath.cubicTo(33.958065f, 66.00661f, 30.134794f, 64.82345f, 28.11141f, 60.38087f);
                instancePath.cubicTo(26.088026f, 55.938293f, 27.59972f, 49.031265f, 23.877104f, 45.04466f);
                instancePath.cubicTo(20.056442f, 40.953053f, 12.17825f, 32.561337f, 16.036615f, 19.769604f);
                instancePath.cubicTo(17.667137f, 14.363896f, 23.538895f, 6.0f, 38.941086f, 6.0f);
                instancePath.cubicTo(52.097633f, 6.0f, 60.592396f, 14.844056f, 58.082718f, 24.757557f);
                instancePath.cubicTo(55.219227f, 36.064884f, 43.393326f, 34.106762f, 43.393326f, 34.106762f);
                instancePath.lineTo(43.981403f, 30.555119f);
                instancePath.cubicTo(43.99767f, 30.557812f, 44.098087f, 30.57103f, 44.27062f, 30.587133f);
                instancePath.cubicTo(45.954597f, 30.74432f, 47.931103f, 30.576462f, 49.707092f, 29.864014f);
                instancePath.cubicTo(52.115486f, 28.897875f, 53.78163f, 27.077248f, 54.59281f, 23.874062f);
                instancePath.cubicTo(56.5027f, 16.3298f, 49.76442f, 9.6f, 38.941086f, 9.6f);
                instancePath.cubicTo(27.652885f, 9.6f, 21.417698f, 14.395851f, 19.48324f, 20.809208f);
                instancePath.cubicTo(17.412807f, 27.673365f, 19.006674f, 33.338905f, 23.24795f, 38.84005f);
                instancePath.cubicTo(24.181522f, 40.050934f, 24.950243f, 40.91912f, 26.508316f, 42.587685f);
                instancePath.cubicTo(28.916208f, 45.166332f, 29.745024f, 47.971817f, 30.291613f, 52.847862f);
                instancePath.cubicTo(30.320282f, 53.10362f, 30.343494f, 53.317245f, 30.392647f, 53.773994f);
                instancePath.cubicTo(30.705244f, 56.67587f, 30.9238f, 57.87037f, 31.38761f, 58.888718f);
                instancePath.cubicTo(32.560234f, 61.463356f, 34.5903f, 62.40577f, 38.93631f, 62.4f);
                instancePath.cubicTo(39.736103f, 62.39894f, 41.10713f, 62.111256f, 42.33132f, 61.52559f);
                instancePath.cubicTo(44.006718f, 60.72406f, 45.24353f, 59.48811f, 45.949417f, 57.659134f);
                instancePath.cubicTo(47.251934f, 54.284264f, 46.6771f, 47.90922f, 44.337685f, 45.457222f);
                instancePath.cubicTo(43.559967f, 44.64208f, 42.7071f, 43.945812f, 41.728207f, 43.304165f);
                instancePath.cubicTo(41.08307f, 42.88129f, 40.39223f, 42.486404f, 39.544956f, 42.04684f);
                instancePath.cubicTo(39.060635f, 41.795578f, 37.39228f, 40.966763f, 37.204113f, 40.871178f);
                instancePath.cubicTo(32.272728f, 38.36617f, 29.937366f, 35.735035f, 29.683456f, 30.495955f);
                instancePath.cubicTo(29.426466f, 25.152885f, 32.484676f, 21.806908f, 37.10066f, 20.598345f);
                instancePath.cubicTo(38.996887f, 20.101871f, 40.901432f, 20.00654f, 42.62291f, 20.127865f);
                instancePath.cubicTo(42.87304f, 20.145493f, 43.067455f, 20.164715f, 43.19847f, 20.180939f);
                instancePath.lineTo(42.756084f, 23.753653f);
                instancePath.cubicTo(42.756084f, 23.753653f, 32.904655f, 22.533808f, 33.2793f, 30.323002f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
