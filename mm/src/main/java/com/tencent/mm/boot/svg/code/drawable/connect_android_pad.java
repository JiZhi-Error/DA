package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.WebView;

public class connect_android_pad extends c {
    private final int height = TbsListener.ErrorCode.ERROR_CANLOADX5_RETURN_NULL;
    private final int width = 408;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 408;
            case 1:
                return TbsListener.ErrorCode.ERROR_CANLOADX5_RETURN_NULL;
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
                instancePath.moveTo(375.0f, 28.0f);
                instancePath.cubicTo(381.6274f, 28.0f, 387.0f, 33.37258f, 387.0f, 40.0f);
                instancePath.lineTo(387.0f, 268.0f);
                instancePath.cubicTo(387.0f, 274.6274f, 381.6274f, 280.0f, 375.0f, 280.0f);
                instancePath.lineTo(33.0f, 280.0f);
                instancePath.cubicTo(26.372583f, 280.0f, 21.0f, 274.6274f, 21.0f, 268.0f);
                instancePath.lineTo(21.0f, 40.0f);
                instancePath.cubicTo(21.0f, 33.37258f, 26.372583f, 28.0f, 33.0f, 28.0f);
                instancePath.lineTo(375.0f, 28.0f);
                instancePath.close();
                instancePath.moveTo(375.0f, 31.0f);
                instancePath.lineTo(33.0f, 31.0f);
                instancePath.cubicTo(28.206957f, 31.0f, 24.289017f, 34.74676f, 24.015278f, 39.47118f);
                instancePath.lineTo(24.0f, 40.0f);
                instancePath.lineTo(24.0f, 268.0f);
                instancePath.cubicTo(24.0f, 272.79303f, 27.74676f, 276.71097f, 32.47118f, 276.9847f);
                instancePath.lineTo(33.0f, 277.0f);
                instancePath.lineTo(375.0f, 277.0f);
                instancePath.cubicTo(379.79303f, 277.0f, 383.71097f, 273.25323f, 383.9847f, 268.5288f);
                instancePath.lineTo(384.0f, 268.0f);
                instancePath.lineTo(384.0f, 40.0f);
                instancePath.cubicTo(384.0f, 35.20696f, 380.25323f, 31.289017f, 375.5288f, 31.015278f);
                instancePath.lineTo(375.0f, 31.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(204.0f, 37.0f);
                instancePath2.cubicTo(205.65686f, 37.0f, 207.0f, 38.343147f, 207.0f, 40.0f);
                instancePath2.cubicTo(207.0f, 41.656853f, 205.65686f, 43.0f, 204.0f, 43.0f);
                instancePath2.cubicTo(202.34314f, 43.0f, 201.0f, 41.656853f, 201.0f, 40.0f);
                instancePath2.cubicTo(201.0f, 38.343147f, 202.34314f, 37.0f, 204.0f, 37.0f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
