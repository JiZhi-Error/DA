package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class mall_order_detail_frame extends c {
    private final int height = JsApiGetBackgroundAudioState.CTRL_INDEX;
    private final int width = JsApiGetBackgroundAudioState.CTRL_INDEX;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return JsApiGetBackgroundAudioState.CTRL_INDEX;
            case 1:
                return JsApiGetBackgroundAudioState.CTRL_INDEX;
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
                canvas.saveLayerAlpha(null, 23, 31);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(69.69f, 0.0f);
                instancePath.lineTo(89.35f, 0.0f);
                instancePath.cubicTo(106.27f, 2.71f, 122.64f, 9.98f, 134.93f, 22.1f);
                instancePath.cubicTo(148.15f, 34.62f, 156.22f, 51.83f, 159.0f, 69.7f);
                instancePath.lineTo(159.0f, 89.29f);
                instancePath.cubicTo(156.38f, 106.0f, 149.23f, 122.14f, 137.43f, 134.4f);
                instancePath.cubicTo(124.86f, 147.9f, 107.45f, 156.17f, 89.34f, 159.0f);
                instancePath.lineTo(69.67f, 159.0f);
                instancePath.cubicTo(54.38f, 156.5f, 39.5f, 150.47f, 27.73f, 140.23f);
                instancePath.cubicTo(12.48f, 127.48f, 2.96f, 108.82f, 0.0f, 89.29f);
                instancePath.lineTo(0.0f, 69.66f);
                instancePath.cubicTo(2.74f, 52.26f, 10.43f, 35.46f, 23.1f, 23.05f);
                instancePath.cubicTo(35.51f, 10.39f, 52.3f, 2.75f, 69.69f, 0.0f);
                instancePath.lineTo(69.69f, 0.0f);
                instancePath.close();
                instancePath.moveTo(72.39f, 1.64f);
                instancePath.cubicTo(50.03f, 3.41f, 29.01f, 15.72f, 16.0f, 33.9f);
                instancePath.cubicTo(5.98f, 47.41f, 1.2f, 64.29f, 1.1f, 80.99f);
                instancePath.cubicTo(1.79f, 91.02f, 3.49f, 101.11f, 7.59f, 110.36f);
                instancePath.cubicTo(16.56f, 131.17f, 34.91f, 147.82f, 56.67f, 154.32f);
                instancePath.cubicTo(67.11f, 157.23f, 78.17f, 158.89f, 88.95f, 157.08f);
                instancePath.cubicTo(109.53f, 154.89f, 128.7f, 143.65f, 141.32f, 127.36f);
                instancePath.cubicTo(157.73f, 106.72f, 162.16f, 77.57f, 153.09f, 52.87f);
                instancePath.cubicTo(144.96f, 30.37f, 125.99f, 12.03f, 103.11f, 4.91f);
                instancePath.cubicTo(93.2f, 2.07f, 82.69f, 0.28f, 72.39f, 1.64f);
                instancePath.lineTo(72.39f, 1.64f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
