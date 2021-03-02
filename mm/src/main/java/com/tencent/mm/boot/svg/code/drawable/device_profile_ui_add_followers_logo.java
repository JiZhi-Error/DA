package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class device_profile_ui_add_followers_logo extends c {
    private final int height = 60;
    private final int width = 60;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.saveLayerAlpha(null, 51, 31);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(29.73f, 4.822f);
                instancePath.cubicTo(15.804f, 4.822f, 4.514f, 16.111f, 4.514f, 30.038f);
                instancePath.cubicTo(4.514f, 43.965f, 15.804f, 55.253f, 29.73f, 55.253f);
                instancePath.cubicTo(43.656f, 55.253f, 54.946f, 43.963997f, 54.946f, 30.036999f);
                instancePath.cubicTo(54.946f, 16.11f, 43.656f, 4.822f, 29.73f, 4.822f);
                instancePath.close();
                instancePath.moveTo(29.73f, 53.27f);
                instancePath.cubicTo(16.898998f, 53.27f, 6.4969997f, 42.868f, 6.4969997f, 30.037f);
                instancePath.cubicTo(6.4969997f, 17.206001f, 16.899f, 6.805f, 29.73f, 6.805f);
                instancePath.cubicTo(42.561f, 6.805f, 52.962997f, 17.207f, 52.962997f, 30.038f);
                instancePath.cubicTo(52.962997f, 42.869f, 42.561f, 53.27f, 29.73f, 53.27f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(31.23f, 15.037f);
                instancePath2.lineTo(28.23f, 15.037f);
                instancePath2.lineTo(28.23f, 28.537f);
                instancePath2.lineTo(14.73f, 28.537f);
                instancePath2.lineTo(14.73f, 31.537f);
                instancePath2.lineTo(28.23f, 31.537f);
                instancePath2.lineTo(28.23f, 45.037f);
                instancePath2.lineTo(31.23f, 45.037f);
                instancePath2.lineTo(31.23f, 31.537f);
                instancePath2.lineTo(44.73f, 31.537f);
                instancePath2.lineTo(44.73f, 28.537f);
                instancePath2.lineTo(31.23f, 28.537f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
