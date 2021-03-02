package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_full_share extends c {
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
                instancePaint4.setColor(-2565928);
                instancePaint5.setColor(-6842473);
                instancePaint5.setStrokeWidth(3.0f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(1.5f, 1.5f);
                instancePath.lineTo(70.5f, 1.5f);
                instancePath.lineTo(70.5f, 70.5f);
                instancePath.lineTo(1.5f, 70.5f);
                instancePath.lineTo(1.5f, 1.5f);
                instancePath.close();
                canvas.saveLayerAlpha(null, 0, 31);
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Paint instancePaint7 = c.instancePaint(instancePaint5, looper);
                canvas.drawPath(instancePath, instancePaint6);
                canvas.drawPath(instancePath, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint, looper);
                instancePaint8.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(42.15029f, 9.0f);
                instancePath2.cubicTo(42.92826f, 9.0f, 43.677906f, 9.274708f, 44.26954f, 9.770407f);
                instancePath2.lineTo(44.48374f, 9.966548f);
                instancePath2.lineTo(60.80176f, 26.284567f);
                instancePath2.cubicTo(62.598175f, 28.080978f, 62.673027f, 30.947031f, 61.026314f, 32.83258f);
                instancePath2.lineTo(60.80176f, 33.072792f);
                instancePath2.lineTo(44.48374f, 49.390812f);
                instancePath2.cubicTo(43.195015f, 50.679543f, 41.105568f, 50.679543f, 39.816837f, 49.390812f);
                instancePath2.cubicTo(39.26673f, 48.840706f, 38.9309f, 48.11638f, 38.863064f, 47.347515f);
                instancePath2.lineTo(38.850292f, 47.057358f);
                instancePath2.lineTo(38.848877f, 37.210567f);
                instancePath2.cubicTo(30.454565f, 37.514618f, 24.104624f, 41.666443f, 19.317652f, 48.58951f);
                instancePath2.cubicTo(17.633574f, 51.025078f, 16.300003f, 53.570847f, 15.158597f, 56.29031f);
                instancePath2.lineTo(14.739267f, 57.31837f);
                instancePath2.lineTo(14.520645f, 57.88214f);
                instancePath2.lineTo(13.831736f, 59.7137f);
                instancePath2.lineTo(13.592604f, 60.3211f);
                instancePath2.cubicTo(13.206709f, 61.162777f, 12.397072f, 61.68232f, 11.352628f, 61.469685f);
                instancePath2.cubicTo(10.308184f, 61.25705f, 10.086042f, 60.282413f, 10.003558f, 59.667286f);
                instancePath2.cubicTo(8.119613f, 38.40898f, 19.10014f, 22.050562f, 38.849327f, 20.036772f);
                instancePath2.lineTo(38.850292f, 12.3f);
                instancePath2.cubicTo(38.850292f, 10.47746f, 40.32775f, 9.0f, 42.15029f, 9.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint8);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
